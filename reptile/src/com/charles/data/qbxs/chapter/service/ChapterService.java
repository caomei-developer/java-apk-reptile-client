package com.charles.data.qbxs.chapter.service;

import com.charles.api.QbxsApi;
import com.charles.data.qbxs.JSon;
import com.charles.data.qbxs.chapter.Chapter;
import com.charles.http.HttpUtil;
import com.charles.util.DesUtil;
import com.charles.util.DBUtil;
import com.charles.util.SQLDBUtil;
import com.charles.util.JSONUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChapterService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < getBookIds().size(); i++) {
            System.out.print(getBookIds().get(i) + "\n");
            getChapter(getBookIds().get(i));
        }
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
            public void OnSuccess(String body) throws Exception {
                JSon jSon = JSONUtil.parseObject(body, JSon.class);
                Chapter dataJson = JSONUtil.parseObject(DesUtil.decode(jSon.getData(), DesUtil.getAppKey), Chapter.class);
                System.out.print(JSONUtil.toJSONString(dataJson) + "\n");
                for (Chapter.ResultBean resultBean : dataJson.getResult()) {
                    addData(bookId, resultBean);
                }
            }

            @Override
            public void onFail(String msg) {
            }
        });
    }

    //获取分类add到数据库
    private static void addData(int booKId, Chapter.ResultBean resultBean) {
        try {
            preparedStatement.setInt(1, resultBean.getChapterId());
            preparedStatement.setString(2, resultBean.getChapter_name());
            preparedStatement.setInt(3, resultBean.getChapter_level());
            preparedStatement.setInt(4, resultBean.getWords_count());
            preparedStatement.setInt(5, resultBean.getIs_free());
            preparedStatement.setInt(6, booKId);
            preparedStatement.executeUpdate();
            System.out.print("添加数据" + JSONUtil.toJSONString(resultBean) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取book章节
    public static void getChapter(int id) throws Exception {
        String url = QbxsApi.CHAPTER_URL.replace("***", "" + (id / 1000)).replace("###", "" + id);
        ChapterService.getChapter(url, id);
    }

    private static List<Integer> getBookIds() throws SQLException {
        List<Integer> bookIds = new ArrayList<>();
        Statement stmt = (Statement) SQLDBUtil.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(DBUtil.getBookIdsSql);
        while (resultSet.next()) {
            bookIds.add(resultSet.getInt("book_id"));
        }
        stmt.close();
        return bookIds;
    }
}
