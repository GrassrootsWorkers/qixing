package com.dream.qixing.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.dream.qixing.constants.Constants;


public abstract class SignUtil {
	
	public static String makeSign(Map<String, Object> params, String secret, boolean isHmac) 
			throws IOException{
		
		// 第一步：把字典按Key的字母顺序排序
		Map<String, Object> sortedParams = new TreeMap<String, Object>();
		sortedParams.putAll(params);
		sortedParams.remove("sign");
		
		Set<Entry<String, Object>> paramSet = sortedParams.entrySet();
		
		// 第二步：把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		if (!isHmac) {
			query.append(secret);
		}
		for (Entry<String, Object> param : paramSet) {
			
			String  value = null;
			if (param.getValue().getClass().isArray()) {
				value =  ( (String[]) param.getValue() )[0];
			} else {
				value = param.getValue().toString();
			}
			
			if (StringUtils.areNotEmpty(param.getKey(), value)) {
				query.append(param.getKey()).append(value);
			}
		}
		
		// 第三步：使用MD5/HMAC加密
		byte[] bytes;
		if (isHmac) {
			bytes = encryptHMAC(query.toString(), secret);
		} else {
			query.append(secret);
			bytes = encryptMD5(query.toString());
		}
		
		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}
	
	public  static byte[] encryptHMAC(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacMD5");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse);
		}
		return bytes;
	}

	public  static byte[] encryptMD5(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			bytes = md.digest(data.getBytes(Constants.CHARSET_UTF8));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse);
		}
		return bytes;
	}

	public  static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
}
