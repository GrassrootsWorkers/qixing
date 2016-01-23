package com.dream.qixing.mobile.util.parse.json;

import com.dream.qixing.mobile.ApiException;
import com.dream.qixing.mobile.BaseParser;
import com.dream.qixing.mobile.BaseResponse;
import com.dream.qixing.mobile.mapping.Converter;

/**
 * 单个JSON对象解释器。
 * 
 */
public class ObjectJsonParser<T extends BaseResponse> implements BaseParser<T> {

	private Class<T> clazz;

	public ObjectJsonParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T parse(String rsp) throws ApiException {
		Converter converter = new JsonConverter();
		return converter.toResponse(rsp, clazz);
	}

	public Class<T> getResponseClass() {
		return clazz;
	}

}
