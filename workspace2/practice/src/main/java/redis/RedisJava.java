package redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class RedisJava extends Thread{
    static Response<String> ret;
    Jedis conn = new Jedis("localhost");
    @Override
    public void run() {
        
        Transaction t = conn.multi();
        t.incr("notrans:");
        Response<String> result1 = t.get("notrans:");
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t.incrBy("notrans:", -1);
        t.exec();
        String foolbar = result1.get();       
        System.out.println(foolbar);
    }


    public static void main(String[] args) {
        String s = "1.517745413E9";
        System.out.println(Long.valueOf(s));

    }
}
