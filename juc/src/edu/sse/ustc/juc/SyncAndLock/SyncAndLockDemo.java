package edu.sse.ustc.juc.SyncAndLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Synchronized 和Lock
 *
 * 需求：
 * A打印5次，B打印10次，C打印15次
 *
 * @author imarklei90
 * @since 2019.08.03
 */
public class SyncAndLockDemo {

	public static void main(String[] args) {
		ShareResource shareResource = new ShareResource();

		new Thread(() ->{
			for (int i = 1; i <= 5; i++) {
				shareResource.print5();
			}
		}, "AA").start();

		new Thread(() ->{
			for (int i = 1; i <= 10; i++) {
				shareResource.print10();
			}
		}, "BB").start();

		new Thread(() ->{
			for (int i = 1; i <= 15; i++) {
				shareResource.print15();
			}
		}, "CC").start();
	}
}

class ShareResource{
	private int number = 1;

	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void print5(){
		lock.lock();
		try {
			while(number != 1){
				c1.await();
			}

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number++);
			}

			number = 2;
			c2.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void print10(){
		lock.lock();
		try {
			while(number != 2){
				c2.await();
			}

			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number++);
			}

			number = 3;
			c3.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void print15(){
		lock.lock();
		try {
			while(number != 3){
				c3.await();
			}

			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number++);
			}

			number = 1;
			c1.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
