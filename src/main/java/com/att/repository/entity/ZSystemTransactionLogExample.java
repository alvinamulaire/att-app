package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZSystemTransactionLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZSystemTransactionLogExample() {
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

        public Criteria andTransIdIsNull() {
            addCriterion("TRANS_ID is null");
            return (Criteria) this;
        }

        public Criteria andTransIdIsNotNull() {
            addCriterion("TRANS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTransIdEqualTo(String value) {
            addCriterion("TRANS_ID =", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotEqualTo(String value) {
            addCriterion("TRANS_ID <>", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThan(String value) {
            addCriterion("TRANS_ID >", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS_ID >=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThan(String value) {
            addCriterion("TRANS_ID <", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLessThanOrEqualTo(String value) {
            addCriterion("TRANS_ID <=", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdLike(String value) {
            addCriterion("TRANS_ID like", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotLike(String value) {
            addCriterion("TRANS_ID not like", value, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdIn(List<String> values) {
            addCriterion("TRANS_ID in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotIn(List<String> values) {
            addCriterion("TRANS_ID not in", values, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdBetween(String value1, String value2) {
            addCriterion("TRANS_ID between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andTransIdNotBetween(String value1, String value2) {
            addCriterion("TRANS_ID not between", value1, value2, "transId");
            return (Criteria) this;
        }

        public Criteria andFromSystemIsNull() {
            addCriterion("FROM_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andFromSystemIsNotNull() {
            addCriterion("FROM_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andFromSystemEqualTo(String value) {
            addCriterion("FROM_SYSTEM =", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemNotEqualTo(String value) {
            addCriterion("FROM_SYSTEM <>", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemGreaterThan(String value) {
            addCriterion("FROM_SYSTEM >", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_SYSTEM >=", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemLessThan(String value) {
            addCriterion("FROM_SYSTEM <", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemLessThanOrEqualTo(String value) {
            addCriterion("FROM_SYSTEM <=", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemLike(String value) {
            addCriterion("FROM_SYSTEM like", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemNotLike(String value) {
            addCriterion("FROM_SYSTEM not like", value, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemIn(List<String> values) {
            addCriterion("FROM_SYSTEM in", values, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemNotIn(List<String> values) {
            addCriterion("FROM_SYSTEM not in", values, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemBetween(String value1, String value2) {
            addCriterion("FROM_SYSTEM between", value1, value2, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andFromSystemNotBetween(String value1, String value2) {
            addCriterion("FROM_SYSTEM not between", value1, value2, "fromSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemIsNull() {
            addCriterion("TO_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andToSystemIsNotNull() {
            addCriterion("TO_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andToSystemEqualTo(String value) {
            addCriterion("TO_SYSTEM =", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemNotEqualTo(String value) {
            addCriterion("TO_SYSTEM <>", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemGreaterThan(String value) {
            addCriterion("TO_SYSTEM >", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemGreaterThanOrEqualTo(String value) {
            addCriterion("TO_SYSTEM >=", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemLessThan(String value) {
            addCriterion("TO_SYSTEM <", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemLessThanOrEqualTo(String value) {
            addCriterion("TO_SYSTEM <=", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemLike(String value) {
            addCriterion("TO_SYSTEM like", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemNotLike(String value) {
            addCriterion("TO_SYSTEM not like", value, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemIn(List<String> values) {
            addCriterion("TO_SYSTEM in", values, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemNotIn(List<String> values) {
            addCriterion("TO_SYSTEM not in", values, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemBetween(String value1, String value2) {
            addCriterion("TO_SYSTEM between", value1, value2, "toSystem");
            return (Criteria) this;
        }

        public Criteria andToSystemNotBetween(String value1, String value2) {
            addCriterion("TO_SYSTEM not between", value1, value2, "toSystem");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIsNull() {
            addCriterion("FUNCTION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIsNotNull() {
            addCriterion("FUNCTION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionNameEqualTo(String value) {
            addCriterion("FUNCTION_NAME =", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotEqualTo(String value) {
            addCriterion("FUNCTION_NAME <>", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameGreaterThan(String value) {
            addCriterion("FUNCTION_NAME >", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameGreaterThanOrEqualTo(String value) {
            addCriterion("FUNCTION_NAME >=", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLessThan(String value) {
            addCriterion("FUNCTION_NAME <", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLessThanOrEqualTo(String value) {
            addCriterion("FUNCTION_NAME <=", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLike(String value) {
            addCriterion("FUNCTION_NAME like", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotLike(String value) {
            addCriterion("FUNCTION_NAME not like", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIn(List<String> values) {
            addCriterion("FUNCTION_NAME in", values, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotIn(List<String> values) {
            addCriterion("FUNCTION_NAME not in", values, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameBetween(String value1, String value2) {
            addCriterion("FUNCTION_NAME between", value1, value2, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotBetween(String value1, String value2) {
            addCriterion("FUNCTION_NAME not between", value1, value2, "functionName");
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