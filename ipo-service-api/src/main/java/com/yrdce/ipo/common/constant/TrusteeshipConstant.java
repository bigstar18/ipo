package com.yrdce.ipo.common.constant;

public interface TrusteeshipConstant {

	//申请状态
	public static enum State{
		APPLY(1,"申请"),
		CANCEL(2,"撤销"),
		FIRST_PASS(3,"仓库初审通过"),
		FIRST_NOTPASS(4,"仓库初审驳回"),
		FINAL_PASS (5,"仓库终审通过"),
		FINAL_NOTPASS(6,"仓库终审驳回"),
		MARKET_PASS (7,"市场审核通过"),
		MARKET_NOTPASS(8,"市场审核驳回"),
		INCREASE(9,"已增持加仓"),
		REDUCTION(10,"已设置预减持");
		
		private int code;
		private String name;
		private State(int code,String name){
			this.code=code;
			this.name=name;
		}
		public int getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
		public static String getName(int code){
			for(State item:State.values()){
				if (item.getCode() == code) {  
	                return item.getName();  
	            }  
			}
			return null;  
		}
	}
	
	
	
   //托管计划状态
	public static enum PlanState{
		NOT_START(1,"未生效"),
		STARTING(2,"生效"),
		END(3,"结束");
		private int code;
		private String name;
		private PlanState(int code,String name){
			this.code=code;
			this.name=name;
		}
		public int getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
		public static String getName(int code){
			for(State item:State.values()){
				if (item.getCode() == code) {  
	                return item.getName();  
	            }  
			}
			return null;  
		}
	}
	
	
}
