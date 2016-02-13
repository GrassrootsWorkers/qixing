package com.dream.qixing.mobile.util.parse.xml;


import com.dream.qixing.mobile.ApiException;
import com.dream.qixing.mobile.BaseParser;
import com.dream.qixing.mobile.BaseResponse;
import com.dream.qixing.mobile.mapping.Converter;

/**
 * 单个XML对象解释器。
 * 
 */
public class ObjectXmlParser<T extends BaseResponse> implements BaseParser<T> {

	private Class<T> clazz;

	public ObjectXmlParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T parse(String rsp) throws ApiException {
		Converter converter = new XmlConverter();
		return converter.toResponse(rsp, clazz);
	}

	public Class<T> getResponseClass() {
		return clazz;
	}

}
