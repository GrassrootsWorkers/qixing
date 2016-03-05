package com.dream.qixing.mobile.control.action.qixing;

import java.util.Date;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction(value = "cyc.report.add")
public class SaveCycReportAction extends BaseAction {

	private Integer reportId;



	private String qxName;

	private Date startTime;

	private String gpsStrs;

	private Integer difficultyDeg;

	private String averageSpeed;

	private String highestSpeed;

	private String lowestSpeed;

	private String timeConsume;

	private String caloricValue;

	private Integer roadBookId;
	//爬升高度
	private String height;
	
	public String execute() {
		//保存到数据库
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setUserId(1000);
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getGpsStrs() {
		return gpsStrs;
	}

	public void setGpsStrs(String gpsStrs) {
		this.gpsStrs = gpsStrs;
	}

	public Integer getDifficultyDeg() {
		return difficultyDeg;
	}

	public void setDifficultyDeg(Integer difficultyDeg) {
		this.difficultyDeg = difficultyDeg;
	}

	public String getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(String averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String getHighestSpeed() {
		return highestSpeed;
	}

	public void setHighestSpeed(String highestSpeed) {
		this.highestSpeed = highestSpeed;
	}

	public String getLowestSpeed() {
		return lowestSpeed;
	}

	public void setLowestSpeed(String lowestSpeed) {
		this.lowestSpeed = lowestSpeed;
	}

	public String getTimeConsume() {
		return timeConsume;
	}

	public void setTimeConsume(String timeConsume) {
		this.timeConsume = timeConsume;
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
}
