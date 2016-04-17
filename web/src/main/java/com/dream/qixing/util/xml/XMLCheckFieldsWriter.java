package com.dream.qixing.util.xml;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;

import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.util.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.dream.qixing.ApiException;
import com.dream.qixing.constants.Constants;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.util.XmlUtils;


/**
 * 
 * <pre>
 * 支持fields：例如 最多两级 order_id, consignee.email, order_detail.item_name
 * </pre>
 * 
 * @author Arron
 *
 */

public class XMLCheckFieldsWriter {
	
	private static final String DEFAULT_PRE = "";
	
	private Document doc;
	
    private Stack<Object> calls = new Stack<Object>();
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Map<String, Set<String>> includeFields;
    private Set<String> beanInclude;
    
    public XMLCheckFieldsWriter() {
    	try {
			doc = XmlUtils.newDocument();
		} catch (ApiException e) {
			throw new RuntimeException(e);
		}
    }

    public XMLCheckFieldsWriter(DateFormat format, String includeFields) {
    	this(includeFields);
        this.format = format;
    }
    
    public XMLCheckFieldsWriter(String includeFields) {
    	this();
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
    
    public String write(String rootTag, Object object) {
        Element root = doc.createElement(rootTag);
    	doc.appendChild(root);
    	Node child = null;
    	try {
	         List<Field> fieldList = ClassUtils.getAllFields(object.getClass());
	         for (int i = 0; i < fieldList.size(); ++i) {
	             Field field = fieldList.get(i);
	             
	             if (field.getAnnotation(ApiField.class) == null) {
	             	continue;
	             }
	             
	             field.setAccessible(true);
	             Object value = field.get(object);
	             if (value == null) continue;
	             
	             if (field.getAnnotation(ApiListField.class) == null) {
	            	child =objectValue(DEFAULT_PRE, null, field.getAnnotation(ApiField.class).value(), value);
	             } else {
	            	child = objectValue(DEFAULT_PRE, field.getAnnotation(ApiListField.class).value(), 
	             			field.getAnnotation(ApiField.class).value(), value);
	             }
	             
	             root.appendChild(child);
	         }
	     } catch (IllegalAccessException iae) {
	         iae.printStackTrace();
	     }
    	
        try {
			return XmlUtils.nodeToString(doc);
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
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
    
    private Node bean(String classPre, String tagName, Object object) {
    	if (!isIncludeBean(classPre)) {
    		return null;
    	}
    	
    	Node node = doc.createElement(tagName);
    	
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
                
                if (field.getAnnotation(ApiListField.class) == null) {
                	node.appendChild( objectValue(fieldName, null, fieldName, value) );
                } else {
                	node.appendChild( objectValue(fieldName, field.getAnnotation(ApiListField.class).value(), 
                			fieldName, value) );
                }
                
            }
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }
        
        return node;
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
    
    
    private Node objectValue(String classPre, String listTagName, String tagName, Object object) {
    	
    	if (object == null || cyclic(object)) {
            return null;
        } else {
            
            calls.push(object);
            Node child = null;
            
            if (object instanceof Class<?>) child = string(tagName, object);
            else if (object instanceof Boolean) child = bool(tagName, ((Boolean) object).booleanValue());
            else if (object instanceof Number) child = text(tagName, object);
            else if (object instanceof String) child = string(tagName, object);
            else if (object instanceof Character) child = string(tagName, object);
            else if (object instanceof Map<?, ?>) child = map(classPre, listTagName, tagName, (Map<?, ?>)object);
            else if (object.getClass().isArray()) child = array(classPre, listTagName, tagName, object);
            else if (object instanceof Iterator<?>) child = array(classPre, listTagName, tagName, (Iterator<?>)object);
            else if (object instanceof Collection<?>) child = array(classPre, listTagName, tagName, ((Collection<?>)object).iterator());
            else if (object instanceof Date) child = date(tagName, (Date)object);
            else child = bean(classPre, tagName, object);
            
            calls.pop();
            return child;
        }
    	
    }
    
    
    private Node text(String tagName, Object object) {
    	Node node = doc.createElement(tagName);
    	node.setTextContent(object.toString());
    	
    	return node;
    }
    
    private Node map(String classPre, String listTagName, String tagName, Map<?, ?> map) {
        
    	Node node = doc.createElement(tagName);
    	
    	Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
           Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next();
           node.appendChild(objectValue(classPre, listTagName, e.getKey().toString(), e.getValue()));
        }
        
        return node;
    }
    
    private Node array(String classPre, String listTagName, String tagName, Iterator<?> it) {
    	Element listNode = doc.createElement(listTagName);
    	listNode.setAttribute("list", "true");
    	
        while (it.hasNext()) {
        	listNode.appendChild(objectValue(classPre, null, tagName, it.next()));
        }
        
        return listNode;
    }

    private Node array(String classPre, String listTagName, String tagName, Object object) {
    	Element listNode = doc.createElement(listTagName);
    	listNode.setAttribute("list", "true");
    	
        int length = Array.getLength(object);
        for (int i = 0; i < length; ++i) {
        	listNode.appendChild(objectValue(classPre, null, tagName, Array.get(object, i)));
        }
        
        return listNode;
    }

    private Node bool(String tagName, boolean b) {
    	Node node = doc.createElement(tagName);
    	node.setTextContent(b ? "true" : "false");
    	
    	return node;
	}
    
    
    private Node date(String tagName, Date date) {
        if (format == null) {
            format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
        }
        
        Node node = doc.createElement(tagName);
        node.setTextContent(format.format(date));
        
        return node;
    }

	
    private Node string(String tagName, Object obj) {
    	Node node = doc.createElement(tagName);
    	node.appendChild(doc.createCDATASection(obj.toString()));
    	
        return node;
    }

    static char[] hex = "0123456789ABCDEF".toCharArray();

    public static void main(String ss[]) {
    /*	OrderGetAction g = new OrderGetAction();
    	
    	Order o = new Order();
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
    	
    	XMLCheckFieldsWriter cf = new XMLCheckFieldsWriter("order_id, invoice, consignee.address, order_detail.count");
    	
    	System.out.println(cf.write("order_get_response", g));*/
    }
}
