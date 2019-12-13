package cn.xhjava.O_future.future.Demo;

/**
 * @author Xiahu
 * @create 2019/11/7
 * @since 1.0.0
 */

/**
 * 订单类
 */
public class Future {
    private Produce produce;

    private boolean isOk;

    public synchronized void setProduce(Produce produce) {
        if (isOk) {
            return;
        }
        isOk = true;
        this.produce = produce;
        notifyAll();
    }

    public synchronized Produce getProduce() {
        while (!isOk){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return produce;
    }

}