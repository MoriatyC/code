package proxy;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class Crawler implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000).setCharset("UTF-8");
    static int index = 0;
    @Override
    public void process(Page page) {
        List<String> locations = page.getHtml().xpath("//td[@data-title='位置']/text()").all();
        List<String> ports = page.getHtml().xpath("//td[@data-title='PORT']/text()").all();
        List<String> ips = page.getHtml().xpath("//td[@data-title='IP']/text()").all();
        for (int i = 0; i < locations.size(); i++) {
            page.putField("Location" + index, locations.get(i));
            page.putField("Port" + index, ports.get(i));
            page.putField("IP" + index, ips.get(i));
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
        Spider spider = Spider.create(new Crawler())
                .addPipeline(new ConsolePipeline())
                .addPipeline(new JsonFilePipeline("D:\\proxypool\\"))
                .addUrl("http://www.kuaidaili.com/free/inha/").thread(5);
        spider.run();
    }
}
