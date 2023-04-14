package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwQmsInspecJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwQmsInspecJobExample() {
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

        public Criteria andJobNoIsNull() {
            addCriterion("JOB_NO is null");
            return (Criteria) this;
        }

        public Criteria andJobNoIsNotNull() {
            addCriterion("JOB_NO is not null");
            return (Criteria) this;
        }

        public Criteria andJobNoEqualTo(String value) {
            addCriterion("JOB_NO =", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotEqualTo(String value) {
            addCriterion("JOB_NO <>", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoGreaterThan(String value) {
            addCriterion("JOB_NO >", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_NO >=", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLessThan(String value) {
            addCriterion("JOB_NO <", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLessThanOrEqualTo(String value) {
            addCriterion("JOB_NO <=", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoLike(String value) {
            addCriterion("JOB_NO like", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotLike(String value) {
            addCriterion("JOB_NO not like", value, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoIn(List<String> values) {
            addCriterion("JOB_NO in", values, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotIn(List<String> values) {
            addCriterion("JOB_NO not in", values, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoBetween(String value1, String value2) {
            addCriterion("JOB_NO between", value1, value2, "jobNo");
            return (Criteria) this;
        }

        public Criteria andJobNoNotBetween(String value1, String value2) {
            addCriterion("JOB_NO not between", value1, value2, "jobNo");
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

        public Criteria andQcFreqIsNull() {
            addCriterion("QC_FREQ is null");
            return (Criteria) this;
        }

        public Criteria andQcFreqIsNotNull() {
            addCriterion("QC_FREQ is not null");
            return (Criteria) this;
        }

        public Criteria andQcFreqEqualTo(String value) {
            addCriterion("QC_FREQ =", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqNotEqualTo(String value) {
            addCriterion("QC_FREQ <>", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqGreaterThan(String value) {
            addCriterion("QC_FREQ >", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqGreaterThanOrEqualTo(String value) {
            addCriterion("QC_FREQ >=", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqLessThan(String value) {
            addCriterion("QC_FREQ <", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqLessThanOrEqualTo(String value) {
            addCriterion("QC_FREQ <=", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqLike(String value) {
            addCriterion("QC_FREQ like", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqNotLike(String value) {
            addCriterion("QC_FREQ not like", value, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqIn(List<String> values) {
            addCriterion("QC_FREQ in", values, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqNotIn(List<String> values) {
            addCriterion("QC_FREQ not in", values, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqBetween(String value1, String value2) {
            addCriterion("QC_FREQ between", value1, value2, "qcFreq");
            return (Criteria) this;
        }

        public Criteria andQcFreqNotBetween(String value1, String value2) {
            addCriterion("QC_FREQ not between", value1, value2, "qcFreq");
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

        public Criteria andPopulationQtyIsNull() {
            addCriterion("POPULATION_QTY is null");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyIsNotNull() {
            addCriterion("POPULATION_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyEqualTo(BigDecimal value) {
            addCriterion("POPULATION_QTY =", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyNotEqualTo(BigDecimal value) {
            addCriterion("POPULATION_QTY <>", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyGreaterThan(BigDecimal value) {
            addCriterion("POPULATION_QTY >", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POPULATION_QTY >=", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyLessThan(BigDecimal value) {
            addCriterion("POPULATION_QTY <", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POPULATION_QTY <=", value, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyIn(List<BigDecimal> values) {
            addCriterion("POPULATION_QTY in", values, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyNotIn(List<BigDecimal> values) {
            addCriterion("POPULATION_QTY not in", values, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POPULATION_QTY between", value1, value2, "populationQty");
            return (Criteria) this;
        }

        public Criteria andPopulationQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POPULATION_QTY not between", value1, value2, "populationQty");
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

        public Criteria andEndDateTimeIsNull() {
            addCriterion("END_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNotNull() {
            addCriterion("END_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeEqualTo(Date value) {
            addCriterion("END_DATE_TIME =", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotEqualTo(Date value) {
            addCriterion("END_DATE_TIME <>", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThan(Date value) {
            addCriterion("END_DATE_TIME >", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_DATE_TIME >=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThan(Date value) {
            addCriterion("END_DATE_TIME <", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_DATE_TIME <=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIn(List<Date> values) {
            addCriterion("END_DATE_TIME in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotIn(List<Date> values) {
            addCriterion("END_DATE_TIME not in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeBetween(Date value1, Date value2) {
            addCriterion("END_DATE_TIME between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_DATE_TIME not between", value1, value2, "endDateTime");
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

        public Criteria andCheckUserIsNull() {
            addCriterion("CHECK_USER is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNotNull() {
            addCriterion("CHECK_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserEqualTo(String value) {
            addCriterion("CHECK_USER =", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotEqualTo(String value) {
            addCriterion("CHECK_USER <>", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThan(String value) {
            addCriterion("CHECK_USER >", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_USER >=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThan(String value) {
            addCriterion("CHECK_USER <", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThanOrEqualTo(String value) {
            addCriterion("CHECK_USER <=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLike(String value) {
            addCriterion("CHECK_USER like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotLike(String value) {
            addCriterion("CHECK_USER not like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserIn(List<String> values) {
            addCriterion("CHECK_USER in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotIn(List<String> values) {
            addCriterion("CHECK_USER not in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserBetween(String value1, String value2) {
            addCriterion("CHECK_USER between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotBetween(String value1, String value2) {
            addCriterion("CHECK_USER not between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeIsNull() {
            addCriterion("CHECK_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeIsNotNull() {
            addCriterion("CHECK_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeEqualTo(Date value) {
            addCriterion("CHECK_DATE_TIME =", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotEqualTo(Date value) {
            addCriterion("CHECK_DATE_TIME <>", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeGreaterThan(Date value) {
            addCriterion("CHECK_DATE_TIME >", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE_TIME >=", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeLessThan(Date value) {
            addCriterion("CHECK_DATE_TIME <", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE_TIME <=", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeIn(List<Date> values) {
            addCriterion("CHECK_DATE_TIME in", values, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotIn(List<Date> values) {
            addCriterion("CHECK_DATE_TIME not in", values, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE_TIME between", value1, value2, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE_TIME not between", value1, value2, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andOkQtyIsNull() {
            addCriterion("OK_QTY is null");
            return (Criteria) this;
        }

        public Criteria andOkQtyIsNotNull() {
            addCriterion("OK_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andOkQtyEqualTo(BigDecimal value) {
            addCriterion("OK_QTY =", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyNotEqualTo(BigDecimal value) {
            addCriterion("OK_QTY <>", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyGreaterThan(BigDecimal value) {
            addCriterion("OK_QTY >", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OK_QTY >=", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyLessThan(BigDecimal value) {
            addCriterion("OK_QTY <", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OK_QTY <=", value, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyIn(List<BigDecimal> values) {
            addCriterion("OK_QTY in", values, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyNotIn(List<BigDecimal> values) {
            addCriterion("OK_QTY not in", values, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OK_QTY between", value1, value2, "okQty");
            return (Criteria) this;
        }

        public Criteria andOkQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OK_QTY not between", value1, value2, "okQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyIsNull() {
            addCriterion("NG_QTY is null");
            return (Criteria) this;
        }

        public Criteria andNgQtyIsNotNull() {
            addCriterion("NG_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andNgQtyEqualTo(BigDecimal value) {
            addCriterion("NG_QTY =", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyNotEqualTo(BigDecimal value) {
            addCriterion("NG_QTY <>", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyGreaterThan(BigDecimal value) {
            addCriterion("NG_QTY >", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NG_QTY >=", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyLessThan(BigDecimal value) {
            addCriterion("NG_QTY <", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NG_QTY <=", value, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyIn(List<BigDecimal> values) {
            addCriterion("NG_QTY in", values, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyNotIn(List<BigDecimal> values) {
            addCriterion("NG_QTY not in", values, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NG_QTY between", value1, value2, "ngQty");
            return (Criteria) this;
        }

        public Criteria andNgQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NG_QTY not between", value1, value2, "ngQty");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoIsNull() {
            addCriterion("ABN_GROUP_NO is null");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoIsNotNull() {
            addCriterion("ABN_GROUP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoEqualTo(String value) {
            addCriterion("ABN_GROUP_NO =", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoNotEqualTo(String value) {
            addCriterion("ABN_GROUP_NO <>", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoGreaterThan(String value) {
            addCriterion("ABN_GROUP_NO >", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("ABN_GROUP_NO >=", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoLessThan(String value) {
            addCriterion("ABN_GROUP_NO <", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoLessThanOrEqualTo(String value) {
            addCriterion("ABN_GROUP_NO <=", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoLike(String value) {
            addCriterion("ABN_GROUP_NO like", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoNotLike(String value) {
            addCriterion("ABN_GROUP_NO not like", value, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoIn(List<String> values) {
            addCriterion("ABN_GROUP_NO in", values, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoNotIn(List<String> values) {
            addCriterion("ABN_GROUP_NO not in", values, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoBetween(String value1, String value2) {
            addCriterion("ABN_GROUP_NO between", value1, value2, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andAbnGroupNoNotBetween(String value1, String value2) {
            addCriterion("ABN_GROUP_NO not between", value1, value2, "abnGroupNo");
            return (Criteria) this;
        }

        public Criteria andUdCodeIsNull() {
            addCriterion("UD_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUdCodeIsNotNull() {
            addCriterion("UD_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUdCodeEqualTo(String value) {
            addCriterion("UD_CODE =", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeNotEqualTo(String value) {
            addCriterion("UD_CODE <>", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeGreaterThan(String value) {
            addCriterion("UD_CODE >", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UD_CODE >=", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeLessThan(String value) {
            addCriterion("UD_CODE <", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeLessThanOrEqualTo(String value) {
            addCriterion("UD_CODE <=", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeLike(String value) {
            addCriterion("UD_CODE like", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeNotLike(String value) {
            addCriterion("UD_CODE not like", value, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeIn(List<String> values) {
            addCriterion("UD_CODE in", values, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeNotIn(List<String> values) {
            addCriterion("UD_CODE not in", values, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeBetween(String value1, String value2) {
            addCriterion("UD_CODE between", value1, value2, "udCode");
            return (Criteria) this;
        }

        public Criteria andUdCodeNotBetween(String value1, String value2) {
            addCriterion("UD_CODE not between", value1, value2, "udCode");
            return (Criteria) this;
        }

        public Criteria andTestingQtyIsNull() {
            addCriterion("TESTING_QTY is null");
            return (Criteria) this;
        }

        public Criteria andTestingQtyIsNotNull() {
            addCriterion("TESTING_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andTestingQtyEqualTo(BigDecimal value) {
            addCriterion("TESTING_QTY =", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyNotEqualTo(BigDecimal value) {
            addCriterion("TESTING_QTY <>", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyGreaterThan(BigDecimal value) {
            addCriterion("TESTING_QTY >", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TESTING_QTY >=", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyLessThan(BigDecimal value) {
            addCriterion("TESTING_QTY <", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TESTING_QTY <=", value, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyIn(List<BigDecimal> values) {
            addCriterion("TESTING_QTY in", values, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyNotIn(List<BigDecimal> values) {
            addCriterion("TESTING_QTY not in", values, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TESTING_QTY between", value1, value2, "testingQty");
            return (Criteria) this;
        }

        public Criteria andTestingQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TESTING_QTY not between", value1, value2, "testingQty");
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

        public Criteria andIsErpIsNull() {
            addCriterion("IS_ERP is null");
            return (Criteria) this;
        }

        public Criteria andIsErpIsNotNull() {
            addCriterion("IS_ERP is not null");
            return (Criteria) this;
        }

        public Criteria andIsErpEqualTo(String value) {
            addCriterion("IS_ERP =", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpNotEqualTo(String value) {
            addCriterion("IS_ERP <>", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpGreaterThan(String value) {
            addCriterion("IS_ERP >", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpGreaterThanOrEqualTo(String value) {
            addCriterion("IS_ERP >=", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpLessThan(String value) {
            addCriterion("IS_ERP <", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpLessThanOrEqualTo(String value) {
            addCriterion("IS_ERP <=", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpLike(String value) {
            addCriterion("IS_ERP like", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpNotLike(String value) {
            addCriterion("IS_ERP not like", value, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpIn(List<String> values) {
            addCriterion("IS_ERP in", values, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpNotIn(List<String> values) {
            addCriterion("IS_ERP not in", values, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpBetween(String value1, String value2) {
            addCriterion("IS_ERP between", value1, value2, "isErp");
            return (Criteria) this;
        }

        public Criteria andIsErpNotBetween(String value1, String value2) {
            addCriterion("IS_ERP not between", value1, value2, "isErp");
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