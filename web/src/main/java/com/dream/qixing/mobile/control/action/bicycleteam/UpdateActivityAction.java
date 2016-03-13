package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

import java.util.Date;

@ApiAction("bicycle.activity.update")
public class UpdateActivityAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ApiField("bicycle_id")
	private Integer bicycleId;
	@ApiField("activity_id")
	private Integer activityId;
	private String activityName;
	private String activityDesc;
	private Date beginTime;
	private Date endTime;
	private Date applyEndTime;
	private Integer roadBookId;
	private Integer peopleNumber;
	private String ifMustJoinTeam;
	private Double expenses;
	private String meetAddress;
	//活动上传的图片串
	private String images;

	public String execute() {
		if(activityId == 1){
			this.setIsSuccessful(false);
			this.setStatusCode(501);
			this.setDescription("车队不存在");
			this.setUserId(1000);
		}else if(activityId == 2){
			this.setIsSuccessful(false);
			this.setStatusCode(500);
			this.setDescription("系统错误，正在努力维护中！");
			this.setUserId(1000);
		}else {
			this.activityId = 1000;
			this.bicycleId = 1000;
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("更新成功！");
			this.setUserId(1000);
		}


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

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public String getIfMustJoinTeam() {
		return ifMustJoinTeam;
	}

	public void setIfMustJoinTeam(String ifMustJoinTeam) {
		this.ifMustJoinTeam = ifMustJoinTeam;
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
