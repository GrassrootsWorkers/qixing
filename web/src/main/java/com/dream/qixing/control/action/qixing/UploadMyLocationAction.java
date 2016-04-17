package com.dream.qixing.control.action.qixing;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;

@ApiAction(value = "cyc.uploadLocation")
public class UploadMyLocationAction extends BaseAction {

    private Integer activityId;
    private String locationLon;
    private String locationLat;
    private double speed;
    private int roleCode;
    private String nickName;

    @Override
    public String execute() {

        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setUserId(10000);
        this.setDescription("上传成功！");

        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
