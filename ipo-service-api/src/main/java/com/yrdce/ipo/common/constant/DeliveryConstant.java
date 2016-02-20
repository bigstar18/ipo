package com.yrdce.ipo.common.constant;

/**
 * 交收常量
 * 
 * @author cj 2016-1-1
 * 
 */
public interface DeliveryConstant {

	/***************** start ********************/
	// 流程常量
	public final static String FLOW = "delivery.flow";
	// 状态常量
	public final static String STATUS = "delivery.status";

	/***************** end ********************/

	// 交收流程类型
	public static enum FlowType {
		SELFPICK("001", "自提流程"), EXPRESS("002", "配送流程"), TRANSFER("003", "过户流程");

		private String code;
		private String name;

		private FlowType(String code, String name) {
			this.code = code;
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static String getName(String code) {
			for (FlowType item : FlowType.values()) {
				if (item.getCode().equals(code)) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 状态类型
	public static enum StatusType {
		REGISTER("001", "注册"), MARKETPASS("002001", "市场通过"), MARKETNOPASS(
				"002002", "市场驳回"), PRINTED("003001", "已自提打印"), TRANSFERRED(
				"003001001", "已货权过户"), EXPRESSCOSTSET("003002", "已设置配送费用"), CONFIRM(
				"003002001", "已确认"), WAREHOUSEPASS("004001", "仓库通过"), WAREHOUSENOPASS(
				"004002", "仓库驳回"), WAREHOUSEOUT("005", "已出库"), CANCEL("006",
				"已废除");

		private String code;
		private String name;

		private StatusType(String code, String name) {
			this.code = code;
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static String getName(String code) {
			for (StatusType item : StatusType.values()) {
				if (item.getCode().equals(code)) {
					return item.getName();
				}
			}
			return null;
		}
	}

}
