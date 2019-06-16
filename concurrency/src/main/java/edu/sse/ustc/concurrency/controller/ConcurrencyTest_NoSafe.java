package main.java.edu.sse.ustc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log_$logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 并发测试
 * @author imarklei90
 * @since 2019.06.05
 */

@Slf4j
public class ConcurrencyTest_NoSafe {

	// 请求总数
	public static int clientTotal = 1000;

	// 同时并发执行线程数
	public static int threadTotal = 50;

	public static int count = 0;

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
		++count;
	}
}
