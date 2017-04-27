package com.earl.spBoot.common.exception;


import com.earl.spBoot.common.constants.ResultCode;

/**
 * 自定义异常——json异常
 * Created by earl on 2017/3/25.
 */
public class SyJsonException extends SyException {

    private static final long serialVersionUID = 1L;

    public SyJsonException(Throwable cause) {
        super(ResultCode.JSON_ERROR, cause);
    }

}
