package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycleteam.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiAction("bicycle.myActivity.list")
public class QueryMyCreateActivityListAction extends BaseAction {
    @ApiField("page_index")
    private int pageIndex;
    @ApiField("total_page")
    private int totalPage;
    @ApiListField("activities")
    @ApiField("activity")
    private List<Activity> activities;

    @Override
    public String execute() {
        if(this.getUserId() == null){
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("您还没创建活动，请点击\"创建按钮\"进行创建！");
            return "";
        }
        pageIndex= pageIndex+1;
        totalPage =10;
        activities = new ArrayList<Activity>();
        Activity activity = new Activity();
        activity.setBeginTime(new Date());
        activity.setActivityId(10001);
        activity.setActivityName("昌平一日游");
        activity.setMeetAddress("北京市昌平区");
        /**
         * 0：活动刚创建，1：活动通过审核开始报名，2活动结束报名，3活动进行中 4 活动结束
         */
        activity.setActivityStatus(0);
        activity.setStatusName("刚创建");
        activity.setActivityType(1);
        activity.setPeopleNum(100);
        activity.setAmount(50);
        activity.setMileage(14.46);
        activities.add(activity);
        Activity activity1 = new Activity();
        activity1.setBeginTime(new Date());
        activity1.setActivityId(10002);
        activity1.setActivityName("昌平一日游");
        activity1.setMeetAddress("北京市昌平区");
        activity1.setActivityStatus(1);
        activity1.setStatusName("报名中");
        activity1.setPeopleNum(100);
        activity1.setAmount(50);
        activity1.setActivityType(1);
        activity1.setMileage(14.46);
        activities.add(activity1);

        Activity activity3 = new Activity();
        activity3.setBeginTime(new Date());
        activity3.setActivityId(10003);
        activity3.setActivityName("昌平一日游");
        activity3.setMeetAddress("北京市昌平区");
        activity3.setActivityStatus(3);
        activity3.setStatusName("进行中");
        activity3.setPeopleNum(100);
        activity3.setAmount(50);
        activity3.setActivityType(1);
        activity3.setMileage(14.46);
        activities.add(activity3);
        Activity activity4 = new Activity();
        activity4.setBeginTime(new Date());
        activity4.setActivityId(10004);
        activity4.setActivityName("昌平一日游");
        activity4.setMeetAddress("北京市昌平区");
        activity4.setActivityStatus(4);
        activity4.setStatusName("活动结束");
        activity4.setPeopleNum(100);
        activity4.setAmount(50);
        activity4.setActivityType(1);
        activity4.setMileage(14.46);
        activities.add(activity4);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功");

        return "";
    }

    @Override
    public String getResponseName() {

        return null;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

}
