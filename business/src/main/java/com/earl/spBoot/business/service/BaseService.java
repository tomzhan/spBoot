package com.earl.spBoot.business.service;

/**
 *  最顶级接口
 * Created by earl on 2017/4/7.
 */
public interface BaseService  <T>{


    int deleteByPrimaryKey(String id);

    int insert(T po);

    int insertSelective(T po);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T po);

    int updateByPrimaryKey(T po);

}
