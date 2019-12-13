package cn.xhjava.O_future.future.Demo;

/**
 * @author Xiahu
 * @create 2019/11/7
 * @since 1.0.0
 */

/**
 * future 核心实现原理
 */
public class Client {
    public static void main(String[] args) {
        Future future = ProduceFactory.createFuture("蛋糕");
        System.out.println("我去上班了，待会下班了来拿蛋糕");
        // 拿着订单获取产品
        System.out.println("我拿着蛋糕回家." + future.getProduce());
    }

}