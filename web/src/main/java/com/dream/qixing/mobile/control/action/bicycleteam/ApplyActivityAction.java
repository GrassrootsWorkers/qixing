package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction("bicycle.activity.apply")
public class ApplyActivityAction extends BaseAction {
    private Integer activityId;

    private Integer userNumber;

	private String applyType;

    public String execute(){
    	if("add".equals(applyType)){
			if(activityId ==0){
				this.setIsSuccessful(false);
				this.setStatusCode(400);
				this.setDescription("活动已经报满");
				return "";
			}else{
				this.setIsSuccessful(true);
				this.setStatusCode(200);
				this.setDescription("申请成功！");
				return "";
			}

		}else{
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("退出成功！");
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

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
}
