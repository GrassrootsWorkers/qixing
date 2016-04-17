package com.dream.qixing.util.parse.xml;


import com.dream.qixing.ApiException;
import com.dream.qixing.BaseParser;
import com.dream.qixing.BaseResponse;
import com.dream.qixing.mapping.Converter;

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
