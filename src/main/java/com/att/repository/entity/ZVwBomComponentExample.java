package com.att.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZVwBomComponentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwBomComponentExample() {
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

        public Criteria andHandleIsNull() {
            addCriterion("HANDLE is null");
            return (Criteria) this;
        }

        public Criteria andHandleIsNotNull() {
            addCriterion("HANDLE is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEqualTo(String value) {
            addCriterion("HANDLE =", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotEqualTo(String value) {
            addCriterion("HANDLE <>", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThan(String value) {
            addCriterion("HANDLE >", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLE >=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThan(String value) {
            addCriterion("HANDLE <", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThanOrEqualTo(String value) {
            addCriterion("HANDLE <=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLike(String value) {
            addCriterion("HANDLE like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotLike(String value) {
            addCriterion("HANDLE not like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleIn(List<String> values) {
            addCriterion("HANDLE in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotIn(List<String> values) {
            addCriterion("HANDLE not in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleBetween(String value1, String value2) {
            addCriterion("HANDLE between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotBetween(String value1, String value2) {
            addCriterion("HANDLE not between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andBomIsNull() {
            addCriterion("BOM is null");
            return (Criteria) this;
        }

        public Criteria andBomIsNotNull() {
            addCriterion("BOM is not null");
            return (Criteria) this;
        }

        public Criteria andBomEqualTo(String value) {
            addCriterion("BOM =", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomNotEqualTo(String value) {
            addCriterion("BOM <>", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomGreaterThan(String value) {
            addCriterion("BOM >", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomGreaterThanOrEqualTo(String value) {
            addCriterion("BOM >=", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomLessThan(String value) {
            addCriterion("BOM <", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomLessThanOrEqualTo(String value) {
            addCriterion("BOM <=", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomLike(String value) {
            addCriterion("BOM like", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomNotLike(String value) {
            addCriterion("BOM not like", value, "bom");
            return (Criteria) this;
        }

        public Criteria andBomIn(List<String> values) {
            addCriterion("BOM in", values, "bom");
            return (Criteria) this;
        }

        public Criteria andBomNotIn(List<String> values) {
            addCriterion("BOM not in", values, "bom");
            return (Criteria) this;
        }

        public Criteria andBomBetween(String value1, String value2) {
            addCriterion("BOM between", value1, value2, "bom");
            return (Criteria) this;
        }

        public Criteria andBomNotBetween(String value1, String value2) {
            addCriterion("BOM not between", value1, value2, "bom");
            return (Criteria) this;
        }

        public Criteria andBomTypeIsNull() {
            addCriterion("BOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBomTypeIsNotNull() {
            addCriterion("BOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBomTypeEqualTo(String value) {
            addCriterion("BOM_TYPE =", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotEqualTo(String value) {
            addCriterion("BOM_TYPE <>", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeGreaterThan(String value) {
            addCriterion("BOM_TYPE >", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BOM_TYPE >=", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeLessThan(String value) {
            addCriterion("BOM_TYPE <", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeLessThanOrEqualTo(String value) {
            addCriterion("BOM_TYPE <=", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeLike(String value) {
            addCriterion("BOM_TYPE like", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotLike(String value) {
            addCriterion("BOM_TYPE not like", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeIn(List<String> values) {
            addCriterion("BOM_TYPE in", values, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotIn(List<String> values) {
            addCriterion("BOM_TYPE not in", values, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeBetween(String value1, String value2) {
            addCriterion("BOM_TYPE between", value1, value2, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotBetween(String value1, String value2) {
            addCriterion("BOM_TYPE not between", value1, value2, "bomType");
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

        public Criteria andRevisionIsNull() {
            addCriterion("REVISION is null");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNotNull() {
            addCriterion("REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andRevisionEqualTo(String value) {
            addCriterion("REVISION =", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotEqualTo(String value) {
            addCriterion("REVISION <>", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThan(String value) {
            addCriterion("REVISION >", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("REVISION >=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThan(String value) {
            addCriterion("REVISION <", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThanOrEqualTo(String value) {
            addCriterion("REVISION <=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLike(String value) {
            addCriterion("REVISION like", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotLike(String value) {
            addCriterion("REVISION not like", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionIn(List<String> values) {
            addCriterion("REVISION in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotIn(List<String> values) {
            addCriterion("REVISION not in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionBetween(String value1, String value2) {
            addCriterion("REVISION between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotBetween(String value1, String value2) {
            addCriterion("REVISION not between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIsNull() {
            addCriterion("CURRENT_REVISION is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIsNotNull() {
            addCriterion("CURRENT_REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionEqualTo(String value) {
            addCriterion("CURRENT_REVISION =", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotEqualTo(String value) {
            addCriterion("CURRENT_REVISION <>", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionGreaterThan(String value) {
            addCriterion("CURRENT_REVISION >", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_REVISION >=", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLessThan(String value) {
            addCriterion("CURRENT_REVISION <", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_REVISION <=", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionLike(String value) {
            addCriterion("CURRENT_REVISION like", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotLike(String value) {
            addCriterion("CURRENT_REVISION not like", value, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionIn(List<String> values) {
            addCriterion("CURRENT_REVISION in", values, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotIn(List<String> values) {
            addCriterion("CURRENT_REVISION not in", values, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionBetween(String value1, String value2) {
            addCriterion("CURRENT_REVISION between", value1, value2, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andCurrentRevisionNotBetween(String value1, String value2) {
            addCriterion("CURRENT_REVISION not between", value1, value2, "currentRevision");
            return (Criteria) this;
        }

        public Criteria andComponentGboIsNull() {
            addCriterion("COMPONENT_GBO is null");
            return (Criteria) this;
        }

        public Criteria andComponentGboIsNotNull() {
            addCriterion("COMPONENT_GBO is not null");
            return (Criteria) this;
        }

        public Criteria andComponentGboEqualTo(String value) {
            addCriterion("COMPONENT_GBO =", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboNotEqualTo(String value) {
            addCriterion("COMPONENT_GBO <>", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboGreaterThan(String value) {
            addCriterion("COMPONENT_GBO >", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboGreaterThanOrEqualTo(String value) {
            addCriterion("COMPONENT_GBO >=", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboLessThan(String value) {
            addCriterion("COMPONENT_GBO <", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboLessThanOrEqualTo(String value) {
            addCriterion("COMPONENT_GBO <=", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboLike(String value) {
            addCriterion("COMPONENT_GBO like", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboNotLike(String value) {
            addCriterion("COMPONENT_GBO not like", value, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboIn(List<String> values) {
            addCriterion("COMPONENT_GBO in", values, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboNotIn(List<String> values) {
            addCriterion("COMPONENT_GBO not in", values, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboBetween(String value1, String value2) {
            addCriterion("COMPONENT_GBO between", value1, value2, "componentGbo");
            return (Criteria) this;
        }

        public Criteria andComponentGboNotBetween(String value1, String value2) {
            addCriterion("COMPONENT_GBO not between", value1, value2, "componentGbo");
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

        public Criteria andOperationBoIsNull() {
            addCriterion("OPERATION_BO is null");
            return (Criteria) this;
        }

        public Criteria andOperationBoIsNotNull() {
            addCriterion("OPERATION_BO is not null");
            return (Criteria) this;
        }

        public Criteria andOperationBoEqualTo(String value) {
            addCriterion("OPERATION_BO =", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotEqualTo(String value) {
            addCriterion("OPERATION_BO <>", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoGreaterThan(String value) {
            addCriterion("OPERATION_BO >", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_BO >=", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLessThan(String value) {
            addCriterion("OPERATION_BO <", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_BO <=", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoLike(String value) {
            addCriterion("OPERATION_BO like", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotLike(String value) {
            addCriterion("OPERATION_BO not like", value, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoIn(List<String> values) {
            addCriterion("OPERATION_BO in", values, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotIn(List<String> values) {
            addCriterion("OPERATION_BO not in", values, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoBetween(String value1, String value2) {
            addCriterion("OPERATION_BO between", value1, value2, "operationBo");
            return (Criteria) this;
        }

        public Criteria andOperationBoNotBetween(String value1, String value2) {
            addCriterion("OPERATION_BO not between", value1, value2, "operationBo");
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