package proxy;

import java.util.List;

import org.apache.http.HttpHost;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class Crawler implements PageProcessor{

    Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setCharset("UTF-8");
    static int index = 0;
    public Crawler() {
        
    }
    public Crawler(String ip, int port, String scheme) {
        site.setHttpProxy(new HttpHost(ip, port, scheme));
    }
    @Override
    public void process(Page page) {
        List<String> locations = page.getHtml().xpath("//td[@data-title='位置']/text()").all();
        List<String> ports = page.getHtml().xpath("//td[@data-title='PORT']/text()").all();
        List<String> ips = page.getHtml().xpath("//td[@data-title='IP']/text()").all();
        List<String> schemes = page.getHtml().xpath("//td[@data-title='类型']/text()").all();
        for (int i = 0; i < locations.size(); i++) {
            page.putField("Location" + index, locations.get(i));
            page.putField("Port" + index, ports.get(i));
            page.putField("IP" + index, ips.get(i));
            page.putField("cheme" + index, schemes.get(i));
            index++;
        }
//        page.putField("url", page.getHtml().links().regex("http://gs\\.dlut\\.edu\\.cn/index/zytz/\\d+.htm").all().toString());
//        page.addTargetRequests(page.getHtml().links().regex("http://gs\\.dlut\\.edu\\.cn/index/zytz/\\d+.htm").all());
        page.putField("url", page.getHtml().links().regex("http://www\\.kuaidaili\\.com/free/inha/\\d+/").all().toString());
        page.addTargetRequests(page.getHtml().links().regex("http://www\\.kuaidaili\\.com/free/inha/\\d+/").all());
//                     "http://www\\.kuaidaili\\.com/free/inha/\\d+/"  http://gs.dlut.edu.cn/index/zytz.htm
    }
    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        if (MyUtils.connectTest("111.13.7.119", 80, "HTTP")) {
            Spider spider = Spider.create(new Crawler("111.13.7.119", 80, "HTTP"))
                    .addPipeline(new ConsolePipeline())
                    .addPipeline(new JsonFilePipeline("D:\\proxypool\\"))
                    .addUrl("http://www.kuaidaili.com/free/inha/1/").thread(5);
            spider.run();
        } else {
            System.out.println("代理失效");
        }
        
    }
}
