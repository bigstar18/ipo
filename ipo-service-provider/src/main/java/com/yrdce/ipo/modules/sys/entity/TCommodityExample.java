package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCommodityExample() {
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

        public Criteria andSortidIsNull() {
            addCriterion("SORTID is null");
            return (Criteria) this;
        }

        public Criteria andSortidIsNotNull() {
            addCriterion("SORTID is not null");
            return (Criteria) this;
        }

        public Criteria andSortidEqualTo(Long value) {
            addCriterion("SORTID =", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotEqualTo(Long value) {
            addCriterion("SORTID <>", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThan(Long value) {
            addCriterion("SORTID >", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThanOrEqualTo(Long value) {
            addCriterion("SORTID >=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThan(Long value) {
            addCriterion("SORTID <", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThanOrEqualTo(Long value) {
            addCriterion("SORTID <=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidIn(List<Long> values) {
            addCriterion("SORTID in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotIn(List<Long> values) {
            addCriterion("SORTID not in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidBetween(Long value1, Long value2) {
            addCriterion("SORTID between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotBetween(Long value1, Long value2) {
            addCriterion("SORTID not between", value1, value2, "sortid");
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

        public Criteria andFeealgrIsNull() {
            addCriterion("FEEALGR is null");
            return (Criteria) this;
        }

        public Criteria andFeealgrIsNotNull() {
            addCriterion("FEEALGR is not null");
            return (Criteria) this;
        }

        public Criteria andFeealgrEqualTo(Short value) {
            addCriterion("FEEALGR =", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrNotEqualTo(Short value) {
            addCriterion("FEEALGR <>", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrGreaterThan(Short value) {
            addCriterion("FEEALGR >", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrGreaterThanOrEqualTo(Short value) {
            addCriterion("FEEALGR >=", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrLessThan(Short value) {
            addCriterion("FEEALGR <", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrLessThanOrEqualTo(Short value) {
            addCriterion("FEEALGR <=", value, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrIn(List<Short> values) {
            addCriterion("FEEALGR in", values, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrNotIn(List<Short> values) {
            addCriterion("FEEALGR not in", values, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrBetween(Short value1, Short value2) {
            addCriterion("FEEALGR between", value1, value2, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeealgrNotBetween(Short value1, Short value2) {
            addCriterion("FEEALGR not between", value1, value2, "feealgr");
            return (Criteria) this;
        }

        public Criteria andFeerateBIsNull() {
            addCriterion("FEERATE_B is null");
            return (Criteria) this;
        }

        public Criteria andFeerateBIsNotNull() {
            addCriterion("FEERATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andFeerateBEqualTo(BigDecimal value) {
            addCriterion("FEERATE_B =", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBNotEqualTo(BigDecimal value) {
            addCriterion("FEERATE_B <>", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBGreaterThan(BigDecimal value) {
            addCriterion("FEERATE_B >", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEERATE_B >=", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBLessThan(BigDecimal value) {
            addCriterion("FEERATE_B <", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEERATE_B <=", value, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBIn(List<BigDecimal> values) {
            addCriterion("FEERATE_B in", values, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBNotIn(List<BigDecimal> values) {
            addCriterion("FEERATE_B not in", values, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEERATE_B between", value1, value2, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEERATE_B not between", value1, value2, "feerateB");
            return (Criteria) this;
        }

        public Criteria andFeerateSIsNull() {
            addCriterion("FEERATE_S is null");
            return (Criteria) this;
        }

        public Criteria andFeerateSIsNotNull() {
            addCriterion("FEERATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andFeerateSEqualTo(BigDecimal value) {
            addCriterion("FEERATE_S =", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSNotEqualTo(BigDecimal value) {
            addCriterion("FEERATE_S <>", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSGreaterThan(BigDecimal value) {
            addCriterion("FEERATE_S >", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEERATE_S >=", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSLessThan(BigDecimal value) {
            addCriterion("FEERATE_S <", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEERATE_S <=", value, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSIn(List<BigDecimal> values) {
            addCriterion("FEERATE_S in", values, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSNotIn(List<BigDecimal> values) {
            addCriterion("FEERATE_S not in", values, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEERATE_S between", value1, value2, "feerateS");
            return (Criteria) this;
        }

        public Criteria andFeerateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEERATE_S not between", value1, value2, "feerateS");
            return (Criteria) this;
        }

        public Criteria andMarginalgrIsNull() {
            addCriterion("MARGINALGR is null");
            return (Criteria) this;
        }

        public Criteria andMarginalgrIsNotNull() {
            addCriterion("MARGINALGR is not null");
            return (Criteria) this;
        }

        public Criteria andMarginalgrEqualTo(Short value) {
            addCriterion("MARGINALGR =", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrNotEqualTo(Short value) {
            addCriterion("MARGINALGR <>", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrGreaterThan(Short value) {
            addCriterion("MARGINALGR >", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrGreaterThanOrEqualTo(Short value) {
            addCriterion("MARGINALGR >=", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrLessThan(Short value) {
            addCriterion("MARGINALGR <", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrLessThanOrEqualTo(Short value) {
            addCriterion("MARGINALGR <=", value, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrIn(List<Short> values) {
            addCriterion("MARGINALGR in", values, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrNotIn(List<Short> values) {
            addCriterion("MARGINALGR not in", values, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrBetween(Short value1, Short value2) {
            addCriterion("MARGINALGR between", value1, value2, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginalgrNotBetween(Short value1, Short value2) {
            addCriterion("MARGINALGR not between", value1, value2, "marginalgr");
            return (Criteria) this;
        }

        public Criteria andMarginrateBIsNull() {
            addCriterion("MARGINRATE_B is null");
            return (Criteria) this;
        }

        public Criteria andMarginrateBIsNotNull() {
            addCriterion("MARGINRATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andMarginrateBEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_B =", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBNotEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_B <>", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBGreaterThan(BigDecimal value) {
            addCriterion("MARGINRATE_B >", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_B >=", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBLessThan(BigDecimal value) {
            addCriterion("MARGINRATE_B <", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_B <=", value, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBIn(List<BigDecimal> values) {
            addCriterion("MARGINRATE_B in", values, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBNotIn(List<BigDecimal> values) {
            addCriterion("MARGINRATE_B not in", values, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINRATE_B between", value1, value2, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINRATE_B not between", value1, value2, "marginrateB");
            return (Criteria) this;
        }

        public Criteria andMarginrateSIsNull() {
            addCriterion("MARGINRATE_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginrateSIsNotNull() {
            addCriterion("MARGINRATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginrateSEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_S =", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSNotEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_S <>", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSGreaterThan(BigDecimal value) {
            addCriterion("MARGINRATE_S >", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_S >=", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSLessThan(BigDecimal value) {
            addCriterion("MARGINRATE_S <", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINRATE_S <=", value, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSIn(List<BigDecimal> values) {
            addCriterion("MARGINRATE_S in", values, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSNotIn(List<BigDecimal> values) {
            addCriterion("MARGINRATE_S not in", values, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINRATE_S between", value1, value2, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarginrateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINRATE_S not between", value1, value2, "marginrateS");
            return (Criteria) this;
        }

        public Criteria andMarketdateIsNull() {
            addCriterion("MARKETDATE is null");
            return (Criteria) this;
        }

        public Criteria andMarketdateIsNotNull() {
            addCriterion("MARKETDATE is not null");
            return (Criteria) this;
        }

        public Criteria andMarketdateEqualTo(Date value) {
            addCriterionForJDBCDate("MARKETDATE =", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("MARKETDATE <>", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateGreaterThan(Date value) {
            addCriterionForJDBCDate("MARKETDATE >", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MARKETDATE >=", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateLessThan(Date value) {
            addCriterionForJDBCDate("MARKETDATE <", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MARKETDATE <=", value, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateIn(List<Date> values) {
            addCriterionForJDBCDate("MARKETDATE in", values, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("MARKETDATE not in", values, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MARKETDATE between", value1, value2, "marketdate");
            return (Criteria) this;
        }

        public Criteria andMarketdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MARKETDATE not between", value1, value2, "marketdate");
            return (Criteria) this;
        }

        public Criteria andSettledateIsNull() {
            addCriterion("SETTLEDATE is null");
            return (Criteria) this;
        }

        public Criteria andSettledateIsNotNull() {
            addCriterion("SETTLEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andSettledateEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE =", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE <>", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateGreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE >", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE >=", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateLessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE <", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE <=", value, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE in", values, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE not in", values, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE between", value1, value2, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE not between", value1, value2, "settledate");
            return (Criteria) this;
        }

        public Criteria andSettledate1IsNull() {
            addCriterion("SETTLEDATE1 is null");
            return (Criteria) this;
        }

        public Criteria andSettledate1IsNotNull() {
            addCriterion("SETTLEDATE1 is not null");
            return (Criteria) this;
        }

        public Criteria andSettledate1EqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 =", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1NotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 <>", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1GreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 >", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 >=", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1LessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 <", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE1 <=", value, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1In(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE1 in", values, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1NotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE1 not in", values, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1Between(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE1 between", value1, value2, "settledate1");
            return (Criteria) this;
        }

        public Criteria andSettledate1NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE1 not between", value1, value2, "settledate1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1IsNull() {
            addCriterion("MARGINITEM1 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem1IsNotNull() {
            addCriterion("MARGINITEM1 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem1EqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1 =", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1 <>", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM1 >", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1 >=", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1LessThan(BigDecimal value) {
            addCriterion("MARGINITEM1 <", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1 <=", value, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1In(List<BigDecimal> values) {
            addCriterion("MARGINITEM1 in", values, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM1 not in", values, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM1 between", value1, value2, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andMarginitem1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM1 not between", value1, value2, "marginitem1");
            return (Criteria) this;
        }

        public Criteria andSettledate2IsNull() {
            addCriterion("SETTLEDATE2 is null");
            return (Criteria) this;
        }

        public Criteria andSettledate2IsNotNull() {
            addCriterion("SETTLEDATE2 is not null");
            return (Criteria) this;
        }

        public Criteria andSettledate2EqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 =", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2NotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 <>", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2GreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 >", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 >=", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2LessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 <", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE2 <=", value, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2In(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE2 in", values, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2NotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE2 not in", values, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2Between(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE2 between", value1, value2, "settledate2");
            return (Criteria) this;
        }

        public Criteria andSettledate2NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE2 not between", value1, value2, "settledate2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2IsNull() {
            addCriterion("MARGINITEM2 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem2IsNotNull() {
            addCriterion("MARGINITEM2 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem2EqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2 =", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2 <>", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM2 >", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2 >=", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2LessThan(BigDecimal value) {
            addCriterion("MARGINITEM2 <", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2 <=", value, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2In(List<BigDecimal> values) {
            addCriterion("MARGINITEM2 in", values, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM2 not in", values, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM2 between", value1, value2, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andMarginitem2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM2 not between", value1, value2, "marginitem2");
            return (Criteria) this;
        }

        public Criteria andSettledate3IsNull() {
            addCriterion("SETTLEDATE3 is null");
            return (Criteria) this;
        }

        public Criteria andSettledate3IsNotNull() {
            addCriterion("SETTLEDATE3 is not null");
            return (Criteria) this;
        }

        public Criteria andSettledate3EqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 =", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3NotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 <>", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3GreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 >", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 >=", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3LessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 <", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE3 <=", value, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3In(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE3 in", values, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3NotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE3 not in", values, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3Between(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE3 between", value1, value2, "settledate3");
            return (Criteria) this;
        }

        public Criteria andSettledate3NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE3 not between", value1, value2, "settledate3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3IsNull() {
            addCriterion("MARGINITEM3 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem3IsNotNull() {
            addCriterion("MARGINITEM3 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem3EqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3 =", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3 <>", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM3 >", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3 >=", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3LessThan(BigDecimal value) {
            addCriterion("MARGINITEM3 <", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3 <=", value, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3In(List<BigDecimal> values) {
            addCriterion("MARGINITEM3 in", values, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM3 not in", values, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM3 between", value1, value2, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andMarginitem3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM3 not between", value1, value2, "marginitem3");
            return (Criteria) this;
        }

        public Criteria andSettledate4IsNull() {
            addCriterion("SETTLEDATE4 is null");
            return (Criteria) this;
        }

        public Criteria andSettledate4IsNotNull() {
            addCriterion("SETTLEDATE4 is not null");
            return (Criteria) this;
        }

        public Criteria andSettledate4EqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 =", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4NotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 <>", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4GreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 >", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 >=", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4LessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 <", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE4 <=", value, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4In(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE4 in", values, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4NotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE4 not in", values, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4Between(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE4 between", value1, value2, "settledate4");
            return (Criteria) this;
        }

        public Criteria andSettledate4NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE4 not between", value1, value2, "settledate4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4IsNull() {
            addCriterion("MARGINITEM4 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem4IsNotNull() {
            addCriterion("MARGINITEM4 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem4EqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4 =", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4 <>", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM4 >", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4 >=", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4LessThan(BigDecimal value) {
            addCriterion("MARGINITEM4 <", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4 <=", value, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4In(List<BigDecimal> values) {
            addCriterion("MARGINITEM4 in", values, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM4 not in", values, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM4 between", value1, value2, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andMarginitem4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM4 not between", value1, value2, "marginitem4");
            return (Criteria) this;
        }

        public Criteria andLastpriceIsNull() {
            addCriterion("LASTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andLastpriceIsNotNull() {
            addCriterion("LASTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLastpriceEqualTo(BigDecimal value) {
            addCriterion("LASTPRICE =", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceNotEqualTo(BigDecimal value) {
            addCriterion("LASTPRICE <>", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceGreaterThan(BigDecimal value) {
            addCriterion("LASTPRICE >", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTPRICE >=", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceLessThan(BigDecimal value) {
            addCriterion("LASTPRICE <", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LASTPRICE <=", value, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceIn(List<BigDecimal> values) {
            addCriterion("LASTPRICE in", values, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceNotIn(List<BigDecimal> values) {
            addCriterion("LASTPRICE not in", values, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTPRICE between", value1, value2, "lastprice");
            return (Criteria) this;
        }

        public Criteria andLastpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LASTPRICE not between", value1, value2, "lastprice");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SIsNull() {
            addCriterion("MARGINITEM1_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SIsNotNull() {
            addCriterion("MARGINITEM1_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1_S =", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1_S <>", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM1_S >", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1_S >=", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SLessThan(BigDecimal value) {
            addCriterion("MARGINITEM1_S <", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM1_S <=", value, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM1_S in", values, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM1_S not in", values, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM1_S between", value1, value2, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem1SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM1_S not between", value1, value2, "marginitem1S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SIsNull() {
            addCriterion("MARGINITEM2_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SIsNotNull() {
            addCriterion("MARGINITEM2_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2_S =", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2_S <>", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM2_S >", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2_S >=", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SLessThan(BigDecimal value) {
            addCriterion("MARGINITEM2_S <", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM2_S <=", value, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM2_S in", values, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM2_S not in", values, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM2_S between", value1, value2, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem2SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM2_S not between", value1, value2, "marginitem2S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SIsNull() {
            addCriterion("MARGINITEM3_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SIsNotNull() {
            addCriterion("MARGINITEM3_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3_S =", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3_S <>", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM3_S >", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3_S >=", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SLessThan(BigDecimal value) {
            addCriterion("MARGINITEM3_S <", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM3_S <=", value, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM3_S in", values, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM3_S not in", values, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM3_S between", value1, value2, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem3SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM3_S not between", value1, value2, "marginitem3S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SIsNull() {
            addCriterion("MARGINITEM4_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SIsNotNull() {
            addCriterion("MARGINITEM4_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4_S =", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4_S <>", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM4_S >", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4_S >=", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SLessThan(BigDecimal value) {
            addCriterion("MARGINITEM4_S <", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM4_S <=", value, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM4_S in", values, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM4_S not in", values, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM4_S between", value1, value2, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginitem4SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM4_S not between", value1, value2, "marginitem4S");
            return (Criteria) this;
        }

        public Criteria andMarginassureBIsNull() {
            addCriterion("MARGINASSURE_B is null");
            return (Criteria) this;
        }

        public Criteria andMarginassureBIsNotNull() {
            addCriterion("MARGINASSURE_B is not null");
            return (Criteria) this;
        }

        public Criteria andMarginassureBEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_B =", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBNotEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_B <>", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBGreaterThan(BigDecimal value) {
            addCriterion("MARGINASSURE_B >", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_B >=", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBLessThan(BigDecimal value) {
            addCriterion("MARGINASSURE_B <", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_B <=", value, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBIn(List<BigDecimal> values) {
            addCriterion("MARGINASSURE_B in", values, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBNotIn(List<BigDecimal> values) {
            addCriterion("MARGINASSURE_B not in", values, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINASSURE_B between", value1, value2, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINASSURE_B not between", value1, value2, "marginassureB");
            return (Criteria) this;
        }

        public Criteria andMarginassureSIsNull() {
            addCriterion("MARGINASSURE_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginassureSIsNotNull() {
            addCriterion("MARGINASSURE_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginassureSEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_S =", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSNotEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_S <>", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSGreaterThan(BigDecimal value) {
            addCriterion("MARGINASSURE_S >", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_S >=", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSLessThan(BigDecimal value) {
            addCriterion("MARGINASSURE_S <", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINASSURE_S <=", value, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSIn(List<BigDecimal> values) {
            addCriterion("MARGINASSURE_S in", values, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSNotIn(List<BigDecimal> values) {
            addCriterion("MARGINASSURE_S not in", values, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINASSURE_S between", value1, value2, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginassureSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINASSURE_S not between", value1, value2, "marginassureS");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1IsNull() {
            addCriterion("MARGINITEMASSURE1 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1IsNotNull() {
            addCriterion("MARGINITEMASSURE1 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1EqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 =", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 <>", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 >", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 >=", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1LessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 <", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1 <=", value, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1In(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE1 in", values, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE1 not in", values, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE1 between", value1, value2, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE1 not between", value1, value2, "marginitemassure1");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2IsNull() {
            addCriterion("MARGINITEMASSURE2 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2IsNotNull() {
            addCriterion("MARGINITEMASSURE2 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2EqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 =", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 <>", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 >", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 >=", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2LessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 <", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2 <=", value, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2In(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE2 in", values, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE2 not in", values, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE2 between", value1, value2, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE2 not between", value1, value2, "marginitemassure2");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3IsNull() {
            addCriterion("MARGINITEMASSURE3 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3IsNotNull() {
            addCriterion("MARGINITEMASSURE3 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3EqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 =", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 <>", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 >", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 >=", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3LessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 <", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3 <=", value, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3In(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE3 in", values, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE3 not in", values, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE3 between", value1, value2, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE3 not between", value1, value2, "marginitemassure3");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4IsNull() {
            addCriterion("MARGINITEMASSURE4 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4IsNotNull() {
            addCriterion("MARGINITEMASSURE4 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4EqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 =", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 <>", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 >", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 >=", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4LessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 <", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4 <=", value, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4In(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE4 in", values, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE4 not in", values, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE4 between", value1, value2, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE4 not between", value1, value2, "marginitemassure4");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SIsNull() {
            addCriterion("MARGINITEMASSURE1_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SIsNotNull() {
            addCriterion("MARGINITEMASSURE1_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S =", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S <>", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S >", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S >=", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SLessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S <", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE1_S <=", value, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE1_S in", values, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE1_S not in", values, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE1_S between", value1, value2, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure1SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE1_S not between", value1, value2, "marginitemassure1S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SIsNull() {
            addCriterion("MARGINITEMASSURE2_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SIsNotNull() {
            addCriterion("MARGINITEMASSURE2_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S =", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S <>", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S >", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S >=", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SLessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S <", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE2_S <=", value, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE2_S in", values, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE2_S not in", values, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE2_S between", value1, value2, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure2SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE2_S not between", value1, value2, "marginitemassure2S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SIsNull() {
            addCriterion("MARGINITEMASSURE3_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SIsNotNull() {
            addCriterion("MARGINITEMASSURE3_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S =", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S <>", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S >", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S >=", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SLessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S <", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE3_S <=", value, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE3_S in", values, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE3_S not in", values, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE3_S between", value1, value2, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure3SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE3_S not between", value1, value2, "marginitemassure3S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SIsNull() {
            addCriterion("MARGINITEMASSURE4_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SIsNotNull() {
            addCriterion("MARGINITEMASSURE4_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S =", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S <>", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S >", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S >=", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SLessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S <", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE4_S <=", value, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE4_S in", values, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE4_S not in", values, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE4_S between", value1, value2, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure4SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE4_S not between", value1, value2, "marginitemassure4S");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBIsNull() {
            addCriterion("TODAYCLOSEFEERATE_B is null");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBIsNotNull() {
            addCriterion("TODAYCLOSEFEERATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B =", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBNotEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B <>", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBGreaterThan(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B >", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B >=", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBLessThan(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B <", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_B <=", value, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBIn(List<BigDecimal> values) {
            addCriterion("TODAYCLOSEFEERATE_B in", values, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBNotIn(List<BigDecimal> values) {
            addCriterion("TODAYCLOSEFEERATE_B not in", values, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAYCLOSEFEERATE_B between", value1, value2, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAYCLOSEFEERATE_B not between", value1, value2, "todayclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSIsNull() {
            addCriterion("TODAYCLOSEFEERATE_S is null");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSIsNotNull() {
            addCriterion("TODAYCLOSEFEERATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S =", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSNotEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S <>", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSGreaterThan(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S >", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S >=", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSLessThan(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S <", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAYCLOSEFEERATE_S <=", value, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSIn(List<BigDecimal> values) {
            addCriterion("TODAYCLOSEFEERATE_S in", values, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSNotIn(List<BigDecimal> values) {
            addCriterion("TODAYCLOSEFEERATE_S not in", values, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAYCLOSEFEERATE_S between", value1, value2, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andTodayclosefeerateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAYCLOSEFEERATE_S not between", value1, value2, "todayclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBIsNull() {
            addCriterion("HISTORYCLOSEFEERATE_B is null");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBIsNotNull() {
            addCriterion("HISTORYCLOSEFEERATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B =", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBNotEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B <>", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBGreaterThan(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B >", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B >=", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBLessThan(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B <", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_B <=", value, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBIn(List<BigDecimal> values) {
            addCriterion("HISTORYCLOSEFEERATE_B in", values, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBNotIn(List<BigDecimal> values) {
            addCriterion("HISTORYCLOSEFEERATE_B not in", values, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORYCLOSEFEERATE_B between", value1, value2, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORYCLOSEFEERATE_B not between", value1, value2, "historyclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSIsNull() {
            addCriterion("HISTORYCLOSEFEERATE_S is null");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSIsNotNull() {
            addCriterion("HISTORYCLOSEFEERATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S =", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSNotEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S <>", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSGreaterThan(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S >", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S >=", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSLessThan(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S <", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HISTORYCLOSEFEERATE_S <=", value, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSIn(List<BigDecimal> values) {
            addCriterion("HISTORYCLOSEFEERATE_S in", values, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSNotIn(List<BigDecimal> values) {
            addCriterion("HISTORYCLOSEFEERATE_S not in", values, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORYCLOSEFEERATE_S between", value1, value2, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andHistoryclosefeerateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HISTORYCLOSEFEERATE_S not between", value1, value2, "historyclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyIsNull() {
            addCriterion("LIMITCMDTYQTY is null");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyIsNotNull() {
            addCriterion("LIMITCMDTYQTY is not null");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyEqualTo(Long value) {
            addCriterion("LIMITCMDTYQTY =", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyNotEqualTo(Long value) {
            addCriterion("LIMITCMDTYQTY <>", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyGreaterThan(Long value) {
            addCriterion("LIMITCMDTYQTY >", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("LIMITCMDTYQTY >=", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyLessThan(Long value) {
            addCriterion("LIMITCMDTYQTY <", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyLessThanOrEqualTo(Long value) {
            addCriterion("LIMITCMDTYQTY <=", value, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyIn(List<Long> values) {
            addCriterion("LIMITCMDTYQTY in", values, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyNotIn(List<Long> values) {
            addCriterion("LIMITCMDTYQTY not in", values, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyBetween(Long value1, Long value2) {
            addCriterion("LIMITCMDTYQTY between", value1, value2, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andLimitcmdtyqtyNotBetween(Long value1, Long value2) {
            addCriterion("LIMITCMDTYQTY not between", value1, value2, "limitcmdtyqty");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrIsNull() {
            addCriterion("SETTLEFEEALGR is null");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrIsNotNull() {
            addCriterion("SETTLEFEEALGR is not null");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrEqualTo(Short value) {
            addCriterion("SETTLEFEEALGR =", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrNotEqualTo(Short value) {
            addCriterion("SETTLEFEEALGR <>", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrGreaterThan(Short value) {
            addCriterion("SETTLEFEEALGR >", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEFEEALGR >=", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrLessThan(Short value) {
            addCriterion("SETTLEFEEALGR <", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEFEEALGR <=", value, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrIn(List<Short> values) {
            addCriterion("SETTLEFEEALGR in", values, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrNotIn(List<Short> values) {
            addCriterion("SETTLEFEEALGR not in", values, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrBetween(Short value1, Short value2) {
            addCriterion("SETTLEFEEALGR between", value1, value2, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeealgrNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEFEEALGR not between", value1, value2, "settlefeealgr");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBIsNull() {
            addCriterion("SETTLEFEERATE_B is null");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBIsNotNull() {
            addCriterion("SETTLEFEERATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B =", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBNotEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B <>", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBGreaterThan(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B >", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B >=", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBLessThan(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B <", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_B <=", value, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBIn(List<BigDecimal> values) {
            addCriterion("SETTLEFEERATE_B in", values, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBNotIn(List<BigDecimal> values) {
            addCriterion("SETTLEFEERATE_B not in", values, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEFEERATE_B between", value1, value2, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEFEERATE_B not between", value1, value2, "settlefeerateB");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSIsNull() {
            addCriterion("SETTLEFEERATE_S is null");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSIsNotNull() {
            addCriterion("SETTLEFEERATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S =", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSNotEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S <>", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSGreaterThan(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S >", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S >=", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSLessThan(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S <", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEFEERATE_S <=", value, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSIn(List<BigDecimal> values) {
            addCriterion("SETTLEFEERATE_S in", values, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSNotIn(List<BigDecimal> values) {
            addCriterion("SETTLEFEERATE_S not in", values, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEFEERATE_S between", value1, value2, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlefeerateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEFEERATE_S not between", value1, value2, "settlefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrIsNull() {
            addCriterion("FORCECLOSEFEEALGR is null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrIsNotNull() {
            addCriterion("FORCECLOSEFEEALGR is not null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrEqualTo(Short value) {
            addCriterion("FORCECLOSEFEEALGR =", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrNotEqualTo(Short value) {
            addCriterion("FORCECLOSEFEEALGR <>", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrGreaterThan(Short value) {
            addCriterion("FORCECLOSEFEEALGR >", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrGreaterThanOrEqualTo(Short value) {
            addCriterion("FORCECLOSEFEEALGR >=", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrLessThan(Short value) {
            addCriterion("FORCECLOSEFEEALGR <", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrLessThanOrEqualTo(Short value) {
            addCriterion("FORCECLOSEFEEALGR <=", value, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrIn(List<Short> values) {
            addCriterion("FORCECLOSEFEEALGR in", values, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrNotIn(List<Short> values) {
            addCriterion("FORCECLOSEFEEALGR not in", values, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrBetween(Short value1, Short value2) {
            addCriterion("FORCECLOSEFEEALGR between", value1, value2, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeealgrNotBetween(Short value1, Short value2) {
            addCriterion("FORCECLOSEFEEALGR not between", value1, value2, "forceclosefeealgr");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBIsNull() {
            addCriterion("FORCECLOSEFEERATE_B is null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBIsNotNull() {
            addCriterion("FORCECLOSEFEERATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B =", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBNotEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B <>", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBGreaterThan(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B >", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B >=", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBLessThan(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B <", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_B <=", value, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBIn(List<BigDecimal> values) {
            addCriterion("FORCECLOSEFEERATE_B in", values, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBNotIn(List<BigDecimal> values) {
            addCriterion("FORCECLOSEFEERATE_B not in", values, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORCECLOSEFEERATE_B between", value1, value2, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORCECLOSEFEERATE_B not between", value1, value2, "forceclosefeerateB");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSIsNull() {
            addCriterion("FORCECLOSEFEERATE_S is null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSIsNotNull() {
            addCriterion("FORCECLOSEFEERATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S =", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSNotEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S <>", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSGreaterThan(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S >", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S >=", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSLessThan(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S <", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FORCECLOSEFEERATE_S <=", value, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSIn(List<BigDecimal> values) {
            addCriterion("FORCECLOSEFEERATE_S in", values, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSNotIn(List<BigDecimal> values) {
            addCriterion("FORCECLOSEFEERATE_S not in", values, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORCECLOSEFEERATE_S between", value1, value2, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andForceclosefeerateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORCECLOSEFEERATE_S not between", value1, value2, "forceclosefeerateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBIsNull() {
            addCriterion("SETTLEMARGINALGR_B is null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBIsNotNull() {
            addCriterion("SETTLEMARGINALGR_B is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_B =", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBNotEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_B <>", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBGreaterThan(Short value) {
            addCriterion("SETTLEMARGINALGR_B >", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_B >=", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBLessThan(Short value) {
            addCriterion("SETTLEMARGINALGR_B <", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_B <=", value, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBIn(List<Short> values) {
            addCriterion("SETTLEMARGINALGR_B in", values, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBNotIn(List<Short> values) {
            addCriterion("SETTLEMARGINALGR_B not in", values, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINALGR_B between", value1, value2, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrBNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINALGR_B not between", value1, value2, "settlemarginalgrB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBIsNull() {
            addCriterion("SETTLEMARGINRATE_B is null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBIsNotNull() {
            addCriterion("SETTLEMARGINRATE_B is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B =", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBNotEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B <>", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBGreaterThan(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B >", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B >=", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBLessThan(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B <", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_B <=", value, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBIn(List<BigDecimal> values) {
            addCriterion("SETTLEMARGINRATE_B in", values, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBNotIn(List<BigDecimal> values) {
            addCriterion("SETTLEMARGINRATE_B not in", values, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMARGINRATE_B between", value1, value2, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMARGINRATE_B not between", value1, value2, "settlemarginrateB");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSIsNull() {
            addCriterion("SETTLEMARGINALGR_S is null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSIsNotNull() {
            addCriterion("SETTLEMARGINALGR_S is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_S =", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSNotEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_S <>", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSGreaterThan(Short value) {
            addCriterion("SETTLEMARGINALGR_S >", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_S >=", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSLessThan(Short value) {
            addCriterion("SETTLEMARGINALGR_S <", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINALGR_S <=", value, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSIn(List<Short> values) {
            addCriterion("SETTLEMARGINALGR_S in", values, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSNotIn(List<Short> values) {
            addCriterion("SETTLEMARGINALGR_S not in", values, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINALGR_S between", value1, value2, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginalgrSNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINALGR_S not between", value1, value2, "settlemarginalgrS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSIsNull() {
            addCriterion("SETTLEMARGINRATE_S is null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSIsNotNull() {
            addCriterion("SETTLEMARGINRATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S =", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSNotEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S <>", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSGreaterThan(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S >", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S >=", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSLessThan(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S <", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMARGINRATE_S <=", value, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSIn(List<BigDecimal> values) {
            addCriterion("SETTLEMARGINRATE_S in", values, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSNotIn(List<BigDecimal> values) {
            addCriterion("SETTLEMARGINRATE_S not in", values, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMARGINRATE_S between", value1, value2, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andSettlemarginrateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMARGINRATE_S not between", value1, value2, "settlemarginrateS");
            return (Criteria) this;
        }

        public Criteria andReservecountIsNull() {
            addCriterion("RESERVECOUNT is null");
            return (Criteria) this;
        }

        public Criteria andReservecountIsNotNull() {
            addCriterion("RESERVECOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReservecountEqualTo(Long value) {
            addCriterion("RESERVECOUNT =", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountNotEqualTo(Long value) {
            addCriterion("RESERVECOUNT <>", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountGreaterThan(Long value) {
            addCriterion("RESERVECOUNT >", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountGreaterThanOrEqualTo(Long value) {
            addCriterion("RESERVECOUNT >=", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountLessThan(Long value) {
            addCriterion("RESERVECOUNT <", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountLessThanOrEqualTo(Long value) {
            addCriterion("RESERVECOUNT <=", value, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountIn(List<Long> values) {
            addCriterion("RESERVECOUNT in", values, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountNotIn(List<Long> values) {
            addCriterion("RESERVECOUNT not in", values, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountBetween(Long value1, Long value2) {
            addCriterion("RESERVECOUNT between", value1, value2, "reservecount");
            return (Criteria) this;
        }

        public Criteria andReservecountNotBetween(Long value1, Long value2) {
            addCriterion("RESERVECOUNT not between", value1, value2, "reservecount");
            return (Criteria) this;
        }

        public Criteria andAddedtaxIsNull() {
            addCriterion("ADDEDTAX is null");
            return (Criteria) this;
        }

        public Criteria andAddedtaxIsNotNull() {
            addCriterion("ADDEDTAX is not null");
            return (Criteria) this;
        }

        public Criteria andAddedtaxEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAX =", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxNotEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAX <>", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxGreaterThan(BigDecimal value) {
            addCriterion("ADDEDTAX >", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAX >=", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxLessThan(BigDecimal value) {
            addCriterion("ADDEDTAX <", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAX <=", value, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxIn(List<BigDecimal> values) {
            addCriterion("ADDEDTAX in", values, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxNotIn(List<BigDecimal> values) {
            addCriterion("ADDEDTAX not in", values, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADDEDTAX between", value1, value2, "addedtax");
            return (Criteria) this;
        }

        public Criteria andAddedtaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADDEDTAX not between", value1, value2, "addedtax");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeIsNull() {
            addCriterion("MARGINPRICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeIsNotNull() {
            addCriterion("MARGINPRICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeEqualTo(Short value) {
            addCriterion("MARGINPRICETYPE =", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeNotEqualTo(Short value) {
            addCriterion("MARGINPRICETYPE <>", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeGreaterThan(Short value) {
            addCriterion("MARGINPRICETYPE >", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("MARGINPRICETYPE >=", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeLessThan(Short value) {
            addCriterion("MARGINPRICETYPE <", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeLessThanOrEqualTo(Short value) {
            addCriterion("MARGINPRICETYPE <=", value, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeIn(List<Short> values) {
            addCriterion("MARGINPRICETYPE in", values, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeNotIn(List<Short> values) {
            addCriterion("MARGINPRICETYPE not in", values, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeBetween(Short value1, Short value2) {
            addCriterion("MARGINPRICETYPE between", value1, value2, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andMarginpricetypeNotBetween(Short value1, Short value2) {
            addCriterion("MARGINPRICETYPE not between", value1, value2, "marginpricetype");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeIsNull() {
            addCriterion("LOWESTSETTLEFEE is null");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeIsNotNull() {
            addCriterion("LOWESTSETTLEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeEqualTo(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE =", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeNotEqualTo(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE <>", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeGreaterThan(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE >", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE >=", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeLessThan(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE <", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWESTSETTLEFEE <=", value, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeIn(List<BigDecimal> values) {
            addCriterion("LOWESTSETTLEFEE in", values, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeNotIn(List<BigDecimal> values) {
            addCriterion("LOWESTSETTLEFEE not in", values, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWESTSETTLEFEE between", value1, value2, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andLowestsettlefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWESTSETTLEFEE not between", value1, value2, "lowestsettlefee");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyIsNull() {
            addCriterion("FIRMCLEANQTY is null");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyIsNotNull() {
            addCriterion("FIRMCLEANQTY is not null");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyEqualTo(Long value) {
            addCriterion("FIRMCLEANQTY =", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyNotEqualTo(Long value) {
            addCriterion("FIRMCLEANQTY <>", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyGreaterThan(Long value) {
            addCriterion("FIRMCLEANQTY >", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("FIRMCLEANQTY >=", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyLessThan(Long value) {
            addCriterion("FIRMCLEANQTY <", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyLessThanOrEqualTo(Long value) {
            addCriterion("FIRMCLEANQTY <=", value, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyIn(List<Long> values) {
            addCriterion("FIRMCLEANQTY in", values, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyNotIn(List<Long> values) {
            addCriterion("FIRMCLEANQTY not in", values, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyBetween(Long value1, Long value2) {
            addCriterion("FIRMCLEANQTY between", value1, value2, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmcleanqtyNotBetween(Long value1, Long value2) {
            addCriterion("FIRMCLEANQTY not between", value1, value2, "firmcleanqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyIsNull() {
            addCriterion("FIRMMAXHOLDQTY is null");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyIsNotNull() {
            addCriterion("FIRMMAXHOLDQTY is not null");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyEqualTo(Long value) {
            addCriterion("FIRMMAXHOLDQTY =", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyNotEqualTo(Long value) {
            addCriterion("FIRMMAXHOLDQTY <>", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyGreaterThan(Long value) {
            addCriterion("FIRMMAXHOLDQTY >", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("FIRMMAXHOLDQTY >=", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyLessThan(Long value) {
            addCriterion("FIRMMAXHOLDQTY <", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyLessThanOrEqualTo(Long value) {
            addCriterion("FIRMMAXHOLDQTY <=", value, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyIn(List<Long> values) {
            addCriterion("FIRMMAXHOLDQTY in", values, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyNotIn(List<Long> values) {
            addCriterion("FIRMMAXHOLDQTY not in", values, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyBetween(Long value1, Long value2) {
            addCriterion("FIRMMAXHOLDQTY between", value1, value2, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyNotBetween(Long value1, Long value2) {
            addCriterion("FIRMMAXHOLDQTY not between", value1, value2, "firmmaxholdqty");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrIsNull() {
            addCriterion("PAYOUTALGR is null");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrIsNotNull() {
            addCriterion("PAYOUTALGR is not null");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrEqualTo(Short value) {
            addCriterion("PAYOUTALGR =", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrNotEqualTo(Short value) {
            addCriterion("PAYOUTALGR <>", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrGreaterThan(Short value) {
            addCriterion("PAYOUTALGR >", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrGreaterThanOrEqualTo(Short value) {
            addCriterion("PAYOUTALGR >=", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrLessThan(Short value) {
            addCriterion("PAYOUTALGR <", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrLessThanOrEqualTo(Short value) {
            addCriterion("PAYOUTALGR <=", value, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrIn(List<Short> values) {
            addCriterion("PAYOUTALGR in", values, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrNotIn(List<Short> values) {
            addCriterion("PAYOUTALGR not in", values, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrBetween(Short value1, Short value2) {
            addCriterion("PAYOUTALGR between", value1, value2, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutalgrNotBetween(Short value1, Short value2) {
            addCriterion("PAYOUTALGR not between", value1, value2, "payoutalgr");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIsNull() {
            addCriterion("PAYOUTRATE is null");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIsNotNull() {
            addCriterion("PAYOUTRATE is not null");
            return (Criteria) this;
        }

        public Criteria andPayoutrateEqualTo(BigDecimal value) {
            addCriterion("PAYOUTRATE =", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotEqualTo(BigDecimal value) {
            addCriterion("PAYOUTRATE <>", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateGreaterThan(BigDecimal value) {
            addCriterion("PAYOUTRATE >", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYOUTRATE >=", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateLessThan(BigDecimal value) {
            addCriterion("PAYOUTRATE <", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYOUTRATE <=", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIn(List<BigDecimal> values) {
            addCriterion("PAYOUTRATE in", values, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotIn(List<BigDecimal> values) {
            addCriterion("PAYOUTRATE not in", values, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYOUTRATE between", value1, value2, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYOUTRATE not between", value1, value2, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorIsNull() {
            addCriterion("ADDEDTAXFACTOR is null");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorIsNotNull() {
            addCriterion("ADDEDTAXFACTOR is not null");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR =", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorNotEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR <>", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorGreaterThan(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR >", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR >=", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorLessThan(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR <", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ADDEDTAXFACTOR <=", value, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorIn(List<BigDecimal> values) {
            addCriterion("ADDEDTAXFACTOR in", values, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorNotIn(List<BigDecimal> values) {
            addCriterion("ADDEDTAXFACTOR not in", values, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADDEDTAXFACTOR between", value1, value2, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andAddedtaxfactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ADDEDTAXFACTOR not between", value1, value2, "addedtaxfactor");
            return (Criteria) this;
        }

        public Criteria andSettledate5IsNull() {
            addCriterion("SETTLEDATE5 is null");
            return (Criteria) this;
        }

        public Criteria andSettledate5IsNotNull() {
            addCriterion("SETTLEDATE5 is not null");
            return (Criteria) this;
        }

        public Criteria andSettledate5EqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 =", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5NotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 <>", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5GreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 >", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 >=", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5LessThan(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 <", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLEDATE5 <=", value, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5In(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE5 in", values, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5NotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLEDATE5 not in", values, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5Between(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE5 between", value1, value2, "settledate5");
            return (Criteria) this;
        }

        public Criteria andSettledate5NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLEDATE5 not between", value1, value2, "settledate5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5IsNull() {
            addCriterion("MARGINITEM5 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem5IsNotNull() {
            addCriterion("MARGINITEM5 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem5EqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5 =", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5 <>", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM5 >", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5 >=", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5LessThan(BigDecimal value) {
            addCriterion("MARGINITEM5 <", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5 <=", value, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5In(List<BigDecimal> values) {
            addCriterion("MARGINITEM5 in", values, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM5 not in", values, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM5 between", value1, value2, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM5 not between", value1, value2, "marginitem5");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SIsNull() {
            addCriterion("MARGINITEM5_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SIsNotNull() {
            addCriterion("MARGINITEM5_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5_S =", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5_S <>", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEM5_S >", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5_S >=", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SLessThan(BigDecimal value) {
            addCriterion("MARGINITEM5_S <", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEM5_S <=", value, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM5_S in", values, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEM5_S not in", values, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM5_S between", value1, value2, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitem5SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEM5_S not between", value1, value2, "marginitem5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5IsNull() {
            addCriterion("MARGINITEMASSURE5 is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5IsNotNull() {
            addCriterion("MARGINITEMASSURE5 is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5EqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 =", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5NotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 <>", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5GreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 >", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 >=", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5LessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 <", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5 <=", value, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5In(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE5 in", values, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5NotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE5 not in", values, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE5 between", value1, value2, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE5 not between", value1, value2, "marginitemassure5");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SIsNull() {
            addCriterion("MARGINITEMASSURE5_S is null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SIsNotNull() {
            addCriterion("MARGINITEMASSURE5_S is not null");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S =", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SNotEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S <>", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SGreaterThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S >", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S >=", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SLessThan(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S <", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MARGINITEMASSURE5_S <=", value, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE5_S in", values, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SNotIn(List<BigDecimal> values) {
            addCriterion("MARGINITEMASSURE5_S not in", values, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE5_S between", value1, value2, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andMarginitemassure5SNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MARGINITEMASSURE5_S not between", value1, value2, "marginitemassure5S");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeIsNull() {
            addCriterion("SETTLEPRICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeIsNotNull() {
            addCriterion("SETTLEPRICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeEqualTo(Short value) {
            addCriterion("SETTLEPRICETYPE =", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeNotEqualTo(Short value) {
            addCriterion("SETTLEPRICETYPE <>", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeGreaterThan(Short value) {
            addCriterion("SETTLEPRICETYPE >", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEPRICETYPE >=", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeLessThan(Short value) {
            addCriterion("SETTLEPRICETYPE <", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEPRICETYPE <=", value, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeIn(List<Short> values) {
            addCriterion("SETTLEPRICETYPE in", values, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeNotIn(List<Short> values) {
            addCriterion("SETTLEPRICETYPE not in", values, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeBetween(Short value1, Short value2) {
            addCriterion("SETTLEPRICETYPE between", value1, value2, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlepricetypeNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEPRICETYPE not between", value1, value2, "settlepricetype");
            return (Criteria) this;
        }

        public Criteria andBeforedaysIsNull() {
            addCriterion("BEFOREDAYS is null");
            return (Criteria) this;
        }

        public Criteria andBeforedaysIsNotNull() {
            addCriterion("BEFOREDAYS is not null");
            return (Criteria) this;
        }

        public Criteria andBeforedaysEqualTo(Short value) {
            addCriterion("BEFOREDAYS =", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysNotEqualTo(Short value) {
            addCriterion("BEFOREDAYS <>", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysGreaterThan(Short value) {
            addCriterion("BEFOREDAYS >", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysGreaterThanOrEqualTo(Short value) {
            addCriterion("BEFOREDAYS >=", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysLessThan(Short value) {
            addCriterion("BEFOREDAYS <", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysLessThanOrEqualTo(Short value) {
            addCriterion("BEFOREDAYS <=", value, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysIn(List<Short> values) {
            addCriterion("BEFOREDAYS in", values, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysNotIn(List<Short> values) {
            addCriterion("BEFOREDAYS not in", values, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysBetween(Short value1, Short value2) {
            addCriterion("BEFOREDAYS between", value1, value2, "beforedays");
            return (Criteria) this;
        }

        public Criteria andBeforedaysNotBetween(Short value1, Short value2) {
            addCriterion("BEFOREDAYS not between", value1, value2, "beforedays");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceIsNull() {
            addCriterion("SPECSETTLEPRICE is null");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceIsNotNull() {
            addCriterion("SPECSETTLEPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceEqualTo(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE =", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceNotEqualTo(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE <>", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceGreaterThan(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE >", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE >=", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceLessThan(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE <", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPECSETTLEPRICE <=", value, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceIn(List<BigDecimal> values) {
            addCriterion("SPECSETTLEPRICE in", values, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceNotIn(List<BigDecimal> values) {
            addCriterion("SPECSETTLEPRICE not in", values, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPECSETTLEPRICE between", value1, value2, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andSpecsettlepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPECSETTLEPRICE not between", value1, value2, "specsettleprice");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBIsNull() {
            addCriterion("ORDERPRIVILEGE_B is null");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBIsNotNull() {
            addCriterion("ORDERPRIVILEGE_B is not null");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_B =", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBNotEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_B <>", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBGreaterThan(Integer value) {
            addCriterion("ORDERPRIVILEGE_B >", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_B >=", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBLessThan(Integer value) {
            addCriterion("ORDERPRIVILEGE_B <", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_B <=", value, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBIn(List<Integer> values) {
            addCriterion("ORDERPRIVILEGE_B in", values, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBNotIn(List<Integer> values) {
            addCriterion("ORDERPRIVILEGE_B not in", values, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRIVILEGE_B between", value1, value2, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeBNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRIVILEGE_B not between", value1, value2, "orderprivilegeB");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSIsNull() {
            addCriterion("ORDERPRIVILEGE_S is null");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSIsNotNull() {
            addCriterion("ORDERPRIVILEGE_S is not null");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_S =", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSNotEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_S <>", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSGreaterThan(Integer value) {
            addCriterion("ORDERPRIVILEGE_S >", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_S >=", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSLessThan(Integer value) {
            addCriterion("ORDERPRIVILEGE_S <", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRIVILEGE_S <=", value, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSIn(List<Integer> values) {
            addCriterion("ORDERPRIVILEGE_S in", values, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSNotIn(List<Integer> values) {
            addCriterion("ORDERPRIVILEGE_S not in", values, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRIVILEGE_S between", value1, value2, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andOrderprivilegeSNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRIVILEGE_S not between", value1, value2, "orderprivilegeS");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrIsNull() {
            addCriterion("FIRMMAXHOLDQTYALGR is null");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrIsNotNull() {
            addCriterion("FIRMMAXHOLDQTYALGR is not null");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrEqualTo(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR =", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrNotEqualTo(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR <>", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrGreaterThan(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR >", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrGreaterThanOrEqualTo(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR >=", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrLessThan(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR <", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrLessThanOrEqualTo(Short value) {
            addCriterion("FIRMMAXHOLDQTYALGR <=", value, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrIn(List<Short> values) {
            addCriterion("FIRMMAXHOLDQTYALGR in", values, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrNotIn(List<Short> values) {
            addCriterion("FIRMMAXHOLDQTYALGR not in", values, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrBetween(Short value1, Short value2) {
            addCriterion("FIRMMAXHOLDQTYALGR between", value1, value2, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andFirmmaxholdqtyalgrNotBetween(Short value1, Short value2) {
            addCriterion("FIRMMAXHOLDQTYALGR not between", value1, value2, "firmmaxholdqtyalgr");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyIsNull() {
            addCriterion("STARTPERCENTQTY is null");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyIsNotNull() {
            addCriterion("STARTPERCENTQTY is not null");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyEqualTo(Long value) {
            addCriterion("STARTPERCENTQTY =", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyNotEqualTo(Long value) {
            addCriterion("STARTPERCENTQTY <>", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyGreaterThan(Long value) {
            addCriterion("STARTPERCENTQTY >", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("STARTPERCENTQTY >=", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyLessThan(Long value) {
            addCriterion("STARTPERCENTQTY <", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyLessThanOrEqualTo(Long value) {
            addCriterion("STARTPERCENTQTY <=", value, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyIn(List<Long> values) {
            addCriterion("STARTPERCENTQTY in", values, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyNotIn(List<Long> values) {
            addCriterion("STARTPERCENTQTY not in", values, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyBetween(Long value1, Long value2) {
            addCriterion("STARTPERCENTQTY between", value1, value2, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andStartpercentqtyNotBetween(Long value1, Long value2) {
            addCriterion("STARTPERCENTQTY not between", value1, value2, "startpercentqty");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitIsNull() {
            addCriterion("MAXPERCENTLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitIsNotNull() {
            addCriterion("MAXPERCENTLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitEqualTo(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT =", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitNotEqualTo(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT <>", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitGreaterThan(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT >", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT >=", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitLessThan(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT <", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXPERCENTLIMIT <=", value, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitIn(List<BigDecimal> values) {
            addCriterion("MAXPERCENTLIMIT in", values, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitNotIn(List<BigDecimal> values) {
            addCriterion("MAXPERCENTLIMIT not in", values, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXPERCENTLIMIT between", value1, value2, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andMaxpercentlimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXPERCENTLIMIT not between", value1, value2, "maxpercentlimit");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyIsNull() {
            addCriterion("ONEMAXHOLDQTY is null");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyIsNotNull() {
            addCriterion("ONEMAXHOLDQTY is not null");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyEqualTo(Long value) {
            addCriterion("ONEMAXHOLDQTY =", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyNotEqualTo(Long value) {
            addCriterion("ONEMAXHOLDQTY <>", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyGreaterThan(Long value) {
            addCriterion("ONEMAXHOLDQTY >", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("ONEMAXHOLDQTY >=", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyLessThan(Long value) {
            addCriterion("ONEMAXHOLDQTY <", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyLessThanOrEqualTo(Long value) {
            addCriterion("ONEMAXHOLDQTY <=", value, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyIn(List<Long> values) {
            addCriterion("ONEMAXHOLDQTY in", values, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyNotIn(List<Long> values) {
            addCriterion("ONEMAXHOLDQTY not in", values, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyBetween(Long value1, Long value2) {
            addCriterion("ONEMAXHOLDQTY between", value1, value2, "onemaxholdqty");
            return (Criteria) this;
        }

        public Criteria andOnemaxholdqtyNotBetween(Long value1, Long value2) {
            addCriterion("ONEMAXHOLDQTY not between", value1, value2, "onemaxholdqty");
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

        public Criteria andMinquantitymoveEqualTo(Short value) {
            addCriterion("MINQUANTITYMOVE =", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotEqualTo(Short value) {
            addCriterion("MINQUANTITYMOVE <>", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveGreaterThan(Short value) {
            addCriterion("MINQUANTITYMOVE >", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveGreaterThanOrEqualTo(Short value) {
            addCriterion("MINQUANTITYMOVE >=", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveLessThan(Short value) {
            addCriterion("MINQUANTITYMOVE <", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveLessThanOrEqualTo(Short value) {
            addCriterion("MINQUANTITYMOVE <=", value, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveIn(List<Short> values) {
            addCriterion("MINQUANTITYMOVE in", values, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotIn(List<Short> values) {
            addCriterion("MINQUANTITYMOVE not in", values, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveBetween(Short value1, Short value2) {
            addCriterion("MINQUANTITYMOVE between", value1, value2, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andMinquantitymoveNotBetween(Short value1, Short value2) {
            addCriterion("MINQUANTITYMOVE not between", value1, value2, "minquantitymove");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateIsNull() {
            addCriterion("DELAYRECOUPRATE is null");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateIsNotNull() {
            addCriterion("DELAYRECOUPRATE is not null");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE =", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateNotEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE <>", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateGreaterThan(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE >", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE >=", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateLessThan(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE <", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE <=", value, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateIn(List<BigDecimal> values) {
            addCriterion("DELAYRECOUPRATE in", values, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateNotIn(List<BigDecimal> values) {
            addCriterion("DELAYRECOUPRATE not in", values, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAYRECOUPRATE between", value1, value2, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAYRECOUPRATE not between", value1, value2, "delayrecouprate");
            return (Criteria) this;
        }

        public Criteria andSettlewayIsNull() {
            addCriterion("SETTLEWAY is null");
            return (Criteria) this;
        }

        public Criteria andSettlewayIsNotNull() {
            addCriterion("SETTLEWAY is not null");
            return (Criteria) this;
        }

        public Criteria andSettlewayEqualTo(Short value) {
            addCriterion("SETTLEWAY =", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayNotEqualTo(Short value) {
            addCriterion("SETTLEWAY <>", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayGreaterThan(Short value) {
            addCriterion("SETTLEWAY >", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEWAY >=", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayLessThan(Short value) {
            addCriterion("SETTLEWAY <", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEWAY <=", value, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayIn(List<Short> values) {
            addCriterion("SETTLEWAY in", values, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayNotIn(List<Short> values) {
            addCriterion("SETTLEWAY not in", values, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayBetween(Short value1, Short value2) {
            addCriterion("SETTLEWAY between", value1, value2, "settleway");
            return (Criteria) this;
        }

        public Criteria andSettlewayNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEWAY not between", value1, value2, "settleway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayIsNull() {
            addCriterion("DELAYFEEWAY is null");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayIsNotNull() {
            addCriterion("DELAYFEEWAY is not null");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayEqualTo(Short value) {
            addCriterion("DELAYFEEWAY =", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayNotEqualTo(Short value) {
            addCriterion("DELAYFEEWAY <>", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayGreaterThan(Short value) {
            addCriterion("DELAYFEEWAY >", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayGreaterThanOrEqualTo(Short value) {
            addCriterion("DELAYFEEWAY >=", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayLessThan(Short value) {
            addCriterion("DELAYFEEWAY <", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayLessThanOrEqualTo(Short value) {
            addCriterion("DELAYFEEWAY <=", value, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayIn(List<Short> values) {
            addCriterion("DELAYFEEWAY in", values, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayNotIn(List<Short> values) {
            addCriterion("DELAYFEEWAY not in", values, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayBetween(Short value1, Short value2) {
            addCriterion("DELAYFEEWAY between", value1, value2, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andDelayfeewayNotBetween(Short value1, Short value2) {
            addCriterion("DELAYFEEWAY not between", value1, value2, "delayfeeway");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateIsNull() {
            addCriterion("MAXFEERATE is null");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateIsNotNull() {
            addCriterion("MAXFEERATE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateEqualTo(BigDecimal value) {
            addCriterion("MAXFEERATE =", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateNotEqualTo(BigDecimal value) {
            addCriterion("MAXFEERATE <>", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateGreaterThan(BigDecimal value) {
            addCriterion("MAXFEERATE >", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXFEERATE >=", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateLessThan(BigDecimal value) {
            addCriterion("MAXFEERATE <", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXFEERATE <=", value, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateIn(List<BigDecimal> values) {
            addCriterion("MAXFEERATE in", values, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateNotIn(List<BigDecimal> values) {
            addCriterion("MAXFEERATE not in", values, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXFEERATE between", value1, value2, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMaxfeerateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXFEERATE not between", value1, value2, "maxfeerate");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyIsNull() {
            addCriterion("MINSETTLEMOVEQTY is null");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyIsNotNull() {
            addCriterion("MINSETTLEMOVEQTY is not null");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyEqualTo(Integer value) {
            addCriterion("MINSETTLEMOVEQTY =", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyNotEqualTo(Integer value) {
            addCriterion("MINSETTLEMOVEQTY <>", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyGreaterThan(Integer value) {
            addCriterion("MINSETTLEMOVEQTY >", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("MINSETTLEMOVEQTY >=", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyLessThan(Integer value) {
            addCriterion("MINSETTLEMOVEQTY <", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyLessThanOrEqualTo(Integer value) {
            addCriterion("MINSETTLEMOVEQTY <=", value, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyIn(List<Integer> values) {
            addCriterion("MINSETTLEMOVEQTY in", values, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyNotIn(List<Integer> values) {
            addCriterion("MINSETTLEMOVEQTY not in", values, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyBetween(Integer value1, Integer value2) {
            addCriterion("MINSETTLEMOVEQTY between", value1, value2, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andMinsettlemoveqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("MINSETTLEMOVEQTY not between", value1, value2, "minsettlemoveqty");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateIsNull() {
            addCriterion("STORERECOUPRATE is null");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateIsNotNull() {
            addCriterion("STORERECOUPRATE is not null");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateEqualTo(BigDecimal value) {
            addCriterion("STORERECOUPRATE =", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateNotEqualTo(BigDecimal value) {
            addCriterion("STORERECOUPRATE <>", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateGreaterThan(BigDecimal value) {
            addCriterion("STORERECOUPRATE >", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STORERECOUPRATE >=", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateLessThan(BigDecimal value) {
            addCriterion("STORERECOUPRATE <", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STORERECOUPRATE <=", value, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateIn(List<BigDecimal> values) {
            addCriterion("STORERECOUPRATE in", values, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateNotIn(List<BigDecimal> values) {
            addCriterion("STORERECOUPRATE not in", values, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORERECOUPRATE between", value1, value2, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andStorerecouprateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORERECOUPRATE not between", value1, value2, "storerecouprate");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyIsNull() {
            addCriterion("MINSETTLEQTY is null");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyIsNotNull() {
            addCriterion("MINSETTLEQTY is not null");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyEqualTo(Long value) {
            addCriterion("MINSETTLEQTY =", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyNotEqualTo(Long value) {
            addCriterion("MINSETTLEQTY <>", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyGreaterThan(Long value) {
            addCriterion("MINSETTLEQTY >", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("MINSETTLEQTY >=", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyLessThan(Long value) {
            addCriterion("MINSETTLEQTY <", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyLessThanOrEqualTo(Long value) {
            addCriterion("MINSETTLEQTY <=", value, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyIn(List<Long> values) {
            addCriterion("MINSETTLEQTY in", values, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyNotIn(List<Long> values) {
            addCriterion("MINSETTLEQTY not in", values, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyBetween(Long value1, Long value2) {
            addCriterion("MINSETTLEQTY between", value1, value2, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andMinsettleqtyNotBetween(Long value1, Long value2) {
            addCriterion("MINSETTLEQTY not between", value1, value2, "minsettleqty");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSIsNull() {
            addCriterion("DELAYRECOUPRATE_S is null");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSIsNotNull() {
            addCriterion("DELAYRECOUPRATE_S is not null");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S =", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSNotEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S <>", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSGreaterThan(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S >", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S >=", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSLessThan(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S <", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAYRECOUPRATE_S <=", value, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSIn(List<BigDecimal> values) {
            addCriterion("DELAYRECOUPRATE_S in", values, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSNotIn(List<BigDecimal> values) {
            addCriterion("DELAYRECOUPRATE_S not in", values, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAYRECOUPRATE_S between", value1, value2, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andDelayrecouprateSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAYRECOUPRATE_S not between", value1, value2, "delayrecouprateS");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeIsNull() {
            addCriterion("AHEADSETTLEPRICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeIsNotNull() {
            addCriterion("AHEADSETTLEPRICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeEqualTo(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE =", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeNotEqualTo(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE <>", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeGreaterThan(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE >", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE >=", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeLessThan(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE <", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeLessThanOrEqualTo(Short value) {
            addCriterion("AHEADSETTLEPRICETYPE <=", value, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeIn(List<Short> values) {
            addCriterion("AHEADSETTLEPRICETYPE in", values, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeNotIn(List<Short> values) {
            addCriterion("AHEADSETTLEPRICETYPE not in", values, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeBetween(Short value1, Short value2) {
            addCriterion("AHEADSETTLEPRICETYPE between", value1, value2, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andAheadsettlepricetypeNotBetween(Short value1, Short value2) {
            addCriterion("AHEADSETTLEPRICETYPE not between", value1, value2, "aheadsettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeIsNull() {
            addCriterion("DELAYSETTLEPRICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeIsNotNull() {
            addCriterion("DELAYSETTLEPRICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeEqualTo(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE =", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeNotEqualTo(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE <>", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeGreaterThan(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE >", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE >=", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeLessThan(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE <", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeLessThanOrEqualTo(Short value) {
            addCriterion("DELAYSETTLEPRICETYPE <=", value, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeIn(List<Short> values) {
            addCriterion("DELAYSETTLEPRICETYPE in", values, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeNotIn(List<Short> values) {
            addCriterion("DELAYSETTLEPRICETYPE not in", values, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeBetween(Short value1, Short value2) {
            addCriterion("DELAYSETTLEPRICETYPE between", value1, value2, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andDelaysettlepricetypeNotBetween(Short value1, Short value2) {
            addCriterion("DELAYSETTLEPRICETYPE not between", value1, value2, "delaysettlepricetype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeIsNull() {
            addCriterion("SETTLEMARGINTYPE is null");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeIsNotNull() {
            addCriterion("SETTLEMARGINTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeEqualTo(Short value) {
            addCriterion("SETTLEMARGINTYPE =", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeNotEqualTo(Short value) {
            addCriterion("SETTLEMARGINTYPE <>", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeGreaterThan(Short value) {
            addCriterion("SETTLEMARGINTYPE >", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINTYPE >=", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeLessThan(Short value) {
            addCriterion("SETTLEMARGINTYPE <", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeLessThanOrEqualTo(Short value) {
            addCriterion("SETTLEMARGINTYPE <=", value, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeIn(List<Short> values) {
            addCriterion("SETTLEMARGINTYPE in", values, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeNotIn(List<Short> values) {
            addCriterion("SETTLEMARGINTYPE not in", values, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINTYPE between", value1, value2, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andSettlemargintypeNotBetween(Short value1, Short value2) {
            addCriterion("SETTLEMARGINTYPE not between", value1, value2, "settlemargintype");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMIsNull() {
            addCriterion("BEFOREDAYS_M is null");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMIsNotNull() {
            addCriterion("BEFOREDAYS_M is not null");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMEqualTo(Short value) {
            addCriterion("BEFOREDAYS_M =", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMNotEqualTo(Short value) {
            addCriterion("BEFOREDAYS_M <>", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMGreaterThan(Short value) {
            addCriterion("BEFOREDAYS_M >", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMGreaterThanOrEqualTo(Short value) {
            addCriterion("BEFOREDAYS_M >=", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMLessThan(Short value) {
            addCriterion("BEFOREDAYS_M <", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMLessThanOrEqualTo(Short value) {
            addCriterion("BEFOREDAYS_M <=", value, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMIn(List<Short> values) {
            addCriterion("BEFOREDAYS_M in", values, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMNotIn(List<Short> values) {
            addCriterion("BEFOREDAYS_M not in", values, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMBetween(Short value1, Short value2) {
            addCriterion("BEFOREDAYS_M between", value1, value2, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andBeforedaysMNotBetween(Short value1, Short value2) {
            addCriterion("BEFOREDAYS_M not between", value1, value2, "beforedaysM");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyIsNull() {
            addCriterion("SIDEHOLDLIMITQTY is null");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyIsNotNull() {
            addCriterion("SIDEHOLDLIMITQTY is not null");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyEqualTo(Long value) {
            addCriterion("SIDEHOLDLIMITQTY =", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyNotEqualTo(Long value) {
            addCriterion("SIDEHOLDLIMITQTY <>", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyGreaterThan(Long value) {
            addCriterion("SIDEHOLDLIMITQTY >", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("SIDEHOLDLIMITQTY >=", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyLessThan(Long value) {
            addCriterion("SIDEHOLDLIMITQTY <", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyLessThanOrEqualTo(Long value) {
            addCriterion("SIDEHOLDLIMITQTY <=", value, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyIn(List<Long> values) {
            addCriterion("SIDEHOLDLIMITQTY in", values, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyNotIn(List<Long> values) {
            addCriterion("SIDEHOLDLIMITQTY not in", values, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyBetween(Long value1, Long value2) {
            addCriterion("SIDEHOLDLIMITQTY between", value1, value2, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andSideholdlimitqtyNotBetween(Long value1, Long value2) {
            addCriterion("SIDEHOLDLIMITQTY not between", value1, value2, "sideholdlimitqty");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitIsNull() {
            addCriterion("HOLDDAYSLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitIsNotNull() {
            addCriterion("HOLDDAYSLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitEqualTo(Short value) {
            addCriterion("HOLDDAYSLIMIT =", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitNotEqualTo(Short value) {
            addCriterion("HOLDDAYSLIMIT <>", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitGreaterThan(Short value) {
            addCriterion("HOLDDAYSLIMIT >", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitGreaterThanOrEqualTo(Short value) {
            addCriterion("HOLDDAYSLIMIT >=", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitLessThan(Short value) {
            addCriterion("HOLDDAYSLIMIT <", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitLessThanOrEqualTo(Short value) {
            addCriterion("HOLDDAYSLIMIT <=", value, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitIn(List<Short> values) {
            addCriterion("HOLDDAYSLIMIT in", values, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitNotIn(List<Short> values) {
            addCriterion("HOLDDAYSLIMIT not in", values, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitBetween(Short value1, Short value2) {
            addCriterion("HOLDDAYSLIMIT between", value1, value2, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andHolddayslimitNotBetween(Short value1, Short value2) {
            addCriterion("HOLDDAYSLIMIT not between", value1, value2, "holddayslimit");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayIsNull() {
            addCriterion("MAXHOLDPOSITIONDAY is null");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayIsNotNull() {
            addCriterion("MAXHOLDPOSITIONDAY is not null");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayEqualTo(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY =", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayNotEqualTo(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY <>", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayGreaterThan(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY >", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayGreaterThanOrEqualTo(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY >=", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayLessThan(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY <", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayLessThanOrEqualTo(Long value) {
            addCriterion("MAXHOLDPOSITIONDAY <=", value, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayIn(List<Long> values) {
            addCriterion("MAXHOLDPOSITIONDAY in", values, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayNotIn(List<Long> values) {
            addCriterion("MAXHOLDPOSITIONDAY not in", values, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayBetween(Long value1, Long value2) {
            addCriterion("MAXHOLDPOSITIONDAY between", value1, value2, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andMaxholdpositiondayNotBetween(Long value1, Long value2) {
            addCriterion("MAXHOLDPOSITIONDAY not between", value1, value2, "maxholdpositionday");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveIsNull() {
            addCriterion("TAXINCLUSIVE is null");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveIsNotNull() {
            addCriterion("TAXINCLUSIVE is not null");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveEqualTo(Short value) {
            addCriterion("TAXINCLUSIVE =", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveNotEqualTo(Short value) {
            addCriterion("TAXINCLUSIVE <>", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveGreaterThan(Short value) {
            addCriterion("TAXINCLUSIVE >", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveGreaterThanOrEqualTo(Short value) {
            addCriterion("TAXINCLUSIVE >=", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveLessThan(Short value) {
            addCriterion("TAXINCLUSIVE <", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveLessThanOrEqualTo(Short value) {
            addCriterion("TAXINCLUSIVE <=", value, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveIn(List<Short> values) {
            addCriterion("TAXINCLUSIVE in", values, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveNotIn(List<Short> values) {
            addCriterion("TAXINCLUSIVE not in", values, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveBetween(Short value1, Short value2) {
            addCriterion("TAXINCLUSIVE between", value1, value2, "taxinclusive");
            return (Criteria) this;
        }

        public Criteria andTaxinclusiveNotBetween(Short value1, Short value2) {
            addCriterion("TAXINCLUSIVE not between", value1, value2, "taxinclusive");
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