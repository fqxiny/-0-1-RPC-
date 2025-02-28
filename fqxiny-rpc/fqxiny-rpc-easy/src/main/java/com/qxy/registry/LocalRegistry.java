package com.qxy.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:36
 */
public class LocalRegistry {
    /*注册信息存储*/
    private static final Map<String,Class<?>> map = new ConcurrentHashMap<>();

    /*注册服务*/
    public static void register(String serviceName,Class<?> implClass){
        map.put(serviceName,implClass);
    }

    /*获取服务*/
    public static Class<?> getService(String serviceName){
        //遍历map,打印其中值到控制台
        for (Map.Entry<String, Class<?>> entry : map.entrySet()) {
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }

        return map.get(serviceName);
    }
    /*删除服务*/
    public static void unRegister(String serviceName){
        map.remove(serviceName);
    }
}


