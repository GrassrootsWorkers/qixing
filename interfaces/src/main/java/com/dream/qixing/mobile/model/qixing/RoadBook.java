package com.dream.qixing.mobile.model.qixing;

import com.dream.qixing.mobile.mapping.ApiField;

import java.io.Serializable;
import java.util.Date;

public class RoadBook implements Serializable {
	@ApiField("road_book_id")
    private Integer roadBookId;
    @ApiField("name")
    private String name;
    @ApiField("road_name")
    private String roadName;
    @ApiField("creator")
    private String creator;
    @ApiField("mileage")
    private Integer mileage;
    @ApiField("difficulty")
    private Integer difficulty;
    @ApiField("status")
    private Integer status;
    @ApiField("status_name")
    private String statusName;
    @ApiField("create_time")
    private Date createTime;
    @ApiField("traces")
    private String traces;
	private static final long serialVersionUID = 1L;

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

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

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
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