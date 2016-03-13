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

@ApiAction("bicycle.activity.list")
public class QueryActivityListAction extends BaseAction {

	private int queryType;
	private String activityName;

	@ApiListField("activities")
	@ApiField("activity")
	private List<Activity>activities;
	public String execute(){
		activities = new ArrayList<Activity>();

		if(1 == queryType){
			Activity activity = new Activity();
			activity.setActivityName("昌平一日游");
			activity.setMeetAddress("北京市昌平区");
			/**
			 * 改值根据活动状态设置
			 */
			activity.setBeginTime(new Date());
			/**
			 * 1:自己创建的车队 2：参加的车队
			 */
			activity.setActivityType(1);
			activity.setStatusName("新建");
			activity.setMileage(14.46);
			activities.add(activity);
			Activity activity1 = new Activity();
			activity1.setActivityName("昌平一日游");
			activity1.setMeetAddress("北京市昌平区");
			/**
			 * 改值根据活动状态设置
			 */
			activity1.setBeginTime(new Date());
			/**
			 * 1:自己创建的车队 2：参加的车队 0:正在报名的车队
			 */
			activity1.setActivityType(2);
			activity1.setStatusName("即将开始");
			activity1.setMileage(14.46);
			activities.add(activity1);
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("查询成功！");
		}else if(queryType == 2) {
			Activity activity = new Activity();
			activity.setActivityName("昌平一日游");
			activity.setMeetAddress("北京市昌平区");
			activity.setPrompt("剩余1天2小时");
			activity.setActivityType(0);
			activity.setPeopleNum(100);
			activity.setAmount(50);
			activity.setMileage(14.46);
			activities.add(activity);
			Activity activity1 = new Activity();
			activity1.setActivityName("昌平一日游");
			activity1.setMeetAddress("北京市昌平区");
			activity1.setPrompt("剩余2天2小时");
			activity1.setPeopleNum(100);
			activity1.setAmount(50);
			activity1.setActivityType(0);
			activity1.setMileage(14.46);
			activities.add(activity1);
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setDescription("搜索成功！");
		}else{
			this.setIsSuccessful(false);
			this.setStatusCode(500);
			this.setDescription("数据查询出了差错，请耐心等待会！");
		}

		return "";
	}
	@Override
	public String getResponseName() {

		return null;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
}
