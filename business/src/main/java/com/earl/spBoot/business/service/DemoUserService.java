package com.earl.spBoot.business.service;


import com.earl.spBoot.bean.entity.DemoUser;
import com.earl.spBoot.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * demo服务接口
 * Created by earl on 2017/3/29.
 */
public interface DemoUserService  extends IBaseService<DemoUser, String> {

    /**
     * 分页
     */
    PageInfo pageList(int pageNum, int pageSize, String userName);

    /**
     * 批量保存用户测试
     */
    void save() ;


}
