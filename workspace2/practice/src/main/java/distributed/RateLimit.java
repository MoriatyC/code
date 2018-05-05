package distributed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author : Menghui Chen
 * @version ：2018年5月5日 下午4:03:35
 * @Description:
 */


public class RateLimit {
    private int permitsPerSecond = 4;
    private int threadNum = 3;
    private void call() {
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        final RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new Mytask(rateLimiter, (char)('A' + i)));
        }
        executor.shutdown();
    }
    public static void main(String[] args) {
        new RateLimit().call();
    }
    
}


class Mytask implements Runnable {
    private RateLimiter rateLimiter;
    private boolean running = true;
    private char c;
    public Mytask(RateLimiter rateLimiter, char c) {
        this.rateLimiter = rateLimiter;
        this.c = c;
    }
    @Override
    public void run() {
        while (running) {
            rateLimiter.acquire(4);
            getData();
        }
    }
    private void getData()  {
        System.out.println(Thread.currentThread().getName()+ "   " + c + "is running");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




