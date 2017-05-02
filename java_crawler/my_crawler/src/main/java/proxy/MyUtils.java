package proxy;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MyUtils {

    public static boolean connectTest(String ip, int port, String scheme) {
        CloseableHttpClient client = HttpClients.createDefault();
        boolean judge = false;
        try{
            HttpHost proxy = new HttpHost(ip, port, scheme);
            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            HttpGet request = new HttpGet("https://www.baidu.com/");
            request.setConfig(config);
            CloseableHttpResponse response = null;
            try {             
                response = client.execute( request);
                System.out.println("___________________________________________");
                System.out.println(response.getStatusLine());
//                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println("___________________________________________");
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (response != null) {
                    try {
                        judge = true;
                        response.close();
                    } catch (IOException e) {
                        System.out.println("reponse close failed");
                        e.printStackTrace();
                    }                    
                }
            }
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    System.out.println("client close failed");
                    e.printStackTrace();
                }
            }
        }
        return judge;
        
    }

    public static void main(String[] args) {
        connectTest("111.13.7.119", 80, "HTTP");
    }

}
