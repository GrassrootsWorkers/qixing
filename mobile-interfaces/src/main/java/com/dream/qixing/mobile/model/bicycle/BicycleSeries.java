package com.dream.qixing.mobile.model.bicycle;

import java.io.Serializable;
import java.util.Date;

public class BicycleSeries implements Serializable {
    private Integer serieId;

    private Integer brandId;

    private Date inputTime;

    private Integer status;

    private String serieName;

    private static final long serialVersionUID = 1L;

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

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

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName == null ? null : serieName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serieId=").append(serieId);
        sb.append(", brandId=").append(brandId);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", status=").append(status);
        sb.append(", serieName=").append(serieName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}