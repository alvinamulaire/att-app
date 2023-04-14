package com.att.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class ZVwInventoryStorageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwInventoryStorageExample() {
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

        public Criteria andStorageLocationBoIsNull() {
            addCriterion("STORAGE_LOCATION_BO is null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoIsNotNull() {
            addCriterion("STORAGE_LOCATION_BO is not null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoEqualTo(String value) {
            addCriterion("STORAGE_LOCATION_BO =", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoNotEqualTo(String value) {
            addCriterion("STORAGE_LOCATION_BO <>", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoGreaterThan(String value) {
            addCriterion("STORAGE_LOCATION_BO >", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoGreaterThanOrEqualTo(String value) {
            addCriterion("STORAGE_LOCATION_BO >=", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoLessThan(String value) {
            addCriterion("STORAGE_LOCATION_BO <", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoLessThanOrEqualTo(String value) {
            addCriterion("STORAGE_LOCATION_BO <=", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoLike(String value) {
            addCriterion("STORAGE_LOCATION_BO like", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoNotLike(String value) {
            addCriterion("STORAGE_LOCATION_BO not like", value, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoIn(List<String> values) {
            addCriterion("STORAGE_LOCATION_BO in", values, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoNotIn(List<String> values) {
            addCriterion("STORAGE_LOCATION_BO not in", values, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoBetween(String value1, String value2) {
            addCriterion("STORAGE_LOCATION_BO between", value1, value2, "storageLocationBo");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBoNotBetween(String value1, String value2) {
            addCriterion("STORAGE_LOCATION_BO not between", value1, value2, "storageLocationBo");
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