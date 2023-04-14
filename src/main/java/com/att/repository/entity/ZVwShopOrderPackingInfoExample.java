package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwShopOrderPackingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwShopOrderPackingInfoExample() {
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

        public Criteria andStatusBoIsNull() {
            addCriterion("STATUS_BO is null");
            return (Criteria) this;
        }

        public Criteria andStatusBoIsNotNull() {
            addCriterion("STATUS_BO is not null");
            return (Criteria) this;
        }

        public Criteria andStatusBoEqualTo(String value) {
            addCriterion("STATUS_BO =", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotEqualTo(String value) {
            addCriterion("STATUS_BO <>", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoGreaterThan(String value) {
            addCriterion("STATUS_BO >", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_BO >=", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLessThan(String value) {
            addCriterion("STATUS_BO <", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLessThanOrEqualTo(String value) {
            addCriterion("STATUS_BO <=", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoLike(String value) {
            addCriterion("STATUS_BO like", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotLike(String value) {
            addCriterion("STATUS_BO not like", value, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoIn(List<String> values) {
            addCriterion("STATUS_BO in", values, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotIn(List<String> values) {
            addCriterion("STATUS_BO not in", values, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoBetween(String value1, String value2) {
            addCriterion("STATUS_BO between", value1, value2, "statusBo");
            return (Criteria) this;
        }

        public Criteria andStatusBoNotBetween(String value1, String value2) {
            addCriterion("STATUS_BO not between", value1, value2, "statusBo");
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

        public Criteria andValueIsNull() {
            addCriterion("VALUE is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("VALUE in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("VALUE not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE not between", value1, value2, "value");
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

        public Criteria andSfcStatusBoIsNull() {
            addCriterion("SFC_STATUS_BO is null");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoIsNotNull() {
            addCriterion("SFC_STATUS_BO is not null");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoEqualTo(String value) {
            addCriterion("SFC_STATUS_BO =", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoNotEqualTo(String value) {
            addCriterion("SFC_STATUS_BO <>", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoGreaterThan(String value) {
            addCriterion("SFC_STATUS_BO >", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoGreaterThanOrEqualTo(String value) {
            addCriterion("SFC_STATUS_BO >=", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoLessThan(String value) {
            addCriterion("SFC_STATUS_BO <", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoLessThanOrEqualTo(String value) {
            addCriterion("SFC_STATUS_BO <=", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoLike(String value) {
            addCriterion("SFC_STATUS_BO like", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoNotLike(String value) {
            addCriterion("SFC_STATUS_BO not like", value, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoIn(List<String> values) {
            addCriterion("SFC_STATUS_BO in", values, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoNotIn(List<String> values) {
            addCriterion("SFC_STATUS_BO not in", values, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoBetween(String value1, String value2) {
            addCriterion("SFC_STATUS_BO between", value1, value2, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andSfcStatusBoNotBetween(String value1, String value2) {
            addCriterion("SFC_STATUS_BO not between", value1, value2, "sfcStatusBo");
            return (Criteria) this;
        }

        public Criteria andItemBoIsNull() {
            addCriterion("ITEM_BO is null");
            return (Criteria) this;
        }

        public Criteria andItemBoIsNotNull() {
            addCriterion("ITEM_BO is not null");
            return (Criteria) this;
        }

        public Criteria andItemBoEqualTo(String value) {
            addCriterion("ITEM_BO =", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotEqualTo(String value) {
            addCriterion("ITEM_BO <>", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoGreaterThan(String value) {
            addCriterion("ITEM_BO >", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_BO >=", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLessThan(String value) {
            addCriterion("ITEM_BO <", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLessThanOrEqualTo(String value) {
            addCriterion("ITEM_BO <=", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoLike(String value) {
            addCriterion("ITEM_BO like", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotLike(String value) {
            addCriterion("ITEM_BO not like", value, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoIn(List<String> values) {
            addCriterion("ITEM_BO in", values, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotIn(List<String> values) {
            addCriterion("ITEM_BO not in", values, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoBetween(String value1, String value2) {
            addCriterion("ITEM_BO between", value1, value2, "itemBo");
            return (Criteria) this;
        }

        public Criteria andItemBoNotBetween(String value1, String value2) {
            addCriterion("ITEM_BO not between", value1, value2, "itemBo");
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

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andCartonNoIsNull() {
            addCriterion("CARTON_NO is null");
            return (Criteria) this;
        }

        public Criteria andCartonNoIsNotNull() {
            addCriterion("CARTON_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCartonNoEqualTo(String value) {
            addCriterion("CARTON_NO =", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotEqualTo(String value) {
            addCriterion("CARTON_NO <>", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoGreaterThan(String value) {
            addCriterion("CARTON_NO >", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_NO >=", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLessThan(String value) {
            addCriterion("CARTON_NO <", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLessThanOrEqualTo(String value) {
            addCriterion("CARTON_NO <=", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoLike(String value) {
            addCriterion("CARTON_NO like", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotLike(String value) {
            addCriterion("CARTON_NO not like", value, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoIn(List<String> values) {
            addCriterion("CARTON_NO in", values, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotIn(List<String> values) {
            addCriterion("CARTON_NO not in", values, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoBetween(String value1, String value2) {
            addCriterion("CARTON_NO between", value1, value2, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andCartonNoNotBetween(String value1, String value2) {
            addCriterion("CARTON_NO not between", value1, value2, "cartonNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoIsNull() {
            addCriterion("PALLET_NO is null");
            return (Criteria) this;
        }

        public Criteria andPalletNoIsNotNull() {
            addCriterion("PALLET_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPalletNoEqualTo(String value) {
            addCriterion("PALLET_NO =", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoNotEqualTo(String value) {
            addCriterion("PALLET_NO <>", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoGreaterThan(String value) {
            addCriterion("PALLET_NO >", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoGreaterThanOrEqualTo(String value) {
            addCriterion("PALLET_NO >=", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoLessThan(String value) {
            addCriterion("PALLET_NO <", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoLessThanOrEqualTo(String value) {
            addCriterion("PALLET_NO <=", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoLike(String value) {
            addCriterion("PALLET_NO like", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoNotLike(String value) {
            addCriterion("PALLET_NO not like", value, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoIn(List<String> values) {
            addCriterion("PALLET_NO in", values, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoNotIn(List<String> values) {
            addCriterion("PALLET_NO not in", values, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoBetween(String value1, String value2) {
            addCriterion("PALLET_NO between", value1, value2, "palletNo");
            return (Criteria) this;
        }

        public Criteria andPalletNoNotBetween(String value1, String value2) {
            addCriterion("PALLET_NO not between", value1, value2, "palletNo");
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