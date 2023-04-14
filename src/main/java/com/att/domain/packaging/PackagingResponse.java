package com.att.domain.packaging;

import java.util.List;

public class PackagingResponse {

    private PackagingMaster master;

    private List<PackagingDetail> detail;

    private int sfcPackedQty;

    private int sfcQty;

    private int packedQty;

    private List<String> prefixList;

    private List<String> suffixList;

    public PackagingMaster getMaster() {
        return master;
    }

    public void setMaster( PackagingMaster master ) {
        this.master = master;
    }

    public List<PackagingDetail> getDetail() {
        return detail;
    }

    public void setDetail( List<PackagingDetail> detail ) {
        this.detail = detail;
    }

    public int getSfcPackedQty() {
        return sfcPackedQty;
    }

    public void setSfcPackedQty( int sfcPackedQty ) {
        this.sfcPackedQty = sfcPackedQty;
    }

    public int getSfcQty() {
        return sfcQty;
    }

    public void setSfcQty( int sfcQty ) {
        this.sfcQty = sfcQty;
    }

    public int getPackedQty() {
        return packedQty;
    }

    public void setPackedQty( int packedQty ) {
        this.packedQty = packedQty;
    }

    public List<String> getPrefixList() {
        return prefixList;
    }

    public void setPrefixList( List<String> prefixList ) {
        this.prefixList = prefixList;
    }

    public List<String> getSuffixList() {
        return suffixList;
    }

    public void setSuffixList( List<String> suffixList ) {
        this.suffixList = suffixList;
    }
}
