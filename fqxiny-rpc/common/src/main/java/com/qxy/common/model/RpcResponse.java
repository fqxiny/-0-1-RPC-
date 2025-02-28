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
public class RpcResponse implements Serializable {
    /*响应数据*/
    private Object data;
    /*响应状态*/
    private Class<?> dataType;
    /*响应信息*/
    private String message;
    /*异常信息*/
    private Exception exception;
}


