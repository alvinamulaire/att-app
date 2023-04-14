package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwQmsInspecJobResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwQmsInspecJobResultExample() {
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

        public Criteria andInspecJobBoIsNull() {
            addCriterion("INSPEC_JOB_BO is null");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoIsNotNull() {
            addCriterion("INSPEC_JOB_BO is not null");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoEqualTo(String value) {
            addCriterion("INSPEC_JOB_BO =", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoNotEqualTo(String value) {
            addCriterion("INSPEC_JOB_BO <>", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoGreaterThan(String value) {
            addCriterion("INSPEC_JOB_BO >", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoGreaterThanOrEqualTo(String value) {
            addCriterion("INSPEC_JOB_BO >=", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoLessThan(String value) {
            addCriterion("INSPEC_JOB_BO <", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoLessThanOrEqualTo(String value) {
            addCriterion("INSPEC_JOB_BO <=", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoLike(String value) {
            addCriterion("INSPEC_JOB_BO like", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoNotLike(String value) {
            addCriterion("INSPEC_JOB_BO not like", value, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoIn(List<String> values) {
            addCriterion("INSPEC_JOB_BO in", values, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoNotIn(List<String> values) {
            addCriterion("INSPEC_JOB_BO not in", values, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoBetween(String value1, String value2) {
            addCriterion("INSPEC_JOB_BO between", value1, value2, "inspecJobBo");
            return (Criteria) this;
        }

        public Criteria andInspecJobBoNotBetween(String value1, String value2) {
            addCriterion("INSPEC_JOB_BO not between", value1, value2, "inspecJobBo");
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

        public Criteria andSampleSizeIsNull() {
            addCriterion("SAMPLE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andSampleSizeIsNotNull() {
            addCriterion("SAMPLE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andSampleSizeEqualTo(BigDecimal value) {
            addCriterion("SAMPLE_SIZE =", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeNotEqualTo(BigDecimal value) {
            addCriterion("SAMPLE_SIZE <>", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeGreaterThan(BigDecimal value) {
            addCriterion("SAMPLE_SIZE >", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SAMPLE_SIZE >=", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeLessThan(BigDecimal value) {
            addCriterion("SAMPLE_SIZE <", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SAMPLE_SIZE <=", value, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeIn(List<BigDecimal> values) {
            addCriterion("SAMPLE_SIZE in", values, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeNotIn(List<BigDecimal> values) {
            addCriterion("SAMPLE_SIZE not in", values, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAMPLE_SIZE between", value1, value2, "sampleSize");
            return (Criteria) this;
        }

        public Criteria andSampleSizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAMPLE_SIZE not between", value1, value2, "sampleSize");
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

        public Criteria andInspecDateTimeIsNull() {
            addCriterion("INSPEC_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeIsNotNull() {
            addCriterion("INSPEC_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeEqualTo(Date value) {
            addCriterion("INSPEC_DATE_TIME =", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeNotEqualTo(Date value) {
            addCriterion("INSPEC_DATE_TIME <>", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeGreaterThan(Date value) {
            addCriterion("INSPEC_DATE_TIME >", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INSPEC_DATE_TIME >=", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeLessThan(Date value) {
            addCriterion("INSPEC_DATE_TIME <", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("INSPEC_DATE_TIME <=", value, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeIn(List<Date> values) {
            addCriterion("INSPEC_DATE_TIME in", values, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeNotIn(List<Date> values) {
            addCriterion("INSPEC_DATE_TIME not in", values, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeBetween(Date value1, Date value2) {
            addCriterion("INSPEC_DATE_TIME between", value1, value2, "inspecDateTime");
            return (Criteria) this;
        }

        public Criteria andInspecDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("INSPEC_DATE_TIME not between", value1, value2, "inspecDateTime");
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

        public Criteria andInspecResultIsNull() {
            addCriterion("INSPEC_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andInspecResultIsNotNull() {
            addCriterion("INSPEC_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andInspecResultEqualTo(BigDecimal value) {
            addCriterion("INSPEC_RESULT =", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultNotEqualTo(BigDecimal value) {
            addCriterion("INSPEC_RESULT <>", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultGreaterThan(BigDecimal value) {
            addCriterion("INSPEC_RESULT >", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPEC_RESULT >=", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultLessThan(BigDecimal value) {
            addCriterion("INSPEC_RESULT <", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSPEC_RESULT <=", value, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultIn(List<BigDecimal> values) {
            addCriterion("INSPEC_RESULT in", values, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultNotIn(List<BigDecimal> values) {
            addCriterion("INSPEC_RESULT not in", values, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPEC_RESULT between", value1, value2, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andInspecResultNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSPEC_RESULT not between", value1, value2, "inspecResult");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNull() {
            addCriterion("SERIES is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNotNull() {
            addCriterion("SERIES is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesEqualTo(Short value) {
            addCriterion("SERIES =", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotEqualTo(Short value) {
            addCriterion("SERIES <>", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThan(Short value) {
            addCriterion("SERIES >", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThanOrEqualTo(Short value) {
            addCriterion("SERIES >=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThan(Short value) {
            addCriterion("SERIES <", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThanOrEqualTo(Short value) {
            addCriterion("SERIES <=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesIn(List<Short> values) {
            addCriterion("SERIES in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotIn(List<Short> values) {
            addCriterion("SERIES not in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesBetween(Short value1, Short value2) {
            addCriterion("SERIES between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotBetween(Short value1, Short value2) {
            addCriterion("SERIES not between", value1, value2, "series");
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