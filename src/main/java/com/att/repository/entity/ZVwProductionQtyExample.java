package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwProductionQtyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwProductionQtyExample() {
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

        public Criteria andErpOperationIsNull() {
            addCriterion("ERP_OPERATION is null");
            return (Criteria) this;
        }

        public Criteria andErpOperationIsNotNull() {
            addCriterion("ERP_OPERATION is not null");
            return (Criteria) this;
        }

        public Criteria andErpOperationEqualTo(String value) {
            addCriterion("ERP_OPERATION =", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationNotEqualTo(String value) {
            addCriterion("ERP_OPERATION <>", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationGreaterThan(String value) {
            addCriterion("ERP_OPERATION >", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_OPERATION >=", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationLessThan(String value) {
            addCriterion("ERP_OPERATION <", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationLessThanOrEqualTo(String value) {
            addCriterion("ERP_OPERATION <=", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationLike(String value) {
            addCriterion("ERP_OPERATION like", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationNotLike(String value) {
            addCriterion("ERP_OPERATION not like", value, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationIn(List<String> values) {
            addCriterion("ERP_OPERATION in", values, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationNotIn(List<String> values) {
            addCriterion("ERP_OPERATION not in", values, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationBetween(String value1, String value2) {
            addCriterion("ERP_OPERATION between", value1, value2, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andErpOperationNotBetween(String value1, String value2) {
            addCriterion("ERP_OPERATION not between", value1, value2, "erpOperation");
            return (Criteria) this;
        }

        public Criteria andQtyStartedIsNull() {
            addCriterion("QTY_STARTED is null");
            return (Criteria) this;
        }

        public Criteria andQtyStartedIsNotNull() {
            addCriterion("QTY_STARTED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyStartedEqualTo(BigDecimal value) {
            addCriterion("QTY_STARTED =", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedNotEqualTo(BigDecimal value) {
            addCriterion("QTY_STARTED <>", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedGreaterThan(BigDecimal value) {
            addCriterion("QTY_STARTED >", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_STARTED >=", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedLessThan(BigDecimal value) {
            addCriterion("QTY_STARTED <", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_STARTED <=", value, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedIn(List<BigDecimal> values) {
            addCriterion("QTY_STARTED in", values, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedNotIn(List<BigDecimal> values) {
            addCriterion("QTY_STARTED not in", values, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_STARTED between", value1, value2, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyStartedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_STARTED not between", value1, value2, "qtyStarted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedIsNull() {
            addCriterion("QTY_COMPLETED is null");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedIsNotNull() {
            addCriterion("QTY_COMPLETED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedEqualTo(BigDecimal value) {
            addCriterion("QTY_COMPLETED =", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedNotEqualTo(BigDecimal value) {
            addCriterion("QTY_COMPLETED <>", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedGreaterThan(BigDecimal value) {
            addCriterion("QTY_COMPLETED >", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_COMPLETED >=", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedLessThan(BigDecimal value) {
            addCriterion("QTY_COMPLETED <", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_COMPLETED <=", value, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedIn(List<BigDecimal> values) {
            addCriterion("QTY_COMPLETED in", values, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedNotIn(List<BigDecimal> values) {
            addCriterion("QTY_COMPLETED not in", values, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_COMPLETED between", value1, value2, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyCompletedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_COMPLETED not between", value1, value2, "qtyCompleted");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIsNull() {
            addCriterion("QTY_SCRAPPED is null");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIsNotNull() {
            addCriterion("QTY_SCRAPPED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED =", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <>", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedGreaterThan(BigDecimal value) {
            addCriterion("QTY_SCRAPPED >", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED >=", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedLessThan(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_SCRAPPED <=", value, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedIn(List<BigDecimal> values) {
            addCriterion("QTY_SCRAPPED in", values, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotIn(List<BigDecimal> values) {
            addCriterion("QTY_SCRAPPED not in", values, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_SCRAPPED between", value1, value2, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyScrappedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_SCRAPPED not between", value1, value2, "qtyScrapped");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIsNull() {
            addCriterion("QTY_DONE is null");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIsNotNull() {
            addCriterion("QTY_DONE is not null");
            return (Criteria) this;
        }

        public Criteria andQtyDoneEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE =", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE <>", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneGreaterThan(BigDecimal value) {
            addCriterion("QTY_DONE >", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE >=", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneLessThan(BigDecimal value) {
            addCriterion("QTY_DONE <", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_DONE <=", value, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneIn(List<BigDecimal> values) {
            addCriterion("QTY_DONE in", values, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotIn(List<BigDecimal> values) {
            addCriterion("QTY_DONE not in", values, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_DONE between", value1, value2, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andQtyDoneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_DONE not between", value1, value2, "qtyDone");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeIsNull() {
            addCriterion("SHOP_ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeIsNotNull() {
            addCriterion("SHOP_ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeEqualTo(String value) {
            addCriterion("SHOP_ORDER_TYPE =", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeNotEqualTo(String value) {
            addCriterion("SHOP_ORDER_TYPE <>", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeGreaterThan(String value) {
            addCriterion("SHOP_ORDER_TYPE >", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_TYPE >=", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeLessThan(String value) {
            addCriterion("SHOP_ORDER_TYPE <", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ORDER_TYPE <=", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeLike(String value) {
            addCriterion("SHOP_ORDER_TYPE like", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeNotLike(String value) {
            addCriterion("SHOP_ORDER_TYPE not like", value, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeIn(List<String> values) {
            addCriterion("SHOP_ORDER_TYPE in", values, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeNotIn(List<String> values) {
            addCriterion("SHOP_ORDER_TYPE not in", values, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_TYPE between", value1, value2, "shopOrderType");
            return (Criteria) this;
        }

        public Criteria andShopOrderTypeNotBetween(String value1, String value2) {
            addCriterion("SHOP_ORDER_TYPE not between", value1, value2, "shopOrderType");
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

        public Criteria andRouterDescIsNull() {
            addCriterion("ROUTER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andRouterDescIsNotNull() {
            addCriterion("ROUTER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andRouterDescEqualTo(String value) {
            addCriterion("ROUTER_DESC =", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescNotEqualTo(String value) {
            addCriterion("ROUTER_DESC <>", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescGreaterThan(String value) {
            addCriterion("ROUTER_DESC >", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTER_DESC >=", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescLessThan(String value) {
            addCriterion("ROUTER_DESC <", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescLessThanOrEqualTo(String value) {
            addCriterion("ROUTER_DESC <=", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescLike(String value) {
            addCriterion("ROUTER_DESC like", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescNotLike(String value) {
            addCriterion("ROUTER_DESC not like", value, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescIn(List<String> values) {
            addCriterion("ROUTER_DESC in", values, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescNotIn(List<String> values) {
            addCriterion("ROUTER_DESC not in", values, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescBetween(String value1, String value2) {
            addCriterion("ROUTER_DESC between", value1, value2, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andRouterDescNotBetween(String value1, String value2) {
            addCriterion("ROUTER_DESC not between", value1, value2, "routerDesc");
            return (Criteria) this;
        }

        public Criteria andLaborHIsNull() {
            addCriterion("LABOR_H is null");
            return (Criteria) this;
        }

        public Criteria andLaborHIsNotNull() {
            addCriterion("LABOR_H is not null");
            return (Criteria) this;
        }

        public Criteria andLaborHEqualTo(BigDecimal value) {
            addCriterion("LABOR_H =", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHNotEqualTo(BigDecimal value) {
            addCriterion("LABOR_H <>", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHGreaterThan(BigDecimal value) {
            addCriterion("LABOR_H >", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LABOR_H >=", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHLessThan(BigDecimal value) {
            addCriterion("LABOR_H <", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LABOR_H <=", value, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHIn(List<BigDecimal> values) {
            addCriterion("LABOR_H in", values, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHNotIn(List<BigDecimal> values) {
            addCriterion("LABOR_H not in", values, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LABOR_H between", value1, value2, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborHNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LABOR_H not between", value1, value2, "laborH");
            return (Criteria) this;
        }

        public Criteria andLaborMIsNull() {
            addCriterion("LABOR_M is null");
            return (Criteria) this;
        }

        public Criteria andLaborMIsNotNull() {
            addCriterion("LABOR_M is not null");
            return (Criteria) this;
        }

        public Criteria andLaborMEqualTo(BigDecimal value) {
            addCriterion("LABOR_M =", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMNotEqualTo(BigDecimal value) {
            addCriterion("LABOR_M <>", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMGreaterThan(BigDecimal value) {
            addCriterion("LABOR_M >", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LABOR_M >=", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMLessThan(BigDecimal value) {
            addCriterion("LABOR_M <", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LABOR_M <=", value, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMIn(List<BigDecimal> values) {
            addCriterion("LABOR_M in", values, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMNotIn(List<BigDecimal> values) {
            addCriterion("LABOR_M not in", values, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LABOR_M between", value1, value2, "laborM");
            return (Criteria) this;
        }

        public Criteria andLaborMNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LABOR_M not between", value1, value2, "laborM");
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