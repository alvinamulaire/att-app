package com.att.domain.packagingProduct;

import java.util.List;

public class ProductRequest {

    private String site;

    private String item;

    private List<PackagingProductRequest> productRequestList;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public List<PackagingProductRequest> getProductRequestList() {
        return productRequestList;
    }

    public void setProductRequestList( List<PackagingProductRequest> productRequestList ) {
        this.productRequestList = productRequestList;
    }
}
