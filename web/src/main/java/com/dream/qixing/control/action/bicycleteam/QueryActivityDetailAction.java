package com.dream.qixing.control.action.bicycleteam;


import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycleteam.Activity;

import java.util.Date;

@ApiAction("bicycle.activity.detail")
public class QueryActivityDetailAction extends BaseAction {

    private int activityId;

    @ApiField("activity")
    private Activity activity ;
    @Override
    public String execute(){
        if(activityId >0){
            activity = new Activity();
            activity.setActivityId(10000);
            activity.setActivityName("昌平一日游");
            activity.setActivityDesc("途径-----长城");
            activity.setBeginTime(new Date());
            activity.setEndTime(new Date());
            activity.setApplyEndTime(new Date());
            activity.setRoadBookId(11);
            activity.setRoadBookName("骑行");
            activity.setPeopleNum(100);
            activity.setExpenses(50.00);
            activity.setIfMustJoinTeam("N");
            activity.setMeetAddress("北京市昌平区");
            activity.setActivityStatus(3);
            activity.setStatusName("进行中");
            activity.setImages("http://p1.qixing.com/1110/1.jpg;http://p1.qixing.com/1110/2.jpg");
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("查询成功！");
        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("不存在该活动");

        }

        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
