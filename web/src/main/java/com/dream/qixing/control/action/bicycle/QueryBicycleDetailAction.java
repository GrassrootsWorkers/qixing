package com.dream.qixing.control.action.bicycle;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycle.OwnBicycle;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/27 0027.
 */
@ApiAction("bicycle.detail")
public class QueryBicycleDetailAction extends BaseAction {

    private int bicycleNumber;
    @ApiField("bicycle")
    private OwnBicycle bicycle;

    @Override
    public String execute(){
        if(bicycleNumber >0){
            bicycle = new OwnBicycle();
            bicycle.setId(10001);
            bicycle.setUserId(this.getUserId());
            bicycle.setBrandId(1000);
            bicycle.setBrandName("捷安特");
            bicycle.setSeriesId(10001);
            bicycle.setSeriesName("XT001");
            bicycle.setBicycleNumber("12345565654");
            bicycle.setImages("http://p1.qixing.com/bicycle/10000.jpg;http://p1.qixing.com/bicycle/10000.jpg");
            bicycle.setBuyTime(new Date());
            bicycle.setDepreciationRate(9);
            bicycle.setPrice(500.00);
            bicycle.setIfAssembly("N");
            bicycle.setIfPublic("Y");
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("查询成功！");

        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("您要查的东西不存在！");
        }

        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public int getBicycleNumber() {
        return bicycleNumber;
    }

    public void setBicycleNumber(int bicycleNumber) {
        this.bicycleNumber = bicycleNumber;
    }

    public OwnBicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(OwnBicycle bicycle) {
        this.bicycle = bicycle;
    }
}
