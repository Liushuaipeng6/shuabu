package com.lalala.shuabu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

/**
 */
public class R {
    /**
     * 用户消息返回数据
     * @param code 代码
     * @param mess 信息
     * @param obj 返回信息
     * @return
     */
    public static String message(int code,String mess,Object obj)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", code);
        map.put("message", mess);
        if(null!=obj)
        {
            map.put("body",obj);
        }
        return JSON.toJSONString(map);
    }
    /**
     * 用户消息返回数据，只有消息记录
     * @param code 代码
     * @param mess 信息
     * @return
     */
    public static String message(int code,String mess)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", code);
        map.put("message", mess);
        return JSON.toJSONString(map);
    }
    /**
     * 正确的消息返回
     * @param mess 信息
     * @return
     */
    public static String success(String mess)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", Const.SUCCESS);
        map.put("message", mess);
        return JSON.toJSONString(map);
    }
    /**
     * 正确的消息返回
     * @param mess 信息
     * @return
     */
    public static String success(String mess,Object obj)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", Const.SUCCESS);
        map.put("message", mess);
        if(null!=obj)
        {
            map.put("body",obj);
        }
        return JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect,WriteMapNullValue);    //避免循环引用
    }
    /**
     * 错误消息
     * @param mess 信息
     * @return
     */
    public static String error(String mess)
    {
        throw new GlobalException(mess, Const.ERROR);
    }
    /**
     * 错误消息
     * @param mess 信息
     * @param code 自定义code
     * @return
     */
    public static String error(String mess,int code)
    {
        throw new GlobalException(mess, code);
    }
}
