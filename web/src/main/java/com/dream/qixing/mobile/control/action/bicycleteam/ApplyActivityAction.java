package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction("bicycle.activity.apply")
public class ApplyActivityAction extends BaseAction {
    private Integer activityId;

    private Integer userId;

    private int roleNumber;
    
    private String mobile;
    
    /**
     * 在该活动担当什么角色
     */
    private Integer roleId;

    public String execute(){
    	
    	this.setIssuccessful(true);
    	this.setStatuscode(200);
    	this.setDescription("申请成功！");
    	this.setUserId("1000");
    	return "";
    }
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
