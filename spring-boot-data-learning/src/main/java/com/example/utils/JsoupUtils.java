package com.example.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/***
 * @description:JsoupUtils 简单的Java爬虫
 * @author: yk
 **/
public class  JsoupUtils {
    public static void main(String[] args) throws Exception {
        getList("https://blog.csdn.net/xingyu_qie/category_2378953.html");
    }

    /**
     * @description 通过 CSDN 的专题系列网址输出对应的内容
     * @param:url
     */
    public static void getList(String url) throws Exception {
        //url对应的网页文档
        Document document = Jsoup.connect(url).get();
        //获取标题
        String title = document.title();
        //获取头部信息
        Element head = document.head();
        //菜单列表ul
        Elements menu = document.getElementsByClass("column_article_list");
        //取出每个li
        Elements items = menu.get(0).getElementsByTag("li");
        System.out.println(items.size()); //40
        for (Element el : items) {
            //取出h2标签，就是每篇文章的标题
            String articleTitle = el.select("div.column_article_title .title").text();
            System.out.println(articleTitle);
            //取出每个li元素子元素a的href,就是每篇文章的链接
            String articleLink = el.getElementsByTag("a").attr("href");
            System.out.println(articleLink);
        }
    }
}
