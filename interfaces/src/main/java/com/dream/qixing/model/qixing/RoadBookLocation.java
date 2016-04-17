package com.dream.qixing.model.qixing;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mapping.ApiField;

public class RoadBookLocation implements Serializable {
    private Integer xyzId;

    @ApiField("location_name")
    private String xyzName;

    private Date createTime;

    private Integer roadBookId;
    
    @ApiField("location_lon")
    private String locationX;
    @ApiField("location_lot")
    private String locationY;
    @ApiField("location_alt")
    private String locationZ;

    private static final long serialVersionUID = 1L;

    public Integer getXyzId() {
        return xyzId;
    }

    public void setXyzId(Integer xyzId) {
        this.xyzId = xyzId;
    }

    public String getXyzName() {
        return xyzName;
    }

    public void setXyzName(String xyzName) {
        this.xyzName = xyzName == null ? null : xyzName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getLocationZ() {
        return locationZ;
    }

    public void setLocationZ(String locationZ) {
        this.locationZ = locationZ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xyzId=").append(xyzId);
        sb.append(", xyzName=").append(xyzName);
        sb.append(", createTime=").append(createTime);
        sb.append(", roadBookId=").append(roadBookId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}