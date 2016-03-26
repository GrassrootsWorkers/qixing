package com.dream.qixing.mobile.control.action.bicycleteam;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.bicycleteam.BicycleTeam;
import com.dream.qixing.mobile.model.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiAction("bicycle.team.member")
public class QueryTeamMemberAction extends BaseAction {
    private Integer bicycleId;
    @ApiField("page_index")
    private Integer pageIndex = 1;
    @ApiListField("users")
    @ApiField("user")
    private List<User> users;
    @ApiField("total_page")
    private int totalPage;
    @Override
    public String execute() {
        if (bicycleId > 0) {
            pageIndex = pageIndex+1;
            totalPage = 10;
            users = new ArrayList<User>();
            User user = new User();
            user.setUserId(100001);
            user.setImage("http://p1.qixing.com/100001/10001.jpg");
            user.setNickName("骑行者");
            user.setLocation("北京市海淀区");
            users.add(user);
            user.setUserId(100002);
            users.add(user);
            user.setUserId(100003);
            users.add(user);
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("查询成功！");
            return "";
        } else {
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("系统异常！");
            return "";
        }
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }
}
