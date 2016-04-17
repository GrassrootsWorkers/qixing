package com.dream.qixing.control.action.user;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value = "user.grade")
public class QueryUserGradeAction extends BaseAction {
    private int userNumber;
    @ApiField("total_used_time")
    private String totalUsedTime;
    @ApiField("total_mileage")
    private String totalMileage;
    @ApiField("total_times")
    private String totalTimes;
    @ApiField("total_caloric")
    private String totalCaloric;
    @ApiField("week_mileage")
    private String weekMileage;
    @ApiField("week_used_time")
    private String weekUsedTime;
    @ApiField("week_caloric")
    private String weekCaloric;
    @ApiField("week_height")
    private String weekHeight;
    @ApiField("week_times")
    private String weekTimes;
    @ApiField("month_mileage")
    private String monthMileage;
    @ApiField("month_used_time")
    private String monthUsedTime;
    @ApiField("month_caloric")
    private String monthCaloric;
    @ApiField("month_height")
    private String monthHeight;
    @ApiField("month_times")
    private String monthTimes;
    @ApiField("total_average_speed")
    private String totalAverageSpeed;
    @ApiField("max_speed")
    private String maxSpeed;
    @ApiField("max_caloric")
    private String maxCaloric;
    @ApiField("max_mileage")
    private String maxMileage;
    @ApiField("max_used_time")
    private String maxTimeUsed;
    public String execute(){
        if(userNumber == 0){
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("数据异常！");
            return "";
        }
        this.totalAverageSpeed="14.56";
        this.totalCaloric="1234567.98";
        this.totalMileage="12345.87";
        this.totalTimes="10";
        this.totalUsedTime="234:34:59";
        this.weekCaloric="12345.6";
        this.weekHeight="123";
        this.weekMileage="1234.97";
        this.weekTimes="5";
        this.weekUsedTime="12:34:56";
        this.monthCaloric="3456.89";
        this.monthHeight="567";
        this.monthMileage="234";
        this.monthTimes="5";
        this.monthUsedTime="23:14:58";
        this.maxCaloric="34567";
        this.maxMileage="23";
        this.maxSpeed="15.87";
        this.maxTimeUsed="4:12:56";
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("查询成功！");
        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public String getTotalUsedTime() {
        return totalUsedTime;
    }

    public void setTotalUsedTime(String totalUsedTime) {
        this.totalUsedTime = totalUsedTime;
    }

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(String totalTimes) {
        this.totalTimes = totalTimes;
    }

    public String getTotalCaloric() {
        return totalCaloric;
    }

    public void setTotalCaloric(String totalCaloric) {
        this.totalCaloric = totalCaloric;
    }

    public String getWeekMileage() {
        return weekMileage;
    }

    public void setWeekMileage(String weekMileage) {
        this.weekMileage = weekMileage;
    }

    public String getWeekUsedTime() {
        return weekUsedTime;
    }

    public void setWeekUsedTime(String weekUsedTime) {
        this.weekUsedTime = weekUsedTime;
    }

    public String getWeekCaloric() {
        return weekCaloric;
    }

    public void setWeekCaloric(String weekCaloric) {
        this.weekCaloric = weekCaloric;
    }

    public String getWeekHeight() {
        return weekHeight;
    }

    public void setWeekHeight(String weekHeight) {
        this.weekHeight = weekHeight;
    }

    public String getWeekTimes() {
        return weekTimes;
    }

    public void setWeekTimes(String weekTimes) {
        this.weekTimes = weekTimes;
    }

    public String getMonthMileage() {
        return monthMileage;
    }

    public void setMonthMileage(String monthMileage) {
        this.monthMileage = monthMileage;
    }

    public String getMonthUsedTime() {
        return monthUsedTime;
    }

    public void setMonthUsedTime(String monthUsedTime) {
        this.monthUsedTime = monthUsedTime;
    }

    public String getMonthCaloric() {
        return monthCaloric;
    }

    public void setMonthCaloric(String monthCaloric) {
        this.monthCaloric = monthCaloric;
    }

    public String getMonthHeight() {
        return monthHeight;
    }

    public void setMonthHeight(String monthHeight) {
        this.monthHeight = monthHeight;
    }

    public String getMonthTimes() {
        return monthTimes;
    }

    public void setMonthTimes(String monthTimes) {
        this.monthTimes = monthTimes;
    }

    public String getTotalAverageSpeed() {
        return totalAverageSpeed;
    }

    public void setTotalAverageSpeed(String totalAverageSpeed) {
        this.totalAverageSpeed = totalAverageSpeed;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMaxCaloric() {
        return maxCaloric;
    }

    public void setMaxCaloric(String maxCaloric) {
        this.maxCaloric = maxCaloric;
    }

    public String getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(String maxMileage) {
        this.maxMileage = maxMileage;
    }

    public String getMaxTimeUsed() {
        return maxTimeUsed;
    }

    public void setMaxTimeUsed(String maxTimeUsed) {
        this.maxTimeUsed = maxTimeUsed;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

}
