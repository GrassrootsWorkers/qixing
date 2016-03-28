package com.dream.qixing.mobile.control.action.bicycle;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

/**
 * Created by Administrator on 2016/3/27 0027.
 */
@ApiAction("bicycle.update")
public class UpdateBicycleAction extends BaseAction {

    @ApiField("bicycle_number")
    private Integer bicycleNumber;
    private String brandId;
    private String seriesId;
    private String bicycleMark;
    private String buyTime;
    private String depRat;
    private String ifAssembly;
    private String ifPublic;
    private double price;
    private String images;

    @Override
    public String execute(){
        if (this.getUserId() == null) {
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("系统繁忙");
            return "";
        }else{
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("修改成功！");
        }
        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getBicycleNumber() {
        return bicycleNumber;
    }

    public void setBicycleNumber(Integer bicycleNumber) {
        this.bicycleNumber = bicycleNumber;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getBicycleMark() {
        return bicycleMark;
    }

    public void setBicycleMark(String bicycleMark) {
        this.bicycleMark = bicycleMark;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getDepRat() {
        return depRat;
    }

    public void setDepRat(String depRat) {
        this.depRat = depRat;
    }

    public String getIfAssembly() {
        return ifAssembly;
    }

    public void setIfAssembly(String ifAssembly) {
        this.ifAssembly = ifAssembly;
    }

    public String getIfPublic() {
        return ifPublic;
    }

    public void setIfPublic(String ifPublic) {
        this.ifPublic = ifPublic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
