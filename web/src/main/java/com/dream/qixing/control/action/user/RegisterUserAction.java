package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.interfaces.user.IUserService;
import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserQuery;
import com.dream.qixing.util.md5.UtilMD5;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/2/28 0028.
 */
@ApiAction(value="customer.register")
public class RegisterUserAction extends BaseAction {

    private String mobile;
    private String pwd1;
    private String pwd2;
    private String validateCode;
    @Autowired
    IUserService userService;
    @Override
    public String execute(){
        if(!validateMobile(mobile)){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("手机号格式不正确！");
            return"";
        }
        UserQuery query = new UserQuery();
        query.setMobile(mobile);
        User queryUser = userService.queryUser(query);
        if(queryUser != null){
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("手机已经注册！");
            return"";
        }
        String code = (String)this.getSession().getAttribute(mobile);
        if(code != null && code.equals(validateCode)){
            User user = new User();
            user.setPassword(UtilMD5.md5(pwd1));
            user.setMobile(mobile);
            user.setUserName(mobile.substring(0,3)+"****"+mobile.substring(7));
            user.setIfFirstLogin(User.first_login);
            user.setRegisteredTime(new Date());
            user.setLastLoginTime(new Date());
            int userId = userService.insertUser(user);
            this.setUserId(userId);
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("注册成功！");
        }else {
            this.setUserId(null);
            this.setIsSuccessful(false);
            this.setStatusCode(501);
            this.setDescription("验证码错误！");
        }
        return "";
    }
    protected   boolean validateMobile(String mobile){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
    @Override
    public String getResponseName() {
        return null;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
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
