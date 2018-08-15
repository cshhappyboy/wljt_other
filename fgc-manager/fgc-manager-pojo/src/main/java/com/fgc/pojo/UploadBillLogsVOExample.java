package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UploadBillLogsVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UploadBillLogsVOExample() {
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

        public Criteria andExecutetimeIsNull() {
            addCriterion("EXECUTETIME is null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNotNull() {
            addCriterion("EXECUTETIME is not null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeEqualTo(String value) {
            addCriterion("EXECUTETIME =", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotEqualTo(String value) {
            addCriterion("EXECUTETIME <>", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThan(String value) {
            addCriterion("EXECUTETIME >", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTETIME >=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThan(String value) {
            addCriterion("EXECUTETIME <", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThanOrEqualTo(String value) {
            addCriterion("EXECUTETIME <=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLike(String value) {
            addCriterion("EXECUTETIME like", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotLike(String value) {
            addCriterion("EXECUTETIME not like", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIn(List<String> values) {
            addCriterion("EXECUTETIME in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotIn(List<String> values) {
            addCriterion("EXECUTETIME not in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeBetween(String value1, String value2) {
            addCriterion("EXECUTETIME between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotBetween(String value1, String value2) {
            addCriterion("EXECUTETIME not between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andVdef1IsNull() {
            addCriterion("VDEF1 is null");
            return (Criteria) this;
        }

        public Criteria andVdef1IsNotNull() {
            addCriterion("VDEF1 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef1EqualTo(String value) {
            addCriterion("VDEF1 =", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1NotEqualTo(String value) {
            addCriterion("VDEF1 <>", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1GreaterThan(String value) {
            addCriterion("VDEF1 >", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF1 >=", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1LessThan(String value) {
            addCriterion("VDEF1 <", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1LessThanOrEqualTo(String value) {
            addCriterion("VDEF1 <=", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1Like(String value) {
            addCriterion("VDEF1 like", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1NotLike(String value) {
            addCriterion("VDEF1 not like", value, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1In(List<String> values) {
            addCriterion("VDEF1 in", values, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1NotIn(List<String> values) {
            addCriterion("VDEF1 not in", values, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1Between(String value1, String value2) {
            addCriterion("VDEF1 between", value1, value2, "vdef1");
            return (Criteria) this;
        }

        public Criteria andVdef1NotBetween(String value1, String value2) {
            addCriterion("VDEF1 not between", value1, value2, "vdef1");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeIsNull() {
            addCriterion("NOTESVBILLCODE is null");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeIsNotNull() {
            addCriterion("NOTESVBILLCODE is not null");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeEqualTo(String value) {
            addCriterion("NOTESVBILLCODE =", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeNotEqualTo(String value) {
            addCriterion("NOTESVBILLCODE <>", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeGreaterThan(String value) {
            addCriterion("NOTESVBILLCODE >", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTESVBILLCODE >=", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeLessThan(String value) {
            addCriterion("NOTESVBILLCODE <", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeLessThanOrEqualTo(String value) {
            addCriterion("NOTESVBILLCODE <=", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeLike(String value) {
            addCriterion("NOTESVBILLCODE like", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeNotLike(String value) {
            addCriterion("NOTESVBILLCODE not like", value, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeIn(List<String> values) {
            addCriterion("NOTESVBILLCODE in", values, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeNotIn(List<String> values) {
            addCriterion("NOTESVBILLCODE not in", values, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeBetween(String value1, String value2) {
            addCriterion("NOTESVBILLCODE between", value1, value2, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andNotesvbillcodeNotBetween(String value1, String value2) {
            addCriterion("NOTESVBILLCODE not between", value1, value2, "notesvbillcode");
            return (Criteria) this;
        }

        public Criteria andVdef2IsNull() {
            addCriterion("VDEF2 is null");
            return (Criteria) this;
        }

        public Criteria andVdef2IsNotNull() {
            addCriterion("VDEF2 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef2EqualTo(String value) {
            addCriterion("VDEF2 =", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2NotEqualTo(String value) {
            addCriterion("VDEF2 <>", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2GreaterThan(String value) {
            addCriterion("VDEF2 >", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF2 >=", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2LessThan(String value) {
            addCriterion("VDEF2 <", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2LessThanOrEqualTo(String value) {
            addCriterion("VDEF2 <=", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2Like(String value) {
            addCriterion("VDEF2 like", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2NotLike(String value) {
            addCriterion("VDEF2 not like", value, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2In(List<String> values) {
            addCriterion("VDEF2 in", values, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2NotIn(List<String> values) {
            addCriterion("VDEF2 not in", values, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2Between(String value1, String value2) {
            addCriterion("VDEF2 between", value1, value2, "vdef2");
            return (Criteria) this;
        }

        public Criteria andVdef2NotBetween(String value1, String value2) {
            addCriterion("VDEF2 not between", value1, value2, "vdef2");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("UPLOADTIME is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("UPLOADTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(String value) {
            addCriterion("UPLOADTIME =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(String value) {
            addCriterion("UPLOADTIME <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(String value) {
            addCriterion("UPLOADTIME >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOADTIME >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(String value) {
            addCriterion("UPLOADTIME <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(String value) {
            addCriterion("UPLOADTIME <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLike(String value) {
            addCriterion("UPLOADTIME like", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotLike(String value) {
            addCriterion("UPLOADTIME not like", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<String> values) {
            addCriterion("UPLOADTIME in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<String> values) {
            addCriterion("UPLOADTIME not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(String value1, String value2) {
            addCriterion("UPLOADTIME between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(String value1, String value2) {
            addCriterion("UPLOADTIME not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andIssuccessIsNull() {
            addCriterion("ISSUCCESS is null");
            return (Criteria) this;
        }

        public Criteria andIssuccessIsNotNull() {
            addCriterion("ISSUCCESS is not null");
            return (Criteria) this;
        }

        public Criteria andIssuccessEqualTo(String value) {
            addCriterion("ISSUCCESS =", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotEqualTo(String value) {
            addCriterion("ISSUCCESS <>", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessGreaterThan(String value) {
            addCriterion("ISSUCCESS >", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessGreaterThanOrEqualTo(String value) {
            addCriterion("ISSUCCESS >=", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessLessThan(String value) {
            addCriterion("ISSUCCESS <", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessLessThanOrEqualTo(String value) {
            addCriterion("ISSUCCESS <=", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessLike(String value) {
            addCriterion("ISSUCCESS like", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotLike(String value) {
            addCriterion("ISSUCCESS not like", value, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessIn(List<String> values) {
            addCriterion("ISSUCCESS in", values, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotIn(List<String> values) {
            addCriterion("ISSUCCESS not in", values, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessBetween(String value1, String value2) {
            addCriterion("ISSUCCESS between", value1, value2, "issuccess");
            return (Criteria) this;
        }

        public Criteria andIssuccessNotBetween(String value1, String value2) {
            addCriterion("ISSUCCESS not between", value1, value2, "issuccess");
            return (Criteria) this;
        }

        public Criteria andVdef3IsNull() {
            addCriterion("VDEF3 is null");
            return (Criteria) this;
        }

        public Criteria andVdef3IsNotNull() {
            addCriterion("VDEF3 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef3EqualTo(String value) {
            addCriterion("VDEF3 =", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3NotEqualTo(String value) {
            addCriterion("VDEF3 <>", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3GreaterThan(String value) {
            addCriterion("VDEF3 >", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF3 >=", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3LessThan(String value) {
            addCriterion("VDEF3 <", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3LessThanOrEqualTo(String value) {
            addCriterion("VDEF3 <=", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3Like(String value) {
            addCriterion("VDEF3 like", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3NotLike(String value) {
            addCriterion("VDEF3 not like", value, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3In(List<String> values) {
            addCriterion("VDEF3 in", values, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3NotIn(List<String> values) {
            addCriterion("VDEF3 not in", values, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3Between(String value1, String value2) {
            addCriterion("VDEF3 between", value1, value2, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef3NotBetween(String value1, String value2) {
            addCriterion("VDEF3 not between", value1, value2, "vdef3");
            return (Criteria) this;
        }

        public Criteria andVdef4IsNull() {
            addCriterion("VDEF4 is null");
            return (Criteria) this;
        }

        public Criteria andVdef4IsNotNull() {
            addCriterion("VDEF4 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef4EqualTo(String value) {
            addCriterion("VDEF4 =", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4NotEqualTo(String value) {
            addCriterion("VDEF4 <>", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4GreaterThan(String value) {
            addCriterion("VDEF4 >", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF4 >=", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4LessThan(String value) {
            addCriterion("VDEF4 <", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4LessThanOrEqualTo(String value) {
            addCriterion("VDEF4 <=", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4Like(String value) {
            addCriterion("VDEF4 like", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4NotLike(String value) {
            addCriterion("VDEF4 not like", value, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4In(List<String> values) {
            addCriterion("VDEF4 in", values, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4NotIn(List<String> values) {
            addCriterion("VDEF4 not in", values, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4Between(String value1, String value2) {
            addCriterion("VDEF4 between", value1, value2, "vdef4");
            return (Criteria) this;
        }

        public Criteria andVdef4NotBetween(String value1, String value2) {
            addCriterion("VDEF4 not between", value1, value2, "vdef4");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andVdef5IsNull() {
            addCriterion("VDEF5 is null");
            return (Criteria) this;
        }

        public Criteria andVdef5IsNotNull() {
            addCriterion("VDEF5 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef5EqualTo(String value) {
            addCriterion("VDEF5 =", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5NotEqualTo(String value) {
            addCriterion("VDEF5 <>", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5GreaterThan(String value) {
            addCriterion("VDEF5 >", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF5 >=", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5LessThan(String value) {
            addCriterion("VDEF5 <", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5LessThanOrEqualTo(String value) {
            addCriterion("VDEF5 <=", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5Like(String value) {
            addCriterion("VDEF5 like", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5NotLike(String value) {
            addCriterion("VDEF5 not like", value, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5In(List<String> values) {
            addCriterion("VDEF5 in", values, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5NotIn(List<String> values) {
            addCriterion("VDEF5 not in", values, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5Between(String value1, String value2) {
            addCriterion("VDEF5 between", value1, value2, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef5NotBetween(String value1, String value2) {
            addCriterion("VDEF5 not between", value1, value2, "vdef5");
            return (Criteria) this;
        }

        public Criteria andVdef6IsNull() {
            addCriterion("VDEF6 is null");
            return (Criteria) this;
        }

        public Criteria andVdef6IsNotNull() {
            addCriterion("VDEF6 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef6EqualTo(String value) {
            addCriterion("VDEF6 =", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6NotEqualTo(String value) {
            addCriterion("VDEF6 <>", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6GreaterThan(String value) {
            addCriterion("VDEF6 >", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF6 >=", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6LessThan(String value) {
            addCriterion("VDEF6 <", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6LessThanOrEqualTo(String value) {
            addCriterion("VDEF6 <=", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6Like(String value) {
            addCriterion("VDEF6 like", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6NotLike(String value) {
            addCriterion("VDEF6 not like", value, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6In(List<String> values) {
            addCriterion("VDEF6 in", values, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6NotIn(List<String> values) {
            addCriterion("VDEF6 not in", values, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6Between(String value1, String value2) {
            addCriterion("VDEF6 between", value1, value2, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef6NotBetween(String value1, String value2) {
            addCriterion("VDEF6 not between", value1, value2, "vdef6");
            return (Criteria) this;
        }

        public Criteria andVdef7IsNull() {
            addCriterion("VDEF7 is null");
            return (Criteria) this;
        }

        public Criteria andVdef7IsNotNull() {
            addCriterion("VDEF7 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef7EqualTo(String value) {
            addCriterion("VDEF7 =", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7NotEqualTo(String value) {
            addCriterion("VDEF7 <>", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7GreaterThan(String value) {
            addCriterion("VDEF7 >", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF7 >=", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7LessThan(String value) {
            addCriterion("VDEF7 <", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7LessThanOrEqualTo(String value) {
            addCriterion("VDEF7 <=", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7Like(String value) {
            addCriterion("VDEF7 like", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7NotLike(String value) {
            addCriterion("VDEF7 not like", value, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7In(List<String> values) {
            addCriterion("VDEF7 in", values, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7NotIn(List<String> values) {
            addCriterion("VDEF7 not in", values, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7Between(String value1, String value2) {
            addCriterion("VDEF7 between", value1, value2, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef7NotBetween(String value1, String value2) {
            addCriterion("VDEF7 not between", value1, value2, "vdef7");
            return (Criteria) this;
        }

        public Criteria andVdef8IsNull() {
            addCriterion("VDEF8 is null");
            return (Criteria) this;
        }

        public Criteria andVdef8IsNotNull() {
            addCriterion("VDEF8 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef8EqualTo(String value) {
            addCriterion("VDEF8 =", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8NotEqualTo(String value) {
            addCriterion("VDEF8 <>", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8GreaterThan(String value) {
            addCriterion("VDEF8 >", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF8 >=", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8LessThan(String value) {
            addCriterion("VDEF8 <", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8LessThanOrEqualTo(String value) {
            addCriterion("VDEF8 <=", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8Like(String value) {
            addCriterion("VDEF8 like", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8NotLike(String value) {
            addCriterion("VDEF8 not like", value, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8In(List<String> values) {
            addCriterion("VDEF8 in", values, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8NotIn(List<String> values) {
            addCriterion("VDEF8 not in", values, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8Between(String value1, String value2) {
            addCriterion("VDEF8 between", value1, value2, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef8NotBetween(String value1, String value2) {
            addCriterion("VDEF8 not between", value1, value2, "vdef8");
            return (Criteria) this;
        }

        public Criteria andVdef9IsNull() {
            addCriterion("VDEF9 is null");
            return (Criteria) this;
        }

        public Criteria andVdef9IsNotNull() {
            addCriterion("VDEF9 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef9EqualTo(String value) {
            addCriterion("VDEF9 =", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9NotEqualTo(String value) {
            addCriterion("VDEF9 <>", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9GreaterThan(String value) {
            addCriterion("VDEF9 >", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF9 >=", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9LessThan(String value) {
            addCriterion("VDEF9 <", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9LessThanOrEqualTo(String value) {
            addCriterion("VDEF9 <=", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9Like(String value) {
            addCriterion("VDEF9 like", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9NotLike(String value) {
            addCriterion("VDEF9 not like", value, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9In(List<String> values) {
            addCriterion("VDEF9 in", values, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9NotIn(List<String> values) {
            addCriterion("VDEF9 not in", values, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9Between(String value1, String value2) {
            addCriterion("VDEF9 between", value1, value2, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef9NotBetween(String value1, String value2) {
            addCriterion("VDEF9 not between", value1, value2, "vdef9");
            return (Criteria) this;
        }

        public Criteria andVdef10IsNull() {
            addCriterion("VDEF10 is null");
            return (Criteria) this;
        }

        public Criteria andVdef10IsNotNull() {
            addCriterion("VDEF10 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef10EqualTo(String value) {
            addCriterion("VDEF10 =", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10NotEqualTo(String value) {
            addCriterion("VDEF10 <>", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10GreaterThan(String value) {
            addCriterion("VDEF10 >", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF10 >=", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10LessThan(String value) {
            addCriterion("VDEF10 <", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10LessThanOrEqualTo(String value) {
            addCriterion("VDEF10 <=", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10Like(String value) {
            addCriterion("VDEF10 like", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10NotLike(String value) {
            addCriterion("VDEF10 not like", value, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10In(List<String> values) {
            addCriterion("VDEF10 in", values, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10NotIn(List<String> values) {
            addCriterion("VDEF10 not in", values, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10Between(String value1, String value2) {
            addCriterion("VDEF10 between", value1, value2, "vdef10");
            return (Criteria) this;
        }

        public Criteria andVdef10NotBetween(String value1, String value2) {
            addCriterion("VDEF10 not between", value1, value2, "vdef10");
            return (Criteria) this;
        }

        public Criteria andUploadbillIsNull() {
            addCriterion("UPLOADBILL is null");
            return (Criteria) this;
        }

        public Criteria andUploadbillIsNotNull() {
            addCriterion("UPLOADBILL is not null");
            return (Criteria) this;
        }

        public Criteria andUploadbillEqualTo(String value) {
            addCriterion("UPLOADBILL =", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillNotEqualTo(String value) {
            addCriterion("UPLOADBILL <>", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillGreaterThan(String value) {
            addCriterion("UPLOADBILL >", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOADBILL >=", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillLessThan(String value) {
            addCriterion("UPLOADBILL <", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillLessThanOrEqualTo(String value) {
            addCriterion("UPLOADBILL <=", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillLike(String value) {
            addCriterion("UPLOADBILL like", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillNotLike(String value) {
            addCriterion("UPLOADBILL not like", value, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillIn(List<String> values) {
            addCriterion("UPLOADBILL in", values, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillNotIn(List<String> values) {
            addCriterion("UPLOADBILL not in", values, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillBetween(String value1, String value2) {
            addCriterion("UPLOADBILL between", value1, value2, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadbillNotBetween(String value1, String value2) {
            addCriterion("UPLOADBILL not between", value1, value2, "uploadbill");
            return (Criteria) this;
        }

        public Criteria andUploadmodeIsNull() {
            addCriterion("UPLOADMODE is null");
            return (Criteria) this;
        }

        public Criteria andUploadmodeIsNotNull() {
            addCriterion("UPLOADMODE is not null");
            return (Criteria) this;
        }

        public Criteria andUploadmodeEqualTo(BigDecimal value) {
            addCriterion("UPLOADMODE =", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeNotEqualTo(BigDecimal value) {
            addCriterion("UPLOADMODE <>", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeGreaterThan(BigDecimal value) {
            addCriterion("UPLOADMODE >", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UPLOADMODE >=", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeLessThan(BigDecimal value) {
            addCriterion("UPLOADMODE <", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UPLOADMODE <=", value, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeIn(List<BigDecimal> values) {
            addCriterion("UPLOADMODE in", values, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeNotIn(List<BigDecimal> values) {
            addCriterion("UPLOADMODE not in", values, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPLOADMODE between", value1, value2, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadmodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPLOADMODE not between", value1, value2, "uploadmode");
            return (Criteria) this;
        }

        public Criteria andUploadcountIsNull() {
            addCriterion("UPLOADCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUploadcountIsNotNull() {
            addCriterion("UPLOADCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUploadcountEqualTo(Long value) {
            addCriterion("UPLOADCOUNT =", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountNotEqualTo(Long value) {
            addCriterion("UPLOADCOUNT <>", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountGreaterThan(Long value) {
            addCriterion("UPLOADCOUNT >", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountGreaterThanOrEqualTo(Long value) {
            addCriterion("UPLOADCOUNT >=", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountLessThan(Long value) {
            addCriterion("UPLOADCOUNT <", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountLessThanOrEqualTo(Long value) {
            addCriterion("UPLOADCOUNT <=", value, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountIn(List<Long> values) {
            addCriterion("UPLOADCOUNT in", values, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountNotIn(List<Long> values) {
            addCriterion("UPLOADCOUNT not in", values, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountBetween(Long value1, Long value2) {
            addCriterion("UPLOADCOUNT between", value1, value2, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andUploadcountNotBetween(Long value1, Long value2) {
            addCriterion("UPLOADCOUNT not between", value1, value2, "uploadcount");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeIsNull() {
            addCriterion("LASTUPLOADTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeIsNotNull() {
            addCriterion("LASTUPLOADTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeEqualTo(String value) {
            addCriterion("LASTUPLOADTIME =", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeNotEqualTo(String value) {
            addCriterion("LASTUPLOADTIME <>", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeGreaterThan(String value) {
            addCriterion("LASTUPLOADTIME >", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeGreaterThanOrEqualTo(String value) {
            addCriterion("LASTUPLOADTIME >=", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeLessThan(String value) {
            addCriterion("LASTUPLOADTIME <", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeLessThanOrEqualTo(String value) {
            addCriterion("LASTUPLOADTIME <=", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeLike(String value) {
            addCriterion("LASTUPLOADTIME like", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeNotLike(String value) {
            addCriterion("LASTUPLOADTIME not like", value, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeIn(List<String> values) {
            addCriterion("LASTUPLOADTIME in", values, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeNotIn(List<String> values) {
            addCriterion("LASTUPLOADTIME not in", values, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeBetween(String value1, String value2) {
            addCriterion("LASTUPLOADTIME between", value1, value2, "lastuploadtime");
            return (Criteria) this;
        }

        public Criteria andLastuploadtimeNotBetween(String value1, String value2) {
            addCriterion("LASTUPLOADTIME not between", value1, value2, "lastuploadtime");
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