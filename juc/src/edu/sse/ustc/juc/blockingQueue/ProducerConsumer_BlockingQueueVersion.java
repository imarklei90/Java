package edu.sse.ustc.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**生产者消费者 - 阻塞队列版本
 *
 * Valatile/CAS/AtomicInteger/BlockingQueue/线程交互
 *
 * @author imarklei90
 * @since 2019.08.03
 */
public class ProducerConsumer_BlockingQueueVersion {
	public static void main(String[] args) {
		MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "\t" + "生产线程启动");
			try {
				myResource.myProducer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Produce").start();

		new Thread(() ->{
			System.out.println(Thread.currentThread().getName() + "\t" + "消费线程启动");
			try {
				myResource.myConsumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Consume").start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main线程停止");
		myResource.stop();
	}
}

/**
 * 资源类
 */
class MyResource{

	private volatile boolean FLAG = true;// 默认开启，进行生产和消费
	private AtomicInteger atomicInteger = new AtomicInteger();

	BlockingQueue<String> blockingQueue = null;

	public MyResource(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
	}

	public void myProducer() throws InterruptedException {

		String data = null;
		boolean retValue;
		while (FLAG){
			data = atomicInteger.incrementAndGet()+ "";
			retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
			if (retValue){
				System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + " 成功");
			}else{
				System.out.println(Thread.currentThread().getName() + "\t 插入队列失败");
			}
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(Thread.currentThread().getName() + "线程停止");
	}

	public void myConsumer() throws InterruptedException {
		String result = null;
		while (FLAG){
			result = blockingQueue.poll(2L, TimeUnit.SECONDS);
			if (null == result || "".equalsIgnoreCase(result)){
				FLAG = false;
				System.out.println(Thread.currentThread().getName() + "\t" + "超时，消费退出");
				return;
			}
			System.out.println(Thread.currentThread().getName() + "\t消费队列" + result + " 成功");
		}
	}

	public void stop(){
		this.FLAG = false;
	}

}
