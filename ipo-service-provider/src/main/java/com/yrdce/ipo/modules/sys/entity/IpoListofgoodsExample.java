package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoListofgoodsExample extends DataEntity<IpoListofgoodsExample> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IpoListofgoodsExample() {
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

		public Criteria andCommodityidIsNull() {
			addCriterion("commodityid is null");
			return (Criteria) this;
		}

		public Criteria andCommodityidIsNotNull() {
			addCriterion("commodityid is not null");
			return (Criteria) this;
		}

		public Criteria andCommodityidEqualTo(BigDecimal value) {
			addCriterion("commodityid =", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotEqualTo(BigDecimal value) {
			addCriterion("commodityid <>", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidGreaterThan(BigDecimal value) {
			addCriterion("commodityid >", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("commodityid >=", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidLessThan(BigDecimal value) {
			addCriterion("commodityid <", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidLessThanOrEqualTo(BigDecimal value) {
			addCriterion("commodityid <=", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidIn(List<BigDecimal> values) {
			addCriterion("commodityid in", values, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotIn(List<BigDecimal> values) {
			addCriterion("commodityid not in", values, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commodityid between", value1, value2, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commodityid not between", value1, value2, "commodityid");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(BigDecimal value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(BigDecimal value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(BigDecimal value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(BigDecimal value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<BigDecimal> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<BigDecimal> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andSaleTimeIsNull() {
			addCriterion("sale_time is null");
			return (Criteria) this;
		}

		public Criteria andSaleTimeIsNotNull() {
			addCriterion("sale_time is not null");
			return (Criteria) this;
		}

		public Criteria andSaleTimeEqualTo(Date value) {
			addCriterionForJDBCDate("sale_time =", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("sale_time <>", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("sale_time >", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("sale_time >=", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeLessThan(Date value) {
			addCriterionForJDBCDate("sale_time <", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("sale_time <=", value, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeIn(List<Date> values) {
			addCriterionForJDBCDate("sale_time in", values, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("sale_time not in", values, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("sale_time between", value1, value2, "saleTime");
			return (Criteria) this;
		}

		public Criteria andSaleTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("sale_time not between", value1, value2, "saleTime");
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