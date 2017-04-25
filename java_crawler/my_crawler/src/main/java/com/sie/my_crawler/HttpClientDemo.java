package com.sie.my_crawler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

	public static void main(String[] args) {
		//1.使用默认配置的httpclient
		CloseableHttpClient  client = HttpClients.createDefault();
	    String url = "http://202.118.67.200:9006/";
	    //2.使用get方法进行请求
	    HttpGet httpGet = new HttpGet(url);
	    InputStream inputStream = null;
	    CloseableHttpResponse response = null;
	    try {
	    	//执行请求获得response
//	    	String text = MyCrawler.getPage(url);
//	    	System.out.println(text);
			response = client.execute(httpGet);
			//打印请求状态码
			System.out.println(response.getStatusLine().getStatusCode());
			//4.获取response的实体内容,即网页内容
			HttpEntity entity = response.getEntity();
//			//5.打印到控制台
			if(entity != null)
			{
				System.out.println(EntityUtils.toString(entity,"UTF-8"));
			}
//			EntityUtils.consume(entity);
		       //方法二  
//            InputStream inputStream = entity.getContent();
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line = "";
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//
//            }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(response != null)
			{
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	   
	}

}
