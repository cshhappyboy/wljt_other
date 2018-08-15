package com.fgc.pojo;

import java.util.ArrayList;
import java.util.List;

public class MarBasClassVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarBasClassVOExample() {
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

        public Criteria andPkmarbasclassIsNull() {
            addCriterion("PKMARBASCLASS is null");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassIsNotNull() {
            addCriterion("PKMARBASCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassEqualTo(String value) {
            addCriterion("PKMARBASCLASS =", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassNotEqualTo(String value) {
            addCriterion("PKMARBASCLASS <>", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassGreaterThan(String value) {
            addCriterion("PKMARBASCLASS >", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassGreaterThanOrEqualTo(String value) {
            addCriterion("PKMARBASCLASS >=", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassLessThan(String value) {
            addCriterion("PKMARBASCLASS <", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassLessThanOrEqualTo(String value) {
            addCriterion("PKMARBASCLASS <=", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassLike(String value) {
            addCriterion("PKMARBASCLASS like", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassNotLike(String value) {
            addCriterion("PKMARBASCLASS not like", value, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassIn(List<String> values) {
            addCriterion("PKMARBASCLASS in", values, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassNotIn(List<String> values) {
            addCriterion("PKMARBASCLASS not in", values, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassBetween(String value1, String value2) {
            addCriterion("PKMARBASCLASS between", value1, value2, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkmarbasclassNotBetween(String value1, String value2) {
            addCriterion("PKMARBASCLASS not between", value1, value2, "pkmarbasclass");
            return (Criteria) this;
        }

        public Criteria andPkorgIsNull() {
            addCriterion("PKORG is null");
            return (Criteria) this;
        }

        public Criteria andPkorgIsNotNull() {
            addCriterion("PKORG is not null");
            return (Criteria) this;
        }

        public Criteria andPkorgEqualTo(String value) {
            addCriterion("PKORG =", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgNotEqualTo(String value) {
            addCriterion("PKORG <>", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgGreaterThan(String value) {
            addCriterion("PKORG >", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgGreaterThanOrEqualTo(String value) {
            addCriterion("PKORG >=", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgLessThan(String value) {
            addCriterion("PKORG <", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgLessThanOrEqualTo(String value) {
            addCriterion("PKORG <=", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgLike(String value) {
            addCriterion("PKORG like", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgNotLike(String value) {
            addCriterion("PKORG not like", value, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgIn(List<String> values) {
            addCriterion("PKORG in", values, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgNotIn(List<String> values) {
            addCriterion("PKORG not in", values, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgBetween(String value1, String value2) {
            addCriterion("PKORG between", value1, value2, "pkorg");
            return (Criteria) this;
        }

        public Criteria andPkorgNotBetween(String value1, String value2) {
            addCriterion("PKORG not between", value1, value2, "pkorg");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
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

        public Criteria andPkparentIsNull() {
            addCriterion("PKPARENT is null");
            return (Criteria) this;
        }

        public Criteria andPkparentIsNotNull() {
            addCriterion("PKPARENT is not null");
            return (Criteria) this;
        }

        public Criteria andPkparentEqualTo(String value) {
            addCriterion("PKPARENT =", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentNotEqualTo(String value) {
            addCriterion("PKPARENT <>", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentGreaterThan(String value) {
            addCriterion("PKPARENT >", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentGreaterThanOrEqualTo(String value) {
            addCriterion("PKPARENT >=", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentLessThan(String value) {
            addCriterion("PKPARENT <", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentLessThanOrEqualTo(String value) {
            addCriterion("PKPARENT <=", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentLike(String value) {
            addCriterion("PKPARENT like", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentNotLike(String value) {
            addCriterion("PKPARENT not like", value, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentIn(List<String> values) {
            addCriterion("PKPARENT in", values, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentNotIn(List<String> values) {
            addCriterion("PKPARENT not in", values, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentBetween(String value1, String value2) {
            addCriterion("PKPARENT between", value1, value2, "pkparent");
            return (Criteria) this;
        }

        public Criteria andPkparentNotBetween(String value1, String value2) {
            addCriterion("PKPARENT not between", value1, value2, "pkparent");
            return (Criteria) this;
        }

        public Criteria andVdef20IsNull() {
            addCriterion("VDEF20 is null");
            return (Criteria) this;
        }

        public Criteria andVdef20IsNotNull() {
            addCriterion("VDEF20 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef20EqualTo(String value) {
            addCriterion("VDEF20 =", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20NotEqualTo(String value) {
            addCriterion("VDEF20 <>", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20GreaterThan(String value) {
            addCriterion("VDEF20 >", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF20 >=", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20LessThan(String value) {
            addCriterion("VDEF20 <", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20LessThanOrEqualTo(String value) {
            addCriterion("VDEF20 <=", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20Like(String value) {
            addCriterion("VDEF20 like", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20NotLike(String value) {
            addCriterion("VDEF20 not like", value, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20In(List<String> values) {
            addCriterion("VDEF20 in", values, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20NotIn(List<String> values) {
            addCriterion("VDEF20 not in", values, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20Between(String value1, String value2) {
            addCriterion("VDEF20 between", value1, value2, "vdef20");
            return (Criteria) this;
        }

        public Criteria andVdef20NotBetween(String value1, String value2) {
            addCriterion("VDEF20 not between", value1, value2, "vdef20");
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

        public Criteria andDrEqualTo(Long value) {
            addCriterion("DR =", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotEqualTo(Long value) {
            addCriterion("DR <>", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThan(Long value) {
            addCriterion("DR >", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThanOrEqualTo(Long value) {
            addCriterion("DR >=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThan(Long value) {
            addCriterion("DR <", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThanOrEqualTo(Long value) {
            addCriterion("DR <=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrIn(List<Long> values) {
            addCriterion("DR in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotIn(List<Long> values) {
            addCriterion("DR not in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrBetween(Long value1, Long value2) {
            addCriterion("DR between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotBetween(Long value1, Long value2) {
            addCriterion("DR not between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andVdef18IsNull() {
            addCriterion("VDEF18 is null");
            return (Criteria) this;
        }

        public Criteria andVdef18IsNotNull() {
            addCriterion("VDEF18 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef18EqualTo(String value) {
            addCriterion("VDEF18 =", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18NotEqualTo(String value) {
            addCriterion("VDEF18 <>", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18GreaterThan(String value) {
            addCriterion("VDEF18 >", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF18 >=", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18LessThan(String value) {
            addCriterion("VDEF18 <", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18LessThanOrEqualTo(String value) {
            addCriterion("VDEF18 <=", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18Like(String value) {
            addCriterion("VDEF18 like", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18NotLike(String value) {
            addCriterion("VDEF18 not like", value, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18In(List<String> values) {
            addCriterion("VDEF18 in", values, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18NotIn(List<String> values) {
            addCriterion("VDEF18 not in", values, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18Between(String value1, String value2) {
            addCriterion("VDEF18 between", value1, value2, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef18NotBetween(String value1, String value2) {
            addCriterion("VDEF18 not between", value1, value2, "vdef18");
            return (Criteria) this;
        }

        public Criteria andVdef19IsNull() {
            addCriterion("VDEF19 is null");
            return (Criteria) this;
        }

        public Criteria andVdef19IsNotNull() {
            addCriterion("VDEF19 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef19EqualTo(String value) {
            addCriterion("VDEF19 =", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19NotEqualTo(String value) {
            addCriterion("VDEF19 <>", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19GreaterThan(String value) {
            addCriterion("VDEF19 >", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF19 >=", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19LessThan(String value) {
            addCriterion("VDEF19 <", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19LessThanOrEqualTo(String value) {
            addCriterion("VDEF19 <=", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19Like(String value) {
            addCriterion("VDEF19 like", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19NotLike(String value) {
            addCriterion("VDEF19 not like", value, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19In(List<String> values) {
            addCriterion("VDEF19 in", values, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19NotIn(List<String> values) {
            addCriterion("VDEF19 not in", values, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19Between(String value1, String value2) {
            addCriterion("VDEF19 between", value1, value2, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef19NotBetween(String value1, String value2) {
            addCriterion("VDEF19 not between", value1, value2, "vdef19");
            return (Criteria) this;
        }

        public Criteria andVdef16IsNull() {
            addCriterion("VDEF16 is null");
            return (Criteria) this;
        }

        public Criteria andVdef16IsNotNull() {
            addCriterion("VDEF16 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef16EqualTo(String value) {
            addCriterion("VDEF16 =", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16NotEqualTo(String value) {
            addCriterion("VDEF16 <>", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16GreaterThan(String value) {
            addCriterion("VDEF16 >", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF16 >=", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16LessThan(String value) {
            addCriterion("VDEF16 <", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16LessThanOrEqualTo(String value) {
            addCriterion("VDEF16 <=", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16Like(String value) {
            addCriterion("VDEF16 like", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16NotLike(String value) {
            addCriterion("VDEF16 not like", value, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16In(List<String> values) {
            addCriterion("VDEF16 in", values, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16NotIn(List<String> values) {
            addCriterion("VDEF16 not in", values, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16Between(String value1, String value2) {
            addCriterion("VDEF16 between", value1, value2, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef16NotBetween(String value1, String value2) {
            addCriterion("VDEF16 not between", value1, value2, "vdef16");
            return (Criteria) this;
        }

        public Criteria andVdef17IsNull() {
            addCriterion("VDEF17 is null");
            return (Criteria) this;
        }

        public Criteria andVdef17IsNotNull() {
            addCriterion("VDEF17 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef17EqualTo(String value) {
            addCriterion("VDEF17 =", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17NotEqualTo(String value) {
            addCriterion("VDEF17 <>", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17GreaterThan(String value) {
            addCriterion("VDEF17 >", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF17 >=", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17LessThan(String value) {
            addCriterion("VDEF17 <", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17LessThanOrEqualTo(String value) {
            addCriterion("VDEF17 <=", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17Like(String value) {
            addCriterion("VDEF17 like", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17NotLike(String value) {
            addCriterion("VDEF17 not like", value, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17In(List<String> values) {
            addCriterion("VDEF17 in", values, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17NotIn(List<String> values) {
            addCriterion("VDEF17 not in", values, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17Between(String value1, String value2) {
            addCriterion("VDEF17 between", value1, value2, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef17NotBetween(String value1, String value2) {
            addCriterion("VDEF17 not between", value1, value2, "vdef17");
            return (Criteria) this;
        }

        public Criteria andVdef14IsNull() {
            addCriterion("VDEF14 is null");
            return (Criteria) this;
        }

        public Criteria andVdef14IsNotNull() {
            addCriterion("VDEF14 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef14EqualTo(String value) {
            addCriterion("VDEF14 =", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14NotEqualTo(String value) {
            addCriterion("VDEF14 <>", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14GreaterThan(String value) {
            addCriterion("VDEF14 >", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF14 >=", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14LessThan(String value) {
            addCriterion("VDEF14 <", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14LessThanOrEqualTo(String value) {
            addCriterion("VDEF14 <=", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14Like(String value) {
            addCriterion("VDEF14 like", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14NotLike(String value) {
            addCriterion("VDEF14 not like", value, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14In(List<String> values) {
            addCriterion("VDEF14 in", values, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14NotIn(List<String> values) {
            addCriterion("VDEF14 not in", values, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14Between(String value1, String value2) {
            addCriterion("VDEF14 between", value1, value2, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef14NotBetween(String value1, String value2) {
            addCriterion("VDEF14 not between", value1, value2, "vdef14");
            return (Criteria) this;
        }

        public Criteria andVdef15IsNull() {
            addCriterion("VDEF15 is null");
            return (Criteria) this;
        }

        public Criteria andVdef15IsNotNull() {
            addCriterion("VDEF15 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef15EqualTo(String value) {
            addCriterion("VDEF15 =", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15NotEqualTo(String value) {
            addCriterion("VDEF15 <>", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15GreaterThan(String value) {
            addCriterion("VDEF15 >", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF15 >=", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15LessThan(String value) {
            addCriterion("VDEF15 <", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15LessThanOrEqualTo(String value) {
            addCriterion("VDEF15 <=", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15Like(String value) {
            addCriterion("VDEF15 like", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15NotLike(String value) {
            addCriterion("VDEF15 not like", value, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15In(List<String> values) {
            addCriterion("VDEF15 in", values, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15NotIn(List<String> values) {
            addCriterion("VDEF15 not in", values, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15Between(String value1, String value2) {
            addCriterion("VDEF15 between", value1, value2, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef15NotBetween(String value1, String value2) {
            addCriterion("VDEF15 not between", value1, value2, "vdef15");
            return (Criteria) this;
        }

        public Criteria andVdef13IsNull() {
            addCriterion("VDEF13 is null");
            return (Criteria) this;
        }

        public Criteria andVdef13IsNotNull() {
            addCriterion("VDEF13 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef13EqualTo(String value) {
            addCriterion("VDEF13 =", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13NotEqualTo(String value) {
            addCriterion("VDEF13 <>", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13GreaterThan(String value) {
            addCriterion("VDEF13 >", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF13 >=", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13LessThan(String value) {
            addCriterion("VDEF13 <", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13LessThanOrEqualTo(String value) {
            addCriterion("VDEF13 <=", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13Like(String value) {
            addCriterion("VDEF13 like", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13NotLike(String value) {
            addCriterion("VDEF13 not like", value, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13In(List<String> values) {
            addCriterion("VDEF13 in", values, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13NotIn(List<String> values) {
            addCriterion("VDEF13 not in", values, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13Between(String value1, String value2) {
            addCriterion("VDEF13 between", value1, value2, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef13NotBetween(String value1, String value2) {
            addCriterion("VDEF13 not between", value1, value2, "vdef13");
            return (Criteria) this;
        }

        public Criteria andVdef11IsNull() {
            addCriterion("VDEF11 is null");
            return (Criteria) this;
        }

        public Criteria andVdef11IsNotNull() {
            addCriterion("VDEF11 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef11EqualTo(String value) {
            addCriterion("VDEF11 =", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11NotEqualTo(String value) {
            addCriterion("VDEF11 <>", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11GreaterThan(String value) {
            addCriterion("VDEF11 >", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF11 >=", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11LessThan(String value) {
            addCriterion("VDEF11 <", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11LessThanOrEqualTo(String value) {
            addCriterion("VDEF11 <=", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11Like(String value) {
            addCriterion("VDEF11 like", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11NotLike(String value) {
            addCriterion("VDEF11 not like", value, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11In(List<String> values) {
            addCriterion("VDEF11 in", values, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11NotIn(List<String> values) {
            addCriterion("VDEF11 not in", values, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11Between(String value1, String value2) {
            addCriterion("VDEF11 between", value1, value2, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef11NotBetween(String value1, String value2) {
            addCriterion("VDEF11 not between", value1, value2, "vdef11");
            return (Criteria) this;
        }

        public Criteria andVdef12IsNull() {
            addCriterion("VDEF12 is null");
            return (Criteria) this;
        }

        public Criteria andVdef12IsNotNull() {
            addCriterion("VDEF12 is not null");
            return (Criteria) this;
        }

        public Criteria andVdef12EqualTo(String value) {
            addCriterion("VDEF12 =", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12NotEqualTo(String value) {
            addCriterion("VDEF12 <>", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12GreaterThan(String value) {
            addCriterion("VDEF12 >", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12GreaterThanOrEqualTo(String value) {
            addCriterion("VDEF12 >=", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12LessThan(String value) {
            addCriterion("VDEF12 <", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12LessThanOrEqualTo(String value) {
            addCriterion("VDEF12 <=", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12Like(String value) {
            addCriterion("VDEF12 like", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12NotLike(String value) {
            addCriterion("VDEF12 not like", value, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12In(List<String> values) {
            addCriterion("VDEF12 in", values, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12NotIn(List<String> values) {
            addCriterion("VDEF12 not in", values, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12Between(String value1, String value2) {
            addCriterion("VDEF12 between", value1, value2, "vdef12");
            return (Criteria) this;
        }

        public Criteria andVdef12NotBetween(String value1, String value2) {
            addCriterion("VDEF12 not between", value1, value2, "vdef12");
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