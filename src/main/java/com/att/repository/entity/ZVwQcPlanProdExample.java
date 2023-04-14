package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwQcPlanProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwQcPlanProdExample() {
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

        public Criteria andWorkCenterIsNull() {
            addCriterion("WORK_CENTER is null");
            return (Criteria) this;
        }

        public Criteria andWorkCenterIsNotNull() {
            addCriterion("WORK_CENTER is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCenterEqualTo(String value) {
            addCriterion("WORK_CENTER =", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterNotEqualTo(String value) {
            addCriterion("WORK_CENTER <>", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterGreaterThan(String value) {
            addCriterion("WORK_CENTER >", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_CENTER >=", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterLessThan(String value) {
            addCriterion("WORK_CENTER <", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterLessThanOrEqualTo(String value) {
            addCriterion("WORK_CENTER <=", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterLike(String value) {
            addCriterion("WORK_CENTER like", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterNotLike(String value) {
            addCriterion("WORK_CENTER not like", value, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterIn(List<String> values) {
            addCriterion("WORK_CENTER in", values, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterNotIn(List<String> values) {
            addCriterion("WORK_CENTER not in", values, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterBetween(String value1, String value2) {
            addCriterion("WORK_CENTER between", value1, value2, "workCenter");
            return (Criteria) this;
        }

        public Criteria andWorkCenterNotBetween(String value1, String value2) {
            addCriterion("WORK_CENTER not between", value1, value2, "workCenter");
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

        public Criteria andResrceIsNull() {
            addCriterion("RESRCE is null");
            return (Criteria) this;
        }

        public Criteria andResrceIsNotNull() {
            addCriterion("RESRCE is not null");
            return (Criteria) this;
        }

        public Criteria andResrceEqualTo(String value) {
            addCriterion("RESRCE =", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceNotEqualTo(String value) {
            addCriterion("RESRCE <>", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceGreaterThan(String value) {
            addCriterion("RESRCE >", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceGreaterThanOrEqualTo(String value) {
            addCriterion("RESRCE >=", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceLessThan(String value) {
            addCriterion("RESRCE <", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceLessThanOrEqualTo(String value) {
            addCriterion("RESRCE <=", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceLike(String value) {
            addCriterion("RESRCE like", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceNotLike(String value) {
            addCriterion("RESRCE not like", value, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceIn(List<String> values) {
            addCriterion("RESRCE in", values, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceNotIn(List<String> values) {
            addCriterion("RESRCE not in", values, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceBetween(String value1, String value2) {
            addCriterion("RESRCE between", value1, value2, "resrce");
            return (Criteria) this;
        }

        public Criteria andResrceNotBetween(String value1, String value2) {
            addCriterion("RESRCE not between", value1, value2, "resrce");
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

        public Criteria andQcPlanRevisionIsNull() {
            addCriterion("QC_PLAN_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionIsNotNull() {
            addCriterion("QC_PLAN_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionEqualTo(String value) {
            addCriterion("QC_PLAN_REVISION =", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionNotEqualTo(String value) {
            addCriterion("QC_PLAN_REVISION <>", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionGreaterThan(String value) {
            addCriterion("QC_PLAN_REVISION >", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_REVISION >=", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionLessThan(String value) {
            addCriterion("QC_PLAN_REVISION <", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionLessThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_REVISION <=", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionLike(String value) {
            addCriterion("QC_PLAN_REVISION like", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionNotLike(String value) {
            addCriterion("QC_PLAN_REVISION not like", value, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionIn(List<String> values) {
            addCriterion("QC_PLAN_REVISION in", values, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionNotIn(List<String> values) {
            addCriterion("QC_PLAN_REVISION not in", values, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionBetween(String value1, String value2) {
            addCriterion("QC_PLAN_REVISION between", value1, value2, "qcPlanRevision");
            return (Criteria) this;
        }

        public Criteria andQcPlanRevisionNotBetween(String value1, String value2) {
            addCriterion("QC_PLAN_REVISION not between", value1, value2, "qcPlanRevision");
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

        public Criteria andMaterialNoIsNull() {
            addCriterion("MATERIAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNoIsNotNull() {
            addCriterion("MATERIAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNoEqualTo(String value) {
            addCriterion("MATERIAL_NO =", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoNotEqualTo(String value) {
            addCriterion("MATERIAL_NO <>", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoGreaterThan(String value) {
            addCriterion("MATERIAL_NO >", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIAL_NO >=", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoLessThan(String value) {
            addCriterion("MATERIAL_NO <", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoLessThanOrEqualTo(String value) {
            addCriterion("MATERIAL_NO <=", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoLike(String value) {
            addCriterion("MATERIAL_NO like", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoNotLike(String value) {
            addCriterion("MATERIAL_NO not like", value, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoIn(List<String> values) {
            addCriterion("MATERIAL_NO in", values, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoNotIn(List<String> values) {
            addCriterion("MATERIAL_NO not in", values, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoBetween(String value1, String value2) {
            addCriterion("MATERIAL_NO between", value1, value2, "materialNo");
            return (Criteria) this;
        }

        public Criteria andMaterialNoNotBetween(String value1, String value2) {
            addCriterion("MATERIAL_NO not between", value1, value2, "materialNo");
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