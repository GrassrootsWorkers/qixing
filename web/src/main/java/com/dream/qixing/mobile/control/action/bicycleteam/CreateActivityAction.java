package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.Date;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

@ApiAction("bicycle.team.activity")
public class CreateActivityAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ApiField("bicycle_id")
	private Integer bicycleId;
	@ApiField("activity_id")
	private Integer activityId;

	private String activityDesc;
	private String activityAddress;
	private String activityName;
	private Date beginTime;

	private Date endTime;

	private Date applyEndTime;

	private Integer roadBookId;


	private Integer peopleNumber;


	private String allowUnknown;

	private Double applyFee;

	private String meetAddress;
	//活动上传的图片串
	private String images;

	public String execute() {
		this.activityId = 1000;
		this.bicycleId = 1000;
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setDescription("创建活动成功");
		this.setUserId(1000);

		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getApplyEndTime() {
		return applyEndTime;
	}

	public void setApplyEndTime(Date applyEndTime) {
		this.applyEndTime = applyEndTime;
	}

	public Integer getRoadBookId() {
		return roadBookId;
	}

	public void setRoadBookId(Integer roadBookId) {
		this.roadBookId = roadBookId;
	}

	public Integer getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getAllowUnknown() {
		return allowUnknown;
	}

	public void setAllowUnknown(String allowUnknown) {
		this.allowUnknown = allowUnknown;
	}

	public Double getApplyFee() {
		return applyFee;
	}

	public void setApplyFee(Double applyFee) {
		this.applyFee = applyFee;
	}

	public String getMeetAddress() {
		return meetAddress;
	}

	public void setMeetAddress(String meetAddress) {
		this.meetAddress = meetAddress;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}
}
