package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.model.bicycleteam.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiAction("bicycle.team.history.activity")
public class QueryTeamActivityHistoryAction extends BaseAction {
    private Integer bicycleId;
    @ApiField("page_index")
    private Integer pageIndex = 1;
    @ApiListField("activities")
    @ApiField("activity")
    private List<Activity> activities;
    @ApiField("total_page")
    private int totalPage;
    @Override
    public String execute() {
        if (bicycleId > 0) {
            pageIndex = pageIndex+1;
            totalPage = 10;
            activities = new ArrayList<Activity>();
            Activity activity = new Activity();
            activity.setActivityName("昌平--八达岭");
            activity.setMeetAddress("昌平地铁站");
            activity.setBeginTime(new Date());
            //activity.setEndTime(new Date());
            activity.setAmount(100);
            activity.setActivityId(10000);
            activities.add(activity);
            activities.add(activity);
            activities.add(activity);
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("查询成功！");
            return "";
        } else {
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("系统异常！");
            return "";
        }
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }
}
