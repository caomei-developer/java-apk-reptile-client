package com.charles.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class JsoupUtil {

    public static void getJsoup(String url, HttpCallback httpCallback) throws Exception {
        HttpsUrlValidator.retrieveResponseFromServer(url);
        Document document = Jsoup.connect(url).get();
        httpCallback.onSuccess(document);
    }

    public interface HttpCallback {
        void onSuccess(Document body) throws Exception;

        void onFail(String msg);
    }

}
