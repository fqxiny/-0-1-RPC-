package com.qxy.proxy;

import java.lang.reflect.Proxy;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午5:02
 */
public class ServiceProxyFactory {

    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}


