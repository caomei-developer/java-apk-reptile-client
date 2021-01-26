package com.charles.util;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;


public class JSONUtil {

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    public static byte[] toJSONBytes(Object object) {
        return JSON.toJSONBytes(object);
    }

    public static <T> T parseObject(String text, Class<T> cls) {
        return JSON.parseObject(text, cls);
    }

    public static <T> T parseObject(byte[] bytes, Class<T> cls) {
        return JSON.parseObject(bytes, cls);
    }

    public static <T> T parseObject(String text, Type type) {
        return JSON.parseObject(text, type);
    }

    public static <T> T parseObject(byte[] bytes, Type type) {
        return JSON.parseObject(bytes, type);
    }

    public static <T> List<T> parseArray(String text, Class<T> cls) {
        return JSON.parseArray(text, cls);
    }

    public static <T> List<T> parseArray(byte[] bytes, Class<T> cls) {
        return parseArray(bytes, "UTF-8", cls);
    }

    public static <T> List<T> parseArray(byte[] bytes, String charset, Class<T> cls) {
        try {
            return parseArray(new String(bytes, charset), cls);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    //
    public static String readJson(String filePath) throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
        int ch;
        StringBuffer stringBuffer = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            stringBuffer.append((char) ch);
        }
        fileReader.close();
        reader.close();
        return stringBuffer.toString();
    }


}
