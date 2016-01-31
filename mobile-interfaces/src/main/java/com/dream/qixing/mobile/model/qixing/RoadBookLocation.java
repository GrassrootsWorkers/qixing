package com.dream.qixing.mobile.model.qixing;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mobile.mapping.ApiField;

public class RoadBookLocation implements Serializable {
    private Integer xyzId;

    @ApiField("location_name")
    private String xyzName;

    @ApiField("location")
    private String xyz;

    private Date createTime;

    private Integer roadBookId;
    
    @ApiField("location_x")
    private Double locationX;
    @ApiField("location_y")
    private Double locationY;
    @ApiField("location_z")
    private Double locationZ;

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

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz == null ? null : xyz.trim();
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

    
    public Double getLocationX() {
		return locationX;
	}

	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}

	public Double getLocationY() {
		return locationY;
	}

	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}

	public Double getLocationZ() {
		return locationZ;
	}

	public void setLocationZ(Double locationZ) {
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
        sb.append(", xyz=").append(xyz);
        sb.append(", createTime=").append(createTime);
        sb.append(", roadBookId=").append(roadBookId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}