package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZMaterialShelfStateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZMaterialShelfStateLogExample() {
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

        public Criteria andResourceIsNull() {
            addCriterion("RESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("RESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("RESOURCE =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("RESOURCE <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("RESOURCE >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("RESOURCE <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("RESOURCE like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("RESOURCE not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("RESOURCE in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("RESOURCE not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("RESOURCE between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("RESOURCE not between", value1, value2, "resource");
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

        public Criteria andShelfNoIsNull() {
            addCriterion("SHELF_NO is null");
            return (Criteria) this;
        }

        public Criteria andShelfNoIsNotNull() {
            addCriterion("SHELF_NO is not null");
            return (Criteria) this;
        }

        public Criteria andShelfNoEqualTo(String value) {
            addCriterion("SHELF_NO =", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoNotEqualTo(String value) {
            addCriterion("SHELF_NO <>", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoGreaterThan(String value) {
            addCriterion("SHELF_NO >", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoGreaterThanOrEqualTo(String value) {
            addCriterion("SHELF_NO >=", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoLessThan(String value) {
            addCriterion("SHELF_NO <", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoLessThanOrEqualTo(String value) {
            addCriterion("SHELF_NO <=", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoLike(String value) {
            addCriterion("SHELF_NO like", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoNotLike(String value) {
            addCriterion("SHELF_NO not like", value, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoIn(List<String> values) {
            addCriterion("SHELF_NO in", values, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoNotIn(List<String> values) {
            addCriterion("SHELF_NO not in", values, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoBetween(String value1, String value2) {
            addCriterion("SHELF_NO between", value1, value2, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andShelfNoNotBetween(String value1, String value2) {
            addCriterion("SHELF_NO not between", value1, value2, "shelfNo");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeIsNull() {
            addCriterion("PUTON_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeIsNotNull() {
            addCriterion("PUTON_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeEqualTo(Date value) {
            addCriterion("PUTON_DATE_TIME =", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeNotEqualTo(Date value) {
            addCriterion("PUTON_DATE_TIME <>", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeGreaterThan(Date value) {
            addCriterion("PUTON_DATE_TIME >", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUTON_DATE_TIME >=", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeLessThan(Date value) {
            addCriterion("PUTON_DATE_TIME <", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUTON_DATE_TIME <=", value, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeIn(List<Date> values) {
            addCriterion("PUTON_DATE_TIME in", values, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeNotIn(List<Date> values) {
            addCriterion("PUTON_DATE_TIME not in", values, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeBetween(Date value1, Date value2) {
            addCriterion("PUTON_DATE_TIME between", value1, value2, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUTON_DATE_TIME not between", value1, value2, "putonDateTime");
            return (Criteria) this;
        }

        public Criteria andPutonUserIsNull() {
            addCriterion("PUTON_USER is null");
            return (Criteria) this;
        }

        public Criteria andPutonUserIsNotNull() {
            addCriterion("PUTON_USER is not null");
            return (Criteria) this;
        }

        public Criteria andPutonUserEqualTo(String value) {
            addCriterion("PUTON_USER =", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserNotEqualTo(String value) {
            addCriterion("PUTON_USER <>", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserGreaterThan(String value) {
            addCriterion("PUTON_USER >", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserGreaterThanOrEqualTo(String value) {
            addCriterion("PUTON_USER >=", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserLessThan(String value) {
            addCriterion("PUTON_USER <", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserLessThanOrEqualTo(String value) {
            addCriterion("PUTON_USER <=", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserLike(String value) {
            addCriterion("PUTON_USER like", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserNotLike(String value) {
            addCriterion("PUTON_USER not like", value, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserIn(List<String> values) {
            addCriterion("PUTON_USER in", values, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserNotIn(List<String> values) {
            addCriterion("PUTON_USER not in", values, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserBetween(String value1, String value2) {
            addCriterion("PUTON_USER between", value1, value2, "putonUser");
            return (Criteria) this;
        }

        public Criteria andPutonUserNotBetween(String value1, String value2) {
            addCriterion("PUTON_USER not between", value1, value2, "putonUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeIsNull() {
            addCriterion("TAKEOFF_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeIsNotNull() {
            addCriterion("TAKEOFF_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeEqualTo(Date value) {
            addCriterion("TAKEOFF_DATE_TIME =", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeNotEqualTo(Date value) {
            addCriterion("TAKEOFF_DATE_TIME <>", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeGreaterThan(Date value) {
            addCriterion("TAKEOFF_DATE_TIME >", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TAKEOFF_DATE_TIME >=", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeLessThan(Date value) {
            addCriterion("TAKEOFF_DATE_TIME <", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("TAKEOFF_DATE_TIME <=", value, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeIn(List<Date> values) {
            addCriterion("TAKEOFF_DATE_TIME in", values, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeNotIn(List<Date> values) {
            addCriterion("TAKEOFF_DATE_TIME not in", values, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeBetween(Date value1, Date value2) {
            addCriterion("TAKEOFF_DATE_TIME between", value1, value2, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("TAKEOFF_DATE_TIME not between", value1, value2, "takeoffDateTime");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserIsNull() {
            addCriterion("TAKEOFF_USER is null");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserIsNotNull() {
            addCriterion("TAKEOFF_USER is not null");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserEqualTo(String value) {
            addCriterion("TAKEOFF_USER =", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserNotEqualTo(String value) {
            addCriterion("TAKEOFF_USER <>", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserGreaterThan(String value) {
            addCriterion("TAKEOFF_USER >", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserGreaterThanOrEqualTo(String value) {
            addCriterion("TAKEOFF_USER >=", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserLessThan(String value) {
            addCriterion("TAKEOFF_USER <", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserLessThanOrEqualTo(String value) {
            addCriterion("TAKEOFF_USER <=", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserLike(String value) {
            addCriterion("TAKEOFF_USER like", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserNotLike(String value) {
            addCriterion("TAKEOFF_USER not like", value, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserIn(List<String> values) {
            addCriterion("TAKEOFF_USER in", values, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserNotIn(List<String> values) {
            addCriterion("TAKEOFF_USER not in", values, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserBetween(String value1, String value2) {
            addCriterion("TAKEOFF_USER between", value1, value2, "takeoffUser");
            return (Criteria) this;
        }

        public Criteria andTakeoffUserNotBetween(String value1, String value2) {
            addCriterion("TAKEOFF_USER not between", value1, value2, "takeoffUser");
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