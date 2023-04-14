package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwProductionIntegratedKanban3Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwProductionIntegratedKanban3Example() {
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

        public Criteria andOnQtyIsNull() {
            addCriterion("ON_QTY is null");
            return (Criteria) this;
        }

        public Criteria andOnQtyIsNotNull() {
            addCriterion("ON_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andOnQtyEqualTo(BigDecimal value) {
            addCriterion("ON_QTY =", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyNotEqualTo(BigDecimal value) {
            addCriterion("ON_QTY <>", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyGreaterThan(BigDecimal value) {
            addCriterion("ON_QTY >", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ON_QTY >=", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyLessThan(BigDecimal value) {
            addCriterion("ON_QTY <", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ON_QTY <=", value, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyIn(List<BigDecimal> values) {
            addCriterion("ON_QTY in", values, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyNotIn(List<BigDecimal> values) {
            addCriterion("ON_QTY not in", values, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ON_QTY between", value1, value2, "onQty");
            return (Criteria) this;
        }

        public Criteria andOnQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ON_QTY not between", value1, value2, "onQty");
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