package com.dream.qixing.mobile.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ActivityApply implements Serializable {
    private Integer id;

    private Integer activityId;

    private Integer userId;

    /**
     * 在该活动担当什么角色
     */
    private Integer roleId;

    private Date applyTime;

    private String ifOnTime;
    
 

    private static final long serialVersionUID = 1L;

    
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getIfOnTime() {
        return ifOnTime;
    }

    public void setIfOnTime(String ifOnTime) {
        this.ifOnTime = ifOnTime == null ? null : ifOnTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", ifOnTime=").append(ifOnTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}