package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoDistributionExample extends DataEntity<IpoDistributionExample> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IpoDistributionExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(BigDecimal value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(BigDecimal value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(BigDecimal value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(BigDecimal value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<BigDecimal> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<BigDecimal> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOrderidIsNull() {
			addCriterion("orderid is null");
			return (Criteria) this;
		}

		public Criteria andOrderidIsNotNull() {
			addCriterion("orderid is not null");
			return (Criteria) this;
		}

		public Criteria andOrderidEqualTo(BigDecimal value) {
			addCriterion("orderid =", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotEqualTo(BigDecimal value) {
			addCriterion("orderid <>", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidGreaterThan(BigDecimal value) {
			addCriterion("orderid >", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("orderid >=", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidLessThan(BigDecimal value) {
			addCriterion("orderid <", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidLessThanOrEqualTo(BigDecimal value) {
			addCriterion("orderid <=", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidIn(List<BigDecimal> values) {
			addCriterion("orderid in", values, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotIn(List<BigDecimal> values) {
			addCriterion("orderid not in", values, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("orderid between", value1, value2, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("orderid not between", value1, value2, "orderid");
			return (Criteria) this;
		}

		public Criteria andStartNumberIsNull() {
			addCriterion("start_number is null");
			return (Criteria) this;
		}

		public Criteria andStartNumberIsNotNull() {
			addCriterion("start_number is not null");
			return (Criteria) this;
		}

		public Criteria andStartNumberEqualTo(BigDecimal value) {
			addCriterion("start_number =", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberNotEqualTo(BigDecimal value) {
			addCriterion("start_number <>", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberGreaterThan(BigDecimal value) {
			addCriterion("start_number >", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("start_number >=", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberLessThan(BigDecimal value) {
			addCriterion("start_number <", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberLessThanOrEqualTo(BigDecimal value) {
			addCriterion("start_number <=", value, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberIn(List<BigDecimal> values) {
			addCriterion("start_number in", values, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberNotIn(List<BigDecimal> values) {
			addCriterion("start_number not in", values, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("start_number between", value1, value2, "startNumber");
			return (Criteria) this;
		}

		public Criteria andStartNumberNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("start_number not between", value1, value2, "startNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityIsNull() {
			addCriterion("distribution_quantity is null");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityIsNotNull() {
			addCriterion("distribution_quantity is not null");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityEqualTo(BigDecimal value) {
			addCriterion("distribution_quantity =", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityNotEqualTo(BigDecimal value) {
			addCriterion("distribution_quantity <>", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityGreaterThan(BigDecimal value) {
			addCriterion("distribution_quantity >", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("distribution_quantity >=", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityLessThan(BigDecimal value) {
			addCriterion("distribution_quantity <", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityLessThanOrEqualTo(BigDecimal value) {
			addCriterion("distribution_quantity <=", value, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityIn(List<BigDecimal> values) {
			addCriterion("distribution_quantity in", values, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityNotIn(List<BigDecimal> values) {
			addCriterion("distribution_quantity not in", values, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("distribution_quantity between", value1, value2, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("distribution_quantity not between", value1, value2, "distributionQuantity");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberIsNull() {
			addCriterion("distribution_number is null");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberIsNotNull() {
			addCriterion("distribution_number is not null");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberEqualTo(String value) {
			addCriterion("distribution_number =", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberNotEqualTo(String value) {
			addCriterion("distribution_number <>", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberGreaterThan(String value) {
			addCriterion("distribution_number >", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberGreaterThanOrEqualTo(String value) {
			addCriterion("distribution_number >=", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberLessThan(String value) {
			addCriterion("distribution_number <", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberLessThanOrEqualTo(String value) {
			addCriterion("distribution_number <=", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberLike(String value) {
			addCriterion("distribution_number like", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberNotLike(String value) {
			addCriterion("distribution_number not like", value, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberIn(List<String> values) {
			addCriterion("distribution_number in", values, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberNotIn(List<String> values) {
			addCriterion("distribution_number not in", values, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberBetween(String value1, String value2) {
			addCriterion("distribution_number between", value1, value2, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionNumberNotBetween(String value1, String value2) {
			addCriterion("distribution_number not between", value1, value2, "distributionNumber");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeIsNull() {
			addCriterion("distribution_time is null");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeIsNotNull() {
			addCriterion("distribution_time is not null");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeEqualTo(Date value) {
			addCriterionForJDBCDate("distribution_time =", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("distribution_time <>", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("distribution_time >", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("distribution_time >=", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeLessThan(Date value) {
			addCriterionForJDBCDate("distribution_time <", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("distribution_time <=", value, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeIn(List<Date> values) {
			addCriterionForJDBCDate("distribution_time in", values, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("distribution_time not in", values, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("distribution_time between", value1, value2, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andDistributionTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("distribution_time not between", value1, value2, "distributionTime");
			return (Criteria) this;
		}

		public Criteria andNumberIsNull() {
			addCriterion("number is null");
			return (Criteria) this;
		}

		public Criteria andNumberIsNotNull() {
			addCriterion("number is not null");
			return (Criteria) this;
		}

		public Criteria andNumberEqualTo(String value) {
			addCriterion("number =", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberNotEqualTo(String value) {
			addCriterion("number <>", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberGreaterThan(String value) {
			addCriterion("number >", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberGreaterThanOrEqualTo(String value) {
			addCriterion("number >=", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberLessThan(String value) {
			addCriterion("number <", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberLessThanOrEqualTo(String value) {
			addCriterion("number <=", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberLike(String value) {
			addCriterion("number like", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberNotLike(String value) {
			addCriterion("number not like", value, "number");
			return (Criteria) this;
		}

		public Criteria andNumberIn(List<String> values) {
			addCriterion("number in", values, "number");
			return (Criteria) this;
		}

		public Criteria andNumberNotIn(List<String> values) {
			addCriterion("number not in", values, "number");
			return (Criteria) this;
		}

		public Criteria andNumberBetween(String value1, String value2) {
			addCriterion("number between", value1, value2, "number");
			return (Criteria) this;
		}

		public Criteria andNumberNotBetween(String value1, String value2) {
			addCriterion("number not between", value1, value2, "number");
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