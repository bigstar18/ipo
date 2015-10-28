package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoCommodityExample extends DataEntity<IpoCommodityExample> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IpoCommodityExample() {
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

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
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

		public Criteria andCommodityidEqualTo(String value) {
			addCriterion("commodityid =", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotEqualTo(String value) {
			addCriterion("commodityid <>", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidGreaterThan(String value) {
			addCriterion("commodityid >", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidGreaterThanOrEqualTo(String value) {
			addCriterion("commodityid >=", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidLessThan(String value) {
			addCriterion("commodityid <", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidLessThanOrEqualTo(String value) {
			addCriterion("commodityid <=", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidLike(String value) {
			addCriterion("commodityid like", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotLike(String value) {
			addCriterion("commodityid not like", value, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidIn(List<String> values) {
			addCriterion("commodityid in", values, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotIn(List<String> values) {
			addCriterion("commodityid not in", values, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidBetween(String value1, String value2) {
			addCriterion("commodityid between", value1, value2, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommodityidNotBetween(String value1, String value2) {
			addCriterion("commodityid not between", value1, value2, "commodityid");
			return (Criteria) this;
		}

		public Criteria andCommoditynameIsNull() {
			addCriterion("commodityname is null");
			return (Criteria) this;
		}

		public Criteria andCommoditynameIsNotNull() {
			addCriterion("commodityname is not null");
			return (Criteria) this;
		}

		public Criteria andCommoditynameEqualTo(String value) {
			addCriterion("commodityname =", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameNotEqualTo(String value) {
			addCriterion("commodityname <>", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameGreaterThan(String value) {
			addCriterion("commodityname >", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameGreaterThanOrEqualTo(String value) {
			addCriterion("commodityname >=", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameLessThan(String value) {
			addCriterion("commodityname <", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameLessThanOrEqualTo(String value) {
			addCriterion("commodityname <=", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameLike(String value) {
			addCriterion("commodityname like", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameNotLike(String value) {
			addCriterion("commodityname not like", value, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameIn(List<String> values) {
			addCriterion("commodityname in", values, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameNotIn(List<String> values) {
			addCriterion("commodityname not in", values, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameBetween(String value1, String value2) {
			addCriterion("commodityname between", value1, value2, "commodityname");
			return (Criteria) this;
		}

		public Criteria andCommoditynameNotBetween(String value1, String value2) {
			addCriterion("commodityname not between", value1, value2, "commodityname");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<BigDecimal> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<BigDecimal> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("unit is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("unit is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(BigDecimal value) {
			addCriterion("unit =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(BigDecimal value) {
			addCriterion("unit <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(BigDecimal value) {
			addCriterion("unit >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("unit >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(BigDecimal value) {
			addCriterion("unit <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("unit <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<BigDecimal> values) {
			addCriterion("unit in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<BigDecimal> values) {
			addCriterion("unit not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("unit between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("unit not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andCountIsNull() {
			addCriterion("count is null");
			return (Criteria) this;
		}

		public Criteria andCountIsNotNull() {
			addCriterion("count is not null");
			return (Criteria) this;
		}

		public Criteria andCountEqualTo(BigDecimal value) {
			addCriterion("count =", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotEqualTo(BigDecimal value) {
			addCriterion("count <>", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThan(BigDecimal value) {
			addCriterion("count >", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("count >=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThan(BigDecimal value) {
			addCriterion("count <", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("count <=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountIn(List<BigDecimal> values) {
			addCriterion("count in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotIn(List<BigDecimal> values) {
			addCriterion("count not in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("count between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("count not between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(Date value) {
			addCriterionForJDBCDate("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(Date value) {
			addCriterionForJDBCDate("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<Date> values) {
			addCriterionForJDBCDate("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterionForJDBCDate("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterionForJDBCDate("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterionForJDBCDate("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
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