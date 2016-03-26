package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

import java.util.Date;

@ApiAction(value = "cyc.trace.pause")
public class PauseRecordTraceAction extends BaseAction {

	private Integer reportId;
	private Integer activityId;
	private String traces;
	private Date pauseTime;

	public String execute() {
		if(reportId == 0){
			//保存到数据库
			this.setIsSuccessful(false);
			this.setStatusCode(500);
			this.setUserId(1000);
			this.setDescription("系统异常！");
		}else{
			//保存到数据库
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setUserId(1000);
			this.setDescription("保存成功！");
		}

		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getTraces() {
		return traces;
	}

	public void setTraces(String traces) {
		this.traces = traces;
	}

	public Date getPauseTime() {
		return pauseTime;
	}

	public void setPauseTime(Date pauseTime) {
		this.pauseTime = pauseTime;
	}
}
