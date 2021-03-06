package com.dream.qixing.control.action.qixing;

import java.util.ArrayList;
import java.util.List;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.qixing.TeamTrace;

@ApiAction(value = "cyc.location")
public class ShowTeamLocationAction extends BaseAction {

    private Integer activityId;
    private String locationLon;
    private String locationLat;
    private String speed;
    @ApiListField("traces")
    @ApiField("trace")
    List<TeamTrace> traces = new ArrayList<TeamTrace>();
    ;

    public String execute() {
        //只能同一时间参加一个活动Id
        String activityUserIds = getActivityUserByActivityId(1000);
        String[] userIds = activityUserIds.split(",");
        for (String u : userIds) {
            if (Integer.parseInt(u) == this.getUserId()) {
                //修改自己的坐标位置
            }else{
                TeamTrace t = getUserTrace(Integer.parseInt(u));
                traces.add(t);
            }
        }
        if (traces.size() > 0) {
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("成功！");
            this.setUserId(this.getUserId());
        } else {
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("系统错误");
        }
        return "";
    }

    private String getActivityUserByActivityId(Integer activityId) {
        return "10000,10001,10002";
    }

    private TeamTrace getUserTrace(int userId) {
        //redis获取json 转对象
        TeamTrace trace = new TeamTrace();
        trace.setUserId(userId);
        trace.setLocationX("1232,33");
        trace.setLocationY("123.5566");
        trace.setRoleCode(0);//队长
        trace.setSpeed("10.5km");
        trace.setNickName("骆驼");
        return trace;
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(String locationLon) {
        this.locationLon = locationLon;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public List<TeamTrace> getTraces() {
        return traces;
    }

    public void setTraces(List<TeamTrace> traces) {
        this.traces = traces;
    }

}
