package com.earl.spBoot.business.service.admin;


import com.github.pagehelper.PageInfo;
import com.earl.spBoot.business.base.IBaseService;
import com.earl.spBoot.mapper.entity.DemoUser;

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
