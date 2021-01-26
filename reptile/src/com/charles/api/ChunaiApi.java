package com.charles.api;

public class ChunaiApi {
    /**
     * 纯爱小说
     */
    public static String CI_BASE_URL="http://novel.chunaixiaowu.net/";
    //app index
    public static String APP_INDEX ="index.php/cms/app/appIndex";
    // app category  本地数据存放在resources
    public static String APP_CATEGORY = "/index.php/cms/app/getSortType";
    // app category get list
    /**
     * 参数
     * tstype  category 比如：校园 都市 豪门
     * ismanhua
     * xstype  0 / 1   0是连载 1是完结
     * offset  页数
     * limit  每页面size
     */
    public static String APP_CATEGORY_LIST = "index.php/cms/app/getBookList";

    /**
     * 根据书id 获取章节
     * uid
     * id 405
     */
    public static String APP_CHAPTER="index.php/cms/app/getChapter";

    /**
     *根据书id 章节id h获取内容
     * uid
     * cid 27320
     * bid 405
     */
    public static String APP_BOOK_CONTENT = "index.php/cms/app/read";


    public static String APP_SEARCH = "index.php/cms/Api2/search";
}
