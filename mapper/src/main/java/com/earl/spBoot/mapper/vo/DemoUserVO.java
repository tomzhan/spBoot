package com.earl.spBoot.mapper.vo;

import com.earl.spBoot.mapper.entity.DemoUser;

/**
 * Created by earl on 2017/3/30.
 */
public class DemoUserVO extends DemoUser {

    private String strCreateDate;


    public String getStrCreateDate() {
        return strCreateDate;
    }

    public void setStrCreateDate(String strCreateDate) {
        this.strCreateDate = strCreateDate;
    }
}
