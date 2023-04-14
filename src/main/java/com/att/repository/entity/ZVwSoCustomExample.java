package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwSoCustomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwSoCustomExample() {
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

        public Criteria andPlannedBomBoIsNull() {
            addCriterion("PLANNED_BOM_BO is null");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoIsNotNull() {
            addCriterion("PLANNED_BOM_BO is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoEqualTo(String value) {
            addCriterion("PLANNED_BOM_BO =", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoNotEqualTo(String value) {
            addCriterion("PLANNED_BOM_BO <>", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoGreaterThan(String value) {
            addCriterion("PLANNED_BOM_BO >", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_BOM_BO >=", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoLessThan(String value) {
            addCriterion("PLANNED_BOM_BO <", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_BOM_BO <=", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoLike(String value) {
            addCriterion("PLANNED_BOM_BO like", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoNotLike(String value) {
            addCriterion("PLANNED_BOM_BO not like", value, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoIn(List<String> values) {
            addCriterion("PLANNED_BOM_BO in", values, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoNotIn(List<String> values) {
            addCriterion("PLANNED_BOM_BO not in", values, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoBetween(String value1, String value2) {
            addCriterion("PLANNED_BOM_BO between", value1, value2, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomBoNotBetween(String value1, String value2) {
            addCriterion("PLANNED_BOM_BO not between", value1, value2, "plannedBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionIsNull() {
            addCriterion("PLANNED_BOM_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionIsNotNull() {
            addCriterion("PLANNED_BOM_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionEqualTo(String value) {
            addCriterion("PLANNED_BOM_REVISION =", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionNotEqualTo(String value) {
            addCriterion("PLANNED_BOM_REVISION <>", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionGreaterThan(String value) {
            addCriterion("PLANNED_BOM_REVISION >", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_BOM_REVISION >=", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionLessThan(String value) {
            addCriterion("PLANNED_BOM_REVISION <", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_BOM_REVISION <=", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionLike(String value) {
            addCriterion("PLANNED_BOM_REVISION like", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionNotLike(String value) {
            addCriterion("PLANNED_BOM_REVISION not like", value, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionIn(List<String> values) {
            addCriterion("PLANNED_BOM_REVISION in", values, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionNotIn(List<String> values) {
            addCriterion("PLANNED_BOM_REVISION not in", values, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionBetween(String value1, String value2) {
            addCriterion("PLANNED_BOM_REVISION between", value1, value2, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedBomRevisionNotBetween(String value1, String value2) {
            addCriterion("PLANNED_BOM_REVISION not between", value1, value2, "plannedBomRevision");
            return (Criteria) this;
        }

        public Criteria andBomBoIsNull() {
            addCriterion("BOM_BO is null");
            return (Criteria) this;
        }

        public Criteria andBomBoIsNotNull() {
            addCriterion("BOM_BO is not null");
            return (Criteria) this;
        }

        public Criteria andBomBoEqualTo(String value) {
            addCriterion("BOM_BO =", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoNotEqualTo(String value) {
            addCriterion("BOM_BO <>", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoGreaterThan(String value) {
            addCriterion("BOM_BO >", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoGreaterThanOrEqualTo(String value) {
            addCriterion("BOM_BO >=", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoLessThan(String value) {
            addCriterion("BOM_BO <", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoLessThanOrEqualTo(String value) {
            addCriterion("BOM_BO <=", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoLike(String value) {
            addCriterion("BOM_BO like", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoNotLike(String value) {
            addCriterion("BOM_BO not like", value, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoIn(List<String> values) {
            addCriterion("BOM_BO in", values, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoNotIn(List<String> values) {
            addCriterion("BOM_BO not in", values, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoBetween(String value1, String value2) {
            addCriterion("BOM_BO between", value1, value2, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomBoNotBetween(String value1, String value2) {
            addCriterion("BOM_BO not between", value1, value2, "bomBo");
            return (Criteria) this;
        }

        public Criteria andBomRevisionIsNull() {
            addCriterion("BOM_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andBomRevisionIsNotNull() {
            addCriterion("BOM_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andBomRevisionEqualTo(String value) {
            addCriterion("BOM_REVISION =", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionNotEqualTo(String value) {
            addCriterion("BOM_REVISION <>", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionGreaterThan(String value) {
            addCriterion("BOM_REVISION >", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("BOM_REVISION >=", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionLessThan(String value) {
            addCriterion("BOM_REVISION <", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionLessThanOrEqualTo(String value) {
            addCriterion("BOM_REVISION <=", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionLike(String value) {
            addCriterion("BOM_REVISION like", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionNotLike(String value) {
            addCriterion("BOM_REVISION not like", value, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionIn(List<String> values) {
            addCriterion("BOM_REVISION in", values, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionNotIn(List<String> values) {
            addCriterion("BOM_REVISION not in", values, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionBetween(String value1, String value2) {
            addCriterion("BOM_REVISION between", value1, value2, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andBomRevisionNotBetween(String value1, String value2) {
            addCriterion("BOM_REVISION not between", value1, value2, "bomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoIsNull() {
            addCriterion("PLANNED_ROUTER_BO is null");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoIsNotNull() {
            addCriterion("PLANNED_ROUTER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_BO =", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoNotEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_BO <>", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoGreaterThan(String value) {
            addCriterion("PLANNED_ROUTER_BO >", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_BO >=", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoLessThan(String value) {
            addCriterion("PLANNED_ROUTER_BO <", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_BO <=", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoLike(String value) {
            addCriterion("PLANNED_ROUTER_BO like", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoNotLike(String value) {
            addCriterion("PLANNED_ROUTER_BO not like", value, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoIn(List<String> values) {
            addCriterion("PLANNED_ROUTER_BO in", values, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoNotIn(List<String> values) {
            addCriterion("PLANNED_ROUTER_BO not in", values, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoBetween(String value1, String value2) {
            addCriterion("PLANNED_ROUTER_BO between", value1, value2, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterBoNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ROUTER_BO not between", value1, value2, "plannedRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionIsNull() {
            addCriterion("PLANNED_ROUTER_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionIsNotNull() {
            addCriterion("PLANNED_ROUTER_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_REVISION =", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionNotEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_REVISION <>", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionGreaterThan(String value) {
            addCriterion("PLANNED_ROUTER_REVISION >", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_REVISION >=", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionLessThan(String value) {
            addCriterion("PLANNED_ROUTER_REVISION <", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ROUTER_REVISION <=", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionLike(String value) {
            addCriterion("PLANNED_ROUTER_REVISION like", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionNotLike(String value) {
            addCriterion("PLANNED_ROUTER_REVISION not like", value, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionIn(List<String> values) {
            addCriterion("PLANNED_ROUTER_REVISION in", values, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionNotIn(List<String> values) {
            addCriterion("PLANNED_ROUTER_REVISION not in", values, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionBetween(String value1, String value2) {
            addCriterion("PLANNED_ROUTER_REVISION between", value1, value2, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedRouterRevisionNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ROUTER_REVISION not between", value1, value2, "plannedRouterRevision");
            return (Criteria) this;
        }

        public Criteria andRouterBoIsNull() {
            addCriterion("ROUTER_BO is null");
            return (Criteria) this;
        }

        public Criteria andRouterBoIsNotNull() {
            addCriterion("ROUTER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andRouterBoEqualTo(String value) {
            addCriterion("ROUTER_BO =", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoNotEqualTo(String value) {
            addCriterion("ROUTER_BO <>", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoGreaterThan(String value) {
            addCriterion("ROUTER_BO >", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTER_BO >=", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoLessThan(String value) {
            addCriterion("ROUTER_BO <", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoLessThanOrEqualTo(String value) {
            addCriterion("ROUTER_BO <=", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoLike(String value) {
            addCriterion("ROUTER_BO like", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoNotLike(String value) {
            addCriterion("ROUTER_BO not like", value, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoIn(List<String> values) {
            addCriterion("ROUTER_BO in", values, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoNotIn(List<String> values) {
            addCriterion("ROUTER_BO not in", values, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoBetween(String value1, String value2) {
            addCriterion("ROUTER_BO between", value1, value2, "routerBo");
            return (Criteria) this;
        }

        public Criteria andRouterBoNotBetween(String value1, String value2) {
            addCriterion("ROUTER_BO not between", value1, value2, "routerBo");
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

        public Criteria andQtyToBuildIsNull() {
            addCriterion("QTY_TO_BUILD is null");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildIsNotNull() {
            addCriterion("QTY_TO_BUILD is not null");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildEqualTo(BigDecimal value) {
            addCriterion("QTY_TO_BUILD =", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildNotEqualTo(BigDecimal value) {
            addCriterion("QTY_TO_BUILD <>", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildGreaterThan(BigDecimal value) {
            addCriterion("QTY_TO_BUILD >", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_TO_BUILD >=", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildLessThan(BigDecimal value) {
            addCriterion("QTY_TO_BUILD <", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_TO_BUILD <=", value, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildIn(List<BigDecimal> values) {
            addCriterion("QTY_TO_BUILD in", values, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildNotIn(List<BigDecimal> values) {
            addCriterion("QTY_TO_BUILD not in", values, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_TO_BUILD between", value1, value2, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andQtyToBuildNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_TO_BUILD not between", value1, value2, "qtyToBuild");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyIsNull() {
            addCriterion("RELEASE_QTY is null");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyIsNotNull() {
            addCriterion("RELEASE_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyEqualTo(BigDecimal value) {
            addCriterion("RELEASE_QTY =", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyNotEqualTo(BigDecimal value) {
            addCriterion("RELEASE_QTY <>", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyGreaterThan(BigDecimal value) {
            addCriterion("RELEASE_QTY >", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RELEASE_QTY >=", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyLessThan(BigDecimal value) {
            addCriterion("RELEASE_QTY <", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RELEASE_QTY <=", value, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyIn(List<BigDecimal> values) {
            addCriterion("RELEASE_QTY in", values, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyNotIn(List<BigDecimal> values) {
            addCriterion("RELEASE_QTY not in", values, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELEASE_QTY between", value1, value2, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andReleaseQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELEASE_QTY not between", value1, value2, "releaseQty");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateIsNull() {
            addCriterion("PLANNED_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateIsNotNull() {
            addCriterion("PLANNED_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateEqualTo(Date value) {
            addCriterion("PLANNED_START_DATE =", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotEqualTo(Date value) {
            addCriterion("PLANNED_START_DATE <>", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateGreaterThan(Date value) {
            addCriterion("PLANNED_START_DATE >", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PLANNED_START_DATE >=", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateLessThan(Date value) {
            addCriterion("PLANNED_START_DATE <", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateLessThanOrEqualTo(Date value) {
            addCriterion("PLANNED_START_DATE <=", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateIn(List<Date> values) {
            addCriterion("PLANNED_START_DATE in", values, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotIn(List<Date> values) {
            addCriterion("PLANNED_START_DATE not in", values, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateBetween(Date value1, Date value2) {
            addCriterion("PLANNED_START_DATE between", value1, value2, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotBetween(Date value1, Date value2) {
            addCriterion("PLANNED_START_DATE not between", value1, value2, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateIsNull() {
            addCriterion("PLANNED_COMP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateIsNotNull() {
            addCriterion("PLANNED_COMP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateEqualTo(Date value) {
            addCriterion("PLANNED_COMP_DATE =", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateNotEqualTo(Date value) {
            addCriterion("PLANNED_COMP_DATE <>", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateGreaterThan(Date value) {
            addCriterion("PLANNED_COMP_DATE >", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PLANNED_COMP_DATE >=", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateLessThan(Date value) {
            addCriterion("PLANNED_COMP_DATE <", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateLessThanOrEqualTo(Date value) {
            addCriterion("PLANNED_COMP_DATE <=", value, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateIn(List<Date> values) {
            addCriterion("PLANNED_COMP_DATE in", values, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateNotIn(List<Date> values) {
            addCriterion("PLANNED_COMP_DATE not in", values, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateBetween(Date value1, Date value2) {
            addCriterion("PLANNED_COMP_DATE between", value1, value2, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompDateNotBetween(Date value1, Date value2) {
            addCriterion("PLANNED_COMP_DATE not between", value1, value2, "plannedCompDate");
            return (Criteria) this;
        }

        public Criteria andPlannedItemIsNull() {
            addCriterion("PLANNED_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemIsNotNull() {
            addCriterion("PLANNED_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemEqualTo(String value) {
            addCriterion("PLANNED_ITEM =", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM <>", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemGreaterThan(String value) {
            addCriterion("PLANNED_ITEM >", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM >=", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemLessThan(String value) {
            addCriterion("PLANNED_ITEM <", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM <=", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemLike(String value) {
            addCriterion("PLANNED_ITEM like", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemNotLike(String value) {
            addCriterion("PLANNED_ITEM not like", value, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemIn(List<String> values) {
            addCriterion("PLANNED_ITEM in", values, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM not in", values, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM between", value1, value2, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andPlannedItemNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM not between", value1, value2, "plannedItem");
            return (Criteria) this;
        }

        public Criteria andLotSizeIsNull() {
            addCriterion("LOT_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andLotSizeIsNotNull() {
            addCriterion("LOT_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andLotSizeEqualTo(BigDecimal value) {
            addCriterion("LOT_SIZE =", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeNotEqualTo(BigDecimal value) {
            addCriterion("LOT_SIZE <>", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeGreaterThan(BigDecimal value) {
            addCriterion("LOT_SIZE >", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOT_SIZE >=", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeLessThan(BigDecimal value) {
            addCriterion("LOT_SIZE <", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOT_SIZE <=", value, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeIn(List<BigDecimal> values) {
            addCriterion("LOT_SIZE in", values, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeNotIn(List<BigDecimal> values) {
            addCriterion("LOT_SIZE not in", values, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOT_SIZE between", value1, value2, "lotSize");
            return (Criteria) this;
        }

        public Criteria andLotSizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOT_SIZE not between", value1, value2, "lotSize");
            return (Criteria) this;
        }

        public Criteria andItemVerIsNull() {
            addCriterion("ITEM_VER is null");
            return (Criteria) this;
        }

        public Criteria andItemVerIsNotNull() {
            addCriterion("ITEM_VER is not null");
            return (Criteria) this;
        }

        public Criteria andItemVerEqualTo(String value) {
            addCriterion("ITEM_VER =", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerNotEqualTo(String value) {
            addCriterion("ITEM_VER <>", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerGreaterThan(String value) {
            addCriterion("ITEM_VER >", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_VER >=", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerLessThan(String value) {
            addCriterion("ITEM_VER <", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerLessThanOrEqualTo(String value) {
            addCriterion("ITEM_VER <=", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerLike(String value) {
            addCriterion("ITEM_VER like", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerNotLike(String value) {
            addCriterion("ITEM_VER not like", value, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerIn(List<String> values) {
            addCriterion("ITEM_VER in", values, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerNotIn(List<String> values) {
            addCriterion("ITEM_VER not in", values, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerBetween(String value1, String value2) {
            addCriterion("ITEM_VER between", value1, value2, "itemVer");
            return (Criteria) this;
        }

        public Criteria andItemVerNotBetween(String value1, String value2) {
            addCriterion("ITEM_VER not between", value1, value2, "itemVer");
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

        public Criteria andPlannedItemBomBoIsNull() {
            addCriterion("PLANNED_ITEM_BOM_BO is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoIsNotNull() {
            addCriterion("PLANNED_ITEM_BOM_BO is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO =", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO <>", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO >", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO >=", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoLessThan(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO <", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO <=", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoLike(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO like", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoNotLike(String value) {
            addCriterion("PLANNED_ITEM_BOM_BO not like", value, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM_BO in", values, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM_BO not in", values, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM_BO between", value1, value2, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBoNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM_BO not between", value1, value2, "plannedItemBomBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomIsNull() {
            addCriterion("PLANNED_ITEM_BOM is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomIsNotNull() {
            addCriterion("PLANNED_ITEM_BOM is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM =", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM <>", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_BOM >", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM >=", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomLessThan(String value) {
            addCriterion("PLANNED_ITEM_BOM <", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM <=", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomLike(String value) {
            addCriterion("PLANNED_ITEM_BOM like", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomNotLike(String value) {
            addCriterion("PLANNED_ITEM_BOM not like", value, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM in", values, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM not in", values, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM between", value1, value2, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM not between", value1, value2, "plannedItemBom");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionIsNull() {
            addCriterion("PLANNED_ITEM_BOM_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionIsNotNull() {
            addCriterion("PLANNED_ITEM_BOM_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION =", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION <>", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION >", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION >=", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionLessThan(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION <", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION <=", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionLike(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION like", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionNotLike(String value) {
            addCriterion("PLANNED_ITEM_BOM_REVISION not like", value, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM_REVISION in", values, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_BOM_REVISION not in", values, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM_REVISION between", value1, value2, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemBomRevisionNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_BOM_REVISION not between", value1, value2, "plannedItemBomRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoIsNull() {
            addCriterion("PLANNED_ITEM_ROUTER_BO is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoIsNotNull() {
            addCriterion("PLANNED_ITEM_ROUTER_BO is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO =", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO <>", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO >", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO >=", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoLessThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO <", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO <=", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO like", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoNotLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_BO not like", value, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER_BO in", values, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER_BO not in", values, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER_BO between", value1, value2, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBoNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER_BO not between", value1, value2, "plannedItemRouterBo");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterIsNull() {
            addCriterion("PLANNED_ITEM_ROUTER is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterIsNotNull() {
            addCriterion("PLANNED_ITEM_ROUTER is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER =", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER <>", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER >", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER >=", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterLessThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER <", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER <=", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER like", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterNotLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER not like", value, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER in", values, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER not in", values, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER between", value1, value2, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER not between", value1, value2, "plannedItemRouter");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionIsNull() {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionIsNotNull() {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION =", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionNotEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION <>", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionGreaterThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION >", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION >=", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionLessThan(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION <", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionLessThanOrEqualTo(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION <=", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION like", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionNotLike(String value) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION not like", value, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION in", values, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionNotIn(List<String> values) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION not in", values, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION between", value1, value2, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andPlannedItemRouterRevisionNotBetween(String value1, String value2) {
            addCriterion("PLANNED_ITEM_ROUTER_REVISION not between", value1, value2, "plannedItemRouterRevision");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionIsNull() {
            addCriterion("STATUS_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionIsNotNull() {
            addCriterion("STATUS_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionEqualTo(String value) {
            addCriterion("STATUS_DESCRIPTION =", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionNotEqualTo(String value) {
            addCriterion("STATUS_DESCRIPTION <>", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionGreaterThan(String value) {
            addCriterion("STATUS_DESCRIPTION >", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_DESCRIPTION >=", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionLessThan(String value) {
            addCriterion("STATUS_DESCRIPTION <", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionLessThanOrEqualTo(String value) {
            addCriterion("STATUS_DESCRIPTION <=", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionLike(String value) {
            addCriterion("STATUS_DESCRIPTION like", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionNotLike(String value) {
            addCriterion("STATUS_DESCRIPTION not like", value, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionIn(List<String> values) {
            addCriterion("STATUS_DESCRIPTION in", values, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionNotIn(List<String> values) {
            addCriterion("STATUS_DESCRIPTION not in", values, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionBetween(String value1, String value2) {
            addCriterion("STATUS_DESCRIPTION between", value1, value2, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andStatusDescriptionNotBetween(String value1, String value2) {
            addCriterion("STATUS_DESCRIPTION not between", value1, value2, "statusDescription");
            return (Criteria) this;
        }

        public Criteria andAuartIsNull() {
            addCriterion("AUART is null");
            return (Criteria) this;
        }

        public Criteria andAuartIsNotNull() {
            addCriterion("AUART is not null");
            return (Criteria) this;
        }

        public Criteria andAuartEqualTo(String value) {
            addCriterion("AUART =", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartNotEqualTo(String value) {
            addCriterion("AUART <>", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartGreaterThan(String value) {
            addCriterion("AUART >", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartGreaterThanOrEqualTo(String value) {
            addCriterion("AUART >=", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartLessThan(String value) {
            addCriterion("AUART <", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartLessThanOrEqualTo(String value) {
            addCriterion("AUART <=", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartLike(String value) {
            addCriterion("AUART like", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartNotLike(String value) {
            addCriterion("AUART not like", value, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartIn(List<String> values) {
            addCriterion("AUART in", values, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartNotIn(List<String> values) {
            addCriterion("AUART not in", values, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartBetween(String value1, String value2) {
            addCriterion("AUART between", value1, value2, "auart");
            return (Criteria) this;
        }

        public Criteria andAuartNotBetween(String value1, String value2) {
            addCriterion("AUART not between", value1, value2, "auart");
            return (Criteria) this;
        }

        public Criteria andPartRevIsNull() {
            addCriterion("PART_REV is null");
            return (Criteria) this;
        }

        public Criteria andPartRevIsNotNull() {
            addCriterion("PART_REV is not null");
            return (Criteria) this;
        }

        public Criteria andPartRevEqualTo(String value) {
            addCriterion("PART_REV =", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevNotEqualTo(String value) {
            addCriterion("PART_REV <>", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevGreaterThan(String value) {
            addCriterion("PART_REV >", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevGreaterThanOrEqualTo(String value) {
            addCriterion("PART_REV >=", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevLessThan(String value) {
            addCriterion("PART_REV <", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevLessThanOrEqualTo(String value) {
            addCriterion("PART_REV <=", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevLike(String value) {
            addCriterion("PART_REV like", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevNotLike(String value) {
            addCriterion("PART_REV not like", value, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevIn(List<String> values) {
            addCriterion("PART_REV in", values, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevNotIn(List<String> values) {
            addCriterion("PART_REV not in", values, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevBetween(String value1, String value2) {
            addCriterion("PART_REV between", value1, value2, "partRev");
            return (Criteria) this;
        }

        public Criteria andPartRevNotBetween(String value1, String value2) {
            addCriterion("PART_REV not between", value1, value2, "partRev");
            return (Criteria) this;
        }

        public Criteria andBuildIsNull() {
            addCriterion("BUILD is null");
            return (Criteria) this;
        }

        public Criteria andBuildIsNotNull() {
            addCriterion("BUILD is not null");
            return (Criteria) this;
        }

        public Criteria andBuildEqualTo(String value) {
            addCriterion("BUILD =", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildNotEqualTo(String value) {
            addCriterion("BUILD <>", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildGreaterThan(String value) {
            addCriterion("BUILD >", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD >=", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildLessThan(String value) {
            addCriterion("BUILD <", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildLessThanOrEqualTo(String value) {
            addCriterion("BUILD <=", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildLike(String value) {
            addCriterion("BUILD like", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildNotLike(String value) {
            addCriterion("BUILD not like", value, "build");
            return (Criteria) this;
        }

        public Criteria andBuildIn(List<String> values) {
            addCriterion("BUILD in", values, "build");
            return (Criteria) this;
        }

        public Criteria andBuildNotIn(List<String> values) {
            addCriterion("BUILD not in", values, "build");
            return (Criteria) this;
        }

        public Criteria andBuildBetween(String value1, String value2) {
            addCriterion("BUILD between", value1, value2, "build");
            return (Criteria) this;
        }

        public Criteria andBuildNotBetween(String value1, String value2) {
            addCriterion("BUILD not between", value1, value2, "build");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("PRODUCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("PRODUCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("PRODUCT_TYPE =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("PRODUCT_TYPE <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("PRODUCT_TYPE >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("PRODUCT_TYPE <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("PRODUCT_TYPE like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("PRODUCT_TYPE not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("PRODUCT_TYPE in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("PRODUCT_TYPE not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andIsoIsNull() {
            addCriterion("ISO is null");
            return (Criteria) this;
        }

        public Criteria andIsoIsNotNull() {
            addCriterion("ISO is not null");
            return (Criteria) this;
        }

        public Criteria andIsoEqualTo(String value) {
            addCriterion("ISO =", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotEqualTo(String value) {
            addCriterion("ISO <>", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoGreaterThan(String value) {
            addCriterion("ISO >", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoGreaterThanOrEqualTo(String value) {
            addCriterion("ISO >=", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLessThan(String value) {
            addCriterion("ISO <", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLessThanOrEqualTo(String value) {
            addCriterion("ISO <=", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoLike(String value) {
            addCriterion("ISO like", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotLike(String value) {
            addCriterion("ISO not like", value, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoIn(List<String> values) {
            addCriterion("ISO in", values, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotIn(List<String> values) {
            addCriterion("ISO not in", values, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoBetween(String value1, String value2) {
            addCriterion("ISO between", value1, value2, "iso");
            return (Criteria) this;
        }

        public Criteria andIsoNotBetween(String value1, String value2) {
            addCriterion("ISO not between", value1, value2, "iso");
            return (Criteria) this;
        }

        public Criteria andAuartValueIsNull() {
            addCriterion("AUART_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andAuartValueIsNotNull() {
            addCriterion("AUART_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andAuartValueEqualTo(String value) {
            addCriterion("AUART_VALUE =", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueNotEqualTo(String value) {
            addCriterion("AUART_VALUE <>", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueGreaterThan(String value) {
            addCriterion("AUART_VALUE >", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueGreaterThanOrEqualTo(String value) {
            addCriterion("AUART_VALUE >=", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueLessThan(String value) {
            addCriterion("AUART_VALUE <", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueLessThanOrEqualTo(String value) {
            addCriterion("AUART_VALUE <=", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueLike(String value) {
            addCriterion("AUART_VALUE like", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueNotLike(String value) {
            addCriterion("AUART_VALUE not like", value, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueIn(List<String> values) {
            addCriterion("AUART_VALUE in", values, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueNotIn(List<String> values) {
            addCriterion("AUART_VALUE not in", values, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueBetween(String value1, String value2) {
            addCriterion("AUART_VALUE between", value1, value2, "auartValue");
            return (Criteria) this;
        }

        public Criteria andAuartValueNotBetween(String value1, String value2) {
            addCriterion("AUART_VALUE not between", value1, value2, "auartValue");
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