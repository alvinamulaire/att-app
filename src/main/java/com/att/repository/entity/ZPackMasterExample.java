package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZPackMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZPackMasterExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("SID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("SID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("SID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("SID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("SID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("SID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("SID like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("SID not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("SID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("SID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("SID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("SID not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("SITE is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("SITE is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("SITE =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("SITE <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("SITE >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("SITE >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("SITE <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("SITE <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("SITE like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("SITE not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("SITE in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("SITE not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("SITE between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("SITE not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andContainerNameIsNull() {
            addCriterion("CONTAINER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContainerNameIsNotNull() {
            addCriterion("CONTAINER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContainerNameEqualTo(String value) {
            addCriterion("CONTAINER_NAME =", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotEqualTo(String value) {
            addCriterion("CONTAINER_NAME <>", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameGreaterThan(String value) {
            addCriterion("CONTAINER_NAME >", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTAINER_NAME >=", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLessThan(String value) {
            addCriterion("CONTAINER_NAME <", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLessThanOrEqualTo(String value) {
            addCriterion("CONTAINER_NAME <=", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameLike(String value) {
            addCriterion("CONTAINER_NAME like", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotLike(String value) {
            addCriterion("CONTAINER_NAME not like", value, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameIn(List<String> values) {
            addCriterion("CONTAINER_NAME in", values, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotIn(List<String> values) {
            addCriterion("CONTAINER_NAME not in", values, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameBetween(String value1, String value2) {
            addCriterion("CONTAINER_NAME between", value1, value2, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNameNotBetween(String value1, String value2) {
            addCriterion("CONTAINER_NAME not between", value1, value2, "containerName");
            return (Criteria) this;
        }

        public Criteria andContainerNoIsNull() {
            addCriterion("CONTAINER_NO is null");
            return (Criteria) this;
        }

        public Criteria andContainerNoIsNotNull() {
            addCriterion("CONTAINER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andContainerNoEqualTo(String value) {
            addCriterion("CONTAINER_NO =", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoNotEqualTo(String value) {
            addCriterion("CONTAINER_NO <>", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoGreaterThan(String value) {
            addCriterion("CONTAINER_NO >", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONTAINER_NO >=", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoLessThan(String value) {
            addCriterion("CONTAINER_NO <", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoLessThanOrEqualTo(String value) {
            addCriterion("CONTAINER_NO <=", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoLike(String value) {
            addCriterion("CONTAINER_NO like", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoNotLike(String value) {
            addCriterion("CONTAINER_NO not like", value, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoIn(List<String> values) {
            addCriterion("CONTAINER_NO in", values, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoNotIn(List<String> values) {
            addCriterion("CONTAINER_NO not in", values, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoBetween(String value1, String value2) {
            addCriterion("CONTAINER_NO between", value1, value2, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerNoNotBetween(String value1, String value2) {
            addCriterion("CONTAINER_NO not between", value1, value2, "containerNo");
            return (Criteria) this;
        }

        public Criteria andContainerTypeIsNull() {
            addCriterion("CONTAINER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContainerTypeIsNotNull() {
            addCriterion("CONTAINER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContainerTypeEqualTo(String value) {
            addCriterion("CONTAINER_TYPE =", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeNotEqualTo(String value) {
            addCriterion("CONTAINER_TYPE <>", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeGreaterThan(String value) {
            addCriterion("CONTAINER_TYPE >", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTAINER_TYPE >=", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeLessThan(String value) {
            addCriterion("CONTAINER_TYPE <", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTAINER_TYPE <=", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeLike(String value) {
            addCriterion("CONTAINER_TYPE like", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeNotLike(String value) {
            addCriterion("CONTAINER_TYPE not like", value, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeIn(List<String> values) {
            addCriterion("CONTAINER_TYPE in", values, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeNotIn(List<String> values) {
            addCriterion("CONTAINER_TYPE not in", values, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeBetween(String value1, String value2) {
            addCriterion("CONTAINER_TYPE between", value1, value2, "containerType");
            return (Criteria) this;
        }

        public Criteria andContainerTypeNotBetween(String value1, String value2) {
            addCriterion("CONTAINER_TYPE not between", value1, value2, "containerType");
            return (Criteria) this;
        }

        public Criteria andMaxQtyIsNull() {
            addCriterion("MAX_QTY is null");
            return (Criteria) this;
        }

        public Criteria andMaxQtyIsNotNull() {
            addCriterion("MAX_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andMaxQtyEqualTo(BigDecimal value) {
            addCriterion("MAX_QTY =", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyNotEqualTo(BigDecimal value) {
            addCriterion("MAX_QTY <>", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyGreaterThan(BigDecimal value) {
            addCriterion("MAX_QTY >", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_QTY >=", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyLessThan(BigDecimal value) {
            addCriterion("MAX_QTY <", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_QTY <=", value, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyIn(List<BigDecimal> values) {
            addCriterion("MAX_QTY in", values, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyNotIn(List<BigDecimal> values) {
            addCriterion("MAX_QTY not in", values, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_QTY between", value1, value2, "maxQty");
            return (Criteria) this;
        }

        public Criteria andMaxQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_QTY not between", value1, value2, "maxQty");
            return (Criteria) this;
        }

        public Criteria andIsMantissaIsNull() {
            addCriterion("IS_MANTISSA is null");
            return (Criteria) this;
        }

        public Criteria andIsMantissaIsNotNull() {
            addCriterion("IS_MANTISSA is not null");
            return (Criteria) this;
        }

        public Criteria andIsMantissaEqualTo(String value) {
            addCriterion("IS_MANTISSA =", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaNotEqualTo(String value) {
            addCriterion("IS_MANTISSA <>", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaGreaterThan(String value) {
            addCriterion("IS_MANTISSA >", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MANTISSA >=", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaLessThan(String value) {
            addCriterion("IS_MANTISSA <", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaLessThanOrEqualTo(String value) {
            addCriterion("IS_MANTISSA <=", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaLike(String value) {
            addCriterion("IS_MANTISSA like", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaNotLike(String value) {
            addCriterion("IS_MANTISSA not like", value, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaIn(List<String> values) {
            addCriterion("IS_MANTISSA in", values, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaNotIn(List<String> values) {
            addCriterion("IS_MANTISSA not in", values, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaBetween(String value1, String value2) {
            addCriterion("IS_MANTISSA between", value1, value2, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andIsMantissaNotBetween(String value1, String value2) {
            addCriterion("IS_MANTISSA not between", value1, value2, "isMantissa");
            return (Criteria) this;
        }

        public Criteria andMfgDateIsNull() {
            addCriterion("MFG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andMfgDateIsNotNull() {
            addCriterion("MFG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andMfgDateEqualTo(String value) {
            addCriterion("MFG_DATE =", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateNotEqualTo(String value) {
            addCriterion("MFG_DATE <>", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateGreaterThan(String value) {
            addCriterion("MFG_DATE >", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateGreaterThanOrEqualTo(String value) {
            addCriterion("MFG_DATE >=", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateLessThan(String value) {
            addCriterion("MFG_DATE <", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateLessThanOrEqualTo(String value) {
            addCriterion("MFG_DATE <=", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateLike(String value) {
            addCriterion("MFG_DATE like", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateNotLike(String value) {
            addCriterion("MFG_DATE not like", value, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateIn(List<String> values) {
            addCriterion("MFG_DATE in", values, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateNotIn(List<String> values) {
            addCriterion("MFG_DATE not in", values, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateBetween(String value1, String value2) {
            addCriterion("MFG_DATE between", value1, value2, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andMfgDateNotBetween(String value1, String value2) {
            addCriterion("MFG_DATE not between", value1, value2, "mfgDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNull() {
            addCriterion("EXP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNotNull() {
            addCriterion("EXP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpDateEqualTo(String value) {
            addCriterion("EXP_DATE =", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotEqualTo(String value) {
            addCriterion("EXP_DATE <>", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThan(String value) {
            addCriterion("EXP_DATE >", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThanOrEqualTo(String value) {
            addCriterion("EXP_DATE >=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThan(String value) {
            addCriterion("EXP_DATE <", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThanOrEqualTo(String value) {
            addCriterion("EXP_DATE <=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLike(String value) {
            addCriterion("EXP_DATE like", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotLike(String value) {
            addCriterion("EXP_DATE not like", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIn(List<String> values) {
            addCriterion("EXP_DATE in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotIn(List<String> values) {
            addCriterion("EXP_DATE not in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateBetween(String value1, String value2) {
            addCriterion("EXP_DATE between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotBetween(String value1, String value2) {
            addCriterion("EXP_DATE not between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1IsNull() {
            addCriterion("DMX_MFG_1 is null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1IsNotNull() {
            addCriterion("DMX_MFG_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1EqualTo(String value) {
            addCriterion("DMX_MFG_1 =", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1NotEqualTo(String value) {
            addCriterion("DMX_MFG_1 <>", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1GreaterThan(String value) {
            addCriterion("DMX_MFG_1 >", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_1 >=", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1LessThan(String value) {
            addCriterion("DMX_MFG_1 <", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1LessThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_1 <=", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1Like(String value) {
            addCriterion("DMX_MFG_1 like", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1NotLike(String value) {
            addCriterion("DMX_MFG_1 not like", value, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1In(List<String> values) {
            addCriterion("DMX_MFG_1 in", values, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1NotIn(List<String> values) {
            addCriterion("DMX_MFG_1 not in", values, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1Between(String value1, String value2) {
            addCriterion("DMX_MFG_1 between", value1, value2, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg1NotBetween(String value1, String value2) {
            addCriterion("DMX_MFG_1 not between", value1, value2, "dmxMfg1");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2IsNull() {
            addCriterion("DMX_MFG_2 is null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2IsNotNull() {
            addCriterion("DMX_MFG_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2EqualTo(String value) {
            addCriterion("DMX_MFG_2 =", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2NotEqualTo(String value) {
            addCriterion("DMX_MFG_2 <>", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2GreaterThan(String value) {
            addCriterion("DMX_MFG_2 >", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_2 >=", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2LessThan(String value) {
            addCriterion("DMX_MFG_2 <", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2LessThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_2 <=", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2Like(String value) {
            addCriterion("DMX_MFG_2 like", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2NotLike(String value) {
            addCriterion("DMX_MFG_2 not like", value, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2In(List<String> values) {
            addCriterion("DMX_MFG_2 in", values, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2NotIn(List<String> values) {
            addCriterion("DMX_MFG_2 not in", values, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2Between(String value1, String value2) {
            addCriterion("DMX_MFG_2 between", value1, value2, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg2NotBetween(String value1, String value2) {
            addCriterion("DMX_MFG_2 not between", value1, value2, "dmxMfg2");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3IsNull() {
            addCriterion("DMX_MFG_3 is null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3IsNotNull() {
            addCriterion("DMX_MFG_3 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3EqualTo(String value) {
            addCriterion("DMX_MFG_3 =", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3NotEqualTo(String value) {
            addCriterion("DMX_MFG_3 <>", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3GreaterThan(String value) {
            addCriterion("DMX_MFG_3 >", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_3 >=", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3LessThan(String value) {
            addCriterion("DMX_MFG_3 <", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3LessThanOrEqualTo(String value) {
            addCriterion("DMX_MFG_3 <=", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3Like(String value) {
            addCriterion("DMX_MFG_3 like", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3NotLike(String value) {
            addCriterion("DMX_MFG_3 not like", value, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3In(List<String> values) {
            addCriterion("DMX_MFG_3 in", values, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3NotIn(List<String> values) {
            addCriterion("DMX_MFG_3 not in", values, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3Between(String value1, String value2) {
            addCriterion("DMX_MFG_3 between", value1, value2, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxMfg3NotBetween(String value1, String value2) {
            addCriterion("DMX_MFG_3 not between", value1, value2, "dmxMfg3");
            return (Criteria) this;
        }

        public Criteria andDmxExp1IsNull() {
            addCriterion("DMX_EXP_1 is null");
            return (Criteria) this;
        }

        public Criteria andDmxExp1IsNotNull() {
            addCriterion("DMX_EXP_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxExp1EqualTo(String value) {
            addCriterion("DMX_EXP_1 =", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1NotEqualTo(String value) {
            addCriterion("DMX_EXP_1 <>", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1GreaterThan(String value) {
            addCriterion("DMX_EXP_1 >", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_1 >=", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1LessThan(String value) {
            addCriterion("DMX_EXP_1 <", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1LessThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_1 <=", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1Like(String value) {
            addCriterion("DMX_EXP_1 like", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1NotLike(String value) {
            addCriterion("DMX_EXP_1 not like", value, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1In(List<String> values) {
            addCriterion("DMX_EXP_1 in", values, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1NotIn(List<String> values) {
            addCriterion("DMX_EXP_1 not in", values, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1Between(String value1, String value2) {
            addCriterion("DMX_EXP_1 between", value1, value2, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp1NotBetween(String value1, String value2) {
            addCriterion("DMX_EXP_1 not between", value1, value2, "dmxExp1");
            return (Criteria) this;
        }

        public Criteria andDmxExp2IsNull() {
            addCriterion("DMX_EXP_2 is null");
            return (Criteria) this;
        }

        public Criteria andDmxExp2IsNotNull() {
            addCriterion("DMX_EXP_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxExp2EqualTo(String value) {
            addCriterion("DMX_EXP_2 =", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2NotEqualTo(String value) {
            addCriterion("DMX_EXP_2 <>", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2GreaterThan(String value) {
            addCriterion("DMX_EXP_2 >", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_2 >=", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2LessThan(String value) {
            addCriterion("DMX_EXP_2 <", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2LessThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_2 <=", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2Like(String value) {
            addCriterion("DMX_EXP_2 like", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2NotLike(String value) {
            addCriterion("DMX_EXP_2 not like", value, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2In(List<String> values) {
            addCriterion("DMX_EXP_2 in", values, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2NotIn(List<String> values) {
            addCriterion("DMX_EXP_2 not in", values, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2Between(String value1, String value2) {
            addCriterion("DMX_EXP_2 between", value1, value2, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp2NotBetween(String value1, String value2) {
            addCriterion("DMX_EXP_2 not between", value1, value2, "dmxExp2");
            return (Criteria) this;
        }

        public Criteria andDmxExp3IsNull() {
            addCriterion("DMX_EXP_3 is null");
            return (Criteria) this;
        }

        public Criteria andDmxExp3IsNotNull() {
            addCriterion("DMX_EXP_3 is not null");
            return (Criteria) this;
        }

        public Criteria andDmxExp3EqualTo(String value) {
            addCriterion("DMX_EXP_3 =", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3NotEqualTo(String value) {
            addCriterion("DMX_EXP_3 <>", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3GreaterThan(String value) {
            addCriterion("DMX_EXP_3 >", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3GreaterThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_3 >=", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3LessThan(String value) {
            addCriterion("DMX_EXP_3 <", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3LessThanOrEqualTo(String value) {
            addCriterion("DMX_EXP_3 <=", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3Like(String value) {
            addCriterion("DMX_EXP_3 like", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3NotLike(String value) {
            addCriterion("DMX_EXP_3 not like", value, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3In(List<String> values) {
            addCriterion("DMX_EXP_3 in", values, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3NotIn(List<String> values) {
            addCriterion("DMX_EXP_3 not in", values, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3Between(String value1, String value2) {
            addCriterion("DMX_EXP_3 between", value1, value2, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andDmxExp3NotBetween(String value1, String value2) {
            addCriterion("DMX_EXP_3 not between", value1, value2, "dmxExp3");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andShippingDateIsNull() {
            addCriterion("SHIPPING_DATE is null");
            return (Criteria) this;
        }

        public Criteria andShippingDateIsNotNull() {
            addCriterion("SHIPPING_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andShippingDateEqualTo(String value) {
            addCriterion("SHIPPING_DATE =", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateNotEqualTo(String value) {
            addCriterion("SHIPPING_DATE <>", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateGreaterThan(String value) {
            addCriterion("SHIPPING_DATE >", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPPING_DATE >=", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateLessThan(String value) {
            addCriterion("SHIPPING_DATE <", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateLessThanOrEqualTo(String value) {
            addCriterion("SHIPPING_DATE <=", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateLike(String value) {
            addCriterion("SHIPPING_DATE like", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateNotLike(String value) {
            addCriterion("SHIPPING_DATE not like", value, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateIn(List<String> values) {
            addCriterion("SHIPPING_DATE in", values, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateNotIn(List<String> values) {
            addCriterion("SHIPPING_DATE not in", values, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateBetween(String value1, String value2) {
            addCriterion("SHIPPING_DATE between", value1, value2, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andShippingDateNotBetween(String value1, String value2) {
            addCriterion("SHIPPING_DATE not between", value1, value2, "shippingDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNull() {
            addCriterion("CREATED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNotNull() {
            addCriterion("CREATED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME =", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <>", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThan(Date value) {
            addCriterion("CREATED_DATE_TIME >", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME >=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThan(Date value) {
            addCriterion("CREATED_DATE_TIME <", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME not in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME not between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNull() {
            addCriterion("CREATED_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNotNull() {
            addCriterion("CREATED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserEqualTo(String value) {
            addCriterion("CREATED_USER =", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotEqualTo(String value) {
            addCriterion("CREATED_USER <>", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThan(String value) {
            addCriterion("CREATED_USER >", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_USER >=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThan(String value) {
            addCriterion("CREATED_USER <", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThanOrEqualTo(String value) {
            addCriterion("CREATED_USER <=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLike(String value) {
            addCriterion("CREATED_USER like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotLike(String value) {
            addCriterion("CREATED_USER not like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIn(List<String> values) {
            addCriterion("CREATED_USER in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotIn(List<String> values) {
            addCriterion("CREATED_USER not in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserBetween(String value1, String value2) {
            addCriterion("CREATED_USER between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotBetween(String value1, String value2) {
            addCriterion("CREATED_USER not between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNull() {
            addCriterion("MODIFIED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNotNull() {
            addCriterion("MODIFIED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME =", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <>", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME >", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME >=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME <", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME not in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME not between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIsNull() {
            addCriterion("MODIFIED_USER is null");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIsNotNull() {
            addCriterion("MODIFIED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedUserEqualTo(String value) {
            addCriterion("MODIFIED_USER =", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotEqualTo(String value) {
            addCriterion("MODIFIED_USER <>", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserGreaterThan(String value) {
            addCriterion("MODIFIED_USER >", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_USER >=", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLessThan(String value) {
            addCriterion("MODIFIED_USER <", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_USER <=", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLike(String value) {
            addCriterion("MODIFIED_USER like", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotLike(String value) {
            addCriterion("MODIFIED_USER not like", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIn(List<String> values) {
            addCriterion("MODIFIED_USER in", values, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotIn(List<String> values) {
            addCriterion("MODIFIED_USER not in", values, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserBetween(String value1, String value2) {
            addCriterion("MODIFIED_USER between", value1, value2, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_USER not between", value1, value2, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeIsNull() {
            addCriterion("CLOSE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeIsNotNull() {
            addCriterion("CLOSE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeEqualTo(Date value) {
            addCriterion("CLOSE_DATE_TIME =", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeNotEqualTo(Date value) {
            addCriterion("CLOSE_DATE_TIME <>", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeGreaterThan(Date value) {
            addCriterion("CLOSE_DATE_TIME >", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CLOSE_DATE_TIME >=", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeLessThan(Date value) {
            addCriterion("CLOSE_DATE_TIME <", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CLOSE_DATE_TIME <=", value, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeIn(List<Date> values) {
            addCriterion("CLOSE_DATE_TIME in", values, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeNotIn(List<Date> values) {
            addCriterion("CLOSE_DATE_TIME not in", values, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeBetween(Date value1, Date value2) {
            addCriterion("CLOSE_DATE_TIME between", value1, value2, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CLOSE_DATE_TIME not between", value1, value2, "closeDateTime");
            return (Criteria) this;
        }

        public Criteria andCloseUserIsNull() {
            addCriterion("CLOSE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCloseUserIsNotNull() {
            addCriterion("CLOSE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCloseUserEqualTo(String value) {
            addCriterion("CLOSE_USER =", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserNotEqualTo(String value) {
            addCriterion("CLOSE_USER <>", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserGreaterThan(String value) {
            addCriterion("CLOSE_USER >", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserGreaterThanOrEqualTo(String value) {
            addCriterion("CLOSE_USER >=", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserLessThan(String value) {
            addCriterion("CLOSE_USER <", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserLessThanOrEqualTo(String value) {
            addCriterion("CLOSE_USER <=", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserLike(String value) {
            addCriterion("CLOSE_USER like", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserNotLike(String value) {
            addCriterion("CLOSE_USER not like", value, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserIn(List<String> values) {
            addCriterion("CLOSE_USER in", values, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserNotIn(List<String> values) {
            addCriterion("CLOSE_USER not in", values, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserBetween(String value1, String value2) {
            addCriterion("CLOSE_USER between", value1, value2, "closeUser");
            return (Criteria) this;
        }

        public Criteria andCloseUserNotBetween(String value1, String value2) {
            addCriterion("CLOSE_USER not between", value1, value2, "closeUser");
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