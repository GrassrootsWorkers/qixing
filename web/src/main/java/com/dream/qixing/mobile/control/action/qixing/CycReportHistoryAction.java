package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.qixing.CycReport;

import java.util.ArrayList;
import java.util.List;

@ApiAction(value = "cyc.report.history")
public class CycReportHistoryAction extends BaseAction {

	private int userNumber;

	@ApiListField("reports")
	@ApiField("report")
	private List<CycReport> reportList;
	
	public String execute() {
		if(userNumber > 0){
			reportList = new ArrayList<CycReport>();
			CycReport report = new CycReport();
			report.setCysReportId(10000);
			report.setRoadBookId(10000);
			report.setQxName("昌平-八达岭");
			report.setMileage(12.34);
			report.setTimeConsume("12:23:23");
			report.setTraceImage("http://p1.qixing.com/10000/10000.jpg");
			reportList.add(report);
			CycReport report1 = new CycReport();
			report1.setRoadBookId(10000);
			report1.setCysReportId(10001);
			report1.setQxName("昌平-八达岭");
			report1.setMileage(12.34);
			report1.setTimeConsume("12:23:23");
			report1.setTraceImage("http://p1.qixing.com/10000/10000.jpg");
			reportList.add(report1);
			//保存到数据库
			this.setIsSuccessful(true);
			this.setStatusCode(200);
			this.setUserId(this.getUserId());
		}else{
			//保存到数据库
			this.setIsSuccessful(false);
			this.setStatusCode(400);
			this.setUserId(1000);
			this.setDescription("还没有骑行记录！");
		}


		return "";
	}

	@Override
	public String getResponseName() {
		return null;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public List<CycReport> getReportList() {
		return reportList;
	}

	public void setReportList(List<CycReport> reportList) {
		this.reportList = reportList;
	}
}
