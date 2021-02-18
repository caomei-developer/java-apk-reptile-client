package com.charles.data.qbxs.category.service;

import com.charles.api.QbxsApi;
import com.charles.data.qbxs.book_shortage.BookShortage;
import com.charles.data.qbxs.category.DataJson;
import com.charles.data.qbxs.JSon;
import com.charles.http.HttpUtil;
import com.charles.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CategoryService {

    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {

        String sql = DBUtil.addCategoryBook;
        if (connection != null) {
            preparedStatement.close();
            connection.close();
        }
        connection = SQLDBUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        addCategoryBook();
    }

    private static void addCategoryBook() throws Exception {
        HttpUtil.http(QbxsApi.CATEGORY_URL, new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) throws Exception {
                JSon jSon = JSONUtil.parseObject(body, JSon.class);
                DataJson dataJson = JSONUtil.parseObject(DesUtil.decode(jSon.getData(), DesUtil.getAppKey), DataJson.class);

                for (DataJson.ResultBean.BookListBean resultBean : dataJson.getResult().getBook_list()) {
                    addData(dataJson, resultBean);
                }
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }


    //获取分类add到数据库
    private static void addData(BookShortage.ResultBean bookShortage, BookShortage.ResultBean.BookListBean bookListBean) {
        try {
            preparedStatement.setInt(1, bookShortage.getNum());
            preparedStatement.setString(2, bookShortage.getBlock_name());
            preparedStatement.setInt(3, bookListBean.getBook_id());
            preparedStatement.setInt(4, bookListBean.getBook_id());
            preparedStatement.setString(5, bookListBean.getAuthor_name());
            preparedStatement.setString(6, bookListBean.getBook_cover());
            preparedStatement.setString(7, bookListBean.getBook_tags().toString());
            preparedStatement.setString(8, bookListBean.getBook_path());
            preparedStatement.setString(9, bookListBean.getChapter_new_name());
            preparedStatement.setString(10, bookListBean.getCategory_name());
            preparedStatement.setString(11, bookListBean.getBook_name());
            preparedStatement.setString(12, bookListBean.getBook_brief());
            preparedStatement.executeUpdate();
            System.out.print(JSONUtil.toJSONString(bookListBean) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取分类add到数据库
    private static void addData(DataJson dataJson, DataJson.ResultBean.BookListBean bookListBean) {
        try {
            preparedStatement.setInt(1, dataJson.getResult().getNum());
            preparedStatement.setString(2, dataJson.getResult().getBlock_name());
            preparedStatement.setInt(3, bookListBean.getBook_id());
            preparedStatement.setInt(4, bookListBean.getBook_id());
            preparedStatement.setString(5, bookListBean.getAuthor_name());
            preparedStatement.setString(6, bookListBean.getBook_cover());
            preparedStatement.setString(7, bookListBean.getBook_tags().toString());
            preparedStatement.setString(8, bookListBean.getBook_path());
            preparedStatement.setString(9, bookListBean.getChapter_new_name());
            preparedStatement.setString(10, bookListBean.getCategory_name());
            preparedStatement.setString(11, bookListBean.getBook_name());
            preparedStatement.setString(12, bookListBean.getBook_brief());
            preparedStatement.executeUpdate();
            System.out.print(JSONUtil.toJSONString(bookListBean) + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
