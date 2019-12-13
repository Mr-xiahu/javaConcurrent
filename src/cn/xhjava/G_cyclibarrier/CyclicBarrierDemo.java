package cn.xhjava.G_cyclibarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;


/**
 * 等待线程都到了,才执行下面的逻辑
 */
public class CyclicBarrierDemo {

	Random random = new Random();

	public void meeting(CyclicBarrier barrier) {
		try {
			Thread.sleep(random.nextInt(4000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 到达会议室，等待开会..");

		if(Thread.currentThread().getName().equals("Thread-7")) {
			// Thread.currentThread().interrupt();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			barrier.reset();//重置为其初始状态的屏障

		}
		
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CyclicBarrierDemo demo = new CyclicBarrierDemo();

		CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("好！我们开始开会...");
			}
		});

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					demo.meeting(barrier);
				}
			}).start();
		}
		
		// 监控等待线程数
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("等待的线程数 " + barrier.getNumberWaiting());
					System.out.println("is broken " + barrier.isBroken());
				}
			}
		}).start();
	}

}
