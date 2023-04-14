package com.att.domain.packaging;

import com.att.repository.entity.ZPackDetail;

public class PackagingDetail extends ZPackDetail {

    private String item;

    private String itemDesc;

    private long cartonQty;

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc( String itemDesc ) {
        this.itemDesc = itemDesc;
    }

    public long getCartonQty() {
        return cartonQty;
    }

    public void setCartonQty( long cartonQty ) {
        this.cartonQty = cartonQty;
    }
}
