package com.att.mssql.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IqcInboundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IqcInboundExample() {
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

        public Criteria andWerkIsNull() {
            addCriterion("WERK is null");
            return (Criteria) this;
        }

        public Criteria andWerkIsNotNull() {
            addCriterion("WERK is not null");
            return (Criteria) this;
        }

        public Criteria andWerkEqualTo(String value) {
            addCriterion("WERK =", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkNotEqualTo(String value) {
            addCriterion("WERK <>", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkGreaterThan(String value) {
            addCriterion("WERK >", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkGreaterThanOrEqualTo(String value) {
            addCriterion("WERK >=", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkLessThan(String value) {
            addCriterion("WERK <", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkLessThanOrEqualTo(String value) {
            addCriterion("WERK <=", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkLike(String value) {
            addCriterion("WERK like", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkNotLike(String value) {
            addCriterion("WERK not like", value, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkIn(List<String> values) {
            addCriterion("WERK in", values, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkNotIn(List<String> values) {
            addCriterion("WERK not in", values, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkBetween(String value1, String value2) {
            addCriterion("WERK between", value1, value2, "werk");
            return (Criteria) this;
        }

        public Criteria andWerkNotBetween(String value1, String value2) {
            addCriterion("WERK not between", value1, value2, "werk");
            return (Criteria) this;
        }

        public Criteria andPrueflosIsNull() {
            addCriterion("PRUEFLOS is null");
            return (Criteria) this;
        }

        public Criteria andPrueflosIsNotNull() {
            addCriterion("PRUEFLOS is not null");
            return (Criteria) this;
        }

        public Criteria andPrueflosEqualTo(String value) {
            addCriterion("PRUEFLOS =", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosNotEqualTo(String value) {
            addCriterion("PRUEFLOS <>", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosGreaterThan(String value) {
            addCriterion("PRUEFLOS >", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosGreaterThanOrEqualTo(String value) {
            addCriterion("PRUEFLOS >=", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosLessThan(String value) {
            addCriterion("PRUEFLOS <", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosLessThanOrEqualTo(String value) {
            addCriterion("PRUEFLOS <=", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosLike(String value) {
            addCriterion("PRUEFLOS like", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosNotLike(String value) {
            addCriterion("PRUEFLOS not like", value, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosIn(List<String> values) {
            addCriterion("PRUEFLOS in", values, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosNotIn(List<String> values) {
            addCriterion("PRUEFLOS not in", values, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosBetween(String value1, String value2) {
            addCriterion("PRUEFLOS between", value1, value2, "prueflos");
            return (Criteria) this;
        }

        public Criteria andPrueflosNotBetween(String value1, String value2) {
            addCriterion("PRUEFLOS not between", value1, value2, "prueflos");
            return (Criteria) this;
        }

        public Criteria andSelmatnrIsNull() {
            addCriterion("SELMATNR is null");
            return (Criteria) this;
        }

        public Criteria andSelmatnrIsNotNull() {
            addCriterion("SELMATNR is not null");
            return (Criteria) this;
        }

        public Criteria andSelmatnrEqualTo(String value) {
            addCriterion("SELMATNR =", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrNotEqualTo(String value) {
            addCriterion("SELMATNR <>", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrGreaterThan(String value) {
            addCriterion("SELMATNR >", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrGreaterThanOrEqualTo(String value) {
            addCriterion("SELMATNR >=", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrLessThan(String value) {
            addCriterion("SELMATNR <", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrLessThanOrEqualTo(String value) {
            addCriterion("SELMATNR <=", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrLike(String value) {
            addCriterion("SELMATNR like", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrNotLike(String value) {
            addCriterion("SELMATNR not like", value, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrIn(List<String> values) {
            addCriterion("SELMATNR in", values, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrNotIn(List<String> values) {
            addCriterion("SELMATNR not in", values, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrBetween(String value1, String value2) {
            addCriterion("SELMATNR between", value1, value2, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andSelmatnrNotBetween(String value1, String value2) {
            addCriterion("SELMATNR not between", value1, value2, "selmatnr");
            return (Criteria) this;
        }

        public Criteria andLmengezubIsNull() {
            addCriterion("LMENGEZUB is null");
            return (Criteria) this;
        }

        public Criteria andLmengezubIsNotNull() {
            addCriterion("LMENGEZUB is not null");
            return (Criteria) this;
        }

        public Criteria andLmengezubEqualTo(Long value) {
            addCriterion("LMENGEZUB =", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubNotEqualTo(Long value) {
            addCriterion("LMENGEZUB <>", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubGreaterThan(Long value) {
            addCriterion("LMENGEZUB >", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubGreaterThanOrEqualTo(Long value) {
            addCriterion("LMENGEZUB >=", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubLessThan(Long value) {
            addCriterion("LMENGEZUB <", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubLessThanOrEqualTo(Long value) {
            addCriterion("LMENGEZUB <=", value, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubIn(List<Long> values) {
            addCriterion("LMENGEZUB in", values, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubNotIn(List<Long> values) {
            addCriterion("LMENGEZUB not in", values, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubBetween(Long value1, Long value2) {
            addCriterion("LMENGEZUB between", value1, value2, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andLmengezubNotBetween(Long value1, Long value2) {
            addCriterion("LMENGEZUB not between", value1, value2, "lmengezub");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNull() {
            addCriterion("VCODE is null");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNotNull() {
            addCriterion("VCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVcodeEqualTo(String value) {
            addCriterion("VCODE =", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotEqualTo(String value) {
            addCriterion("VCODE <>", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThan(String value) {
            addCriterion("VCODE >", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VCODE >=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThan(String value) {
            addCriterion("VCODE <", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThanOrEqualTo(String value) {
            addCriterion("VCODE <=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLike(String value) {
            addCriterion("VCODE like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotLike(String value) {
            addCriterion("VCODE not like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeIn(List<String> values) {
            addCriterion("VCODE in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotIn(List<String> values) {
            addCriterion("VCODE not in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeBetween(String value1, String value2) {
            addCriterion("VCODE between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotBetween(String value1, String value2) {
            addCriterion("VCODE not between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andLmengeistIsNull() {
            addCriterion("LMENGEIST is null");
            return (Criteria) this;
        }

        public Criteria andLmengeistIsNotNull() {
            addCriterion("LMENGEIST is not null");
            return (Criteria) this;
        }

        public Criteria andLmengeistEqualTo(Short value) {
            addCriterion("LMENGEIST =", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistNotEqualTo(Short value) {
            addCriterion("LMENGEIST <>", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistGreaterThan(Short value) {
            addCriterion("LMENGEIST >", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistGreaterThanOrEqualTo(Short value) {
            addCriterion("LMENGEIST >=", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistLessThan(Short value) {
            addCriterion("LMENGEIST <", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistLessThanOrEqualTo(Short value) {
            addCriterion("LMENGEIST <=", value, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistIn(List<Short> values) {
            addCriterion("LMENGEIST in", values, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistNotIn(List<Short> values) {
            addCriterion("LMENGEIST not in", values, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistBetween(Short value1, Short value2) {
            addCriterion("LMENGEIST between", value1, value2, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andLmengeistNotBetween(Short value1, Short value2) {
            addCriterion("LMENGEIST not between", value1, value2, "lmengeist");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerIsNull() {
            addCriterion("ANZFEHLER is null");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerIsNotNull() {
            addCriterion("ANZFEHLER is not null");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerEqualTo(Short value) {
            addCriterion("ANZFEHLER =", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerNotEqualTo(Short value) {
            addCriterion("ANZFEHLER <>", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerGreaterThan(Short value) {
            addCriterion("ANZFEHLER >", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerGreaterThanOrEqualTo(Short value) {
            addCriterion("ANZFEHLER >=", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerLessThan(Short value) {
            addCriterion("ANZFEHLER <", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerLessThanOrEqualTo(Short value) {
            addCriterion("ANZFEHLER <=", value, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerIn(List<Short> values) {
            addCriterion("ANZFEHLER in", values, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerNotIn(List<Short> values) {
            addCriterion("ANZFEHLER not in", values, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerBetween(Short value1, Short value2) {
            addCriterion("ANZFEHLER between", value1, value2, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andAnzfehlerNotBetween(Short value1, Short value2) {
            addCriterion("ANZFEHLER not between", value1, value2, "anzfehler");
            return (Criteria) this;
        }

        public Criteria andGesstichprIsNull() {
            addCriterion("GESSTICHPR is null");
            return (Criteria) this;
        }

        public Criteria andGesstichprIsNotNull() {
            addCriterion("GESSTICHPR is not null");
            return (Criteria) this;
        }

        public Criteria andGesstichprEqualTo(Short value) {
            addCriterion("GESSTICHPR =", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprNotEqualTo(Short value) {
            addCriterion("GESSTICHPR <>", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprGreaterThan(Short value) {
            addCriterion("GESSTICHPR >", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprGreaterThanOrEqualTo(Short value) {
            addCriterion("GESSTICHPR >=", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprLessThan(Short value) {
            addCriterion("GESSTICHPR <", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprLessThanOrEqualTo(Short value) {
            addCriterion("GESSTICHPR <=", value, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprIn(List<Short> values) {
            addCriterion("GESSTICHPR in", values, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprNotIn(List<Short> values) {
            addCriterion("GESSTICHPR not in", values, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprBetween(Short value1, Short value2) {
            addCriterion("GESSTICHPR between", value1, value2, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andGesstichprNotBetween(Short value1, Short value2) {
            addCriterion("GESSTICHPR not between", value1, value2, "gesstichpr");
            return (Criteria) this;
        }

        public Criteria andStatustextIsNull() {
            addCriterion("STATUSTEXT is null");
            return (Criteria) this;
        }

        public Criteria andStatustextIsNotNull() {
            addCriterion("STATUSTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andStatustextEqualTo(String value) {
            addCriterion("STATUSTEXT =", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextNotEqualTo(String value) {
            addCriterion("STATUSTEXT <>", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextGreaterThan(String value) {
            addCriterion("STATUSTEXT >", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextGreaterThanOrEqualTo(String value) {
            addCriterion("STATUSTEXT >=", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextLessThan(String value) {
            addCriterion("STATUSTEXT <", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextLessThanOrEqualTo(String value) {
            addCriterion("STATUSTEXT <=", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextLike(String value) {
            addCriterion("STATUSTEXT like", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextNotLike(String value) {
            addCriterion("STATUSTEXT not like", value, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextIn(List<String> values) {
            addCriterion("STATUSTEXT in", values, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextNotIn(List<String> values) {
            addCriterion("STATUSTEXT not in", values, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextBetween(String value1, String value2) {
            addCriterion("STATUSTEXT between", value1, value2, "statustext");
            return (Criteria) this;
        }

        public Criteria andStatustextNotBetween(String value1, String value2) {
            addCriterion("STATUSTEXT not between", value1, value2, "statustext");
            return (Criteria) this;
        }

        public Criteria andErpStatusIsNull() {
            addCriterion("ERP_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andErpStatusIsNotNull() {
            addCriterion("ERP_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andErpStatusEqualTo(String value) {
            addCriterion("ERP_STATUS =", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusNotEqualTo(String value) {
            addCriterion("ERP_STATUS <>", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusGreaterThan(String value) {
            addCriterion("ERP_STATUS >", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_STATUS >=", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusLessThan(String value) {
            addCriterion("ERP_STATUS <", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusLessThanOrEqualTo(String value) {
            addCriterion("ERP_STATUS <=", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusLike(String value) {
            addCriterion("ERP_STATUS like", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusNotLike(String value) {
            addCriterion("ERP_STATUS not like", value, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusIn(List<String> values) {
            addCriterion("ERP_STATUS in", values, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusNotIn(List<String> values) {
            addCriterion("ERP_STATUS not in", values, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusBetween(String value1, String value2) {
            addCriterion("ERP_STATUS between", value1, value2, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpStatusNotBetween(String value1, String value2) {
            addCriterion("ERP_STATUS not between", value1, value2, "erpStatus");
            return (Criteria) this;
        }

        public Criteria andErpMemoIsNull() {
            addCriterion("ERP_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andErpMemoIsNotNull() {
            addCriterion("ERP_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andErpMemoEqualTo(String value) {
            addCriterion("ERP_MEMO =", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoNotEqualTo(String value) {
            addCriterion("ERP_MEMO <>", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoGreaterThan(String value) {
            addCriterion("ERP_MEMO >", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_MEMO >=", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoLessThan(String value) {
            addCriterion("ERP_MEMO <", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoLessThanOrEqualTo(String value) {
            addCriterion("ERP_MEMO <=", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoLike(String value) {
            addCriterion("ERP_MEMO like", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoNotLike(String value) {
            addCriterion("ERP_MEMO not like", value, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoIn(List<String> values) {
            addCriterion("ERP_MEMO in", values, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoNotIn(List<String> values) {
            addCriterion("ERP_MEMO not in", values, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoBetween(String value1, String value2) {
            addCriterion("ERP_MEMO between", value1, value2, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andErpMemoNotBetween(String value1, String value2) {
            addCriterion("ERP_MEMO not between", value1, value2, "erpMemo");
            return (Criteria) this;
        }

        public Criteria andLmenge01IsNull() {
            addCriterion("LMENGE01 is null");
            return (Criteria) this;
        }

        public Criteria andLmenge01IsNotNull() {
            addCriterion("LMENGE01 is not null");
            return (Criteria) this;
        }

        public Criteria andLmenge01EqualTo(BigDecimal value) {
            addCriterion("LMENGE01 =", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01NotEqualTo(BigDecimal value) {
            addCriterion("LMENGE01 <>", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01GreaterThan(BigDecimal value) {
            addCriterion("LMENGE01 >", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE01 >=", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01LessThan(BigDecimal value) {
            addCriterion("LMENGE01 <", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01LessThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE01 <=", value, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01In(List<BigDecimal> values) {
            addCriterion("LMENGE01 in", values, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01NotIn(List<BigDecimal> values) {
            addCriterion("LMENGE01 not in", values, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE01 between", value1, value2, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge01NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE01 not between", value1, value2, "lmenge01");
            return (Criteria) this;
        }

        public Criteria andLmenge08IsNull() {
            addCriterion("LMENGE08 is null");
            return (Criteria) this;
        }

        public Criteria andLmenge08IsNotNull() {
            addCriterion("LMENGE08 is not null");
            return (Criteria) this;
        }

        public Criteria andLmenge08EqualTo(BigDecimal value) {
            addCriterion("LMENGE08 =", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08NotEqualTo(BigDecimal value) {
            addCriterion("LMENGE08 <>", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08GreaterThan(BigDecimal value) {
            addCriterion("LMENGE08 >", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE08 >=", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08LessThan(BigDecimal value) {
            addCriterion("LMENGE08 <", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08LessThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE08 <=", value, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08In(List<BigDecimal> values) {
            addCriterion("LMENGE08 in", values, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08NotIn(List<BigDecimal> values) {
            addCriterion("LMENGE08 not in", values, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE08 between", value1, value2, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge08NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE08 not between", value1, value2, "lmenge08");
            return (Criteria) this;
        }

        public Criteria andLmenge03IsNull() {
            addCriterion("LMENGE03 is null");
            return (Criteria) this;
        }

        public Criteria andLmenge03IsNotNull() {
            addCriterion("LMENGE03 is not null");
            return (Criteria) this;
        }

        public Criteria andLmenge03EqualTo(BigDecimal value) {
            addCriterion("LMENGE03 =", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03NotEqualTo(BigDecimal value) {
            addCriterion("LMENGE03 <>", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03GreaterThan(BigDecimal value) {
            addCriterion("LMENGE03 >", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE03 >=", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03LessThan(BigDecimal value) {
            addCriterion("LMENGE03 <", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03LessThanOrEqualTo(BigDecimal value) {
            addCriterion("LMENGE03 <=", value, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03In(List<BigDecimal> values) {
            addCriterion("LMENGE03 in", values, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03NotIn(List<BigDecimal> values) {
            addCriterion("LMENGE03 not in", values, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE03 between", value1, value2, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andLmenge03NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LMENGE03 not between", value1, value2, "lmenge03");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("CREATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("CREATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(String value) {
            addCriterion("CREATION_DATE =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(String value) {
            addCriterion("CREATION_DATE <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(String value) {
            addCriterion("CREATION_DATE >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATION_DATE >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(String value) {
            addCriterion("CREATION_DATE <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(String value) {
            addCriterion("CREATION_DATE <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLike(String value) {
            addCriterion("CREATION_DATE like", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotLike(String value) {
            addCriterion("CREATION_DATE not like", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<String> values) {
            addCriterion("CREATION_DATE in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<String> values) {
            addCriterion("CREATION_DATE not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(String value1, String value2) {
            addCriterion("CREATION_DATE between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(String value1, String value2) {
            addCriterion("CREATION_DATE not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("CREATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("CREATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(String value) {
            addCriterion("CREATION_TIME =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(String value) {
            addCriterion("CREATION_TIME <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(String value) {
            addCriterion("CREATION_TIME >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATION_TIME >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(String value) {
            addCriterion("CREATION_TIME <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATION_TIME <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLike(String value) {
            addCriterion("CREATION_TIME like", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotLike(String value) {
            addCriterion("CREATION_TIME not like", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<String> values) {
            addCriterion("CREATION_TIME in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<String> values) {
            addCriterion("CREATION_TIME not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(String value1, String value2) {
            addCriterion("CREATION_TIME between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(String value1, String value2) {
            addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNull() {
            addCriterion("LAST_UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNotNull() {
            addCriterion("LAST_UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY =", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <>", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThan(String value) {
            addCriterion("LAST_UPDATED_BY >", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY >=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThan(String value) {
            addCriterion("LAST_UPDATED_BY <", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLike(String value) {
            addCriterion("LAST_UPDATED_BY like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotLike(String value) {
            addCriterion("LAST_UPDATED_BY not like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY not in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY not between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("LAST_UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("LAST_UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(String value) {
            addCriterion("LAST_UPDATE_DATE =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(String value) {
            addCriterion("LAST_UPDATE_DATE <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(String value) {
            addCriterion("LAST_UPDATE_DATE >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_DATE >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(String value) {
            addCriterion("LAST_UPDATE_DATE <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_DATE <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLike(String value) {
            addCriterion("LAST_UPDATE_DATE like", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotLike(String value) {
            addCriterion("LAST_UPDATE_DATE not like", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<String> values) {
            addCriterion("LAST_UPDATE_DATE in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<String> values) {
            addCriterion("LAST_UPDATE_DATE not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_DATE between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_DATE not between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LAST_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LAST_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(String value) {
            addCriterion("LAST_UPDATE_TIME =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(String value) {
            addCriterion("LAST_UPDATE_TIME <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(String value) {
            addCriterion("LAST_UPDATE_TIME >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_TIME >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(String value) {
            addCriterion("LAST_UPDATE_TIME <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_TIME <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLike(String value) {
            addCriterion("LAST_UPDATE_TIME like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotLike(String value) {
            addCriterion("LAST_UPDATE_TIME not like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<String> values) {
            addCriterion("LAST_UPDATE_TIME in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<String> values) {
            addCriterion("LAST_UPDATE_TIME not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_TIME between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_TIME not between", value1, value2, "lastUpdateTime");
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