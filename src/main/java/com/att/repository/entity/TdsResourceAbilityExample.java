package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdsResourceAbilityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdsResourceAbilityExample() {
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

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Short value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Short value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Short value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Short value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Short value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Short value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Short> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Short> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Short value1, Short value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Short value1, Short value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeIsNull() {
            addCriterion("SWITCH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeIsNotNull() {
            addCriterion("SWITCH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeEqualTo(Short value) {
            addCriterion("SWITCH_TIME =", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeNotEqualTo(Short value) {
            addCriterion("SWITCH_TIME <>", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeGreaterThan(Short value) {
            addCriterion("SWITCH_TIME >", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("SWITCH_TIME >=", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeLessThan(Short value) {
            addCriterion("SWITCH_TIME <", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeLessThanOrEqualTo(Short value) {
            addCriterion("SWITCH_TIME <=", value, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeIn(List<Short> values) {
            addCriterion("SWITCH_TIME in", values, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeNotIn(List<Short> values) {
            addCriterion("SWITCH_TIME not in", values, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeBetween(Short value1, Short value2) {
            addCriterion("SWITCH_TIME between", value1, value2, "switchTime");
            return (Criteria) this;
        }

        public Criteria andSwitchTimeNotBetween(Short value1, Short value2) {
            addCriterion("SWITCH_TIME not between", value1, value2, "switchTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeIsNull() {
            addCriterion("PREPARATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeIsNotNull() {
            addCriterion("PREPARATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeEqualTo(Short value) {
            addCriterion("PREPARATION_TIME =", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeNotEqualTo(Short value) {
            addCriterion("PREPARATION_TIME <>", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeGreaterThan(Short value) {
            addCriterion("PREPARATION_TIME >", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("PREPARATION_TIME >=", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeLessThan(Short value) {
            addCriterion("PREPARATION_TIME <", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeLessThanOrEqualTo(Short value) {
            addCriterion("PREPARATION_TIME <=", value, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeIn(List<Short> values) {
            addCriterion("PREPARATION_TIME in", values, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeNotIn(List<Short> values) {
            addCriterion("PREPARATION_TIME not in", values, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeBetween(Short value1, Short value2) {
            addCriterion("PREPARATION_TIME between", value1, value2, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andPreparationTimeNotBetween(Short value1, Short value2) {
            addCriterion("PREPARATION_TIME not between", value1, value2, "preparationTime");
            return (Criteria) this;
        }

        public Criteria andUphIsNull() {
            addCriterion("UPH is null");
            return (Criteria) this;
        }

        public Criteria andUphIsNotNull() {
            addCriterion("UPH is not null");
            return (Criteria) this;
        }

        public Criteria andUphEqualTo(Integer value) {
            addCriterion("UPH =", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphNotEqualTo(Integer value) {
            addCriterion("UPH <>", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphGreaterThan(Integer value) {
            addCriterion("UPH >", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPH >=", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphLessThan(Integer value) {
            addCriterion("UPH <", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphLessThanOrEqualTo(Integer value) {
            addCriterion("UPH <=", value, "uph");
            return (Criteria) this;
        }

        public Criteria andUphIn(List<Integer> values) {
            addCriterion("UPH in", values, "uph");
            return (Criteria) this;
        }

        public Criteria andUphNotIn(List<Integer> values) {
            addCriterion("UPH not in", values, "uph");
            return (Criteria) this;
        }

        public Criteria andUphBetween(Integer value1, Integer value2) {
            addCriterion("UPH between", value1, value2, "uph");
            return (Criteria) this;
        }

        public Criteria andUphNotBetween(Integer value1, Integer value2) {
            addCriterion("UPH not between", value1, value2, "uph");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNull() {
            addCriterion("MODIFIED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIsNotNull() {
            addCriterion("MODIFIED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME =", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <>", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME >", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME >=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThan(Date value) {
            addCriterion("MODIFIED_DATE_TIME <", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFIED_DATE_TIME <=", value, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotIn(List<Date> values) {
            addCriterion("MODIFIED_DATE_TIME not in", values, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFIED_DATE_TIME not between", value1, value2, "modifiedDateTime");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIsNull() {
            addCriterion("MODIFIED_USER is null");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIsNotNull() {
            addCriterion("MODIFIED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedUserEqualTo(String value) {
            addCriterion("MODIFIED_USER =", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotEqualTo(String value) {
            addCriterion("MODIFIED_USER <>", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserGreaterThan(String value) {
            addCriterion("MODIFIED_USER >", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_USER >=", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLessThan(String value) {
            addCriterion("MODIFIED_USER <", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_USER <=", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserLike(String value) {
            addCriterion("MODIFIED_USER like", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotLike(String value) {
            addCriterion("MODIFIED_USER not like", value, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserIn(List<String> values) {
            addCriterion("MODIFIED_USER in", values, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotIn(List<String> values) {
            addCriterion("MODIFIED_USER not in", values, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserBetween(String value1, String value2) {
            addCriterion("MODIFIED_USER between", value1, value2, "modifiedUser");
            return (Criteria) this;
        }

        public Criteria andModifiedUserNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_USER not between", value1, value2, "modifiedUser");
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