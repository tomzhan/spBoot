package com.earl.spBoot.common.util;



import com.earl.spBoot.common.constants.ResultCode;
import com.earl.spBoot.common.constants.ResultMap;

import java.util.HashMap;
import java.util.Map;

/**
 * json返回工具
 * Created by earl on 2017/3/25.
 */
public final class ResultUtil {

    private ResultUtil(){}

    public static String getError() {
        return getError(ResultCode.OP_ERROR);
    }


    public static String getError(String code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.FAILURE);
        map.put(ResultCode.RETCODE, code);
        map.put(ResultCode.ERROR, ResultMap.getMessage(code));
        return JsonUtil.toJsonString(map);
    }


    public static String getError(String code, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.FAILURE);
        map.put(ResultCode.RETCODE, code);
        map.put(ResultCode.ERROR, message);
        return JsonUtil.toJsonString(map);
    }

    public static String getError(String code, String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.FAILURE);
        map.put(ResultCode.RETCODE, code);
        map.put(ResultCode.ERROR, ResultMap.getMessage(code));
        map.put(key, value);
        return JsonUtil.toJsonString(map);
    }

    public static String getError(String code, String[] keys, Object... values) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.FAILURE);
        map.put(ResultCode.RETCODE, code);
        map.put(ResultCode.ERROR, ResultMap.getMessage(code));
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        return JsonUtil.toJsonString(map);
    }

    public static String getSuccess() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.SUCCESS);
        map.put(ResultCode.RETCODE, ResultCode.SUCCESS_CODE);
        return JsonUtil.toJsonString(map);
    }

    public static String getSuccess(Object response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.SUCCESS);
        map.put(ResultCode.RETCODE, ResultCode.SUCCESS_CODE);
        map.put(ResultCode.RESPONSE, response);
        return JsonUtil.toJsonString(map);
    }

    public static String getSuccess(String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.SUCCESS);
        map.put(ResultCode.RETCODE, ResultCode.SUCCESS_CODE);
        map.put(key, value);
        return JsonUtil.toJsonString(map);
    }

    public static String getSuccess(String[] keys, Object... values) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ResultCode.STATUS, ResultCode.SUCCESS);
        map.put(ResultCode.RETCODE, ResultCode.SUCCESS_CODE);
        if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                map.put(keys[i], values[i]);
            }
        }
        return JsonUtil.toJsonString(map);
    }

}
