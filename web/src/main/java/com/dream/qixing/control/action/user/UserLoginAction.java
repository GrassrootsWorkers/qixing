package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.interfaces.user.IUserService;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserQuery;
import com.dream.qixing.util.md5.UtilMD5;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
@ApiAction(value="customer.login")
public class UserLoginAction extends BaseAction {

    private String mobile;
    private String password;
    @ApiField("if_first")
    private String ifFirst;

    @Autowired
    IUserService userService;
    public String execute(){
        if(!validateMobile(mobile)){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("手机号格式不正确！");
            return"";
        }
        UserQuery query = new UserQuery();
        query.setMobile(mobile);
        User user = userService.queryUser(query);
        if(user == null){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("用户不存在！");
            return"";
        }
        if(user.getIfFirstLogin() == User.first_login){
            ifFirst ="Y";
        }else{
            ifFirst = "N";
        }
        if(user.getPassword().equals(UtilMD5.md5(password))){
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("登录成功！");
            this.setUserId(user.getUserId());
            //在修改用户信息中改变该值
            //user.setIfFirstLogin(User.no_first_login);
            //userService.updateUser(user);
            this.getSession().setAttribute("login_"+mobile,user.getUserId());
            return "";
        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("密码错误！");
            return "";
        }
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIfFirst() {
        return ifFirst;
    }

    public void setIfFirst(String ifFirst) {
        this.ifFirst = ifFirst;
    }
}
