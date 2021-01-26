package com.charles.data.fuzhu.fu_category;

import com.charles.api.FuzhuApi;
import com.charles.data.fuzhu.fu_category.bean.Search;
import com.charles.data.qbxs.JSon;
import com.charles.http.HttpUtil;
import com.charles.util.*;
import com.charles.util.string.CosineSimilarity;
import com.charles.util.xlxs.XlxsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


public class FuCategoryService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {
        String sql = DBUtil .addSearchBook;

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

    private static void getBookSorts() throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        //加密sign
        String param = checkSign(HTTP_SIGN.BOOK_SORTS, timestamp, bt, 0, state, rank);

        getCategory(timestamp, param, FuzhuApi.FZ_ENCRYPTION_QUANTITATIVE_PREFER, FuzhuApi.UID);
    }

    /**
     * bt category 类别  比如 古风耽美 玄幻 同人
     * pn  没页数据是20 第一次 40 第三次60 以此类推
     * state 链接 或者 完结
     * rank 星级  最新  数量   人气
     *
     * @throws Exception
     */
    public static void getBookCategory(int pn) throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        //加密sign
        String param = checkSign(HTTP_SIGN.CATEGORY_BOOK_LIST, timestamp, bt, pn, state, rank);

        getBookCategoryList(timestamp, param, FuzhuApi.FZ_ENCRYPTION_QUANTITATIVE_PREFER, FuzhuApi.UID, 0, pn, state, rank);
    }

    public static void getSearch(String keyword) throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        String param = checkSign(HTTP_SIGN.SEARCH, timestamp, 0, point, 0, 0);
        getSearchList(timestamp, param, keyword, point);
    }

    public static void getCategory(long l, String param, String prefer, String uID) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_CATEGORY_URL, RequestUtil.buildMap("timestamp", String.valueOf(l)
                , "sign", param, "prefer", prefer, "uID", uID), new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) throws Exception {
                System.out.println(body);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public static void getBookCategoryList(long l, String param, String prefer, String uID, int bt, int pn, int state, int rank) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_CATEGORY_BOOK_LIST, RequestUtil.buildMap("timestamp", String.valueOf(l)
                , "sign", param, "prefer", prefer, "uID", uID, "vip", "0", "state", String.valueOf(state), "rank", String.valueOf(rank), "pn", String.valueOf(pn), "bt", String.valueOf(bt)), new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) throws Exception {
                System.out.println(body);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public static void getSearchList(long timestamp, String param, String keyword, int point) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_SEARCH_URL, RequestUtil.buildMap(
                "timestamp", String.valueOf(timestamp),
                "sign", param,
                "uID", FuzhuApi.UID,
                "kw", keyword,
                "pn", String.valueOf(point)), new HttpUtil.HttpCallback() {
            @Override
            public void OnSuccess(String body) {
                Search search = JSONUtil.parseObject(body, Search.class);
                if (search.getDATA().KEYLIST != null) {
                    System.out.println(search.getDATA().KEYLIST.size());
                    for (Search.DATABean.KEYLISTBean resultBean : search.getDATA().KEYLIST) {
                        double strSimilarity = CosineSimilarity.getSimilarity(keyword, resultBean.getKEYNAME());
                        if (strSimilarity >= 0.7f && strSimilarity < 1.0) {
                            System.out.println(strSimilarity * 100);
//                            addData(resultBean, keyword, strSimilarity * 100);
                        }
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public static String checkSign(HTTP_SIGN http_sign, long timestamp, int bt, int pn, int state, int rank) {
        switch (http_sign) {
            case BOOK_SORTS:
                return SignatureUtil.booksorts(
                        FuzhuApi.APP_ANDROID,
                        String.valueOf(timestamp),
                        FuzhuApi.FZ_ENCRYPTION_QUANTITATIVE_PREFER,
                        FuzhuApi.UID,
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_CATEGORY_URL);
            case CATEGORY_BOOK_LIST:
                return SignatureUtil.listcommbook(
                        FuzhuApi.APP_ANDROID,
                        String.valueOf(timestamp),
                        FuzhuApi.FZ_ENCRYPTION_QUANTITATIVE_PREFER,
                        FuzhuApi.UID,
                        String.valueOf(bt),
                        FuzhuApi.VIP,
                        String.valueOf(state),
                        String.valueOf(rank),
                        String.valueOf(pn),
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_CATEGORY_BOOK_LIST);
            case SEARCH:
                return SignatureUtil.keyBooks(
                        FuzhuApi.APP_ANDROID,
                        String.valueOf(timestamp),
                        FuzhuApi.UID,
                        String.valueOf(pn),
                        FuzhuApi.APP_URL_POST_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_SEARCH_URL);

        }

        return null;
    }

    public enum HTTP_SIGN {
        BOOK_SORTS, CATEGORY_BOOK_LIST, SEARCH
    }

    //1001搜索
    //获取分类add到数据库
    private static void addData(Search.DATABean.KEYLISTBean resultBean, String primary_book_name, double similarity) {
        try {
            preparedStatement.setInt(1, resultBean.getKEYID());
            preparedStatement.setInt(2, 1002);
            preparedStatement.setString(3, resultBean.getKEYNAME());
            preparedStatement.setString(4, primary_book_name);
            preparedStatement.setDouble(5, similarity);
            preparedStatement.setString(6, resultBean.getAUTHORNAME());
            preparedStatement.setString(7, resultBean.getCOVERURL());
            preparedStatement.setString(8, resultBean.getKEYTYPE());
            preparedStatement.setString(9, "暂无");
            preparedStatement.setString(10, "暂无");
            preparedStatement.setString(11, "无返回");
            preparedStatement.setString(12, resultBean.getCONTENT());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int state = 0; //此参数 10 连载 20 完结 0 所有

    private static int rank = 0; //次参数 10 星级 20 最新 30 数字  0 人气

    private static int bt = 0; // 24=幻想耽美 25=现代耽美 26=古风耽美 4=青春校园 17=玄幻 15=同人 22=短片 18=奇幻 6=仙侠 9=灵异 20= 百合 14=游戏

    private static int point = 20; // point 就是 pn  每夜多少条数据


}
