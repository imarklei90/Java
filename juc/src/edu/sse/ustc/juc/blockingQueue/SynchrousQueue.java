package edu.sse.ustc.juc.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/** Synchronous Queue 不存储元素
 * @author imarklei90
 * @since 2019.08.03
 */
public class SynchrousQueue {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

		new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + "Put 1");
				blockingQueue.put("1");
				System.out.println(Thread.currentThread().getName() + "Put 2");
				blockingQueue.put("2");
				System.out.println(Thread.currentThread().getName() + "Put 3");
				blockingQueue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A").start();


		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(blockingQueue.take());

				TimeUnit.SECONDS.sleep(5);
				System.out.println(blockingQueue.take());

				TimeUnit.SECONDS.sleep(5);
				System.out.println(blockingQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "B").start();
	}
}
