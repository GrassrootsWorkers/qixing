package com.dream.qixing.model.bicycle;

import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.mapping.ApiField;

import java.io.Serializable;
import java.util.List;

public class BicycleBrand implements Serializable {
    @ApiField("brand_id")
    private Integer brandId;
    @ApiField("brand_name")
    private String brandName;

    private String brandStory;

    private String brandDesc;

    private Integer peopleNumber;

    /**
     * 0：停用1：启用
     */
    private Integer status;
    @ApiListField("brand_series")
    @ApiField("series")
    private List<BicycleSeries> seriesList;

    private static final long serialVersionUID = 1L;

    public List<BicycleSeries> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<BicycleSeries> seriesList) {
        this.seriesList = seriesList;
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
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory == null ? null : brandStory.trim();
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc == null ? null : brandDesc.trim();
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", brandId=").append(brandId);
        sb.append(", brandName=").append(brandName);
        sb.append(", brandStory=").append(brandStory);
        sb.append(", brandDesc=").append(brandDesc);
        sb.append(", peopleNumber=").append(peopleNumber);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}