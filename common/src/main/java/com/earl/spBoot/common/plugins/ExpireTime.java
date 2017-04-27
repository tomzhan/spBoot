package com.earl.spBoot.common.plugins;

/**
 * 缓存时间
 * Created by earl on 2017/4/5.
 */
public enum ExpireTime {

    NONE(0,"无固定期限"),ONE_SEC(1,"1秒钟"),FIVE_SEC(5,"5秒钟"), TEN_SEC(10,"10秒钟"),
    HALF_A_MIN(30,"30秒钟"), ONE_MIN(60,"1分钟"), FIVE_MIN(5*60,"5分钟"),TEN_MIN(10*60,"10分钟"),
    TWENTY_MIN(20*60,"20分钟"), HALF_AN_HOUR(30*60,"30分钟"),ONE_HOUR(60*60,"1小时"),
    ONE_DAY(24*60*60,"1天"), ONE_MON(30*24*60*60,"1个月"),ONE_YEAR(365*24*60*60,"1年");

    /**
     * 时间
     */
    private   int time;
    /**
     * 描述
     */
    private   String desc;

    ExpireTime(int time, String desc) {
        this.time = time;
        this.desc = desc;
    }


    /**
     * 获取具体时间
     *
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     * 获取时间描述信息
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 根据描述获取时间
     * @param desc 描述
     * @return time ，时间
     */
    public static Integer getKey(String desc) {
        for (ExpireTime temp : ExpireTime.values()) {
            if (temp.getDesc().equals(desc) || temp.getDesc() == desc) {
                return temp.getTime();
            }
        }
        return null;
    }

    /**
     * 根据时间获取描述
     * @param time 时间
     * @return desc 描述
     */
    public static String getValue(Integer time) {
        for (ExpireTime temp : ExpireTime.values()) {
            if (temp.getTime() == time) {
                return temp.desc;
            }
        }
        return null;
    }

}
