package com.dream.qixing.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;

import com.dream.qixing.mapping.ApiField;

public class BicycleTeam implements Serializable {

    @ApiField("user_id")
    private Integer userId;

    @ApiField("bicycle_id")
    private Integer cycId;
    @ApiField("team_logo")
    private String cycTeamLogo;
    @ApiField("team_name")
    private String clubName;
    @ApiField("team_address")
    private String clubAddress;
    @ApiField("desc")
    private String clubDesc;
    @ApiField("purpose")
    private String purpose;
    @ApiField("create_name")
    private String createName;
    @ApiField("mobile")
    private String mobile;
    @ApiField("allow_stranger_apply")
    private String allowUnknown;
    //车队上限人数
    @ApiField("person_limit")
    private Integer personLimit;
    //车队报名的人数
    @ApiField("amount")
    private Integer amount;
    @ApiField("create_time")
    private Date createTime;
    //车队举办的活动数
    private Integer activityAmount;
    private Integer provinceId;
    private Integer cityId;
    @ApiField("if_take_part")
    private String  isJoin;
    /**
     * 1-10分 根据举办的活动计算
     */
    @ApiField("activeness")
    private String activeness;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCycId() {
        return cycId;
    }

    public void setCycId(Integer cycId) {
        this.cycId = cycId;
    }

    public String getCycTeamLogo() {
        return cycTeamLogo;
    }

    public void setCycTeamLogo(String cycTeamLogo) {
        this.cycTeamLogo = cycTeamLogo;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubDesc() {
        return clubDesc;
    }

    public void setClubDesc(String clubDesc) {
        this.clubDesc = clubDesc;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAllowUnknown() {
        return allowUnknown;
    }

    public void setAllowUnknown(String allowUnknown) {
        this.allowUnknown = allowUnknown;
    }

    public Integer getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(Integer personLimit) {
        this.personLimit = personLimit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getActivityAmount() {
        return activityAmount;
    }

    public void setActivityAmount(Integer activityAmount) {
        this.activityAmount = activityAmount;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(String isJoin) {
        this.isJoin = isJoin;
    }

    public String getActiveness() {
        return activeness;
    }

    public void setActiveness(String activeness) {
        this.activeness = activeness;
    }
}