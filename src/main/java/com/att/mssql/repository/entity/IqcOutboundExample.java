package com.att.mssql.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IqcOutboundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IqcOutboundExample() {
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

        public Criteria andLosmengeIsNull() {
            addCriterion("LOSMENGE is null");
            return (Criteria) this;
        }

        public Criteria andLosmengeIsNotNull() {
            addCriterion("LOSMENGE is not null");
            return (Criteria) this;
        }

        public Criteria andLosmengeEqualTo(BigDecimal value) {
            addCriterion("LOSMENGE =", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeNotEqualTo(BigDecimal value) {
            addCriterion("LOSMENGE <>", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeGreaterThan(BigDecimal value) {
            addCriterion("LOSMENGE >", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOSMENGE >=", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeLessThan(BigDecimal value) {
            addCriterion("LOSMENGE <", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOSMENGE <=", value, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeIn(List<BigDecimal> values) {
            addCriterion("LOSMENGE in", values, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeNotIn(List<BigDecimal> values) {
            addCriterion("LOSMENGE not in", values, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOSMENGE between", value1, value2, "losmenge");
            return (Criteria) this;
        }

        public Criteria andLosmengeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOSMENGE not between", value1, value2, "losmenge");
            return (Criteria) this;
        }

        public Criteria andChargIsNull() {
            addCriterion("CHARG is null");
            return (Criteria) this;
        }

        public Criteria andChargIsNotNull() {
            addCriterion("CHARG is not null");
            return (Criteria) this;
        }

        public Criteria andChargEqualTo(String value) {
            addCriterion("CHARG =", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargNotEqualTo(String value) {
            addCriterion("CHARG <>", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargGreaterThan(String value) {
            addCriterion("CHARG >", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargGreaterThanOrEqualTo(String value) {
            addCriterion("CHARG >=", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargLessThan(String value) {
            addCriterion("CHARG <", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargLessThanOrEqualTo(String value) {
            addCriterion("CHARG <=", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargLike(String value) {
            addCriterion("CHARG like", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargNotLike(String value) {
            addCriterion("CHARG not like", value, "charg");
            return (Criteria) this;
        }

        public Criteria andChargIn(List<String> values) {
            addCriterion("CHARG in", values, "charg");
            return (Criteria) this;
        }

        public Criteria andChargNotIn(List<String> values) {
            addCriterion("CHARG not in", values, "charg");
            return (Criteria) this;
        }

        public Criteria andChargBetween(String value1, String value2) {
            addCriterion("CHARG between", value1, value2, "charg");
            return (Criteria) this;
        }

        public Criteria andChargNotBetween(String value1, String value2) {
            addCriterion("CHARG not between", value1, value2, "charg");
            return (Criteria) this;
        }

        public Criteria andLifnrIsNull() {
            addCriterion("LIFNR is null");
            return (Criteria) this;
        }

        public Criteria andLifnrIsNotNull() {
            addCriterion("LIFNR is not null");
            return (Criteria) this;
        }

        public Criteria andLifnrEqualTo(String value) {
            addCriterion("LIFNR =", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrNotEqualTo(String value) {
            addCriterion("LIFNR <>", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrGreaterThan(String value) {
            addCriterion("LIFNR >", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrGreaterThanOrEqualTo(String value) {
            addCriterion("LIFNR >=", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrLessThan(String value) {
            addCriterion("LIFNR <", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrLessThanOrEqualTo(String value) {
            addCriterion("LIFNR <=", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrLike(String value) {
            addCriterion("LIFNR like", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrNotLike(String value) {
            addCriterion("LIFNR not like", value, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrIn(List<String> values) {
            addCriterion("LIFNR in", values, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrNotIn(List<String> values) {
            addCriterion("LIFNR not in", values, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrBetween(String value1, String value2) {
            addCriterion("LIFNR between", value1, value2, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLifnrNotBetween(String value1, String value2) {
            addCriterion("LIFNR not between", value1, value2, "lifnr");
            return (Criteria) this;
        }

        public Criteria andLichnIsNull() {
            addCriterion("LICHN is null");
            return (Criteria) this;
        }

        public Criteria andLichnIsNotNull() {
            addCriterion("LICHN is not null");
            return (Criteria) this;
        }

        public Criteria andLichnEqualTo(String value) {
            addCriterion("LICHN =", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnNotEqualTo(String value) {
            addCriterion("LICHN <>", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnGreaterThan(String value) {
            addCriterion("LICHN >", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnGreaterThanOrEqualTo(String value) {
            addCriterion("LICHN >=", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnLessThan(String value) {
            addCriterion("LICHN <", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnLessThanOrEqualTo(String value) {
            addCriterion("LICHN <=", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnLike(String value) {
            addCriterion("LICHN like", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnNotLike(String value) {
            addCriterion("LICHN not like", value, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnIn(List<String> values) {
            addCriterion("LICHN in", values, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnNotIn(List<String> values) {
            addCriterion("LICHN not in", values, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnBetween(String value1, String value2) {
            addCriterion("LICHN between", value1, value2, "lichn");
            return (Criteria) this;
        }

        public Criteria andLichnNotBetween(String value1, String value2) {
            addCriterion("LICHN not between", value1, value2, "lichn");
            return (Criteria) this;
        }

        public Criteria andZbMfdateIsNull() {
            addCriterion("ZB_MFDATE is null");
            return (Criteria) this;
        }

        public Criteria andZbMfdateIsNotNull() {
            addCriterion("ZB_MFDATE is not null");
            return (Criteria) this;
        }

        public Criteria andZbMfdateEqualTo(String value) {
            addCriterion("ZB_MFDATE =", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateNotEqualTo(String value) {
            addCriterion("ZB_MFDATE <>", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateGreaterThan(String value) {
            addCriterion("ZB_MFDATE >", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateGreaterThanOrEqualTo(String value) {
            addCriterion("ZB_MFDATE >=", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateLessThan(String value) {
            addCriterion("ZB_MFDATE <", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateLessThanOrEqualTo(String value) {
            addCriterion("ZB_MFDATE <=", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateLike(String value) {
            addCriterion("ZB_MFDATE like", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateNotLike(String value) {
            addCriterion("ZB_MFDATE not like", value, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateIn(List<String> values) {
            addCriterion("ZB_MFDATE in", values, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateNotIn(List<String> values) {
            addCriterion("ZB_MFDATE not in", values, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateBetween(String value1, String value2) {
            addCriterion("ZB_MFDATE between", value1, value2, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andZbMfdateNotBetween(String value1, String value2) {
            addCriterion("ZB_MFDATE not between", value1, value2, "zbMfdate");
            return (Criteria) this;
        }

        public Criteria andMjahrIsNull() {
            addCriterion("MJAHR is null");
            return (Criteria) this;
        }

        public Criteria andMjahrIsNotNull() {
            addCriterion("MJAHR is not null");
            return (Criteria) this;
        }

        public Criteria andMjahrEqualTo(Short value) {
            addCriterion("MJAHR =", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrNotEqualTo(Short value) {
            addCriterion("MJAHR <>", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrGreaterThan(Short value) {
            addCriterion("MJAHR >", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrGreaterThanOrEqualTo(Short value) {
            addCriterion("MJAHR >=", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrLessThan(Short value) {
            addCriterion("MJAHR <", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrLessThanOrEqualTo(Short value) {
            addCriterion("MJAHR <=", value, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrIn(List<Short> values) {
            addCriterion("MJAHR in", values, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrNotIn(List<Short> values) {
            addCriterion("MJAHR not in", values, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrBetween(Short value1, Short value2) {
            addCriterion("MJAHR between", value1, value2, "mjahr");
            return (Criteria) this;
        }

        public Criteria andMjahrNotBetween(Short value1, Short value2) {
            addCriterion("MJAHR not between", value1, value2, "mjahr");
            return (Criteria) this;
        }

        public Criteria andEbelnIsNull() {
            addCriterion("EBELN is null");
            return (Criteria) this;
        }

        public Criteria andEbelnIsNotNull() {
            addCriterion("EBELN is not null");
            return (Criteria) this;
        }

        public Criteria andEbelnEqualTo(String value) {
            addCriterion("EBELN =", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnNotEqualTo(String value) {
            addCriterion("EBELN <>", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnGreaterThan(String value) {
            addCriterion("EBELN >", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnGreaterThanOrEqualTo(String value) {
            addCriterion("EBELN >=", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnLessThan(String value) {
            addCriterion("EBELN <", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnLessThanOrEqualTo(String value) {
            addCriterion("EBELN <=", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnLike(String value) {
            addCriterion("EBELN like", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnNotLike(String value) {
            addCriterion("EBELN not like", value, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnIn(List<String> values) {
            addCriterion("EBELN in", values, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnNotIn(List<String> values) {
            addCriterion("EBELN not in", values, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnBetween(String value1, String value2) {
            addCriterion("EBELN between", value1, value2, "ebeln");
            return (Criteria) this;
        }

        public Criteria andEbelnNotBetween(String value1, String value2) {
            addCriterion("EBELN not between", value1, value2, "ebeln");
            return (Criteria) this;
        }

        public Criteria andMblnrIsNull() {
            addCriterion("MBLNR is null");
            return (Criteria) this;
        }

        public Criteria andMblnrIsNotNull() {
            addCriterion("MBLNR is not null");
            return (Criteria) this;
        }

        public Criteria andMblnrEqualTo(String value) {
            addCriterion("MBLNR =", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrNotEqualTo(String value) {
            addCriterion("MBLNR <>", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrGreaterThan(String value) {
            addCriterion("MBLNR >", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrGreaterThanOrEqualTo(String value) {
            addCriterion("MBLNR >=", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrLessThan(String value) {
            addCriterion("MBLNR <", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrLessThanOrEqualTo(String value) {
            addCriterion("MBLNR <=", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrLike(String value) {
            addCriterion("MBLNR like", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrNotLike(String value) {
            addCriterion("MBLNR not like", value, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrIn(List<String> values) {
            addCriterion("MBLNR in", values, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrNotIn(List<String> values) {
            addCriterion("MBLNR not in", values, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrBetween(String value1, String value2) {
            addCriterion("MBLNR between", value1, value2, "mblnr");
            return (Criteria) this;
        }

        public Criteria andMblnrNotBetween(String value1, String value2) {
            addCriterion("MBLNR not between", value1, value2, "mblnr");
            return (Criteria) this;
        }

        public Criteria andEbelpIsNull() {
            addCriterion("EBELP is null");
            return (Criteria) this;
        }

        public Criteria andEbelpIsNotNull() {
            addCriterion("EBELP is not null");
            return (Criteria) this;
        }

        public Criteria andEbelpEqualTo(Integer value) {
            addCriterion("EBELP =", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpNotEqualTo(Integer value) {
            addCriterion("EBELP <>", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpGreaterThan(Integer value) {
            addCriterion("EBELP >", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpGreaterThanOrEqualTo(Integer value) {
            addCriterion("EBELP >=", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpLessThan(Integer value) {
            addCriterion("EBELP <", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpLessThanOrEqualTo(Integer value) {
            addCriterion("EBELP <=", value, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpIn(List<Integer> values) {
            addCriterion("EBELP in", values, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpNotIn(List<Integer> values) {
            addCriterion("EBELP not in", values, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpBetween(Integer value1, Integer value2) {
            addCriterion("EBELP between", value1, value2, "ebelp");
            return (Criteria) this;
        }

        public Criteria andEbelpNotBetween(Integer value1, Integer value2) {
            addCriterion("EBELP not between", value1, value2, "ebelp");
            return (Criteria) this;
        }

        public Criteria andBudatIsNull() {
            addCriterion("BUDAT is null");
            return (Criteria) this;
        }

        public Criteria andBudatIsNotNull() {
            addCriterion("BUDAT is not null");
            return (Criteria) this;
        }

        public Criteria andBudatEqualTo(String value) {
            addCriterion("BUDAT =", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatNotEqualTo(String value) {
            addCriterion("BUDAT <>", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatGreaterThan(String value) {
            addCriterion("BUDAT >", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatGreaterThanOrEqualTo(String value) {
            addCriterion("BUDAT >=", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatLessThan(String value) {
            addCriterion("BUDAT <", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatLessThanOrEqualTo(String value) {
            addCriterion("BUDAT <=", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatLike(String value) {
            addCriterion("BUDAT like", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatNotLike(String value) {
            addCriterion("BUDAT not like", value, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatIn(List<String> values) {
            addCriterion("BUDAT in", values, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatNotIn(List<String> values) {
            addCriterion("BUDAT not in", values, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatBetween(String value1, String value2) {
            addCriterion("BUDAT between", value1, value2, "budat");
            return (Criteria) this;
        }

        public Criteria andBudatNotBetween(String value1, String value2) {
            addCriterion("BUDAT not between", value1, value2, "budat");
            return (Criteria) this;
        }

        public Criteria andCputmIsNull() {
            addCriterion("CPUTM is null");
            return (Criteria) this;
        }

        public Criteria andCputmIsNotNull() {
            addCriterion("CPUTM is not null");
            return (Criteria) this;
        }

        public Criteria andCputmEqualTo(String value) {
            addCriterion("CPUTM =", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmNotEqualTo(String value) {
            addCriterion("CPUTM <>", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmGreaterThan(String value) {
            addCriterion("CPUTM >", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmGreaterThanOrEqualTo(String value) {
            addCriterion("CPUTM >=", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmLessThan(String value) {
            addCriterion("CPUTM <", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmLessThanOrEqualTo(String value) {
            addCriterion("CPUTM <=", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmLike(String value) {
            addCriterion("CPUTM like", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmNotLike(String value) {
            addCriterion("CPUTM not like", value, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmIn(List<String> values) {
            addCriterion("CPUTM in", values, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmNotIn(List<String> values) {
            addCriterion("CPUTM not in", values, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmBetween(String value1, String value2) {
            addCriterion("CPUTM between", value1, value2, "cputm");
            return (Criteria) this;
        }

        public Criteria andCputmNotBetween(String value1, String value2) {
            addCriterion("CPUTM not between", value1, value2, "cputm");
            return (Criteria) this;
        }

        public Criteria andErsteldatIsNull() {
            addCriterion("ERSTELDAT is null");
            return (Criteria) this;
        }

        public Criteria andErsteldatIsNotNull() {
            addCriterion("ERSTELDAT is not null");
            return (Criteria) this;
        }

        public Criteria andErsteldatEqualTo(String value) {
            addCriterion("ERSTELDAT =", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatNotEqualTo(String value) {
            addCriterion("ERSTELDAT <>", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatGreaterThan(String value) {
            addCriterion("ERSTELDAT >", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatGreaterThanOrEqualTo(String value) {
            addCriterion("ERSTELDAT >=", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatLessThan(String value) {
            addCriterion("ERSTELDAT <", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatLessThanOrEqualTo(String value) {
            addCriterion("ERSTELDAT <=", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatLike(String value) {
            addCriterion("ERSTELDAT like", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatNotLike(String value) {
            addCriterion("ERSTELDAT not like", value, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatIn(List<String> values) {
            addCriterion("ERSTELDAT in", values, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatNotIn(List<String> values) {
            addCriterion("ERSTELDAT not in", values, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatBetween(String value1, String value2) {
            addCriterion("ERSTELDAT between", value1, value2, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErsteldatNotBetween(String value1, String value2) {
            addCriterion("ERSTELDAT not between", value1, value2, "ersteldat");
            return (Criteria) this;
        }

        public Criteria andErstelzeitIsNull() {
            addCriterion("ERSTELZEIT is null");
            return (Criteria) this;
        }

        public Criteria andErstelzeitIsNotNull() {
            addCriterion("ERSTELZEIT is not null");
            return (Criteria) this;
        }

        public Criteria andErstelzeitEqualTo(String value) {
            addCriterion("ERSTELZEIT =", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitNotEqualTo(String value) {
            addCriterion("ERSTELZEIT <>", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitGreaterThan(String value) {
            addCriterion("ERSTELZEIT >", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitGreaterThanOrEqualTo(String value) {
            addCriterion("ERSTELZEIT >=", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitLessThan(String value) {
            addCriterion("ERSTELZEIT <", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitLessThanOrEqualTo(String value) {
            addCriterion("ERSTELZEIT <=", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitLike(String value) {
            addCriterion("ERSTELZEIT like", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitNotLike(String value) {
            addCriterion("ERSTELZEIT not like", value, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitIn(List<String> values) {
            addCriterion("ERSTELZEIT in", values, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitNotIn(List<String> values) {
            addCriterion("ERSTELZEIT not in", values, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitBetween(String value1, String value2) {
            addCriterion("ERSTELZEIT between", value1, value2, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andErstelzeitNotBetween(String value1, String value2) {
            addCriterion("ERSTELZEIT not between", value1, value2, "erstelzeit");
            return (Criteria) this;
        }

        public Criteria andPastrtermIsNull() {
            addCriterion("PASTRTERM is null");
            return (Criteria) this;
        }

        public Criteria andPastrtermIsNotNull() {
            addCriterion("PASTRTERM is not null");
            return (Criteria) this;
        }

        public Criteria andPastrtermEqualTo(String value) {
            addCriterion("PASTRTERM =", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermNotEqualTo(String value) {
            addCriterion("PASTRTERM <>", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermGreaterThan(String value) {
            addCriterion("PASTRTERM >", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermGreaterThanOrEqualTo(String value) {
            addCriterion("PASTRTERM >=", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermLessThan(String value) {
            addCriterion("PASTRTERM <", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermLessThanOrEqualTo(String value) {
            addCriterion("PASTRTERM <=", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermLike(String value) {
            addCriterion("PASTRTERM like", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermNotLike(String value) {
            addCriterion("PASTRTERM not like", value, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermIn(List<String> values) {
            addCriterion("PASTRTERM in", values, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermNotIn(List<String> values) {
            addCriterion("PASTRTERM not in", values, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermBetween(String value1, String value2) {
            addCriterion("PASTRTERM between", value1, value2, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andPastrtermNotBetween(String value1, String value2) {
            addCriterion("PASTRTERM not between", value1, value2, "pastrterm");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1IsNull() {
            addCriterion("ERSTELZEIT1 is null");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1IsNotNull() {
            addCriterion("ERSTELZEIT1 is not null");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1EqualTo(String value) {
            addCriterion("ERSTELZEIT1 =", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1NotEqualTo(String value) {
            addCriterion("ERSTELZEIT1 <>", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1GreaterThan(String value) {
            addCriterion("ERSTELZEIT1 >", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1GreaterThanOrEqualTo(String value) {
            addCriterion("ERSTELZEIT1 >=", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1LessThan(String value) {
            addCriterion("ERSTELZEIT1 <", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1LessThanOrEqualTo(String value) {
            addCriterion("ERSTELZEIT1 <=", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1Like(String value) {
            addCriterion("ERSTELZEIT1 like", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1NotLike(String value) {
            addCriterion("ERSTELZEIT1 not like", value, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1In(List<String> values) {
            addCriterion("ERSTELZEIT1 in", values, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1NotIn(List<String> values) {
            addCriterion("ERSTELZEIT1 not in", values, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1Between(String value1, String value2) {
            addCriterion("ERSTELZEIT1 between", value1, value2, "erstelzeit1");
            return (Criteria) this;
        }

        public Criteria andErstelzeit1NotBetween(String value1, String value2) {
            addCriterion("ERSTELZEIT1 not between", value1, value2, "erstelzeit1");
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

        public Criteria andMeStatusIsNull() {
            addCriterion("ME_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMeStatusIsNotNull() {
            addCriterion("ME_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMeStatusEqualTo(String value) {
            addCriterion("ME_STATUS =", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotEqualTo(String value) {
            addCriterion("ME_STATUS <>", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusGreaterThan(String value) {
            addCriterion("ME_STATUS >", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ME_STATUS >=", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLessThan(String value) {
            addCriterion("ME_STATUS <", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLessThanOrEqualTo(String value) {
            addCriterion("ME_STATUS <=", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLike(String value) {
            addCriterion("ME_STATUS like", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotLike(String value) {
            addCriterion("ME_STATUS not like", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusIn(List<String> values) {
            addCriterion("ME_STATUS in", values, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotIn(List<String> values) {
            addCriterion("ME_STATUS not in", values, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusBetween(String value1, String value2) {
            addCriterion("ME_STATUS between", value1, value2, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotBetween(String value1, String value2) {
            addCriterion("ME_STATUS not between", value1, value2, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeMemoIsNull() {
            addCriterion("ME_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMeMemoIsNotNull() {
            addCriterion("ME_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMeMemoEqualTo(String value) {
            addCriterion("ME_MEMO =", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoNotEqualTo(String value) {
            addCriterion("ME_MEMO <>", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoGreaterThan(String value) {
            addCriterion("ME_MEMO >", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoGreaterThanOrEqualTo(String value) {
            addCriterion("ME_MEMO >=", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoLessThan(String value) {
            addCriterion("ME_MEMO <", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoLessThanOrEqualTo(String value) {
            addCriterion("ME_MEMO <=", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoLike(String value) {
            addCriterion("ME_MEMO like", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoNotLike(String value) {
            addCriterion("ME_MEMO not like", value, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoIn(List<String> values) {
            addCriterion("ME_MEMO in", values, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoNotIn(List<String> values) {
            addCriterion("ME_MEMO not in", values, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoBetween(String value1, String value2) {
            addCriterion("ME_MEMO between", value1, value2, "meMemo");
            return (Criteria) this;
        }

        public Criteria andMeMemoNotBetween(String value1, String value2) {
            addCriterion("ME_MEMO not between", value1, value2, "meMemo");
            return (Criteria) this;
        }

        public Criteria andNameOrg1IsNull() {
            addCriterion("NAME_ORG1 is null");
            return (Criteria) this;
        }

        public Criteria andNameOrg1IsNotNull() {
            addCriterion("NAME_ORG1 is not null");
            return (Criteria) this;
        }

        public Criteria andNameOrg1EqualTo(String value) {
            addCriterion("NAME_ORG1 =", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1NotEqualTo(String value) {
            addCriterion("NAME_ORG1 <>", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1GreaterThan(String value) {
            addCriterion("NAME_ORG1 >", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1GreaterThanOrEqualTo(String value) {
            addCriterion("NAME_ORG1 >=", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1LessThan(String value) {
            addCriterion("NAME_ORG1 <", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1LessThanOrEqualTo(String value) {
            addCriterion("NAME_ORG1 <=", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1Like(String value) {
            addCriterion("NAME_ORG1 like", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1NotLike(String value) {
            addCriterion("NAME_ORG1 not like", value, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1In(List<String> values) {
            addCriterion("NAME_ORG1 in", values, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1NotIn(List<String> values) {
            addCriterion("NAME_ORG1 not in", values, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1Between(String value1, String value2) {
            addCriterion("NAME_ORG1 between", value1, value2, "nameOrg1");
            return (Criteria) this;
        }

        public Criteria andNameOrg1NotBetween(String value1, String value2) {
            addCriterion("NAME_ORG1 not between", value1, value2, "nameOrg1");
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