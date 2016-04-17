package com.dream.qixing.control.action.bicycleteam;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.user.User;

import java.util.ArrayList;
import java.util.List;

@ApiAction("bicycle.activity.member")
public class QueryActivityMemberAction extends BaseAction {
    private Integer activityId;
    @ApiField("page_index")
    private Integer pageIndex ;
    @ApiField("total_page")
    private int totalPage;
    @ApiListField("users")
    @ApiField("user")
    private List<User> users;

    @Override
    public String execute() {
        pageIndex = pageIndex+1;
        totalPage = 10;
        if (activityId > 0) {
            users = new ArrayList<User>();
            User user = new User();
            user.setUserId(100001);
            user.setImage("http://p1.qixing.com/100001/10001.jpg");
            user.setNickName("骑行者");
            user.setLocation("北京市海淀区");
            user.setBicycleAge(10);
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

}
