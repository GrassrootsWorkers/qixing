package com.dream.qixing.mobile.model.qixing;

import java.io.Serializable;

public class CycEssay implements Serializable {
    private Integer essaysId;

    private String description;

    private Integer cysReportId;

    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public Integer getEssaysId() {
        return essaysId;
    }

    public void setEssaysId(Integer essaysId) {
        this.essaysId = essaysId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCysReportId() {
        return cysReportId;
    }

    public void setCysReportId(Integer cysReportId) {
        this.cysReportId = cysReportId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", essaysId=").append(essaysId);
        sb.append(", description=").append(description);
        sb.append(", cysReportId=").append(cysReportId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}