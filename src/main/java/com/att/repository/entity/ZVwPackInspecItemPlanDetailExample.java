package com.att.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZVwPackInspecItemPlanDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZVwPackInspecItemPlanDetailExample() {
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

        public Criteria andQcPlanBoIsNull() {
            addCriterion("QC_PLAN_BO is null");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoIsNotNull() {
            addCriterion("QC_PLAN_BO is not null");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoEqualTo(String value) {
            addCriterion("QC_PLAN_BO =", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoNotEqualTo(String value) {
            addCriterion("QC_PLAN_BO <>", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoGreaterThan(String value) {
            addCriterion("QC_PLAN_BO >", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoGreaterThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_BO >=", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoLessThan(String value) {
            addCriterion("QC_PLAN_BO <", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoLessThanOrEqualTo(String value) {
            addCriterion("QC_PLAN_BO <=", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoLike(String value) {
            addCriterion("QC_PLAN_BO like", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoNotLike(String value) {
            addCriterion("QC_PLAN_BO not like", value, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoIn(List<String> values) {
            addCriterion("QC_PLAN_BO in", values, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoNotIn(List<String> values) {
            addCriterion("QC_PLAN_BO not in", values, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoBetween(String value1, String value2) {
            addCriterion("QC_PLAN_BO between", value1, value2, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andQcPlanBoNotBetween(String value1, String value2) {
            addCriterion("QC_PLAN_BO not between", value1, value2, "qcPlanBo");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("CREATE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("CREATE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("CREATE_DATE_TIME >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("CREATE_DATE_TIME <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIsNull() {
            addCriterion("QC_ITEM_SID is null");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIsNotNull() {
            addCriterion("QC_ITEM_SID is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemSidEqualTo(String value) {
            addCriterion("QC_ITEM_SID =", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotEqualTo(String value) {
            addCriterion("QC_ITEM_SID <>", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidGreaterThan(String value) {
            addCriterion("QC_ITEM_SID >", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_SID >=", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLessThan(String value) {
            addCriterion("QC_ITEM_SID <", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_SID <=", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidLike(String value) {
            addCriterion("QC_ITEM_SID like", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotLike(String value) {
            addCriterion("QC_ITEM_SID not like", value, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidIn(List<String> values) {
            addCriterion("QC_ITEM_SID in", values, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotIn(List<String> values) {
            addCriterion("QC_ITEM_SID not in", values, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidBetween(String value1, String value2) {
            addCriterion("QC_ITEM_SID between", value1, value2, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemSidNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM_SID not between", value1, value2, "qcItemSid");
            return (Criteria) this;
        }

        public Criteria andQcItemIsNull() {
            addCriterion("QC_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andQcItemIsNotNull() {
            addCriterion("QC_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemEqualTo(String value) {
            addCriterion("QC_ITEM =", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotEqualTo(String value) {
            addCriterion("QC_ITEM <>", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemGreaterThan(String value) {
            addCriterion("QC_ITEM >", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM >=", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLessThan(String value) {
            addCriterion("QC_ITEM <", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM <=", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemLike(String value) {
            addCriterion("QC_ITEM like", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotLike(String value) {
            addCriterion("QC_ITEM not like", value, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemIn(List<String> values) {
            addCriterion("QC_ITEM in", values, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotIn(List<String> values) {
            addCriterion("QC_ITEM not in", values, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemBetween(String value1, String value2) {
            addCriterion("QC_ITEM between", value1, value2, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM not between", value1, value2, "qcItem");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIsNull() {
            addCriterion("QC_ITEM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIsNotNull() {
            addCriterion("QC_ITEM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andQcItemDescEqualTo(String value) {
            addCriterion("QC_ITEM_DESC =", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotEqualTo(String value) {
            addCriterion("QC_ITEM_DESC <>", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescGreaterThan(String value) {
            addCriterion("QC_ITEM_DESC >", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_DESC >=", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLessThan(String value) {
            addCriterion("QC_ITEM_DESC <", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLessThanOrEqualTo(String value) {
            addCriterion("QC_ITEM_DESC <=", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescLike(String value) {
            addCriterion("QC_ITEM_DESC like", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotLike(String value) {
            addCriterion("QC_ITEM_DESC not like", value, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescIn(List<String> values) {
            addCriterion("QC_ITEM_DESC in", values, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotIn(List<String> values) {
            addCriterion("QC_ITEM_DESC not in", values, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescBetween(String value1, String value2) {
            addCriterion("QC_ITEM_DESC between", value1, value2, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andQcItemDescNotBetween(String value1, String value2) {
            addCriterion("QC_ITEM_DESC not between", value1, value2, "qcItemDesc");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("ITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("ITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("ITEM_TYPE =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("ITEM_TYPE <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("ITEM_TYPE >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("ITEM_TYPE <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("ITEM_TYPE like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("ITEM_TYPE not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("ITEM_TYPE in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("ITEM_TYPE not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("RESOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("RESOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(String value) {
            addCriterion("RESOURCE_TYPE =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(String value) {
            addCriterion("RESOURCE_TYPE >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(String value) {
            addCriterion("RESOURCE_TYPE <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLike(String value) {
            addCriterion("RESOURCE_TYPE like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotLike(String value) {
            addCriterion("RESOURCE_TYPE not like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<String> values) {
            addCriterion("RESOURCE_TYPE in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<String> values) {
            addCriterion("RESOURCE_TYPE not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIsNull() {
            addCriterion("QC_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIsNotNull() {
            addCriterion("QC_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionEqualTo(String value) {
            addCriterion("QC_DESCRIPTION =", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotEqualTo(String value) {
            addCriterion("QC_DESCRIPTION <>", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionGreaterThan(String value) {
            addCriterion("QC_DESCRIPTION >", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("QC_DESCRIPTION >=", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLessThan(String value) {
            addCriterion("QC_DESCRIPTION <", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLessThanOrEqualTo(String value) {
            addCriterion("QC_DESCRIPTION <=", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionLike(String value) {
            addCriterion("QC_DESCRIPTION like", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotLike(String value) {
            addCriterion("QC_DESCRIPTION not like", value, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionIn(List<String> values) {
            addCriterion("QC_DESCRIPTION in", values, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotIn(List<String> values) {
            addCriterion("QC_DESCRIPTION not in", values, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionBetween(String value1, String value2) {
            addCriterion("QC_DESCRIPTION between", value1, value2, "qcDescription");
            return (Criteria) this;
        }

        public Criteria andQcDescriptionNotBetween(String value1, String value2) {
            addCriterion("QC_DESCRIPTION not between", value1, value2, "qcDescription");
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

        public Criteria andUnitsIsNull() {
            addCriterion("UNITS is null");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNotNull() {
            addCriterion("UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsEqualTo(String value) {
            addCriterion("UNITS =", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotEqualTo(String value) {
            addCriterion("UNITS <>", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThan(String value) {
            addCriterion("UNITS >", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("UNITS >=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThan(String value) {
            addCriterion("UNITS <", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThanOrEqualTo(String value) {
            addCriterion("UNITS <=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLike(String value) {
            addCriterion("UNITS like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotLike(String value) {
            addCriterion("UNITS not like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsIn(List<String> values) {
            addCriterion("UNITS in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotIn(List<String> values) {
            addCriterion("UNITS not in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsBetween(String value1, String value2) {
            addCriterion("UNITS between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotBetween(String value1, String value2) {
            addCriterion("UNITS not between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andControlModeIsNull() {
            addCriterion("CONTROL_MODE is null");
            return (Criteria) this;
        }

        public Criteria andControlModeIsNotNull() {
            addCriterion("CONTROL_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andControlModeEqualTo(String value) {
            addCriterion("CONTROL_MODE =", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotEqualTo(String value) {
            addCriterion("CONTROL_MODE <>", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeGreaterThan(String value) {
            addCriterion("CONTROL_MODE >", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTROL_MODE >=", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLessThan(String value) {
            addCriterion("CONTROL_MODE <", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLessThanOrEqualTo(String value) {
            addCriterion("CONTROL_MODE <=", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeLike(String value) {
            addCriterion("CONTROL_MODE like", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotLike(String value) {
            addCriterion("CONTROL_MODE not like", value, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeIn(List<String> values) {
            addCriterion("CONTROL_MODE in", values, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotIn(List<String> values) {
            addCriterion("CONTROL_MODE not in", values, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeBetween(String value1, String value2) {
            addCriterion("CONTROL_MODE between", value1, value2, "controlMode");
            return (Criteria) this;
        }

        public Criteria andControlModeNotBetween(String value1, String value2) {
            addCriterion("CONTROL_MODE not between", value1, value2, "controlMode");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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