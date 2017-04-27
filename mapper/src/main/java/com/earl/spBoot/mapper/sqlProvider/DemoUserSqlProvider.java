package com.earl.spBoot.mapper.sqlProvider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class DemoUserSqlProvider {


    public String pageList(String userName) {
        SQL sql = new SQL();
        sql.SELECT("*,date_format(d.create_date,'%Y-%c-%d %h:%i:%s') as 'strCreateDate' ")
                .FROM("demo_user d");
        if (StringUtils.isNotBlank(userName)) {
            sql.WHERE("d.userName LIKE #{userName}");
        }
        sql.ORDER_BY("create_date desc");
        return sql.toString();
    }

}