package edu.sse.ustc.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** Blocking Queue
 * @author imarklei90
 * @since 2019.08.03
 */
public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
		System.out.println(blockingQueue.add("a"));
		System.out.println(blockingQueue.add("b"));
		System.out.println(blockingQueue.add("c"));

		// java.lang.IllegalStateException: Queue full
		// blockingQueue.add("d");
	}
}
