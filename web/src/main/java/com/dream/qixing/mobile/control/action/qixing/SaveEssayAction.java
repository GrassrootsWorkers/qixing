package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction(value="cyc.essays")
public class SaveEssayAction extends BaseAction {

	private String reportId;
	private String desc;
	private String imageStrs;
	private String userId;
	public String execute(){
		//保存到数据库
		this.setIssuccessful(true);
		this.setStatuscode(200);
		this.setUserId(userId);
		
		return "";
	}
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImageStrs() {
		return imageStrs;
	}
	public void setImageStrs(String imageStrs) {
		this.imageStrs = imageStrs;
	}

	
}
