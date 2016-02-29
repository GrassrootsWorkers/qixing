package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction("bicycle.team.apply")
public class ApplyBicycleTeamAction extends BaseAction {
	private int userId;
	private int bicycleId;
	private int code;
	
	public String execute(){
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setDescription("加入车队成功");
		this.setUserId(1000);
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
