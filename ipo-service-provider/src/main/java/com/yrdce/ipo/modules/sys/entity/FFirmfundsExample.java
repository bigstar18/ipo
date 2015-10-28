package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yrdce.ipo.common.persistence.DataEntity;

public class FFirmfundsExample extends DataEntity<FFirmfundsExample> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FFirmfundsExample() {
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

		public Criteria andBalanceIsNull() {
			addCriterion("BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNotNull() {
			addCriterion("BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceEqualTo(BigDecimal value) {
			addCriterion("BALANCE =", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotEqualTo(BigDecimal value) {
			addCriterion("BALANCE <>", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThan(BigDecimal value) {
			addCriterion("BALANCE >", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BALANCE >=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThan(BigDecimal value) {
			addCriterion("BALANCE <", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BALANCE <=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceIn(List<BigDecimal> values) {
			addCriterion("BALANCE in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotIn(List<BigDecimal> values) {
			addCriterion("BALANCE not in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BALANCE between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BALANCE not between", value1, value2, "balance");
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

		public Criteria andLastbalanceIsNull() {
			addCriterion("LASTBALANCE is null");
			return (Criteria) this;
		}

		public Criteria andLastbalanceIsNotNull() {
			addCriterion("LASTBALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andLastbalanceEqualTo(BigDecimal value) {
			addCriterion("LASTBALANCE =", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceNotEqualTo(BigDecimal value) {
			addCriterion("LASTBALANCE <>", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceGreaterThan(BigDecimal value) {
			addCriterion("LASTBALANCE >", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTBALANCE >=", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceLessThan(BigDecimal value) {
			addCriterion("LASTBALANCE <", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTBALANCE <=", value, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceIn(List<BigDecimal> values) {
			addCriterion("LASTBALANCE in", values, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceNotIn(List<BigDecimal> values) {
			addCriterion("LASTBALANCE not in", values, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTBALANCE between", value1, value2, "lastbalance");
			return (Criteria) this;
		}

		public Criteria andLastbalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTBALANCE not between", value1, value2, "lastbalance");
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

		public Criteria andSettlemarginIsNull() {
			addCriterion("SETTLEMARGIN is null");
			return (Criteria) this;
		}

		public Criteria andSettlemarginIsNotNull() {
			addCriterion("SETTLEMARGIN is not null");
			return (Criteria) this;
		}

		public Criteria andSettlemarginEqualTo(BigDecimal value) {
			addCriterion("SETTLEMARGIN =", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginNotEqualTo(BigDecimal value) {
			addCriterion("SETTLEMARGIN <>", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginGreaterThan(BigDecimal value) {
			addCriterion("SETTLEMARGIN >", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SETTLEMARGIN >=", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginLessThan(BigDecimal value) {
			addCriterion("SETTLEMARGIN <", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SETTLEMARGIN <=", value, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginIn(List<BigDecimal> values) {
			addCriterion("SETTLEMARGIN in", values, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginNotIn(List<BigDecimal> values) {
			addCriterion("SETTLEMARGIN not in", values, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SETTLEMARGIN between", value1, value2, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andSettlemarginNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SETTLEMARGIN not between", value1, value2, "settlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginIsNull() {
			addCriterion("LASTSETTLEMARGIN is null");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginIsNotNull() {
			addCriterion("LASTSETTLEMARGIN is not null");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginEqualTo(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN =", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginNotEqualTo(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN <>", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginGreaterThan(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN >", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN >=", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginLessThan(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN <", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LASTSETTLEMARGIN <=", value, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginIn(List<BigDecimal> values) {
			addCriterion("LASTSETTLEMARGIN in", values, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginNotIn(List<BigDecimal> values) {
			addCriterion("LASTSETTLEMARGIN not in", values, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTSETTLEMARGIN between", value1, value2, "lastsettlemargin");
			return (Criteria) this;
		}

		public Criteria andLastsettlemarginNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LASTSETTLEMARGIN not between", value1, value2, "lastsettlemargin");
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