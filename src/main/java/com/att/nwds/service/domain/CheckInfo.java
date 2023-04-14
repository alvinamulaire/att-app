package com.att.nwds.service.domain;

import java.math.BigDecimal;

public class CheckInfo {

    private BigDecimal demandQty;

    private boolean flag;

    public BigDecimal getDemandQty() {
        return demandQty;
    }

    public void setDemandQty( BigDecimal demandQty ) {
        this.demandQty = demandQty;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag( boolean flag ) {
        this.flag = flag;
    }
}
