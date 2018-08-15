package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoneyDetailVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoneyDetailVOExample() {
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

        public Criteria andDbilldateIsNull() {
            addCriterion("DBILLDATE is null");
            return (Criteria) this;
        }

        public Criteria andDbilldateIsNotNull() {
            addCriterion("DBILLDATE is not null");
            return (Criteria) this;
        }

        public Criteria andDbilldateEqualTo(String value) {
            addCriterion("DBILLDATE =", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateNotEqualTo(String value) {
            addCriterion("DBILLDATE <>", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateGreaterThan(String value) {
            addCriterion("DBILLDATE >", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateGreaterThanOrEqualTo(String value) {
            addCriterion("DBILLDATE >=", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateLessThan(String value) {
            addCriterion("DBILLDATE <", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateLessThanOrEqualTo(String value) {
            addCriterion("DBILLDATE <=", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateLike(String value) {
            addCriterion("DBILLDATE like", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateNotLike(String value) {
            addCriterion("DBILLDATE not like", value, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateIn(List<String> values) {
            addCriterion("DBILLDATE in", values, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateNotIn(List<String> values) {
            addCriterion("DBILLDATE not in", values, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateBetween(String value1, String value2) {
            addCriterion("DBILLDATE between", value1, value2, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDbilldateNotBetween(String value1, String value2) {
            addCriterion("DBILLDATE not between", value1, value2, "dbilldate");
            return (Criteria) this;
        }

        public Criteria andDdhIsNull() {
            addCriterion("DDH is null");
            return (Criteria) this;
        }

        public Criteria andDdhIsNotNull() {
            addCriterion("DDH is not null");
            return (Criteria) this;
        }

        public Criteria andDdhEqualTo(String value) {
            addCriterion("DDH =", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhNotEqualTo(String value) {
            addCriterion("DDH <>", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhGreaterThan(String value) {
            addCriterion("DDH >", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhGreaterThanOrEqualTo(String value) {
            addCriterion("DDH >=", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhLessThan(String value) {
            addCriterion("DDH <", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhLessThanOrEqualTo(String value) {
            addCriterion("DDH <=", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhLike(String value) {
            addCriterion("DDH like", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhNotLike(String value) {
            addCriterion("DDH not like", value, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhIn(List<String> values) {
            addCriterion("DDH in", values, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhNotIn(List<String> values) {
            addCriterion("DDH not in", values, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhBetween(String value1, String value2) {
            addCriterion("DDH between", value1, value2, "ddh");
            return (Criteria) this;
        }

        public Criteria andDdhNotBetween(String value1, String value2) {
            addCriterion("DDH not between", value1, value2, "ddh");
            return (Criteria) this;
        }

        public Criteria andBahIsNull() {
            addCriterion("BAH is null");
            return (Criteria) this;
        }

        public Criteria andBahIsNotNull() {
            addCriterion("BAH is not null");
            return (Criteria) this;
        }

        public Criteria andBahEqualTo(String value) {
            addCriterion("BAH =", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahNotEqualTo(String value) {
            addCriterion("BAH <>", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahGreaterThan(String value) {
            addCriterion("BAH >", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahGreaterThanOrEqualTo(String value) {
            addCriterion("BAH >=", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahLessThan(String value) {
            addCriterion("BAH <", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahLessThanOrEqualTo(String value) {
            addCriterion("BAH <=", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahLike(String value) {
            addCriterion("BAH like", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahNotLike(String value) {
            addCriterion("BAH not like", value, "bah");
            return (Criteria) this;
        }

        public Criteria andBahIn(List<String> values) {
            addCriterion("BAH in", values, "bah");
            return (Criteria) this;
        }

        public Criteria andBahNotIn(List<String> values) {
            addCriterion("BAH not in", values, "bah");
            return (Criteria) this;
        }

        public Criteria andBahBetween(String value1, String value2) {
            addCriterion("BAH between", value1, value2, "bah");
            return (Criteria) this;
        }

        public Criteria andBahNotBetween(String value1, String value2) {
            addCriterion("BAH not between", value1, value2, "bah");
            return (Criteria) this;
        }

        public Criteria andFpzjeIsNull() {
            addCriterion("FPZJE is null");
            return (Criteria) this;
        }

        public Criteria andFpzjeIsNotNull() {
            addCriterion("FPZJE is not null");
            return (Criteria) this;
        }

        public Criteria andFpzjeEqualTo(BigDecimal value) {
            addCriterion("FPZJE =", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeNotEqualTo(BigDecimal value) {
            addCriterion("FPZJE <>", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeGreaterThan(BigDecimal value) {
            addCriterion("FPZJE >", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FPZJE >=", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeLessThan(BigDecimal value) {
            addCriterion("FPZJE <", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FPZJE <=", value, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeIn(List<BigDecimal> values) {
            addCriterion("FPZJE in", values, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeNotIn(List<BigDecimal> values) {
            addCriterion("FPZJE not in", values, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPZJE between", value1, value2, "fpzje");
            return (Criteria) this;
        }

        public Criteria andFpzjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPZJE not between", value1, value2, "fpzje");
            return (Criteria) this;
        }

        public Criteria andSkjeIsNull() {
            addCriterion("SKJE is null");
            return (Criteria) this;
        }

        public Criteria andSkjeIsNotNull() {
            addCriterion("SKJE is not null");
            return (Criteria) this;
        }

        public Criteria andSkjeEqualTo(BigDecimal value) {
            addCriterion("SKJE =", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeNotEqualTo(BigDecimal value) {
            addCriterion("SKJE <>", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeGreaterThan(BigDecimal value) {
            addCriterion("SKJE >", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SKJE >=", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeLessThan(BigDecimal value) {
            addCriterion("SKJE <", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SKJE <=", value, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeIn(List<BigDecimal> values) {
            addCriterion("SKJE in", values, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeNotIn(List<BigDecimal> values) {
            addCriterion("SKJE not in", values, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SKJE between", value1, value2, "skje");
            return (Criteria) this;
        }

        public Criteria andSkjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SKJE not between", value1, value2, "skje");
            return (Criteria) this;
        }

        public Criteria andWkIsNull() {
            addCriterion("WK is null");
            return (Criteria) this;
        }

        public Criteria andWkIsNotNull() {
            addCriterion("WK is not null");
            return (Criteria) this;
        }

        public Criteria andWkEqualTo(BigDecimal value) {
            addCriterion("WK =", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkNotEqualTo(BigDecimal value) {
            addCriterion("WK <>", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkGreaterThan(BigDecimal value) {
            addCriterion("WK >", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WK >=", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkLessThan(BigDecimal value) {
            addCriterion("WK <", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WK <=", value, "wk");
            return (Criteria) this;
        }

        public Criteria andWkIn(List<BigDecimal> values) {
            addCriterion("WK in", values, "wk");
            return (Criteria) this;
        }

        public Criteria andWkNotIn(List<BigDecimal> values) {
            addCriterion("WK not in", values, "wk");
            return (Criteria) this;
        }

        public Criteria andWkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WK between", value1, value2, "wk");
            return (Criteria) this;
        }

        public Criteria andWkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WK not between", value1, value2, "wk");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyIsNull() {
            addCriterion("RNRECEIVEDMNY is null");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyIsNotNull() {
            addCriterion("RNRECEIVEDMNY is not null");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyEqualTo(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY =", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyNotEqualTo(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY <>", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyGreaterThan(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY >", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY >=", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyLessThan(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY <", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RNRECEIVEDMNY <=", value, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyIn(List<BigDecimal> values) {
            addCriterion("RNRECEIVEDMNY in", values, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyNotIn(List<BigDecimal> values) {
            addCriterion("RNRECEIVEDMNY not in", values, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RNRECEIVEDMNY between", value1, value2, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andRnreceivedmnyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RNRECEIVEDMNY not between", value1, value2, "rnreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyIsNull() {
            addCriterion("INRECEIVEDMNY is null");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyIsNotNull() {
            addCriterion("INRECEIVEDMNY is not null");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyEqualTo(BigDecimal value) {
            addCriterion("INRECEIVEDMNY =", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyNotEqualTo(BigDecimal value) {
            addCriterion("INRECEIVEDMNY <>", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyGreaterThan(BigDecimal value) {
            addCriterion("INRECEIVEDMNY >", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INRECEIVEDMNY >=", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyLessThan(BigDecimal value) {
            addCriterion("INRECEIVEDMNY <", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INRECEIVEDMNY <=", value, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyIn(List<BigDecimal> values) {
            addCriterion("INRECEIVEDMNY in", values, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyNotIn(List<BigDecimal> values) {
            addCriterion("INRECEIVEDMNY not in", values, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INRECEIVEDMNY between", value1, value2, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andInreceivedmnyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INRECEIVEDMNY not between", value1, value2, "inreceivedmny");
            return (Criteria) this;
        }

        public Criteria andFphIsNull() {
            addCriterion("FPH is null");
            return (Criteria) this;
        }

        public Criteria andFphIsNotNull() {
            addCriterion("FPH is not null");
            return (Criteria) this;
        }

        public Criteria andFphEqualTo(String value) {
            addCriterion("FPH =", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphNotEqualTo(String value) {
            addCriterion("FPH <>", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphGreaterThan(String value) {
            addCriterion("FPH >", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphGreaterThanOrEqualTo(String value) {
            addCriterion("FPH >=", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphLessThan(String value) {
            addCriterion("FPH <", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphLessThanOrEqualTo(String value) {
            addCriterion("FPH <=", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphLike(String value) {
            addCriterion("FPH like", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphNotLike(String value) {
            addCriterion("FPH not like", value, "fph");
            return (Criteria) this;
        }

        public Criteria andFphIn(List<String> values) {
            addCriterion("FPH in", values, "fph");
            return (Criteria) this;
        }

        public Criteria andFphNotIn(List<String> values) {
            addCriterion("FPH not in", values, "fph");
            return (Criteria) this;
        }

        public Criteria andFphBetween(String value1, String value2) {
            addCriterion("FPH between", value1, value2, "fph");
            return (Criteria) this;
        }

        public Criteria andFphNotBetween(String value1, String value2) {
            addCriterion("FPH not between", value1, value2, "fph");
            return (Criteria) this;
        }

        public Criteria andCdeptIsNull() {
            addCriterion("CDEPT is null");
            return (Criteria) this;
        }

        public Criteria andCdeptIsNotNull() {
            addCriterion("CDEPT is not null");
            return (Criteria) this;
        }

        public Criteria andCdeptEqualTo(String value) {
            addCriterion("CDEPT =", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptNotEqualTo(String value) {
            addCriterion("CDEPT <>", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptGreaterThan(String value) {
            addCriterion("CDEPT >", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptGreaterThanOrEqualTo(String value) {
            addCriterion("CDEPT >=", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptLessThan(String value) {
            addCriterion("CDEPT <", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptLessThanOrEqualTo(String value) {
            addCriterion("CDEPT <=", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptLike(String value) {
            addCriterion("CDEPT like", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptNotLike(String value) {
            addCriterion("CDEPT not like", value, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptIn(List<String> values) {
            addCriterion("CDEPT in", values, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptNotIn(List<String> values) {
            addCriterion("CDEPT not in", values, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptBetween(String value1, String value2) {
            addCriterion("CDEPT between", value1, value2, "cdept");
            return (Criteria) this;
        }

        public Criteria andCdeptNotBetween(String value1, String value2) {
            addCriterion("CDEPT not between", value1, value2, "cdept");
            return (Criteria) this;
        }

        public Criteria andBillmakerIsNull() {
            addCriterion("BILLMAKER is null");
            return (Criteria) this;
        }

        public Criteria andBillmakerIsNotNull() {
            addCriterion("BILLMAKER is not null");
            return (Criteria) this;
        }

        public Criteria andBillmakerEqualTo(String value) {
            addCriterion("BILLMAKER =", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerNotEqualTo(String value) {
            addCriterion("BILLMAKER <>", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerGreaterThan(String value) {
            addCriterion("BILLMAKER >", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerGreaterThanOrEqualTo(String value) {
            addCriterion("BILLMAKER >=", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerLessThan(String value) {
            addCriterion("BILLMAKER <", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerLessThanOrEqualTo(String value) {
            addCriterion("BILLMAKER <=", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerLike(String value) {
            addCriterion("BILLMAKER like", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerNotLike(String value) {
            addCriterion("BILLMAKER not like", value, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerIn(List<String> values) {
            addCriterion("BILLMAKER in", values, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerNotIn(List<String> values) {
            addCriterion("BILLMAKER not in", values, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerBetween(String value1, String value2) {
            addCriterion("BILLMAKER between", value1, value2, "billmaker");
            return (Criteria) this;
        }

        public Criteria andBillmakerNotBetween(String value1, String value2) {
            addCriterion("BILLMAKER not between", value1, value2, "billmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerIsNull() {
            addCriterion("SOHBILLMAKER is null");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerIsNotNull() {
            addCriterion("SOHBILLMAKER is not null");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerEqualTo(String value) {
            addCriterion("SOHBILLMAKER =", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerNotEqualTo(String value) {
            addCriterion("SOHBILLMAKER <>", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerGreaterThan(String value) {
            addCriterion("SOHBILLMAKER >", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerGreaterThanOrEqualTo(String value) {
            addCriterion("SOHBILLMAKER >=", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerLessThan(String value) {
            addCriterion("SOHBILLMAKER <", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerLessThanOrEqualTo(String value) {
            addCriterion("SOHBILLMAKER <=", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerLike(String value) {
            addCriterion("SOHBILLMAKER like", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerNotLike(String value) {
            addCriterion("SOHBILLMAKER not like", value, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerIn(List<String> values) {
            addCriterion("SOHBILLMAKER in", values, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerNotIn(List<String> values) {
            addCriterion("SOHBILLMAKER not in", values, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerBetween(String value1, String value2) {
            addCriterion("SOHBILLMAKER between", value1, value2, "sohbillmaker");
            return (Criteria) this;
        }

        public Criteria andSohbillmakerNotBetween(String value1, String value2) {
            addCriterion("SOHBILLMAKER not between", value1, value2, "sohbillmaker");
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