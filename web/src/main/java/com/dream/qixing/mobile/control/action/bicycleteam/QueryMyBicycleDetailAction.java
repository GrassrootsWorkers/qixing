package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;

import java.util.Date;

@ApiAction("bicycle.myTeam.detail")
public class QueryMyBicycleDetailAction extends BaseAction {

    @ApiField("bicycle_team")
    private BicycleTeam bicycleTeam;

    public String execute() {
        if(this.getUserId() == null){
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("您还没创建车队请先创建车队！");
            return"";
        }else{
            bicycleTeam = new BicycleTeam();
            bicycleTeam.setUserId(this.getUserId());
            bicycleTeam.setCycId(10000);
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
            this.setDescription("查看我的车队信息成功！");
            return"";
        }

    }

    @Override
    public String getResponseName() {
        // TODO Auto-generated method stub
        return null;
    }

}
