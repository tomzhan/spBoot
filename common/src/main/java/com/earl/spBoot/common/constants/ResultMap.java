package com.earl.spBoot.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by earl on 2017/3/25.
 */
public class ResultMap {

    private static Map<Object, String> map = new HashMap<Object, String>();

    static {
        map.put(ResultCode.SUCCESS, "成功");
        map.put(ResultCode.UN_KNOW_EXCEPTION, "未知异常");
        map.put(ResultCode.CLIENT_ERROR, "数据格式错误");
        map.put(ResultCode.OP_ERROR, "操作失败，请重试");
        map.put(ResultCode.JSON_ERROR, "Json操作错误,请检查数据格式");
        map.put(ResultCode.JDBC_ERROR, "数据库操作错误");
        map.put(ResultCode.PARAM_ERROR, "参数错误");
        map.put(ResultCode.NO_PERMISSIONS, "无权限进行此操作!");
        map.put(ResultCode.DATA_ASSOCIATION, "操作失败,数据存在关联关系");
        map.put(ResultCode.DATA_NOT_EXIST, "操作失败,记录不存在");
        map.put(ResultCode.ILLEGAL_OPERATING, "操作失败,用户非法操作");
        map.put(ResultCode.WECHAT_ERROR, "操作失败，对接微信配置发生错误");
        map.put(ResultCode.CAPTCHA_ERROR, "验证码错误");
        map.put(ResultCode.UNKNOWN_ERROR, "未知错误");

        map.put(ResultCode.ACCOUNT_CREATE_FAIL, "用户创建失败");
        map.put(ResultCode.ACCOUNT_LONG_ERROR, "用户名或密码错误");
        map.put(ResultCode.ACCOUNT_PWD_ERROR, "密码与确认密码不一致");
        map.put(ResultCode.ACCOUNT_NAME_EMPTY, "用户名不能为空");
        map.put(ResultCode.ACCOUNT_TYPE_ERROR, "用户类型错误");
        map.put(ResultCode.ACCOUNT_UPDATE_FAIL, "用户修改失败");
        map.put(ResultCode.ACCOUNT_TRY_TOO_MORE, "登录尝试次数过多，请10分钟后重试");
        map.put(ResultCode.ACCOUNT_LOCKED, "账号被锁定");
        map.put(ResultCode.ACCOUNT_NOT_OPEN, "未开发登录的用户");
    }

    private ResultMap(){}

    public static String getMessage(String resultCode) {
        return map.get(resultCode);
    }

}
