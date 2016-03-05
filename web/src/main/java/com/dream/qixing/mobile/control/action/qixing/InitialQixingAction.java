package com.dream.qixing.mobile.control.action.qixing;

import java.util.ArrayList;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.qixing.RoadBook;
import com.dream.qixing.mobile.model.qixing.RoadBookLocation;

@ApiAction(value="cyc.start")
public class InitialQixingAction extends BaseAction {

	//创建的骑行报告Id
	@ApiField("reportId")
	private int cycReportId;
	@ApiField("ifteam")
	private String ifTeam;
	@ApiField("activityId")
	private Integer activityId;

	@ApiField("roadbook")
	private RoadBook roadBook;
	@Override
	public String execute(){
		roadBook = new RoadBook();
		roadBook.setBeginX("123.44");
		roadBook.setBeginY("123.44");
		roadBook.setEndX("123.56");
		roadBook.setEndY("123.56");
		cycReportId = 1000;
		ifTeam ="N";
		List<RoadBookLocation> locations = new ArrayList<RoadBookLocation>(); 
		RoadBookLocation location = new RoadBookLocation();
		location.setRoadBookId(1);
		//location.setXyz("123.67");
		location.setLocationX("1234.666666");
		location.setLocationY("1234.666666");
		//location.setLocationX(1234.666666);
		location.setXyzName("北京西站");
		locations.add(location);
		RoadBookLocation location1 = new RoadBookLocation();
		location1.setRoadBookId(1);
		//location1.setXyz("233.66");
		location1.setXyzName("北京西站");
		location1.setLocationX("1234.666666");
		location1.setLocationY("1234.666666");
		locations.add(location1);
		this.setIsSuccessful(true);
		this.setStatusCode(200);
		this.setUserId(10000);
		activityId =10000;
		
		roadBook.setLocations(locations);
		
		return "";
		
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
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

	public RoadBook getRoadBook() {
		return roadBook;
	}

	public void setRoadBook(RoadBook roadBook) {
		this.roadBook = roadBook;
	}
}
