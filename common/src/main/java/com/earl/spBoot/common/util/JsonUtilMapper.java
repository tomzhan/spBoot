package com.earl.spBoot.common.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.earl.spBoot.common.exception.SyJsonException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 */
public final class JsonUtilMapper {

    private final static ObjectMapper jackSon;
    private final static ObjectMapper jsckSonDes;
    private final static TypeFactory typeFactory;

    private JsonUtilMapper(){}


    static {
        jackSon = new ObjectMapper();
        jackSon.setDateFormat(new SimpleDateFormat(DateUtil.LONE_HAS_LINE));// 序列化时间格式
        jackSon.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // jackSon.setSerializationInclusion(Include.NON_NULL);// 忽略为null的数据

        jsckSonDes = new ObjectMapper();
        // 反序列化时间格式无法统一，故不定
        jsckSonDes.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // jackSon.setSerializationInclusion(Include.NON_NULL);// 忽略为null的数据
        typeFactory = jsckSonDes.getTypeFactory();
    }

    public final static String toString(Object obj) {
        try {
            return jackSon.writeValueAsString(obj);
        } catch (Exception e) {
            throw new SyJsonException(e);
        }
    }

    public final static <T> T toObject(String jsonStr, Class<T> type) {
        try {
            return jsckSonDes.readValue(jsonStr, type);
        } catch (Exception e) {
            throw new SyJsonException(e);
        }
    }

    public final static <T> List<T> toObjects(String jsonStr, Class<T> type) {
        try {
            return jsckSonDes.readValue(jsonStr, typeFactory.constructParametricType(ArrayList.class, type));
        } catch (Exception e) {
            throw new SyJsonException(e);
        }
    }

}
