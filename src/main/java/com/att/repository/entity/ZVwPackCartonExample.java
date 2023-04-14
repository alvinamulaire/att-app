package com.att.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class ZVwPackCartonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwPackCartonExample() {
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

        public Criteria andCartonSidIsNull() {
            addCriterion("CARTON_SID is null");
            return (Criteria) this;
        }

        public Criteria andCartonSidIsNotNull() {
            addCriterion("CARTON_SID is not null");
            return (Criteria) this;
        }

        public Criteria andCartonSidEqualTo(String value) {
            addCriterion("CARTON_SID =", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidNotEqualTo(String value) {
            addCriterion("CARTON_SID <>", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidGreaterThan(String value) {
            addCriterion("CARTON_SID >", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_SID >=", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidLessThan(String value) {
            addCriterion("CARTON_SID <", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidLessThanOrEqualTo(String value) {
            addCriterion("CARTON_SID <=", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidLike(String value) {
            addCriterion("CARTON_SID like", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidNotLike(String value) {
            addCriterion("CARTON_SID not like", value, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidIn(List<String> values) {
            addCriterion("CARTON_SID in", values, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidNotIn(List<String> values) {
            addCriterion("CARTON_SID not in", values, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidBetween(String value1, String value2) {
            addCriterion("CARTON_SID between", value1, value2, "cartonSid");
            return (Criteria) this;
        }

        public Criteria andCartonSidNotBetween(String value1, String value2) {
            addCriterion("CARTON_SID not between", value1, value2, "cartonSid");
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

        public Criteria andCartonContainerNameIsNull() {
            addCriterion("CARTON_CONTAINER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameIsNotNull() {
            addCriterion("CARTON_CONTAINER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NAME =", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameNotEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NAME <>", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameGreaterThan(String value) {
            addCriterion("CARTON_CONTAINER_NAME >", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NAME >=", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameLessThan(String value) {
            addCriterion("CARTON_CONTAINER_NAME <", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameLessThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NAME <=", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameLike(String value) {
            addCriterion("CARTON_CONTAINER_NAME like", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameNotLike(String value) {
            addCriterion("CARTON_CONTAINER_NAME not like", value, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_NAME in", values, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameNotIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_NAME not in", values, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_NAME between", value1, value2, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNameNotBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_NAME not between", value1, value2, "cartonContainerName");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoIsNull() {
            addCriterion("CARTON_CONTAINER_NO is null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoIsNotNull() {
            addCriterion("CARTON_CONTAINER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NO =", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoNotEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NO <>", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoGreaterThan(String value) {
            addCriterion("CARTON_CONTAINER_NO >", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NO >=", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoLessThan(String value) {
            addCriterion("CARTON_CONTAINER_NO <", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoLessThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_NO <=", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoLike(String value) {
            addCriterion("CARTON_CONTAINER_NO like", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoNotLike(String value) {
            addCriterion("CARTON_CONTAINER_NO not like", value, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_NO in", values, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoNotIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_NO not in", values, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_NO between", value1, value2, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerNoNotBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_NO not between", value1, value2, "cartonContainerNo");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeIsNull() {
            addCriterion("CARTON_CONTAINER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeIsNotNull() {
            addCriterion("CARTON_CONTAINER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_TYPE =", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeNotEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_TYPE <>", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeGreaterThan(String value) {
            addCriterion("CARTON_CONTAINER_TYPE >", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_TYPE >=", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeLessThan(String value) {
            addCriterion("CARTON_CONTAINER_TYPE <", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeLessThanOrEqualTo(String value) {
            addCriterion("CARTON_CONTAINER_TYPE <=", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeLike(String value) {
            addCriterion("CARTON_CONTAINER_TYPE like", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeNotLike(String value) {
            addCriterion("CARTON_CONTAINER_TYPE not like", value, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_TYPE in", values, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeNotIn(List<String> values) {
            addCriterion("CARTON_CONTAINER_TYPE not in", values, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_TYPE between", value1, value2, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonContainerTypeNotBetween(String value1, String value2) {
            addCriterion("CARTON_CONTAINER_TYPE not between", value1, value2, "cartonContainerType");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateIsNull() {
            addCriterion("CARTON_MFG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateIsNotNull() {
            addCriterion("CARTON_MFG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateEqualTo(String value) {
            addCriterion("CARTON_MFG_DATE =", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateNotEqualTo(String value) {
            addCriterion("CARTON_MFG_DATE <>", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateGreaterThan(String value) {
            addCriterion("CARTON_MFG_DATE >", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_MFG_DATE >=", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateLessThan(String value) {
            addCriterion("CARTON_MFG_DATE <", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateLessThanOrEqualTo(String value) {
            addCriterion("CARTON_MFG_DATE <=", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateLike(String value) {
            addCriterion("CARTON_MFG_DATE like", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateNotLike(String value) {
            addCriterion("CARTON_MFG_DATE not like", value, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateIn(List<String> values) {
            addCriterion("CARTON_MFG_DATE in", values, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateNotIn(List<String> values) {
            addCriterion("CARTON_MFG_DATE not in", values, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateBetween(String value1, String value2) {
            addCriterion("CARTON_MFG_DATE between", value1, value2, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonMfgDateNotBetween(String value1, String value2) {
            addCriterion("CARTON_MFG_DATE not between", value1, value2, "cartonMfgDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateIsNull() {
            addCriterion("CARTON_EXP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateIsNotNull() {
            addCriterion("CARTON_EXP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateEqualTo(String value) {
            addCriterion("CARTON_EXP_DATE =", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateNotEqualTo(String value) {
            addCriterion("CARTON_EXP_DATE <>", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateGreaterThan(String value) {
            addCriterion("CARTON_EXP_DATE >", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_EXP_DATE >=", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateLessThan(String value) {
            addCriterion("CARTON_EXP_DATE <", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateLessThanOrEqualTo(String value) {
            addCriterion("CARTON_EXP_DATE <=", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateLike(String value) {
            addCriterion("CARTON_EXP_DATE like", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateNotLike(String value) {
            addCriterion("CARTON_EXP_DATE not like", value, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateIn(List<String> values) {
            addCriterion("CARTON_EXP_DATE in", values, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateNotIn(List<String> values) {
            addCriterion("CARTON_EXP_DATE not in", values, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateBetween(String value1, String value2) {
            addCriterion("CARTON_EXP_DATE between", value1, value2, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonExpDateNotBetween(String value1, String value2) {
            addCriterion("CARTON_EXP_DATE not between", value1, value2, "cartonExpDate");
            return (Criteria) this;
        }

        public Criteria andCartonStatusIsNull() {
            addCriterion("CARTON_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCartonStatusIsNotNull() {
            addCriterion("CARTON_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCartonStatusEqualTo(String value) {
            addCriterion("CARTON_STATUS =", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusNotEqualTo(String value) {
            addCriterion("CARTON_STATUS <>", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusGreaterThan(String value) {
            addCriterion("CARTON_STATUS >", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_STATUS >=", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusLessThan(String value) {
            addCriterion("CARTON_STATUS <", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusLessThanOrEqualTo(String value) {
            addCriterion("CARTON_STATUS <=", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusLike(String value) {
            addCriterion("CARTON_STATUS like", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusNotLike(String value) {
            addCriterion("CARTON_STATUS not like", value, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusIn(List<String> values) {
            addCriterion("CARTON_STATUS in", values, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusNotIn(List<String> values) {
            addCriterion("CARTON_STATUS not in", values, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusBetween(String value1, String value2) {
            addCriterion("CARTON_STATUS between", value1, value2, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonStatusNotBetween(String value1, String value2) {
            addCriterion("CARTON_STATUS not between", value1, value2, "cartonStatus");
            return (Criteria) this;
        }

        public Criteria andCartonSfcIsNull() {
            addCriterion("CARTON_SFC is null");
            return (Criteria) this;
        }

        public Criteria andCartonSfcIsNotNull() {
            addCriterion("CARTON_SFC is not null");
            return (Criteria) this;
        }

        public Criteria andCartonSfcEqualTo(String value) {
            addCriterion("CARTON_SFC =", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcNotEqualTo(String value) {
            addCriterion("CARTON_SFC <>", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcGreaterThan(String value) {
            addCriterion("CARTON_SFC >", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_SFC >=", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcLessThan(String value) {
            addCriterion("CARTON_SFC <", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcLessThanOrEqualTo(String value) {
            addCriterion("CARTON_SFC <=", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcLike(String value) {
            addCriterion("CARTON_SFC like", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcNotLike(String value) {
            addCriterion("CARTON_SFC not like", value, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcIn(List<String> values) {
            addCriterion("CARTON_SFC in", values, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcNotIn(List<String> values) {
            addCriterion("CARTON_SFC not in", values, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcBetween(String value1, String value2) {
            addCriterion("CARTON_SFC between", value1, value2, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonSfcNotBetween(String value1, String value2) {
            addCriterion("CARTON_SFC not between", value1, value2, "cartonSfc");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoIsNull() {
            addCriterion("CARTON_BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoIsNotNull() {
            addCriterion("CARTON_BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoEqualTo(String value) {
            addCriterion("CARTON_BATCH_NO =", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoNotEqualTo(String value) {
            addCriterion("CARTON_BATCH_NO <>", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoGreaterThan(String value) {
            addCriterion("CARTON_BATCH_NO >", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_BATCH_NO >=", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoLessThan(String value) {
            addCriterion("CARTON_BATCH_NO <", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoLessThanOrEqualTo(String value) {
            addCriterion("CARTON_BATCH_NO <=", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoLike(String value) {
            addCriterion("CARTON_BATCH_NO like", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoNotLike(String value) {
            addCriterion("CARTON_BATCH_NO not like", value, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoIn(List<String> values) {
            addCriterion("CARTON_BATCH_NO in", values, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoNotIn(List<String> values) {
            addCriterion("CARTON_BATCH_NO not in", values, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoBetween(String value1, String value2) {
            addCriterion("CARTON_BATCH_NO between", value1, value2, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonBatchNoNotBetween(String value1, String value2) {
            addCriterion("CARTON_BATCH_NO not between", value1, value2, "cartonBatchNo");
            return (Criteria) this;
        }

        public Criteria andCartonSnIsNull() {
            addCriterion("CARTON_SN is null");
            return (Criteria) this;
        }

        public Criteria andCartonSnIsNotNull() {
            addCriterion("CARTON_SN is not null");
            return (Criteria) this;
        }

        public Criteria andCartonSnEqualTo(String value) {
            addCriterion("CARTON_SN =", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnNotEqualTo(String value) {
            addCriterion("CARTON_SN <>", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnGreaterThan(String value) {
            addCriterion("CARTON_SN >", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_SN >=", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnLessThan(String value) {
            addCriterion("CARTON_SN <", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnLessThanOrEqualTo(String value) {
            addCriterion("CARTON_SN <=", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnLike(String value) {
            addCriterion("CARTON_SN like", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnNotLike(String value) {
            addCriterion("CARTON_SN not like", value, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnIn(List<String> values) {
            addCriterion("CARTON_SN in", values, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnNotIn(List<String> values) {
            addCriterion("CARTON_SN not in", values, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnBetween(String value1, String value2) {
            addCriterion("CARTON_SN between", value1, value2, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andCartonSnNotBetween(String value1, String value2) {
            addCriterion("CARTON_SN not between", value1, value2, "cartonSn");
            return (Criteria) this;
        }

        public Criteria andPalletSidIsNull() {
            addCriterion("PALLET_SID is null");
            return (Criteria) this;
        }

        public Criteria andPalletSidIsNotNull() {
            addCriterion("PALLET_SID is not null");
            return (Criteria) this;
        }

        public Criteria andPalletSidEqualTo(String value) {
            addCriterion("PALLET_SID =", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidNotEqualTo(String value) {
            addCriterion("PALLET_SID <>", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidGreaterThan(String value) {
            addCriterion("PALLET_SID >", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidGreaterThanOrEqualTo(String value) {
            addCriterion("PALLET_SID >=", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidLessThan(String value) {
            addCriterion("PALLET_SID <", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidLessThanOrEqualTo(String value) {
            addCriterion("PALLET_SID <=", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidLike(String value) {
            addCriterion("PALLET_SID like", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidNotLike(String value) {
            addCriterion("PALLET_SID not like", value, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidIn(List<String> values) {
            addCriterion("PALLET_SID in", values, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidNotIn(List<String> values) {
            addCriterion("PALLET_SID not in", values, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidBetween(String value1, String value2) {
            addCriterion("PALLET_SID between", value1, value2, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletSidNotBetween(String value1, String value2) {
            addCriterion("PALLET_SID not between", value1, value2, "palletSid");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameIsNull() {
            addCriterion("PALLET_CONTAINER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameIsNotNull() {
            addCriterion("PALLET_CONTAINER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NAME =", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameNotEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NAME <>", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameGreaterThan(String value) {
            addCriterion("PALLET_CONTAINER_NAME >", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NAME >=", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameLessThan(String value) {
            addCriterion("PALLET_CONTAINER_NAME <", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameLessThanOrEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NAME <=", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameLike(String value) {
            addCriterion("PALLET_CONTAINER_NAME like", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameNotLike(String value) {
            addCriterion("PALLET_CONTAINER_NAME not like", value, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameIn(List<String> values) {
            addCriterion("PALLET_CONTAINER_NAME in", values, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameNotIn(List<String> values) {
            addCriterion("PALLET_CONTAINER_NAME not in", values, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameBetween(String value1, String value2) {
            addCriterion("PALLET_CONTAINER_NAME between", value1, value2, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNameNotBetween(String value1, String value2) {
            addCriterion("PALLET_CONTAINER_NAME not between", value1, value2, "palletContainerName");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoIsNull() {
            addCriterion("PALLET_CONTAINER_NO is null");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoIsNotNull() {
            addCriterion("PALLET_CONTAINER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NO =", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoNotEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NO <>", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoGreaterThan(String value) {
            addCriterion("PALLET_CONTAINER_NO >", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoGreaterThanOrEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NO >=", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoLessThan(String value) {
            addCriterion("PALLET_CONTAINER_NO <", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoLessThanOrEqualTo(String value) {
            addCriterion("PALLET_CONTAINER_NO <=", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoLike(String value) {
            addCriterion("PALLET_CONTAINER_NO like", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoNotLike(String value) {
            addCriterion("PALLET_CONTAINER_NO not like", value, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoIn(List<String> values) {
            addCriterion("PALLET_CONTAINER_NO in", values, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoNotIn(List<String> values) {
            addCriterion("PALLET_CONTAINER_NO not in", values, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoBetween(String value1, String value2) {
            addCriterion("PALLET_CONTAINER_NO between", value1, value2, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletContainerNoNotBetween(String value1, String value2) {
            addCriterion("PALLET_CONTAINER_NO not between", value1, value2, "palletContainerNo");
            return (Criteria) this;
        }

        public Criteria andPalletStatusIsNull() {
            addCriterion("PALLET_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPalletStatusIsNotNull() {
            addCriterion("PALLET_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPalletStatusEqualTo(String value) {
            addCriterion("PALLET_STATUS =", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusNotEqualTo(String value) {
            addCriterion("PALLET_STATUS <>", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusGreaterThan(String value) {
            addCriterion("PALLET_STATUS >", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PALLET_STATUS >=", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusLessThan(String value) {
            addCriterion("PALLET_STATUS <", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusLessThanOrEqualTo(String value) {
            addCriterion("PALLET_STATUS <=", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusLike(String value) {
            addCriterion("PALLET_STATUS like", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusNotLike(String value) {
            addCriterion("PALLET_STATUS not like", value, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusIn(List<String> values) {
            addCriterion("PALLET_STATUS in", values, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusNotIn(List<String> values) {
            addCriterion("PALLET_STATUS not in", values, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusBetween(String value1, String value2) {
            addCriterion("PALLET_STATUS between", value1, value2, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andPalletStatusNotBetween(String value1, String value2) {
            addCriterion("PALLET_STATUS not between", value1, value2, "palletStatus");
            return (Criteria) this;
        }

        public Criteria andSfcIsNull() {
            addCriterion("SFC is null");
            return (Criteria) this;
        }

        public Criteria andSfcIsNotNull() {
            addCriterion("SFC is not null");
            return (Criteria) this;
        }

        public Criteria andSfcEqualTo(String value) {
            addCriterion("SFC =", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotEqualTo(String value) {
            addCriterion("SFC <>", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcGreaterThan(String value) {
            addCriterion("SFC >", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcGreaterThanOrEqualTo(String value) {
            addCriterion("SFC >=", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLessThan(String value) {
            addCriterion("SFC <", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLessThanOrEqualTo(String value) {
            addCriterion("SFC <=", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcLike(String value) {
            addCriterion("SFC like", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotLike(String value) {
            addCriterion("SFC not like", value, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcIn(List<String> values) {
            addCriterion("SFC in", values, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotIn(List<String> values) {
            addCriterion("SFC not in", values, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcBetween(String value1, String value2) {
            addCriterion("SFC between", value1, value2, "sfc");
            return (Criteria) this;
        }

        public Criteria andSfcNotBetween(String value1, String value2) {
            addCriterion("SFC not between", value1, value2, "sfc");
            return (Criteria) this;
        }

        public Criteria andShopOrderIsNull() {
            addCriterion("SHOP_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderIsNotNull() {
            addCriterion("SHOP_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderEqualTo(String value) {
            addCriterion("SHOP_ORDER =", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderNotEqualTo(String value) {
            addCriterion("SHOP_ORDER <>", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderGreaterThan(String value) {
            addCriterion("SHOP_ORDER >", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER >=", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderLessThan(String value) {
            addCriterion("SHOP_ORDER <", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER <=", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderLike(String value) {
            addCriterion("SHOP_ORDER like", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderNotLike(String value) {
            addCriterion("SHOP_ORDER not like", value, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderIn(List<String> values) {
            addCriterion("SHOP_ORDER in", values, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderNotIn(List<String> values) {
            addCriterion("SHOP_ORDER not in", values, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER between", value1, value2, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andShopOrderNotBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER not between", value1, value2, "shopOrder");
            return (Criteria) this;
        }

        public Criteria andItemIsNull() {
            addCriterion("ITEM is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("ITEM =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("ITEM <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("ITEM >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("ITEM <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("ITEM <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("ITEM like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("ITEM not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("ITEM in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("ITEM not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("ITEM between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("ITEM not between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
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