package com.att.domain.sfcDone;

import com.att.repository.entity.ZVwSfcDone;

import java.math.BigDecimal;

public class SfcDoneInfo extends ZVwSfcDone {

    private BigDecimal qty;

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty( BigDecimal qty ) {
        this.qty = qty;
    }
}
