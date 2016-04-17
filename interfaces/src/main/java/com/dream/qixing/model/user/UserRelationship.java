package com.dream.qixing.model.user;

import java.io.Serializable;
import java.util.Date;

public class UserRelationship implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer referrer;

    private Integer founderId;

    /**
     * 一个人只能有三个推荐人，多余三个忘伞下放
     */
    private Integer childIndex;

    private Date addTime;

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

    public Integer getReferrer() {
        return referrer;
    }

    public void setReferrer(Integer referrer) {
        this.referrer = referrer;
    }

    public Integer getFounderId() {
        return founderId;
    }

    public void setFounderId(Integer founderId) {
        this.founderId = founderId;
    }

    public Integer getChildIndex() {
        return childIndex;
    }

    public void setChildIndex(Integer childIndex) {
        this.childIndex = childIndex;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", referrer=").append(referrer);
        sb.append(", founderId=").append(founderId);
        sb.append(", childIndex=").append(childIndex);
        sb.append(", addTime=").append(addTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}