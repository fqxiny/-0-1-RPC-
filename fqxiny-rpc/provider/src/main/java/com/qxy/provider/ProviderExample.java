package com.qxy.provider;


import com.qxy.common.service.UserService;
import com.qxy.registry.LocalRegistry;
import com.qxy.server.HttpServer;
import com.qxy.server.VertxHttpServer;
/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:12
 */
public class ProviderExample {
    // TODO : 提供服务
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        //启动Web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}


