package com.dream.qixing.mobile.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mobile.mapping.ApiField;

public class Friend implements Serializable {
    private Integer id;

    private Integer cycId;

    @ApiField("user_id")
    private Integer userId;
    @ApiField("nick_name")
    private String nickName;

    private Date addTime;

    private Integer status;
    //是否是管理员，创建者默认是管理员
    private String ifAdmin;

    private static final long serialVersionUID = 1L;

    public String getIfAdmin() {
		return ifAdmin;
	}

	public void setIfAdmin(String ifAdmin) {
		this.ifAdmin = ifAdmin;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCycId() {
        return cycId;
    }

    public void setCycId(Integer cycId) {
        this.cycId = cycId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cycId=").append(cycId);
        sb.append(", userId=").append(userId);
        sb.append(", addTime=").append(addTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}