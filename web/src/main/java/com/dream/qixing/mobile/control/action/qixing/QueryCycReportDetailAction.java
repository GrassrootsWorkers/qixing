package com.dream.qixing.mobile.control.action.qixing;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import org.springframework.test.context.ActiveProfiles;

@ApiAction(value = "cyc.report.detail")
public class QueryCycReportDetailAction extends BaseAction {
    @ApiField("tracks")
    private String tracks;
    @ApiField("report_id")
    private Integer reportId;
    @ApiField("name")
    private String qxName;
    @ApiField("mileage")
    private Double mileage;
    @ApiField("time_consume")
    private String timeConsume;
    @ApiField("average_speed")
    private Double averageSpeed;
    @ApiField("highest_speed")
    private Double highestSpeed;
    @ApiField("lowest_speed")
    private Double lowestSpeed;
    @ApiField("caloric_value")
    private String caloricValue;
    @ApiField("road_book_id")
    private Integer roadBookId;
    //爬升高度
    @ApiField("height")
    private String height;

    @ApiField("speed_chart")
    private String speedChart;
    @ApiField("height_chart")
    private String heightChart;
    @ApiField("images")
    private String images;

    public String execute() {
        if (reportId == 0) {
            setIsSuccessful(false);
            setStatusCode(400);
            setDescription("查询失败！");
            return "";
        } else {

            qxName = "一日游";
            tracks = "116.357428:39.90923_10,116.397428:39.90923_11";
            mileage = 12.45;
            timeConsume = "00:24:50";
            averageSpeed = 12.46;
            highestSpeed = 15.34;
            lowestSpeed = 6.68;
            caloricValue = "12345.09";
            roadBookId = 100001;
            //爬升高度
            height = "123.24";
            speedChart="http://p1.dream.qixing.com/report/speed/"+reportId+".jpg";
            heightChart="http://p1.dream.qixing.com/report/height/"+reportId+".jpg";
            images="http://p1.qixing.com/1.jpg;http://p1.qixing.com/1.jpg";
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setUserId(1000);
            setDescription("查询成功！");
            return "";
        }

    }

    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getQxName() {
        return qxName;
    }

    public void setQxName(String qxName) {
        this.qxName = qxName;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(String timeConsume) {
        this.timeConsume = timeConsume;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Double getHighestSpeed() {
        return highestSpeed;
    }

    public void setHighestSpeed(Double highestSpeed) {
        this.highestSpeed = highestSpeed;
    }

    public Double getLowestSpeed() {
        return lowestSpeed;
    }

    public void setLowestSpeed(Double lowestSpeed) {
        this.lowestSpeed = lowestSpeed;
    }

    public String getCaloricValue() {
        return caloricValue;
    }

    public void setCaloricValue(String caloricValue) {
        this.caloricValue = caloricValue;
    }

    public Integer getRoadBookId() {
        return roadBookId;
    }

    public void setRoadBookId(Integer roadBookId) {
        this.roadBookId = roadBookId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getSpeedChart() {
        return speedChart;
    }

    public void setSpeedChart(String speedChart) {
        this.speedChart = speedChart;
    }

    public String getHeightChart() {
        return heightChart;
    }

    public void setHeightChart(String heightChart) {
        this.heightChart = heightChart;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
