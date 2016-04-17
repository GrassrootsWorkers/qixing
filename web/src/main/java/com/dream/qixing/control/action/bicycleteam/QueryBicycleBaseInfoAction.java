package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycleteam.BicycleTeam;

@ApiAction("bicycle.team.baseInfo")
public class QueryBicycleBaseInfoAction extends BaseAction {
      private Integer bicycleId;

    @ApiField("bicycle_team")
    private BicycleTeam bicycleTeam;

    public String execute() {
        bicycleTeam = new BicycleTeam();
        bicycleTeam.setCycId(bicycleId);
        bicycleTeam.setPersonLimit(500);
        bicycleTeam.setAmount(200);
        bicycleTeam.setCycTeamLogo("http://p1.dream.com/1000/b_100000.jpg");
        bicycleTeam.setMobile("18618102693");
        bicycleTeam.setAllowUnknown("Y");
        bicycleTeam.setClubAddress("北京市昌平区南邵镇");
        bicycleTeam.setClubDesc("如果你无法简洁的表达你的想法，那只说明你还不够了解它。 -- 阿尔伯特·爱因斯坦");
        bicycleTeam.setClubName("夕阳红车队");
        bicycleTeam.setCreateName("刘先生");
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("获取基本信息成功！");

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
