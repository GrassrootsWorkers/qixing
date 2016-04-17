package com.dream.qixing.control.action.bicycle;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.bicycle.BicycleBrand;
import com.dream.qixing.model.bicycle.BicycleSeries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/27 0027.
 */
@ApiAction("bicycle.brands")
public class QueryBicycleBrandAction extends BaseAction {

    @ApiListField("brands")
    @ApiField("brand")
    private List<BicycleBrand> brands;

    @Override
    public String execute() {
        if (this.getUserId() == null) {
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("系统繁忙");
            return "";
        }
        brands = new ArrayList<BicycleBrand>();
        BicycleBrand brand = new BicycleBrand();
        brand.setBrandId(1000);
        brand.setBrandName("捷安特");
        brand.setSeriesList(getSeries(1000));
        brands.add(brand);
        BicycleBrand brand1 = new BicycleBrand();
        brand1.setBrandId(1001);
        brand1.setBrandName("捷安特");
        brand1.setSeriesList(getSeries(1001));
        brands.add(brand1);
        BicycleBrand brand2 = new BicycleBrand();
        brand2.setBrandId(1002);
        brand2.setBrandName("捷安特");
        brand2.setSeriesList(getSeries(1002));
        brands.add(brand2);
        BicycleBrand brand3 = new BicycleBrand();
        brand3.setBrandId(1003);
        brand3.setBrandName("捷安特");
        brand3.setSeriesList(getSeries(1003));
        brands.add(brand3);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功！");
        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    private List<BicycleSeries> getSeries(int brandId) {
    List<BicycleSeries> seriesList  = new ArrayList<BicycleSeries>();
        BicycleSeries series = new BicycleSeries();
        series.setBrandId(brandId);
        series.setSeriesId(brandId+1);
        series.setSeriesName("JATXT"+brandId+1);
        seriesList.add(series);
        BicycleSeries series1 = new BicycleSeries();
        series1.setBrandId(brandId);
        series1.setSeriesId(brandId+1);
        series1.setSeriesName("JATXT"+brandId+2);
        seriesList.add(series1);
        return seriesList;
    }

}
