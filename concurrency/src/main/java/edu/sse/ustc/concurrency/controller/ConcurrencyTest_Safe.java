package main.java.edu.sse.ustc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/** 并发测试
 * @author imarklei90
 * @since 2019.06.05
 */

@Slf4j
public class ConcurrencyTest_Safe {

	// 请求总数
	public static int clientTotal = 1000;

	// 同时并发执行线程数
	public static int threadTotal = 50;

	public static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {

		// 定义线程迟
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 定义信号量
		final Semaphore semaphore = new Semaphore(threadTotal);
		// 定义闭锁
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0; i < clientTotal; i++){
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				}catch (Exception e){
					e.printStackTrace();
				}
				countDownLatch.countDown();

			});
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println("count : " + count);
	}

	private static void add(){
		count.getAndIncrement();
	}
}
