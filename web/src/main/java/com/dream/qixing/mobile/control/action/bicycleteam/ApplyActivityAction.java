package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction("bicycle.activity.apply")
public class ApplyActivityAction extends BaseAction {
    private Integer activityId;

    private Integer userId;

	private String type;

    public String execute(){
    	if("add".equals(type)){
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("申请成功！");
			this.setUserId(10000);
			return "";
		}else{
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("退出成功！");
			this.setUserId(10000);
			return "";
		}

    }
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}
}
