package edu.sse.ustc.singleton;

import java.io.IOException;
import java.util.Properties;

/** 单例模式 - 饿汉式
 *  方式三：静态代码块
 * @author imarklei90
 * @since 2019.05.15
 */
public class Singleton03 {

	public static final Singleton03 INSTANCE;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	static {
		Properties prop = new Properties();
		try {
			prop.load(Singleton03.class.getClassLoader().getResourceAsStream("singleton.properties"));
			INSTANCE = new Singleton03(prop.getProperty("info"));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Singleton03(String info){
		this.info = info;
	}

	@Override
	public String toString() {
		return "Singleton03{" +
				"info='" + info + '\'' +
				'}';
	}
}
