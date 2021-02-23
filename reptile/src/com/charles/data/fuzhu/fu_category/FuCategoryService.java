package com.charles.data.fuzhu.fu_category;

import com.charles.api.FuzhuApi;
import com.charles.data.fuzhu.fu_category.bean.Recommend;
import com.charles.data.fuzhu.fu_category.bean.RecommendList;
import com.charles.data.fuzhu.fu_category.bean.Search;
import com.charles.http.HttpUtil;
import com.charles.util.*;
import com.charles.util.string.CosineSimilarity;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class FuCategoryService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {
        String sql = DBUtil.addRecommend;

//        if (connection != null) {
//            preparedStatement.close();
//            connection.close();
//        }
//        connection = SQLDBUtil.getConnection();
//        preparedStatement = connection.prepareStatement(sql);
//        List<String> keyword = XlxsUtils.read(DBUtil.searchXlsxPath);
//        System.out.println(keyword.size());
//        for (String string : keyword) {
//            getSearch(string);
//        }
        pubchapter();


//        System.out.println(DesUtil.decryptDES("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","20200618"));

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

    public static void getRecommend() throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        String param = checkSign(HTTP_SIGN.JING_XUAN, timestamp, 0, point, 0, 0);
        recommend(timestamp, param, FuzhuApi.FU_JING_XUAN, FuzhuApi.UID, "0", "", "", "", "0");
    }

    public static void bookindex() throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        String param = checkSign(HTTP_SIGN.BOOK_INDEX, timestamp, 0, point, 0, 0);
        bookIndex(timestamp,param);
    }

    public static void bookCata() throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        String param = checkSign(HTTP_SIGN.BOOK_CATA, timestamp, 0, point, 0, 0);
        bookCata(timestamp,param);
    }

    public static void pubchapter() throws Exception {
        long timestamp = Long.valueOf(System.currentTimeMillis());
        String param = checkSign(HTTP_SIGN.FZ_BOOK_FREECHAPTER, timestamp, 0, point, 0, 0);
        bookPubchapter(timestamp,param);
    }

    public static void getCategory(long l, String param, String prefer, String uID) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_CATEGORY_URL, RequestUtil.buildMap("timestamp", String.valueOf(l)
                , "sign", param, "prefer", prefer, "uID", uID), new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) throws Exception {
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
            public void onSuccess(String body) throws Exception {
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
            public void onSuccess(String body) {
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

    public static void recommend(long timestamp, String param, String fuJingXuan, String UID, String s, String s1, String s2, String s3, String s4) throws Exception {
        RequestUtil.buildMap("timestamp", timestamp, "sign", param, "page", fuJingXuan, "uID", UID, "token", s, "country", s1, "province", s2, "city", s3, "isWifi", s4);

        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_HOME_URL, RequestUtil.buildMap("timestamp", "" + timestamp,
                "sign", param,
                "page", fuJingXuan,
                "uID", UID,
                "token", s,
                "country", s1,
                "province", s2,
                "city", s3,
                "isWifi", s4),
                new HttpUtil.HttpCallback() {
                    @Override
                    public void onSuccess(String body) throws Exception {
                        System.out.println(body);
                        RecommendList recommendList = JSONUtil.parseObject(body, RecommendList.class);
                        for (RecommendList.DataBean.LmlistBean lmlistBean : recommendList.DATA.LMLIST) {
                            for (RecommendList.DataBean.LmlistBean.BooksBean booksBean : lmlistBean.BOOKS) {
                                Recommend recommend = new Recommend();
                                recommend.setNovelId(booksBean.getKEYID());
                                recommend.setNovelName(booksBean.getKEYNAME());
                                recommend.setNovelImageUrl(booksBean.getCOVERURL());
                                recommend.setNovelAuthor(booksBean.getAUTHORNAME());
                                recommend.setNovelCategory(booksBean.getKEYTYPE());
                                recommend.setNovelSrc(booksBean.getCONTENT());
                                recommend.setNovelTime(System.currentTimeMillis());
//                                addData(recommend);
//                            System.out.println(JSONUtil.toJSONString(recommend));

                            }
                        }
                    }

                    @Override
                    public void onFail(String msg) {

                    }
                });

    }

    public static void bookIndex(long timestamp, String param) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_BOOK_INDEX, RequestUtil.buildMap(
                "timestamp", String.valueOf(timestamp),
                "sign", param,
                "bID", "268987",
                "lmID","6002420",
                "token","0",
                "uID", FuzhuApi.UID), new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) {
                System.out.println(body);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public static void bookCata(long timestamp, String param) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_BOOK_CATA, RequestUtil.buildMap(
                "timestamp", String.valueOf(timestamp),
                "sign", param,
                "bID", "268987",
                "isUpdate","0",
                "token","0",
                "uID", FuzhuApi.UID), new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) {
                System.out.println(body);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public static void bookPubchapter(long timestamp, String param) throws Exception {
        HttpUtil.getHttp(FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_BOOK_FREECHAPTER, RequestUtil.buildMap(
                "timestamp", String.valueOf(timestamp),
                "sign", param,
                "bID", "268987",
                "cID","5661874",
                "token","0",
                "uID", FuzhuApi.UID), new HttpUtil.HttpCallback() {
            @Override
            public void onSuccess(String body) {
                System.out.println(body);
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

            case JING_XUAN:
                return SignatureUtil.elitebook(
                        FuzhuApi.APP_ANDROID,
                        timestamp,
                        FuzhuApi.FU_JING_XUAN,
                        FuzhuApi.UID,
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL + FuzhuApi.FZ_HOME_URL);
            case BOOK_INDEX:
                return SignatureUtil.bookindex(
                        FuzhuApi.APP_ANDROID,
                        timestamp,
                        "268987",
                        "6002420",
                        FuzhuApi.UID,
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL+ FuzhuApi.FZ_BOOK_INDEX
                );
            case BOOK_CATA:
                return SignatureUtil.bookcata(
                        FuzhuApi.APP_ANDROID,
                        timestamp,
                        "268987",
                        "0",
                        FuzhuApi.UID,
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL+ FuzhuApi.FZ_BOOK_CATA
                );
            case FZ_BOOK_FREECHAPTER:
                return SignatureUtil.pubchapter(
                        FuzhuApi.APP_ANDROID,
                        ""+timestamp,
                        "268987",
                        "5661874",
                        FuzhuApi.UID,
                        FuzhuApi.APP_URL_GET_HTTP_MODE,
                        FuzhuApi.FZ_BASE_URL+ FuzhuApi.FZ_BOOK_FREECHAPTER
                );

        }

        return null;
    }

    public enum HTTP_SIGN {
        BOOK_SORTS, CATEGORY_BOOK_LIST, SEARCH, JING_XUAN, BOOK_INDEX,BOOK_CATA,FZ_BOOK_FREECHAPTER
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


    private static void addData(Recommend recommend) {
        try {
            preparedStatement.setInt(1, recommend.getNovelId());
            preparedStatement.setInt(2, recommend.getNovelChapters());
            preparedStatement.setString(3, recommend.getNovelName());
            preparedStatement.setString(4, recommend.getNovelSrc());
            preparedStatement.setString(5, recommend.getNovelImageUrl());
            preparedStatement.setString(6, recommend.getNovelAuthor() == null ? "" : recommend.getNovelAuthor());
            preparedStatement.setLong(7, recommend.getNovelTime());
            preparedStatement.setString(8, recommend.getNovelCategory() == null ? "" : recommend.getNovelAuthor());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int state = 0; //此参数 10 连载 20 完结 0 所有

    private static int rank = 0; //次参数 10 星级 20 最新 30 数字  0 人气

    private static int bt = 0; // 24=幻想耽美 25=现代耽美 26=古风耽美 4=青春校园 17=玄幻 15=同人 22=短片 18=奇幻 6=仙侠 9=灵异 20= 百合 14=游戏

    private static int point = 20; // point 就是 pn  每页多少条数据




}
