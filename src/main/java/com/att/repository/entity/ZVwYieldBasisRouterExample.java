package com.att.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class ZVwYieldBasisRouterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwYieldBasisRouterExample() {
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

        public Criteria andRouterTypeIsNull() {
            addCriterion("ROUTER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRouterTypeIsNotNull() {
            addCriterion("ROUTER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRouterTypeEqualTo(String value) {
            addCriterion("ROUTER_TYPE =", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeNotEqualTo(String value) {
            addCriterion("ROUTER_TYPE <>", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeGreaterThan(String value) {
            addCriterion("ROUTER_TYPE >", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTER_TYPE >=", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeLessThan(String value) {
            addCriterion("ROUTER_TYPE <", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeLessThanOrEqualTo(String value) {
            addCriterion("ROUTER_TYPE <=", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeLike(String value) {
            addCriterion("ROUTER_TYPE like", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeNotLike(String value) {
            addCriterion("ROUTER_TYPE not like", value, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeIn(List<String> values) {
            addCriterion("ROUTER_TYPE in", values, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeNotIn(List<String> values) {
            addCriterion("ROUTER_TYPE not in", values, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeBetween(String value1, String value2) {
            addCriterion("ROUTER_TYPE between", value1, value2, "routerType");
            return (Criteria) this;
        }

        public Criteria andRouterTypeNotBetween(String value1, String value2) {
            addCriterion("ROUTER_TYPE not between", value1, value2, "routerType");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andNowVerIsNull() {
            addCriterion("NOW_VER is null");
            return (Criteria) this;
        }

        public Criteria andNowVerIsNotNull() {
            addCriterion("NOW_VER is not null");
            return (Criteria) this;
        }

        public Criteria andNowVerEqualTo(String value) {
            addCriterion("NOW_VER =", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerNotEqualTo(String value) {
            addCriterion("NOW_VER <>", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerGreaterThan(String value) {
            addCriterion("NOW_VER >", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerGreaterThanOrEqualTo(String value) {
            addCriterion("NOW_VER >=", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerLessThan(String value) {
            addCriterion("NOW_VER <", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerLessThanOrEqualTo(String value) {
            addCriterion("NOW_VER <=", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerLike(String value) {
            addCriterion("NOW_VER like", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerNotLike(String value) {
            addCriterion("NOW_VER not like", value, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerIn(List<String> values) {
            addCriterion("NOW_VER in", values, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerNotIn(List<String> values) {
            addCriterion("NOW_VER not in", values, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerBetween(String value1, String value2) {
            addCriterion("NOW_VER between", value1, value2, "nowVer");
            return (Criteria) this;
        }

        public Criteria andNowVerNotBetween(String value1, String value2) {
            addCriterion("NOW_VER not between", value1, value2, "nowVer");
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