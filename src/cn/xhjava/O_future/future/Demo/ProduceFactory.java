package cn.xhjava.O_future.future.Demo;

import java.util.Random;

/**
 * @author Xiahu
 * @create 2019/11/7
 * @since 1.0.0
 */
public class ProduceFactory {

    //生产订单
    public static Future createFuture(String name) {
        Future future = new Future();
        System.out.println("订单已经下单,你可以去上班了");

        //多线程实现制作蛋糕
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始制作蛋糕");
                Produce produce = new Produce(new Random().nextInt(), name);
                future.setProduce(produce);
            }
        }).start();

        return future;
    }
}