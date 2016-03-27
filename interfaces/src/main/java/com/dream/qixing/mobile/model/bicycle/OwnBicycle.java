package com.dream.qixing.mobile.model.bicycle;

import com.dream.qixing.mobile.mapping.ApiField;

import java.io.Serializable;
import java.util.Date;

public class OwnBicycle implements Serializable {

    @ApiField("bicycle_number")
    private Integer Id;

    @ApiField("own_user")
    private Integer userId;
    @ApiField("brand_id")
    private Integer brandId;
    @ApiField("brand_name")
    private String brandName;
    @ApiField("series_id")
    private Integer seriesId;
    @ApiField("series_name")
    private String seriesName;
    @ApiField("bicycle_mark")
    private String bicycleNumber;
    @ApiField("buy_time")
    private Date buyTime;
    @ApiField("price")
    private Double price;
    @ApiField("if_assembly")
    private String ifAssembly;
    @ApiField("if_public")
    private String ifPublic;
    @ApiField("dep_rate")
    private Integer depreciationRate;

    private Date inputTime;
    @ApiField("main_image")
    private String mainImage;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBicycleNumber() {
        return bicycleNumber;
    }

    public void setBicycleNumber(String bicycleNumber) {
        this.bicycleNumber = bicycleNumber == null ? null : bicycleNumber.trim();
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIfAssembly() {
        return ifAssembly;
    }

    public void setIfAssembly(String ifAssembly) {
        this.ifAssembly = ifAssembly == null ? null : ifAssembly.trim();
    }

    public String getIfPublic() {
        return ifPublic;
    }

    public void setIfPublic(String ifPublic) {
        this.ifPublic = ifPublic == null ? null : ifPublic.trim();
    }

    public Integer getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Integer depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", bicycleNumber=").append(bicycleNumber);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", price=").append(price);
        sb.append(", ifAssembly=").append(ifAssembly);
        sb.append(", ifPublic=").append(ifPublic);
        sb.append(", depreciationRate=").append(depreciationRate);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}