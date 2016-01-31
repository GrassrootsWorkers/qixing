package com.dream.qixing.mobile.model.qixing;

import com.dream.qixing.mobile.mapping.ApiField;

public class TeamTrace {
	
	
	private String roleName;
	@ApiField("role_code")
	private Integer roleCode;
	
	@ApiField("user_id")
	private Integer userId;
	private Integer activityId;
	@ApiField("nick_name")
	private String nickName;
	@ApiField("speed")
	private String speed;
	@ApiField("x")
	private String locationX;
	@ApiField("y")
	private String locationY;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(Integer roleCode) {
		this.roleCode = roleCode;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	public String getLocationY() {
		return locationY;
	}
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	
	
}
