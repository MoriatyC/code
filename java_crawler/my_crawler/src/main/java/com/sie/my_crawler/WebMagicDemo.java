package com.sie.my_crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;;

public class WebMagicDemo implements PageProcessor {
    //1.抓取网站的相关配置，包括编码、抓取间隔、重试次数、
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);
    @Override
    //process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        //2.定义如何抽取页面信息，并保存下来
        Selectable article = page.getHtml().xpath("article");
//        String footer = page.getHtml().xpath("article").xpath("//div[class='footer']").toString();
//        article = article.replaceAll("data-src", "src");
        String content = article.toString();
        Pattern p = Pattern.compile("<div class=\"footer\">(.*)</div>", Pattern.DOTALL);
        Matcher m = p.matcher(content);
        String footer = "";
        if (m.find()) {
            footer = m.group(0);
        }
        System.out.println(content.replace(footer, "").replace("data-src", "src"));
//        page.putField("article", article);
        //        page.putField("article", article);
        
//        page.putField("name", page.getHtml().xpath("//span").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//        
//        //3.从页面发现后续的url地址来抓取
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//        Path path = Paths.get("E:", "data.txt");
//        try {
//            Files.write(path, content.getBytes(Charset.forName("UTF-8")));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        System.out.println("-----------------------------------------------------");
        String s = "";
        
    }


    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
//        BasicConfigurator.configure();
        Spider.create(new WebMagicDemo())
            .addUrl("http://3g.163.com/game/article/D2KOMPHC00318P2J.html")
            //开启5个线程抓取
            .thread(5)
            //启动
            .run();

    }
}



