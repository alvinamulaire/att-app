package com.att.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class ZVwPackPalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwPackPalletExample() {
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

        public Criteria andMasterSidIsNull() {
            addCriterion("MASTER_SID is null");
            return (Criteria) this;
        }

        public Criteria andMasterSidIsNotNull() {
            addCriterion("MASTER_SID is not null");
            return (Criteria) this;
        }

        public Criteria andMasterSidEqualTo(String value) {
            addCriterion("MASTER_SID =", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotEqualTo(String value) {
            addCriterion("MASTER_SID <>", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidGreaterThan(String value) {
            addCriterion("MASTER_SID >", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_SID >=", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLessThan(String value) {
            addCriterion("MASTER_SID <", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLessThanOrEqualTo(String value) {
            addCriterion("MASTER_SID <=", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidLike(String value) {
            addCriterion("MASTER_SID like", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotLike(String value) {
            addCriterion("MASTER_SID not like", value, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidIn(List<String> values) {
            addCriterion("MASTER_SID in", values, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotIn(List<String> values) {
            addCriterion("MASTER_SID not in", values, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidBetween(String value1, String value2) {
            addCriterion("MASTER_SID between", value1, value2, "masterSid");
            return (Criteria) this;
        }

        public Criteria andMasterSidNotBetween(String value1, String value2) {
            addCriterion("MASTER_SID not between", value1, value2, "masterSid");
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

        public Criteria andMasterContainerNameIsNull() {
            addCriterion("MASTER_CONTAINER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameIsNotNull() {
            addCriterion("MASTER_CONTAINER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NAME =", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameNotEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NAME <>", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameGreaterThan(String value) {
            addCriterion("MASTER_CONTAINER_NAME >", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NAME >=", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameLessThan(String value) {
            addCriterion("MASTER_CONTAINER_NAME <", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameLessThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NAME <=", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameLike(String value) {
            addCriterion("MASTER_CONTAINER_NAME like", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameNotLike(String value) {
            addCriterion("MASTER_CONTAINER_NAME not like", value, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_NAME in", values, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameNotIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_NAME not in", values, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_NAME between", value1, value2, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNameNotBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_NAME not between", value1, value2, "masterContainerName");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoIsNull() {
            addCriterion("MASTER_CONTAINER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoIsNotNull() {
            addCriterion("MASTER_CONTAINER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NO =", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoNotEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NO <>", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoGreaterThan(String value) {
            addCriterion("MASTER_CONTAINER_NO >", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NO >=", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoLessThan(String value) {
            addCriterion("MASTER_CONTAINER_NO <", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoLessThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_NO <=", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoLike(String value) {
            addCriterion("MASTER_CONTAINER_NO like", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoNotLike(String value) {
            addCriterion("MASTER_CONTAINER_NO not like", value, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_NO in", values, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoNotIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_NO not in", values, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_NO between", value1, value2, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerNoNotBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_NO not between", value1, value2, "masterContainerNo");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeIsNull() {
            addCriterion("MASTER_CONTAINER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeIsNotNull() {
            addCriterion("MASTER_CONTAINER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_TYPE =", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeNotEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_TYPE <>", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeGreaterThan(String value) {
            addCriterion("MASTER_CONTAINER_TYPE >", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_TYPE >=", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeLessThan(String value) {
            addCriterion("MASTER_CONTAINER_TYPE <", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeLessThanOrEqualTo(String value) {
            addCriterion("MASTER_CONTAINER_TYPE <=", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeLike(String value) {
            addCriterion("MASTER_CONTAINER_TYPE like", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeNotLike(String value) {
            addCriterion("MASTER_CONTAINER_TYPE not like", value, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_TYPE in", values, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeNotIn(List<String> values) {
            addCriterion("MASTER_CONTAINER_TYPE not in", values, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_TYPE between", value1, value2, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterContainerTypeNotBetween(String value1, String value2) {
            addCriterion("MASTER_CONTAINER_TYPE not between", value1, value2, "masterContainerType");
            return (Criteria) this;
        }

        public Criteria andMasterStatusIsNull() {
            addCriterion("MASTER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMasterStatusIsNotNull() {
            addCriterion("MASTER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMasterStatusEqualTo(String value) {
            addCriterion("MASTER_STATUS =", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusNotEqualTo(String value) {
            addCriterion("MASTER_STATUS <>", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusGreaterThan(String value) {
            addCriterion("MASTER_STATUS >", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_STATUS >=", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusLessThan(String value) {
            addCriterion("MASTER_STATUS <", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusLessThanOrEqualTo(String value) {
            addCriterion("MASTER_STATUS <=", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusLike(String value) {
            addCriterion("MASTER_STATUS like", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusNotLike(String value) {
            addCriterion("MASTER_STATUS not like", value, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusIn(List<String> values) {
            addCriterion("MASTER_STATUS in", values, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusNotIn(List<String> values) {
            addCriterion("MASTER_STATUS not in", values, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusBetween(String value1, String value2) {
            addCriterion("MASTER_STATUS between", value1, value2, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterStatusNotBetween(String value1, String value2) {
            addCriterion("MASTER_STATUS not between", value1, value2, "masterStatus");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoIsNull() {
            addCriterion("MASTER_CARTON_NO is null");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoIsNotNull() {
            addCriterion("MASTER_CARTON_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoEqualTo(String value) {
            addCriterion("MASTER_CARTON_NO =", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoNotEqualTo(String value) {
            addCriterion("MASTER_CARTON_NO <>", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoGreaterThan(String value) {
            addCriterion("MASTER_CARTON_NO >", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_CARTON_NO >=", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoLessThan(String value) {
            addCriterion("MASTER_CARTON_NO <", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoLessThanOrEqualTo(String value) {
            addCriterion("MASTER_CARTON_NO <=", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoLike(String value) {
            addCriterion("MASTER_CARTON_NO like", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoNotLike(String value) {
            addCriterion("MASTER_CARTON_NO not like", value, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoIn(List<String> values) {
            addCriterion("MASTER_CARTON_NO in", values, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoNotIn(List<String> values) {
            addCriterion("MASTER_CARTON_NO not in", values, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoBetween(String value1, String value2) {
            addCriterion("MASTER_CARTON_NO between", value1, value2, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andMasterCartonNoNotBetween(String value1, String value2) {
            addCriterion("MASTER_CARTON_NO not between", value1, value2, "masterCartonNo");
            return (Criteria) this;
        }

        public Criteria andDetailSidIsNull() {
            addCriterion("DETAIL_SID is null");
            return (Criteria) this;
        }

        public Criteria andDetailSidIsNotNull() {
            addCriterion("DETAIL_SID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSidEqualTo(String value) {
            addCriterion("DETAIL_SID =", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidNotEqualTo(String value) {
            addCriterion("DETAIL_SID <>", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidGreaterThan(String value) {
            addCriterion("DETAIL_SID >", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_SID >=", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidLessThan(String value) {
            addCriterion("DETAIL_SID <", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_SID <=", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidLike(String value) {
            addCriterion("DETAIL_SID like", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidNotLike(String value) {
            addCriterion("DETAIL_SID not like", value, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidIn(List<String> values) {
            addCriterion("DETAIL_SID in", values, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidNotIn(List<String> values) {
            addCriterion("DETAIL_SID not in", values, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidBetween(String value1, String value2) {
            addCriterion("DETAIL_SID between", value1, value2, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailSidNotBetween(String value1, String value2) {
            addCriterion("DETAIL_SID not between", value1, value2, "detailSid");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameIsNull() {
            addCriterion("DETAIL_CONTAINER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameIsNotNull() {
            addCriterion("DETAIL_CONTAINER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NAME =", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameNotEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NAME <>", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameGreaterThan(String value) {
            addCriterion("DETAIL_CONTAINER_NAME >", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NAME >=", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameLessThan(String value) {
            addCriterion("DETAIL_CONTAINER_NAME <", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NAME <=", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameLike(String value) {
            addCriterion("DETAIL_CONTAINER_NAME like", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameNotLike(String value) {
            addCriterion("DETAIL_CONTAINER_NAME not like", value, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameIn(List<String> values) {
            addCriterion("DETAIL_CONTAINER_NAME in", values, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameNotIn(List<String> values) {
            addCriterion("DETAIL_CONTAINER_NAME not in", values, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameBetween(String value1, String value2) {
            addCriterion("DETAIL_CONTAINER_NAME between", value1, value2, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNameNotBetween(String value1, String value2) {
            addCriterion("DETAIL_CONTAINER_NAME not between", value1, value2, "detailContainerName");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoIsNull() {
            addCriterion("DETAIL_CONTAINER_NO is null");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoIsNotNull() {
            addCriterion("DETAIL_CONTAINER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NO =", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoNotEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NO <>", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoGreaterThan(String value) {
            addCriterion("DETAIL_CONTAINER_NO >", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NO >=", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoLessThan(String value) {
            addCriterion("DETAIL_CONTAINER_NO <", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_CONTAINER_NO <=", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoLike(String value) {
            addCriterion("DETAIL_CONTAINER_NO like", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoNotLike(String value) {
            addCriterion("DETAIL_CONTAINER_NO not like", value, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoIn(List<String> values) {
            addCriterion("DETAIL_CONTAINER_NO in", values, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoNotIn(List<String> values) {
            addCriterion("DETAIL_CONTAINER_NO not in", values, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoBetween(String value1, String value2) {
            addCriterion("DETAIL_CONTAINER_NO between", value1, value2, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailContainerNoNotBetween(String value1, String value2) {
            addCriterion("DETAIL_CONTAINER_NO not between", value1, value2, "detailContainerNo");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateIsNull() {
            addCriterion("DETAIL_MFG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateIsNotNull() {
            addCriterion("DETAIL_MFG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateEqualTo(String value) {
            addCriterion("DETAIL_MFG_DATE =", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateNotEqualTo(String value) {
            addCriterion("DETAIL_MFG_DATE <>", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateGreaterThan(String value) {
            addCriterion("DETAIL_MFG_DATE >", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_MFG_DATE >=", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateLessThan(String value) {
            addCriterion("DETAIL_MFG_DATE <", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_MFG_DATE <=", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateLike(String value) {
            addCriterion("DETAIL_MFG_DATE like", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateNotLike(String value) {
            addCriterion("DETAIL_MFG_DATE not like", value, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateIn(List<String> values) {
            addCriterion("DETAIL_MFG_DATE in", values, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateNotIn(List<String> values) {
            addCriterion("DETAIL_MFG_DATE not in", values, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateBetween(String value1, String value2) {
            addCriterion("DETAIL_MFG_DATE between", value1, value2, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailMfgDateNotBetween(String value1, String value2) {
            addCriterion("DETAIL_MFG_DATE not between", value1, value2, "detailMfgDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateIsNull() {
            addCriterion("DETAIL_EXP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateIsNotNull() {
            addCriterion("DETAIL_EXP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateEqualTo(String value) {
            addCriterion("DETAIL_EXP_DATE =", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateNotEqualTo(String value) {
            addCriterion("DETAIL_EXP_DATE <>", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateGreaterThan(String value) {
            addCriterion("DETAIL_EXP_DATE >", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_EXP_DATE >=", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateLessThan(String value) {
            addCriterion("DETAIL_EXP_DATE <", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_EXP_DATE <=", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateLike(String value) {
            addCriterion("DETAIL_EXP_DATE like", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateNotLike(String value) {
            addCriterion("DETAIL_EXP_DATE not like", value, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateIn(List<String> values) {
            addCriterion("DETAIL_EXP_DATE in", values, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateNotIn(List<String> values) {
            addCriterion("DETAIL_EXP_DATE not in", values, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateBetween(String value1, String value2) {
            addCriterion("DETAIL_EXP_DATE between", value1, value2, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailExpDateNotBetween(String value1, String value2) {
            addCriterion("DETAIL_EXP_DATE not between", value1, value2, "detailExpDate");
            return (Criteria) this;
        }

        public Criteria andDetailStatusIsNull() {
            addCriterion("DETAIL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDetailStatusIsNotNull() {
            addCriterion("DETAIL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDetailStatusEqualTo(String value) {
            addCriterion("DETAIL_STATUS =", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusNotEqualTo(String value) {
            addCriterion("DETAIL_STATUS <>", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusGreaterThan(String value) {
            addCriterion("DETAIL_STATUS >", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_STATUS >=", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusLessThan(String value) {
            addCriterion("DETAIL_STATUS <", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_STATUS <=", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusLike(String value) {
            addCriterion("DETAIL_STATUS like", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusNotLike(String value) {
            addCriterion("DETAIL_STATUS not like", value, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusIn(List<String> values) {
            addCriterion("DETAIL_STATUS in", values, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusNotIn(List<String> values) {
            addCriterion("DETAIL_STATUS not in", values, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusBetween(String value1, String value2) {
            addCriterion("DETAIL_STATUS between", value1, value2, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailStatusNotBetween(String value1, String value2) {
            addCriterion("DETAIL_STATUS not between", value1, value2, "detailStatus");
            return (Criteria) this;
        }

        public Criteria andDetailSfcIsNull() {
            addCriterion("DETAIL_SFC is null");
            return (Criteria) this;
        }

        public Criteria andDetailSfcIsNotNull() {
            addCriterion("DETAIL_SFC is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSfcEqualTo(String value) {
            addCriterion("DETAIL_SFC =", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcNotEqualTo(String value) {
            addCriterion("DETAIL_SFC <>", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcGreaterThan(String value) {
            addCriterion("DETAIL_SFC >", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_SFC >=", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcLessThan(String value) {
            addCriterion("DETAIL_SFC <", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_SFC <=", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcLike(String value) {
            addCriterion("DETAIL_SFC like", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcNotLike(String value) {
            addCriterion("DETAIL_SFC not like", value, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcIn(List<String> values) {
            addCriterion("DETAIL_SFC in", values, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcNotIn(List<String> values) {
            addCriterion("DETAIL_SFC not in", values, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcBetween(String value1, String value2) {
            addCriterion("DETAIL_SFC between", value1, value2, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailSfcNotBetween(String value1, String value2) {
            addCriterion("DETAIL_SFC not between", value1, value2, "detailSfc");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoIsNull() {
            addCriterion("DETAIL_BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoIsNotNull() {
            addCriterion("DETAIL_BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoEqualTo(String value) {
            addCriterion("DETAIL_BATCH_NO =", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoNotEqualTo(String value) {
            addCriterion("DETAIL_BATCH_NO <>", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoGreaterThan(String value) {
            addCriterion("DETAIL_BATCH_NO >", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_BATCH_NO >=", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoLessThan(String value) {
            addCriterion("DETAIL_BATCH_NO <", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_BATCH_NO <=", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoLike(String value) {
            addCriterion("DETAIL_BATCH_NO like", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoNotLike(String value) {
            addCriterion("DETAIL_BATCH_NO not like", value, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoIn(List<String> values) {
            addCriterion("DETAIL_BATCH_NO in", values, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoNotIn(List<String> values) {
            addCriterion("DETAIL_BATCH_NO not in", values, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoBetween(String value1, String value2) {
            addCriterion("DETAIL_BATCH_NO between", value1, value2, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailBatchNoNotBetween(String value1, String value2) {
            addCriterion("DETAIL_BATCH_NO not between", value1, value2, "detailBatchNo");
            return (Criteria) this;
        }

        public Criteria andDetailSnIsNull() {
            addCriterion("DETAIL_SN is null");
            return (Criteria) this;
        }

        public Criteria andDetailSnIsNotNull() {
            addCriterion("DETAIL_SN is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSnEqualTo(String value) {
            addCriterion("DETAIL_SN =", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnNotEqualTo(String value) {
            addCriterion("DETAIL_SN <>", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnGreaterThan(String value) {
            addCriterion("DETAIL_SN >", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_SN >=", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnLessThan(String value) {
            addCriterion("DETAIL_SN <", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_SN <=", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnLike(String value) {
            addCriterion("DETAIL_SN like", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnNotLike(String value) {
            addCriterion("DETAIL_SN not like", value, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnIn(List<String> values) {
            addCriterion("DETAIL_SN in", values, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnNotIn(List<String> values) {
            addCriterion("DETAIL_SN not in", values, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnBetween(String value1, String value2) {
            addCriterion("DETAIL_SN between", value1, value2, "detailSn");
            return (Criteria) this;
        }

        public Criteria andDetailSnNotBetween(String value1, String value2) {
            addCriterion("DETAIL_SN not between", value1, value2, "detailSn");
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