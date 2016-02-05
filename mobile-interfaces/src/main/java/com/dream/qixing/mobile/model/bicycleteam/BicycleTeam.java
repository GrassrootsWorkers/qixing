package com.dream.qixing.mobile.model.bicycleteam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;

public class BicycleTeam implements Serializable {
    private Integer cycId;

    private String cycTeamLogo;

    private String clubName;

    private String clubAddress;

    private String clubDesc;

    private String createName;

    private String mobile;

    private String personalPhp;

    private String allowUnknow;

    private Integer personLimit;

    private Date createTime;
    //车队举办的活动数

    private Integer activityAmount;
    
    @ApiListField("friends")
    @ApiField("friend")
    private List<Friend> friends;
    
    @ApiListField("activitys")
    @ApiField("activity")
    private List<Activity> activitys;	
    /**
     * 1-10分 根据举办的活动计算
     */
    private Integer liveness;

    private static final long serialVersionUID = 1L;

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
        this.cycTeamLogo = cycTeamLogo == null ? null : cycTeamLogo.trim();
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName == null ? null : clubName.trim();
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress == null ? null : clubAddress.trim();
    }

    public String getClubDesc() {
        return clubDesc;
    }

    public void setClubDesc(String clubDesc) {
        this.clubDesc = clubDesc == null ? null : clubDesc.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPersonalPhp() {
        return personalPhp;
    }

    public void setPersonalPhp(String personalPhp) {
        this.personalPhp = personalPhp == null ? null : personalPhp.trim();
    }

    public String getAllowUnknow() {
        return allowUnknow;
    }

    public void setAllowUnknow(String allowUnknow) {
        this.allowUnknow = allowUnknow == null ? null : allowUnknow.trim();
    }

    public Integer getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(Integer personLimit) {
        this.personLimit = personLimit;
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

    public Integer getLiveness() {
        return liveness;
    }

    public void setLiveness(Integer liveness) {
        this.liveness = liveness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cycId=").append(cycId);
        sb.append(", cycTeamLogo=").append(cycTeamLogo);
        sb.append(", clubName=").append(clubName);
        sb.append(", clubAddress=").append(clubAddress);
        sb.append(", clubDesc=").append(clubDesc);
        sb.append(", createName=").append(createName);
        sb.append(", mobile=").append(mobile);
        sb.append(", personalPhp=").append(personalPhp);
        sb.append(", allowUnknow=").append(allowUnknow);
        sb.append(", personLimit=").append(personLimit);
        sb.append(", createTime=").append(createTime);
        sb.append(", activityAmount=").append(activityAmount);
        sb.append(", liveness=").append(liveness);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}