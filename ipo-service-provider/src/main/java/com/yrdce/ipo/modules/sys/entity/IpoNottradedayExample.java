package com.yrdce.ipo.modules.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IpoNottradedayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpoNottradedayExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("WEEK is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("WEEK =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("WEEK <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("WEEK >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("WEEK >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("WEEK <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("WEEK <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("WEEK like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("WEEK not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("WEEK in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("WEEK not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("WEEK between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("WEEK not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("DAY is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("DAY is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(String value) {
            addCriterion("DAY =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(String value) {
            addCriterion("DAY <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(String value) {
            addCriterion("DAY >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(String value) {
            addCriterion("DAY >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(String value) {
            addCriterion("DAY <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(String value) {
            addCriterion("DAY <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLike(String value) {
            addCriterion("DAY like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotLike(String value) {
            addCriterion("DAY not like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<String> values) {
            addCriterion("DAY in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<String> values) {
            addCriterion("DAY not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(String value1, String value2) {
            addCriterion("DAY between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(String value1, String value2) {
            addCriterion("DAY not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("MODIFYTIME is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("MODIFYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYTIME =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYTIME <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("MODIFYTIME >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYTIME >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("MODIFYTIME <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYTIME <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYTIME in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYTIME not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYTIME between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYTIME not between", value1, value2, "modifytime");
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