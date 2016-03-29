package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.model.user.User;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value = "customer.summary.info")
public class GetSummaryUserInfoAction extends BaseAction {

    @ApiField("user")
    private User user ;
    private int userNumber;
    public String execute(){
        if(userNumber ==1000){
            user =new User();
            user.setImage("http://p1.qixing.com/100.jpg");
            user.setLocation("北京市海淀区北大西门");
            user.setNickName("骆驼");
            user.setTotalMileage("123.23");
            user.setTotalTime("12:24:24");
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
