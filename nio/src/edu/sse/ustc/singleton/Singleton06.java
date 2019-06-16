package edu.sse.ustc.singleton;

/** 单例模式 - 懒汉式
 * 	方式三：静态内部类，不会随着外部类的加载和初始化而初始化，而是单独加载和初始化 线程安全
 * @author imarklei90
 * @since 2019.05.15
 */
public class Singleton06 {

	private Singleton06(){

	}

	// 内部类
	private static class inner{
		private static final Singleton06 INSTANCE = new Singleton06();
	}

	public static Singleton06 getInstance(){
		return inner.INSTANCE;
	}
}
