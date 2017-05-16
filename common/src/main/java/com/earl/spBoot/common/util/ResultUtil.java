package com.earl.spBoot.common.util;


import com.alibaba.fastjson.JSON;
import com.earl.spBoot.common.constants.ResultCode;

import java.util.HashMap;
import java.util.Map;

/**
 * json返回工具
 * Created by earl on 2017/3/25.
 */
public final class ResultUtil {

    private ResultUtil(){}

    public static String getError() {
        return getError(ResultCode.OP_ERROR.getCode());
    }


    public static String getError(String code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.FAILURE.getCode());
        map.put(ResultCode.RETCODE.getCode(), code);
        map.put(ResultCode.ERROR.getCode(), ResultCode.getMessage(code));
        return JSON.toJSONString(map);
    }


    public static String getError(String code, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.FAILURE.getCode() );
        map.put(ResultCode.RETCODE.getCode(), code);
        map.put(ResultCode.ERROR.getCode(), message);
        return JSON.toJSONString(map);
    }

    public static String getError(String code, String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.FAILURE.getCode());
        map.put(ResultCode.RETCODE.getCode(), code);
        map.put(ResultCode.ERROR.getCode(), ResultCode.getMessage(code));
        map.put(key, value);
        return JSON.toJSONString(map);
    }

    public static String getError(String code, String[] keys, Object... values) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.FAILURE.getCode() );
        map.put(ResultCode.RETCODE.getCode(), code);
        map.put(ResultCode.ERROR.getCode(), ResultCode.getMessage(code));
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        return JSON.toJSONString(map);
    }

    public static String getSuccess() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.SUCCESS.getCode() );
        map.put(ResultCode.RETCODE.getCode(), ResultCode.SUCCESS_CODE.getMsg());
        return JSON.toJSONString(map);
    }

    public static String getSuccess(Object response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.SUCCESS.getCode() );
        map.put(ResultCode.RETCODE.getCode(), ResultCode.SUCCESS_CODE.getMsg());
        map.put(ResultCode.RESPONSE.getCode(), response);
        return JSON.toJSONString(map);
    }

    public static String getSuccess(String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.SUCCESS );
        map.put(ResultCode.RETCODE.getCode(), ResultCode.SUCCESS_CODE.getMsg());
        map.put(key, value);
        return JSON.toJSONString(map);
    }

    public static String getSuccess(String[] keys, Object... values) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS.getCode(), ResultCode.SUCCESS );
        map.put(ResultCode.RETCODE.getCode(), ResultCode.SUCCESS_CODE.getMsg());
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        return JSON.toJSONString(map);
    }

}
