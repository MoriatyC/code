package distributed;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author : Menghui Chen
 * @version ：2018年5月5日 下午4:03:35
 * @Description:
 */
public class RateLimit {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1.0);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire(1);
            System.out.println(i);
            System.out.println("call execute.." + i);  
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
