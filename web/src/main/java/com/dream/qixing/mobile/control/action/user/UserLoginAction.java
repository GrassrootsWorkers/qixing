package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
@ApiAction(value="customer.login")
public class UserLoginAction extends BaseAction{

    private String mobile;
    private String password;
    @ApiField("if_first")
    private String ifFirst="Y";
    public String execute(){
        if(!validateMobile(mobile)){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("手机号格式不正确！");
            return"";
        }
        if("admin".equals(password)){
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("登录成功！");
            this.setUserId(10000);
            ifFirst="Y";
            return "";
        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(500);
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
