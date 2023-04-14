package com.att.domain.nc;

import java.math.BigDecimal;

public class NcInfo {

    private String ncCode;

    private BigDecimal ncQty;

    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode( String ncCode ) {
        this.ncCode = ncCode;
    }

    public BigDecimal getNcQty() {
        return ncQty;
    }

    public void setNcQty( BigDecimal ncQty ) {
        this.ncQty = ncQty;
    }
}
