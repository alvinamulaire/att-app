package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZSfcNcDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZSfcNcDataExample() {
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

        public Criteria andNcDataBoIsNull() {
            addCriterion("NC_DATA_BO is null");
            return (Criteria) this;
        }

        public Criteria andNcDataBoIsNotNull() {
            addCriterion("NC_DATA_BO is not null");
            return (Criteria) this;
        }

        public Criteria andNcDataBoEqualTo(String value) {
            addCriterion("NC_DATA_BO =", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoNotEqualTo(String value) {
            addCriterion("NC_DATA_BO <>", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoGreaterThan(String value) {
            addCriterion("NC_DATA_BO >", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoGreaterThanOrEqualTo(String value) {
            addCriterion("NC_DATA_BO >=", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoLessThan(String value) {
            addCriterion("NC_DATA_BO <", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoLessThanOrEqualTo(String value) {
            addCriterion("NC_DATA_BO <=", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoLike(String value) {
            addCriterion("NC_DATA_BO like", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoNotLike(String value) {
            addCriterion("NC_DATA_BO not like", value, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoIn(List<String> values) {
            addCriterion("NC_DATA_BO in", values, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoNotIn(List<String> values) {
            addCriterion("NC_DATA_BO not in", values, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoBetween(String value1, String value2) {
            addCriterion("NC_DATA_BO between", value1, value2, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andNcDataBoNotBetween(String value1, String value2) {
            addCriterion("NC_DATA_BO not between", value1, value2, "ncDataBo");
            return (Criteria) this;
        }

        public Criteria andIsCancelledIsNull() {
            addCriterion("IS_CANCELLED is null");
            return (Criteria) this;
        }

        public Criteria andIsCancelledIsNotNull() {
            addCriterion("IS_CANCELLED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCancelledEqualTo(String value) {
            addCriterion("IS_CANCELLED =", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledNotEqualTo(String value) {
            addCriterion("IS_CANCELLED <>", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledGreaterThan(String value) {
            addCriterion("IS_CANCELLED >", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CANCELLED >=", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledLessThan(String value) {
            addCriterion("IS_CANCELLED <", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledLessThanOrEqualTo(String value) {
            addCriterion("IS_CANCELLED <=", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledLike(String value) {
            addCriterion("IS_CANCELLED like", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledNotLike(String value) {
            addCriterion("IS_CANCELLED not like", value, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledIn(List<String> values) {
            addCriterion("IS_CANCELLED in", values, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledNotIn(List<String> values) {
            addCriterion("IS_CANCELLED not in", values, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledBetween(String value1, String value2) {
            addCriterion("IS_CANCELLED between", value1, value2, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andIsCancelledNotBetween(String value1, String value2) {
            addCriterion("IS_CANCELLED not between", value1, value2, "isCancelled");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoIsNull() {
            addCriterion("CANCELLED_USER_BO is null");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoIsNotNull() {
            addCriterion("CANCELLED_USER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoEqualTo(String value) {
            addCriterion("CANCELLED_USER_BO =", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoNotEqualTo(String value) {
            addCriterion("CANCELLED_USER_BO <>", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoGreaterThan(String value) {
            addCriterion("CANCELLED_USER_BO >", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELLED_USER_BO >=", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoLessThan(String value) {
            addCriterion("CANCELLED_USER_BO <", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoLessThanOrEqualTo(String value) {
            addCriterion("CANCELLED_USER_BO <=", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoLike(String value) {
            addCriterion("CANCELLED_USER_BO like", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoNotLike(String value) {
            addCriterion("CANCELLED_USER_BO not like", value, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoIn(List<String> values) {
            addCriterion("CANCELLED_USER_BO in", values, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoNotIn(List<String> values) {
            addCriterion("CANCELLED_USER_BO not in", values, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoBetween(String value1, String value2) {
            addCriterion("CANCELLED_USER_BO between", value1, value2, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledUserBoNotBetween(String value1, String value2) {
            addCriterion("CANCELLED_USER_BO not between", value1, value2, "cancelledUserBo");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeIsNull() {
            addCriterion("CANCELLED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeIsNotNull() {
            addCriterion("CANCELLED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeEqualTo(Date value) {
            addCriterion("CANCELLED_DATE_TIME =", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeNotEqualTo(Date value) {
            addCriterion("CANCELLED_DATE_TIME <>", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeGreaterThan(Date value) {
            addCriterion("CANCELLED_DATE_TIME >", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CANCELLED_DATE_TIME >=", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeLessThan(Date value) {
            addCriterion("CANCELLED_DATE_TIME <", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CANCELLED_DATE_TIME <=", value, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeIn(List<Date> values) {
            addCriterion("CANCELLED_DATE_TIME in", values, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeNotIn(List<Date> values) {
            addCriterion("CANCELLED_DATE_TIME not in", values, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeBetween(Date value1, Date value2) {
            addCriterion("CANCELLED_DATE_TIME between", value1, value2, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CANCELLED_DATE_TIME not between", value1, value2, "cancelledDateTime");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonIsNull() {
            addCriterion("CANCELLED_REASON is null");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonIsNotNull() {
            addCriterion("CANCELLED_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonEqualTo(String value) {
            addCriterion("CANCELLED_REASON =", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonNotEqualTo(String value) {
            addCriterion("CANCELLED_REASON <>", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonGreaterThan(String value) {
            addCriterion("CANCELLED_REASON >", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELLED_REASON >=", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonLessThan(String value) {
            addCriterion("CANCELLED_REASON <", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonLessThanOrEqualTo(String value) {
            addCriterion("CANCELLED_REASON <=", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonLike(String value) {
            addCriterion("CANCELLED_REASON like", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonNotLike(String value) {
            addCriterion("CANCELLED_REASON not like", value, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonIn(List<String> values) {
            addCriterion("CANCELLED_REASON in", values, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonNotIn(List<String> values) {
            addCriterion("CANCELLED_REASON not in", values, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonBetween(String value1, String value2) {
            addCriterion("CANCELLED_REASON between", value1, value2, "cancelledReason");
            return (Criteria) this;
        }

        public Criteria andCancelledReasonNotBetween(String value1, String value2) {
            addCriterion("CANCELLED_REASON not between", value1, value2, "cancelledReason");
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