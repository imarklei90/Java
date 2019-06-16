package edu.sse.ustc.singleton;

/** 单例模式 - 懒汉式
 *  方式二：线程安全
 *
 * @author imarklei90
 * @since 2019.05.15
 */
public class Singleton05 {

	private static Singleton05 instance;

	private Singleton05(){

	}

	// 线程不安全
	public static Singleton05 getInstance(){
		if(instance == null) {
			synchronized (Singleton05.class) {
				if (instance == null) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Singleton05();
				}
			}
		}
		return instance;
	}
}
