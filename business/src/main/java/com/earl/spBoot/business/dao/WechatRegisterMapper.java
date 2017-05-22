package com.earl.spBoot.business.dao;

import java.util.List;
import com.earl.spBoot.business.base.IBaseDao;
import com.earl.spBoot.bean.entity.WechatRegister;
import org.apache.ibatis.annotations.Param;


/**
 * 新生报名
 * 
 * @author earl
 * @date 2017-05-22 20:57:59
 */
public interface WechatRegisterMapper extends IBaseDao<WechatRegister> {

    List<WechatRegister> pageList(@Param("search") String search);

    void deleteBatch(@Param("registerIds") Long[] registerIds);

}
