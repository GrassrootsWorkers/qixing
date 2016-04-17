package com.dream.qixing.model.user;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer id;

    private Integer userId;

    /**
     * 骑过路线的难度最高等级 --根据路线进行测评，定期更新该字段，为推荐好友做准备
     */
    private Integer level;

    private String location;

    private String height;

    private String weight;

    private Integer bicycleAge;

    private String realName;

    private String weixinNum;

    private String role;

    private Integer total;

    /**
     * 根据使用次数和组件车队的次数
     */
    private Integer activeLevel;

    private String userMobile;

    private Date addTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public Integer getBicycleAge() {
        return bicycleAge;
    }

    public void setBicycleAge(Integer bicycleAge) {
        this.bicycleAge = bicycleAge;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getWeixinNum() {
        return weixinNum;
    }

    public void setWeixinNum(String weixinNum) {
        this.weixinNum = weixinNum == null ? null : weixinNum.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getActiveLevel() {
        return activeLevel;
    }

    public void setActiveLevel(Integer activeLevel) {
        this.activeLevel = activeLevel;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", level=").append(level);
        sb.append(", location=").append(location);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", bicycleAge=").append(bicycleAge);
        sb.append(", realName=").append(realName);
        sb.append(", weixinNum=").append(weixinNum);
        sb.append(", role=").append(role);
        sb.append(", total=").append(total);
        sb.append(", activeLevel=").append(activeLevel);
        sb.append(", userMobile=").append(userMobile);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}