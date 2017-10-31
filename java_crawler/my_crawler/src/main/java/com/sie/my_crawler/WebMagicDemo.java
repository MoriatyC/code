package com.sie.my_crawler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicDemo implements PageProcessor {
    //1.抓取网站的相关配置，包括编码、抓取间隔、重试次数、
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
            .setDomain("http://www.weibo.com")
            .addCookie("SWB", "usrmdinst_10")
            
            .addCookie("_s_tentry", "s.weibo.com")
            
            .addCookie("Apache", "7720765747375.72.1494662357939")
            
            .addCookie("SINAGLOBAL", "7720765747375.72.1494662357939")
            
            .addCookie("ULV", "1494662357965:1:1:1:7720765747375.72.1494662357939:")
            
            .addCookie("WBtopGlobal_register_version", "a05309c5d15974a8")
            .addCookie("SCF", "AsBpfh_eOTwHiq9VRNmjKovca9XJY0UCe6cN86B02M3m_7R-ACHzixI2RJGJ-5OWX2AvIx7gE6s0aOezZKzpqmc.")
            
            .addCookie("SUB", "_2A250EsuwDeRhGeVN4lAU8CnNzTiIHXVXabp4rDV8PUNbmtBeLW7CkW-UvVXAsJMiz8Ue9qjaowdfGgREog..")
            
            .addCookie("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WF0ETZEDAX0hrMh8je6i_hT5JpX5K2hUgL.Foe01KzfehMpSoB2dJLoI7LSdNiDqPx4PXet")
            
            .addCookie("SUHB", "0xnywLz3Zp0MRv")
            
            .addCookie("ALF", "1526198111")
            
            .addCookie("SSOLoginState", "1494662112")
            
            .addCookie("SSOLoginState", "1494662112")
            .addCookie("un", "cmhfy8520@qq.com")
            
            .addCookie("wvr", "6")
            
            .addCookie("YF-Ugrow-G0", "ad06784f6deda07eea88e095402e4243")
            
            .addCookie("YF-V5-G0", "3d0866500b190395de868745b0875841")
            .addCookie("YF-Page-G0", "46f5b98560a83dd9bfdd28c040a3673e")
            
            .addCookie("WBStorage", "02e13baf68409715|undefined");
            
             
    @Override
    //process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        //2.定义如何抽取页面信息，并保存下来
//        page.putField("url", page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//        page.putField("name", page.getHtml().xpath("//span").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//        
//        //3.从页面发现后续的url地址来抓取
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
           String content = page.toString();
        Path path = Paths.get("E:", "data.txt");
        try {
            Files.write(path, content.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(page.toString());

    }


    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
//        BasicConfigurator.configure();
        Spider.create(new WebMagicDemo())
            .addUrl("http://s.weibo.com/weibo/%25E6%25AF%2594%25E7%2589%25B9%25E5%25B8%2581%2520%25E7%2597%2585%25E6%25AF%2592&b=1&nodup=1")
            //开启5个线程抓取
            .thread(5)
            //启动
            .run();

    }
}



