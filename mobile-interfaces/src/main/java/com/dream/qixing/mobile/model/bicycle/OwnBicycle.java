package com.dream.qixing.mobile.model.bicycle;

import java.io.Serializable;
import java.util.Date;

public class OwnBicycle implements Serializable {
    private Integer bicycleId;

    private Integer userId;

    private Integer brand;

    private Integer version;

    private String bicycleNumber;

    private Date buyTime;

    private Double price;

    private String ifAssembly;

    private String ifPublic;

    private Integer depreciationRate;

    private Date inputTime;

    private static final long serialVersionUID = 1L;

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
        sb.append(", bicycleId=").append(bicycleId);
        sb.append(", userId=").append(userId);
        sb.append(", brand=").append(brand);
        sb.append(", version=").append(version);
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