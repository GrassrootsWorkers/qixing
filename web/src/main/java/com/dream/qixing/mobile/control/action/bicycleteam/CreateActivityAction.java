package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.Date;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

@ApiAction("bicycle.team.activity")
public class CreateActivityAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ApiField("bicycle_id")
	private Integer bicycleId;
	@ApiField("activity_id")
	private Integer activityId;

	private String activityDesc;

	private Date beginTime;

	private Date endTime;

	private Date applyEndTime;

	private Integer roadBookId;

	private String roleNumber;

	private Integer peopleNumber;
	//是否群发队友
	private String ifMass;

	private String allowUnknow;

	private Double applyFee;
	private String meetAddress;
	//活动上传的图片串
	private String images;

	public String execute() {
		this.activityId = 1000;
		this.bicycleId = 1000;
		this.setIssuccessful(true);
		this.setStatuscode(200);
		this.setDescription("创建活动成功");
		this.setUserId("1000");

		return "";
	}

	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
