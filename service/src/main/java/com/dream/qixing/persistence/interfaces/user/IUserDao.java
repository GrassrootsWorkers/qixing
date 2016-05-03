package com.dream.qixing.persistence.interfaces.user;

import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserInfo;
import com.dream.qixing.model.user.UserQuery;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public interface IUserDao {

    /**
     * 保存用户最基本信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 保存用户回经常改变的信息
     * @param user
     * @return
     */
    int insertUserInfo(UserInfo user);

    /**
     * 根据条件查询用户
     * @param query
     * @return
     */
    User queryUser(UserQuery query);
}
