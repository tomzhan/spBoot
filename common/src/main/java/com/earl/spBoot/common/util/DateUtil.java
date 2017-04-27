package com.earl.spBoot.common.util;

/**
 * Created by earl on 2017/3/25.
 */
public final class DateUtil {


    private DateUtil(){}

    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String LONG_NO_LINE                  = "yyyyMMddHHmmss";

    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String LONE_HAS_LINE                  = "yyyy-MM-dd HH:mm:ss";
    /** 完整时间 yyyy-MM-dd  */
    public static final String NORMAL                  = "yyyy-MM-dd HH:mm";

    /** 年月日(无下划线) yyyyMMdd */
    public static final String SHORT_NO_LINE                 = "yyyyMMdd";
    /** 年月日  yyyy-MM-dd */
    public static final String SHORT_HAS_LINE                 = "yyyy-MM-dd";
    /** 年月日  yyyy/MM/dd */
    public static final String SHORT_DIAGONAL_LINE                 = "yyyy/MM/dd";


    /** 年月(无下划线) yyyyMM */
    public static final String SHORT_YEAR_WITHOUT_lINE                 = "yyyyMM";

    //一天中开始的时间
    public static final String DAY_BEGIN_TIME = " 00:00:00";
    //一天中结束的时间
    public static final String DAY_END_TIME = " 23:59:59";


}
