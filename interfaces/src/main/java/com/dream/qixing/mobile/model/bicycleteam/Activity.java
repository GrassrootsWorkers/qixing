package com.dream.qixing.mobile.model.bicycleteam;

import com.dream.qixing.mobile.mapping.ApiField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Activity implements Serializable {
    @ApiField("activity_id")
    private Integer activityId;
    @ApiField("activity_desc")
    private String activityDesc;
    @ApiField("activity_name")
    private String activityName;
    @ApiField("begin_time")
    private Date beginTime;
    @ApiField("end_time")
    private Date endTime;
    @ApiField("apply_end_time")
    private Date applyEndTime;
    @ApiField("road_book_id")
    private Integer roadBookId;
    @ApiField("book_name")
    private String roadBookName;
    @ApiField("meet_address")
    private String activityAddress;
    @ApiField("people_number")
    private Integer peopleNum;
    @ApiField("expenses")
    private Double expenses;
    @ApiField("amount")
    private Integer amount;
    @ApiField("if_must_join_team")
    private String ifMustJoinTeam;
    @ApiField("organiser")
    private String organiser;
    @ApiField("meet_address")
    private String meetAddress;
    private String ifMass;
    private String roles;
    private Date createTime;
    private String startX;
    private String startY;
    private String endX;
    private String endY;
    /**
     * 0：活动刚创建，1：活动通过审核开始报名，2活动结束报名，3活动进行中 4 活动结束
     */
    @ApiField("status")
    private Integer activityStatus;
    @ApiField("status_name")
    private String statusName;
    @ApiField("activity_type")
    /**
     * 1:自己创建的活动 2：参加的活动  0:正在报名的活动
     */
    private int activityType;
    private String activityImages;
    //正在报名活动提示
    @ApiField("prompt")
    private String prompt;
    @ApiField("mileage")
    private double mileage;
    @ApiField("images")
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRoadBookName() {
        return roadBookName;
    }

    public void setRoadBookName(String roadBookName) {
        this.roadBookName = roadBookName;
    }

    public String getPrompt() {
        return prompt;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getOrganiser() {
        return organiser;
    }

    public String getMeetAddress() {
        return meetAddress;
    }

    public void setMeetAddress(String meetAddress) {
        this.meetAddress = meetAddress;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public List<ActivityApply> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<ActivityApply> applicant) {
        this.applicant = applicant;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    private List<ActivityApply> applicant;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

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

    public String getIfMustJoinTeam() {
        return ifMustJoinTeam;
    }

    public void setIfMustJoinTeam(String ifMustJoinTeam) {
        this.ifMustJoinTeam = ifMustJoinTeam;
    }

    public String getActivityImages() {
        return activityImages;
    }

    public void setActivityImages(String activityImages) {
        this.activityImages = activityImages;
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