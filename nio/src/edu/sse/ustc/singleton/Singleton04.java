package edu.sse.ustc.singleton;

/** 单例模式 - 懒汉式
 *  方式一：延迟创建实例对象，线程不安全
 *
 * @author imarklei90
 * @since 2019.05.15
 */
public class Singleton04 {

	private static Singleton04 instance;

	private Singleton04(){

	}

	// 线程不安全
	public static Singleton04 getInstance(){
		if(instance == null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Singleton04();
		}
		return instance;
	}
}
