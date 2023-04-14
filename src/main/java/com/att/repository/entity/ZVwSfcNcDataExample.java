package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwSfcNcDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwSfcNcDataExample() {
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

        public Criteria andShopOrderErpTypeIsNull() {
            addCriterion("SHOP_ORDER_ERP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeIsNotNull() {
            addCriterion("SHOP_ORDER_ERP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeEqualTo(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE =", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeNotEqualTo(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE <>", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeGreaterThan(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE >", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE >=", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeLessThan(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE <", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE <=", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeLike(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE like", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeNotLike(String value) {
            addCriterion("SHOP_ORDER_ERP_TYPE not like", value, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeIn(List<String> values) {
            addCriterion("SHOP_ORDER_ERP_TYPE in", values, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeNotIn(List<String> values) {
            addCriterion("SHOP_ORDER_ERP_TYPE not in", values, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_ERP_TYPE between", value1, value2, "shopOrderErpType");
            return (Criteria) this;
        }

        public Criteria andShopOrderErpTypeNotBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_ERP_TYPE not between", value1, value2, "shopOrderErpType");
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

        public Criteria andOperationDescIsNull() {
            addCriterion("OPERATION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOperationDescIsNotNull() {
            addCriterion("OPERATION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDescEqualTo(String value) {
            addCriterion("OPERATION_DESC =", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescNotEqualTo(String value) {
            addCriterion("OPERATION_DESC <>", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescGreaterThan(String value) {
            addCriterion("OPERATION_DESC >", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_DESC >=", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescLessThan(String value) {
            addCriterion("OPERATION_DESC <", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_DESC <=", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescLike(String value) {
            addCriterion("OPERATION_DESC like", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescNotLike(String value) {
            addCriterion("OPERATION_DESC not like", value, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescIn(List<String> values) {
            addCriterion("OPERATION_DESC in", values, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescNotIn(List<String> values) {
            addCriterion("OPERATION_DESC not in", values, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescBetween(String value1, String value2) {
            addCriterion("OPERATION_DESC between", value1, value2, "operationDesc");
            return (Criteria) this;
        }

        public Criteria andOperationDescNotBetween(String value1, String value2) {
            addCriterion("OPERATION_DESC not between", value1, value2, "operationDesc");
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

        public Criteria andItemDescIsNull() {
            addCriterion("ITEM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andItemDescIsNotNull() {
            addCriterion("ITEM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescEqualTo(String value) {
            addCriterion("ITEM_DESC =", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotEqualTo(String value) {
            addCriterion("ITEM_DESC <>", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThan(String value) {
            addCriterion("ITEM_DESC >", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_DESC >=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThan(String value) {
            addCriterion("ITEM_DESC <", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThanOrEqualTo(String value) {
            addCriterion("ITEM_DESC <=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLike(String value) {
            addCriterion("ITEM_DESC like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotLike(String value) {
            addCriterion("ITEM_DESC not like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescIn(List<String> values) {
            addCriterion("ITEM_DESC in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotIn(List<String> values) {
            addCriterion("ITEM_DESC not in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescBetween(String value1, String value2) {
            addCriterion("ITEM_DESC between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotBetween(String value1, String value2) {
            addCriterion("ITEM_DESC not between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeIsNull() {
            addCriterion("NC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andNcCodeIsNotNull() {
            addCriterion("NC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andNcCodeEqualTo(String value) {
            addCriterion("NC_CODE =", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeNotEqualTo(String value) {
            addCriterion("NC_CODE <>", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeGreaterThan(String value) {
            addCriterion("NC_CODE >", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("NC_CODE >=", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeLessThan(String value) {
            addCriterion("NC_CODE <", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeLessThanOrEqualTo(String value) {
            addCriterion("NC_CODE <=", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeLike(String value) {
            addCriterion("NC_CODE like", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeNotLike(String value) {
            addCriterion("NC_CODE not like", value, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeIn(List<String> values) {
            addCriterion("NC_CODE in", values, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeNotIn(List<String> values) {
            addCriterion("NC_CODE not in", values, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeBetween(String value1, String value2) {
            addCriterion("NC_CODE between", value1, value2, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeNotBetween(String value1, String value2) {
            addCriterion("NC_CODE not between", value1, value2, "ncCode");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescIsNull() {
            addCriterion("NC_CODE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescIsNotNull() {
            addCriterion("NC_CODE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescEqualTo(String value) {
            addCriterion("NC_CODE_DESC =", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescNotEqualTo(String value) {
            addCriterion("NC_CODE_DESC <>", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescGreaterThan(String value) {
            addCriterion("NC_CODE_DESC >", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescGreaterThanOrEqualTo(String value) {
            addCriterion("NC_CODE_DESC >=", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescLessThan(String value) {
            addCriterion("NC_CODE_DESC <", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescLessThanOrEqualTo(String value) {
            addCriterion("NC_CODE_DESC <=", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescLike(String value) {
            addCriterion("NC_CODE_DESC like", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescNotLike(String value) {
            addCriterion("NC_CODE_DESC not like", value, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescIn(List<String> values) {
            addCriterion("NC_CODE_DESC in", values, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescNotIn(List<String> values) {
            addCriterion("NC_CODE_DESC not in", values, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescBetween(String value1, String value2) {
            addCriterion("NC_CODE_DESC between", value1, value2, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcCodeDescNotBetween(String value1, String value2) {
            addCriterion("NC_CODE_DESC not between", value1, value2, "ncCodeDesc");
            return (Criteria) this;
        }

        public Criteria andNcStateIsNull() {
            addCriterion("NC_STATE is null");
            return (Criteria) this;
        }

        public Criteria andNcStateIsNotNull() {
            addCriterion("NC_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andNcStateEqualTo(String value) {
            addCriterion("NC_STATE =", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateNotEqualTo(String value) {
            addCriterion("NC_STATE <>", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateGreaterThan(String value) {
            addCriterion("NC_STATE >", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateGreaterThanOrEqualTo(String value) {
            addCriterion("NC_STATE >=", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateLessThan(String value) {
            addCriterion("NC_STATE <", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateLessThanOrEqualTo(String value) {
            addCriterion("NC_STATE <=", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateLike(String value) {
            addCriterion("NC_STATE like", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateNotLike(String value) {
            addCriterion("NC_STATE not like", value, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateIn(List<String> values) {
            addCriterion("NC_STATE in", values, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateNotIn(List<String> values) {
            addCriterion("NC_STATE not in", values, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateBetween(String value1, String value2) {
            addCriterion("NC_STATE between", value1, value2, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcStateNotBetween(String value1, String value2) {
            addCriterion("NC_STATE not between", value1, value2, "ncState");
            return (Criteria) this;
        }

        public Criteria andNcCategoryIsNull() {
            addCriterion("NC_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andNcCategoryIsNotNull() {
            addCriterion("NC_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andNcCategoryEqualTo(String value) {
            addCriterion("NC_CATEGORY =", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryNotEqualTo(String value) {
            addCriterion("NC_CATEGORY <>", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryGreaterThan(String value) {
            addCriterion("NC_CATEGORY >", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("NC_CATEGORY >=", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryLessThan(String value) {
            addCriterion("NC_CATEGORY <", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryLessThanOrEqualTo(String value) {
            addCriterion("NC_CATEGORY <=", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryLike(String value) {
            addCriterion("NC_CATEGORY like", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryNotLike(String value) {
            addCriterion("NC_CATEGORY not like", value, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryIn(List<String> values) {
            addCriterion("NC_CATEGORY in", values, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryNotIn(List<String> values) {
            addCriterion("NC_CATEGORY not in", values, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryBetween(String value1, String value2) {
            addCriterion("NC_CATEGORY between", value1, value2, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcCategoryNotBetween(String value1, String value2) {
            addCriterion("NC_CATEGORY not between", value1, value2, "ncCategory");
            return (Criteria) this;
        }

        public Criteria andNcQtyIsNull() {
            addCriterion("NC_QTY is null");
            return (Criteria) this;
        }

        public Criteria andNcQtyIsNotNull() {
            addCriterion("NC_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andNcQtyEqualTo(BigDecimal value) {
            addCriterion("NC_QTY =", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyNotEqualTo(BigDecimal value) {
            addCriterion("NC_QTY <>", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyGreaterThan(BigDecimal value) {
            addCriterion("NC_QTY >", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NC_QTY >=", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyLessThan(BigDecimal value) {
            addCriterion("NC_QTY <", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NC_QTY <=", value, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyIn(List<BigDecimal> values) {
            addCriterion("NC_QTY in", values, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyNotIn(List<BigDecimal> values) {
            addCriterion("NC_QTY not in", values, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NC_QTY between", value1, value2, "ncQty");
            return (Criteria) this;
        }

        public Criteria andNcQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NC_QTY not between", value1, value2, "ncQty");
            return (Criteria) this;
        }

        public Criteria andActionCodeIsNull() {
            addCriterion("ACTION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andActionCodeIsNotNull() {
            addCriterion("ACTION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andActionCodeEqualTo(String value) {
            addCriterion("ACTION_CODE =", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeNotEqualTo(String value) {
            addCriterion("ACTION_CODE <>", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeGreaterThan(String value) {
            addCriterion("ACTION_CODE >", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_CODE >=", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeLessThan(String value) {
            addCriterion("ACTION_CODE <", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeLessThanOrEqualTo(String value) {
            addCriterion("ACTION_CODE <=", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeLike(String value) {
            addCriterion("ACTION_CODE like", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeNotLike(String value) {
            addCriterion("ACTION_CODE not like", value, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeIn(List<String> values) {
            addCriterion("ACTION_CODE in", values, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeNotIn(List<String> values) {
            addCriterion("ACTION_CODE not in", values, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeBetween(String value1, String value2) {
            addCriterion("ACTION_CODE between", value1, value2, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeNotBetween(String value1, String value2) {
            addCriterion("ACTION_CODE not between", value1, value2, "actionCode");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescIsNull() {
            addCriterion("ACTION_CODE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescIsNotNull() {
            addCriterion("ACTION_CODE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescEqualTo(String value) {
            addCriterion("ACTION_CODE_DESC =", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescNotEqualTo(String value) {
            addCriterion("ACTION_CODE_DESC <>", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescGreaterThan(String value) {
            addCriterion("ACTION_CODE_DESC >", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_CODE_DESC >=", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescLessThan(String value) {
            addCriterion("ACTION_CODE_DESC <", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescLessThanOrEqualTo(String value) {
            addCriterion("ACTION_CODE_DESC <=", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescLike(String value) {
            addCriterion("ACTION_CODE_DESC like", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescNotLike(String value) {
            addCriterion("ACTION_CODE_DESC not like", value, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescIn(List<String> values) {
            addCriterion("ACTION_CODE_DESC in", values, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescNotIn(List<String> values) {
            addCriterion("ACTION_CODE_DESC not in", values, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescBetween(String value1, String value2) {
            addCriterion("ACTION_CODE_DESC between", value1, value2, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andActionCodeDescNotBetween(String value1, String value2) {
            addCriterion("ACTION_CODE_DESC not between", value1, value2, "actionCodeDesc");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(Date value) {
            addCriterion("DATE_TIME =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(Date value) {
            addCriterion("DATE_TIME <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(Date value) {
            addCriterion("DATE_TIME >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DATE_TIME >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(Date value) {
            addCriterion("DATE_TIME <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("DATE_TIME <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<Date> values) {
            addCriterion("DATE_TIME in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<Date> values) {
            addCriterion("DATE_TIME not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(Date value1, Date value2) {
            addCriterion("DATE_TIME between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("DATE_TIME not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andUserBoIsNull() {
            addCriterion("USER_BO is null");
            return (Criteria) this;
        }

        public Criteria andUserBoIsNotNull() {
            addCriterion("USER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andUserBoEqualTo(String value) {
            addCriterion("USER_BO =", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoNotEqualTo(String value) {
            addCriterion("USER_BO <>", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoGreaterThan(String value) {
            addCriterion("USER_BO >", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_BO >=", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoLessThan(String value) {
            addCriterion("USER_BO <", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoLessThanOrEqualTo(String value) {
            addCriterion("USER_BO <=", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoLike(String value) {
            addCriterion("USER_BO like", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoNotLike(String value) {
            addCriterion("USER_BO not like", value, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoIn(List<String> values) {
            addCriterion("USER_BO in", values, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoNotIn(List<String> values) {
            addCriterion("USER_BO not in", values, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoBetween(String value1, String value2) {
            addCriterion("USER_BO between", value1, value2, "userBo");
            return (Criteria) this;
        }

        public Criteria andUserBoNotBetween(String value1, String value2) {
            addCriterion("USER_BO not between", value1, value2, "userBo");
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