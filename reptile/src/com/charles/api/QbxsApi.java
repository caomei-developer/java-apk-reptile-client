package com.charles.api;

public class QbxsApi {

    /**
     * 趣步小说
     */
    //0 或者 1 都是页数
    //趣步app列表
    //幻想言情 http://s.mujiang88.cn/api/book/block/1534_1.json
    //热血都市 http://s.mujiang88.cn/api/book/block/1539_1.json
    //古代言情 http://s.mujiang88.cn/api/book/block/1535_1.json
    //东方玄幻 http://s.mujiang88.cn/api/book/block/1538_1.json
    //悬疑灵异 http://s.mujiang88.cn/api/book/block/1536_1.json
    //仙侠武侠 http://s.mujiang88.cn/api/book/block/1540_1.json
    //现代言情 http://s.mujiang88.cn/api/book/block/1541_1.json
    //历史军事 http://s.mujiang88.cn/api/book/block/1542_1.json
    //科幻游戏 http://s.mujiang88.cn/api/book/block/1537_1.json

    //书荒 http://s.mujiang88.cn/api/json/qbmfxs/type_8_0.json // 暂无

    //书荒分类列表 http://s.mujiang88.cn/api/book/block/1575_1.json //暂无 1709

    //拼接 1534_1.json 等后缀
    public static String CATEGORY_URL = "http://s.mujiang88.cn/api/book/block/";

    //根据小说ID 获取章节  目前不清楚 t=26844830有什么用处
    //TEST_URL http://s.mujiang88.cn/api/book/chapter/128/128396/list.json?t=26844830
    //请把带* ###替换掉，128 / 128396
    public static String CHAPTER_URL = "http://s.mujiang88.cn/api/book/chapter/***/###/list.json?";

    //根据章节小说id 和章节id 获取内容  目前不清楚 t26844830有什么用处
    // http://s.mujiang88.cn/api/book/chapter/128/128396/819.json?t26844830
    //请把带 * #  替换成 128 / 128396 类型， chapterId 替换成 对应章节id
    public static String chapter_content_url = "http://s.mujiang88.cn/api/book/chapter/***/###/chapterId.json?t26844830";

    public static String SEARCH_URL = "http://m.mujiang88.cn/search/book/result";



}
