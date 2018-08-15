package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoneyVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoneyVOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andZhipiaoIsNull() {
            addCriterion("ZHIPIAO is null");
            return (Criteria) this;
        }

        public Criteria andZhipiaoIsNotNull() {
            addCriterion("ZHIPIAO is not null");
            return (Criteria) this;
        }

        public Criteria andZhipiaoEqualTo(BigDecimal value) {
            addCriterion("ZHIPIAO =", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoNotEqualTo(BigDecimal value) {
            addCriterion("ZHIPIAO <>", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoGreaterThan(BigDecimal value) {
            addCriterion("ZHIPIAO >", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZHIPIAO >=", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoLessThan(BigDecimal value) {
            addCriterion("ZHIPIAO <", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZHIPIAO <=", value, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoIn(List<BigDecimal> values) {
            addCriterion("ZHIPIAO in", values, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoNotIn(List<BigDecimal> values) {
            addCriterion("ZHIPIAO not in", values, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZHIPIAO between", value1, value2, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andZhipiaoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZHIPIAO not between", value1, value2, "zhipiao");
            return (Criteria) this;
        }

        public Criteria andXianjinIsNull() {
            addCriterion("XIANJIN is null");
            return (Criteria) this;
        }

        public Criteria andXianjinIsNotNull() {
            addCriterion("XIANJIN is not null");
            return (Criteria) this;
        }

        public Criteria andXianjinEqualTo(BigDecimal value) {
            addCriterion("XIANJIN =", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinNotEqualTo(BigDecimal value) {
            addCriterion("XIANJIN <>", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinGreaterThan(BigDecimal value) {
            addCriterion("XIANJIN >", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XIANJIN >=", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinLessThan(BigDecimal value) {
            addCriterion("XIANJIN <", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XIANJIN <=", value, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinIn(List<BigDecimal> values) {
            addCriterion("XIANJIN in", values, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinNotIn(List<BigDecimal> values) {
            addCriterion("XIANJIN not in", values, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XIANJIN between", value1, value2, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXianjinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XIANJIN not between", value1, value2, "xianjin");
            return (Criteria) this;
        }

        public Criteria andXiaojiIsNull() {
            addCriterion("XIAOJI is null");
            return (Criteria) this;
        }

        public Criteria andXiaojiIsNotNull() {
            addCriterion("XIAOJI is not null");
            return (Criteria) this;
        }

        public Criteria andXiaojiEqualTo(BigDecimal value) {
            addCriterion("XIAOJI =", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiNotEqualTo(BigDecimal value) {
            addCriterion("XIAOJI <>", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiGreaterThan(BigDecimal value) {
            addCriterion("XIAOJI >", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XIAOJI >=", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiLessThan(BigDecimal value) {
            addCriterion("XIAOJI <", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XIAOJI <=", value, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiIn(List<BigDecimal> values) {
            addCriterion("XIAOJI in", values, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiNotIn(List<BigDecimal> values) {
            addCriterion("XIAOJI not in", values, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XIAOJI between", value1, value2, "xiaoji");
            return (Criteria) this;
        }

        public Criteria andXiaojiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XIAOJI not between", value1, value2, "xiaoji");
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