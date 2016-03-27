package com.dream.qixing.mobile.model.bicycle;

import com.dream.qixing.mobile.mapping.ApiField;

import java.io.Serializable;
import java.util.Date;

public class BicycleSeries implements Serializable {
    @ApiField("series_id")
    private Integer seriesId;
    @ApiField("series_name")
    private String seriesName;
    @ApiField("brand_id")
    private Integer brandId;

    private Date inputTime;

    private Integer status;



    private static final long serialVersionUID = 1L;



    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", brandId=").append(brandId);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}