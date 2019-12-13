package cn.xhjava.A_produceAndCosumer;

/**
 * @author Xiahu
 * @create 2019/10/23
 * @since 1.0.0
 */
public class Consumer implements Runnable {

    private Tamll tamll;

    public Consumer(Tamll tamll) {
        this.tamll = tamll;
    }

    @Override
    public void run() {
        while (true) {
            tamll.pull();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}