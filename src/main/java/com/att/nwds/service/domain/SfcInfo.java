package com.att.nwds.service.domain;

import java.math.BigDecimal;
import java.util.List;

public class SfcInfo {

    private String itemBo;

    private String shopOrderBo;

    private BigDecimal qty;

    private String routerBo;

    private List<BomComponent> bomComponentList;

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo(String itemBo) {
        this.itemBo = itemBo;
    }

    public String getShopOrderBo() {
        return shopOrderBo;
    }

    public void setShopOrderBo( String shopOrderBo ) {
        this.shopOrderBo = shopOrderBo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty( BigDecimal qty ) {
        this.qty = qty;
    }

    public String getRouterBo() {
        return routerBo;
    }

    public void setRouterBo(String routerBo) {
        this.routerBo = routerBo;
    }

    public List<BomComponent> getBomComponentList() {
        return bomComponentList;
    }

    public void setBomComponentList( List<BomComponent> bomComponentList ) {
        this.bomComponentList = bomComponentList;
    }
}
