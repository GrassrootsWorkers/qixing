package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycleteam.BicycleTeam;

@ApiAction("bicycle.team.create")
public class CreateBicycleTeamAction extends BaseAction {

	private String bicycleTeamLogo;

	private String bicycleTeamName;

	private String clubAddress;

	private String desc;

	private String createName;

	private String mobile;

	private String allowStrangerApply;
	private String purpose;

	private Integer personLimit;
	@ApiField("bicycle_id")
	private Integer bicycleId;

	public String execute() {
		BicycleTeam team = new BicycleTeam() ;
		team.setPersonLimit(personLimit);
		bicycleId = team.getCycId();
		bicycleId = 1000;
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setDescription("success");
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBicycleTeamLogo() {
		return bicycleTeamLogo;
	}

	public void setBicycleTeamLogo(String bicycleTeamLogo) {
		this.bicycleTeamLogo = bicycleTeamLogo;
	}

	public String getBicycleTeamName() {
		return bicycleTeamName;
	}

	public void setBicycleTeamName(String bicycleTeamName) {
		this.bicycleTeamName = bicycleTeamName;
	}

	public String getClubAddress() {
		return clubAddress;
	}

	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAllowStrangerApply() {
		return allowStrangerApply;
	}

	public void setAllowStrangerApply(String allowStrangerApply) {
		this.allowStrangerApply = allowStrangerApply;
	}

	public Integer getPersonLimit() {
		return personLimit;
	}

	public void setPersonLimit(Integer personLimit) {
		this.personLimit = personLimit;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}
}
