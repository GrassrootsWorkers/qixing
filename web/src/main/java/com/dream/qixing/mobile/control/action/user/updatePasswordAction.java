package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction("customer.findPassword")
public class updatePasswordAction extends BaseAction {

    private String mobile;
    private String mobileValidate;
    private String newPassword;

    public String execute() {
        this.setIsSuccessful(true);
        this.setStatusCode(200);
        this.setDescription("修改密码成功！");
        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileValidate() {
        return mobileValidate;
    }

    public void setMobileValidate(String mobileValidate) {
        this.mobileValidate = mobileValidate;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
