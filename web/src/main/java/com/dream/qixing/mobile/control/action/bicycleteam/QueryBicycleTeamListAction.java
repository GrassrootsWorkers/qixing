package com.dream.qixing.mobile.control.action.bicycleteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;


@ApiAction("bicycle.team.list")
public class QueryBicycleTeamListAction extends BaseAction {

    //查询类型  1:推荐的车队 2：参加的车队
    private int queryType;
    private String bicycleName;
    private Integer provinceId;
    private Integer cityId;
    @ApiField("page_index")
    private int pageIndex;
    @ApiField("total_page")
    private int totalPage;

    @ApiListField("teams")
    @ApiField("team")
    private List<BicycleTeam> bicycleTeams;

    @Override
    public String execute() {
        if (queryType == 0) {
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("您还没参加任何车队！");
            return"";

        }
        if (queryType == 4) {
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("目前还没有适合您的车队，请完善你的用户信息在进行查找！");
            return"";

        }
        bicycleTeams = new ArrayList<BicycleTeam>();
        BicycleTeam team = new BicycleTeam();
        team.setCycId(1000);
        team.setCycTeamLogo("http://qixing.com/imgage.jpg");
        team.setAmount(100);
        team.setPersonLimit(500);
        team.setClubName("夕阳红");
        team.setActiveness("高");
        team.setClubAddress("北京市海淀区");
        team.setCreateTime(new Date());
        bicycleTeams.add(team);
        BicycleTeam team1 = new BicycleTeam();
        team1.setCycId(1000);
        team1.setCycTeamLogo("http://qixing.com/imgage.jpg");
        team1.setPersonLimit(500);
        team1.setAmount(100);
        team1.setClubName("夕阳红");
        team1.setActiveness("高");
        team1.setClubAddress("北京市昌平区南邵镇");
        team1.setCreateTime(new Date());
        bicycleTeams.add(team1);

        pageIndex = pageIndex + 1;
        totalPage = 10;
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        if (queryType == 2) {
            this.setDescription("查询参加的车队成功！");
        } else {
            this.setDescription("查询推荐的车队成功！");
        }
        return "";
    }

    @Override
    public String getResponseName() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<BicycleTeam> getBicycleTeams() {
        return bicycleTeams;
    }

    public void setBicycleTeams(List<BicycleTeam> bicycleTeams) {
        this.bicycleTeams = bicycleTeams;
    }

    public int getQueryType() {
        return queryType;
    }


    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }


    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
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


}
