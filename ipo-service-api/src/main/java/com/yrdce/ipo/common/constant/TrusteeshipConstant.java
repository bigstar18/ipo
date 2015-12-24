package com.yrdce.ipo.common.constant;

public interface TrusteeshipConstant {

	//申请状态
	public static enum State{
		APPLY(1,"申请"),
		CANCEL(2,"撤销"),
		FIRST_PASS(3,"初审通过"),
		FIRST_NOTPASS(4,"初审不通过"),
		FINAL_PASS (5,"终审通过"),
		FINAL_NOTPASS(6,"终审不通过"),
		INCREASE(7,"已增持加仓"),
		REDUCTION(8,"已设置预减持");
		
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
	
	
	
	
	
	
}
