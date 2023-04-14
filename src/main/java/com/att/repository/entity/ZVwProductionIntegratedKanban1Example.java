package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwProductionIntegratedKanban1Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwProductionIntegratedKanban1Example() {
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

        public Criteria andHoldQtyIsNull() {
            addCriterion("HOLD_QTY is null");
            return (Criteria) this;
        }

        public Criteria andHoldQtyIsNotNull() {
            addCriterion("HOLD_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andHoldQtyEqualTo(BigDecimal value) {
            addCriterion("HOLD_QTY =", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyNotEqualTo(BigDecimal value) {
            addCriterion("HOLD_QTY <>", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyGreaterThan(BigDecimal value) {
            addCriterion("HOLD_QTY >", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLD_QTY >=", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyLessThan(BigDecimal value) {
            addCriterion("HOLD_QTY <", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLD_QTY <=", value, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyIn(List<BigDecimal> values) {
            addCriterion("HOLD_QTY in", values, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyNotIn(List<BigDecimal> values) {
            addCriterion("HOLD_QTY not in", values, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLD_QTY between", value1, value2, "holdQty");
            return (Criteria) this;
        }

        public Criteria andHoldQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLD_QTY not between", value1, value2, "holdQty");
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