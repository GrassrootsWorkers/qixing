package com.dream.qixing.mapping;

import com.dream.qixing.ApiException;
import com.dream.qixing.BaseResponse;

/**
 * 动态格式转换器。
 * 
 */
public interface Converter {

	/**
	 * 把字符串转换为响应对象。
	 * 
	 * @param <T> 领域泛型
	 * @param rsp 响应字符串
	 * @param clazz 领域类型
	 * @return 响应对象
	 * @throws TopException
	 */
	public <T  extends BaseResponse> T toResponse(String rsp, Class<T> clazz) throws ApiException;

}
