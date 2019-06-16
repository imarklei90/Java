package main.java.edu.sse.ustc.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 用来标记线程不安全的类
 * @author imarklei90
 * @since 2019.06.04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NoThreadSafe {
	String value() default "";
}
