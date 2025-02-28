package com.qxy.common.model;

import java.io.Serializable;

/**
 * @author : 戚欣扬
 * @description :用户实体类User
 * @createDate : 2025/2/28 下午2:57
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


