package com.dream.qixing.mobile.control.action.user;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.mapping.ApiField;

/**
 * Created by Administrator on 2016/2/28 0028.
 */
@ApiAction(value ="customer.getCheckCode")
public class CheckCodeAction extends BaseAction {

    private String mobile;
    //获取验证码的用途：0：注册；1：修改密码在此type的值为0，2快速登录验证码
    private int codeType;
    @ApiField("checkCode")
    private String checkCode;
    @Override
    public String execute(){

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

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
