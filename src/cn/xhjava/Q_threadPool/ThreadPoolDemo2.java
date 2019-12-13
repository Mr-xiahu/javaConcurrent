package cn.xhjava.Q_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Xiahu
 * @create 2019/12/1
 * @since 1.0.0
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        ExecutorService pool2 = Executors.newCachedThreadPool();
        ExecutorService pool3 = Executors.newScheduledThreadPool(1);
        ExecutorService pool4 = Executors.newSingleThreadExecutor();
    }

}