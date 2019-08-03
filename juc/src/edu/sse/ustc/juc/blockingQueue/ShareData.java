package edu.sse.ustc.juc.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData{
	private int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void increment() throws InterruptedException {

		lock.lock();
		try {
			// 1. 判断
			while (number != 0){
				condition.await();
			}
			// 2. 干活
			number++;
			System.out.println(Thread.currentThread().getName() + "\t" + number);

			// 3. 通知唤醒
			condition.signalAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void decrement() throws InterruptedException {

		lock.lock();
		try {
			// 1. 判断
			while (number == 0){
				condition.await();
			}
			// 2. 干活
			number--;
			System.out.println(Thread.currentThread().getName() + "\t" + number);

			// 3. 通知唤醒
			condition.signalAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

}
