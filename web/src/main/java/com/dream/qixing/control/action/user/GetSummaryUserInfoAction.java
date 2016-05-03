package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserVo;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value = "customer.summary.info")
public class GetSummaryUserInfoAction extends BaseAction {

    @ApiField("user")
    private UserVo user ;
    private int userNumber;
    public String execute(){
        if(userNumber ==1000){
            user =new UserVo();
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

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }
}
