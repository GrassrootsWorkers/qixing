package com.dream.qixing.mobile.model.vender;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mobile.mapping.ApiField;

public class Vender implements Serializable {

	private static final long serialVersionUID = 3545898387735120194L;
	
	public static final int DISABLED = 1;//启用
	public static final int ENABLED = 0;//停用
	
	private Integer id;
	@ApiField("changeTime")
	private Integer chanageTime;
	private Integer status;
	@ApiField("vender_id")
	private String venderId;
	@ApiField("app_type")
	private String appType;
	@ApiField("secret")
	private String secret;	
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getChanageTime() {
		return chanageTime;
	}
	public void setChanageTime(Integer chanageTime) {
		this.chanageTime = chanageTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
