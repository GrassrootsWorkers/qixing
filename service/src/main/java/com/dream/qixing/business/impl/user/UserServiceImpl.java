package com.dream.qixing.business.impl.user;

import com.dream.qixing.interfaces.user.IUserService;
import com.dream.qixing.model.user.User;
import com.dream.qixing.model.user.UserInfo;
import com.dream.qixing.model.user.UserQuery;
import com.dream.qixing.persistence.interfaces.user.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public int insertUser(User user) {
        userDao.insertUser(user);
        return user.getUserId();
    }

    @Override
    public int insertUserInfo(UserInfo user) {
        return 0;
    }

    @Override
    public User queryUser(UserQuery query) {
        return userDao.queryUser(query);
    }

    @Override
    public int updateUser(User user) {
        user.setLastLoginTime(new Date());
        return userDao.updateUser(user);
    }

}
