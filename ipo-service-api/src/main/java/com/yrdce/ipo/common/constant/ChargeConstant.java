package com.yrdce.ipo.common.constant;

/**
 * 费用常量
 * 
 * @author wq 2016-1-1
 * 
 */
public interface ChargeConstant {
	
	/*****************start********************/
	// 业务常量
	public final static String BUSINESS = "charge.business";
	// 角色常量
	public final static String ROLE = "charge.role";

	
	/*****************end********************/
	
	
	
	
	// 费用类型
	public static enum Type {
		DISPOSABLE(1, "一次性费用"), CYCLICITY(2, "周期性费用");
		private int code;
		private String name;

		private Type(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static String getName(int code) {
			for (Type item : Type.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 收费模式 
	public static enum Pattern {
		PERCENTAGE(1, "百分比"), FIXED(2, "固定值");
		private int code;
		private String name;

		private Pattern(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static String getName(int code) {
			for (Pattern item : Pattern.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

}
