package cn.xhjava.A_produceAndCosumer;

/**
 * @author Xiahu
 * @create 2019/10/23
 * @since 1.0.0
 */

//生产者和消费者
public class Client {
    public static void main(String[] args) {
        Tamll tamll = new Tamll();

        Produce produce = new Produce(tamll);
        Consumer consumer = new Consumer(tamll);

        new Thread(produce).start();
        new Thread(produce).start();
        new Thread(produce).start();
        new Thread(produce).start();
        new Thread(produce).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}