package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwQcPlanItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwQcPlanItemExample() {
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

        public Criteria andHandleIsNull() {
            addCriterion("HANDLE is null");
            return (Criteria) this;
        }

        public Criteria andHandleIsNotNull() {
            addCriterion("HANDLE is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEqualTo(String value) {
            addCriterion("HANDLE =", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotEqualTo(String value) {
            addCriterion("HANDLE <>", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThan(String value) {
            addCriterion("HANDLE >", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLE >=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThan(String value) {
            addCriterion("HANDLE <", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThanOrEqualTo(String value) {
            addCriterion("HANDLE <=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLike(String value) {
            addCriterion("HANDLE like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotLike(String value) {
            addCriterion("HANDLE not like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleIn(List<String> values) {
            addCriterion("HANDLE in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotIn(List<String> values) {
            addCriterion("HANDLE not in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleBetween(String value1, String value2) {
            addCriterion("HANDLE between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotBetween(String value1, String value2) {
            addCriterion("HANDLE not between", value1, value2, "handle");
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

        public Criteria andQcPlanIsNull() {
            addCriterion("QC_PLAN is null");
            return (Criteria) this;
        }

        public Criteria andQcPlanIsNotNull() {
            addCriterion("QC_PLAN is not null");
            return (Criteria) this;
        }

        public Criteria andQcPlanEqualTo(String value) {
            addCriterion("QC_PLAN =", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanNotEqualTo(String value) {
            addCriterion("QC_PLAN <>", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanGreaterThan(String value) {
            addCriterion("QC_PLAN >", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanGreaterThanOrEqualTo(String value) {
            addCriterion("QC_PLAN >=", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanLessThan(String value) {
            addCriterion("QC_PLAN <", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanLessThanOrEqualTo(String value) {
            addCriterion("QC_PLAN <=", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanLike(String value) {
            addCriterion("QC_PLAN like", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanNotLike(String value) {
            addCriterion("QC_PLAN not like", value, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanIn(List<String> values) {
            addCriterion("QC_PLAN in", values, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanNotIn(List<String> values) {
            addCriterion("QC_PLAN not in", values, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanBetween(String value1, String value2) {
            addCriterion("QC_PLAN between", value1, value2, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andQcPlanNotBetween(String value1, String value2) {
            addCriterion("QC_PLAN not between", value1, value2, "qcPlan");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNull() {
            addCriterion("REVISION is null");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNotNull() {
            addCriterion("REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andRevisionEqualTo(String value) {
            addCriterion("REVISION =", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotEqualTo(String value) {
            addCriterion("REVISION <>", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThan(String value) {
            addCriterion("REVISION >", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("REVISION >=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThan(String value) {
            addCriterion("REVISION <", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThanOrEqualTo(String value) {
            addCriterion("REVISION <=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLike(String value) {
            addCriterion("REVISION like", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotLike(String value) {
            addCriterion("REVISION not like", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionIn(List<String> values) {
            addCriterion("REVISION in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotIn(List<String> values) {
            addCriterion("REVISION not in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionBetween(String value1, String value2) {
            addCriterion("REVISION between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotBetween(String value1, String value2) {
            addCriterion("REVISION not between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIsNull() {
            addCriterion("CURRENT_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIsNotNull() {
            addCriterion("CURRENT_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionEqualTo(String value) {
            addCriterion("CURRENT_REVISION =", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotEqualTo(String value) {
            addCriterion("CURRENT_REVISION <>", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionGreaterThan(String value) {
            addCriterion("CURRENT_REVISION >", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_REVISION >=", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLessThan(String value) {
            addCriterion("CURRENT_REVISION <", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_REVISION <=", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLike(String value) {
            addCriterion("CURRENT_REVISION like", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotLike(String value) {
            addCriterion("CURRENT_REVISION not like", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIn(List<String> values) {
            addCriterion("CURRENT_REVISION in", values, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotIn(List<String> values) {
            addCriterion("CURRENT_REVISION not in", values, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionBetween(String value1, String value2) {
            addCriterion("CURRENT_REVISION between", value1, value2, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotBetween(String value1, String value2) {
            addCriterion("CURRENT_REVISION not between", value1, value2, "currentRevision");
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

        public Criteria andQcModeIsNull() {
            addCriterion("QC_MODE is null");
            return (Criteria) this;
        }

        public Criteria andQcModeIsNotNull() {
            addCriterion("QC_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andQcModeEqualTo(String value) {
            addCriterion("QC_MODE =", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeNotEqualTo(String value) {
            addCriterion("QC_MODE <>", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeGreaterThan(String value) {
            addCriterion("QC_MODE >", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeGreaterThanOrEqualTo(String value) {
            addCriterion("QC_MODE >=", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeLessThan(String value) {
            addCriterion("QC_MODE <", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeLessThanOrEqualTo(String value) {
            addCriterion("QC_MODE <=", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeLike(String value) {
            addCriterion("QC_MODE like", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeNotLike(String value) {
            addCriterion("QC_MODE not like", value, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeIn(List<String> values) {
            addCriterion("QC_MODE in", values, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeNotIn(List<String> values) {
            addCriterion("QC_MODE not in", values, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeBetween(String value1, String value2) {
            addCriterion("QC_MODE between", value1, value2, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcModeNotBetween(String value1, String value2) {
            addCriterion("QC_MODE not between", value1, value2, "qcMode");
            return (Criteria) this;
        }

        public Criteria andQcTypeIsNull() {
            addCriterion("QC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQcTypeIsNotNull() {
            addCriterion("QC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQcTypeEqualTo(String value) {
            addCriterion("QC_TYPE =", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeNotEqualTo(String value) {
            addCriterion("QC_TYPE <>", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeGreaterThan(String value) {
            addCriterion("QC_TYPE >", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QC_TYPE >=", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeLessThan(String value) {
            addCriterion("QC_TYPE <", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeLessThanOrEqualTo(String value) {
            addCriterion("QC_TYPE <=", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeLike(String value) {
            addCriterion("QC_TYPE like", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeNotLike(String value) {
            addCriterion("QC_TYPE not like", value, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeIn(List<String> values) {
            addCriterion("QC_TYPE in", values, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeNotIn(List<String> values) {
            addCriterion("QC_TYPE not in", values, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeBetween(String value1, String value2) {
            addCriterion("QC_TYPE between", value1, value2, "qcType");
            return (Criteria) this;
        }

        public Criteria andQcTypeNotBetween(String value1, String value2) {
            addCriterion("QC_TYPE not between", value1, value2, "qcType");
            return (Criteria) this;
        }

        public Criteria andInspecNoIsNull() {
            addCriterion("INSPEC_NO is null");
            return (Criteria) this;
        }

        public Criteria andInspecNoIsNotNull() {
            addCriterion("INSPEC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInspecNoEqualTo(String value) {
            addCriterion("INSPEC_NO =", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoNotEqualTo(String value) {
            addCriterion("INSPEC_NO <>", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoGreaterThan(String value) {
            addCriterion("INSPEC_NO >", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoGreaterThanOrEqualTo(String value) {
            addCriterion("INSPEC_NO >=", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoLessThan(String value) {
            addCriterion("INSPEC_NO <", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoLessThanOrEqualTo(String value) {
            addCriterion("INSPEC_NO <=", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoLike(String value) {
            addCriterion("INSPEC_NO like", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoNotLike(String value) {
            addCriterion("INSPEC_NO not like", value, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoIn(List<String> values) {
            addCriterion("INSPEC_NO in", values, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoNotIn(List<String> values) {
            addCriterion("INSPEC_NO not in", values, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoBetween(String value1, String value2) {
            addCriterion("INSPEC_NO between", value1, value2, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andInspecNoNotBetween(String value1, String value2) {
            addCriterion("INSPEC_NO not between", value1, value2, "inspecNo");
            return (Criteria) this;
        }

        public Criteria andUserGroupIsNull() {
            addCriterion("USER_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIsNotNull() {
            addCriterion("USER_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupEqualTo(String value) {
            addCriterion("USER_GROUP =", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotEqualTo(String value) {
            addCriterion("USER_GROUP <>", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupGreaterThan(String value) {
            addCriterion("USER_GROUP >", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupGreaterThanOrEqualTo(String value) {
            addCriterion("USER_GROUP >=", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLessThan(String value) {
            addCriterion("USER_GROUP <", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLessThanOrEqualTo(String value) {
            addCriterion("USER_GROUP <=", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLike(String value) {
            addCriterion("USER_GROUP like", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotLike(String value) {
            addCriterion("USER_GROUP not like", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupIn(List<String> values) {
            addCriterion("USER_GROUP in", values, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotIn(List<String> values) {
            addCriterion("USER_GROUP not in", values, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupBetween(String value1, String value2) {
            addCriterion("USER_GROUP between", value1, value2, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotBetween(String value1, String value2) {
            addCriterion("USER_GROUP not between", value1, value2, "userGroup");
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

        public Criteria andSipGroupNameIsNull() {
            addCriterion("SIP_GROUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameIsNotNull() {
            addCriterion("SIP_GROUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameEqualTo(String value) {
            addCriterion("SIP_GROUP_NAME =", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameNotEqualTo(String value) {
            addCriterion("SIP_GROUP_NAME <>", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameGreaterThan(String value) {
            addCriterion("SIP_GROUP_NAME >", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("SIP_GROUP_NAME >=", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameLessThan(String value) {
            addCriterion("SIP_GROUP_NAME <", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameLessThanOrEqualTo(String value) {
            addCriterion("SIP_GROUP_NAME <=", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameLike(String value) {
            addCriterion("SIP_GROUP_NAME like", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameNotLike(String value) {
            addCriterion("SIP_GROUP_NAME not like", value, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameIn(List<String> values) {
            addCriterion("SIP_GROUP_NAME in", values, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameNotIn(List<String> values) {
            addCriterion("SIP_GROUP_NAME not in", values, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameBetween(String value1, String value2) {
            addCriterion("SIP_GROUP_NAME between", value1, value2, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipGroupNameNotBetween(String value1, String value2) {
            addCriterion("SIP_GROUP_NAME not between", value1, value2, "sipGroupName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameIsNull() {
            addCriterion("SIP_FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSipFileNameIsNotNull() {
            addCriterion("SIP_FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSipFileNameEqualTo(String value) {
            addCriterion("SIP_FILE_NAME =", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameNotEqualTo(String value) {
            addCriterion("SIP_FILE_NAME <>", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameGreaterThan(String value) {
            addCriterion("SIP_FILE_NAME >", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("SIP_FILE_NAME >=", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameLessThan(String value) {
            addCriterion("SIP_FILE_NAME <", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameLessThanOrEqualTo(String value) {
            addCriterion("SIP_FILE_NAME <=", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameLike(String value) {
            addCriterion("SIP_FILE_NAME like", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameNotLike(String value) {
            addCriterion("SIP_FILE_NAME not like", value, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameIn(List<String> values) {
            addCriterion("SIP_FILE_NAME in", values, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameNotIn(List<String> values) {
            addCriterion("SIP_FILE_NAME not in", values, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameBetween(String value1, String value2) {
            addCriterion("SIP_FILE_NAME between", value1, value2, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andSipFileNameNotBetween(String value1, String value2) {
            addCriterion("SIP_FILE_NAME not between", value1, value2, "sipFileName");
            return (Criteria) this;
        }

        public Criteria andToSpcIsNull() {
            addCriterion("TO_SPC is null");
            return (Criteria) this;
        }

        public Criteria andToSpcIsNotNull() {
            addCriterion("TO_SPC is not null");
            return (Criteria) this;
        }

        public Criteria andToSpcEqualTo(String value) {
            addCriterion("TO_SPC =", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcNotEqualTo(String value) {
            addCriterion("TO_SPC <>", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcGreaterThan(String value) {
            addCriterion("TO_SPC >", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcGreaterThanOrEqualTo(String value) {
            addCriterion("TO_SPC >=", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcLessThan(String value) {
            addCriterion("TO_SPC <", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcLessThanOrEqualTo(String value) {
            addCriterion("TO_SPC <=", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcLike(String value) {
            addCriterion("TO_SPC like", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcNotLike(String value) {
            addCriterion("TO_SPC not like", value, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcIn(List<String> values) {
            addCriterion("TO_SPC in", values, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcNotIn(List<String> values) {
            addCriterion("TO_SPC not in", values, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcBetween(String value1, String value2) {
            addCriterion("TO_SPC between", value1, value2, "toSpc");
            return (Criteria) this;
        }

        public Criteria andToSpcNotBetween(String value1, String value2) {
            addCriterion("TO_SPC not between", value1, value2, "toSpc");
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

        public Criteria andQcPlanDetailBoIsNull() {
            addCriterion("QC_PLAN_DETAIL_BO is null");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoIsNotNull() {
            addCriterion("QC_PLAN_DETAIL_BO is not null");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoEqualTo(String value) {
            addCriterion("QC_PLAN_DETAIL_BO =", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoNotEqualTo(String value) {
            addCriterion("QC_PLAN_DETAIL_BO <>", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoGreaterThan(String value) {
            addCriterion("QC_PLAN_DETAIL_BO >", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoGreaterThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_DETAIL_BO >=", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoLessThan(String value) {
            addCriterion("QC_PLAN_DETAIL_BO <", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoLessThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_DETAIL_BO <=", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoLike(String value) {
            addCriterion("QC_PLAN_DETAIL_BO like", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoNotLike(String value) {
            addCriterion("QC_PLAN_DETAIL_BO not like", value, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoIn(List<String> values) {
            addCriterion("QC_PLAN_DETAIL_BO in", values, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoNotIn(List<String> values) {
            addCriterion("QC_PLAN_DETAIL_BO not in", values, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoBetween(String value1, String value2) {
            addCriterion("QC_PLAN_DETAIL_BO between", value1, value2, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanDetailBoNotBetween(String value1, String value2) {
            addCriterion("QC_PLAN_DETAIL_BO not between", value1, value2, "qcPlanDetailBo");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(String value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(String value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(String value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(String value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(String value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLike(String value) {
            addCriterion("SEQ like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotLike(String value) {
            addCriterion("SEQ not like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<String> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<String> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(String value1, String value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(String value1, String value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoIsNull() {
            addCriterion("SAMPLE_PLAN_BO is null");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoIsNotNull() {
            addCriterion("SAMPLE_PLAN_BO is not null");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoEqualTo(String value) {
            addCriterion("SAMPLE_PLAN_BO =", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoNotEqualTo(String value) {
            addCriterion("SAMPLE_PLAN_BO <>", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoGreaterThan(String value) {
            addCriterion("SAMPLE_PLAN_BO >", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLE_PLAN_BO >=", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoLessThan(String value) {
            addCriterion("SAMPLE_PLAN_BO <", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoLessThanOrEqualTo(String value) {
            addCriterion("SAMPLE_PLAN_BO <=", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoLike(String value) {
            addCriterion("SAMPLE_PLAN_BO like", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoNotLike(String value) {
            addCriterion("SAMPLE_PLAN_BO not like", value, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoIn(List<String> values) {
            addCriterion("SAMPLE_PLAN_BO in", values, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoNotIn(List<String> values) {
            addCriterion("SAMPLE_PLAN_BO not in", values, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoBetween(String value1, String value2) {
            addCriterion("SAMPLE_PLAN_BO between", value1, value2, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andSamplePlanBoNotBetween(String value1, String value2) {
            addCriterion("SAMPLE_PLAN_BO not between", value1, value2, "samplePlanBo");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsIsNull() {
            addCriterion("MEASUREMENT_POINTS is null");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsIsNotNull() {
            addCriterion("MEASUREMENT_POINTS is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsEqualTo(Short value) {
            addCriterion("MEASUREMENT_POINTS =", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsNotEqualTo(Short value) {
            addCriterion("MEASUREMENT_POINTS <>", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsGreaterThan(Short value) {
            addCriterion("MEASUREMENT_POINTS >", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsGreaterThanOrEqualTo(Short value) {
            addCriterion("MEASUREMENT_POINTS >=", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsLessThan(Short value) {
            addCriterion("MEASUREMENT_POINTS <", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsLessThanOrEqualTo(Short value) {
            addCriterion("MEASUREMENT_POINTS <=", value, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsIn(List<Short> values) {
            addCriterion("MEASUREMENT_POINTS in", values, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsNotIn(List<Short> values) {
            addCriterion("MEASUREMENT_POINTS not in", values, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsBetween(Short value1, Short value2) {
            addCriterion("MEASUREMENT_POINTS between", value1, value2, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMeasurementPointsNotBetween(Short value1, Short value2) {
            addCriterion("MEASUREMENT_POINTS not between", value1, value2, "measurementPoints");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNull() {
            addCriterion("MAX_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNotNull() {
            addCriterion("MAX_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValueEqualTo(BigDecimal value) {
            addCriterion("MAX_VALUE =", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotEqualTo(BigDecimal value) {
            addCriterion("MAX_VALUE <>", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThan(BigDecimal value) {
            addCriterion("MAX_VALUE >", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_VALUE >=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThan(BigDecimal value) {
            addCriterion("MAX_VALUE <", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_VALUE <=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIn(List<BigDecimal> values) {
            addCriterion("MAX_VALUE in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotIn(List<BigDecimal> values) {
            addCriterion("MAX_VALUE not in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_VALUE between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_VALUE not between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNull() {
            addCriterion("MIN_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNotNull() {
            addCriterion("MIN_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMinValueEqualTo(BigDecimal value) {
            addCriterion("MIN_VALUE =", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotEqualTo(BigDecimal value) {
            addCriterion("MIN_VALUE <>", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThan(BigDecimal value) {
            addCriterion("MIN_VALUE >", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_VALUE >=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThan(BigDecimal value) {
            addCriterion("MIN_VALUE <", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_VALUE <=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueIn(List<BigDecimal> values) {
            addCriterion("MIN_VALUE in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotIn(List<BigDecimal> values) {
            addCriterion("MIN_VALUE not in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_VALUE between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_VALUE not between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueIsNull() {
            addCriterion("CENTER_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andCenterValueIsNotNull() {
            addCriterion("CENTER_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andCenterValueEqualTo(BigDecimal value) {
            addCriterion("CENTER_VALUE =", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueNotEqualTo(BigDecimal value) {
            addCriterion("CENTER_VALUE <>", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueGreaterThan(BigDecimal value) {
            addCriterion("CENTER_VALUE >", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CENTER_VALUE >=", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueLessThan(BigDecimal value) {
            addCriterion("CENTER_VALUE <", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CENTER_VALUE <=", value, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueIn(List<BigDecimal> values) {
            addCriterion("CENTER_VALUE in", values, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueNotIn(List<BigDecimal> values) {
            addCriterion("CENTER_VALUE not in", values, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CENTER_VALUE between", value1, value2, "centerValue");
            return (Criteria) this;
        }

        public Criteria andCenterValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CENTER_VALUE not between", value1, value2, "centerValue");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIsNull() {
            addCriterion("QC_ITEM_SID is null");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIsNotNull() {
            addCriterion("QC_ITEM_SID is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemSidEqualTo(String value) {
            addCriterion("QC_ITEM_SID =", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotEqualTo(String value) {
            addCriterion("QC_ITEM_SID <>", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidGreaterThan(String value) {
            addCriterion("QC_ITEM_SID >", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_SID >=", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLessThan(String value) {
            addCriterion("QC_ITEM_SID <", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_SID <=", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLike(String value) {
            addCriterion("QC_ITEM_SID like", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotLike(String value) {
            addCriterion("QC_ITEM_SID not like", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIn(List<String> values) {
            addCriterion("QC_ITEM_SID in", values, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotIn(List<String> values) {
            addCriterion("QC_ITEM_SID not in", values, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidBetween(String value1, String value2) {
            addCriterion("QC_ITEM_SID between", value1, value2, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM_SID not between", value1, value2, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemIsNull() {
            addCriterion("QC_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andQcItemIsNotNull() {
            addCriterion("QC_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemEqualTo(String value) {
            addCriterion("QC_ITEM =", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotEqualTo(String value) {
            addCriterion("QC_ITEM <>", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemGreaterThan(String value) {
            addCriterion("QC_ITEM >", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM >=", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLessThan(String value) {
            addCriterion("QC_ITEM <", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM <=", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLike(String value) {
            addCriterion("QC_ITEM like", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotLike(String value) {
            addCriterion("QC_ITEM not like", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemIn(List<String> values) {
            addCriterion("QC_ITEM in", values, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotIn(List<String> values) {
            addCriterion("QC_ITEM not in", values, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemBetween(String value1, String value2) {
            addCriterion("QC_ITEM between", value1, value2, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM not between", value1, value2, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIsNull() {
            addCriterion("QC_ITEM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIsNotNull() {
            addCriterion("QC_ITEM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemDescEqualTo(String value) {
            addCriterion("QC_ITEM_DESC =", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotEqualTo(String value) {
            addCriterion("QC_ITEM_DESC <>", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescGreaterThan(String value) {
            addCriterion("QC_ITEM_DESC >", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_DESC >=", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLessThan(String value) {
            addCriterion("QC_ITEM_DESC <", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_DESC <=", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLike(String value) {
            addCriterion("QC_ITEM_DESC like", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotLike(String value) {
            addCriterion("QC_ITEM_DESC not like", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIn(List<String> values) {
            addCriterion("QC_ITEM_DESC in", values, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotIn(List<String> values) {
            addCriterion("QC_ITEM_DESC not in", values, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescBetween(String value1, String value2) {
            addCriterion("QC_ITEM_DESC between", value1, value2, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM_DESC not between", value1, value2, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("ITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("ITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("ITEM_TYPE =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("ITEM_TYPE <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("ITEM_TYPE >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("ITEM_TYPE <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("ITEM_TYPE like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("ITEM_TYPE not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("ITEM_TYPE in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("ITEM_TYPE not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("RESOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("RESOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(String value) {
            addCriterion("RESOURCE_TYPE =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(String value) {
            addCriterion("RESOURCE_TYPE >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(String value) {
            addCriterion("RESOURCE_TYPE <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLike(String value) {
            addCriterion("RESOURCE_TYPE like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotLike(String value) {
            addCriterion("RESOURCE_TYPE not like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<String> values) {
            addCriterion("RESOURCE_TYPE in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<String> values) {
            addCriterion("RESOURCE_TYPE not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIsNull() {
            addCriterion("QC_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIsNotNull() {
            addCriterion("QC_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionEqualTo(String value) {
            addCriterion("QC_DESCRIPTION =", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotEqualTo(String value) {
            addCriterion("QC_DESCRIPTION <>", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionGreaterThan(String value) {
            addCriterion("QC_DESCRIPTION >", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("QC_DESCRIPTION >=", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLessThan(String value) {
            addCriterion("QC_DESCRIPTION <", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLessThanOrEqualTo(String value) {
            addCriterion("QC_DESCRIPTION <=", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLike(String value) {
            addCriterion("QC_DESCRIPTION like", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotLike(String value) {
            addCriterion("QC_DESCRIPTION not like", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIn(List<String> values) {
            addCriterion("QC_DESCRIPTION in", values, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotIn(List<String> values) {
            addCriterion("QC_DESCRIPTION not in", values, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionBetween(String value1, String value2) {
            addCriterion("QC_DESCRIPTION between", value1, value2, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotBetween(String value1, String value2) {
            addCriterion("QC_DESCRIPTION not between", value1, value2, "qcDescription");
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

        public Criteria andUnitsIsNull() {
            addCriterion("UNITS is null");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNotNull() {
            addCriterion("UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsEqualTo(String value) {
            addCriterion("UNITS =", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotEqualTo(String value) {
            addCriterion("UNITS <>", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThan(String value) {
            addCriterion("UNITS >", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("UNITS >=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThan(String value) {
            addCriterion("UNITS <", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThanOrEqualTo(String value) {
            addCriterion("UNITS <=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLike(String value) {
            addCriterion("UNITS like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotLike(String value) {
            addCriterion("UNITS not like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsIn(List<String> values) {
            addCriterion("UNITS in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotIn(List<String> values) {
            addCriterion("UNITS not in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsBetween(String value1, String value2) {
            addCriterion("UNITS between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotBetween(String value1, String value2) {
            addCriterion("UNITS not between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andControlModeIsNull() {
            addCriterion("CONTROL_MODE is null");
            return (Criteria) this;
        }

        public Criteria andControlModeIsNotNull() {
            addCriterion("CONTROL_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andControlModeEqualTo(String value) {
            addCriterion("CONTROL_MODE =", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotEqualTo(String value) {
            addCriterion("CONTROL_MODE <>", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeGreaterThan(String value) {
            addCriterion("CONTROL_MODE >", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTROL_MODE >=", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLessThan(String value) {
            addCriterion("CONTROL_MODE <", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLessThanOrEqualTo(String value) {
            addCriterion("CONTROL_MODE <=", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLike(String value) {
            addCriterion("CONTROL_MODE like", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotLike(String value) {
            addCriterion("CONTROL_MODE not like", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeIn(List<String> values) {
            addCriterion("CONTROL_MODE in", values, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotIn(List<String> values) {
            addCriterion("CONTROL_MODE not in", values, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeBetween(String value1, String value2) {
            addCriterion("CONTROL_MODE between", value1, value2, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotBetween(String value1, String value2) {
            addCriterion("CONTROL_MODE not between", value1, value2, "controlMode");
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