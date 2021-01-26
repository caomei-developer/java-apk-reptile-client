package com.charles.data.qbxs.search.service;

import com.charles.api.QbxsApi;
import com.charles.data.qbxs.JSon;
import com.charles.data.qbxs.search.Search;
import com.charles.http.HttpUtil;
import com.charles.util.*;
import com.charles.util.string.CosineSimilarity;
import com.charles.util.xlxs.XlxsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class SearchService {

    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {

        String sql = DBUtil.addSearchBook;

        if (connection != null) {
            preparedStatement.close();
            connection.close();
        }
        connection = SQLDBUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        addSearchBook();
    }




    private static void addSearchBook() throws Exception {
        List<String> keyword = XlxsUtils.read(DBUtil.searchXlsxPath);
        System.out.println("start");
        for (String key : keyword) {
            HttpUtil.postHttp(QbxsApi.SEARCH_URL, key, 1, new HttpUtil.HttpCallback() {
                @Override
                public void OnSuccess(String body) throws Exception {
                    JSon jSon = JSONUtil.parseObject(body, JSon.class);
                    Search dataJson = JSONUtil.parseObject(DesUtil.decode(jSon.getData(), DesUtil.getAppKey), Search.class);
                    for (Search.ResultBean resultBean : dataJson.getResult()) {
                        double strSimilarity = CosineSimilarity.getSimilarity(key, resultBean.getBook_name());
                        if (strSimilarity >= 0.7f && strSimilarity < 1.0) {
                            System.out.println(strSimilarity * 100);
                            addData(resultBean, key, strSimilarity);
                        }
                    }
                }

                @Override
                public void onFail(String msg) {
                    System.out.println(msg);
                }
            });
        }
        System.out.println("stop");
    }

    private static void checkSimilarity(Search.ResultBean resultBean, String primaryBookName, String primaryBookBrief, String primaryBookAuthorName) {
        double bookNameSimilarity =CosineSimilarity.getSimilarity(primaryBookName, resultBean.getBook_name());
        double bookAuthorNameSimilarity = CosineSimilarity.getSimilarity(primaryBookAuthorName, resultBean.getAuthor_name());
        double bookBriefSimilarity = CosineSimilarity.getSimilarity(primaryBookBrief, resultBean.getBook_brief());
        if (bookNameSimilarity > 70f || bookBriefSimilarity > 70f) {
            addData(resultBean, primaryBookName, bookNameSimilarity);
        }
    }

    //1001搜索
    //获取分类add到数据库
    private static void addData(Search.ResultBean resultBean, String primary_book_name, double similarity) {
        try {
            preparedStatement.setInt(1, resultBean.getBook_id());
            preparedStatement.setInt(2, 1001);
            preparedStatement.setString(3, resultBean.getBook_name());
            preparedStatement.setString(4, primary_book_name);
            preparedStatement.setDouble(5, similarity);
            preparedStatement.setString(6, resultBean.getAuthor_name());
            preparedStatement.setString(7, resultBean.getBook_cover());
            preparedStatement.setString(8, resultBean.getCategory_name());
            preparedStatement.setString(9, resultBean.getBook_path());
            preparedStatement.setString(10, resultBean.getBook_tags().toString());
            preparedStatement.setString(11, resultBean.getChapter_new_name());
            preparedStatement.setString(12, resultBean.getBook_brief());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
