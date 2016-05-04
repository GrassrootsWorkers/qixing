package com.dream.qixing.interfaces.user;

import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserInfo;
import com.dream.qixing.model.user.UserQuery;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public interface IUserService {
    /**
     * 保存用户信息
     * @param user
     * @return
     */

    int insertUser(User user);

    /**
     * 保存用户基本信息
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
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
}
