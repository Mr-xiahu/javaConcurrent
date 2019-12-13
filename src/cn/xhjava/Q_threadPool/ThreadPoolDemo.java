package cn.xhjava.Q_threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xiahu
 * @create 2019/11/25
 * @since 1.0.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 30, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i <= 100; i++) {
            int j = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    count.getAndIncrement();
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        pool.shutdown();
        System.out.println(count);
    }
}