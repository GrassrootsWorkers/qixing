package com.dream.qixing.control.action.user;

import com.dream.qixing.config.ApiAction;
import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.user.User;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value = "customer.userInfo")
public class GetUserInfoAction extends BaseAction {

    @ApiField("user")
    private User user ;
    private int userNumber;
    public String execute(){
        if(userNumber ==1000){
            user =new User();
            user.setUserId(1000);
            user.setBicycleAge(10);
            user.setHeight("60Kg");
            user.setImage("http://p1.qixing.com/100.jpg");
            user.setLocation("北京市海淀区北大西门");
            user.setNickName("骆驼");
            user.setMobile("18618102693");
            user.setSex("M");
            user.setRealName("刘先生");
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("获取成功");

        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(400);
            this.setDescription("用户不存在！");
        }

        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
