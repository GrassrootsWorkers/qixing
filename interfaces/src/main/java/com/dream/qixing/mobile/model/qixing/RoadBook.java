package com.dream.qixing.mobile.model.qixing;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;

public class RoadBook implements Serializable {
	@ApiField("road_book_id")
    private Integer roadBookId;
    @ApiField("road_name")
    private String name;
    @ApiField("road_map")
    private String roadMap;
    @ApiField("creator")
    private String creator;
    @ApiField("mileage")
    private Integer mileage;

    private Integer estimatedTime;
    @ApiField("difficulty")
    private Integer difficulty;

    @ApiField("if_use")
    private Integer status;
    @ApiField("create_time")
    private Date createTime;



	private static final long serialVersionUID = 1L;

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(String roadMap) {
        this.roadMap = roadMap;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}