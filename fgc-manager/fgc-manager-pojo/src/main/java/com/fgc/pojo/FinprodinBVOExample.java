package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinprodinBVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinprodinBVOExample() {
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

        public Criteria andHidIsNull() {
            addCriterion("HID is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("HID is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(String value) {
            addCriterion("HID =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(String value) {
            addCriterion("HID <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(String value) {
            addCriterion("HID >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(String value) {
            addCriterion("HID >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(String value) {
            addCriterion("HID <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(String value) {
            addCriterion("HID <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLike(String value) {
            addCriterion("HID like", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotLike(String value) {
            addCriterion("HID not like", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<String> values) {
            addCriterion("HID in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<String> values) {
            addCriterion("HID not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(String value1, String value2) {
            addCriterion("HID between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(String value1, String value2) {
            addCriterion("HID not between", value1, value2, "hid");
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

        public Criteria andVrownumIsNull() {
            addCriterion("VROWNUM is null");
            return (Criteria) this;
        }

        public Criteria andVrownumIsNotNull() {
            addCriterion("VROWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andVrownumEqualTo(String value) {
            addCriterion("VROWNUM =", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumNotEqualTo(String value) {
            addCriterion("VROWNUM <>", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumGreaterThan(String value) {
            addCriterion("VROWNUM >", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumGreaterThanOrEqualTo(String value) {
            addCriterion("VROWNUM >=", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumLessThan(String value) {
            addCriterion("VROWNUM <", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumLessThanOrEqualTo(String value) {
            addCriterion("VROWNUM <=", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumLike(String value) {
            addCriterion("VROWNUM like", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumNotLike(String value) {
            addCriterion("VROWNUM not like", value, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumIn(List<String> values) {
            addCriterion("VROWNUM in", values, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumNotIn(List<String> values) {
            addCriterion("VROWNUM not in", values, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumBetween(String value1, String value2) {
            addCriterion("VROWNUM between", value1, value2, "vrownum");
            return (Criteria) this;
        }

        public Criteria andVrownumNotBetween(String value1, String value2) {
            addCriterion("VROWNUM not between", value1, value2, "vrownum");
            return (Criteria) this;
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

        public Criteria andMaterialnameIsNull() {
            addCriterion("MATERIALNAME is null");
            return (Criteria) this;
        }

        public Criteria andMaterialnameIsNotNull() {
            addCriterion("MATERIALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialnameEqualTo(String value) {
            addCriterion("MATERIALNAME =", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotEqualTo(String value) {
            addCriterion("MATERIALNAME <>", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameGreaterThan(String value) {
            addCriterion("MATERIALNAME >", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIALNAME >=", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLessThan(String value) {
            addCriterion("MATERIALNAME <", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLessThanOrEqualTo(String value) {
            addCriterion("MATERIALNAME <=", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameLike(String value) {
            addCriterion("MATERIALNAME like", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotLike(String value) {
            addCriterion("MATERIALNAME not like", value, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameIn(List<String> values) {
            addCriterion("MATERIALNAME in", values, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotIn(List<String> values) {
            addCriterion("MATERIALNAME not in", values, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameBetween(String value1, String value2) {
            addCriterion("MATERIALNAME between", value1, value2, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialnameNotBetween(String value1, String value2) {
            addCriterion("MATERIALNAME not between", value1, value2, "materialname");
            return (Criteria) this;
        }

        public Criteria andMaterialspecIsNull() {
            addCriterion("MATERIALSPEC is null");
            return (Criteria) this;
        }

        public Criteria andMaterialspecIsNotNull() {
            addCriterion("MATERIALSPEC is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialspecEqualTo(String value) {
            addCriterion("MATERIALSPEC =", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecNotEqualTo(String value) {
            addCriterion("MATERIALSPEC <>", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecGreaterThan(String value) {
            addCriterion("MATERIALSPEC >", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIALSPEC >=", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecLessThan(String value) {
            addCriterion("MATERIALSPEC <", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecLessThanOrEqualTo(String value) {
            addCriterion("MATERIALSPEC <=", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecLike(String value) {
            addCriterion("MATERIALSPEC like", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecNotLike(String value) {
            addCriterion("MATERIALSPEC not like", value, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecIn(List<String> values) {
            addCriterion("MATERIALSPEC in", values, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecNotIn(List<String> values) {
            addCriterion("MATERIALSPEC not in", values, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecBetween(String value1, String value2) {
            addCriterion("MATERIALSPEC between", value1, value2, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialspecNotBetween(String value1, String value2) {
            addCriterion("MATERIALSPEC not between", value1, value2, "materialspec");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeIsNull() {
            addCriterion("MATERIALTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeIsNotNull() {
            addCriterion("MATERIALTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeEqualTo(String value) {
            addCriterion("MATERIALTYPE =", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotEqualTo(String value) {
            addCriterion("MATERIALTYPE <>", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeGreaterThan(String value) {
            addCriterion("MATERIALTYPE >", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIALTYPE >=", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLessThan(String value) {
            addCriterion("MATERIALTYPE <", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLessThanOrEqualTo(String value) {
            addCriterion("MATERIALTYPE <=", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLike(String value) {
            addCriterion("MATERIALTYPE like", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotLike(String value) {
            addCriterion("MATERIALTYPE not like", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeIn(List<String> values) {
            addCriterion("MATERIALTYPE in", values, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotIn(List<String> values) {
            addCriterion("MATERIALTYPE not in", values, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeBetween(String value1, String value2) {
            addCriterion("MATERIALTYPE between", value1, value2, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotBetween(String value1, String value2) {
            addCriterion("MATERIALTYPE not between", value1, value2, "materialtype");
            return (Criteria) this;
        }

        public Criteria andCastunitidIsNull() {
            addCriterion("CASTUNITID is null");
            return (Criteria) this;
        }

        public Criteria andCastunitidIsNotNull() {
            addCriterion("CASTUNITID is not null");
            return (Criteria) this;
        }

        public Criteria andCastunitidEqualTo(String value) {
            addCriterion("CASTUNITID =", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidNotEqualTo(String value) {
            addCriterion("CASTUNITID <>", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidGreaterThan(String value) {
            addCriterion("CASTUNITID >", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidGreaterThanOrEqualTo(String value) {
            addCriterion("CASTUNITID >=", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidLessThan(String value) {
            addCriterion("CASTUNITID <", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidLessThanOrEqualTo(String value) {
            addCriterion("CASTUNITID <=", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidLike(String value) {
            addCriterion("CASTUNITID like", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidNotLike(String value) {
            addCriterion("CASTUNITID not like", value, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidIn(List<String> values) {
            addCriterion("CASTUNITID in", values, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidNotIn(List<String> values) {
            addCriterion("CASTUNITID not in", values, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidBetween(String value1, String value2) {
            addCriterion("CASTUNITID between", value1, value2, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCastunitidNotBetween(String value1, String value2) {
            addCriterion("CASTUNITID not between", value1, value2, "castunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidIsNull() {
            addCriterion("CUNITID is null");
            return (Criteria) this;
        }

        public Criteria andCunitidIsNotNull() {
            addCriterion("CUNITID is not null");
            return (Criteria) this;
        }

        public Criteria andCunitidEqualTo(String value) {
            addCriterion("CUNITID =", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidNotEqualTo(String value) {
            addCriterion("CUNITID <>", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidGreaterThan(String value) {
            addCriterion("CUNITID >", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidGreaterThanOrEqualTo(String value) {
            addCriterion("CUNITID >=", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidLessThan(String value) {
            addCriterion("CUNITID <", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidLessThanOrEqualTo(String value) {
            addCriterion("CUNITID <=", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidLike(String value) {
            addCriterion("CUNITID like", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidNotLike(String value) {
            addCriterion("CUNITID not like", value, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidIn(List<String> values) {
            addCriterion("CUNITID in", values, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidNotIn(List<String> values) {
            addCriterion("CUNITID not in", values, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidBetween(String value1, String value2) {
            addCriterion("CUNITID between", value1, value2, "cunitid");
            return (Criteria) this;
        }

        public Criteria andCunitidNotBetween(String value1, String value2) {
            addCriterion("CUNITID not between", value1, value2, "cunitid");
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

        public Criteria andVtransrateIsNull() {
            addCriterion("VTRANSRATE is null");
            return (Criteria) this;
        }

        public Criteria andVtransrateIsNotNull() {
            addCriterion("VTRANSRATE is not null");
            return (Criteria) this;
        }

        public Criteria andVtransrateEqualTo(String value) {
            addCriterion("VTRANSRATE =", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateNotEqualTo(String value) {
            addCriterion("VTRANSRATE <>", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateGreaterThan(String value) {
            addCriterion("VTRANSRATE >", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateGreaterThanOrEqualTo(String value) {
            addCriterion("VTRANSRATE >=", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateLessThan(String value) {
            addCriterion("VTRANSRATE <", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateLessThanOrEqualTo(String value) {
            addCriterion("VTRANSRATE <=", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateLike(String value) {
            addCriterion("VTRANSRATE like", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateNotLike(String value) {
            addCriterion("VTRANSRATE not like", value, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateIn(List<String> values) {
            addCriterion("VTRANSRATE in", values, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateNotIn(List<String> values) {
            addCriterion("VTRANSRATE not in", values, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateBetween(String value1, String value2) {
            addCriterion("VTRANSRATE between", value1, value2, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andVtransrateNotBetween(String value1, String value2) {
            addCriterion("VTRANSRATE not between", value1, value2, "vtransrate");
            return (Criteria) this;
        }

        public Criteria andNinassistnumIsNull() {
            addCriterion("NINASSISTNUM is null");
            return (Criteria) this;
        }

        public Criteria andNinassistnumIsNotNull() {
            addCriterion("NINASSISTNUM is not null");
            return (Criteria) this;
        }

        public Criteria andNinassistnumEqualTo(BigDecimal value) {
            addCriterion("NINASSISTNUM =", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumNotEqualTo(BigDecimal value) {
            addCriterion("NINASSISTNUM <>", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumGreaterThan(BigDecimal value) {
            addCriterion("NINASSISTNUM >", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NINASSISTNUM >=", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumLessThan(BigDecimal value) {
            addCriterion("NINASSISTNUM <", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NINASSISTNUM <=", value, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumIn(List<BigDecimal> values) {
            addCriterion("NINASSISTNUM in", values, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumNotIn(List<BigDecimal> values) {
            addCriterion("NINASSISTNUM not in", values, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NINASSISTNUM between", value1, value2, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinassistnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NINASSISTNUM not between", value1, value2, "ninassistnum");
            return (Criteria) this;
        }

        public Criteria andNinnumIsNull() {
            addCriterion("NINNUM is null");
            return (Criteria) this;
        }

        public Criteria andNinnumIsNotNull() {
            addCriterion("NINNUM is not null");
            return (Criteria) this;
        }

        public Criteria andNinnumEqualTo(BigDecimal value) {
            addCriterion("NINNUM =", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumNotEqualTo(BigDecimal value) {
            addCriterion("NINNUM <>", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumGreaterThan(BigDecimal value) {
            addCriterion("NINNUM >", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NINNUM >=", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumLessThan(BigDecimal value) {
            addCriterion("NINNUM <", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NINNUM <=", value, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumIn(List<BigDecimal> values) {
            addCriterion("NINNUM in", values, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumNotIn(List<BigDecimal> values) {
            addCriterion("NINNUM not in", values, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NINNUM between", value1, value2, "ninnum");
            return (Criteria) this;
        }

        public Criteria andNinnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NINNUM not between", value1, value2, "ninnum");
            return (Criteria) this;
        }

        public Criteria andDbizindateIsNull() {
            addCriterion("DBIZINDATE is null");
            return (Criteria) this;
        }

        public Criteria andDbizindateIsNotNull() {
            addCriterion("DBIZINDATE is not null");
            return (Criteria) this;
        }

        public Criteria andDbizindateEqualTo(String value) {
            addCriterion("DBIZINDATE =", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateNotEqualTo(String value) {
            addCriterion("DBIZINDATE <>", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateGreaterThan(String value) {
            addCriterion("DBIZINDATE >", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateGreaterThanOrEqualTo(String value) {
            addCriterion("DBIZINDATE >=", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateLessThan(String value) {
            addCriterion("DBIZINDATE <", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateLessThanOrEqualTo(String value) {
            addCriterion("DBIZINDATE <=", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateLike(String value) {
            addCriterion("DBIZINDATE like", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateNotLike(String value) {
            addCriterion("DBIZINDATE not like", value, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateIn(List<String> values) {
            addCriterion("DBIZINDATE in", values, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateNotIn(List<String> values) {
            addCriterion("DBIZINDATE not in", values, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateBetween(String value1, String value2) {
            addCriterion("DBIZINDATE between", value1, value2, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andDbizindateNotBetween(String value1, String value2) {
            addCriterion("DBIZINDATE not between", value1, value2, "dbizindate");
            return (Criteria) this;
        }

        public Criteria andMomenIsNull() {
            addCriterion("MOMEN is null");
            return (Criteria) this;
        }

        public Criteria andMomenIsNotNull() {
            addCriterion("MOMEN is not null");
            return (Criteria) this;
        }

        public Criteria andMomenEqualTo(String value) {
            addCriterion("MOMEN =", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenNotEqualTo(String value) {
            addCriterion("MOMEN <>", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenGreaterThan(String value) {
            addCriterion("MOMEN >", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenGreaterThanOrEqualTo(String value) {
            addCriterion("MOMEN >=", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenLessThan(String value) {
            addCriterion("MOMEN <", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenLessThanOrEqualTo(String value) {
            addCriterion("MOMEN <=", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenLike(String value) {
            addCriterion("MOMEN like", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenNotLike(String value) {
            addCriterion("MOMEN not like", value, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenIn(List<String> values) {
            addCriterion("MOMEN in", values, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenNotIn(List<String> values) {
            addCriterion("MOMEN not in", values, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenBetween(String value1, String value2) {
            addCriterion("MOMEN between", value1, value2, "momen");
            return (Criteria) this;
        }

        public Criteria andMomenNotBetween(String value1, String value2) {
            addCriterion("MOMEN not between", value1, value2, "momen");
            return (Criteria) this;
        }

        public Criteria andVbdef1IsNull() {
            addCriterion("VBDEF1 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef1IsNotNull() {
            addCriterion("VBDEF1 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef1EqualTo(String value) {
            addCriterion("VBDEF1 =", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1NotEqualTo(String value) {
            addCriterion("VBDEF1 <>", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1GreaterThan(String value) {
            addCriterion("VBDEF1 >", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF1 >=", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1LessThan(String value) {
            addCriterion("VBDEF1 <", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1LessThanOrEqualTo(String value) {
            addCriterion("VBDEF1 <=", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1Like(String value) {
            addCriterion("VBDEF1 like", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1NotLike(String value) {
            addCriterion("VBDEF1 not like", value, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1In(List<String> values) {
            addCriterion("VBDEF1 in", values, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1NotIn(List<String> values) {
            addCriterion("VBDEF1 not in", values, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1Between(String value1, String value2) {
            addCriterion("VBDEF1 between", value1, value2, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef1NotBetween(String value1, String value2) {
            addCriterion("VBDEF1 not between", value1, value2, "vbdef1");
            return (Criteria) this;
        }

        public Criteria andVbdef2IsNull() {
            addCriterion("VBDEF2 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef2IsNotNull() {
            addCriterion("VBDEF2 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef2EqualTo(String value) {
            addCriterion("VBDEF2 =", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2NotEqualTo(String value) {
            addCriterion("VBDEF2 <>", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2GreaterThan(String value) {
            addCriterion("VBDEF2 >", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF2 >=", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2LessThan(String value) {
            addCriterion("VBDEF2 <", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2LessThanOrEqualTo(String value) {
            addCriterion("VBDEF2 <=", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2Like(String value) {
            addCriterion("VBDEF2 like", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2NotLike(String value) {
            addCriterion("VBDEF2 not like", value, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2In(List<String> values) {
            addCriterion("VBDEF2 in", values, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2NotIn(List<String> values) {
            addCriterion("VBDEF2 not in", values, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2Between(String value1, String value2) {
            addCriterion("VBDEF2 between", value1, value2, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef2NotBetween(String value1, String value2) {
            addCriterion("VBDEF2 not between", value1, value2, "vbdef2");
            return (Criteria) this;
        }

        public Criteria andVbdef3IsNull() {
            addCriterion("VBDEF3 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef3IsNotNull() {
            addCriterion("VBDEF3 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef3EqualTo(String value) {
            addCriterion("VBDEF3 =", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3NotEqualTo(String value) {
            addCriterion("VBDEF3 <>", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3GreaterThan(String value) {
            addCriterion("VBDEF3 >", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF3 >=", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3LessThan(String value) {
            addCriterion("VBDEF3 <", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3LessThanOrEqualTo(String value) {
            addCriterion("VBDEF3 <=", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3Like(String value) {
            addCriterion("VBDEF3 like", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3NotLike(String value) {
            addCriterion("VBDEF3 not like", value, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3In(List<String> values) {
            addCriterion("VBDEF3 in", values, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3NotIn(List<String> values) {
            addCriterion("VBDEF3 not in", values, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3Between(String value1, String value2) {
            addCriterion("VBDEF3 between", value1, value2, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef3NotBetween(String value1, String value2) {
            addCriterion("VBDEF3 not between", value1, value2, "vbdef3");
            return (Criteria) this;
        }

        public Criteria andVbdef4IsNull() {
            addCriterion("VBDEF4 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef4IsNotNull() {
            addCriterion("VBDEF4 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef4EqualTo(String value) {
            addCriterion("VBDEF4 =", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4NotEqualTo(String value) {
            addCriterion("VBDEF4 <>", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4GreaterThan(String value) {
            addCriterion("VBDEF4 >", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF4 >=", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4LessThan(String value) {
            addCriterion("VBDEF4 <", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4LessThanOrEqualTo(String value) {
            addCriterion("VBDEF4 <=", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4Like(String value) {
            addCriterion("VBDEF4 like", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4NotLike(String value) {
            addCriterion("VBDEF4 not like", value, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4In(List<String> values) {
            addCriterion("VBDEF4 in", values, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4NotIn(List<String> values) {
            addCriterion("VBDEF4 not in", values, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4Between(String value1, String value2) {
            addCriterion("VBDEF4 between", value1, value2, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef4NotBetween(String value1, String value2) {
            addCriterion("VBDEF4 not between", value1, value2, "vbdef4");
            return (Criteria) this;
        }

        public Criteria andVbdef5IsNull() {
            addCriterion("VBDEF5 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef5IsNotNull() {
            addCriterion("VBDEF5 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef5EqualTo(String value) {
            addCriterion("VBDEF5 =", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5NotEqualTo(String value) {
            addCriterion("VBDEF5 <>", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5GreaterThan(String value) {
            addCriterion("VBDEF5 >", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF5 >=", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5LessThan(String value) {
            addCriterion("VBDEF5 <", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5LessThanOrEqualTo(String value) {
            addCriterion("VBDEF5 <=", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5Like(String value) {
            addCriterion("VBDEF5 like", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5NotLike(String value) {
            addCriterion("VBDEF5 not like", value, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5In(List<String> values) {
            addCriterion("VBDEF5 in", values, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5NotIn(List<String> values) {
            addCriterion("VBDEF5 not in", values, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5Between(String value1, String value2) {
            addCriterion("VBDEF5 between", value1, value2, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef5NotBetween(String value1, String value2) {
            addCriterion("VBDEF5 not between", value1, value2, "vbdef5");
            return (Criteria) this;
        }

        public Criteria andVbdef6IsNull() {
            addCriterion("VBDEF6 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef6IsNotNull() {
            addCriterion("VBDEF6 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef6EqualTo(String value) {
            addCriterion("VBDEF6 =", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6NotEqualTo(String value) {
            addCriterion("VBDEF6 <>", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6GreaterThan(String value) {
            addCriterion("VBDEF6 >", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF6 >=", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6LessThan(String value) {
            addCriterion("VBDEF6 <", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6LessThanOrEqualTo(String value) {
            addCriterion("VBDEF6 <=", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6Like(String value) {
            addCriterion("VBDEF6 like", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6NotLike(String value) {
            addCriterion("VBDEF6 not like", value, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6In(List<String> values) {
            addCriterion("VBDEF6 in", values, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6NotIn(List<String> values) {
            addCriterion("VBDEF6 not in", values, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6Between(String value1, String value2) {
            addCriterion("VBDEF6 between", value1, value2, "vbdef6");
            return (Criteria) this;
        }

        public Criteria andVbdef6NotBetween(String value1, String value2) {
            addCriterion("VBDEF6 not between", value1, value2, "vbdef6");
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

        public Criteria andVbdef7IsNull() {
            addCriterion("VBDEF7 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef7IsNotNull() {
            addCriterion("VBDEF7 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef7EqualTo(String value) {
            addCriterion("VBDEF7 =", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7NotEqualTo(String value) {
            addCriterion("VBDEF7 <>", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7GreaterThan(String value) {
            addCriterion("VBDEF7 >", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF7 >=", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7LessThan(String value) {
            addCriterion("VBDEF7 <", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7LessThanOrEqualTo(String value) {
            addCriterion("VBDEF7 <=", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7Like(String value) {
            addCriterion("VBDEF7 like", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7NotLike(String value) {
            addCriterion("VBDEF7 not like", value, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7In(List<String> values) {
            addCriterion("VBDEF7 in", values, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7NotIn(List<String> values) {
            addCriterion("VBDEF7 not in", values, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7Between(String value1, String value2) {
            addCriterion("VBDEF7 between", value1, value2, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVbdef7NotBetween(String value1, String value2) {
            addCriterion("VBDEF7 not between", value1, value2, "vbdef7");
            return (Criteria) this;
        }

        public Criteria andVsrcbidIsNull() {
            addCriterion("VSRCBID is null");
            return (Criteria) this;
        }

        public Criteria andVsrcbidIsNotNull() {
            addCriterion("VSRCBID is not null");
            return (Criteria) this;
        }

        public Criteria andVsrcbidEqualTo(String value) {
            addCriterion("VSRCBID =", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidNotEqualTo(String value) {
            addCriterion("VSRCBID <>", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidGreaterThan(String value) {
            addCriterion("VSRCBID >", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidGreaterThanOrEqualTo(String value) {
            addCriterion("VSRCBID >=", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidLessThan(String value) {
            addCriterion("VSRCBID <", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidLessThanOrEqualTo(String value) {
            addCriterion("VSRCBID <=", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidLike(String value) {
            addCriterion("VSRCBID like", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidNotLike(String value) {
            addCriterion("VSRCBID not like", value, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidIn(List<String> values) {
            addCriterion("VSRCBID in", values, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidNotIn(List<String> values) {
            addCriterion("VSRCBID not in", values, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidBetween(String value1, String value2) {
            addCriterion("VSRCBID between", value1, value2, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVsrcbidNotBetween(String value1, String value2) {
            addCriterion("VSRCBID not between", value1, value2, "vsrcbid");
            return (Criteria) this;
        }

        public Criteria andVbdef8IsNull() {
            addCriterion("VBDEF8 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef8IsNotNull() {
            addCriterion("VBDEF8 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef8EqualTo(String value) {
            addCriterion("VBDEF8 =", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8NotEqualTo(String value) {
            addCriterion("VBDEF8 <>", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8GreaterThan(String value) {
            addCriterion("VBDEF8 >", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF8 >=", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8LessThan(String value) {
            addCriterion("VBDEF8 <", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8LessThanOrEqualTo(String value) {
            addCriterion("VBDEF8 <=", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8Like(String value) {
            addCriterion("VBDEF8 like", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8NotLike(String value) {
            addCriterion("VBDEF8 not like", value, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8In(List<String> values) {
            addCriterion("VBDEF8 in", values, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8NotIn(List<String> values) {
            addCriterion("VBDEF8 not in", values, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8Between(String value1, String value2) {
            addCriterion("VBDEF8 between", value1, value2, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef8NotBetween(String value1, String value2) {
            addCriterion("VBDEF8 not between", value1, value2, "vbdef8");
            return (Criteria) this;
        }

        public Criteria andVbdef9IsNull() {
            addCriterion("VBDEF9 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef9IsNotNull() {
            addCriterion("VBDEF9 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef9EqualTo(String value) {
            addCriterion("VBDEF9 =", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9NotEqualTo(String value) {
            addCriterion("VBDEF9 <>", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9GreaterThan(String value) {
            addCriterion("VBDEF9 >", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF9 >=", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9LessThan(String value) {
            addCriterion("VBDEF9 <", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9LessThanOrEqualTo(String value) {
            addCriterion("VBDEF9 <=", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9Like(String value) {
            addCriterion("VBDEF9 like", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9NotLike(String value) {
            addCriterion("VBDEF9 not like", value, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9In(List<String> values) {
            addCriterion("VBDEF9 in", values, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9NotIn(List<String> values) {
            addCriterion("VBDEF9 not in", values, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9Between(String value1, String value2) {
            addCriterion("VBDEF9 between", value1, value2, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef9NotBetween(String value1, String value2) {
            addCriterion("VBDEF9 not between", value1, value2, "vbdef9");
            return (Criteria) this;
        }

        public Criteria andVbdef10IsNull() {
            addCriterion("VBDEF10 is null");
            return (Criteria) this;
        }

        public Criteria andVbdef10IsNotNull() {
            addCriterion("VBDEF10 is not null");
            return (Criteria) this;
        }

        public Criteria andVbdef10EqualTo(String value) {
            addCriterion("VBDEF10 =", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10NotEqualTo(String value) {
            addCriterion("VBDEF10 <>", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10GreaterThan(String value) {
            addCriterion("VBDEF10 >", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10GreaterThanOrEqualTo(String value) {
            addCriterion("VBDEF10 >=", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10LessThan(String value) {
            addCriterion("VBDEF10 <", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10LessThanOrEqualTo(String value) {
            addCriterion("VBDEF10 <=", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10Like(String value) {
            addCriterion("VBDEF10 like", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10NotLike(String value) {
            addCriterion("VBDEF10 not like", value, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10In(List<String> values) {
            addCriterion("VBDEF10 in", values, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10NotIn(List<String> values) {
            addCriterion("VBDEF10 not in", values, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10Between(String value1, String value2) {
            addCriterion("VBDEF10 between", value1, value2, "vbdef10");
            return (Criteria) this;
        }

        public Criteria andVbdef10NotBetween(String value1, String value2) {
            addCriterion("VBDEF10 not between", value1, value2, "vbdef10");
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

        public Criteria andCostunitpriceIsNull() {
            addCriterion("COSTUNITPRICE is null");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceIsNotNull() {
            addCriterion("COSTUNITPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceEqualTo(BigDecimal value) {
            addCriterion("COSTUNITPRICE =", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceNotEqualTo(BigDecimal value) {
            addCriterion("COSTUNITPRICE <>", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceGreaterThan(BigDecimal value) {
            addCriterion("COSTUNITPRICE >", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COSTUNITPRICE >=", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceLessThan(BigDecimal value) {
            addCriterion("COSTUNITPRICE <", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COSTUNITPRICE <=", value, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceIn(List<BigDecimal> values) {
            addCriterion("COSTUNITPRICE in", values, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceNotIn(List<BigDecimal> values) {
            addCriterion("COSTUNITPRICE not in", values, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COSTUNITPRICE between", value1, value2, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COSTUNITPRICE not between", value1, value2, "costunitprice");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyIsNull() {
            addCriterion("COSTUNITMNY is null");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyIsNotNull() {
            addCriterion("COSTUNITMNY is not null");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyEqualTo(BigDecimal value) {
            addCriterion("COSTUNITMNY =", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyNotEqualTo(BigDecimal value) {
            addCriterion("COSTUNITMNY <>", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyGreaterThan(BigDecimal value) {
            addCriterion("COSTUNITMNY >", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COSTUNITMNY >=", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyLessThan(BigDecimal value) {
            addCriterion("COSTUNITMNY <", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COSTUNITMNY <=", value, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyIn(List<BigDecimal> values) {
            addCriterion("COSTUNITMNY in", values, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyNotIn(List<BigDecimal> values) {
            addCriterion("COSTUNITMNY not in", values, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COSTUNITMNY between", value1, value2, "costunitmny");
            return (Criteria) this;
        }

        public Criteria andCostunitmnyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COSTUNITMNY not between", value1, value2, "costunitmny");
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