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
      private Integer bicycleId;

    @ApiField("team")
    private BicycleTeam bicycleTeam;

    public String execute() {
        bicycleTeam = new BicycleTeam();
        bicycleTeam.setPersonLimit(500);
        bicycleTeam.setAmount(200);
        List<Friend> friends = new ArrayList<Friend>();
        Friend f = new Friend();
        f.setUserId(1000);
        f.setNickName("天空的云");
        friends.add(f);
        Friend f1 = new Friend();
        f1.setUserId(1001);
        f1.setNickName("天空的云");
        friends.add(f1);
        List<Activity> activitys = new ArrayList<Activity>();
        Activity act = new Activity();
        act.setActivityId(1000);
        act.setActivityName("昌平一日游");
        act.setActivityDesc("昌平一日游");
        act.setBeginTime(new Date());
        act.setEndTime(new Date());
        act.setApplyEndTime(new Date());
        act.setActivityAddress("北京昌平");
        act.setPeopleNum(100);
        act.setAmount(60);
        activitys.add(act);
        bicycleTeam.setActivitys(activitys);
        bicycleTeam.setFriends(friends);

        return "";
    }

    @Override
    public String getResponseName() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }
}
