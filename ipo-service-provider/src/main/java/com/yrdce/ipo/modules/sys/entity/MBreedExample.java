package com.yrdce.ipo.modules.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class MBreedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MBreedExample() {
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

        public Criteria andBreedidIsNull() {
            addCriterion("BREEDID is null");
            return (Criteria) this;
        }

        public Criteria andBreedidIsNotNull() {
            addCriterion("BREEDID is not null");
            return (Criteria) this;
        }

        public Criteria andBreedidEqualTo(Long value) {
            addCriterion("BREEDID =", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotEqualTo(Long value) {
            addCriterion("BREEDID <>", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidGreaterThan(Long value) {
            addCriterion("BREEDID >", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidGreaterThanOrEqualTo(Long value) {
            addCriterion("BREEDID >=", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidLessThan(Long value) {
            addCriterion("BREEDID <", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidLessThanOrEqualTo(Long value) {
            addCriterion("BREEDID <=", value, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidIn(List<Long> values) {
            addCriterion("BREEDID in", values, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotIn(List<Long> values) {
            addCriterion("BREEDID not in", values, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidBetween(Long value1, Long value2) {
            addCriterion("BREEDID between", value1, value2, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreedidNotBetween(Long value1, Long value2) {
            addCriterion("BREEDID not between", value1, value2, "breedid");
            return (Criteria) this;
        }

        public Criteria andBreednameIsNull() {
            addCriterion("BREEDNAME is null");
            return (Criteria) this;
        }

        public Criteria andBreednameIsNotNull() {
            addCriterion("BREEDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andBreednameEqualTo(String value) {
            addCriterion("BREEDNAME =", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameNotEqualTo(String value) {
            addCriterion("BREEDNAME <>", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameGreaterThan(String value) {
            addCriterion("BREEDNAME >", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameGreaterThanOrEqualTo(String value) {
            addCriterion("BREEDNAME >=", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameLessThan(String value) {
            addCriterion("BREEDNAME <", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameLessThanOrEqualTo(String value) {
            addCriterion("BREEDNAME <=", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameLike(String value) {
            addCriterion("BREEDNAME like", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameNotLike(String value) {
            addCriterion("BREEDNAME not like", value, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameIn(List<String> values) {
            addCriterion("BREEDNAME in", values, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameNotIn(List<String> values) {
            addCriterion("BREEDNAME not in", values, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameBetween(String value1, String value2) {
            addCriterion("BREEDNAME between", value1, value2, "breedname");
            return (Criteria) this;
        }

        public Criteria andBreednameNotBetween(String value1, String value2) {
            addCriterion("BREEDNAME not between", value1, value2, "breedname");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andTrademodeIsNull() {
            addCriterion("TRADEMODE is null");
            return (Criteria) this;
        }

        public Criteria andTrademodeIsNotNull() {
            addCriterion("TRADEMODE is not null");
            return (Criteria) this;
        }

        public Criteria andTrademodeEqualTo(Short value) {
            addCriterion("TRADEMODE =", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeNotEqualTo(Short value) {
            addCriterion("TRADEMODE <>", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeGreaterThan(Short value) {
            addCriterion("TRADEMODE >", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeGreaterThanOrEqualTo(Short value) {
            addCriterion("TRADEMODE >=", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeLessThan(Short value) {
            addCriterion("TRADEMODE <", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeLessThanOrEqualTo(Short value) {
            addCriterion("TRADEMODE <=", value, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeIn(List<Short> values) {
            addCriterion("TRADEMODE in", values, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeNotIn(List<Short> values) {
            addCriterion("TRADEMODE not in", values, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeBetween(Short value1, Short value2) {
            addCriterion("TRADEMODE between", value1, value2, "trademode");
            return (Criteria) this;
        }

        public Criteria andTrademodeNotBetween(Short value1, Short value2) {
            addCriterion("TRADEMODE not between", value1, value2, "trademode");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("CATEGORYID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("CATEGORYID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Long value) {
            addCriterion("CATEGORYID =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Long value) {
            addCriterion("CATEGORYID <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Long value) {
            addCriterion("CATEGORYID >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Long value) {
            addCriterion("CATEGORYID >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Long value) {
            addCriterion("CATEGORYID <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Long value) {
            addCriterion("CATEGORYID <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Long> values) {
            addCriterion("CATEGORYID in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Long> values) {
            addCriterion("CATEGORYID not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Long value1, Long value2) {
            addCriterion("CATEGORYID between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Long value1, Long value2) {
            addCriterion("CATEGORYID not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleIsNull() {
            addCriterion("BELONGMODULE is null");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleIsNotNull() {
            addCriterion("BELONGMODULE is not null");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleEqualTo(String value) {
            addCriterion("BELONGMODULE =", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleNotEqualTo(String value) {
            addCriterion("BELONGMODULE <>", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleGreaterThan(String value) {
            addCriterion("BELONGMODULE >", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleGreaterThanOrEqualTo(String value) {
            addCriterion("BELONGMODULE >=", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleLessThan(String value) {
            addCriterion("BELONGMODULE <", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleLessThanOrEqualTo(String value) {
            addCriterion("BELONGMODULE <=", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleLike(String value) {
            addCriterion("BELONGMODULE like", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleNotLike(String value) {
            addCriterion("BELONGMODULE not like", value, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleIn(List<String> values) {
            addCriterion("BELONGMODULE in", values, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleNotIn(List<String> values) {
            addCriterion("BELONGMODULE not in", values, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleBetween(String value1, String value2) {
            addCriterion("BELONGMODULE between", value1, value2, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andBelongmoduleNotBetween(String value1, String value2) {
            addCriterion("BELONGMODULE not between", value1, value2, "belongmodule");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNull() {
            addCriterion("SORTNO is null");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNotNull() {
            addCriterion("SORTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSortnoEqualTo(Long value) {
            addCriterion("SORTNO =", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotEqualTo(Long value) {
            addCriterion("SORTNO <>", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThan(Long value) {
            addCriterion("SORTNO >", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThanOrEqualTo(Long value) {
            addCriterion("SORTNO >=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThan(Long value) {
            addCriterion("SORTNO <", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThanOrEqualTo(Long value) {
            addCriterion("SORTNO <=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoIn(List<Long> values) {
            addCriterion("SORTNO in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotIn(List<Long> values) {
            addCriterion("SORTNO not in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoBetween(Long value1, Long value2) {
            addCriterion("SORTNO between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotBetween(Long value1, Long value2) {
            addCriterion("SORTNO not between", value1, value2, "sortno");
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