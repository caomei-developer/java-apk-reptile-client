package com.charles.data.html;

import com.charles.http.JsoupUtil;
import com.charles.util.DBUtil;
import com.charles.util.SQLDBUtil;
import com.charles.util.string.CosineSimilarity;
import com.charles.util.xlxs.XlxsUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JsoupHtmlService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;
    private static String dj_url = "https://www.idejian.com/search?keyword=";
    public static void main(String[] args) throws Exception {
        String sql = DBUtil.addSearchBook;
        if (connection != null) {
            preparedStatement.close();
            connection.close();
        }
        connection = SQLDBUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        List<String> keyword = XlxsUtils.read(DBUtil.searchXlsxPath);
        System.out.println(keyword.size());
        for (String string : keyword) {
            getSearch(string);
        }
    }

    private static void getSearch(String k) throws Exception {

        JsoupUtil.getJsoup(dj_url + k, new JsoupUtil.HttpCallback() {
            @Override
            public void onSuccess(Document body) throws Exception {
                html(body, k);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void html(Document document, String k) {
        Elements postList = document.getElementsByClass("rank_ullist");
        for (int i = 0; i < postList.size(); i++) {
            Elements items_l = postList.get(i).getElementsByClass("items_l");
            for (int j = 0; j < items_l.size(); j++) {
                String newKeyword = items_l.get(j).getElementsByTag("a").first().getElementsByAttributeStarting("alt").attr("alt");
                double strSimilarity = CosineSimilarity.getSimilarity(k, newKeyword);
                if (strSimilarity >= 0.7f && strSimilarity < 1.0) {
                    System.out.println(strSimilarity * 100 + (k + "====" + newKeyword));
                }
            }
        }
    }
}
