package com.fgc.pojo;

import java.util.ArrayList;
import java.util.List;

public class BillCodeVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCodeVOExample() {
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

        public Criteria andBillflagIsNull() {
            addCriterion("BILLFLAG is null");
            return (Criteria) this;
        }

        public Criteria andBillflagIsNotNull() {
            addCriterion("BILLFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBillflagEqualTo(String value) {
            addCriterion("BILLFLAG =", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagNotEqualTo(String value) {
            addCriterion("BILLFLAG <>", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagGreaterThan(String value) {
            addCriterion("BILLFLAG >", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagGreaterThanOrEqualTo(String value) {
            addCriterion("BILLFLAG >=", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagLessThan(String value) {
            addCriterion("BILLFLAG <", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagLessThanOrEqualTo(String value) {
            addCriterion("BILLFLAG <=", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagLike(String value) {
            addCriterion("BILLFLAG like", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagNotLike(String value) {
            addCriterion("BILLFLAG not like", value, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagIn(List<String> values) {
            addCriterion("BILLFLAG in", values, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagNotIn(List<String> values) {
            addCriterion("BILLFLAG not in", values, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagBetween(String value1, String value2) {
            addCriterion("BILLFLAG between", value1, value2, "billflag");
            return (Criteria) this;
        }

        public Criteria andBillflagNotBetween(String value1, String value2) {
            addCriterion("BILLFLAG not between", value1, value2, "billflag");
            return (Criteria) this;
        }

        public Criteria andDtIsNull() {
            addCriterion("DT is null");
            return (Criteria) this;
        }

        public Criteria andDtIsNotNull() {
            addCriterion("DT is not null");
            return (Criteria) this;
        }

        public Criteria andDtEqualTo(String value) {
            addCriterion("DT =", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotEqualTo(String value) {
            addCriterion("DT <>", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThan(String value) {
            addCriterion("DT >", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThanOrEqualTo(String value) {
            addCriterion("DT >=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThan(String value) {
            addCriterion("DT <", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThanOrEqualTo(String value) {
            addCriterion("DT <=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLike(String value) {
            addCriterion("DT like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotLike(String value) {
            addCriterion("DT not like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtIn(List<String> values) {
            addCriterion("DT in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotIn(List<String> values) {
            addCriterion("DT not in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtBetween(String value1, String value2) {
            addCriterion("DT between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotBetween(String value1, String value2) {
            addCriterion("DT not between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andFlowIsNull() {
            addCriterion("FLOW is null");
            return (Criteria) this;
        }

        public Criteria andFlowIsNotNull() {
            addCriterion("FLOW is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEqualTo(Long value) {
            addCriterion("FLOW =", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotEqualTo(Long value) {
            addCriterion("FLOW <>", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThan(Long value) {
            addCriterion("FLOW >", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThanOrEqualTo(Long value) {
            addCriterion("FLOW >=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThan(Long value) {
            addCriterion("FLOW <", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThanOrEqualTo(Long value) {
            addCriterion("FLOW <=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowIn(List<Long> values) {
            addCriterion("FLOW in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotIn(List<Long> values) {
            addCriterion("FLOW not in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowBetween(Long value1, Long value2) {
            addCriterion("FLOW between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotBetween(Long value1, Long value2) {
            addCriterion("FLOW not between", value1, value2, "flow");
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