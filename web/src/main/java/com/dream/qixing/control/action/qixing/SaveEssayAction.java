package com.dream.qixing.control.action.qixing;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;

@ApiAction(value="cyc.essays")
public class SaveEssayAction extends BaseAction {

	private String reportId;
	private String desc;
	private String image;
	private String locationLon;
	private String locationLat;
	private String locationName;
	@Override
	public String execute(){
		//保存到数据库
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setUserId(10000);
		this.setDescription("保存成功");
		return "";
	}
	@Override
	public String getResponseName() {
		return null;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocationLon() {
		return locationLon;
	}

	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}

	public String getLocationLat() {
		return locationLat;
	}

	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}
}
