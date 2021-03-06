package com.sie.my_crawler;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Service {
    String content;
    public Service() {
        content = "";
    }
    public  void getPage() {
        HttpHost proxy = new HttpHost("127.0.0.1", 1080);
        CloseableHttpClient client = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        String url = "https://bandwagonhost.com/vps-hosting.php";
        HttpGet request = new HttpGet(url);
        request.setConfig(config);
        CloseableHttpResponse response = null;
        
        //执行请求操作
        try {
            response = client.execute(request);
            
            //获得response的实体内容
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                content = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("================================================================================");
            e.printStackTrace();
        }
    }
    public boolean isEmpty() {
        content = "html";
        Document doc;
        try {
            doc = Jsoup.parse(content);
            Elements div = doc.select("div.bronze");
//          Elements div = doc.select("div.bronze ").eq(1).select("div ul:gt(1)");
          //字符小于69说明至少有一个ul没有了，有货         
          boolean isEmpty = div.toString().length() == 69;
          System.out.println(isEmpty);
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            
        }
        
        return true;
    }
    public static void main(String[] args) throws Exception {
        Service s = new Service();
//        s.getPage();
        s.isEmpty();
    }
}
