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

    @ApiField("bicycle_team")
    private BicycleTeam bicycleTeam;

    public String execute() {
        bicycleTeam = new BicycleTeam();
        bicycleTeam.setCycId(bicycleId);
        bicycleTeam.setCycTeamLogo("http://qixing.com/imgage.jpg");
        bicycleTeam.setAmount(100);
        bicycleTeam.setPersonLimit(500);
        bicycleTeam.setClubName("夕阳红");
        bicycleTeam.setCreateTime(new Date());
        bicycleTeam.setClubDesc("快乐健康！");
        bicycleTeam.setClubAddress("北京市昌平区南邵镇");
        bicycleTeam.setCreateName("刘先生");

        List<Friend> friends = new ArrayList<Friend>();
        Friend f = new Friend();
        f.setImage("http://p1.qixing.com/1000/1000.jpg");
        f.setUserId(1000);
        f.setNickName("天空的云");
        f.setLocation("北京市海淀区");
        friends.add(f);
        Friend f1 = new Friend();
        f1.setImage("http://p1.qixing.com/1000/1000.jpg");
        f1.setUserId(1000);
        f1.setNickName("天空的云");
        f1.setLocation("北京市海淀区");
        friends.add(f1);
        List<Activity> activitys = new ArrayList<Activity>();
        Activity act = new Activity();
        act.setActivityId(1000);
        act.setActivityName("昌平一日游");
        act.setActivityDesc("昌平一日游");
        act.setBeginTime(new Date());
        act.setEndTime(new Date());
        act.setApplyEndTime(new Date());
        act.setActivityAddress("北京市昌平区昌平小学");
        act.setPeopleNum(100);
        act.setAmount(60);
        activitys.add(act);
        bicycleTeam.setActivitys(activitys);
        bicycleTeam.setFriends(friends);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功！");

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
