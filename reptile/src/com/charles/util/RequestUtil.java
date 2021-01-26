package com.charles.util;

import com.charles.helper.DeviceHelper;

import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
    public static Map<String, Object> buildMap(Object... keyValues) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (int i = 0; i < keyValues.length; i += 2) {
            resultMap.put((String) keyValues[i], keyValues[i + 1]);
        }
        return resultMap;
    }

    public static Map<String, String> buildMap(String... keyValues) {
        return fixedMap(keyValues);
    }

    //腐竹 请求公共参数
    public static Map<String,String> fixedMap(String... values){
        Map<String , String> map = new HashMap<>();
        map.put("consumerKey", "FUZHU_ANDROID");
        map.put("mType", "MEIZU-m3 note");
        map.put("PACKINGCHANNEL", "WANDOUJIA");
        map.put("imei", DeviceHelper.imei);
        map.put("androidID", DeviceHelper.android_id);
        for (int i = 0; i < values.length; i += 2) {
            map.put(values[i], values[i + 1]);
        }
        return map;
    }
}
