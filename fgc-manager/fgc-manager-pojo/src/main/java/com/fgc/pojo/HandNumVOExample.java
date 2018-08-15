package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HandNumVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HandNumVOExample() {
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

        public Criteria andCmaterialIsNull() {
            addCriterion("CMATERIAL is null");
            return (Criteria) this;
        }

        public Criteria andCmaterialIsNotNull() {
            addCriterion("CMATERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andCmaterialEqualTo(String value) {
            addCriterion("CMATERIAL =", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialNotEqualTo(String value) {
            addCriterion("CMATERIAL <>", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialGreaterThan(String value) {
            addCriterion("CMATERIAL >", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialGreaterThanOrEqualTo(String value) {
            addCriterion("CMATERIAL >=", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialLessThan(String value) {
            addCriterion("CMATERIAL <", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialLessThanOrEqualTo(String value) {
            addCriterion("CMATERIAL <=", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialLike(String value) {
            addCriterion("CMATERIAL like", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialNotLike(String value) {
            addCriterion("CMATERIAL not like", value, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialIn(List<String> values) {
            addCriterion("CMATERIAL in", values, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialNotIn(List<String> values) {
            addCriterion("CMATERIAL not in", values, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialBetween(String value1, String value2) {
            addCriterion("CMATERIAL between", value1, value2, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCmaterialNotBetween(String value1, String value2) {
            addCriterion("CMATERIAL not between", value1, value2, "cmaterial");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidIsNull() {
            addCriterion("CWAREHOUSEID is null");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidIsNotNull() {
            addCriterion("CWAREHOUSEID is not null");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidEqualTo(String value) {
            addCriterion("CWAREHOUSEID =", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidNotEqualTo(String value) {
            addCriterion("CWAREHOUSEID <>", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidGreaterThan(String value) {
            addCriterion("CWAREHOUSEID >", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidGreaterThanOrEqualTo(String value) {
            addCriterion("CWAREHOUSEID >=", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidLessThan(String value) {
            addCriterion("CWAREHOUSEID <", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidLessThanOrEqualTo(String value) {
            addCriterion("CWAREHOUSEID <=", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidLike(String value) {
            addCriterion("CWAREHOUSEID like", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidNotLike(String value) {
            addCriterion("CWAREHOUSEID not like", value, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidIn(List<String> values) {
            addCriterion("CWAREHOUSEID in", values, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidNotIn(List<String> values) {
            addCriterion("CWAREHOUSEID not in", values, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidBetween(String value1, String value2) {
            addCriterion("CWAREHOUSEID between", value1, value2, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andCwarehouseidNotBetween(String value1, String value2) {
            addCriterion("CWAREHOUSEID not between", value1, value2, "cwarehouseid");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeIsNull() {
            addCriterion("VBATCHCODE is null");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeIsNotNull() {
            addCriterion("VBATCHCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeEqualTo(String value) {
            addCriterion("VBATCHCODE =", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeNotEqualTo(String value) {
            addCriterion("VBATCHCODE <>", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeGreaterThan(String value) {
            addCriterion("VBATCHCODE >", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VBATCHCODE >=", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeLessThan(String value) {
            addCriterion("VBATCHCODE <", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeLessThanOrEqualTo(String value) {
            addCriterion("VBATCHCODE <=", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeLike(String value) {
            addCriterion("VBATCHCODE like", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeNotLike(String value) {
            addCriterion("VBATCHCODE not like", value, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeIn(List<String> values) {
            addCriterion("VBATCHCODE in", values, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeNotIn(List<String> values) {
            addCriterion("VBATCHCODE not in", values, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeBetween(String value1, String value2) {
            addCriterion("VBATCHCODE between", value1, value2, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andVbatchcodeNotBetween(String value1, String value2) {
            addCriterion("VBATCHCODE not between", value1, value2, "vbatchcode");
            return (Criteria) this;
        }

        public Criteria andNastnumIsNull() {
            addCriterion("NASTNUM is null");
            return (Criteria) this;
        }

        public Criteria andNastnumIsNotNull() {
            addCriterion("NASTNUM is not null");
            return (Criteria) this;
        }

        public Criteria andNastnumEqualTo(BigDecimal value) {
            addCriterion("NASTNUM =", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumNotEqualTo(BigDecimal value) {
            addCriterion("NASTNUM <>", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumGreaterThan(BigDecimal value) {
            addCriterion("NASTNUM >", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NASTNUM >=", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumLessThan(BigDecimal value) {
            addCriterion("NASTNUM <", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NASTNUM <=", value, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumIn(List<BigDecimal> values) {
            addCriterion("NASTNUM in", values, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumNotIn(List<BigDecimal> values) {
            addCriterion("NASTNUM not in", values, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NASTNUM between", value1, value2, "nastnum");
            return (Criteria) this;
        }

        public Criteria andNastnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NASTNUM not between", value1, value2, "nastnum");
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