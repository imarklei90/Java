package edu.sse.ustc.enums;

/** 定义枚举
 * @author imarklei90
 * @since 2019.08.08
 */
public enum EnumBean {

	SPIRING("春天", "spring"),
	SUMMER("夏天", "summer"),
	AUTUMN("秋天", "autumn"),
	WINTER("冬天", "winter");

	private String seasonName;
	private String seasonDesc;

	EnumBean(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	public void setSeasonDesc(String seasonDesc) {
		this.seasonDesc = seasonDesc;
	}

	public static String getDescByName(String name){
		for (EnumBean enumBean : EnumBean.values()) {
			if(enumBean.getSeasonName().equalsIgnoreCase(name)){
				return enumBean.getSeasonDesc();
			}
		}
		return null;
	}
}
