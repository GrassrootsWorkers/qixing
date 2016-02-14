package com.dream.qixing.mobile.control.action.qixing;

import java.util.ArrayList;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.qixing.TeamTrace;

@ApiAction(value="cyc.location")
public class ShowTeamLocationAction extends BaseAction{
	
	private Integer activityId;
	private String userId;
	
	private String locationLon;
	private String locationLat;
	private String speed;
	@ApiListField("traces")
	@ApiField("trace")
	List<TeamTrace> traces = new ArrayList<TeamTrace>();;
	public String execute(){
		
		//只能同一时间参加一个活动Id
		String activityUserIds = getActivityUserByActivityId(1000);
		String[] userIds = activityUserIds.split(",");
		for(String u: userIds){
			if(u.equals(userId)){
				//修改该用户中的值
				
			}else{
				TeamTrace t = getUserTrace(u);
				traces.add(t);
			}
		}
		
		if(traces.size() >0){
			this.setIssuccessful(true);
			this.setStatuscode(200);
			this.setUserId(userId);
		}else{
			this.setIssuccessful(false);
			this.setStatuscode(500);
			this.setDescription("系统错误");
		}
		return "";
	}

	private String getActivityUserByActivityId(Integer activityId){
		return "1000,1001,1002";
	}
	private TeamTrace getUserTrace(String userId){
		//redis获取json 转对象
		TeamTrace trace = new TeamTrace();
		trace.setLocationX("1232,33");
		trace.setLocationY("123.5566");
		trace.setRoleCode(1);//队长
		trace.setSpeed("10.5km");
		trace.setNickName("骆驼");
		return trace;
	}
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
