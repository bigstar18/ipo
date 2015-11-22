package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IpoABreedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpoABreedExample() {
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

        public Criteria andTradetimeIsNull() {
            addCriterion("TRADETIME is null");
            return (Criteria) this;
        }

        public Criteria andTradetimeIsNotNull() {
            addCriterion("TRADETIME is not null");
            return (Criteria) this;
        }

        public Criteria andTradetimeEqualTo(Short value) {
            addCriterion("TRADETIME =", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotEqualTo(Short value) {
            addCriterion("TRADETIME <>", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThan(Short value) {
            addCriterion("TRADETIME >", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThanOrEqualTo(Short value) {
            addCriterion("TRADETIME >=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThan(Short value) {
            addCriterion("TRADETIME <", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThanOrEqualTo(Short value) {
            addCriterion("TRADETIME <=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeIn(List<Short> values) {
            addCriterion("TRADETIME in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotIn(List<Short> values) {
            addCriterion("TRADETIME not in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeBetween(Short value1, Short value2) {
            addCriterion("TRADETIME between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotBetween(Short value1, Short value2) {
            addCriterion("TRADETIME not between", value1, value2, "tradetime");
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

        public Criteria andContractcurrencyIsNull() {
            addCriterion("CONTRACTCURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyIsNotNull() {
            addCriterion("CONTRACTCURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyEqualTo(Short value) {
            addCriterion("CONTRACTCURRENCY =", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyNotEqualTo(Short value) {
            addCriterion("CONTRACTCURRENCY <>", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyGreaterThan(Short value) {
            addCriterion("CONTRACTCURRENCY >", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyGreaterThanOrEqualTo(Short value) {
            addCriterion("CONTRACTCURRENCY >=", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyLessThan(Short value) {
            addCriterion("CONTRACTCURRENCY <", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyLessThanOrEqualTo(Short value) {
            addCriterion("CONTRACTCURRENCY <=", value, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyIn(List<Short> values) {
            addCriterion("CONTRACTCURRENCY in", values, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyNotIn(List<Short> values) {
            addCriterion("CONTRACTCURRENCY not in", values, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyBetween(Short value1, Short value2) {
            addCriterion("CONTRACTCURRENCY between", value1, value2, "contractcurrency");
            return (Criteria) this;
        }

        public Criteria andContractcurrencyNotBetween(Short value1, Short value2) {
            addCriterion("CONTRACTCURRENCY not between", value1, value2, "contractcurrency");
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