package com.earl.spBoot.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import org.apache.commons.lang3.ArrayUtils;
import com.earl.spBoot.common.constants.ResultCode;
import com.earl.spBoot.common.constants.ResultResponse;
import com.earl.spBoot.common.util.BeanUtils;
import com.earl.spBoot.common.util.ResultUtil;
import com.earl.spBoot.bean.entity.WechatRegister;
import com.earl.spBoot.business.service.WechatRegisterService;


/**
 * 新生报名
 * 
 * @author earl
 * @date 2017-05-22 20:57:59
 */
@RestController
@RequestMapping("wechatregister")
@Api( description="新生报名接口")
public class WechatRegisterController {
	@Autowired
	private WechatRegisterService wechatRegisterService;

    @RequestMapping(value="/list",method = RequestMethod.POST )
    @ApiOperation(value = "新生报名分页列表",response = WechatRegister.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageNum", value = "页码，为空时默认1" ),
            @ApiImplicitParam(paramType = "query", dataType="int", name = "pageSize", value = "页数,为空时默认20" ),
            @ApiImplicitParam(paramType = "query", dataType="string", name = "search", value = "搜索字符" )
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse pageList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20")Integer pageSize, String search)  {
        return ResultUtil.getSuccess(wechatRegisterService.pageList(pageNum,pageSize,search));
    }


    @RequestMapping(value="/save",method = RequestMethod.POST )
    @ApiOperation(value = "保存新生报名",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse save(WechatRegister wechatRegister){
		wechatRegisterService.insert(wechatRegister);
        return ResultUtil.getSuccess();
    }

    @RequestMapping(value="/info",method = RequestMethod.GET )
    @ApiOperation(value = "获取新生报名信息",response = WechatRegister.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="Long", name = "registerId", value = "新生报名id" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse info(Long registerId ){
		WechatRegister wechatRegister = wechatRegisterService.selectByPrimaryKey(registerId);
        if (wechatRegister == null ){
            return ResultUtil.getError(ResultCode.DATA_NOT_EXIST.getCode());
        }
        return ResultUtil.getSuccess(wechatRegister);
    }


    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新新生报名",response = ResultResponse.class)
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse update(WechatRegister vo){
        if ( vo == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
		WechatRegister po = wechatRegisterService.selectByPrimaryKey(vo.getRegisterId());
        if ( po == null) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
        BeanUtils.copyProperties(vo,po, BeanUtils.getNullPropertyNames(vo));
        //更新
	    wechatRegisterService.updateByPrimaryKey(po);
        return ResultUtil.getSuccess();
    }
	


    @RequestMapping(value="/deleteBatch",method = RequestMethod.POST)
    @ApiOperation(value = "批量删除新生报名",response = ResultResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType="array", name = "registerIds", value = "新生报名id数组" ),
    })
    @ApiResponses({ @ApiResponse(code = 500,message = "服务器异常",response= ResultResponse.class)})
    public ResultResponse deleteBatch(Long [] registerIds){
        if (ArrayUtils.isEmpty(registerIds)) {
            return ResultUtil.getError(ResultCode.PARAM_ERROR.getCode());
        }
		wechatRegisterService.deleteBatch(registerIds);
        return ResultUtil.getSuccess();
    }

	
}
