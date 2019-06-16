package edu.sse.ustc.singleton;

/** 单例模式 - 饿汉式 （直接创建对象，不存在线程安全问题）
 *  方式一：直接创建对象
 * @author imarklei90
 * @since 2019.05.15
 */
public class Singleton01 {

	public static final Singleton01 INSTANCE = new Singleton01();

	private Singleton01(){

	}


}
