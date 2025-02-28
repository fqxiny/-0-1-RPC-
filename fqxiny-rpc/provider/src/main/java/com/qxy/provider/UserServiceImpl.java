package com.qxy.provider;

import com.qxy.common.model.User;
import com.qxy.common.service.UserService;

/**
 * @author : 戚欣扬
 * @description :实现公共模块中的用户服务接口
 * @createDate : 2025/2/28 下午3:07
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名："+user.getName());
        return user;
    }
}


