package com.earl.spBoot.business.service;

import  com.earl.spBoot.bean.entity.WechatRegister;
import  com.earl.spBoot.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * 新生报名
 * @author earl
 * @date 2017-05-22 20:34:12
 */
public interface WechatRegisterService  extends IBaseService<WechatRegister, Long> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<WechatRegister> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param registerIds   id数组
     */
    public void deleteBatch(Long [] registerIds);


}
