package com.charles.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupUtil {

    public static void getJsoup(String url, HttpCallback httpCallback) throws Exception {
        HttpsUrlValidator.retrieveResponseFromServer(url);
        Document document = Jsoup.connect(url).get();
        httpCallback.OnSuccess(document);
    }

    public interface HttpCallback {
        void OnSuccess(Document body) throws Exception;

        void onFail(String msg);
    }

}
