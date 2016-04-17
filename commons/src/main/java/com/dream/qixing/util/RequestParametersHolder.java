package com.dream.qixing.util;

public class RequestParametersHolder {
	private PureStringHashMap protocalMustParams;
	private PureStringHashMap protocalOptParams;
	private PureStringHashMap applicationParams;
	
	public PureStringHashMap getProtocalMustParams() {
		return protocalMustParams;
	}
	public void setProtocalMustParams(PureStringHashMap protocalMustParams) {
		this.protocalMustParams = protocalMustParams;
	}
	public PureStringHashMap getProtocalOptParams() {
		return protocalOptParams;
	}
	public void setProtocalOptParams(PureStringHashMap protocalOptParams) {
		this.protocalOptParams = protocalOptParams;
	}
	public PureStringHashMap getApplicationParams() {
		return applicationParams;
	}
	public void setApplicationParams(PureStringHashMap applicationParams) {
		this.applicationParams = applicationParams;
	}
	

	
}
