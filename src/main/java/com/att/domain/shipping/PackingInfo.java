package com.att.domain.shipping;

import com.att.repository.entity.ZVwShopOrderPackingInfo;

import java.util.List;

public class PackingInfo extends ZVwShopOrderPackingInfo {

    private String lan;

    private String planStartDate;

    private String planEndDate;

    private List<String> cartonNoList;

    private List<String> palletNoList;

    private List<String> snList;

    public String getLan() {
        return lan;
    }

    public void setLan( String lan ) {
        this.lan = lan;
    }

    public String getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate( String planStartDate ) {
        this.planStartDate = planStartDate;
    }

    public String getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate( String planEndDate ) {
        this.planEndDate = planEndDate;
    }

    public List<String> getCartonNoList() {
        return cartonNoList;
    }

    public void setCartonNoList( List<String> cartonNoList ) {
        this.cartonNoList = cartonNoList;
    }

    public List<String> getPalletNoList() {
        return palletNoList;
    }

    public void setPalletNoList( List<String> palletNoList ) {
        this.palletNoList = palletNoList;
    }

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList( List<String> snList ) {
        this.snList = snList;
    }
}
