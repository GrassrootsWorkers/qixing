package com.dream.qixing.mobile.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private Integer activityId;

    private String activityDesc;

    private Date beginTime;

    private Date endTime;

    private Date applyEndTime;

    private Integer roadBookId;

    private String roles;

    private Integer peopleNum;

    private String ifMass;

    private String allowUnknow;

    private Double applyFee;

    private Date createTime;

    private String startX;

    private String startY;
    
    private String endX;

    private String endY;

    /**
     * 0：活动刚创建，1：活动通过审核开始报名，2活动结束报名，3活动进行中 4 活动结束
     */
    private Integer activityStatus;

    private static final long serialVersionUID = 1L;

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
        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getIfMass() {
        return ifMass;
    }

    public void setIfMass(String ifMass) {
        this.ifMass = ifMass == null ? null : ifMass.trim();
    }

    public String getAllowUnknow() {
        return allowUnknow;
    }

    public void setAllowUnknow(String allowUnknow) {
        this.allowUnknow = allowUnknow == null ? null : allowUnknow.trim();
    }

    public Double getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(Double applyFee) {
        this.applyFee = applyFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStartX() {
        return startX;
    }

    public void setStartX(String startX) {
        this.startX = startX == null ? null : startX.trim();
    }

    public String getEndX() {
        return endX;
    }

    public void setEndX(String endX) {
        this.endX = endX == null ? null : endX.trim();
    }

    public String getStartY() {
        return startY;
    }

    public void setStartY(String startY) {
        this.startY = startY == null ? null : startY.trim();
    }

    public String getEndY() {
        return endY;
    }

    public void setEndY(String endY) {
        this.endY = endY == null ? null : endY.trim();
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", activityDesc=").append(activityDesc);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", applyEndTime=").append(applyEndTime);
        sb.append(", roadBookId=").append(roadBookId);
        sb.append(", roles=").append(roles);
        sb.append(", peopleNum=").append(peopleNum);
        sb.append(", ifMass=").append(ifMass);
        sb.append(", allowUnknow=").append(allowUnknow);
        sb.append(", applyFee=").append(applyFee);
        sb.append(", createTime=").append(createTime);
        sb.append(", startX=").append(startX);
        sb.append(", endX=").append(endX);
        sb.append(", startY=").append(startY);
        sb.append(", endY=").append(endY);
        sb.append(", activityStatus=").append(activityStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}