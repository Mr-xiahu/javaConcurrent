package cn.xhjava.A_produceAndCosumer;

/**
 * @author Xiahu
 * @create 2019/10/23
 * @since 1.0.0
 */

//生产商品
public class Produce implements Runnable {

    private Tamll tamll;

    public Produce(Tamll tamll){
        this.tamll = tamll;
    }

    @Override
    public void run() {
        while (true){
            tamll.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}