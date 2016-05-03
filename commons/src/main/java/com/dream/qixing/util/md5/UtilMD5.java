package com.dream.qixing.util.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UtilMD5 {
	
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	@SuppressWarnings("unused")
	private static String key="xpg28h1bejddn24lzj2c5";
	
	public static String md5(String text) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(
					"System doesn't support MD5 algorithm.");
		}
		try {
			msgDigest.update(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));
		return md5Str;
	}

	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}
	
	
	public static String StrToHex(String str) 
	{ 
		if(str == null) return null; 
		String content = str; 
		String Digital="0123456789ABCDEF"; 
		StringBuffer sb=new StringBuffer(""); 
		byte[] bs=content.getBytes(); 
		int bit; 
		for(int i=0;i<bs.length;i++){ 
		bit=(bs[i]&0x0f0)>>4; 
		sb.append(Digital.substring(bit,bit+1)); 
		bit=bs[i]&0x0f; 
		sb.append(Digital.substring(bit,bit+1)); 
		} 
		return sb.toString(); 
	} 

	public static String HexToStr(String str) 
	{ 
		if(str == null) return null; 
		String b= str; 
		String Digital="0123456789ABCDEF"; 
		byte[] bytes=new byte[b.length()/2]; 
		int temp; 
		for(int i=0;i<bytes.length;i++){ 
		temp=Digital.indexOf(b.substring(2*i,2*i+1))*16; 
		temp+=Digital.indexOf(b.substring(2*i+1,2*i+2)); 
		bytes[i]=(byte)(temp&0xff); 
	} 
	return (new String(bytes)); 
	} 

	public static String dHex(byte[] data){
		if(data.length%2!=0){
			throw new RuntimeException("erroe array length");
		}
		byte[] str=new byte[data.length>>1];
		int temp=0;
		for(int i=0;i<str.length;i++){ 
			temp=DIGITS[2*i+1]*16; 
			temp+=DIGITS[2*i+1]; 
			str[i]=(byte)(temp&0xff); 
		}
		return new String(str);
	}
	
	public static void main(String[] args) {
		System.out.println(md5("liqiadddddddddddddddddddddddddddddddddddsaaaaaaaaaaaaasdffffffffffffasdng"));
	}

}
