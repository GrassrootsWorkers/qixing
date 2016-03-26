package com.dream.qixing.mobile.control.action.qixing;

import java.util.ArrayList;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.qixing.RoadBook;
import com.dream.qixing.mobile.model.qixing.RoadBookLocation;

@ApiAction(value="cyc.start")
public class InitialQixingAction extends BaseAction {

	//创建的骑行报告Id
	@ApiField("report_id")
	private Integer cycReportId;
	@ApiField("if_team")
	private String ifTeam;
	@ApiField("activity_id")
	private Integer activityId;

	@ApiField("road_book_id")
	private Integer roadBookId;
	@ApiListField("locations")
	@ApiField("location")
	private List<RoadBookLocation> locations;
	@Override
	public String execute(){
		if(this.getUserId() ==null){
			this.setIsSuccessful(true);
			this.setStatusCode(501);
			this.setDescription("用户请登录！");
		}else{
			try{
				activityId =10000;
				cycReportId = 1000;
				ifTeam ="Y";
				roadBookId =1000001;
				locations = new ArrayList<RoadBookLocation>();
				RoadBookLocation location = new RoadBookLocation();
				location.setRoadBookId(1);
				location.setLocationX("1234.666666");
				location.setLocationY("1234.666666");
				location.setXyzName("北京西站");
				locations.add(location);
				RoadBookLocation location1 = new RoadBookLocation();
				location1.setRoadBookId(1);
				location1.setXyzName("北京西站");
				location1.setLocationX("1234.666666");
				location1.setLocationY("1234.666666");
				locations.add(location1);
				this.setIsSuccessful(true);
				this.setStatusCode(200);
				this.setUserId(10000);
				this.setDescription("初始化成功！");
			}catch (Exception e){
				this.setIsSuccessful(false);
				this.setStatusCode(500);
				this.setUserId(null);
				this.setDescription("系统异常！");
			}
		}
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRoadBookId() {
		return roadBookId;
	}

	public void setRoadBookId(Integer roadBookId) {
		this.roadBookId = roadBookId;
	}

	public List<RoadBookLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<RoadBookLocation> locations) {
		this.locations = locations;
	}

	public int getCycReportId() {
		return cycReportId;
	}

	public void setCycReportId(int cycReportId) {
		this.cycReportId = cycReportId;
	}

	public String getIfTeam() {
		return ifTeam;
	}

	public void setIfTeam(String ifTeam) {
		this.ifTeam = ifTeam;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}
