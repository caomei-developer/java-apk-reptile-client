package com.charles.data.chuai.category;

import com.charles.api.ChunaiApi;
import com.charles.data.chuai.category.bean.BookCategoryListBean;
import com.charles.data.chuai.category.bean.CategoryBean;
import com.charles.data.chuai.category.bean.Search;
import com.charles.data.qbxs.JSon;
import com.charles.http.HttpUtil;
import com.charles.util.DBUtil;
import com.charles.util.JSONUtil;
import com.charles.util.RequestUtil;
import com.charles.util.SQLDBUtil;
import com.charles.util.string.CosineSimilarity;
import com.charles.util.xlxs.XlxsUtils;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {
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
        List<String> keyword = XlxsUtils.read(DBUtil.searchXlsxPath);
        System.out.println(keyword.size());
        for (String string : keyword) {
            getSearch(string, 1);
        }

    }


    private static Map<String, String> getBookIds() throws SQLException {
        Map<String, String> map = new HashMap<>();
        Statement stmt = (Statement) SQLDBUtil.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(DBUtil.getBookNameAndBookAuthorName);
        while (resultSet.next()) {
            map.put(resultSet.getString("book_name"), resultSet.getString("author_name"));
        }
        stmt.close();
        return map;
    }

    private static void getCategory() throws Exception {
        HttpUtil.http(ChunaiApi.CI_BASE_URL + ChunaiApi.APP_CATEGORY, new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) {
                CategoryBean categoryBean = JSONUtil.parseObject(body, CategoryBean.class);
                System.out.println(JSONUtil.toJSONString(categoryBean));
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    /**
     * @param ismanhua 暂时不知道代表什么
     * @param xstype   完结 0 / 1
     * @param tstype   类别
     * @param offset   页数
     * @param limit    每页的数量
     * @param isfree   是否免费
     * @param order    点击量或者更新时间 update_time/desc
     */

    public static void getCategoryBookList(int tstype, int ismanhua, int xstype, int offset, int isfree, int limit, String order, CategoryEnum categoryEnum) throws Exception {

        HttpUtil.postHttp(ChunaiApi.CI_BASE_URL + ChunaiApi.APP_CATEGORY_LIST, RequestUtil.buildMap("tstype", tstype, "ismanhua", ismanhua, "xstype", xstype, "offset", offset, "isfree", isfree, "limit", limit, "order", order), new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) {
                BookCategoryListBean bookCategoryListBean = JSONUtil.parseObject(body, BookCategoryListBean.class);
                for (BookCategoryListBean.DataBean dataBean : bookCategoryListBean.getData()) {
                    System.out.println(dataBean.getBookName());
                }

            }

            @Override
            public void onFail(String msg) {

            }
        });

    }

    public static void getSearch(String keyword, Integer pn) throws Exception {
        HttpUtil.postHttp(ChunaiApi.CI_BASE_URL + ChunaiApi.APP_SEARCH, RequestUtil.buildMap("search", keyword, "offset", pn.intValue(),"limit", 20), new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) {
                Search search = JSONUtil.parseObject(body,Search.class);
                for (Search.DataBean resultBean : search.getData()) {
                    double strSimilarity = CosineSimilarity.getSimilarity(keyword, resultBean.getArticlename());
                    if (strSimilarity >= 0.7f && strSimilarity < 1.0) {
                        System.out.println(strSimilarity * 100);
                        addData(resultBean, keyword, strSimilarity * 100);
                    }
                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    //1001搜索
    //获取分类add到数据库
    private static void addData(Search.DataBean dataBean, String primary_book_name, double similarity) {
        try {
            preparedStatement.setInt(1, dataBean.getAid());
            preparedStatement.setInt(2, 1003);
            preparedStatement.setString(3, dataBean.getArticlename());
            preparedStatement.setString(4, primary_book_name);
            preparedStatement.setDouble(5, similarity);
            preparedStatement.setString(6, dataBean.getAuthor());
            preparedStatement.setString(7, dataBean.getImage());
            preparedStatement.setString(8, dataBean.getSort());
            preparedStatement.setString(9, "暂无");
            preparedStatement.setString(10, "暂无");
            preparedStatement.setString(11, "无返回");
            preparedStatement.setString(12, dataBean.getIntro());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public enum CategoryEnum {
        ALL, IS_FINISHED, SERIAL, FREE,
    }

}

