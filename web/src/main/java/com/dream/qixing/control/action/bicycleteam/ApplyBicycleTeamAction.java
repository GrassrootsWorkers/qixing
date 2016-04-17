package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;

@ApiAction("bicycle.team.apply")
public class ApplyBicycleTeamAction extends BaseAction {
	private int bicycleId;
	private String applyType;
	
	public String execute(){
		if("add".equals(applyType)){
			if(bicycleId == 0){
				this.setIsSuccessful(false);
				this.setStatusCode(501);
				this.setDescription("车队已满员，请去推荐的车队中寻找您喜爱的车队！");
				this.setUserId(10000);
			}else{
				this.setIsSuccessful(true);
				this.setStatusCode(200);
				this.setDescription("加入车队成功");
				this.setUserId(10000);
			}

		}else{
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("退出车队成功");
			this.setUserId(1000);
		}

		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(int bicycleId) {
		this.bicycleId = bicycleId;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
}
