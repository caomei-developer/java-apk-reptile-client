package com.charles.data.baidu;

import com.charles.data.baidu.data.BaiduBean;
import com.charles.data.baidu.data.BaiduJson;
import com.charles.http.JsoupUtil;
import com.charles.util.DBUtil;
import com.charles.util.JSONUtil;
import com.charles.util.SQLDBUtil;
import com.charles.util.xlxs.XlxsUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaiduService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;

    static int pn[] = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};

    static String string[] ={"我家老公是傻蛋","绿帽","墙角处的阳光","仙食录","姬天子","将门庶女：太子妃驾到","曲陌路绵绵","昼夜","最后的微元族人","双面娇妻","邝少恋爱有点甜","爱如蜜糖恨似刀"};

    private static String base_url = "https://www.baidu.com/s?ie=utf-8&wd=***&pn=###";

    private static String ip_url = "http://seo.chinaz.com/";

    public static void main(String[] args) throws Exception {
        String sql = DBUtil.copyright;

        if (connection == null) {
            connection = SQLDBUtil.getConnection();
        }
        preparedStatement = connection.prepareStatement(sql);
//        List<String> keyword = XlxsUtils.read(DBUtil.searchBaiduXlsxPath);
//        System.out.println(keyword);
//        for (String string : string) {
            for (int i = 1; i < pn.length; i++) {
                String url = base_url.replace("***", "情动入心" + "小说").replace("###", "" + pn[i]);
                JsoupUtil.getJsoup(url, new JsoupUtil.HttpCallback() {
                    @Override
                    public void onSuccess(Document body) throws Exception {
                        html(body, "情动入心");
                        return;
                    }

                    @Override
                    public void onFail(String msg) {
                        System.out.println(msg);
                    }
                });
//            }
        }


    }

    private static void html(Document document, String searchKey) throws Exception {
        Element element = document.getElementById("content_left");
        if (element != null) {
            Elements elements = element.getElementsByClass("new-pmd");
            if (elements != null) {
                for (Element element1 : elements) {
                    Elements elements1 = element1.getElementsByClass("user-avatar");
                    for (Element element11 : elements1) {
                        BaiduBean baiduBean = new BaiduBean();
                        String path = element11.getElementsByClass("c-color-gray").get(0).getElementsByTag("a").text();
                        baiduBean.setPath(path.split("/")[0]);
                        Elements element2 = element11.getElementsByClass("c-tools");
                        for (Element element3 : element2) {
                            BaiduJson baiduJson = JSONUtil.parseObject(element3.attr("data-tools"), BaiduJson.class);
                            baiduBean.setName(baiduJson.getTitle());
                            baiduBean.setSearch_name(searchKey);
                        }
                        checkIp(baiduBean);
                    }
                }
            }
        }
    }

    private static List<BaiduBean> baiduBeans = new ArrayList<>();

    private static void checkIp(BaiduBean baiduBean) throws Exception {
        if (baiduBean != null) {
            if (baiduBean.getName().contains("章节") || baiduBean.getName().contains("小说")
                    || baiduBean.getName().contains("免费阅读") || baiduBean.getName().contains("TXT")
                    || baiduBean.getName().contains("TXT全集")) {

                Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
                if (pattern.matcher(baiduBean.getPath()).find()) {
                    return;
                }
                JsoupUtil.getJsoup(ip_url + baiduBean.getPath(), new JsoupUtil.HttpCallback() {
                    @Override
                    public void onSuccess(Document body) throws Exception {
                        Elements elements = body.getElementsByAttributeValue("class", "_chinaz-seo-newtc _chinaz-seo-newh78");
                        if (elements == null && elements.size() <= 0) {
                            return;

                        }
                        elements.remove(0);
                        Elements divs = elements.select("div");
                        for (int i = 0; i < divs.size(); i++) {
                            Elements elements1 = divs.get(i).getElementsByClass("mr50");
                            if (i == 1) {
                                Elements element = divs.get(1).getElementsByTag("span");
                                Elements a = element.get(0).getElementsByTag("a");
                                String domainTime = a.get(0).getElementsByClass("color-63").text();
                                baiduBean.setDomainTime(domainTime);
                            }
                            for (Element element1 : elements1) {
                                Elements elements2 = element1.getElementsByClass("color-63");
                                baiduBean.setRegistrant(elements2.get(0).getElementsByTag("i").text());
                            }
                        }

                        Elements elements1 = body.getElementsByAttributeValue("class", "_chinaz-seo-newh78 _chinaz-seo-newinfo");

                        if (elements1.get(0).getElementsByClass("mr50") != null && elements1.get(0).getElementsByClass("mr50").size() > 0) {
                            if (elements1.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a") != null && elements1.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a").size() > 0) {
                                String ip = elements1.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a").first().text();
                                baiduBean.setIp(ip);
                            }
                        }

                        Elements elements2 = body.getElementsByAttributeValue("class", "_chinaz-seo-newtc _chinaz-seo-newh40");
                        if (elements2.get(0).getElementsByClass("mr50").size() > 1) {
                            if (elements2.get(0).getElementsByClass("mr50") != null && elements2.get(0).getElementsByClass("mr50").size() > 0) {
                                if (elements2.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a") != null && elements2.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a").size() > 0) {
                                    String recordNumber = elements2.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a").first().text() == null ? "" : elements2.get(0).getElementsByClass("mr50").get(0).getElementsByTag("a").first().text();
                                    baiduBean.setRecordNumber(recordNumber);
                                }

                            }

                            if (elements2.get(0).getElementsByClass("mr50") != null && elements2.get(0).getElementsByClass("mr50").size() > 0) {
                                String company = null;
                                if (elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a") != null && elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").size() > 0) {
                                    company = elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").first().text();
//                                    System.out.println("11111"+company);
                                } else {
                                    company = elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("i").first().text();
//                                    System.out.println("22222"+company);
                                }
//                                System.out.println("3333"+company);
                                baiduBean.setCompany(company);
                            }

                            if (elements2.get(0).getElementsByClass("mr50") != null && elements2.get(0).getElementsByClass("mr50").size() > 0) {
                                if (elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a") != null && elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").size() > 0) {
                                    String recordNumberPath = elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").attr("href") == null ? "" : elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").attr("href");

                                    baiduBean.setRecordNumberPath("https:" + recordNumberPath);
                                }
                            }
//                            String recordNumberPath = elements2.get(0).getElementsByClass("mr50").get(1).getElementsByTag("a").attr("href");

                            if (elements2.get(0).getElementsByClass("mr50") != null && elements2.get(0).getElementsByClass("mr50").size() > 0) {
                                if (elements2.get(0).getElementsByClass("mr50").get(2).getElementsByTag("i") != null && elements2.get(0).getElementsByClass("mr50").get(2).getElementsByTag("i").size() > 0) {
                                    String nature = elements2.get(0).getElementsByClass("mr50").get(2).getElementsByTag("i").first().text() == null ? "" : elements2.get(0).getElementsByClass("mr50").get(2).getElementsByTag("i").first().text();
                                    ;

                                    baiduBean.setNature(nature);
                                }

                            }


                        }
                        getCorporateRepresentative(baiduBean);
                    }

                    @Override
                    public void onFail(String msg) {
                        System.out.println(msg);
                    }
                });
            }
        }
    }

    private static void getCorporateRepresentative(BaiduBean baiduBean) throws Exception {
        if (baiduBean.getRecordNumberPath() == null) {
            addData(baiduBean);
            System.out.println("end");
            return;
        }
        String path = null;
        if (baiduBean.getRecordNumberPath().contains(baiduBean.getCompany())) {
            path = baiduBean.getRecordNumberPath().replace(baiduBean.getCompany(), URLEncoder.encode(baiduBean.getCompany(), "UTF-8"));
        }
        if (path == null) {
            return;
        }
        JsoupUtil.getJsoup(baiduBean.getRecordNumberPath(), new JsoupUtil.HttpCallback() {
            @Override
            public void onSuccess(Document body) throws Exception {
                if (body.getElementsByClass("Module-table-list clearfix") != null && body.getElementsByClass("Module-table-list clearfix").size() > 0) {
                    String corporateRepresentative = body.getElementsByClass("Module-table-list clearfix").get(0).getElementsByClass("col-2").get(1).getElementsByTag("li").first().text();
                    baiduBean.setCorporateRepresentative(corporateRepresentative);
//                    System.out.println("end path");
                }
                addData(baiduBean);
            }

            @Override
            public void onFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    private static void addData(BaiduBean baiduBean) {
        try {
            preparedStatement.setString(1, baiduBean.getSearch_name());
            preparedStatement.setString(2, baiduBean.getName());
            preparedStatement.setString(3, baiduBean.getPath());
            preparedStatement.setString(4, baiduBean.getNature());
            preparedStatement.setString(5, baiduBean.getCompany());
            preparedStatement.setString(6, baiduBean.getDomainTime());
            preparedStatement.setString(7, baiduBean.getIp());
            preparedStatement.setString(8, baiduBean.getRegistrant());
            preparedStatement.setString(9, baiduBean.getRecordNumber());
            preparedStatement.setString(10, baiduBean.getRecordNumberPath());
            preparedStatement.setString(11, baiduBean.getCorporateRepresentative());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
