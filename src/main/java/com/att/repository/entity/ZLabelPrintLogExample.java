package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZLabelPrintLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZLabelPrintLogExample() {
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

        public Criteria andLabelTypeIsNull() {
            addCriterion("LABEL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLabelTypeIsNotNull() {
            addCriterion("LABEL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLabelTypeEqualTo(String value) {
            addCriterion("LABEL_TYPE =", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeNotEqualTo(String value) {
            addCriterion("LABEL_TYPE <>", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeGreaterThan(String value) {
            addCriterion("LABEL_TYPE >", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL_TYPE >=", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeLessThan(String value) {
            addCriterion("LABEL_TYPE <", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeLessThanOrEqualTo(String value) {
            addCriterion("LABEL_TYPE <=", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeLike(String value) {
            addCriterion("LABEL_TYPE like", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeNotLike(String value) {
            addCriterion("LABEL_TYPE not like", value, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeIn(List<String> values) {
            addCriterion("LABEL_TYPE in", values, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeNotIn(List<String> values) {
            addCriterion("LABEL_TYPE not in", values, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeBetween(String value1, String value2) {
            addCriterion("LABEL_TYPE between", value1, value2, "labelType");
            return (Criteria) this;
        }

        public Criteria andLabelTypeNotBetween(String value1, String value2) {
            addCriterion("LABEL_TYPE not between", value1, value2, "labelType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeIsNull() {
            addCriterion("PRINT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPrintTypeIsNotNull() {
            addCriterion("PRINT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTypeEqualTo(String value) {
            addCriterion("PRINT_TYPE =", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeNotEqualTo(String value) {
            addCriterion("PRINT_TYPE <>", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeGreaterThan(String value) {
            addCriterion("PRINT_TYPE >", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRINT_TYPE >=", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeLessThan(String value) {
            addCriterion("PRINT_TYPE <", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeLessThanOrEqualTo(String value) {
            addCriterion("PRINT_TYPE <=", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeLike(String value) {
            addCriterion("PRINT_TYPE like", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeNotLike(String value) {
            addCriterion("PRINT_TYPE not like", value, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeIn(List<String> values) {
            addCriterion("PRINT_TYPE in", values, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeNotIn(List<String> values) {
            addCriterion("PRINT_TYPE not in", values, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeBetween(String value1, String value2) {
            addCriterion("PRINT_TYPE between", value1, value2, "printType");
            return (Criteria) this;
        }

        public Criteria andPrintTypeNotBetween(String value1, String value2) {
            addCriterion("PRINT_TYPE not between", value1, value2, "printType");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNull() {
            addCriterion("KEY_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNotNull() {
            addCriterion("KEY_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andKeyValueEqualTo(String value) {
            addCriterion("KEY_VALUE =", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotEqualTo(String value) {
            addCriterion("KEY_VALUE <>", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThan(String value) {
            addCriterion("KEY_VALUE >", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_VALUE >=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThan(String value) {
            addCriterion("KEY_VALUE <", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThanOrEqualTo(String value) {
            addCriterion("KEY_VALUE <=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLike(String value) {
            addCriterion("KEY_VALUE like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotLike(String value) {
            addCriterion("KEY_VALUE not like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueIn(List<String> values) {
            addCriterion("KEY_VALUE in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotIn(List<String> values) {
            addCriterion("KEY_VALUE not in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueBetween(String value1, String value2) {
            addCriterion("KEY_VALUE between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotBetween(String value1, String value2) {
            addCriterion("KEY_VALUE not between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNull() {
            addCriterion("CREATED_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNotNull() {
            addCriterion("CREATED_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME =", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <>", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThan(Date value) {
            addCriterion("CREATED_DATE_TIME >", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME >=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThan(Date value) {
            addCriterion("CREATED_DATE_TIME <", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DATE_TIME <=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotIn(List<Date> values) {
            addCriterion("CREATED_DATE_TIME not in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DATE_TIME not between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNull() {
            addCriterion("CREATED_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNotNull() {
            addCriterion("CREATED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserEqualTo(String value) {
            addCriterion("CREATED_USER =", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotEqualTo(String value) {
            addCriterion("CREATED_USER <>", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThan(String value) {
            addCriterion("CREATED_USER >", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_USER >=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThan(String value) {
            addCriterion("CREATED_USER <", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThanOrEqualTo(String value) {
            addCriterion("CREATED_USER <=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLike(String value) {
            addCriterion("CREATED_USER like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotLike(String value) {
            addCriterion("CREATED_USER not like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIn(List<String> values) {
            addCriterion("CREATED_USER in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotIn(List<String> values) {
            addCriterion("CREATED_USER not in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserBetween(String value1, String value2) {
            addCriterion("CREATED_USER between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotBetween(String value1, String value2) {
            addCriterion("CREATED_USER not between", value1, value2, "createdUser");
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