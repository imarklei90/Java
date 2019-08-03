package edu.sse.ustc.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**CyclicBarrier
 * @author imarklei90
 * @since 2019.08.03
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
			System.out.println("------Completed-------");
		});

		for (int i = 1; i <= 7; i++) {
			final int temp = i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + " 到达第 " + temp);
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}
}
