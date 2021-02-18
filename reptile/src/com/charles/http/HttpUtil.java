package com.charles.http;

import com.charles.util.JSONUtil;
import okhttp3.*;

import java.util.Map;


public class HttpUtil {
    public static OkHttpClient okHttpClient = new OkHttpClient();

    public static void http(String url, HttpCallback httpCallback) throws Exception {
        Response response = okHttpClient.newCall(request(url)).execute();
        if (response.isSuccessful()) {
            String txt = response.body().string();
            httpCallback.onSuccess(txt);
        } else {
            httpCallback.onFail(response.message());
        }
    }
    //趣步搜索
    public static void postHttp(String url, String keyword, int page, HttpCallback httpCallback) throws Exception {
        Response response = okHttpClient.newCall(request(url, keyword, page)).execute();
        if (response.isSuccessful()) {
            String txt = response.body().string();
            httpCallback.onSuccess(txt);
        } else {
            httpCallback.onFail(response.message());
        }
    }

    //腐竹
    //纯爱
    private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");


    public static void getHttp(String url,Map<String, String> map,HttpCallback httpCallback) throws Exception {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        if (map != null) {
            for(Map.Entry<String, String> param : map.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(),param.getValue());
            }
        }
        Request request = new Request.Builder().url(httpBuilder.build()).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String txt = response.body().string();
            httpCallback.onSuccess(txt);
        } else {
            httpCallback.onFail(response.message());
        }
    }

    public static void stringPostHttp(String url, Map<String, String> map, HttpCallback httpCallback) throws Exception {
        Response response = okHttpClient.newCall(stringRequest(url, map)).execute();
        if (response.isSuccessful()) {
            String txt = response.body().string();
            httpCallback.onSuccess(txt);
        } else {
            httpCallback.onFail(response.message());
        }
    }

    public static void postHttp(String url, Map<String, Object> map, HttpCallback httpCallback) throws Exception {
        Response response = okHttpClient.newCall(request(url, map)).execute();
        if (response.isSuccessful()) {
            String txt = response.body().string();
            httpCallback.onSuccess(txt);
        } else {
            httpCallback.onFail(response.message());
        }
    }

    private static Request request(String url, Map<String, Object> map) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSONUtil.toJSONString(map));
        return new Request.Builder()
                .url(url)
                .post(body)
                .build();
    }

    private static Request stringRequest(String url, Map<String, String> map) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSONUtil.toJSONString(map));
        return new Request.Builder()
                .url(url)
                .post(body)
                .build();
    }

    public static Request request(String url) {
        return new Request.Builder()
                .url(url)
                .build();
    }

    /**
     * 趣步免费小说  post
     *
     * @param url
     * @param keyword
     * @param page
     * @return
     */
    public static Request request(String url, String keyword, int page) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("kw", keyword);
        builder.add("pn", "" + page);
        FormBody formBody = builder.build();
        return new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/vnd.yourapi.v1.full+json")
                .addHeader("Sys-Platform", "Android")
                .addHeader("User-Agent", "Android")
                .addHeader("Version-Code", "2600")
                .addHeader("Version-Name", "2.6.0")
                .addHeader("appid", "qbmfxs")
                .addHeader("Channel", "oppo")
                .addHeader("Device-Id", "a_imei863478037919366")
                .addHeader("imei", "86347803791936")
                .addHeader("Token", "gAAAAABf_9sCA73yaqBiTNU9VgeFDNcrt3Bvwwbrtg_QtbVth8HBE_vYPUsVSoMVpsZfk4GwW69CSPat1-W4J45v0sNf3PmccSYOEl3m9DFXZ7V3fK9A8GcyGZOWCGcLW0oo1sKiWXlG8WXtSZigOzfuIlNG_9y-ovp_ffyophNerKXpEMtK9Dkb97YzmHGBENvHR5AMo9AT1rmIpJLhIEYblvQANuNyzA==")
                .addHeader("Sign", "3CFC95F9D5D48638778B0F06B20E7592")
                .addHeader("Operator", "no")
                .addHeader("Mob-Model", "m3note")
                .addHeader("Mob-Mfr", "Meizu")
                .addHeader("Sys-Release", "7.0")
                .addHeader("Screen-Height", "1920")
                .addHeader("Screen-Width", "1080")
                .post(formBody)
                .build();
    }

    public interface HttpCallback {
        void onSuccess(String body) throws Exception;

        void onFail(String msg);
    }
}
