package com.yrdce.ipo.common.constant;

/**
 * 持仓常量
 * @author wq 2016-2-16
 *
 */
public interface PositionConstant {
	
	/*****************start********************/
 
	
	/*****************end********************/
	 
	//持仓流水状态
	public static enum FlowState {
		no_turn_goods(1, "待转现货"), turn_goods(2, "已转现货");
		
		private int code;
		private String name;

		private FlowState(int code, String name) {
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
			for (FlowState item : FlowState.values()) {
				if (item.getCode()==code ){
					return item.getName();
				}
			}
			return null;
		}
	}
	
	//持仓减持状态
	public static enum ReduceState {
		no_reduce(1, "未减持"), reduce(2, "已减持");
		
		private int code;
		private String name;

		private ReduceState(int code, String name) {
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
			for (ReduceState item : ReduceState.values()) {
				if (item.getCode()==code ){
					return item.getName();
				}
			}
			return null;
		}
	}
		
}
