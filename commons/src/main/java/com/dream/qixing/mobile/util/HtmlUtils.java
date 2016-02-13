package com.dream.qixing.mobile.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.net.HttpURLConnection;
import java.net.URL;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.Parser;

public class HtmlUtils {
	public static String parseTags(String htmlStr){
        String textStr = "";  
        java.util.regex.Pattern p_script;  
        java.util.regex.Matcher m_script;  
        java.util.regex.Pattern p_style;  
        java.util.regex.Matcher m_style;  
        java.util.regex.Pattern p_html;  
        java.util.regex.Matcher m_html;  
        try {  
            String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>";   
            String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>";   
            String regEx_html = "<[^>]+>";  
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
            m_script = p_script.matcher(htmlStr);  
            htmlStr = m_script.replaceAll("");   
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
            m_style = p_style.matcher(htmlStr);  
            htmlStr = m_style.replaceAll("");   
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
            m_html = p_html.matcher(htmlStr);  
            htmlStr = m_html.replaceAll("");  
            textStr = htmlStr.replaceAll(" ", "");  
            textStr = htmlStr.replaceAll("<",  "<");  
            textStr = htmlStr.replaceAll(">",  ">");  
            textStr = htmlStr.replaceAll("&", "&");  
        } catch(Exception ex){
			return "";
		}
		return textStr;
	}	 
	
	 
//	 public static List<String> getContext(String html,String matchStr0,String matchStr1){
//		 List<String> resultList = new ArrayList<String>();
//	       Pattern p = Pattern.compile(matchStr0);//匹配<title>开头，</title>结尾的文档
//	       Matcher m = p.matcher(html );//开始编译
//	       while (m.find()) {
//	    	   String str = m.group(0);
//	    	   //String pattern= "href=\"([^\"]*)\"";
//	    	   Pattern p1 = Pattern.compile(matchStr1, 2 | Pattern.DOTALL);
//	    	   Matcher m1 = p1.matcher(str);
//	    	   m1.group(1);
//
//	           resultList.add(m.group(0));//获取被匹配的部分
//	       }
//	       return resultList;
//	 }
	 
	/**
	 * 
	 * @param url
	 * @param tag
	 * @return
	 */
	 public static List<String> getContext(String url,String tag){
		  try{
			  	List<String> resultList = new ArrayList<String>();
	            Parser parser = new Parser((HttpURLConnection) (new URL(url)).openConnection() );
	            TagNameFilter filter = new TagNameFilter(tag);
	            NodeList nodeList = parser.extractAllNodesThatMatch(filter);
	            NodeIterator it = nodeList.elements();
	            
	            while (it.hasMoreNodes()) {
	            	LinkTag node = (LinkTag) it.nextNode();
	            	String href = node.getLink().replaceAll(",", "");
	            	String title = node.getLinkText().replaceAll(",", "");
	                resultList.add(title+","+href);
	            } 
	            return resultList;
	        }
	        catch( Exception e ) {     
	            return null;
	        }
	 }
}
