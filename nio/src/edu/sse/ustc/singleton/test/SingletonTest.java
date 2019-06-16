package edu.sse.ustc.singleton.test;

import edu.sse.ustc.singleton.*;

import java.util.concurrent.*;

/** 单例模式 测试
 * @author imarklei90
 * @since 2019.05.15
 */
public class SingletonTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 直接创建
		Singleton01 instance = Singleton01.INSTANCE;

		// 枚举类型
		Singleton02 instance2 = Singleton02.INSTANCE;

		// 静态代码块
		Singleton03 instance3 = Singleton03.INSTANCE;
		System.out.println(instance3);

		// 懒汉式
		Singleton04 instance4 = Singleton04.getInstance();
		System.out.println(instance4);

		// 多线程访问(线程不安全)
		Callable<Singleton04> c = new Callable<Singleton04>() {
			@Override
			public Singleton04 call() throws Exception {
				return Singleton04.getInstance();
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Singleton04> future1 = executorService.submit(c);
		Future<Singleton04> future2 = executorService.submit(c);

		Singleton04 s1 = future1.get();
		Singleton04 s2 = future2.get();

		System.out.println(s1 == s2);

		executorService.shutdown();

		// 多线程访问(线程不安全)
		Callable<Singleton05> c1 = new Callable<Singleton05>() {
			@Override
			public Singleton05 call() throws Exception {
				return Singleton05.getInstance();
			}
		};

		ExecutorService executorService2 = Executors.newFixedThreadPool(2);
		Future<Singleton05> future3 = executorService2.submit(c1);
		Future<Singleton05> future4 = executorService2.submit(c1);

		Singleton05 s3 = future3.get();
		Singleton05 s4 = future4.get();

		System.out.println(s3 == s4);

		executorService.shutdown();


	}
}
