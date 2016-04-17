package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycleteam.BicycleTeam;

import java.util.Date;

@ApiAction("bicycle.team.detail")
public class QueryBicycleDetailAction extends BaseAction {
    private Integer bicycleId;

    @ApiField("bicycle_team")
    private BicycleTeam bicycleTeam;

    public String execute() {
        bicycleTeam = new BicycleTeam();
        if(this.getUserId()== null){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("系统异常");
            return"";
        }else{
            bicycleTeam.setUserId(10001);
            bicycleTeam.setCycId(bicycleId);
            bicycleTeam.setCycTeamLogo("http://qixing.com/imgage.jpg");
            bicycleTeam.setPurpose("快乐健身，传递快乐");
            bicycleTeam.setAmount(100);
            bicycleTeam.setPersonLimit(500);
            bicycleTeam.setClubName("夕阳红");
            bicycleTeam.setCreateTime(new Date());
            bicycleTeam.setClubDesc("快乐健康！");
            bicycleTeam.setClubAddress("北京市昌平区南邵镇");
            bicycleTeam.setAllowUnknown("N");
            bicycleTeam.setCreateName("刘先生");
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("获取车队信息成功！");
            return"";
        }

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
