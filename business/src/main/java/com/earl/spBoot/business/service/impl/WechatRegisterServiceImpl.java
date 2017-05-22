package com.earl.spBoot.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.earl.spBoot.business.service.WechatRegisterService;
import com.earl.spBoot.business.base.BaseService;
import com.earl.spBoot.business.base.IBaseDao;
import com.earl.spBoot.business.dao.WechatRegisterMapper;
import com.earl.spBoot.bean.entity.WechatRegister;
import java.util.List;



/**
 * 新生报名
 *
 * @author earl
 * @date 2017-05-22 20:57:59
 */
@Service("wechatRegisterService")
@Transactional
public class WechatRegisterServiceImpl extends BaseService<WechatRegister,Long> implements WechatRegisterService {

	@Autowired
	private WechatRegisterMapper wechatRegisterMapper;


    @Override
    protected IBaseDao <WechatRegister> getBaseDao() {
        return wechatRegisterMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<WechatRegister> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<WechatRegister> list = wechatRegisterMapper.pageList(search);
        PageInfo <WechatRegister> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param registerIds   id数组
     */
    @Override
    public void deleteBatch(Long [] registerIds){
        wechatRegisterMapper.deleteBatch(registerIds);
    }
}
