package com.yrdce.ipo.modules.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BrBrokerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrBrokerExample() {
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

        public Criteria andBrokeridIsNull() {
            addCriterion("BROKERID is null");
            return (Criteria) this;
        }

        public Criteria andBrokeridIsNotNull() {
            addCriterion("BROKERID is not null");
            return (Criteria) this;
        }

        public Criteria andBrokeridEqualTo(String value) {
            addCriterion("BROKERID =", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridNotEqualTo(String value) {
            addCriterion("BROKERID <>", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridGreaterThan(String value) {
            addCriterion("BROKERID >", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridGreaterThanOrEqualTo(String value) {
            addCriterion("BROKERID >=", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridLessThan(String value) {
            addCriterion("BROKERID <", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridLessThanOrEqualTo(String value) {
            addCriterion("BROKERID <=", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridLike(String value) {
            addCriterion("BROKERID like", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridNotLike(String value) {
            addCriterion("BROKERID not like", value, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridIn(List<String> values) {
            addCriterion("BROKERID in", values, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridNotIn(List<String> values) {
            addCriterion("BROKERID not in", values, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridBetween(String value1, String value2) {
            addCriterion("BROKERID between", value1, value2, "brokerid");
            return (Criteria) this;
        }

        public Criteria andBrokeridNotBetween(String value1, String value2) {
            addCriterion("BROKERID not between", value1, value2, "brokerid");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
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

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
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

        public Criteria andAreaidIsNull() {
            addCriterion("AREAID is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("AREAID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(Short value) {
            addCriterion("AREAID =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(Short value) {
            addCriterion("AREAID <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(Short value) {
            addCriterion("AREAID >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(Short value) {
            addCriterion("AREAID >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(Short value) {
            addCriterion("AREAID <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(Short value) {
            addCriterion("AREAID <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<Short> values) {
            addCriterion("AREAID in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<Short> values) {
            addCriterion("AREAID not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(Short value1, Short value2) {
            addCriterion("AREAID between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(Short value1, Short value2) {
            addCriterion("AREAID not between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNull() {
            addCriterion("MEMBERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNotNull() {
            addCriterion("MEMBERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMembertypeEqualTo(Short value) {
            addCriterion("MEMBERTYPE =", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotEqualTo(Short value) {
            addCriterion("MEMBERTYPE <>", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThan(Short value) {
            addCriterion("MEMBERTYPE >", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("MEMBERTYPE >=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThan(Short value) {
            addCriterion("MEMBERTYPE <", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThanOrEqualTo(Short value) {
            addCriterion("MEMBERTYPE <=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeIn(List<Short> values) {
            addCriterion("MEMBERTYPE in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotIn(List<Short> values) {
            addCriterion("MEMBERTYPE not in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeBetween(Short value1, Short value2) {
            addCriterion("MEMBERTYPE between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotBetween(Short value1, Short value2) {
            addCriterion("MEMBERTYPE not between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("TIMELIMIT is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("TIMELIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(Date value) {
            addCriterionForJDBCDate("TIMELIMIT =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(Date value) {
            addCriterionForJDBCDate("TIMELIMIT <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(Date value) {
            addCriterionForJDBCDate("TIMELIMIT >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIMELIMIT >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(Date value) {
            addCriterionForJDBCDate("TIMELIMIT <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIMELIMIT <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<Date> values) {
            addCriterionForJDBCDate("TIMELIMIT in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<Date> values) {
            addCriterionForJDBCDate("TIMELIMIT not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIMELIMIT between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIMELIMIT not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerIsNull() {
            addCriterion("MARKETMANAGER is null");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerIsNotNull() {
            addCriterion("MARKETMANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerEqualTo(String value) {
            addCriterion("MARKETMANAGER =", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerNotEqualTo(String value) {
            addCriterion("MARKETMANAGER <>", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerGreaterThan(String value) {
            addCriterion("MARKETMANAGER >", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerGreaterThanOrEqualTo(String value) {
            addCriterion("MARKETMANAGER >=", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerLessThan(String value) {
            addCriterion("MARKETMANAGER <", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerLessThanOrEqualTo(String value) {
            addCriterion("MARKETMANAGER <=", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerLike(String value) {
            addCriterion("MARKETMANAGER like", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerNotLike(String value) {
            addCriterion("MARKETMANAGER not like", value, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerIn(List<String> values) {
            addCriterion("MARKETMANAGER in", values, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerNotIn(List<String> values) {
            addCriterion("MARKETMANAGER not in", values, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerBetween(String value1, String value2) {
            addCriterion("MARKETMANAGER between", value1, value2, "marketmanager");
            return (Criteria) this;
        }

        public Criteria andMarketmanagerNotBetween(String value1, String value2) {
            addCriterion("MARKETMANAGER not between", value1, value2, "marketmanager");
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