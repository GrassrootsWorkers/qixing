package com.dream.qixing.mobile.control.action.bicycle;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.bicycle.OwnBicycle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/27 0027.
 */
@ApiAction("bicycle.myBicycle")
public class QueryMyBicycleAction extends BaseAction {

    @ApiField("page_index")
    private int pageIndex;
    @ApiField("total_page")
    private int totalPage;
    @ApiListField("bicycles")
    @ApiField("bicycle")
    private List<OwnBicycle> bicycleList ;

    @Override
    public String execute(){
        if(this.getUserId() == null){
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("您还没录入您的爱车信息，请点击\"添加\"按钮进行添加");
            return "";
        }
        pageIndex = pageIndex+1;
        totalPage = 10;
        bicycleList = new ArrayList<OwnBicycle>();
        OwnBicycle bicycle = new OwnBicycle();
        bicycle.setId(10001);
        bicycle.setUserId(this.getUserId());
        bicycle.setBrandId(1000);
        bicycle.setBrandName("捷安特");
        bicycle.setSeriesId(10001);
        bicycle.setSeriesName("XT001");
        bicycle.setBicycleNumber("12345565654");
        bicycle.setMainImage("http://p1.qixing.com/bicycle/10000.jpg");
        bicycle.setBuyTime(new Date());
        bicycleList.add(bicycle);
        OwnBicycle bicycle1 = new OwnBicycle();
        bicycle1.setId(10001);
        bicycle1.setUserId(this.getUserId());
        bicycle1.setBrandId(1000);
        bicycle1.setBrandName("捷安特");
        bicycle1.setSeriesId(10001);
        bicycle1.setSeriesName("XT001");
        bicycle1.setBicycleNumber("12345565654");
        bicycle1.setMainImage("http://p1.qixing.com/bicycle/10000.jpg");
        bicycle1.setBuyTime(new Date());
        bicycleList.add(bicycle1);
        bicycle.setDepreciationRate(1);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功！");
        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
