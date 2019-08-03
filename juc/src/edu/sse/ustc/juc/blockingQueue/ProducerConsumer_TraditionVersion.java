package edu.sse.ustc.juc.blockingQueue;


/** 生产者消费者 - 传统版本
 *
 * 需求：一个初始值为0的变量，两个线程交替操作，一个加，一个减
 * 步骤：
 * 1.  线程		操作(方法)		资源类
 * 2.  判断		干活		通知
 * 3.  防止虚假唤醒机制
 *
 * @author imarklei90
 * @since 2019.08.03
 */
public class ProducerConsumer_TraditionVersion {

	public static void main(String[] args) {
		ShareData shareData = new ShareData();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					shareData.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "AA").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					shareData.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "BB").start();

	}
}

