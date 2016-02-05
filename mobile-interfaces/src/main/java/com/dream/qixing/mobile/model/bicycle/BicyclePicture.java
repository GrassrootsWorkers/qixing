package com.dream.qixing.mobile.model.bicycle;

import java.io.Serializable;
import java.util.Date;

public class BicyclePicture implements Serializable {
    private Integer id;

    private String bigPic;

    private String centerPic;

    private String smallPic;

    private Integer bicycleId;

    private Date inputTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    public String getCenterPic() {
        return centerPic;
    }

    public void setCenterPic(String centerPic) {
        this.centerPic = centerPic == null ? null : centerPic.trim();
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
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
        sb.append(", id=").append(id);
        sb.append(", bigPic=").append(bigPic);
        sb.append(", centerPic=").append(centerPic);
        sb.append(", smallPic=").append(smallPic);
        sb.append(", bicycleId=").append(bicycleId);
        sb.append(", inputTime=").append(inputTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}