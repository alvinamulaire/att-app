package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwSfcDoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwSfcDoneExample() {
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

        public Criteria andOperationBoIsNull() {
            addCriterion("OPERATION_BO is null");
            return (Criteria) this;
        }

        public Criteria andOperationBoIsNotNull() {
            addCriterion("OPERATION_BO is not null");
            return (Criteria) this;
        }

        public Criteria andOperationBoEqualTo(String value) {
            addCriterion("OPERATION_BO =", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotEqualTo(String value) {
            addCriterion("OPERATION_BO <>", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoGreaterThan(String value) {
            addCriterion("OPERATION_BO >", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_BO >=", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLessThan(String value) {
            addCriterion("OPERATION_BO <", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_BO <=", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLike(String value) {
            addCriterion("OPERATION_BO like", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotLike(String value) {
            addCriterion("OPERATION_BO not like", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoIn(List<String> values) {
            addCriterion("OPERATION_BO in", values, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotIn(List<String> values) {
            addCriterion("OPERATION_BO not in", values, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoBetween(String value1, String value2) {
            addCriterion("OPERATION_BO between", value1, value2, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotBetween(String value1, String value2) {
            addCriterion("OPERATION_BO not between", value1, value2, "operationBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoIsNull() {
            addCriterion("RESOURCE_BO is null");
            return (Criteria) this;
        }

        public Criteria andResourceBoIsNotNull() {
            addCriterion("RESOURCE_BO is not null");
            return (Criteria) this;
        }

        public Criteria andResourceBoEqualTo(String value) {
            addCriterion("RESOURCE_BO =", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoNotEqualTo(String value) {
            addCriterion("RESOURCE_BO <>", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoGreaterThan(String value) {
            addCriterion("RESOURCE_BO >", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_BO >=", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoLessThan(String value) {
            addCriterion("RESOURCE_BO <", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_BO <=", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoLike(String value) {
            addCriterion("RESOURCE_BO like", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoNotLike(String value) {
            addCriterion("RESOURCE_BO not like", value, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoIn(List<String> values) {
            addCriterion("RESOURCE_BO in", values, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoNotIn(List<String> values) {
            addCriterion("RESOURCE_BO not in", values, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoBetween(String value1, String value2) {
            addCriterion("RESOURCE_BO between", value1, value2, "resourceBo");
            return (Criteria) this;
        }

        public Criteria andResourceBoNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_BO not between", value1, value2, "resourceBo");
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

        public Criteria andQtyInWorkIsNull() {
            addCriterion("QTY_IN_WORK is null");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkIsNotNull() {
            addCriterion("QTY_IN_WORK is not null");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_WORK =", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkNotEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_WORK <>", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkGreaterThan(BigDecimal value) {
            addCriterion("QTY_IN_WORK >", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_WORK >=", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkLessThan(BigDecimal value) {
            addCriterion("QTY_IN_WORK <", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_WORK <=", value, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_WORK in", values, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkNotIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_WORK not in", values, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_WORK between", value1, value2, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andQtyInWorkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_WORK not between", value1, value2, "qtyInWork");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNull() {
            addCriterion("BATCH_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("BATCH_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(String value) {
            addCriterion("BATCH_NUMBER =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("BATCH_NUMBER <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("BATCH_NUMBER >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NUMBER >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(String value) {
            addCriterion("BATCH_NUMBER <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NUMBER <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLike(String value) {
            addCriterion("BATCH_NUMBER like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotLike(String value) {
            addCriterion("BATCH_NUMBER not like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<String> values) {
            addCriterion("BATCH_NUMBER in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("BATCH_NUMBER not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("BATCH_NUMBER between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("BATCH_NUMBER not between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andProductRankIsNull() {
            addCriterion("PRODUCT_RANK is null");
            return (Criteria) this;
        }

        public Criteria andProductRankIsNotNull() {
            addCriterion("PRODUCT_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andProductRankEqualTo(String value) {
            addCriterion("PRODUCT_RANK =", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankNotEqualTo(String value) {
            addCriterion("PRODUCT_RANK <>", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankGreaterThan(String value) {
            addCriterion("PRODUCT_RANK >", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_RANK >=", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankLessThan(String value) {
            addCriterion("PRODUCT_RANK <", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_RANK <=", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankLike(String value) {
            addCriterion("PRODUCT_RANK like", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankNotLike(String value) {
            addCriterion("PRODUCT_RANK not like", value, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankIn(List<String> values) {
            addCriterion("PRODUCT_RANK in", values, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankNotIn(List<String> values) {
            addCriterion("PRODUCT_RANK not in", values, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankBetween(String value1, String value2) {
            addCriterion("PRODUCT_RANK between", value1, value2, "productRank");
            return (Criteria) this;
        }

        public Criteria andProductRankNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_RANK not between", value1, value2, "productRank");
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