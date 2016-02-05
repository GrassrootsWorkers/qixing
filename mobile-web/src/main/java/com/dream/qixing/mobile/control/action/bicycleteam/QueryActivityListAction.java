package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;

@ApiAction("bicycle.team.list")
public class QueryActivityListAction extends BaseAction {
	
	
	private String userId;
	private String queryType;
	@ApiListField("teams")
	@ApiField("team")
	private List<BicycleTeam> teams;
	
	public String execute(){
		
		return "";
	}
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
