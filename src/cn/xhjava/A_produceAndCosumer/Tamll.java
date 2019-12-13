package cn.xhjava.A_produceAndCosumer;

/**
 * @author Xiahu
 * @create 2019/10/23
 * @since 1.0.0
 */

//天猫电商平台
public class Tamll {
    private int count;

    private final int MAX_COUNT = 10;

    public synchronized void push() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存达到上限,生产者停止生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者: 当前库存:" + count);
        notifyAll();
    }

    public synchronized void pull() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "当前库存为零,消费者在等待");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费者: 当前库存:" + count);
        notifyAll();
    }
}