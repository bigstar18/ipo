package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yrdce.ipo.common.persistence.DataEntity;

public class VFFirmcurfundsExample extends DataEntity<VFFirmcurfundsExample> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public VFFirmcurfundsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andFirmidIsNull() {
			addCriterion("FIRMID is null");
			return (Criteria) this;
		}

		public Criteria andFirmidIsNotNull() {
			addCriterion("FIRMID is not null");
			return (Criteria) this;
		}

		public Criteria andFirmidEqualTo(String value) {
			addCriterion("FIRMID =", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidNotEqualTo(String value) {
			addCriterion("FIRMID <>", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidGreaterThan(String value) {
			addCriterion("FIRMID >", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidGreaterThanOrEqualTo(String value) {
			addCriterion("FIRMID >=", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidLessThan(String value) {
			addCriterion("FIRMID <", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidLessThanOrEqualTo(String value) {
			addCriterion("FIRMID <=", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidLike(String value) {
			addCriterion("FIRMID like", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidNotLike(String value) {
			addCriterion("FIRMID not like", value, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidIn(List<String> values) {
			addCriterion("FIRMID in", values, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidNotIn(List<String> values) {
			addCriterion("FIRMID not in", values, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidBetween(String value1, String value2) {
			addCriterion("FIRMID between", value1, value2, "firmid");
			return (Criteria) this;
		}

		public Criteria andFirmidNotBetween(String value1, String value2) {
			addCriterion("FIRMID not between", value1, value2, "firmid");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andFBalanceIsNull() {
			addCriterion("F_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andFBalanceIsNotNull() {
			addCriterion("F_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andFBalanceEqualTo(BigDecimal value) {
			addCriterion("F_BALANCE =", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceNotEqualTo(BigDecimal value) {
			addCriterion("F_BALANCE <>", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceGreaterThan(BigDecimal value) {
			addCriterion("F_BALANCE >", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("F_BALANCE >=", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceLessThan(BigDecimal value) {
			addCriterion("F_BALANCE <", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("F_BALANCE <=", value, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceIn(List<BigDecimal> values) {
			addCriterion("F_BALANCE in", values, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceNotIn(List<BigDecimal> values) {
			addCriterion("F_BALANCE not in", values, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("F_BALANCE between", value1, value2, "fBalance");
			return (Criteria) this;
		}

		public Criteria andFBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("F_BALANCE not between", value1, value2, "fBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceIsNull() {
			addCriterion("L_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andLBalanceIsNotNull() {
			addCriterion("L_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andLBalanceEqualTo(BigDecimal value) {
			addCriterion("L_BALANCE =", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceNotEqualTo(BigDecimal value) {
			addCriterion("L_BALANCE <>", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceGreaterThan(BigDecimal value) {
			addCriterion("L_BALANCE >", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("L_BALANCE >=", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceLessThan(BigDecimal value) {
			addCriterion("L_BALANCE <", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("L_BALANCE <=", value, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceIn(List<BigDecimal> values) {
			addCriterion("L_BALANCE in", values, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceNotIn(List<BigDecimal> values) {
			addCriterion("L_BALANCE not in", values, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("L_BALANCE between", value1, value2, "lBalance");
			return (Criteria) this;
		}

		public Criteria andLBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("L_BALANCE not between", value1, value2, "lBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceIsNull() {
			addCriterion("Y_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andYBalanceIsNotNull() {
			addCriterion("Y_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andYBalanceEqualTo(BigDecimal value) {
			addCriterion("Y_BALANCE =", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceNotEqualTo(BigDecimal value) {
			addCriterion("Y_BALANCE <>", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceGreaterThan(BigDecimal value) {
			addCriterion("Y_BALANCE >", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("Y_BALANCE >=", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceLessThan(BigDecimal value) {
			addCriterion("Y_BALANCE <", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("Y_BALANCE <=", value, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceIn(List<BigDecimal> values) {
			addCriterion("Y_BALANCE in", values, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceNotIn(List<BigDecimal> values) {
			addCriterion("Y_BALANCE not in", values, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Y_BALANCE between", value1, value2, "yBalance");
			return (Criteria) this;
		}

		public Criteria andYBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Y_BALANCE not between", value1, value2, "yBalance");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractIsNull() {
			addCriterion("BALANCESUBTRACT is null");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractIsNotNull() {
			addCriterion("BALANCESUBTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractEqualTo(BigDecimal value) {
			addCriterion("BALANCESUBTRACT =", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractNotEqualTo(BigDecimal value) {
			addCriterion("BALANCESUBTRACT <>", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractGreaterThan(BigDecimal value) {
			addCriterion("BALANCESUBTRACT >", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BALANCESUBTRACT >=", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractLessThan(BigDecimal value) {
			addCriterion("BALANCESUBTRACT <", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BALANCESUBTRACT <=", value, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractIn(List<BigDecimal> values) {
			addCriterion("BALANCESUBTRACT in", values, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractNotIn(List<BigDecimal> values) {
			addCriterion("BALANCESUBTRACT not in", values, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BALANCESUBTRACT between", value1, value2, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andBalancesubtractNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BALANCESUBTRACT not between", value1, value2, "balancesubtract");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyIsNull() {
			addCriterion("LASTWARRANTY is null");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyIsNotNull() {
			addCriterion("LASTWARRANTY is not null");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyEqualTo(BigDecimal value) {
			addCriterion("LASTWARRANTY =", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyNotEqualTo(BigDecimal value) {
			addCriterion("LASTWARRANTY <>", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyGreaterThan(BigDecimal value) {
			addCriterion("LASTWARRANTY >", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTWARRANTY >=", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyLessThan(BigDecimal value) {
			addCriterion("LASTWARRANTY <", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTWARRANTY <=", value, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyIn(List<BigDecimal> values) {
			addCriterion("LASTWARRANTY in", values, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyNotIn(List<BigDecimal> values) {
			addCriterion("LASTWARRANTY not in", values, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTWARRANTY between", value1, value2, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andLastwarrantyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTWARRANTY not between", value1, value2, "lastwarranty");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsIsNull() {
			addCriterion("FROZENFUNDS is null");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsIsNotNull() {
			addCriterion("FROZENFUNDS is not null");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsEqualTo(BigDecimal value) {
			addCriterion("FROZENFUNDS =", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsNotEqualTo(BigDecimal value) {
			addCriterion("FROZENFUNDS <>", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsGreaterThan(BigDecimal value) {
			addCriterion("FROZENFUNDS >", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FROZENFUNDS >=", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsLessThan(BigDecimal value) {
			addCriterion("FROZENFUNDS <", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FROZENFUNDS <=", value, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsIn(List<BigDecimal> values) {
			addCriterion("FROZENFUNDS in", values, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsNotIn(List<BigDecimal> values) {
			addCriterion("FROZENFUNDS not in", values, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FROZENFUNDS between", value1, value2, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andFrozenfundsNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FROZENFUNDS not between", value1, value2, "frozenfunds");
			return (Criteria) this;
		}

		public Criteria andUserBalanceIsNull() {
			addCriterion("USER_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andUserBalanceIsNotNull() {
			addCriterion("USER_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andUserBalanceEqualTo(BigDecimal value) {
			addCriterion("USER_BALANCE =", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceNotEqualTo(BigDecimal value) {
			addCriterion("USER_BALANCE <>", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceGreaterThan(BigDecimal value) {
			addCriterion("USER_BALANCE >", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_BALANCE >=", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceLessThan(BigDecimal value) {
			addCriterion("USER_BALANCE <", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_BALANCE <=", value, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceIn(List<BigDecimal> values) {
			addCriterion("USER_BALANCE in", values, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceNotIn(List<BigDecimal> values) {
			addCriterion("USER_BALANCE not in", values, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_BALANCE between", value1, value2, "userBalance");
			return (Criteria) this;
		}

		public Criteria andUserBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_BALANCE not between", value1, value2, "userBalance");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}