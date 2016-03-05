package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.user.User;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value = "customer.userInfo")
public class GetUserInfoAction extends BaseAction {

    @ApiField("user")
    private User user ;
    public String execute(){
        user =new User();
        user.setBicycleAge(10);
        user.setHeight("60Kg");
        user.setImage("http://p1.qixing.com/100.jpg");
        user.setLocation("北京市海淀区北大西门");
        user.setNickName("骆驼");
        user.setMobile("18618102693");
        user.setSex("男");
        user.setRealName("刘先生");
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("获取成功");
        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
