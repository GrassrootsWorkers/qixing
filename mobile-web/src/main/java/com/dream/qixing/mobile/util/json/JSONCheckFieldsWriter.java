package com.dream.qixing.mobile.util.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

import com.dream.qixing.mobile.constants.Constants;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;


/**
 * 
 * <pre>
 * 支持fields：例如 最多两级 order_id, consignee.email, order_detail.item_name
 * </pre>
 * 
 * @author Arron
 *
 */

public class JSONCheckFieldsWriter {

    private StringBuffer buf = new StringBuffer();
    private Stack<Object> calls = new Stack<Object>();
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Map<String, Set<String>> includeFields;
    private Set<String> beanInclude;
    
    public JSONCheckFieldsWriter() {
    }

    public JSONCheckFieldsWriter(DateFormat format, String includeFields) {
    	this(includeFields);
        this.format = format;
    }
    
    public JSONCheckFieldsWriter(String includeFields) {
    	if (StringUtils.isEmpty(includeFields)) {
    		return;
    	}
    	
    	beanInclude = new HashSet<String>();
    	
    	for (String field : includeFields.replaceAll("( )?", "").split(",")) {
    		if (field.contains(".")) {
    			String classField[] = field.split("\\.");
    			putInlucdeString(classField[0], classField[1]);
    			putInlucdeString("", classField[0]);
    		} else {
    			putInlucdeString("", field);
    		}
    	}
    }
    
    private void putInlucdeString(String key, String value) {
    	beanInclude.add(key);
    	if (includeFields == null) {
    		includeFields = new HashMap<String, Set<String>>();
    	}
    	
    	Set<String> fields = includeFields.get(key);
    	if (fields == null) {
    		fields = new HashSet<String>();
    	}
    	
    	fields.add(value);
    	
    	includeFields.put(key, fields);
    }
    
    public String write(Object object) {
        buf.setLength(0);
        value(object);
        return buf.toString();
    }

    public String write(long n) {
        return String.valueOf(n);
    }

    public String write(double d) {
        return String.valueOf(d);
    }

    public String write(char c) {
        return "\"" + c + "\"";
    }
    
    public String write(boolean b) {
        return String.valueOf(b);
    }

    private void value(Object object) {
    	value("", object);
    }
    
    private void value(String classPre, Object object) {
        if (object == null || cyclic(object)) {
            add(null);
        } else {
            calls.push(object);
            if (object instanceof Class<?>) string(object);
            else if (object instanceof Boolean) bool(((Boolean) object).booleanValue());
            else if (object instanceof Number) add(object);
            else if (object instanceof String) string(object);
            else if (object instanceof Character) string(object);
            else if (object instanceof Map<?, ?>) map(classPre, (Map<?, ?>)object);
            else if (object.getClass().isArray()) array(classPre, object);
            else if (object instanceof Iterator<?>) array(classPre, (Iterator<?>)object);
            else if (object instanceof Collection<?>) array(classPre, ((Collection<?>)object).iterator());
            else if (object instanceof Date) date((Date)object);
            else bean(classPre, object);
            calls.pop();
        }
    }
    
    
    private boolean cyclic(Object object) {
        Iterator<Object> it = calls.iterator();
        while (it.hasNext()) {
            Object called = it.next();
            if (object == called) return true;
        }
        return false;
    }
    
    private void bean(String classPre, Object object) {
    	if (!isIncludeBean(classPre)) {
    		return;
    	}
    	
        add("{");
        boolean addedSomething = false;
        try {
            Field[] ff = object.getClass().getDeclaredFields();
            for (int i = 0; i < ff.length; ++i) {
                Field field = ff[i];
                
                if (field.getAnnotation(ApiField.class) == null) {
                	continue;
                }
                
                String fieldName = field.getAnnotation(ApiField.class).value();
                
                if (!isInclude(classPre, fieldName)) {
                	continue;
                }
                
                field.setAccessible(true);
                Object value = field.get(object);
                if (value == null) continue;
                if (addedSomething) add(',');
                
                if (field.getAnnotation(ApiListField.class) == null) {
                	add(field.getAnnotation(ApiField.class).value(), value);
                } else {
                	add(field.getAnnotation(ApiListField.class).value(), 
                			field.getAnnotation(ApiField.class).value(), value);
                }
                
                addedSomething = true;
            }
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }
        
        add("}");
    }
    
