package com.dream.qixing.mobile.model.qixing;

import com.dream.qixing.mobile.mapping.ApiField;

import java.io.Serializable;
import java.util.Date;

public class CycReport implements Serializable {
    @ApiField("report_id")
    private Integer cysReportId;
    @ApiField("user_number")
    private Integer userId;
    @ApiField("name")
    private String qxName;

    private Date startTime;

    private Date endTime;
    @ApiField("mileage")
    private Double mileage;
    private String traces;

    private Integer difficultyDeg;

    private Float averageSpeed;

    private Float highestSpeed;

    private Float lowestSpeed;

    /**
     * 时分秒
     */
    @ApiField("time_consume")
    private String timeConsume;

    private Float caloricValue;

    private Integer ifTeam;

    @ApiField("road_book_id")
    private Integer roadBookId;

    @ApiField("speed_chart")
    private String speedChart;
    @ApiField("alt_chart")
    private String altitudeChart;
    @ApiField("trace_image")
    private String traceImage;

    private static final long serialVersionUID = 1L;

    public String getTraceImage() {
        return traceImage;
    }

    public void setTraceImage(String traceImage) {
        this.traceImage = traceImage;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getSpeedChart() {
        return speedChart;
    }

    public void setSpeedChart(String speedChart) {
        this.speedChart = speedChart;
    }

    public String getAltitudeChart() {
        return altitudeChart;
    }

    public void setAltitudeChart(String altitudeChart) {
        this.altitudeChart = altitudeChart;
    }

    public Integer getCysReportId() {
        return cysReportId;
    }

    public void setCysReportId(Integer cysReportId) {
        this.cysReportId = cysReportId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getQxName() {
        return qxName;
    }

    public void setQxName(String qxName) {
        this.qxName = qxName == null ? null : qxName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    public Integer getDifficultyDeg() {
        return difficultyDeg;
    }

    public void setDifficultyDeg(Integer difficultyDeg) {
        this.difficultyDeg = difficultyDeg;
    }

    public Float getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Float getHighestSpeed() {
        return highestSpeed;
    }

    public void setHighestSpeed(Float highestSpeed) {
        this.highestSpeed = highestSpeed;
    }

    public Float getLowestSpeed() {
        return lowestSpeed;
    }

    public void setLowestSpeed(Float lowestSpeed) {
        this.lowestSpeed = lowestSpeed;
    }

    public String getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(String timeConsume) {
        this.timeConsume = timeConsume;
    }

    public Float getCaloricValue() {
        return caloricValue;
    }

    public void setCaloricValue(Float caloricValue) {
        this.caloricValue = caloricValue;
    }

    public Integer getIfTeam() {
        return ifTeam;
    }

    public void setIfTeam(Integer ifTeam) {
        this.ifTeam = ifTeam;
    }

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cysReportId=").append(cysReportId);
        sb.append(", userId=").append(userId);
        sb.append(", qxName=").append(qxName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", gpsStrs=").append(traces);
        sb.append(", difficultyDeg=").append(difficultyDeg);
        sb.append(", averageSpeed=").append(averageSpeed);
        sb.append(", highestSpeed=").append(highestSpeed);
        sb.append(", lowestSpeed=").append(lowestSpeed);
        sb.append(", timeConsume=").append(timeConsume);
        sb.append(", caloricValue=").append(caloricValue);
        sb.append(", ifTeam=").append(ifTeam);
        sb.append(", roadBookId=").append(roadBookId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}