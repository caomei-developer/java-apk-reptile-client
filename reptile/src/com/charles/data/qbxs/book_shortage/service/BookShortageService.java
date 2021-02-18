package com.charles.data.qbxs.book_shortage.service;

import com.charles.data.qbxs.JSon;
import com.charles.data.qbxs.chapter.Chapter;
import com.charles.http.HttpUtil;
import com.charles.util.DBUtil;
import com.charles.util.SQLDBUtil;
import com.charles.util.DesUtil;
import com.charles.util.JSONUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookShortageService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) {

    }

    public static void getChapter(String url, int bookId) throws Exception {
        String sql = DBUtil.chapterSql;
        if (connection != null) {
            preparedStatement.close();
            connection.close();
        }
        connection = SQLDBUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        HttpUtil.http(url, new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) throws Exception {
                JSon jSon = JSONUtil.parseObject(body, JSon.class);
                Chapter dataJson = JSONUtil.parseObject(DesUtil.decode(jSon.getData(), DesUtil.getAppKey), Chapter.class);
                System.out.print(JSONUtil.toJSONString(dataJson) + "\n");
                for (Chapter.ResultBean resultBean : dataJson.getResult()) {
                }
            }

            @Override
            public void onFail(String msg) {
            }
        });
    }
}
