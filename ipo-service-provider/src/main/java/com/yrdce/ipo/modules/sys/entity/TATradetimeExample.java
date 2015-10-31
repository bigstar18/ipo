package com.yrdce.ipo.modules.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TATradetimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TATradetimeExample() {
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

        public Criteria andSectionidIsNull() {
            addCriterion("SECTIONID is null");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNotNull() {
            addCriterion("SECTIONID is not null");
            return (Criteria) this;
        }

        public Criteria andSectionidEqualTo(Short value) {
            addCriterion("SECTIONID =", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotEqualTo(Short value) {
            addCriterion("SECTIONID <>", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThan(Short value) {
            addCriterion("SECTIONID >", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThanOrEqualTo(Short value) {
            addCriterion("SECTIONID >=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThan(Short value) {
            addCriterion("SECTIONID <", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThanOrEqualTo(Short value) {
            addCriterion("SECTIONID <=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidIn(List<Short> values) {
            addCriterion("SECTIONID in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotIn(List<Short> values) {
            addCriterion("SECTIONID not in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidBetween(Short value1, Short value2) {
            addCriterion("SECTIONID between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotBetween(Short value1, Short value2) {
            addCriterion("SECTIONID not between", value1, value2, "sectionid");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("STARTTIME like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("STARTTIME not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("STARTTIME not between", value1, value2, "starttime");
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

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("ENDTIME like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("ENDTIME not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
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

        public Criteria andGatherbidIsNull() {
            addCriterion("GATHERBID is null");
            return (Criteria) this;
        }

        public Criteria andGatherbidIsNotNull() {
            addCriterion("GATHERBID is not null");
            return (Criteria) this;
        }

        public Criteria andGatherbidEqualTo(Short value) {
            addCriterion("GATHERBID =", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidNotEqualTo(Short value) {
            addCriterion("GATHERBID <>", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidGreaterThan(Short value) {
            addCriterion("GATHERBID >", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidGreaterThanOrEqualTo(Short value) {
            addCriterion("GATHERBID >=", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidLessThan(Short value) {
            addCriterion("GATHERBID <", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidLessThanOrEqualTo(Short value) {
            addCriterion("GATHERBID <=", value, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidIn(List<Short> values) {
            addCriterion("GATHERBID in", values, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidNotIn(List<Short> values) {
            addCriterion("GATHERBID not in", values, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidBetween(Short value1, Short value2) {
            addCriterion("GATHERBID between", value1, value2, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andGatherbidNotBetween(Short value1, Short value2) {
            addCriterion("GATHERBID not between", value1, value2, "gatherbid");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeIsNull() {
            addCriterion("BIDSTARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeIsNotNull() {
            addCriterion("BIDSTARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeEqualTo(String value) {
            addCriterion("BIDSTARTTIME =", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeNotEqualTo(String value) {
            addCriterion("BIDSTARTTIME <>", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeGreaterThan(String value) {
            addCriterion("BIDSTARTTIME >", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("BIDSTARTTIME >=", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeLessThan(String value) {
            addCriterion("BIDSTARTTIME <", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeLessThanOrEqualTo(String value) {
            addCriterion("BIDSTARTTIME <=", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeLike(String value) {
            addCriterion("BIDSTARTTIME like", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeNotLike(String value) {
            addCriterion("BIDSTARTTIME not like", value, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeIn(List<String> values) {
            addCriterion("BIDSTARTTIME in", values, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeNotIn(List<String> values) {
            addCriterion("BIDSTARTTIME not in", values, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeBetween(String value1, String value2) {
            addCriterion("BIDSTARTTIME between", value1, value2, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidstarttimeNotBetween(String value1, String value2) {
            addCriterion("BIDSTARTTIME not between", value1, value2, "bidstarttime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeIsNull() {
            addCriterion("BIDENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andBidendtimeIsNotNull() {
            addCriterion("BIDENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBidendtimeEqualTo(String value) {
            addCriterion("BIDENDTIME =", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeNotEqualTo(String value) {
            addCriterion("BIDENDTIME <>", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeGreaterThan(String value) {
            addCriterion("BIDENDTIME >", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("BIDENDTIME >=", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeLessThan(String value) {
            addCriterion("BIDENDTIME <", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeLessThanOrEqualTo(String value) {
            addCriterion("BIDENDTIME <=", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeLike(String value) {
            addCriterion("BIDENDTIME like", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeNotLike(String value) {
            addCriterion("BIDENDTIME not like", value, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeIn(List<String> values) {
            addCriterion("BIDENDTIME in", values, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeNotIn(List<String> values) {
            addCriterion("BIDENDTIME not in", values, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeBetween(String value1, String value2) {
            addCriterion("BIDENDTIME between", value1, value2, "bidendtime");
            return (Criteria) this;
        }

        public Criteria andBidendtimeNotBetween(String value1, String value2) {
            addCriterion("BIDENDTIME not between", value1, value2, "bidendtime");
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

        public Criteria andStartdateIsNull() {
            addCriterion("STARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("STARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(String value) {
            addCriterion("STARTDATE =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(String value) {
            addCriterion("STARTDATE <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(String value) {
            addCriterion("STARTDATE >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("STARTDATE >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(String value) {
            addCriterion("STARTDATE <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(String value) {
            addCriterion("STARTDATE <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLike(String value) {
            addCriterion("STARTDATE like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotLike(String value) {
            addCriterion("STARTDATE not like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<String> values) {
            addCriterion("STARTDATE in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<String> values) {
            addCriterion("STARTDATE not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(String value1, String value2) {
            addCriterion("STARTDATE between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(String value1, String value2) {
            addCriterion("STARTDATE not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("ENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("ENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(String value) {
            addCriterion("ENDDATE =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(String value) {
            addCriterion("ENDDATE <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(String value) {
            addCriterion("ENDDATE >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("ENDDATE >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(String value) {
            addCriterion("ENDDATE <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(String value) {
            addCriterion("ENDDATE <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLike(String value) {
            addCriterion("ENDDATE like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotLike(String value) {
            addCriterion("ENDDATE not like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<String> values) {
            addCriterion("ENDDATE in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<String> values) {
            addCriterion("ENDDATE not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(String value1, String value2) {
            addCriterion("ENDDATE between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(String value1, String value2) {
            addCriterion("ENDDATE not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateIsNull() {
            addCriterion("BIDSTARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andBidstartdateIsNotNull() {
            addCriterion("BIDSTARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBidstartdateEqualTo(String value) {
            addCriterion("BIDSTARTDATE =", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateNotEqualTo(String value) {
            addCriterion("BIDSTARTDATE <>", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateGreaterThan(String value) {
            addCriterion("BIDSTARTDATE >", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateGreaterThanOrEqualTo(String value) {
            addCriterion("BIDSTARTDATE >=", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateLessThan(String value) {
            addCriterion("BIDSTARTDATE <", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateLessThanOrEqualTo(String value) {
            addCriterion("BIDSTARTDATE <=", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateLike(String value) {
            addCriterion("BIDSTARTDATE like", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateNotLike(String value) {
            addCriterion("BIDSTARTDATE not like", value, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateIn(List<String> values) {
            addCriterion("BIDSTARTDATE in", values, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateNotIn(List<String> values) {
            addCriterion("BIDSTARTDATE not in", values, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateBetween(String value1, String value2) {
            addCriterion("BIDSTARTDATE between", value1, value2, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidstartdateNotBetween(String value1, String value2) {
            addCriterion("BIDSTARTDATE not between", value1, value2, "bidstartdate");
            return (Criteria) this;
        }

        public Criteria andBidenddateIsNull() {
            addCriterion("BIDENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andBidenddateIsNotNull() {
            addCriterion("BIDENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBidenddateEqualTo(String value) {
            addCriterion("BIDENDDATE =", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateNotEqualTo(String value) {
            addCriterion("BIDENDDATE <>", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateGreaterThan(String value) {
            addCriterion("BIDENDDATE >", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateGreaterThanOrEqualTo(String value) {
            addCriterion("BIDENDDATE >=", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateLessThan(String value) {
            addCriterion("BIDENDDATE <", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateLessThanOrEqualTo(String value) {
            addCriterion("BIDENDDATE <=", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateLike(String value) {
            addCriterion("BIDENDDATE like", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateNotLike(String value) {
            addCriterion("BIDENDDATE not like", value, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateIn(List<String> values) {
            addCriterion("BIDENDDATE in", values, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateNotIn(List<String> values) {
            addCriterion("BIDENDDATE not in", values, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateBetween(String value1, String value2) {
            addCriterion("BIDENDDATE between", value1, value2, "bidenddate");
            return (Criteria) this;
        }

        public Criteria andBidenddateNotBetween(String value1, String value2) {
            addCriterion("BIDENDDATE not between", value1, value2, "bidenddate");
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