package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptHVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReceiptHVOExample() {
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

        public Criteria andPkGroupIsNull() {
            addCriterion("PK_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andPkGroupIsNotNull() {
            addCriterion("PK_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andPkGroupEqualTo(String value) {
            addCriterion("PK_GROUP =", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupNotEqualTo(String value) {
            addCriterion("PK_GROUP <>", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupGreaterThan(String value) {
            addCriterion("PK_GROUP >", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupGreaterThanOrEqualTo(String value) {
            addCriterion("PK_GROUP >=", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupLessThan(String value) {
            addCriterion("PK_GROUP <", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupLessThanOrEqualTo(String value) {
            addCriterion("PK_GROUP <=", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupLike(String value) {
            addCriterion("PK_GROUP like", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupNotLike(String value) {
            addCriterion("PK_GROUP not like", value, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupIn(List<String> values) {
            addCriterion("PK_GROUP in", values, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupNotIn(List<String> values) {
            addCriterion("PK_GROUP not in", values, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupBetween(String value1, String value2) {
            addCriterion("PK_GROUP between", value1, value2, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkGroupNotBetween(String value1, String value2) {
            addCriterion("PK_GROUP not between", value1, value2, "pkGroup");
            return (Criteria) this;
        }

        public Criteria andPkOrgIsNull() {
            addCriterion("PK_ORG is null");
            return (Criteria) this;
        }

        public Criteria andPkOrgIsNotNull() {
            addCriterion("PK_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andPkOrgEqualTo(String value) {
            addCriterion("PK_ORG =", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgNotEqualTo(String value) {
            addCriterion("PK_ORG <>", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgGreaterThan(String value) {
            addCriterion("PK_ORG >", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ORG >=", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgLessThan(String value) {
            addCriterion("PK_ORG <", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgLessThanOrEqualTo(String value) {
            addCriterion("PK_ORG <=", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgLike(String value) {
            addCriterion("PK_ORG like", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgNotLike(String value) {
            addCriterion("PK_ORG not like", value, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgIn(List<String> values) {
            addCriterion("PK_ORG in", values, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgNotIn(List<String> values) {
            addCriterion("PK_ORG not in", values, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgBetween(String value1, String value2) {
            addCriterion("PK_ORG between", value1, value2, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andPkOrgNotBetween(String value1, String value2) {
            addCriterion("PK_ORG not between", value1, value2, "pkOrg");
            return (Criteria) this;
        }

        public Criteria andVbillstatusIsNull() {
            addCriterion("VBILLSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andVbillstatusIsNotNull() {
            addCriterion("VBILLSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andVbillstatusEqualTo(Long value) {
            addCriterion("VBILLSTATUS =", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusNotEqualTo(Long value) {
            addCriterion("VBILLSTATUS <>", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusGreaterThan(Long value) {
            addCriterion("VBILLSTATUS >", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusGreaterThanOrEqualTo(Long value) {
            addCriterion("VBILLSTATUS >=", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusLessThan(Long value) {
            addCriterion("VBILLSTATUS <", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusLessThanOrEqualTo(Long value) {
            addCriterion("VBILLSTATUS <=", value, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusIn(List<Long> values) {
            addCriterion("VBILLSTATUS in", values, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusNotIn(List<Long> values) {
            addCriterion("VBILLSTATUS not in", values, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusBetween(Long value1, Long value2) {
            addCriterion("VBILLSTATUS between", value1, value2, "vbillstatus");
            return (Criteria) this;
        }

        public Criteria andVbillstatusNotBetween(Long value1, Long value2) {
            addCriterion("VBILLSTATUS not between", value1, value2, "vbillstatus");
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

        public Criteria andVbillcodeIsNull() {
            addCriterion("VBILLCODE is null");
            return (Criteria) this;
        }

        public Criteria andVbillcodeIsNotNull() {
            addCriterion("VBILLCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVbillcodeEqualTo(String value) {
            addCriterion("VBILLCODE =", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeNotEqualTo(String value) {
            addCriterion("VBILLCODE <>", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeGreaterThan(String value) {
            addCriterion("VBILLCODE >", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VBILLCODE >=", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeLessThan(String value) {
            addCriterion("VBILLCODE <", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeLessThanOrEqualTo(String value) {
            addCriterion("VBILLCODE <=", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeLike(String value) {
            addCriterion("VBILLCODE like", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeNotLike(String value) {
            addCriterion("VBILLCODE not like", value, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeIn(List<String> values) {
            addCriterion("VBILLCODE in", values, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeNotIn(List<String> values) {
            addCriterion("VBILLCODE not in", values, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeBetween(String value1, String value2) {
            addCriterion("VBILLCODE between", value1, value2, "vbillcode");
            return (Criteria) this;
        }

        public Criteria andVbillcodeNotBetween(String value1, String value2) {
            addCriterion("VBILLCODE not between", value1, value2, "vbillcode");
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

        public Criteria andCustomerIsNull() {
            addCriterion("CUSTOMER is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("CUSTOMER is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("CUSTOMER =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("CUSTOMER <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("CUSTOMER >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("CUSTOMER <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("CUSTOMER like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("CUSTOMER not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("CUSTOMER in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("CUSTOMER not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("CUSTOMER between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER not between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
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

        public Criteria andSalesmanIsNull() {
            addCriterion("SALESMAN is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNotNull() {
            addCriterion("SALESMAN is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEqualTo(String value) {
            addCriterion("SALESMAN =", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotEqualTo(String value) {
            addCriterion("SALESMAN <>", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThan(String value) {
            addCriterion("SALESMAN >", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThanOrEqualTo(String value) {
            addCriterion("SALESMAN >=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThan(String value) {
            addCriterion("SALESMAN <", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThanOrEqualTo(String value) {
            addCriterion("SALESMAN <=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLike(String value) {
            addCriterion("SALESMAN like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotLike(String value) {
            addCriterion("SALESMAN not like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanIn(List<String> values) {
            addCriterion("SALESMAN in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotIn(List<String> values) {
            addCriterion("SALESMAN not in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanBetween(String value1, String value2) {
            addCriterion("SALESMAN between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotBetween(String value1, String value2) {
            addCriterion("SALESMAN not between", value1, value2, "salesman");
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

        public Criteria andNreceivedmnyIsNull() {
            addCriterion("NRECEIVEDMNY is null");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyIsNotNull() {
            addCriterion("NRECEIVEDMNY is not null");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyEqualTo(BigDecimal value) {
            addCriterion("NRECEIVEDMNY =", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyNotEqualTo(BigDecimal value) {
            addCriterion("NRECEIVEDMNY <>", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyGreaterThan(BigDecimal value) {
            addCriterion("NRECEIVEDMNY >", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NRECEIVEDMNY >=", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyLessThan(BigDecimal value) {
            addCriterion("NRECEIVEDMNY <", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NRECEIVEDMNY <=", value, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyIn(List<BigDecimal> values) {
            addCriterion("NRECEIVEDMNY in", values, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyNotIn(List<BigDecimal> values) {
            addCriterion("NRECEIVEDMNY not in", values, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NRECEIVEDMNY between", value1, value2, "nreceivedmny");
            return (Criteria) this;
        }

        public Criteria andNreceivedmnyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NRECEIVEDMNY not between", value1, value2, "nreceivedmny");
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

        public Criteria andBillmaketimeIsNull() {
            addCriterion("BILLMAKETIME is null");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeIsNotNull() {
            addCriterion("BILLMAKETIME is not null");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeEqualTo(String value) {
            addCriterion("BILLMAKETIME =", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeNotEqualTo(String value) {
            addCriterion("BILLMAKETIME <>", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeGreaterThan(String value) {
            addCriterion("BILLMAKETIME >", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeGreaterThanOrEqualTo(String value) {
            addCriterion("BILLMAKETIME >=", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeLessThan(String value) {
            addCriterion("BILLMAKETIME <", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeLessThanOrEqualTo(String value) {
            addCriterion("BILLMAKETIME <=", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeLike(String value) {
            addCriterion("BILLMAKETIME like", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeNotLike(String value) {
            addCriterion("BILLMAKETIME not like", value, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeIn(List<String> values) {
            addCriterion("BILLMAKETIME in", values, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeNotIn(List<String> values) {
            addCriterion("BILLMAKETIME not in", values, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeBetween(String value1, String value2) {
            addCriterion("BILLMAKETIME between", value1, value2, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andBillmaketimeNotBetween(String value1, String value2) {
            addCriterion("BILLMAKETIME not between", value1, value2, "billmaketime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("MODIFIEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("MODIFIEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(String value) {
            addCriterion("MODIFIEDTIME =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(String value) {
            addCriterion("MODIFIEDTIME <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(String value) {
            addCriterion("MODIFIEDTIME >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIEDTIME >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(String value) {
            addCriterion("MODIFIEDTIME <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(String value) {
            addCriterion("MODIFIEDTIME <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLike(String value) {
            addCriterion("MODIFIEDTIME like", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotLike(String value) {
            addCriterion("MODIFIEDTIME not like", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<String> values) {
            addCriterion("MODIFIEDTIME in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<String> values) {
            addCriterion("MODIFIEDTIME not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(String value1, String value2) {
            addCriterion("MODIFIEDTIME between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(String value1, String value2) {
            addCriterion("MODIFIEDTIME not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("APPROVER is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("APPROVER is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("APPROVER =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("APPROVER <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("APPROVER >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVER >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("APPROVER <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("APPROVER <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("APPROVER like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("APPROVER not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("APPROVER in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("APPROVER not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("APPROVER between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("APPROVER not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApprovetimeIsNull() {
            addCriterion("APPROVETIME is null");
            return (Criteria) this;
        }

        public Criteria andApprovetimeIsNotNull() {
            addCriterion("APPROVETIME is not null");
            return (Criteria) this;
        }

        public Criteria andApprovetimeEqualTo(String value) {
            addCriterion("APPROVETIME =", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeNotEqualTo(String value) {
            addCriterion("APPROVETIME <>", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeGreaterThan(String value) {
            addCriterion("APPROVETIME >", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVETIME >=", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeLessThan(String value) {
            addCriterion("APPROVETIME <", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeLessThanOrEqualTo(String value) {
            addCriterion("APPROVETIME <=", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeLike(String value) {
            addCriterion("APPROVETIME like", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeNotLike(String value) {
            addCriterion("APPROVETIME not like", value, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeIn(List<String> values) {
            addCriterion("APPROVETIME in", values, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeNotIn(List<String> values) {
            addCriterion("APPROVETIME not in", values, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeBetween(String value1, String value2) {
            addCriterion("APPROVETIME between", value1, value2, "approvetime");
            return (Criteria) this;
        }

        public Criteria andApprovetimeNotBetween(String value1, String value2) {
            addCriterion("APPROVETIME not between", value1, value2, "approvetime");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("TS is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("TS is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(String value) {
            addCriterion("TS =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(String value) {
            addCriterion("TS <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(String value) {
            addCriterion("TS >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(String value) {
            addCriterion("TS >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(String value) {
            addCriterion("TS <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(String value) {
            addCriterion("TS <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLike(String value) {
            addCriterion("TS like", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotLike(String value) {
            addCriterion("TS not like", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<String> values) {
            addCriterion("TS in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<String> values) {
            addCriterion("TS not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(String value1, String value2) {
            addCriterion("TS between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(String value1, String value2) {
            addCriterion("TS not between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andVsrcidIsNull() {
            addCriterion("VSRCID is null");
            return (Criteria) this;
        }

        public Criteria andVsrcidIsNotNull() {
            addCriterion("VSRCID is not null");
            return (Criteria) this;
        }

        public Criteria andVsrcidEqualTo(String value) {
            addCriterion("VSRCID =", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidNotEqualTo(String value) {
            addCriterion("VSRCID <>", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidGreaterThan(String value) {
            addCriterion("VSRCID >", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidGreaterThanOrEqualTo(String value) {
            addCriterion("VSRCID >=", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidLessThan(String value) {
            addCriterion("VSRCID <", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidLessThanOrEqualTo(String value) {
            addCriterion("VSRCID <=", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidLike(String value) {
            addCriterion("VSRCID like", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidNotLike(String value) {
            addCriterion("VSRCID not like", value, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidIn(List<String> values) {
            addCriterion("VSRCID in", values, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidNotIn(List<String> values) {
            addCriterion("VSRCID not in", values, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidBetween(String value1, String value2) {
            addCriterion("VSRCID between", value1, value2, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andVsrcidNotBetween(String value1, String value2) {
            addCriterion("VSRCID not between", value1, value2, "vsrcid");
            return (Criteria) this;
        }

        public Criteria andDrIsNull() {
            addCriterion("DR is null");
            return (Criteria) this;
        }

        public Criteria andDrIsNotNull() {
            addCriterion("DR is not null");
            return (Criteria) this;
        }

        public Criteria andDrEqualTo(BigDecimal value) {
            addCriterion("DR =", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotEqualTo(BigDecimal value) {
            addCriterion("DR <>", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThan(BigDecimal value) {
            addCriterion("DR >", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DR >=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThan(BigDecimal value) {
            addCriterion("DR <", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DR <=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrIn(List<BigDecimal> values) {
            addCriterion("DR in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotIn(List<BigDecimal> values) {
            addCriterion("DR not in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DR between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DR not between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andIssyncIsNull() {
            addCriterion("ISSYNC is null");
            return (Criteria) this;
        }

        public Criteria andIssyncIsNotNull() {
            addCriterion("ISSYNC is not null");
            return (Criteria) this;
        }

        public Criteria andIssyncEqualTo(Short value) {
            addCriterion("ISSYNC =", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncNotEqualTo(Short value) {
            addCriterion("ISSYNC <>", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncGreaterThan(Short value) {
            addCriterion("ISSYNC >", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncGreaterThanOrEqualTo(Short value) {
            addCriterion("ISSYNC >=", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncLessThan(Short value) {
            addCriterion("ISSYNC <", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncLessThanOrEqualTo(Short value) {
            addCriterion("ISSYNC <=", value, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncIn(List<Short> values) {
            addCriterion("ISSYNC in", values, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncNotIn(List<Short> values) {
            addCriterion("ISSYNC not in", values, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncBetween(Short value1, Short value2) {
            addCriterion("ISSYNC between", value1, value2, "issync");
            return (Criteria) this;
        }

        public Criteria andIssyncNotBetween(Short value1, Short value2) {
            addCriterion("ISSYNC not between", value1, value2, "issync");
            return (Criteria) this;
        }

        public Criteria andVsrccodeIsNull() {
            addCriterion("VSRCCODE is null");
            return (Criteria) this;
        }

        public Criteria andVsrccodeIsNotNull() {
            addCriterion("VSRCCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVsrccodeEqualTo(String value) {
            addCriterion("VSRCCODE =", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeNotEqualTo(String value) {
            addCriterion("VSRCCODE <>", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeGreaterThan(String value) {
            addCriterion("VSRCCODE >", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeGreaterThanOrEqualTo(String value) {
            addCriterion("VSRCCODE >=", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeLessThan(String value) {
            addCriterion("VSRCCODE <", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeLessThanOrEqualTo(String value) {
            addCriterion("VSRCCODE <=", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeLike(String value) {
            addCriterion("VSRCCODE like", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeNotLike(String value) {
            addCriterion("VSRCCODE not like", value, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeIn(List<String> values) {
            addCriterion("VSRCCODE in", values, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeNotIn(List<String> values) {
            addCriterion("VSRCCODE not in", values, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeBetween(String value1, String value2) {
            addCriterion("VSRCCODE between", value1, value2, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrccodeNotBetween(String value1, String value2) {
            addCriterion("VSRCCODE not between", value1, value2, "vsrccode");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeIsNull() {
            addCriterion("VSRCBILLTYPE is null");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeIsNotNull() {
            addCriterion("VSRCBILLTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeEqualTo(String value) {
            addCriterion("VSRCBILLTYPE =", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeNotEqualTo(String value) {
            addCriterion("VSRCBILLTYPE <>", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeGreaterThan(String value) {
            addCriterion("VSRCBILLTYPE >", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeGreaterThanOrEqualTo(String value) {
            addCriterion("VSRCBILLTYPE >=", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeLessThan(String value) {
            addCriterion("VSRCBILLTYPE <", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeLessThanOrEqualTo(String value) {
            addCriterion("VSRCBILLTYPE <=", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeLike(String value) {
            addCriterion("VSRCBILLTYPE like", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeNotLike(String value) {
            addCriterion("VSRCBILLTYPE not like", value, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeIn(List<String> values) {
            addCriterion("VSRCBILLTYPE in", values, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeNotIn(List<String> values) {
            addCriterion("VSRCBILLTYPE not in", values, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeBetween(String value1, String value2) {
            addCriterion("VSRCBILLTYPE between", value1, value2, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andVsrcbilltypeNotBetween(String value1, String value2) {
            addCriterion("VSRCBILLTYPE not between", value1, value2, "vsrcbilltype");
            return (Criteria) this;
        }

        public Criteria andTypecollectIsNull() {
            addCriterion("TYPECOLLECT is null");
            return (Criteria) this;
        }

        public Criteria andTypecollectIsNotNull() {
            addCriterion("TYPECOLLECT is not null");
            return (Criteria) this;
        }

        public Criteria andTypecollectEqualTo(String value) {
            addCriterion("TYPECOLLECT =", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectNotEqualTo(String value) {
            addCriterion("TYPECOLLECT <>", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectGreaterThan(String value) {
            addCriterion("TYPECOLLECT >", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectGreaterThanOrEqualTo(String value) {
            addCriterion("TYPECOLLECT >=", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectLessThan(String value) {
            addCriterion("TYPECOLLECT <", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectLessThanOrEqualTo(String value) {
            addCriterion("TYPECOLLECT <=", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectLike(String value) {
            addCriterion("TYPECOLLECT like", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectNotLike(String value) {
            addCriterion("TYPECOLLECT not like", value, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectIn(List<String> values) {
            addCriterion("TYPECOLLECT in", values, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectNotIn(List<String> values) {
            addCriterion("TYPECOLLECT not in", values, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectBetween(String value1, String value2) {
            addCriterion("TYPECOLLECT between", value1, value2, "typecollect");
            return (Criteria) this;
        }

        public Criteria andTypecollectNotBetween(String value1, String value2) {
            addCriterion("TYPECOLLECT not between", value1, value2, "typecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectIsNull() {
            addCriterion("NATURECOLLECT is null");
            return (Criteria) this;
        }

        public Criteria andNaturecollectIsNotNull() {
            addCriterion("NATURECOLLECT is not null");
            return (Criteria) this;
        }

        public Criteria andNaturecollectEqualTo(String value) {
            addCriterion("NATURECOLLECT =", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectNotEqualTo(String value) {
            addCriterion("NATURECOLLECT <>", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectGreaterThan(String value) {
            addCriterion("NATURECOLLECT >", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectGreaterThanOrEqualTo(String value) {
            addCriterion("NATURECOLLECT >=", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectLessThan(String value) {
            addCriterion("NATURECOLLECT <", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectLessThanOrEqualTo(String value) {
            addCriterion("NATURECOLLECT <=", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectLike(String value) {
            addCriterion("NATURECOLLECT like", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectNotLike(String value) {
            addCriterion("NATURECOLLECT not like", value, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectIn(List<String> values) {
            addCriterion("NATURECOLLECT in", values, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectNotIn(List<String> values) {
            addCriterion("NATURECOLLECT not in", values, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectBetween(String value1, String value2) {
            addCriterion("NATURECOLLECT between", value1, value2, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andNaturecollectNotBetween(String value1, String value2) {
            addCriterion("NATURECOLLECT not between", value1, value2, "naturecollect");
            return (Criteria) this;
        }

        public Criteria andTauxIsNull() {
            addCriterion("TAUX is null");
            return (Criteria) this;
        }

        public Criteria andTauxIsNotNull() {
            addCriterion("TAUX is not null");
            return (Criteria) this;
        }

        public Criteria andTauxEqualTo(BigDecimal value) {
            addCriterion("TAUX =", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxNotEqualTo(BigDecimal value) {
            addCriterion("TAUX <>", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxGreaterThan(BigDecimal value) {
            addCriterion("TAUX >", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAUX >=", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxLessThan(BigDecimal value) {
            addCriterion("TAUX <", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAUX <=", value, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxIn(List<BigDecimal> values) {
            addCriterion("TAUX in", values, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxNotIn(List<BigDecimal> values) {
            addCriterion("TAUX not in", values, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAUX between", value1, value2, "taux");
            return (Criteria) this;
        }

        public Criteria andTauxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAUX not between", value1, value2, "taux");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("TOTAL =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("TOTAL >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("TOTAL <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("TOTAL in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andCbalatypeIsNull() {
            addCriterion("CBALATYPE is null");
            return (Criteria) this;
        }

        public Criteria andCbalatypeIsNotNull() {
            addCriterion("CBALATYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCbalatypeEqualTo(String value) {
            addCriterion("CBALATYPE =", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeNotEqualTo(String value) {
            addCriterion("CBALATYPE <>", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeGreaterThan(String value) {
            addCriterion("CBALATYPE >", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeGreaterThanOrEqualTo(String value) {
            addCriterion("CBALATYPE >=", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeLessThan(String value) {
            addCriterion("CBALATYPE <", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeLessThanOrEqualTo(String value) {
            addCriterion("CBALATYPE <=", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeLike(String value) {
            addCriterion("CBALATYPE like", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeNotLike(String value) {
            addCriterion("CBALATYPE not like", value, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeIn(List<String> values) {
            addCriterion("CBALATYPE in", values, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeNotIn(List<String> values) {
            addCriterion("CBALATYPE not in", values, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeBetween(String value1, String value2) {
            addCriterion("CBALATYPE between", value1, value2, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andCbalatypeNotBetween(String value1, String value2) {
            addCriterion("CBALATYPE not between", value1, value2, "cbalatype");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeIsNull() {
            addCriterion("EFFECTBILLCODE is null");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeIsNotNull() {
            addCriterion("EFFECTBILLCODE is not null");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeEqualTo(String value) {
            addCriterion("EFFECTBILLCODE =", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeNotEqualTo(String value) {
            addCriterion("EFFECTBILLCODE <>", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeGreaterThan(String value) {
            addCriterion("EFFECTBILLCODE >", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECTBILLCODE >=", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeLessThan(String value) {
            addCriterion("EFFECTBILLCODE <", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeLessThanOrEqualTo(String value) {
            addCriterion("EFFECTBILLCODE <=", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeLike(String value) {
            addCriterion("EFFECTBILLCODE like", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeNotLike(String value) {
            addCriterion("EFFECTBILLCODE not like", value, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeIn(List<String> values) {
            addCriterion("EFFECTBILLCODE in", values, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeNotIn(List<String> values) {
            addCriterion("EFFECTBILLCODE not in", values, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeBetween(String value1, String value2) {
            addCriterion("EFFECTBILLCODE between", value1, value2, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andEffectbillcodeNotBetween(String value1, String value2) {
            addCriterion("EFFECTBILLCODE not between", value1, value2, "effectbillcode");
            return (Criteria) this;
        }

        public Criteria andCashaccountIsNull() {
            addCriterion("CASHACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCashaccountIsNotNull() {
            addCriterion("CASHACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCashaccountEqualTo(String value) {
            addCriterion("CASHACCOUNT =", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountNotEqualTo(String value) {
            addCriterion("CASHACCOUNT <>", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountGreaterThan(String value) {
            addCriterion("CASHACCOUNT >", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountGreaterThanOrEqualTo(String value) {
            addCriterion("CASHACCOUNT >=", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountLessThan(String value) {
            addCriterion("CASHACCOUNT <", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountLessThanOrEqualTo(String value) {
            addCriterion("CASHACCOUNT <=", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountLike(String value) {
            addCriterion("CASHACCOUNT like", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountNotLike(String value) {
            addCriterion("CASHACCOUNT not like", value, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountIn(List<String> values) {
            addCriterion("CASHACCOUNT in", values, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountNotIn(List<String> values) {
            addCriterion("CASHACCOUNT not in", values, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountBetween(String value1, String value2) {
            addCriterion("CASHACCOUNT between", value1, value2, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andCashaccountNotBetween(String value1, String value2) {
            addCriterion("CASHACCOUNT not between", value1, value2, "cashaccount");
            return (Criteria) this;
        }

        public Criteria andNordermnyIsNull() {
            addCriterion("NORDERMNY is null");
            return (Criteria) this;
        }

        public Criteria andNordermnyIsNotNull() {
            addCriterion("NORDERMNY is not null");
            return (Criteria) this;
        }

        public Criteria andNordermnyEqualTo(BigDecimal value) {
            addCriterion("NORDERMNY =", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyNotEqualTo(BigDecimal value) {
            addCriterion("NORDERMNY <>", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyGreaterThan(BigDecimal value) {
            addCriterion("NORDERMNY >", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NORDERMNY >=", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyLessThan(BigDecimal value) {
            addCriterion("NORDERMNY <", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NORDERMNY <=", value, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyIn(List<BigDecimal> values) {
            addCriterion("NORDERMNY in", values, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyNotIn(List<BigDecimal> values) {
            addCriterion("NORDERMNY not in", values, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NORDERMNY between", value1, value2, "nordermny");
            return (Criteria) this;
        }

        public Criteria andNordermnyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NORDERMNY not between", value1, value2, "nordermny");
            return (Criteria) this;
        }

        public Criteria andCbankidIsNull() {
            addCriterion("CBANKID is null");
            return (Criteria) this;
        }

        public Criteria andCbankidIsNotNull() {
            addCriterion("CBANKID is not null");
            return (Criteria) this;
        }

        public Criteria andCbankidEqualTo(String value) {
            addCriterion("CBANKID =", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidNotEqualTo(String value) {
            addCriterion("CBANKID <>", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidGreaterThan(String value) {
            addCriterion("CBANKID >", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidGreaterThanOrEqualTo(String value) {
            addCriterion("CBANKID >=", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidLessThan(String value) {
            addCriterion("CBANKID <", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidLessThanOrEqualTo(String value) {
            addCriterion("CBANKID <=", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidLike(String value) {
            addCriterion("CBANKID like", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidNotLike(String value) {
            addCriterion("CBANKID not like", value, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidIn(List<String> values) {
            addCriterion("CBANKID in", values, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidNotIn(List<String> values) {
            addCriterion("CBANKID not in", values, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidBetween(String value1, String value2) {
            addCriterion("CBANKID between", value1, value2, "cbankid");
            return (Criteria) this;
        }

        public Criteria andCbankidNotBetween(String value1, String value2) {
            addCriterion("CBANKID not between", value1, value2, "cbankid");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeIsNull() {
            addCriterion("VORDERBILLCODE is null");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeIsNotNull() {
            addCriterion("VORDERBILLCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeEqualTo(String value) {
            addCriterion("VORDERBILLCODE =", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeNotEqualTo(String value) {
            addCriterion("VORDERBILLCODE <>", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeGreaterThan(String value) {
            addCriterion("VORDERBILLCODE >", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VORDERBILLCODE >=", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeLessThan(String value) {
            addCriterion("VORDERBILLCODE <", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeLessThanOrEqualTo(String value) {
            addCriterion("VORDERBILLCODE <=", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeLike(String value) {
            addCriterion("VORDERBILLCODE like", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeNotLike(String value) {
            addCriterion("VORDERBILLCODE not like", value, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeIn(List<String> values) {
            addCriterion("VORDERBILLCODE in", values, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeNotIn(List<String> values) {
            addCriterion("VORDERBILLCODE not in", values, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeBetween(String value1, String value2) {
            addCriterion("VORDERBILLCODE between", value1, value2, "vorderbillcode");
            return (Criteria) this;
        }

        public Criteria andVorderbillcodeNotBetween(String value1, String value2) {
            addCriterion("VORDERBILLCODE not between", value1, value2, "vorderbillcode");
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