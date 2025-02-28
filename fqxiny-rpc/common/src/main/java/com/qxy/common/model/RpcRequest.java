package com.qxy.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RpcRequest implements Serializable {

    /*服务名称*/
    private String serviceName;

    /*方法名称*/
    private String methodName;

    /*参数类型*/
    private Class<?>[] parameterTypes;

    /*参数值*/
    private Object[] args;

}


