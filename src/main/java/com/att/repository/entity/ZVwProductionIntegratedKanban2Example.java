package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwProductionIntegratedKanban2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwProductionIntegratedKanban2Example() {
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

        public Criteria andActualProductionKpiIsNull() {
            addCriterion("ACTUAL_PRODUCTION_KPI is null");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiIsNotNull() {
            addCriterion("ACTUAL_PRODUCTION_KPI is not null");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI =", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI <>", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI >", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI >=", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiLessThan(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI <", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_PRODUCTION_KPI <=", value, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PRODUCTION_KPI in", values, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_PRODUCTION_KPI not in", values, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PRODUCTION_KPI between", value1, value2, "actualProductionKpi");
            return (Criteria) this;
        }

        public Criteria andActualProductionKpiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_PRODUCTION_KPI not between", value1, value2, "actualProductionKpi");
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

        public Criteria andReworkQtyIsNull() {
            addCriterion("REWORK_QTY is null");
            return (Criteria) this;
        }

        public Criteria andReworkQtyIsNotNull() {
            addCriterion("REWORK_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andReworkQtyEqualTo(BigDecimal value) {
            addCriterion("REWORK_QTY =", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyNotEqualTo(BigDecimal value) {
            addCriterion("REWORK_QTY <>", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyGreaterThan(BigDecimal value) {
            addCriterion("REWORK_QTY >", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REWORK_QTY >=", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyLessThan(BigDecimal value) {
            addCriterion("REWORK_QTY <", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REWORK_QTY <=", value, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyIn(List<BigDecimal> values) {
            addCriterion("REWORK_QTY in", values, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyNotIn(List<BigDecimal> values) {
            addCriterion("REWORK_QTY not in", values, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REWORK_QTY between", value1, value2, "reworkQty");
            return (Criteria) this;
        }

        public Criteria andReworkQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REWORK_QTY not between", value1, value2, "reworkQty");
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