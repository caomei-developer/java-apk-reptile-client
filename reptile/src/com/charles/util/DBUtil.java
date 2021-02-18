package com.charles.util;

public class DBUtil {
    public static String chapterSql = "insert into book_detail (id,chapter_name,chapter_level,words_count,is_free,book_id) values(?,?,?,?,?,?)";

    public static String addSearchBook= "insert into book_ids (book_id,block_id,book_name,primary_book_name,similarity,author_name,book_cover,category_name,book_path,book_tags,chapter_new_name,book_brief) values(?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String addCategoryBook = "insert into book_fantasy_romance (block_id,block_name,column_litm,book_id,author_name,book_cover,book_tags,book_path,chapter_new_name,category_name,book_name,book_brief) values(?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String getBookIdsSql="select book_id from book_fantasy_romance";

    public static String getBookNameAndBookAuthorName="select book_name ,author_name from book_ids";

    public static String addRecommend = "insert into novel_recommend (novelId,novelChapters,novelName,novelSrc,novelImageUrl,novelAuthor,novelTime,novelCategory) values(?,?,?,?,?,?,?,?)";

    public static String copyright = "insert into legal_affairs (search_key,search_name,path,nature,company,time,ip,registrant,record_number,record_number_path,corporate_representative) values(?,?,?,?,?,?,?,?,?,?,?)";


    //获取文件xlsx
    public static String searchXlsxPath = "/Users/zw/Downloads/test_novel.xlsx";
    public static String searchBaiduXlsxPath = "/Users/zw/Downloads/shudan.xlsx";

    //词典数据包地址
    public static String dictionaryAddress = "/Users/zw/Downloads/data-for-1.7.5";



}