    private boolean isIncludeBean(String classPre) {
    	if (beanInclude == null || beanInclude.isEmpty()) {
    		return true;
    	}
    	
    	return beanInclude.contains(classPre);
    }
    
    private boolean isInclude(String classPre, String fieldName) {
    	if (includeFields == null || includeFields.isEmpty()) {
    		return true;
    	}
    	
    	return includeFields.get(classPre) == null 
    			|| includeFields.get(classPre).contains(fieldName);
    }
    
    
    private void add(String name, Object value) {
        add('"');
        add(name);
        add("\":");
        value(name, value);
    }
    
    private void add(String outer, String name, Object value) {
        add('"');
        add(outer);
        add("\":{");
        add('"');
        add(name);
        add("\":");
        value(name, value);
        add("}");
    }
    
    private void map(String classPre, Map<?, ?> map) {
        add("{");
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next();
            value(e.getKey());
            add(":");
            value(classPre, e.getValue());
            if (it.hasNext()) add(',');
        }
        add("}");
    }
    
    private void array(String classPre, Iterator<?> it) {
        add("[");
        while (it.hasNext()) {
            value(classPre, it.next());
            if (it.hasNext()) add(",");
        }
        add("]");
    }

    private void array(String classPre, Object object) {
        add("[");
        int length = Array.getLength(object);
        for (int i = 0; i < length; ++i) {
            value(classPre, Array.get(object, i));
            if (i < length - 1) add(',');
        }
        add("]");
    }

    private void bool(boolean b) {
        add(b ? "true" : "false");
	}

    private void date(Date date) {
        if (this.format == null) {
            this.format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            this.format.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
        }
        add("\"");
        add(format.format(date));
        add("\"");
    }

	private void string(Object obj) {
        add('"');
        CharacterIterator it = new StringCharacterIterator(obj.toString());
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            if (c == '"') add("\\\"");
            else if (c == '\\') add("\\\\");
            else if (c == '/') add("\\/");
            else if (c == '\b') add("\\b");
            else if (c == '\f') add("\\f");
            else if (c == '\n') add("\\n");
            else if (c == '\r') add("\\r");
            else if (c == '\t') add("\\t");
            else if (Character.isISOControl(c)) {
                unicode(c);
            } else {
                add(c);
            }
        }
        add('"');
    }

    private void add(Object obj) {
        buf.append(obj);
    }

    private void add(char c) {
        buf.append(c);
    }

    static char[] hex = "0123456789ABCDEF".toCharArray();

    private void unicode(char c) {
        add("\\u");
        int n = c;
        for (int i = 0; i < 4; ++i) {
            int digit = (n & 0xf000) >> 12;
            add(hex[digit]);
            n <<= 4;
        }
    }
    
   /*public static void main(String ss[]) {
    	OrderGetAction g = new OrderGetAction();
    	
    	Order o = new Order();
    	o.setInvoice("dddd");
    	o.setOrderId("ddddddddddddd");
    	o.setEndOrderTime(new Date());
    	o.setFreightPrice(222.0);
    	o.setItemTotalPrice(111.0);
    	
    	OrderDetail ddd = new OrderDetail();
    	ddd.setCount(111);
    	ddd.setItemId("11111");
    	ddd.setItemName("test");
    	
    	Consignee c = new Consignee();
    	c.setAddress("dddddddddd");
    	c.setEmail("woyaochangshi@162.com");
    	o.setConsignee(c);
    	
    	List<OrderDetail> list = new ArrayList<OrderDetail>();
    	list.add(ddd);
    	o.setOrderDetails(list);
    	
    	g.setOrder(o);
    	
    	Order[] o0 = new Order[1];
    	o0[0] = o;
    	
    	JSONCheckFieldsWriter j = new JSONCheckFieldsWriter("order_id, consignee.email, order_detail.item_name");
    	
    	System.out.println(j.write(o0));
    }*/
}
