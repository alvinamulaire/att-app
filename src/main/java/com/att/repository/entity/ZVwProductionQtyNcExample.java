package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwProductionQtyNcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwProductionQtyNcExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("DATE is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("DATE =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("DATE <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("DATE >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("DATE >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("DATE <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("DATE <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("DATE like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("DATE not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("DATE in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("DATE not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("DATE between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("DATE not between", value1, value2, "date");
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

        public Criteria andActivityIsNull() {
            addCriterion("ACTIVITY is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsNotNull() {
            addCriterion("ACTIVITY is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEqualTo(String value) {
            addCriterion("ACTIVITY =", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotEqualTo(String value) {
            addCriterion("ACTIVITY <>", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThan(String value) {
            addCriterion("ACTIVITY >", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVITY >=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThan(String value) {
            addCriterion("ACTIVITY <", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThanOrEqualTo(String value) {
            addCriterion("ACTIVITY <=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLike(String value) {
            addCriterion("ACTIVITY like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotLike(String value) {
            addCriterion("ACTIVITY not like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityIn(List<String> values) {
            addCriterion("ACTIVITY in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotIn(List<String> values) {
            addCriterion("ACTIVITY not in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityBetween(String value1, String value2) {
            addCriterion("ACTIVITY between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotBetween(String value1, String value2) {
            addCriterion("ACTIVITY not between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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

        public Criteria andOperationRevisionIsNull() {
            addCriterion("OPERATION_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionIsNotNull() {
            addCriterion("OPERATION_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionEqualTo(String value) {
            addCriterion("OPERATION_REVISION =", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionNotEqualTo(String value) {
            addCriterion("OPERATION_REVISION <>", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionGreaterThan(String value) {
            addCriterion("OPERATION_REVISION >", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_REVISION >=", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionLessThan(String value) {
            addCriterion("OPERATION_REVISION <", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_REVISION <=", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionLike(String value) {
            addCriterion("OPERATION_REVISION like", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionNotLike(String value) {
            addCriterion("OPERATION_REVISION not like", value, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionIn(List<String> values) {
            addCriterion("OPERATION_REVISION in", values, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionNotIn(List<String> values) {
            addCriterion("OPERATION_REVISION not in", values, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionBetween(String value1, String value2) {
            addCriterion("OPERATION_REVISION between", value1, value2, "operationRevision");
            return (Criteria) this;
        }

        public Criteria andOperationRevisionNotBetween(String value1, String value2) {
            addCriterion("OPERATION_REVISION not between", value1, value2, "operationRevision");
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

        public Criteria andItemRevisionIsNull() {
            addCriterion("ITEM_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andItemRevisionIsNotNull() {
            addCriterion("ITEM_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andItemRevisionEqualTo(String value) {
            addCriterion("ITEM_REVISION =", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionNotEqualTo(String value) {
            addCriterion("ITEM_REVISION <>", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionGreaterThan(String value) {
            addCriterion("ITEM_REVISION >", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_REVISION >=", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionLessThan(String value) {
            addCriterion("ITEM_REVISION <", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionLessThanOrEqualTo(String value) {
            addCriterion("ITEM_REVISION <=", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionLike(String value) {
            addCriterion("ITEM_REVISION like", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionNotLike(String value) {
            addCriterion("ITEM_REVISION not like", value, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionIn(List<String> values) {
            addCriterion("ITEM_REVISION in", values, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionNotIn(List<String> values) {
            addCriterion("ITEM_REVISION not in", values, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionBetween(String value1, String value2) {
            addCriterion("ITEM_REVISION between", value1, value2, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemRevisionNotBetween(String value1, String value2) {
            addCriterion("ITEM_REVISION not between", value1, value2, "itemRevision");
            return (Criteria) this;
        }

        public Criteria andItemDeacIsNull() {
            addCriterion("ITEM_DEAC is null");
            return (Criteria) this;
        }

        public Criteria andItemDeacIsNotNull() {
            addCriterion("ITEM_DEAC is not null");
            return (Criteria) this;
        }

        public Criteria andItemDeacEqualTo(String value) {
            addCriterion("ITEM_DEAC =", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacNotEqualTo(String value) {
            addCriterion("ITEM_DEAC <>", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacGreaterThan(String value) {
            addCriterion("ITEM_DEAC >", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_DEAC >=", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacLessThan(String value) {
            addCriterion("ITEM_DEAC <", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacLessThanOrEqualTo(String value) {
            addCriterion("ITEM_DEAC <=", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacLike(String value) {
            addCriterion("ITEM_DEAC like", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacNotLike(String value) {
            addCriterion("ITEM_DEAC not like", value, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacIn(List<String> values) {
            addCriterion("ITEM_DEAC in", values, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacNotIn(List<String> values) {
            addCriterion("ITEM_DEAC not in", values, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacBetween(String value1, String value2) {
            addCriterion("ITEM_DEAC between", value1, value2, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andItemDeacNotBetween(String value1, String value2) {
            addCriterion("ITEM_DEAC not between", value1, value2, "itemDeac");
            return (Criteria) this;
        }

        public Criteria andRouterIsNull() {
            addCriterion("ROUTER is null");
            return (Criteria) this;
        }

        public Criteria andRouterIsNotNull() {
            addCriterion("ROUTER is not null");
            return (Criteria) this;
        }

        public Criteria andRouterEqualTo(String value) {
            addCriterion("ROUTER =", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotEqualTo(String value) {
            addCriterion("ROUTER <>", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterGreaterThan(String value) {
            addCriterion("ROUTER >", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTER >=", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLessThan(String value) {
            addCriterion("ROUTER <", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLessThanOrEqualTo(String value) {
            addCriterion("ROUTER <=", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLike(String value) {
            addCriterion("ROUTER like", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotLike(String value) {
            addCriterion("ROUTER not like", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterIn(List<String> values) {
            addCriterion("ROUTER in", values, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotIn(List<String> values) {
            addCriterion("ROUTER not in", values, "router");
            return (Criteria) this;
        }

        public Criteria andRouterBetween(String value1, String value2) {
            addCriterion("ROUTER between", value1, value2, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotBetween(String value1, String value2) {
            addCriterion("ROUTER not between", value1, value2, "router");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionIsNull() {
            addCriterion("ROUTER_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionIsNotNull() {
            addCriterion("ROUTER_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionEqualTo(String value) {
            addCriterion("ROUTER_REVISION =", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionNotEqualTo(String value) {
            addCriterion("ROUTER_REVISION <>", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionGreaterThan(String value) {
            addCriterion("ROUTER_REVISION >", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTER_REVISION >=", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionLessThan(String value) {
            addCriterion("ROUTER_REVISION <", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionLessThanOrEqualTo(String value) {
            addCriterion("ROUTER_REVISION <=", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionLike(String value) {
            addCriterion("ROUTER_REVISION like", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionNotLike(String value) {
            addCriterion("ROUTER_REVISION not like", value, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionIn(List<String> values) {
            addCriterion("ROUTER_REVISION in", values, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionNotIn(List<String> values) {
            addCriterion("ROUTER_REVISION not in", values, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionBetween(String value1, String value2) {
            addCriterion("ROUTER_REVISION between", value1, value2, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andRouterRevisionNotBetween(String value1, String value2) {
            addCriterion("ROUTER_REVISION not between", value1, value2, "routerRevision");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("STEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("STEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(String value) {
            addCriterion("STEP_ID =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(String value) {
            addCriterion("STEP_ID <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(String value) {
            addCriterion("STEP_ID >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_ID >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(String value) {
            addCriterion("STEP_ID <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(String value) {
            addCriterion("STEP_ID <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLike(String value) {
            addCriterion("STEP_ID like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotLike(String value) {
            addCriterion("STEP_ID not like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<String> values) {
            addCriterion("STEP_ID in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<String> values) {
            addCriterion("STEP_ID not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(String value1, String value2) {
            addCriterion("STEP_ID between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(String value1, String value2) {
            addCriterion("STEP_ID not between", value1, value2, "stepId");
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

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(BigDecimal value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(BigDecimal value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(BigDecimal value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(BigDecimal value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<BigDecimal> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<BigDecimal> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andIsReworkIsNull() {
            addCriterion("IS_REWORK is null");
            return (Criteria) this;
        }

        public Criteria andIsReworkIsNotNull() {
            addCriterion("IS_REWORK is not null");
            return (Criteria) this;
        }

        public Criteria andIsReworkEqualTo(String value) {
            addCriterion("IS_REWORK =", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkNotEqualTo(String value) {
            addCriterion("IS_REWORK <>", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkGreaterThan(String value) {
            addCriterion("IS_REWORK >", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkGreaterThanOrEqualTo(String value) {
            addCriterion("IS_REWORK >=", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkLessThan(String value) {
            addCriterion("IS_REWORK <", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkLessThanOrEqualTo(String value) {
            addCriterion("IS_REWORK <=", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkLike(String value) {
            addCriterion("IS_REWORK like", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkNotLike(String value) {
            addCriterion("IS_REWORK not like", value, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkIn(List<String> values) {
            addCriterion("IS_REWORK in", values, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkNotIn(List<String> values) {
            addCriterion("IS_REWORK not in", values, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkBetween(String value1, String value2) {
            addCriterion("IS_REWORK between", value1, value2, "isRework");
            return (Criteria) this;
        }

        public Criteria andIsReworkNotBetween(String value1, String value2) {
            addCriterion("IS_REWORK not between", value1, value2, "isRework");
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