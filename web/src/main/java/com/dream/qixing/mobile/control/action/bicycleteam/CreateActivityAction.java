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

	private String roleNumber;

	private Integer peopleNumber;
	//是否群发队友
	private String ifMass;

	private String allowUnknow;

	private Double applyFee;
	private String meetAddress;
	//活动上传的图片串
	private String images;

	public String execute() {
		this.activityId = 1000;
		this.bicycleId = 1000;
		this.setIssuccessful(true);
		this.setStatuscode(200);
		this.setDescription("创建活动成功");
		this.setUserId("1000");

		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
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

	public String getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(String roleNumber) {
		this.roleNumber = roleNumber;
	}

	public Integer getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getIfMass() {
		return ifMass;
	}

	public void setIfMass(String ifMass) {
		this.ifMass = ifMass;
	}

	public String getAllowUnknow() {
		return allowUnknow;
	}

	public void setAllowUnknow(String allowUnknow) {
		this.allowUnknow = allowUnknow;
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
}
