package com.earl.spBoot.admin.web;

import com.alibaba.fastjson.JSON;
import com.earl.spBoot.admin.base.BaseController;
import com.earl.spBoot.bean.entity.DemoUser;
import com.earl.spBoot.bean.vo.DemoUserVO;
import com.earl.spBoot.business.service.DemoUserService;
import com.earl.spBoot.common.constants.ResultCode;
import com.earl.spBoot.common.constants.ResultResponse;
import com.earl.spBoot.common.util.BeanUtils;
import com.earl.spBoot.common.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * demo测试controller
 * Created by earl on 2017/3/27.
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoUserService demoUserService;


    @Autowired
    private RedisTemplate redisTemplate;

    private static final String DEMO_LIST ="demoList";


    //分页
    @RequestMapping("list")
    public @ResponseBody String pageList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize,String search)  {
        PageInfo page = demoUserService.pageList(pageNum,pageSize,search);
        return JSON.toJSONString( page);
    }

    //事务测试
    @RequestMapping(value="transactionTest",method = RequestMethod.GET)
    public @ResponseBody  ResultResponse   saveDemoUser()   {
         demoUserService.save();
         return ResultUtil.getSuccess();
    }

    //缓存获取列表，方式一
    @RequestMapping(value="cachePageList",method = RequestMethod.POST)
    public @ResponseBody String cachePageList(@RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "10")Integer pageSize,String search) {
        ValueOperations<String,PageInfo> operations = redisTemplate.opsForValue();
        PageInfo page = operations.get(DEMO_LIST + pageNum + search );
        //若缓存已存在，直接返回页面显示
        if (page != null){
            log.debug("@@@@@@@   读取缓存返回 @@@@@@@@@@"+page.toString());
            return JSON.toJSONString( page);
        }
        page = demoUserService.pageList(pageNum,pageSize,search);
        if ( CollectionUtils.isNotEmpty(page.getList()) ){
            //缓存一分钟
            operations.set(DEMO_LIST+pageNum+search , page ,1, TimeUnit.MINUTES);
        }
        return JSON.toJSONString( page);
    }

    //缓存获取列表，方式二，注解
    @RequestMapping(value="cachePageList2",method = RequestMethod.POST)
    @Cacheable(value = "cachePageList2",key = "#pageNum + #search" )       //放至缓存
    public @ResponseBody String cachePageList2(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10")Integer pageSize,String search)  {
        PageInfo page = demoUserService.pageList(pageNum,pageSize,search);
        return  JSON.toJSONString( page);
    }

    //保存
    @RequestMapping(value="save",method=RequestMethod.POST)
    public  @ResponseBody ResultResponse   save( DemoUser po)   {
        if ( po == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        //实体保存
        po.setCreateDate(new Date());
        demoUserService.insert(po);
        return ResultUtil.getSuccess();
    }

    //编辑
    @RequestMapping(value="edit",method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value="id")String id) {
        ModelAndView view = new ModelAndView("/demo/edit");
        DemoUser po = demoUserService.selectByPrimaryKey(id);
        view.addObject("po", po);
        return view;
    }

    //更新
    @RequestMapping(value="update",method=RequestMethod.POST)
    public    @ResponseBody ResultResponse update(DemoUserVO vo)   {
        if ( vo == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        DemoUser po = demoUserService.selectByPrimaryKey(vo.getId());
        if ( po == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        BeanUtils.copyProperties(vo,po, BeanUtils.getNullPropertyNames(vo));
        //更新
        demoUserService.updateByPrimaryKey(po);
        return ResultUtil.getSuccess();
    }

    //删除
    @RequestMapping("delete")
    public  @ResponseBody  ResultResponse   delete( String[] id )  {
        if (ArrayUtils.isEmpty(id)){
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        for (String tempId : id) {
            demoUserService.deleteByPrimaryKey(tempId);
        }
        return ResultUtil.getSuccess( );
    }

}
