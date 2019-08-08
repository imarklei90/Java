package edu.sse.ustc.enums;

/**
 * Enum 测试
 *
 * @author imarklei90
 * @since 2019.08.08
 */
public class EnumTest {

	public static void main(String[] args) {
		EnumBean[] enumBeans = EnumBean.values();
		for (EnumBean value: enumBeans) {
			System.out.println(value.getSeasonName() + "---->" + value.getSeasonDesc());

		}
	}

}
