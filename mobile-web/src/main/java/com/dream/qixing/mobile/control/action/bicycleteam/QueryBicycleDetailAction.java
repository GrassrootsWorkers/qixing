package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.bicycleteam.Activity;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;
import com.dream.qixing.mobile.model.bicycleteam.Friend;

@ApiAction("bicycle.team.detail")
public class QueryBicycleDetailAction extends BaseAction {
	// 查询类型 0：自己的车队 1:其他车队
	private int queryType;
	
	private int bicycleId;
	
	@ApiField("bicycle_team")
	private BicycleTeam bicycleTeam;

	public String execute(){
		if(0 == queryType){
			bicycleTeam = new BicycleTeam();
			bicycleTeam.setPersonLimit(500);
			bicycleTeam.setAmount(200);
			List<Friend> friends = new ArrayList<Friend>();
			Friend f = new Friend();
			f.setUserId(1000);
			f.setNickName("天空的云");
			friends.add(f);
			List<Activity> activitys = new ArrayList<Activity>();
			Activity act = new Activity();
			act.setActivityId(1000);
			act.setActivityDesc("昌平一日游");
			act.setBeginTime(new Date());
			act.setEndTime(new Date());
			act.setApplyEndTime(new Date());
			activitys.add(act);
			bicycleTeam.setActivitys(activitys);
			bicycleTeam.setFriends(friends);
		} else{
			
		}
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

	public int getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(int bicycleId) {
		this.bicycleId = bicycleId;
	}

}
