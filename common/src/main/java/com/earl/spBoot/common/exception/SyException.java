package com.earl.spBoot.common.exception;


import com.earl.spBoot.common.constants.ResultCode;

/**
 * 自定义异常
 * Created by earl on 2017/3/25.
 */
public class SyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String resultCode;

    public SyException(Throwable cause) {
        super(cause);
        this.resultCode = ResultCode.OP_ERROR.getCode();
    }

    public SyException(String resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }


    public SyException(String resultCode) {
        super(ResultCode.getMessage(resultCode));
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return ResultCode.getMessage(resultCode);
    }

}
