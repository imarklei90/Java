package edu.sse.ustc.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/** Semaphore
 * @author imarklei90
 * @since 2019.08.03
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3); // 3个车位

		for (int i = 1; i <= 6; i++) { // 6个车
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "抢到车位");
					try {
						TimeUnit.SECONDS.sleep(3);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "离开车位");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					// 释放资源
					semaphore.release();
				}
			}).start();
		}
	}
}
