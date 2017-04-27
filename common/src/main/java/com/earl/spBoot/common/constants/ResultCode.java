package com.earl.spBoot.common.constants;

/**
 * 状态码
 * Created by earl on 2017/3/25.
 */
public class ResultCode {

    private ResultCode(){}

    //-----------固定key名称----------------
    public static final String RETCODE = "retcode";
    public static final String MESSAGE = "message";
    public static final String RESPONSE = "response";
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;
    public static final String STATUS = "status";
    public static final String ERROR = "error";

    // ------------------------固定状态码------------------------------------

    public static final String SUCCESS_CODE = "200";        // 服务器正常
    public static final String UN_KNOW_EXCEPTION = "500";    //服务器异常
    public static final String CLIENT_ERROR = "400";            //数据格式错误
    public static final String PARAM_ERROR = "401";            //参数错误
    public static final String NO_PERMISSIONS = "403";        //权限不够
    public static final String OP_ERROR = "501";            //操作错误
    public static final String JSON_ERROR = "502";
    public static final String JDBC_ERROR = "503";            //jdbc错误
    public static final String DATA_ASSOCIATION = "504";        //数据有关联关系
    public static final String DATA_NOT_EXIST = "505";        //记录不存在
    public static final String ILLEGAL_OPERATING = "506";        //非法操作
    public static final String WECHAT_ERROR = "507";           //微信接口错误
    public static final String UNKNOWN_ERROR = "508";        //未知错误


    //-----------------------用户相关，状态码1000~1200 -----------------------------------
    /**
     * 用户创建失败
     */
    public static final String ACCOUNT_CREATE_FAIL = "1000";
    /**
     * 用户名或密码错误
     */
    public static final String ACCOUNT_LONG_ERROR = "1001";
    /**
     * 两次输入密码不一致
     */
    public static final String ACCOUNT_PWD_ERROR = "1002";
    /**
     * 用户名不能为空
     */
    public static final String ACCOUNT_NAME_EMPTY = "1003";
    /**
     * 用户类型错误
     */
    public static final String ACCOUNT_TYPE_ERROR = "1004";

    /**
     * 用户更新失败
     */
    public static final String ACCOUNT_UPDATE_FAIL = "1005";
    /**
     * 登录尝试次数过多
     */
    public static final String ACCOUNT_TRY_TOO_MORE = "1006";

    /**
     * 用户被锁定
     */
    public static final String ACCOUNT_LOCKED = "1007";

    /**
     * 未开放登录的用户
     */
    public static final String ACCOUNT_NOT_OPEN = "1008";

    /**
     * 验证码错误
     */
    public static final String CAPTCHA_ERROR = "1009";

}
