package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZPackDetailLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZPackDetailLogExample() {
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

        public Criteria andMasterSidIsNull() {
            addCriterion("MASTER_SID is null");
            return (Criteria) this;
        }

        public Criteria andMasterSidIsNotNull() {
            addCriterion("MASTER_SID is not null");
            return (Criteria) this;
        }

        public Criteria andMasterSidEqualTo(String value) {
            addCriterion("MASTER_SID =", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotEqualTo(String value) {
            addCriterion("MASTER_SID <>", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidGreaterThan(String value) {
            addCriterion("MASTER_SID >", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_SID >=", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLessThan(String value) {
            addCriterion("MASTER_SID <", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLessThanOrEqualTo(String value) {
            addCriterion("MASTER_SID <=", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLike(String value) {
            addCriterion("MASTER_SID like", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotLike(String value) {
            addCriterion("MASTER_SID not like", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidIn(List<String> values) {
            addCriterion("MASTER_SID in", values, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotIn(List<String> values) {
            addCriterion("MASTER_SID not in", values, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidBetween(String value1, String value2) {
            addCriterion("MASTER_SID between", value1, value2, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotBetween(String value1, String value2) {
            addCriterion("MASTER_SID not between", value1, value2, "masterSid");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andCartonNoIsNull() {
            addCriterion("CARTON_NO is null");
            return (Criteria) this;
        }

        public Criteria andCartonNoIsNotNull() {
            addCriterion("CARTON_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCartonNoEqualTo(String value) {
            addCriterion("CARTON_NO =", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotEqualTo(String value) {
            addCriterion("CARTON_NO <>", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoGreaterThan(String value) {
            addCriterion("CARTON_NO >", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_NO >=", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLessThan(String value) {
            addCriterion("CARTON_NO <", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLessThanOrEqualTo(String value) {
            addCriterion("CARTON_NO <=", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLike(String value) {
            addCriterion("CARTON_NO like", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotLike(String value) {
            addCriterion("CARTON_NO not like", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoIn(List<String> values) {
            addCriterion("CARTON_NO in", values, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotIn(List<String> values) {
            addCriterion("CARTON_NO not in", values, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoBetween(String value1, String value2) {
            addCriterion("CARTON_NO between", value1, value2, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotBetween(String value1, String value2) {
            addCriterion("CARTON_NO not between", value1, value2, "cartonNo");
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

        public Criteria andUnboxingDateTimeIsNull() {
            addCriterion("UNBOXING_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeIsNotNull() {
            addCriterion("UNBOXING_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeEqualTo(Date value) {
            addCriterion("UNBOXING_DATE_TIME =", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeNotEqualTo(Date value) {
            addCriterion("UNBOXING_DATE_TIME <>", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeGreaterThan(Date value) {
            addCriterion("UNBOXING_DATE_TIME >", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UNBOXING_DATE_TIME >=", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeLessThan(Date value) {
            addCriterion("UNBOXING_DATE_TIME <", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UNBOXING_DATE_TIME <=", value, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeIn(List<Date> values) {
            addCriterion("UNBOXING_DATE_TIME in", values, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeNotIn(List<Date> values) {
            addCriterion("UNBOXING_DATE_TIME not in", values, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeBetween(Date value1, Date value2) {
            addCriterion("UNBOXING_DATE_TIME between", value1, value2, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UNBOXING_DATE_TIME not between", value1, value2, "unboxingDateTime");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserIsNull() {
            addCriterion("UNBOXING_USER is null");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserIsNotNull() {
            addCriterion("UNBOXING_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserEqualTo(String value) {
            addCriterion("UNBOXING_USER =", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserNotEqualTo(String value) {
            addCriterion("UNBOXING_USER <>", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserGreaterThan(String value) {
            addCriterion("UNBOXING_USER >", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserGreaterThanOrEqualTo(String value) {
            addCriterion("UNBOXING_USER >=", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserLessThan(String value) {
            addCriterion("UNBOXING_USER <", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserLessThanOrEqualTo(String value) {
            addCriterion("UNBOXING_USER <=", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserLike(String value) {
            addCriterion("UNBOXING_USER like", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserNotLike(String value) {
            addCriterion("UNBOXING_USER not like", value, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserIn(List<String> values) {
            addCriterion("UNBOXING_USER in", values, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserNotIn(List<String> values) {
            addCriterion("UNBOXING_USER not in", values, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserBetween(String value1, String value2) {
            addCriterion("UNBOXING_USER between", value1, value2, "unboxingUser");
            return (Criteria) this;
        }

        public Criteria andUnboxingUserNotBetween(String value1, String value2) {
            addCriterion("UNBOXING_USER not between", value1, value2, "unboxingUser");
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