package com.yrdce.ipo.common.constant;

/**
 * 费用常量
 * 
 * @author wq 2016-1-1
 * 
 */
public interface ChargeConstant {

	/***************** start ********************/
	// 业务常量
	public final static String BUSINESS = "charge.business";
	// 角色常量
	public final static String ROLE = "charge.role";

	/***************** end ********************/

	// 业务类型
	public static enum BusinessType {
		UNDERWRITE("001", "承销业务"), PUBLISH("002", "发行业务"), MEMBER("003", "经纪业务"), INCREASE_PUBLISH(
				"004", "增发业务"), DELIVERY("005", "交收业务"), PURCHASE("006", "申购业务"), TRUSTEESHIP(
				"007", "库转交易业务");

		private String code;
		private String name;

		private BusinessType(String code, String name) {
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
			for (BusinessType item : BusinessType.values()) {
				if (item.getCode().equals(code)) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 费用类型
	public static enum ChargeType {
		HANDLING("001", "手续费"), GOODS("002", "货款"), REGISTER("003001", "提单注册费"), CANCEL(
				"003002", "提单注销费"), CHANGE_OWNER("003003", "提单过户费"), CARRIAGE(
				"003004", "提单配送费"), WAREHOUSING("004001", "仓储费"), INSURANCE(
				"004002", "保险费"), TRUSTEE("004003", "托管费"), LISTING("005",
				"挂牌费"), COMMISSION("006", "佣金"), OTHER("007", "其他费");

		private String code;
		private String name;

		private ChargeType(String code, String name) {
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
			for (ChargeType item : ChargeType.values()) {
				if (item.getCode().equals(code)) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 角色类型
	public static enum RoleType {
		MARKET("001", "市场"), PUBLISHER("002", "发行商"), UNDERWRITER("003", "承销商"), MEMBER(
				"004", "经济会员"), TRADER("005", "交易商");

		private String code;
		private String name;

		private RoleType(String code, String name) {
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
			for (RoleType item : RoleType.values()) {
				if (item.getCode().equals(code)) {
					return item.getName();
				}
			}
			return null;
		}
	}

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

	// 扣款模式
	public static enum DebitMode {
		ONLINE(1, "线上"), OFFLINE(2, "线下");
		private int code;
		private String name;

		private DebitMode(int code, String name) {
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
			for (DebitMode item : DebitMode.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 付款模式
	public static enum PayMode {
		ONLINE(1, "线上"), OFFLINE(2, "线下");
		private int code;
		private String name;

		private PayMode(int code, String name) {
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
			for (PayMode item : PayMode.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 扣款渠道
	public static enum DebitChannel {
		DEPOSIT(1, "保证金"), CASH(2, "现金"), CARD(3, "刷卡"), ALIPAY(4, "支付宝"), WECHAT(
				5, "微信");
		private int code;
		private String name;

		private DebitChannel(int code, String name) {
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
			for (DebitChannel item : DebitChannel.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 付款渠道
	public static enum PayChannel {
		DEPOSIT(1, "保证金"), CASH(2, "现金"), CARD(3, "刷卡"), ALIPAY(4, "支付宝"), WECHAT(
				5, "微信");
		private int code;
		private String name;

		private PayChannel(int code, String name) {
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
			for (PayChannel item : PayChannel.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 扣款状态
	public static enum DebitState {
		FROZEN_SUCCESS(1, "冻结成功"), PAY_SUCCESS(2, "扣款成功"), FROZEN_FAIL(3,
				"冻结失败"), PAY_FAIL(4, "扣款失败");
		private int code;
		private String name;

		private DebitState(int code, String name) {
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
			for (DebitState item : DebitState.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

	// 扣款状态
	public static enum PayState {
		UNPAY(1, "未付款"), PAY_SUCCESS(2, "已付款");
		private int code;
		private String name;

		private PayState(int code, String name) {
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
			for (PayState item : PayState.values()) {
				if (item.getCode() == code) {
					return item.getName();
				}
			}
			return null;
		}
	}

}
