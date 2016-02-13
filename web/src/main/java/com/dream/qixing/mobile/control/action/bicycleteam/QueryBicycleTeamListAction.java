package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.bicycleteam.Activity;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;
import com.dream.qixing.mobile.model.bicycleteam.Friend;

@ApiAction("bicycle.activity.list")
public class QueryBicycleTeamListAction extends BaseAction {
	
	//查询类型  1:推荐的车队 2：参加的车队
	private int queryType;
	private String bicycleName;
	private Integer provinceId;
	private Integer cityId;
	
	@ApiListField("bicycle_teams")
	@ApiField("team")
	private List<BicycleTeam> bicycleTeams;
	public String execute(){
		bicycleTeams = new ArrayList<BicycleTeam>();
		BicycleTeam team = new BicycleTeam();
		team.setCycId(1000);
		team.setCycTeamLogo("http://qixing.com/imgage.jpg");
		team.setAmount(100);
		team.setClubName("夕阳红");
		team.setLiveness("高");
		team.setCreateTime(new Date());
		bicycleTeams.add(team);
		team.setCycId(1001);
		bicycleTeams.add(team);
		return "";
	}
	

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public int getQueryType() {
		return queryType;
	}


	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}


	public String getBicycleName() {
		return bicycleName;
	}

	public void setBicycleName(String bicycleName) {
		this.bicycleName = bicycleName;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	

}
