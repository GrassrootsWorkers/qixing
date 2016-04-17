package com.dream.qixing.util.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TimeZone;

import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.constants.Constants;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.util.ClassUtils;


public class JSONActionWrite {
    private StringBuffer buf = new StringBuffer();
    private Stack<Object> calls = new Stack<Object>();
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String inlucdefields;
    
    public JSONActionWrite() {
    }

    public JSONActionWrite(String includeFields, DateFormat format) {
       this(includeFields);
       this.format = format;
    }
    
    public JSONActionWrite(String inlucdefields) {
    	this.inlucdefields = inlucdefields;
    }
    
    public String write(Object object) {
       buf.setLength(0);
	   add("{");
	     boolean addedSomething = false;
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
        return buf.toString();
    }
    public String mobileWrite(Object object,boolean ifMobile) {
    	String listName=null;
        buf.setLength(0);
 	   add("{");
 	     boolean addedSomething = false;
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
 	             if (addedSomething) add(',');
 	             
 	             if (field.getAnnotation(ApiListField.class) == null) {
 	             	add(field.getAnnotation(ApiField.class).value(), value);
 	             } else {
 	            	  listName= field.getAnnotation(ApiListField.class).value();
 	             	add(listName,field.getAnnotation(ApiField.class).value(), value);
 	             	
 	             }
 	             
 	             addedSomething = true;
 	         }
 	     } catch (IllegalAccessException iae) {
 	         iae.printStackTrace();
 	     }
 	     
 	     add("}");
 	     String result=buf.toString();
 	    /* if(listName!=null){
 	    	 result=result.substring(1,  result.length()).replace("\""+listName+"\":", ""); 
 	    	 result=result.substring(0,result.length()-1);
 	     }*/
         return result;
     }
    private void value(Object object) {
        if (object == null || cyclic(object)) {
            add(null);
        } else {
            calls.push(object);
            if (object instanceof Class<?>) string(object);
            else if (object instanceof Boolean) bool(((Boolean) object).booleanValue());
            else if (object instanceof Number) add(object);
            else if (object instanceof String) string(object);
            else if (object instanceof Character) string(object);
            else if (object instanceof Map<?, ?>) map((Map<?, ?>)object);
            else if (object.getClass().isArray()) array(object);
            else if (object instanceof Iterator<?>) array((Iterator<?>)object);
            else if (object instanceof Collection<?>) array(((Collection<?>)object).iterator());
            else if (object instanceof Date) date((Date)object);
            else bean(object);
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
    
    private void bean(Object object) {
    	add(new JSONCheckFieldsWriter(format, inlucdefields).write(object));
    }
    
    
    private void add(String name, Object value) {
        add('"');
        add(name);
        add("\":");
        value(value);
    }
    
    private void add(String outer, String name, Object value) {
        add('"');
        add(outer);
        add("\":{");
        add('"');
        add(name);
        add("\":");
        value(value);
        add("}");
    }
    
    private void map(Map<?, ?> map) {
        add("{");
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next();
            value(e.getKey());
            add(":");
            value(e.getValue());
            if (it.hasNext()) add(',');
        }
        add("}");
    }
    
    private void array(Iterator<?> it) {
        add("[");
        while (it.hasNext()) {
            value(it.next());
            if (it.hasNext()) add(",");
        }
        add("]");
    }

    private void array(Object object) {
        add("[");
        int length = Array.getLength(object);
        for (int i = 0; i < length; ++i) {
            value(Array.get(object, i));
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
    
    
}
