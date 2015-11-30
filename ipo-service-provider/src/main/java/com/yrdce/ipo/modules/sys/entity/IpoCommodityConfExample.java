package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IpoCommodityConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpoCommodityConfExample() {
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

        public Criteria andCommodityidIsNull() {
            addCriterion("COMMODITYID is null");
            return (Criteria) this;
        }

        public Criteria andCommodityidIsNotNull() {
            addCriterion("COMMODITYID is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityidEqualTo(String value) {
            addCriterion("COMMODITYID =", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotEqualTo(String value) {
            addCriterion("COMMODITYID <>", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThan(String value) {
            addCriterion("COMMODITYID >", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITYID >=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThan(String value) {
            addCriterion("COMMODITYID <", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThanOrEqualTo(String value) {
            addCriterion("COMMODITYID <=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLike(String value) {
            addCriterion("COMMODITYID like", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotLike(String value) {
            addCriterion("COMMODITYID not like", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidIn(List<String> values) {
            addCriterion("COMMODITYID in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotIn(List<String> values) {
            addCriterion("COMMODITYID not in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidBetween(String value1, String value2) {
            addCriterion("COMMODITYID between", value1, value2, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotBetween(String value1, String value2) {
            addCriterion("COMMODITYID not between", value1, value2, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIsNull() {
            addCriterion("COMMODITYNAME is null");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIsNotNull() {
            addCriterion("COMMODITYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditynameEqualTo(String value) {
            addCriterion("COMMODITYNAME =", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotEqualTo(String value) {
            addCriterion("COMMODITYNAME <>", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameGreaterThan(String value) {
            addCriterion("COMMODITYNAME >", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITYNAME >=", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLessThan(String value) {
            addCriterion("COMMODITYNAME <", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLessThanOrEqualTo(String value) {
            addCriterion("COMMODITYNAME <=", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLike(String value) {
            addCriterion("COMMODITYNAME like", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotLike(String value) {
            addCriterion("COMMODITYNAME not like", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIn(List<String> values) {
            addCriterion("COMMODITYNAME in", values, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotIn(List<String> values) {
            addCriterion("COMMODITYNAME not in", values, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameBetween(String value1, String value2) {
            addCriterion("COMMODITYNAME between", value1, value2, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotBetween(String value1, String value2) {
            addCriterion("COMMODITYNAME not between", value1, value2, "commodityname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNull() {
            addCriterion("UNITS is null");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNotNull() {
            addCriterion("UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsEqualTo(BigDecimal value) {
            addCriterion("UNITS =", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotEqualTo(BigDecimal value) {
            addCriterion("UNITS <>", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThan(BigDecimal value) {
            addCriterion("UNITS >", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNITS >=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThan(BigDecimal value) {
            addCriterion("UNITS <", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNITS <=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsIn(List<BigDecimal> values) {
            addCriterion("UNITS in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotIn(List<BigDecimal> values) {
            addCriterion("UNITS not in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNITS between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNITS not between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andCountsIsNull() {
            addCriterion("COUNTS is null");
            return (Criteria) this;
        }

        public Criteria andCountsIsNotNull() {
            addCriterion("COUNTS is not null");
            return (Criteria) this;
        }

        public Criteria andCountsEqualTo(BigDecimal value) {
            addCriterion("COUNTS =", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotEqualTo(BigDecimal value) {
            addCriterion("COUNTS <>", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThan(BigDecimal value) {
            addCriterion("COUNTS >", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNTS >=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThan(BigDecimal value) {
            addCriterion("COUNTS <", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COUNTS <=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsIn(List<BigDecimal> values) {
            addCriterion("COUNTS in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotIn(List<BigDecimal> values) {
            addCriterion("COUNTS not in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNTS between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COUNTS not between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumIsNull() {
            addCriterion("MAXAPPLYNUM is null");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumIsNotNull() {
            addCriterion("MAXAPPLYNUM is not null");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumEqualTo(BigDecimal value) {
            addCriterion("MAXAPPLYNUM =", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumNotEqualTo(BigDecimal value) {
            addCriterion("MAXAPPLYNUM <>", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumGreaterThan(BigDecimal value) {
            addCriterion("MAXAPPLYNUM >", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXAPPLYNUM >=", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumLessThan(BigDecimal value) {
            addCriterion("MAXAPPLYNUM <", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXAPPLYNUM <=", value, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumIn(List<BigDecimal> values) {
            addCriterion("MAXAPPLYNUM in", values, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumNotIn(List<BigDecimal> values) {
            addCriterion("MAXAPPLYNUM not in", values, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXAPPLYNUM between", value1, value2, "maxapplynum");
            return (Criteria) this;
        }

        public Criteria andMaxapplynumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXAPPLYNUM not between", value1, value2, "maxapplynum");
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

        public Criteria andStatusEqualTo(BigDecimal value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BigDecimal value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BigDecimal value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BigDecimal value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BigDecimal> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BigDecimal> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
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

        public Criteria andTradedaysIsNull() {
            addCriterion("TRADEDAYS is null");
            return (Criteria) this;
        }

        public Criteria andTradedaysIsNotNull() {
            addCriterion("TRADEDAYS is not null");
            return (Criteria) this;
        }

        public Criteria andTradedaysEqualTo(Integer value) {
            addCriterion("TRADEDAYS =", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysNotEqualTo(Integer value) {
            addCriterion("TRADEDAYS <>", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysGreaterThan(Integer value) {
            addCriterion("TRADEDAYS >", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADEDAYS >=", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysLessThan(Integer value) {
            addCriterion("TRADEDAYS <", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysLessThanOrEqualTo(Integer value) {
            addCriterion("TRADEDAYS <=", value, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysIn(List<Integer> values) {
            addCriterion("TRADEDAYS in", values, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysNotIn(List<Integer> values) {
            addCriterion("TRADEDAYS not in", values, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysBetween(Integer value1, Integer value2) {
            addCriterion("TRADEDAYS between", value1, value2, "tradedays");
            return (Criteria) this;
        }

        public Criteria andTradedaysNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADEDAYS not between", value1, value2, "tradedays");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryIsNull() {
            addCriterion("CODEDELIVERY is null");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryIsNotNull() {
            addCriterion("CODEDELIVERY is not null");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryEqualTo(BigDecimal value) {
            addCriterion("CODEDELIVERY =", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryNotEqualTo(BigDecimal value) {
            addCriterion("CODEDELIVERY <>", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryGreaterThan(BigDecimal value) {
            addCriterion("CODEDELIVERY >", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CODEDELIVERY >=", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryLessThan(BigDecimal value) {
            addCriterion("CODEDELIVERY <", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CODEDELIVERY <=", value, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryIn(List<BigDecimal> values) {
            addCriterion("CODEDELIVERY in", values, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryNotIn(List<BigDecimal> values) {
            addCriterion("CODEDELIVERY not in", values, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CODEDELIVERY between", value1, value2, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andCodedeliveryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CODEDELIVERY not between", value1, value2, "codedelivery");
            return (Criteria) this;
        }

        public Criteria andNonissueregIsNull() {
            addCriterion("NONISSUEREG is null");
            return (Criteria) this;
        }

        public Criteria andNonissueregIsNotNull() {
            addCriterion("NONISSUEREG is not null");
            return (Criteria) this;
        }

        public Criteria andNonissueregEqualTo(BigDecimal value) {
            addCriterion("NONISSUEREG =", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregNotEqualTo(BigDecimal value) {
            addCriterion("NONISSUEREG <>", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregGreaterThan(BigDecimal value) {
            addCriterion("NONISSUEREG >", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NONISSUEREG >=", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregLessThan(BigDecimal value) {
            addCriterion("NONISSUEREG <", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NONISSUEREG <=", value, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregIn(List<BigDecimal> values) {
            addCriterion("NONISSUEREG in", values, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregNotIn(List<BigDecimal> values) {
            addCriterion("NONISSUEREG not in", values, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NONISSUEREG between", value1, value2, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andNonissueregNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NONISSUEREG not between", value1, value2, "nonissuereg");
            return (Criteria) this;
        }

        public Criteria andPubmemberidIsNull() {
            addCriterion("PUBMEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andPubmemberidIsNotNull() {
            addCriterion("PUBMEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andPubmemberidEqualTo(String value) {
            addCriterion("PUBMEMBERID =", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidNotEqualTo(String value) {
            addCriterion("PUBMEMBERID <>", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidGreaterThan(String value) {
            addCriterion("PUBMEMBERID >", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidGreaterThanOrEqualTo(String value) {
            addCriterion("PUBMEMBERID >=", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidLessThan(String value) {
            addCriterion("PUBMEMBERID <", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidLessThanOrEqualTo(String value) {
            addCriterion("PUBMEMBERID <=", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidLike(String value) {
            addCriterion("PUBMEMBERID like", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidNotLike(String value) {
            addCriterion("PUBMEMBERID not like", value, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidIn(List<String> values) {
            addCriterion("PUBMEMBERID in", values, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidNotIn(List<String> values) {
            addCriterion("PUBMEMBERID not in", values, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidBetween(String value1, String value2) {
            addCriterion("PUBMEMBERID between", value1, value2, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andPubmemberidNotBetween(String value1, String value2) {
            addCriterion("PUBMEMBERID not between", value1, value2, "pubmemberid");
            return (Criteria) this;
        }

        public Criteria andMinapplynumIsNull() {
            addCriterion("MINAPPLYNUM is null");
            return (Criteria) this;
        }

        public Criteria andMinapplynumIsNotNull() {
            addCriterion("MINAPPLYNUM is not null");
            return (Criteria) this;
        }

        public Criteria andMinapplynumEqualTo(Long value) {
            addCriterion("MINAPPLYNUM =", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumNotEqualTo(Long value) {
            addCriterion("MINAPPLYNUM <>", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumGreaterThan(Long value) {
            addCriterion("MINAPPLYNUM >", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumGreaterThanOrEqualTo(Long value) {
            addCriterion("MINAPPLYNUM >=", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumLessThan(Long value) {
            addCriterion("MINAPPLYNUM <", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumLessThanOrEqualTo(Long value) {
            addCriterion("MINAPPLYNUM <=", value, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumIn(List<Long> values) {
            addCriterion("MINAPPLYNUM in", values, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumNotIn(List<Long> values) {
            addCriterion("MINAPPLYNUM not in", values, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumBetween(Long value1, Long value2) {
            addCriterion("MINAPPLYNUM between", value1, value2, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplynumNotBetween(Long value1, Long value2) {
            addCriterion("MINAPPLYNUM not between", value1, value2, "minapplynum");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveIsNull() {
            addCriterion("MINAPPLYQUAMOVE is null");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveIsNotNull() {
            addCriterion("MINAPPLYQUAMOVE is not null");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveEqualTo(Integer value) {
            addCriterion("MINAPPLYQUAMOVE =", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveNotEqualTo(Integer value) {
            addCriterion("MINAPPLYQUAMOVE <>", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveGreaterThan(Integer value) {
            addCriterion("MINAPPLYQUAMOVE >", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveGreaterThanOrEqualTo(Integer value) {
            addCriterion("MINAPPLYQUAMOVE >=", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveLessThan(Integer value) {
            addCriterion("MINAPPLYQUAMOVE <", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveLessThanOrEqualTo(Integer value) {
            addCriterion("MINAPPLYQUAMOVE <=", value, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveIn(List<Integer> values) {
            addCriterion("MINAPPLYQUAMOVE in", values, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveNotIn(List<Integer> values) {
            addCriterion("MINAPPLYQUAMOVE not in", values, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveBetween(Integer value1, Integer value2) {
            addCriterion("MINAPPLYQUAMOVE between", value1, value2, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andMinapplyquamoveNotBetween(Integer value1, Integer value2) {
            addCriterion("MINAPPLYQUAMOVE not between", value1, value2, "minapplyquamove");
            return (Criteria) this;
        }

        public Criteria andPublishalgrIsNull() {
            addCriterion("PUBLISHALGR is null");
            return (Criteria) this;
        }

        public Criteria andPublishalgrIsNotNull() {
            addCriterion("PUBLISHALGR is not null");
            return (Criteria) this;
        }

        public Criteria andPublishalgrEqualTo(Short value) {
            addCriterion("PUBLISHALGR =", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrNotEqualTo(Short value) {
            addCriterion("PUBLISHALGR <>", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrGreaterThan(Short value) {
            addCriterion("PUBLISHALGR >", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrGreaterThanOrEqualTo(Short value) {
            addCriterion("PUBLISHALGR >=", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrLessThan(Short value) {
            addCriterion("PUBLISHALGR <", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrLessThanOrEqualTo(Short value) {
            addCriterion("PUBLISHALGR <=", value, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrIn(List<Short> values) {
            addCriterion("PUBLISHALGR in", values, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrNotIn(List<Short> values) {
            addCriterion("PUBLISHALGR not in", values, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrBetween(Short value1, Short value2) {
            addCriterion("PUBLISHALGR between", value1, value2, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andPublishalgrNotBetween(Short value1, Short value2) {
            addCriterion("PUBLISHALGR not between", value1, value2, "publishalgr");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioIsNull() {
            addCriterion("DEALERPUBCHARATIO is null");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioIsNotNull() {
            addCriterion("DEALERPUBCHARATIO is not null");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioEqualTo(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO =", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioNotEqualTo(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO <>", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioGreaterThan(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO >", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO >=", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioLessThan(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO <", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEALERPUBCHARATIO <=", value, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioIn(List<BigDecimal> values) {
            addCriterion("DEALERPUBCHARATIO in", values, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioNotIn(List<BigDecimal> values) {
            addCriterion("DEALERPUBCHARATIO not in", values, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEALERPUBCHARATIO between", value1, value2, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andDealerpubcharatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEALERPUBCHARATIO not between", value1, value2, "dealerpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioIsNull() {
            addCriterion("MKTDEAPUBCHARATIO is null");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioIsNotNull() {
            addCriterion("MKTDEAPUBCHARATIO is not null");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioEqualTo(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO =", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioNotEqualTo(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO <>", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioGreaterThan(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO >", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO >=", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioLessThan(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO <", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MKTDEAPUBCHARATIO <=", value, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioIn(List<BigDecimal> values) {
            addCriterion("MKTDEAPUBCHARATIO in", values, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioNotIn(List<BigDecimal> values) {
            addCriterion("MKTDEAPUBCHARATIO not in", values, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MKTDEAPUBCHARATIO between", value1, value2, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktdeapubcharatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MKTDEAPUBCHARATIO not between", value1, value2, "mktdeapubcharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioIsNull() {
            addCriterion("PUBLISHERCHARATIO is null");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioIsNotNull() {
            addCriterion("PUBLISHERCHARATIO is not null");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioEqualTo(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO =", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioNotEqualTo(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO <>", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioGreaterThan(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO >", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO >=", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioLessThan(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO <", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PUBLISHERCHARATIO <=", value, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioIn(List<BigDecimal> values) {
            addCriterion("PUBLISHERCHARATIO in", values, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioNotIn(List<BigDecimal> values) {
            addCriterion("PUBLISHERCHARATIO not in", values, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PUBLISHERCHARATIO between", value1, value2, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andPublishercharatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PUBLISHERCHARATIO not between", value1, value2, "publishercharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioIsNull() {
            addCriterion("MKTPUBCHARATIO is null");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioIsNotNull() {
            addCriterion("MKTPUBCHARATIO is not null");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioEqualTo(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO =", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioNotEqualTo(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO <>", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioGreaterThan(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO >", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO >=", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioLessThan(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO <", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MKTPUBCHARATIO <=", value, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioIn(List<BigDecimal> values) {
            addCriterion("MKTPUBCHARATIO in", values, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioNotIn(List<BigDecimal> values) {
            addCriterion("MKTPUBCHARATIO not in", values, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MKTPUBCHARATIO between", value1, value2, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andMktpubcharatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MKTPUBCHARATIO not between", value1, value2, "mktpubcharatio");
            return (Criteria) this;
        }

        public Criteria andCurrstatusIsNull() {
            addCriterion("CURRSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andCurrstatusIsNotNull() {
            addCriterion("CURRSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrstatusEqualTo(Short value) {
            addCriterion("CURRSTATUS =", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusNotEqualTo(Short value) {
            addCriterion("CURRSTATUS <>", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusGreaterThan(Short value) {
            addCriterion("CURRSTATUS >", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("CURRSTATUS >=", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusLessThan(Short value) {
            addCriterion("CURRSTATUS <", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusLessThanOrEqualTo(Short value) {
            addCriterion("CURRSTATUS <=", value, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusIn(List<Short> values) {
            addCriterion("CURRSTATUS in", values, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusNotIn(List<Short> values) {
            addCriterion("CURRSTATUS not in", values, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusBetween(Short value1, Short value2) {
            addCriterion("CURRSTATUS between", value1, value2, "currstatus");
            return (Criteria) this;
        }

        public Criteria andCurrstatusNotBetween(Short value1, Short value2) {
            addCriterion("CURRSTATUS not between", value1, value2, "currstatus");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceIsNull() {
            addCriterion("SUPERVISEDPRICE is null");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceIsNotNull() {
            addCriterion("SUPERVISEDPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceEqualTo(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE =", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceNotEqualTo(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE <>", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceGreaterThan(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE >", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE >=", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceLessThan(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE <", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPERVISEDPRICE <=", value, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceIn(List<BigDecimal> values) {
            addCriterion("SUPERVISEDPRICE in", values, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceNotIn(List<BigDecimal> values) {
            addCriterion("SUPERVISEDPRICE not in", values, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPERVISEDPRICE between", value1, value2, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andSupervisedpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPERVISEDPRICE not between", value1, value2, "supervisedprice");
            return (Criteria) this;
        }

        public Criteria andListingdateIsNull() {
            addCriterion("LISTINGDATE is null");
            return (Criteria) this;
        }

        public Criteria andListingdateIsNotNull() {
            addCriterion("LISTINGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andListingdateEqualTo(Date value) {
            addCriterionForJDBCDate("LISTINGDATE =", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LISTINGDATE <>", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateGreaterThan(Date value) {
            addCriterionForJDBCDate("LISTINGDATE >", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LISTINGDATE >=", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateLessThan(Date value) {
            addCriterionForJDBCDate("LISTINGDATE <", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LISTINGDATE <=", value, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateIn(List<Date> values) {
            addCriterionForJDBCDate("LISTINGDATE in", values, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LISTINGDATE not in", values, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LISTINGDATE between", value1, value2, "listingdate");
            return (Criteria) this;
        }

        public Criteria andListingdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LISTINGDATE not between", value1, value2, "listingdate");
            return (Criteria) this;
        }

        public Criteria andLasttradateIsNull() {
            addCriterion("LASTTRADATE is null");
            return (Criteria) this;
        }

        public Criteria andLasttradateIsNotNull() {
            addCriterion("LASTTRADATE is not null");
            return (Criteria) this;
        }

        public Criteria andLasttradateEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTRADATE =", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTRADATE <>", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateGreaterThan(Date value) {
            addCriterionForJDBCDate("LASTTRADATE >", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTRADATE >=", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateLessThan(Date value) {
            addCriterionForJDBCDate("LASTTRADATE <", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTRADATE <=", value, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateIn(List<Date> values) {
            addCriterionForJDBCDate("LASTTRADATE in", values, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LASTTRADATE not in", values, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LASTTRADATE between", value1, value2, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andLasttradateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LASTTRADATE not between", value1, value2, "lasttradate");
            return (Criteria) this;
        }

        public Criteria andContractfactorIsNull() {
            addCriterion("CONTRACTFACTOR is null");
            return (Criteria) this;
        }

        public Criteria andContractfactorIsNotNull() {
            addCriterion("CONTRACTFACTOR is not null");
            return (Criteria) this;
        }

        public Criteria andContractfactorEqualTo(BigDecimal value) {
            addCriterion("CONTRACTFACTOR =", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorNotEqualTo(BigDecimal value) {
            addCriterion("CONTRACTFACTOR <>", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorGreaterThan(BigDecimal value) {
            addCriterion("CONTRACTFACTOR >", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACTFACTOR >=", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorLessThan(BigDecimal value) {
            addCriterion("CONTRACTFACTOR <", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACTFACTOR <=", value, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorIn(List<BigDecimal> values) {
            addCriterion("CONTRACTFACTOR in", values, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorNotIn(List<BigDecimal> values) {
            addCriterion("CONTRACTFACTOR not in", values, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACTFACTOR between", value1, value2, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andContractfactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACTFACTOR not between", value1, value2, "contractfactor");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveIsNull() {
            addCriterion("MINPRICEMOVE is null");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveIsNotNull() {
            addCriterion("MINPRICEMOVE is not null");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveEqualTo(BigDecimal value) {
            addCriterion("MINPRICEMOVE =", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveNotEqualTo(BigDecimal value) {
            addCriterion("MINPRICEMOVE <>", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveGreaterThan(BigDecimal value) {
            addCriterion("MINPRICEMOVE >", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MINPRICEMOVE >=", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveLessThan(BigDecimal value) {
            addCriterion("MINPRICEMOVE <", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MINPRICEMOVE <=", value, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveIn(List<BigDecimal> values) {
            addCriterion("MINPRICEMOVE in", values, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveNotIn(List<BigDecimal> values) {
            addCriterion("MINPRICEMOVE not in", values, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINPRICEMOVE between", value1, value2, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinpricemoveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MINPRICEMOVE not between", value1, value2, "minpricemove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveIsNull() {
            addCriterion("MINQUANTITYMOVE is null");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveIsNotNull() {
            addCriterion("MINQUANTITYMOVE is not null");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveEqualTo(Integer value) {
            addCriterion("MINQUANTITYMOVE =", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotEqualTo(Integer value) {
            addCriterion("MINQUANTITYMOVE <>", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveGreaterThan(Integer value) {
            addCriterion("MINQUANTITYMOVE >", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveGreaterThanOrEqualTo(Integer value) {
            addCriterion("MINQUANTITYMOVE >=", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveLessThan(Integer value) {
            addCriterion("MINQUANTITYMOVE <", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveLessThanOrEqualTo(Integer value) {
            addCriterion("MINQUANTITYMOVE <=", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveIn(List<Integer> values) {
            addCriterion("MINQUANTITYMOVE in", values, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotIn(List<Integer> values) {
            addCriterion("MINQUANTITYMOVE not in", values, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveBetween(Integer value1, Integer value2) {
            addCriterion("MINQUANTITYMOVE between", value1, value2, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotBetween(Integer value1, Integer value2) {
            addCriterion("MINQUANTITYMOVE not between", value1, value2, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrIsNull() {
            addCriterion("SPREADALGR is null");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrIsNotNull() {
            addCriterion("SPREADALGR is not null");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrEqualTo(Short value) {
            addCriterion("SPREADALGR =", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrNotEqualTo(Short value) {
            addCriterion("SPREADALGR <>", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrGreaterThan(Short value) {
            addCriterion("SPREADALGR >", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrGreaterThanOrEqualTo(Short value) {
            addCriterion("SPREADALGR >=", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrLessThan(Short value) {
            addCriterion("SPREADALGR <", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrLessThanOrEqualTo(Short value) {
            addCriterion("SPREADALGR <=", value, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrIn(List<Short> values) {
            addCriterion("SPREADALGR in", values, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrNotIn(List<Short> values) {
            addCriterion("SPREADALGR not in", values, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrBetween(Short value1, Short value2) {
            addCriterion("SPREADALGR between", value1, value2, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreadalgrNotBetween(Short value1, Short value2) {
            addCriterion("SPREADALGR not between", value1, value2, "spreadalgr");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtIsNull() {
            addCriterion("SPREADUPLMT is null");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtIsNotNull() {
            addCriterion("SPREADUPLMT is not null");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtEqualTo(BigDecimal value) {
            addCriterion("SPREADUPLMT =", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtNotEqualTo(BigDecimal value) {
            addCriterion("SPREADUPLMT <>", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtGreaterThan(BigDecimal value) {
            addCriterion("SPREADUPLMT >", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPREADUPLMT >=", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtLessThan(BigDecimal value) {
            addCriterion("SPREADUPLMT <", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPREADUPLMT <=", value, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtIn(List<BigDecimal> values) {
            addCriterion("SPREADUPLMT in", values, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtNotIn(List<BigDecimal> values) {
            addCriterion("SPREADUPLMT not in", values, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPREADUPLMT between", value1, value2, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaduplmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPREADUPLMT not between", value1, value2, "spreaduplmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtIsNull() {
            addCriterion("SPREADDOWNLMT is null");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtIsNotNull() {
            addCriterion("SPREADDOWNLMT is not null");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtEqualTo(BigDecimal value) {
            addCriterion("SPREADDOWNLMT =", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtNotEqualTo(BigDecimal value) {
            addCriterion("SPREADDOWNLMT <>", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtGreaterThan(BigDecimal value) {
            addCriterion("SPREADDOWNLMT >", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPREADDOWNLMT >=", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtLessThan(BigDecimal value) {
            addCriterion("SPREADDOWNLMT <", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPREADDOWNLMT <=", value, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtIn(List<BigDecimal> values) {
            addCriterion("SPREADDOWNLMT in", values, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtNotIn(List<BigDecimal> values) {
            addCriterion("SPREADDOWNLMT not in", values, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPREADDOWNLMT between", value1, value2, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andSpreaddownlmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPREADDOWNLMT not between", value1, value2, "spreaddownlmt");
            return (Criteria) this;
        }

        public Criteria andContractfactornameIsNull() {
            addCriterion("CONTRACTFACTORNAME is null");
            return (Criteria) this;
        }

        public Criteria andContractfactornameIsNotNull() {
            addCriterion("CONTRACTFACTORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractfactornameEqualTo(String value) {
            addCriterion("CONTRACTFACTORNAME =", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameNotEqualTo(String value) {
            addCriterion("CONTRACTFACTORNAME <>", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameGreaterThan(String value) {
            addCriterion("CONTRACTFACTORNAME >", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACTFACTORNAME >=", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameLessThan(String value) {
            addCriterion("CONTRACTFACTORNAME <", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACTFACTORNAME <=", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameLike(String value) {
            addCriterion("CONTRACTFACTORNAME like", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameNotLike(String value) {
            addCriterion("CONTRACTFACTORNAME not like", value, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameIn(List<String> values) {
            addCriterion("CONTRACTFACTORNAME in", values, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameNotIn(List<String> values) {
            addCriterion("CONTRACTFACTORNAME not in", values, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameBetween(String value1, String value2) {
            addCriterion("CONTRACTFACTORNAME between", value1, value2, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andContractfactornameNotBetween(String value1, String value2) {
            addCriterion("CONTRACTFACTORNAME not between", value1, value2, "contractfactorname");
            return (Criteria) this;
        }

        public Criteria andMapperidIsNull() {
            addCriterion("MAPPERID is null");
            return (Criteria) this;
        }

        public Criteria andMapperidIsNotNull() {
            addCriterion("MAPPERID is not null");
            return (Criteria) this;
        }

        public Criteria andMapperidEqualTo(String value) {
            addCriterion("MAPPERID =", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidNotEqualTo(String value) {
            addCriterion("MAPPERID <>", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidGreaterThan(String value) {
            addCriterion("MAPPERID >", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidGreaterThanOrEqualTo(String value) {
            addCriterion("MAPPERID >=", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidLessThan(String value) {
            addCriterion("MAPPERID <", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidLessThanOrEqualTo(String value) {
            addCriterion("MAPPERID <=", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidLike(String value) {
            addCriterion("MAPPERID like", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidNotLike(String value) {
            addCriterion("MAPPERID not like", value, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidIn(List<String> values) {
            addCriterion("MAPPERID in", values, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidNotIn(List<String> values) {
            addCriterion("MAPPERID not in", values, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidBetween(String value1, String value2) {
            addCriterion("MAPPERID between", value1, value2, "mapperid");
            return (Criteria) this;
        }

        public Criteria andMapperidNotBetween(String value1, String value2) {
            addCriterion("MAPPERID not between", value1, value2, "mapperid");
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