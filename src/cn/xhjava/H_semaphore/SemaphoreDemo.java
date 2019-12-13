package cn.xhjava.H_semaphore;

import java.util.concurrent.Semaphore;


/**
 * 信号量
 * 		控制线程访问个数
 */
public class SemaphoreDemo {
	
	public void method (Semaphore semaphore) {
		
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " is run ...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		semaphore.release();
	}
	
	
	public static void main(String[] args) {
		
		SemaphoreDemo d = new SemaphoreDemo();
		Semaphore semaphore = new Semaphore(10);
		
		while(true) {
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					d.method(semaphore);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		
	}

}
