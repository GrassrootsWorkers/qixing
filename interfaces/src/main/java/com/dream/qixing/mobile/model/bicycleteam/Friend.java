package com.dream.qixing.mobile.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.user.User;

public class Friend implements Serializable {
    @ApiField("user_id")
    private Integer userId;
    @ApiField("nick_name")
    private String nickName;
    @ApiField("user_image")
    private String image;
    @ApiField("location")
    private String location;
    private Integer cycId;
    private Integer activityId;
    private Date addTime;
    private Integer status;
    //是否是管理员，创建者默认是管理员
    private String ifAdmin;
    private int roleCode;

    public Integer getCycId() {
        return cycId;
    }

    public void setCycId(Integer cycId) {
        this.cycId = cycId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(String ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}