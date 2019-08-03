package edu.sse.ustc.juc;

import java.util.concurrent.CountDownLatch;

/** CountDownLatchDemo
 * @author imarklei90
 * @since 2019.08.03
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		for (int i = 1; i <= 3; i++) {
			new Thread(() ->{
				System.out.println(Thread.currentThread().getName() + "----离开");
				countDownLatch.countDown();
			},NameEnum.iter_NameEnum(i).getName()).start();
		}

		countDownLatch.await();
		System.out.println(Thread.currentThread().getName() + "最后离开=========");
	}

}
