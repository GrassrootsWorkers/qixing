package com.dream.qixing.mobile.model.qixing;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;

public class RoadBook implements Serializable {
	@ApiField("road_book_id")
    private Integer roadBookId;

    private String creater;

    private Integer activityId;

    private Integer allDistance;

    private Integer estimatedTime;

    private Integer difficulty;

    private Integer status;
    
    @ApiField("begin_lon")
    private String beginX;
    @ApiField("begin_lat")
    private String beginY;
    @ApiField("end_lon")
    private String endX;
    @ApiField("end_lat")
    private String endY;

    private Date createTime;

    @ApiListField("locations")
    @ApiField("location")
    private List<RoadBookLocation> locations;
    
    public List<RoadBookLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<RoadBookLocation> locations) {
		this.locations = locations;
	}

	private static final long serialVersionUID = 1L;

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getAllDistance() {
        return allDistance;
    }

    public void setAllDistance(Integer allDistance) {
        this.allDistance = allDistance;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

   

    public String getBeginX() {
		return beginX;
	}

	public void setBeginX(String beginX) {
		this.beginX = beginX;
	}

	public String getBeginY() {
		return beginY;
	}

	public void setBeginY(String beginY) {
		this.beginY = beginY;
	}

	public String getEndX() {
		return endX;
	}

	public void setEndX(String endX) {
		this.endX = endX;
	}

	public String getEndY() {
		return endY;
	}

	public void setEndY(String endY) {
		this.endY = endY;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roadBookId=").append(roadBookId);
        sb.append(", creater=").append(creater);
        sb.append(", activityId=").append(activityId);
        sb.append(", allDistance=").append(allDistance);
        sb.append(", estimatedTime=").append(estimatedTime);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", status=").append(status);
    
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}