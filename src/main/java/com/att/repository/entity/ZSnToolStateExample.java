package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZSnToolStateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZSnToolStateExample() {
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

        public Criteria andOperationIsNull() {
            addCriterion("OPERATION is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("OPERATION is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("OPERATION =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("OPERATION <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("OPERATION >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("OPERATION <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("OPERATION <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("OPERATION like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("OPERATION not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("OPERATION in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("OPERATION not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("OPERATION between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("OPERATION not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("RESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("RESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("RESOURCE =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("RESOURCE <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("RESOURCE >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("RESOURCE <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("RESOURCE like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("RESOURCE not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("RESOURCE in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("RESOURCE not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("RESOURCE between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("RESOURCE not between", value1, value2, "resource");
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

        public Criteria andToolNumberIsNull() {
            addCriterion("TOOL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andToolNumberIsNotNull() {
            addCriterion("TOOL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andToolNumberEqualTo(String value) {
            addCriterion("TOOL_NUMBER =", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotEqualTo(String value) {
            addCriterion("TOOL_NUMBER <>", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberGreaterThan(String value) {
            addCriterion("TOOL_NUMBER >", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberGreaterThanOrEqualTo(String value) {
            addCriterion("TOOL_NUMBER >=", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLessThan(String value) {
            addCriterion("TOOL_NUMBER <", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLessThanOrEqualTo(String value) {
            addCriterion("TOOL_NUMBER <=", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLike(String value) {
            addCriterion("TOOL_NUMBER like", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotLike(String value) {
            addCriterion("TOOL_NUMBER not like", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberIn(List<String> values) {
            addCriterion("TOOL_NUMBER in", values, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotIn(List<String> values) {
            addCriterion("TOOL_NUMBER not in", values, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberBetween(String value1, String value2) {
            addCriterion("TOOL_NUMBER between", value1, value2, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotBetween(String value1, String value2) {
            addCriterion("TOOL_NUMBER not between", value1, value2, "toolNumber");
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

        public Criteria andStartDateTimeIsNull() {
            addCriterion("START_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIsNotNull() {
            addCriterion("START_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeEqualTo(Date value) {
            addCriterion("START_DATE_TIME =", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotEqualTo(Date value) {
            addCriterion("START_DATE_TIME <>", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThan(Date value) {
            addCriterion("START_DATE_TIME >", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_DATE_TIME >=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThan(Date value) {
            addCriterion("START_DATE_TIME <", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_DATE_TIME <=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIn(List<Date> values) {
            addCriterion("START_DATE_TIME in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotIn(List<Date> values) {
            addCriterion("START_DATE_TIME not in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeBetween(Date value1, Date value2) {
            addCriterion("START_DATE_TIME between", value1, value2, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_DATE_TIME not between", value1, value2, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartUserIsNull() {
            addCriterion("START_USER is null");
            return (Criteria) this;
        }

        public Criteria andStartUserIsNotNull() {
            addCriterion("START_USER is not null");
            return (Criteria) this;
        }

        public Criteria andStartUserEqualTo(String value) {
            addCriterion("START_USER =", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserNotEqualTo(String value) {
            addCriterion("START_USER <>", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserGreaterThan(String value) {
            addCriterion("START_USER >", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserGreaterThanOrEqualTo(String value) {
            addCriterion("START_USER >=", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserLessThan(String value) {
            addCriterion("START_USER <", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserLessThanOrEqualTo(String value) {
            addCriterion("START_USER <=", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserLike(String value) {
            addCriterion("START_USER like", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserNotLike(String value) {
            addCriterion("START_USER not like", value, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserIn(List<String> values) {
            addCriterion("START_USER in", values, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserNotIn(List<String> values) {
            addCriterion("START_USER not in", values, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserBetween(String value1, String value2) {
            addCriterion("START_USER between", value1, value2, "startUser");
            return (Criteria) this;
        }

        public Criteria andStartUserNotBetween(String value1, String value2) {
            addCriterion("START_USER not between", value1, value2, "startUser");
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