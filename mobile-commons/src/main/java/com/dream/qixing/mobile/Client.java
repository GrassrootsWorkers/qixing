package com.dream.qixing.mobile;


/**
 * 客户端。
 */
public interface Client {
	
	/**
	 * 执行 公开API请求。
	 * @param <T>
	 * @param request 具体的 请求
	 * @return
	 * @throws ApiException
	 */
	public <T extends BaseResponse> T execute(BaseRequest<T> request) throws ApiException ;
}
