package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

/**
 * Created by Administrator on 2016/2/28 0028.
 */
@ApiAction(value="customer.register")
public class RegisterUserAction extends BaseAction {

    private String mobile;
    private String pwd1;
    private String pwd2;
    private String validateCode;
    @Override
    public String execute(){
        this.setUserId(10000);
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("注册成功！");
        return "";
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd1() {
        return pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    public String getPwd2() {
        return pwd2;
    }

    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }
}
