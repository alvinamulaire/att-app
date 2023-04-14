package com.att.nwds.service.domain;

import com.fw.mes.util.FwUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BomComponent {

    private String componentBo;

    private String itemBo;

    private BigDecimal qty;

    private String location;

    private List<String> alternateItemBoList;

    public String getComponentBo() {
        return componentBo;
    }

    public void setComponentBo( String componentBo ) {
        this.componentBo = componentBo;
    }

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo( String itemBo ) {
        this.itemBo = itemBo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty( BigDecimal qty ) {
        this.qty = qty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public List<String> getAlternateItemBoList() {
        if(this.alternateItemBoList == null){
            this.alternateItemBoList = new ArrayList<>();
        }
        return alternateItemBoList;
    }

    public void setAlternateItemBoList( List<String> alternateItemBoList ) {
        this.alternateItemBoList = alternateItemBoList;
    }
}
