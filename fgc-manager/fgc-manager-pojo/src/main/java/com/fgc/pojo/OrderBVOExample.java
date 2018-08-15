package com.fgc.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderBVOExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderBVOExample() {
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

		public Criteria andNpriceIsNull() {
			addCriterion("NPRICE is null");
			return (Criteria) this;
		}

		public Criteria andNpriceIsNotNull() {
			addCriterion("NPRICE is not null");
			return (Criteria) this;
		}

		public Criteria andNpriceEqualTo(BigDecimal value) {
			addCriterion("NPRICE =", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceNotEqualTo(BigDecimal value) {
			addCriterion("NPRICE <>", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceGreaterThan(BigDecimal value) {
			addCriterion("NPRICE >", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NPRICE >=", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceLessThan(BigDecimal value) {
			addCriterion("NPRICE <", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NPRICE <=", value, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceIn(List<BigDecimal> values) {
			addCriterion("NPRICE in", values, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceNotIn(List<BigDecimal> values) {
			addCriterion("NPRICE not in", values, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NPRICE between", value1, value2, "nprice");
			return (Criteria) this;
		}

		public Criteria andNpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NPRICE not between", value1, value2, "nprice");
			return (Criteria) this;
		}

		public Criteria andNmnyIsNull() {
			addCriterion("NMNY is null");
			return (Criteria) this;
		}

		public Criteria andNmnyIsNotNull() {
			addCriterion("NMNY is not null");
			return (Criteria) this;
		}

		public Criteria andNmnyEqualTo(BigDecimal value) {
			addCriterion("NMNY =", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyNotEqualTo(BigDecimal value) {
			addCriterion("NMNY <>", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyGreaterThan(BigDecimal value) {
			addCriterion("NMNY >", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NMNY >=", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyLessThan(BigDecimal value) {
			addCriterion("NMNY <", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NMNY <=", value, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyIn(List<BigDecimal> values) {
			addCriterion("NMNY in", values, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyNotIn(List<BigDecimal> values) {
			addCriterion("NMNY not in", values, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NMNY between", value1, value2, "nmny");
			return (Criteria) this;
		}

		public Criteria andNmnyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NMNY not between", value1, value2, "nmny");
			return (Criteria) this;
		}

		public Criteria andSizecodeIsNull() {
			addCriterion("SIZECODE is null");
			return (Criteria) this;
		}

		public Criteria andSizecodeIsNotNull() {
			addCriterion("SIZECODE is not null");
			return (Criteria) this;
		}

		public Criteria andSizecodeEqualTo(String value) {
			addCriterion("SIZECODE =", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeNotEqualTo(String value) {
			addCriterion("SIZECODE <>", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeGreaterThan(String value) {
			addCriterion("SIZECODE >", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeGreaterThanOrEqualTo(String value) {
			addCriterion("SIZECODE >=", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeLessThan(String value) {
			addCriterion("SIZECODE <", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeLessThanOrEqualTo(String value) {
			addCriterion("SIZECODE <=", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeLike(String value) {
			addCriterion("SIZECODE like", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeNotLike(String value) {
			addCriterion("SIZECODE not like", value, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeIn(List<String> values) {
			addCriterion("SIZECODE in", values, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeNotIn(List<String> values) {
			addCriterion("SIZECODE not in", values, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeBetween(String value1, String value2) {
			addCriterion("SIZECODE between", value1, value2, "sizecode");
			return (Criteria) this;
		}

		public Criteria andSizecodeNotBetween(String value1, String value2) {
			addCriterion("SIZECODE not between", value1, value2, "sizecode");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseIsNull() {
			addCriterion("DELWAREHOUSE is null");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseIsNotNull() {
			addCriterion("DELWAREHOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseEqualTo(String value) {
			addCriterion("DELWAREHOUSE =", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseNotEqualTo(String value) {
			addCriterion("DELWAREHOUSE <>", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseGreaterThan(String value) {
			addCriterion("DELWAREHOUSE >", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseGreaterThanOrEqualTo(String value) {
			addCriterion("DELWAREHOUSE >=", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseLessThan(String value) {
			addCriterion("DELWAREHOUSE <", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseLessThanOrEqualTo(String value) {
			addCriterion("DELWAREHOUSE <=", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseLike(String value) {
			addCriterion("DELWAREHOUSE like", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseNotLike(String value) {
			addCriterion("DELWAREHOUSE not like", value, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseIn(List<String> values) {
			addCriterion("DELWAREHOUSE in", values, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseNotIn(List<String> values) {
			addCriterion("DELWAREHOUSE not in", values, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseBetween(String value1, String value2) {
			addCriterion("DELWAREHOUSE between", value1, value2, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andDelwarehouseNotBetween(String value1, String value2) {
			addCriterion("DELWAREHOUSE not between", value1, value2, "delwarehouse");
			return (Criteria) this;
		}

		public Criteria andNexchangerateIsNull() {
			addCriterion("NEXCHANGERATE is null");
			return (Criteria) this;
		}

		public Criteria andNexchangerateIsNotNull() {
			addCriterion("NEXCHANGERATE is not null");
			return (Criteria) this;
		}

		public Criteria andNexchangerateEqualTo(String value) {
			addCriterion("NEXCHANGERATE =", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateNotEqualTo(String value) {
			addCriterion("NEXCHANGERATE <>", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateGreaterThan(String value) {
			addCriterion("NEXCHANGERATE >", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateGreaterThanOrEqualTo(String value) {
			addCriterion("NEXCHANGERATE >=", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateLessThan(String value) {
			addCriterion("NEXCHANGERATE <", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateLessThanOrEqualTo(String value) {
			addCriterion("NEXCHANGERATE <=", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateLike(String value) {
			addCriterion("NEXCHANGERATE like", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateNotLike(String value) {
			addCriterion("NEXCHANGERATE not like", value, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateIn(List<String> values) {
			addCriterion("NEXCHANGERATE in", values, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateNotIn(List<String> values) {
			addCriterion("NEXCHANGERATE not in", values, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateBetween(String value1, String value2) {
			addCriterion("NEXCHANGERATE between", value1, value2, "nexchangerate");
			return (Criteria) this;
		}

		public Criteria andNexchangerateNotBetween(String value1, String value2) {
			addCriterion("NEXCHANGERATE not between", value1, value2, "nexchangerate");
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

		public Criteria andCsaleunitidIsNull() {
			addCriterion("CSALEUNITID is null");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidIsNotNull() {
			addCriterion("CSALEUNITID is not null");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidEqualTo(String value) {
			addCriterion("CSALEUNITID =", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidNotEqualTo(String value) {
			addCriterion("CSALEUNITID <>", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidGreaterThan(String value) {
			addCriterion("CSALEUNITID >", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidGreaterThanOrEqualTo(String value) {
			addCriterion("CSALEUNITID >=", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidLessThan(String value) {
			addCriterion("CSALEUNITID <", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidLessThanOrEqualTo(String value) {
			addCriterion("CSALEUNITID <=", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidLike(String value) {
			addCriterion("CSALEUNITID like", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidNotLike(String value) {
			addCriterion("CSALEUNITID not like", value, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidIn(List<String> values) {
			addCriterion("CSALEUNITID in", values, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidNotIn(List<String> values) {
			addCriterion("CSALEUNITID not in", values, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidBetween(String value1, String value2) {
			addCriterion("CSALEUNITID between", value1, value2, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andCsaleunitidNotBetween(String value1, String value2) {
			addCriterion("CSALEUNITID not between", value1, value2, "csaleunitid");
			return (Criteria) this;
		}

		public Criteria andVunitratioIsNull() {
			addCriterion("VUNITRATIO is null");
			return (Criteria) this;
		}

		public Criteria andVunitratioIsNotNull() {
			addCriterion("VUNITRATIO is not null");
			return (Criteria) this;
		}

		public Criteria andVunitratioEqualTo(String value) {
			addCriterion("VUNITRATIO =", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioNotEqualTo(String value) {
			addCriterion("VUNITRATIO <>", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioGreaterThan(String value) {
			addCriterion("VUNITRATIO >", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioGreaterThanOrEqualTo(String value) {
			addCriterion("VUNITRATIO >=", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioLessThan(String value) {
			addCriterion("VUNITRATIO <", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioLessThanOrEqualTo(String value) {
			addCriterion("VUNITRATIO <=", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioLike(String value) {
			addCriterion("VUNITRATIO like", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioNotLike(String value) {
			addCriterion("VUNITRATIO not like", value, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioIn(List<String> values) {
			addCriterion("VUNITRATIO in", values, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioNotIn(List<String> values) {
			addCriterion("VUNITRATIO not in", values, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioBetween(String value1, String value2) {
			addCriterion("VUNITRATIO between", value1, value2, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andVunitratioNotBetween(String value1, String value2) {
			addCriterion("VUNITRATIO not between", value1, value2, "vunitratio");
			return (Criteria) this;
		}

		public Criteria andSalenumIsNull() {
			addCriterion("SALENUM is null");
			return (Criteria) this;
		}

		public Criteria andSalenumIsNotNull() {
			addCriterion("SALENUM is not null");
			return (Criteria) this;
		}

		public Criteria andSalenumEqualTo(BigDecimal value) {
			addCriterion("SALENUM =", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumNotEqualTo(BigDecimal value) {
			addCriterion("SALENUM <>", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumGreaterThan(BigDecimal value) {
			addCriterion("SALENUM >", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALENUM >=", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumLessThan(BigDecimal value) {
			addCriterion("SALENUM <", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALENUM <=", value, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumIn(List<BigDecimal> values) {
			addCriterion("SALENUM in", values, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumNotIn(List<BigDecimal> values) {
			addCriterion("SALENUM not in", values, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALENUM between", value1, value2, "salenum");
			return (Criteria) this;
		}

		public Criteria andSalenumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALENUM not between", value1, value2, "salenum");
			return (Criteria) this;
		}

		public Criteria andNsalepriceIsNull() {
			addCriterion("NSALEPRICE is null");
			return (Criteria) this;
		}

		public Criteria andNsalepriceIsNotNull() {
			addCriterion("NSALEPRICE is not null");
			return (Criteria) this;
		}

		public Criteria andNsalepriceEqualTo(BigDecimal value) {
			addCriterion("NSALEPRICE =", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceNotEqualTo(BigDecimal value) {
			addCriterion("NSALEPRICE <>", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceGreaterThan(BigDecimal value) {
			addCriterion("NSALEPRICE >", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NSALEPRICE >=", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceLessThan(BigDecimal value) {
			addCriterion("NSALEPRICE <", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NSALEPRICE <=", value, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceIn(List<BigDecimal> values) {
			addCriterion("NSALEPRICE in", values, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceNotIn(List<BigDecimal> values) {
			addCriterion("NSALEPRICE not in", values, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NSALEPRICE between", value1, value2, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNsalepriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NSALEPRICE not between", value1, value2, "nsaleprice");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumIsNull() {
			addCriterion("NINVOICENUM is null");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumIsNotNull() {
			addCriterion("NINVOICENUM is not null");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumEqualTo(BigDecimal value) {
			addCriterion("NINVOICENUM =", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumNotEqualTo(BigDecimal value) {
			addCriterion("NINVOICENUM <>", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumGreaterThan(BigDecimal value) {
			addCriterion("NINVOICENUM >", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICENUM >=", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumLessThan(BigDecimal value) {
			addCriterion("NINVOICENUM <", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICENUM <=", value, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumIn(List<BigDecimal> values) {
			addCriterion("NINVOICENUM in", values, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumNotIn(List<BigDecimal> values) {
			addCriterion("NINVOICENUM not in", values, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICENUM between", value1, value2, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICENUM not between", value1, value2, "ninvoicenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumIsNull() {
			addCriterion("NINVOICESALENUM is null");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumIsNotNull() {
			addCriterion("NINVOICESALENUM is not null");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumEqualTo(BigDecimal value) {
			addCriterion("NINVOICESALENUM =", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumNotEqualTo(BigDecimal value) {
			addCriterion("NINVOICESALENUM <>", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumGreaterThan(BigDecimal value) {
			addCriterion("NINVOICESALENUM >", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICESALENUM >=", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumLessThan(BigDecimal value) {
			addCriterion("NINVOICESALENUM <", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICESALENUM <=", value, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumIn(List<BigDecimal> values) {
			addCriterion("NINVOICESALENUM in", values, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumNotIn(List<BigDecimal> values) {
			addCriterion("NINVOICESALENUM not in", values, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICESALENUM between", value1, value2, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicesalenumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICESALENUM not between", value1, value2, "ninvoicesalenum");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyIsNull() {
			addCriterion("NINVOICEMNY is null");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyIsNotNull() {
			addCriterion("NINVOICEMNY is not null");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyEqualTo(BigDecimal value) {
			addCriterion("NINVOICEMNY =", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyNotEqualTo(BigDecimal value) {
			addCriterion("NINVOICEMNY <>", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyGreaterThan(BigDecimal value) {
			addCriterion("NINVOICEMNY >", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICEMNY >=", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyLessThan(BigDecimal value) {
			addCriterion("NINVOICEMNY <", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICEMNY <=", value, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyIn(List<BigDecimal> values) {
			addCriterion("NINVOICEMNY in", values, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyNotIn(List<BigDecimal> values) {
			addCriterion("NINVOICEMNY not in", values, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICEMNY between", value1, value2, "ninvoicemny");
			return (Criteria) this;
		}

		public Criteria andNinvoicemnyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICEMNY not between", value1, value2, "ninvoicemny");
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

		public Criteria andNinfonumIsNull() {
			addCriterion("NINFONUM is null");
			return (Criteria) this;
		}

		public Criteria andNinfonumIsNotNull() {
			addCriterion("NINFONUM is not null");
			return (Criteria) this;
		}

		public Criteria andNinfonumEqualTo(BigDecimal value) {
			addCriterion("NINFONUM =", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumNotEqualTo(BigDecimal value) {
			addCriterion("NINFONUM <>", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumGreaterThan(BigDecimal value) {
			addCriterion("NINFONUM >", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINFONUM >=", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumLessThan(BigDecimal value) {
			addCriterion("NINFONUM <", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINFONUM <=", value, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumIn(List<BigDecimal> values) {
			addCriterion("NINFONUM in", values, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumNotIn(List<BigDecimal> values) {
			addCriterion("NINFONUM not in", values, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINFONUM between", value1, value2, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNinfonumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINFONUM not between", value1, value2, "ninfonum");
			return (Criteria) this;
		}

		public Criteria andNoutnumIsNull() {
			addCriterion("NOUTNUM is null");
			return (Criteria) this;
		}

		public Criteria andNoutnumIsNotNull() {
			addCriterion("NOUTNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNoutnumEqualTo(BigDecimal value) {
			addCriterion("NOUTNUM =", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumNotEqualTo(BigDecimal value) {
			addCriterion("NOUTNUM <>", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumGreaterThan(BigDecimal value) {
			addCriterion("NOUTNUM >", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NOUTNUM >=", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumLessThan(BigDecimal value) {
			addCriterion("NOUTNUM <", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NOUTNUM <=", value, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumIn(List<BigDecimal> values) {
			addCriterion("NOUTNUM in", values, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumNotIn(List<BigDecimal> values) {
			addCriterion("NOUTNUM not in", values, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NOUTNUM between", value1, value2, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNoutnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NOUTNUM not between", value1, value2, "noutnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumIsNull() {
			addCriterion("NRETURNNUM is null");
			return (Criteria) this;
		}

		public Criteria andNreturnnumIsNotNull() {
			addCriterion("NRETURNNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNreturnnumEqualTo(BigDecimal value) {
			addCriterion("NRETURNNUM =", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumNotEqualTo(BigDecimal value) {
			addCriterion("NRETURNNUM <>", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumGreaterThan(BigDecimal value) {
			addCriterion("NRETURNNUM >", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NRETURNNUM >=", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumLessThan(BigDecimal value) {
			addCriterion("NRETURNNUM <", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NRETURNNUM <=", value, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumIn(List<BigDecimal> values) {
			addCriterion("NRETURNNUM in", values, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumNotIn(List<BigDecimal> values) {
			addCriterion("NRETURNNUM not in", values, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NRETURNNUM between", value1, value2, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andNreturnnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NRETURNNUM not between", value1, value2, "nreturnnum");
			return (Criteria) this;
		}

		public Criteria andGiftIsNull() {
			addCriterion("GIFT is null");
			return (Criteria) this;
		}

		public Criteria andGiftIsNotNull() {
			addCriterion("GIFT is not null");
			return (Criteria) this;
		}

		public Criteria andGiftEqualTo(Long value) {
			addCriterion("GIFT =", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftNotEqualTo(Long value) {
			addCriterion("GIFT <>", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftGreaterThan(Long value) {
			addCriterion("GIFT >", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftGreaterThanOrEqualTo(Long value) {
			addCriterion("GIFT >=", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftLessThan(Long value) {
			addCriterion("GIFT <", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftLessThanOrEqualTo(Long value) {
			addCriterion("GIFT <=", value, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftIn(List<Long> values) {
			addCriterion("GIFT in", values, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftNotIn(List<Long> values) {
			addCriterion("GIFT not in", values, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftBetween(Long value1, Long value2) {
			addCriterion("GIFT between", value1, value2, "gift");
			return (Criteria) this;
		}

		public Criteria andGiftNotBetween(Long value1, Long value2) {
			addCriterion("GIFT not between", value1, value2, "gift");
			return (Criteria) this;
		}

		public Criteria andServicesIsNull() {
			addCriterion("SERVICES is null");
			return (Criteria) this;
		}

		public Criteria andServicesIsNotNull() {
			addCriterion("SERVICES is not null");
			return (Criteria) this;
		}

		public Criteria andServicesEqualTo(Long value) {
			addCriterion("SERVICES =", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesNotEqualTo(Long value) {
			addCriterion("SERVICES <>", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesGreaterThan(Long value) {
			addCriterion("SERVICES >", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesGreaterThanOrEqualTo(Long value) {
			addCriterion("SERVICES >=", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesLessThan(Long value) {
			addCriterion("SERVICES <", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesLessThanOrEqualTo(Long value) {
			addCriterion("SERVICES <=", value, "services");
			return (Criteria) this;
		}

		public Criteria andServicesIn(List<Long> values) {
			addCriterion("SERVICES in", values, "services");
			return (Criteria) this;
		}

		public Criteria andServicesNotIn(List<Long> values) {
			addCriterion("SERVICES not in", values, "services");
			return (Criteria) this;
		}

		public Criteria andServicesBetween(Long value1, Long value2) {
			addCriterion("SERVICES between", value1, value2, "services");
			return (Criteria) this;
		}

		public Criteria andServicesNotBetween(Long value1, Long value2) {
			addCriterion("SERVICES not between", value1, value2, "services");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumIsNull() {
			addCriterion("NTHISINFONUM is null");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumIsNotNull() {
			addCriterion("NTHISINFONUM is not null");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumEqualTo(BigDecimal value) {
			addCriterion("NTHISINFONUM =", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumNotEqualTo(BigDecimal value) {
			addCriterion("NTHISINFONUM <>", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumGreaterThan(BigDecimal value) {
			addCriterion("NTHISINFONUM >", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NTHISINFONUM >=", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumLessThan(BigDecimal value) {
			addCriterion("NTHISINFONUM <", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NTHISINFONUM <=", value, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumIn(List<BigDecimal> values) {
			addCriterion("NTHISINFONUM in", values, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumNotIn(List<BigDecimal> values) {
			addCriterion("NTHISINFONUM not in", values, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NTHISINFONUM between", value1, value2, "nthisinfonum");
			return (Criteria) this;
		}

		public Criteria andNthisinfonumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NTHISINFONUM not between", value1, value2, "nthisinfonum");
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

		public Criteria andNnumIsNull() {
			addCriterion("NNUM is null");
			return (Criteria) this;
		}

		public Criteria andNnumIsNotNull() {
			addCriterion("NNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNnumEqualTo(BigDecimal value) {
			addCriterion("NNUM =", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumNotEqualTo(BigDecimal value) {
			addCriterion("NNUM <>", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumGreaterThan(BigDecimal value) {
			addCriterion("NNUM >", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NNUM >=", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumLessThan(BigDecimal value) {
			addCriterion("NNUM <", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NNUM <=", value, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumIn(List<BigDecimal> values) {
			addCriterion("NNUM in", values, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumNotIn(List<BigDecimal> values) {
			addCriterion("NNUM not in", values, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NNUM between", value1, value2, "nnum");
			return (Criteria) this;
		}

		public Criteria andNnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NNUM not between", value1, value2, "nnum");
			return (Criteria) this;
		}

		public Criteria andMeasrateIsNull() {
			addCriterion("MEASRATE is null");
			return (Criteria) this;
		}

		public Criteria andMeasrateIsNotNull() {
			addCriterion("MEASRATE is not null");
			return (Criteria) this;
		}

		public Criteria andMeasrateEqualTo(String value) {
			addCriterion("MEASRATE =", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateNotEqualTo(String value) {
			addCriterion("MEASRATE <>", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateGreaterThan(String value) {
			addCriterion("MEASRATE >", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateGreaterThanOrEqualTo(String value) {
			addCriterion("MEASRATE >=", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateLessThan(String value) {
			addCriterion("MEASRATE <", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateLessThanOrEqualTo(String value) {
			addCriterion("MEASRATE <=", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateLike(String value) {
			addCriterion("MEASRATE like", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateNotLike(String value) {
			addCriterion("MEASRATE not like", value, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateIn(List<String> values) {
			addCriterion("MEASRATE in", values, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateNotIn(List<String> values) {
			addCriterion("MEASRATE not in", values, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateBetween(String value1, String value2) {
			addCriterion("MEASRATE between", value1, value2, "measrate");
			return (Criteria) this;
		}

		public Criteria andMeasrateNotBetween(String value1, String value2) {
			addCriterion("MEASRATE not between", value1, value2, "measrate");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumIsNull() {
			addCriterion("NINVOICENASTNUM is null");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumIsNotNull() {
			addCriterion("NINVOICENASTNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumEqualTo(BigDecimal value) {
			addCriterion("NINVOICENASTNUM =", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumNotEqualTo(BigDecimal value) {
			addCriterion("NINVOICENASTNUM <>", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumGreaterThan(BigDecimal value) {
			addCriterion("NINVOICENASTNUM >", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICENASTNUM >=", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumLessThan(BigDecimal value) {
			addCriterion("NINVOICENASTNUM <", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINVOICENASTNUM <=", value, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumIn(List<BigDecimal> values) {
			addCriterion("NINVOICENASTNUM in", values, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumNotIn(List<BigDecimal> values) {
			addCriterion("NINVOICENASTNUM not in", values, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICENASTNUM between", value1, value2, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinvoicenastnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINVOICENASTNUM not between", value1, value2, "ninvoicenastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumIsNull() {
			addCriterion("NINASTNUM is null");
			return (Criteria) this;
		}

		public Criteria andNinastnumIsNotNull() {
			addCriterion("NINASTNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNinastnumEqualTo(BigDecimal value) {
			addCriterion("NINASTNUM =", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumNotEqualTo(BigDecimal value) {
			addCriterion("NINASTNUM <>", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumGreaterThan(BigDecimal value) {
			addCriterion("NINASTNUM >", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NINASTNUM >=", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumLessThan(BigDecimal value) {
			addCriterion("NINASTNUM <", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NINASTNUM <=", value, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumIn(List<BigDecimal> values) {
			addCriterion("NINASTNUM in", values, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumNotIn(List<BigDecimal> values) {
			addCriterion("NINASTNUM not in", values, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINASTNUM between", value1, value2, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNinastnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NINASTNUM not between", value1, value2, "ninastnum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumIsNull() {
			addCriterion("NOUTNASTUM is null");
			return (Criteria) this;
		}

		public Criteria andNoutnastumIsNotNull() {
			addCriterion("NOUTNASTUM is not null");
			return (Criteria) this;
		}

		public Criteria andNoutnastumEqualTo(BigDecimal value) {
			addCriterion("NOUTNASTUM =", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumNotEqualTo(BigDecimal value) {
			addCriterion("NOUTNASTUM <>", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumGreaterThan(BigDecimal value) {
			addCriterion("NOUTNASTUM >", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NOUTNASTUM >=", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumLessThan(BigDecimal value) {
			addCriterion("NOUTNASTUM <", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NOUTNASTUM <=", value, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumIn(List<BigDecimal> values) {
			addCriterion("NOUTNASTUM in", values, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumNotIn(List<BigDecimal> values) {
			addCriterion("NOUTNASTUM not in", values, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NOUTNASTUM between", value1, value2, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNoutnastumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NOUTNASTUM not between", value1, value2, "noutnastum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumIsNull() {
			addCriterion("NRETURNASTNUM is null");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumIsNotNull() {
			addCriterion("NRETURNASTNUM is not null");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumEqualTo(BigDecimal value) {
			addCriterion("NRETURNASTNUM =", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumNotEqualTo(BigDecimal value) {
			addCriterion("NRETURNASTNUM <>", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumGreaterThan(BigDecimal value) {
			addCriterion("NRETURNASTNUM >", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NRETURNASTNUM >=", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumLessThan(BigDecimal value) {
			addCriterion("NRETURNASTNUM <", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NRETURNASTNUM <=", value, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumIn(List<BigDecimal> values) {
			addCriterion("NRETURNASTNUM in", values, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumNotIn(List<BigDecimal> values) {
			addCriterion("NRETURNASTNUM not in", values, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NRETURNASTNUM between", value1, value2, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andNreturnastnumNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NRETURNASTNUM not between", value1, value2, "nreturnastnum");
			return (Criteria) this;
		}

		public Criteria andSalenumGreaterThanNinvoicesalenum() {
			addCriterion("NVL(SALENUM,0) - NVL(NINVOICESALENUM,0) <> 0 ");
			return (Criteria) this;
		}
		
		public Criteria andNastnumGreaterThanNinastnum() {
			addCriterion("NVL(NASTNUM,0) -NVL(NINASTNUM,0) <> 0");
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