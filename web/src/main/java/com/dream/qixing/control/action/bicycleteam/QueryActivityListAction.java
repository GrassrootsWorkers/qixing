package com.dream.qixing.control.action.bicycleteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.model.bicycleteam.Activity;

@ApiAction("bicycle.activity.list")
public class QueryActivityListAction extends BaseAction {

    private String activityName;
    @ApiField("page_index")
    private int pageIndex;
    @ApiField("total_page")
    private int totalPage;

    @ApiListField("activities")
    @ApiField("activity")
    private List<Activity> activities;

    public String execute() {
        if(this.getUserId() == null){
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("目前没有报名的活动，请您自己创建活动吧！");
            return "";
        }
        pageIndex= pageIndex+1;
        totalPage =10;
        activities = new ArrayList<Activity>();
        Activity activity = new Activity();
        activity.setActivityId(100001);
        activity.setActivityName("昌平一日游");
        activity.setMeetAddress("北京市昌平区");
        activity.setPrompt("剩余2天2小时");
        activity.setActivityStatus(1);
        activity.setStatusName("报名中");
        activity.setPeopleNum(100);
        activity.setAmount(50);
        activity.setActivityType(0);
        activity.setMileage(14.46);
        activity.setBeginTime(new Date());
        activities.add(activity);
        Activity activity1 = new Activity();
        activity1.setActivityId(100002);
        activity1.setActivityName("昌平一日游");
        activity1.setMeetAddress("北京市昌平区");
        activity1.setPrompt("剩余3天2小时");
        activity1.setActivityStatus(1);
        activity1.setStatusName("报名中");
        activity1.setPeopleNum(100);
        activity1.setAmount(50);
        activity1.setActivityType(0);
        activity1.setMileage(14.46);
        activity1.setBeginTime(new Date());
        activities.add(activity1);

        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("搜索成功！");


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

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
