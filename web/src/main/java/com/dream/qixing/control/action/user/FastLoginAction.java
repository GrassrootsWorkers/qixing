package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;

/**
 * Created by Administrator on 2016/2/28 0028.
 */
@ApiAction(value ="customer.fastlogin")
public class FastLoginAction extends BaseAction {

    private String mobile;
    private String checkCode;
    @ApiField("if_first")
    private String ifFirst;
    @Override
    public String execute(){
        if(!validateMobile(mobile)){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("手机号格式不正确！");
            return"";
        }
        if("123456".equals(checkCode)){
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("登录成功！");
            this.setUserId(10000);
            ifFirst="Y";
            return "";
        }
        if("654321".equals(checkCode)){
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("登录成功！");
            this.setUserId(10000);
            ifFirst="N";
            return "";
        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("验证码不正确！");
            return "";
        }

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


    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
