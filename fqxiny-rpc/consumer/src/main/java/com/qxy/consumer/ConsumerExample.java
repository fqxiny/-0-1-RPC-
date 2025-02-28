package com.qxy.consumer;

import com.qxy.common.model.User;
import com.qxy.common.service.UserService;
import com.qxy.proxy.ServiceProxyFactory;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:15
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // TODO : 需要获取目标服务（用户信息接口的实现）

        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("fqxiny");

        //invoke
        User newUser = userService.getUser(user);
        if(newUser != null){
            System.out.println(newUser.getName());
        }else{
            System.out.println("user == null");
        }
    }
}


