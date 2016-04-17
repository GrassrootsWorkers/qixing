package com.dream.qixing.control.action.qixing;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;

@ApiAction(value = "cyc.report.add")
public class SaveCycReportAction extends BaseAction {

	private Integer reportId;
	private String qxName;
	private Double mileage;
	private String timeConsume;
	private Double averageSpeed;
	private Double highestSpeed;
	private Double lowestSpeed;
	private String caloricValue;
	private Integer roadBookId;
	//爬升高度
	private String height;
	private String tracks;
	
	public String execute() {
		//保存到数据库
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setUserId(1000);
		return "";
	}

	@Override
	public String getResponseName() {
		return null;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getQxName() {
		return qxName;
	}

	public void setQxName(String qxName) {
		this.qxName = qxName;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public String getTimeConsume() {
		return timeConsume;
	}

	public void setTimeConsume(String timeConsume) {
		this.timeConsume = timeConsume;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public Double getHighestSpeed() {
		return highestSpeed;
	}

	public void setHighestSpeed(Double highestSpeed) {
		this.highestSpeed = highestSpeed;
	}

	public Double getLowestSpeed() {
		return lowestSpeed;
	}

	public void setLowestSpeed(Double lowestSpeed) {
		this.lowestSpeed = lowestSpeed;
	}

	public String getCaloricValue() {
		return caloricValue;
	}

	public void setCaloricValue(String caloricValue) {
		this.caloricValue = caloricValue;
	}

	public Integer getRoadBookId() {
		return roadBookId;
	}

	public void setRoadBookId(Integer roadBookId) {
		this.roadBookId = roadBookId;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTracks() {
		return tracks;
	}

	public void setTracks(String tracks) {
		this.tracks = tracks;
	}
}
