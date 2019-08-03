package edu.sse.ustc.juc;

import javax.naming.Name;

/** 名称的枚举定义 : 相当于是数据库的一张表
 * @author imarklei90
 * @since 2019.08.03
 */
public enum NameEnum {

	ONE(1, "张三"), TWO(2, "李四"), THREE(3, "王五");

	private Integer id;
	private String name;

	NameEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 枚举的遍历
	 * @param index
	 * @return
	 */
	public static NameEnum iter_NameEnum(int index){
		NameEnum[] nameArrs = NameEnum.values();
		for (NameEnum nameEnum : nameArrs) {
			if(index == nameEnum.getId()){
				return nameEnum;
			}
		}

		return null;
	}
}
