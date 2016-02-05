package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;

@ApiAction("bicycle.team.create")
public class CreateBicycleTeamAction extends BaseAction {

	private String bicycleTeamLogo;

	private String bicycleTeamName;

	private String clubAddress;

	private String clubDesc;

	private String createName;

	private String mobile;

	private String imageUrl;

	private String allowUnknowApply;

	private Integer personLimit;
	@ApiField("bicycle_id")
	private Integer bicycleId;

	public String execute() {
		BicycleTeam team = new BicycleTeam() ;
		team.setPersonLimit(personLimit);
		bicycleId = team.getCycId();
		bicycleId = 1000;
		this.setIssuccessful(true);
		this.setStatuscode(200);
		this.setDescription("success");
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
