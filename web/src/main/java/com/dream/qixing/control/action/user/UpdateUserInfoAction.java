package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.interfaces.user.IUserService;
import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
@ApiAction(value="customer.modifyinfo")
public class UpdateUserInfoAction extends BaseAction {
    private String userImg;
    private String nickName;
    private String location;
    private String cyclingAge;
    private String height;
    private String weight;
    private String name;
    private String mobile;
    @Autowired
    IUserService userService;
    public String execute(){
        if(this.getUserId()==null){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("请登录！再修改用户信息");
        }
        //判定用户是否登录
        UserQuery query = new UserQuery();
        query.setUserId(this.getUserId());
        User user = userService.queryUser(query);
        if(user == null){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("用户不存在！");
        }
        Object obj = this.getSession().getAttribute("login_"+user.getMobile());
        if(obj == null){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("请登录！再修改用户信息");
        }
        int loggedUserId = (Integer)obj;
        if(this.getUserId() != loggedUserId){
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("请登录！再修改用户信息");
        }
        boolean ifLogin = false;
        if(ifLogin){
            this.setIsSuccessful(true);
            this.setStatusCode(200);
            this.setDescription("修改成功！");
            return "";
        }else{
            this.setIsSuccessful(false);
            this.setStatusCode(500);
            this.setDescription("请登录！在修改用户信息");
        }

        return "";
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCyclingAge() {
        return cyclingAge;
    }

    public void setCyclingAge(String cyclingAge) {
        this.cyclingAge = cyclingAge;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
