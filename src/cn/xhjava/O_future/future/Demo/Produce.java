package cn.xhjava.O_future.future.Demo;

/**
 * @author Xiahu
 * @create 2019/11/7
 * @since 1.0.0
 */

/**
 * 蛋糕类
 */
public class Produce {
    private Integer id;
    private String name;

    public Produce(Integer id, String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
        System.out.println(name + "已经制作完毕");
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}