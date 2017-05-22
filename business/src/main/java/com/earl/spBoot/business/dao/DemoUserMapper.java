package com.earl.spBoot.business.dao;

import com.earl.spBoot.bean.entity.DemoUser;
import com.earl.spBoot.bean.vo.DemoUserVO;
import com.earl.spBoot.business.base.IBaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DemoUserMapper extends IBaseDao<DemoUser> {

    List<DemoUserVO> pageList(@Param("search") String search);
}