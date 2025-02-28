package com.qxy.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.qxy.common.model.RpcRequest;
import com.qxy.common.model.RpcResponse;
import com.qxy.common.model.User;
import com.qxy.common.service.UserService;
import com.qxy.serializer.JdkSerializer;
import com.qxy.serializer.Serializer;

import java.io.IOException;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午4:43
 */
public class UserServiceProxy implements UserService {


    @Override
    public User getUser(User user) {
        //指定序列化器
        Serializer serializer = new JdkSerializer();
        //发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();

        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                        .body(bodyBytes)
                        .execute()) {
                    result = httpResponse.bodyBytes();
                }
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return (User)rpcResponse.getData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }
}

