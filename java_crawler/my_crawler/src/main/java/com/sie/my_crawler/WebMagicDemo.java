package com.sie.my_crawler;

import javax.management.JMException;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicDemo implements PageProcessor {
    //1.抓取网站的相关配置，包括编码、抓取间隔、重试次数、
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);
    
    @Override
    //process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        //2.定义如何抽取页面信息，并保存下来
        page.putField("url", page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("name", page.getHtml().xpath("//span").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
        
        //3.从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    }


    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
//        BasicConfigurator.configure();
        Spider spider = Spider.create(new WebMagicDemo())
        //从“https://github.com/code4craft”开始爬
                
            .addUrl("https://github.com/code4craft")
            //开启5个线程抓取
            .thread(5);
            //启动
//            .run();
        try {
            //添加单例，注册监控（可以注册多个到SpiderMonitor）
            SpiderMonitor.instance().register(spider);
        } catch (JMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        spider.start();
    }
}