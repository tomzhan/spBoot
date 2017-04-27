package com.earl.spBoot.mapper.dao;

import com.earl.spBoot.mapper.base.IBaseDao;
import com.earl.spBoot.mapper.entity.DemoUser;
import com.earl.spBoot.mapper.sqlProvider.DemoUserSqlProvider;
import com.earl.spBoot.mapper.vo.DemoUserVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


public interface DemoUserMapper extends IBaseDao<DemoUser> {

    @SelectProvider(type = DemoUserSqlProvider.class, method = "pageList")
    @Results({
            @Result(column="strCreateDate", property="strCreateDate", jdbcType=JdbcType.VARCHAR)
    })
    List<DemoUserVO> pageList(String userName);
}