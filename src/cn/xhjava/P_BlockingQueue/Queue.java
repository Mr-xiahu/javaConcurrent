package cn.xhjava.P_BlockingQueue;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Xiahu
 * @create 2019/11/18
 * @since 1.0.0
 */
public class Queue {
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);


    public void put(Integer num) {
        try {
            queue.put(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take() {
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void size() throws InterruptedException {
        System.out.println("当前队列大小--->" + queue);
        Thread.sleep(2000);
    }
}