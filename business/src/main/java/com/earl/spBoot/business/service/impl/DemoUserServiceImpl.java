package com.earl.spBoot.business.service.impl;

import com.earl.spBoot.bean.entity.DemoUser;
import com.earl.spBoot.bean.vo.DemoUserVO;
import com.earl.spBoot.business.base.BaseService;
import com.earl.spBoot.business.base.IBaseDao;
import com.earl.spBoot.business.dao.DemoUserMapper;
import com.earl.spBoot.business.service.DemoUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.earl.spBoot.common.util.FontUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * demo
 * Created by earl on 2017/3/29.
 */
@Service
@Transactional             //开启事务
public class DemoUserServiceImpl extends BaseService<DemoUser,String> implements DemoUserService {

    @Autowired
    private DemoUserMapper  demoUserMapper;

    @Override
    protected IBaseDao<DemoUser> getBaseDao() {
        return demoUserMapper;
    }

    @Override
    public PageInfo pageList(int pageNum, int pageSize,String userName) {
        PageHelper.startPage(pageNum, pageSize);
        List<DemoUserVO> list = demoUserMapper.pageList(userName);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }


    @Override
    public void save()  {
        for (int i = 0;i < 50;i++){
            if( i == 45){
                throw new NullPointerException("测试事务回滚~~~~~~~~~~~~~~~~~~~~");
            }
            DemoUser demoUser = new DemoUser();
            demoUser.setUsername(FontUtils.getStringRandom(8));
            demoUser.setName(FontUtils.getRandomChinaFont(3));
            demoUser.setCreateDate(new Date());
            insert(demoUser);
        }
    }
 


}
