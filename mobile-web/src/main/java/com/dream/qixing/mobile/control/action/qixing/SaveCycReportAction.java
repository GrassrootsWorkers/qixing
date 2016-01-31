package com.dream.qixing.mobile.control.action.qixing;

import java.util.Date;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

@ApiAction(value = "cyc.report.add")
public class SaveCycReportAction extends BaseAction {

	private Integer reportId;

	private String userId;

	private String qxName;

	private Date startTime;

	private String gpsStrs;

	private Integer difficultyDeg;

	private String averageSpeed;

	private String highestSpeed;

	private String lowestSpeed;

	private String timeConsume;

	private String caloricValue;

	private Integer roadBookId;
	//爬升高度
	private String height;
	
	public String execute() {
		//保存到数据库
		this.setIssuccessful(true);
		this.setStatuscode(200);
		this.setUserId(userId);
		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
