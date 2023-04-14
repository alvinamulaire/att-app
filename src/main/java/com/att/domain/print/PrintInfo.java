package com.att.domain.print;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;

public class PrintInfo extends BaseInfo {

    private String printName;
    private String printLabel;
    private String printType;
    // 箱號使用
    private String item;
    private String rev;
    private String mfgDate;
    private String shopOrder;
    private String expDate;
    private String carton;
    private String dmxDate1;
    private String dmxDate2;
    private String dmxDate3;
    private String dmxExpDate1;
    private String dmxExpDate2;
    private String dmxExpDate3;
    private String isMantissa;
    private List<String> cartons;
    // 棧板使用
    private List<String> pallets;
    private String activity;

    public String getPrintName() {
        return printName;
    }

    public void setPrintName( String printName ) {
        this.printName = printName;
    }

    public String getPrintLabel() {
        return printLabel;
    }

    public void setPrintLabel( String printLabel ) {
        this.printLabel = printLabel;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType( String printType ) {
        this.printType = printType;
    }

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getRev() {
        return rev;
    }

    public void setRev( String rev ) {
        this.rev = rev;
    }

    public String getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate( String mfgDate ) {
        this.mfgDate = mfgDate;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder( String shopOrder ) {
        this.shopOrder = shopOrder;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate( String expDate ) {
        this.expDate = expDate;
    }

    public String getCarton() {
        return carton;
    }

    public void setCarton( String carton ) {
        this.carton = carton;
    }

    public String getDmxDate1() {
        return dmxDate1;
    }

    public void setDmxDate1( String dmxDate1 ) {
        this.dmxDate1 = dmxDate1;
    }

    public String getDmxDate2() {
        return dmxDate2;
    }

    public void setDmxDate2( String dmxDate2 ) {
        this.dmxDate2 = dmxDate2;
    }

    public String getDmxDate3() {
        return dmxDate3;
    }

    public void setDmxDate3( String dmxDate3 ) {
        this.dmxDate3 = dmxDate3;
    }

    public String getDmxExpDate1() {
        return dmxExpDate1;
    }

    public void setDmxExpDate1( String dmxExpDate1 ) {
        this.dmxExpDate1 = dmxExpDate1;
    }

    public String getDmxExpDate2() {
        return dmxExpDate2;
    }

    public void setDmxExpDate2( String dmxExpDate2 ) {
        this.dmxExpDate2 = dmxExpDate2;
    }

    public String getDmxExpDate3() {
        return dmxExpDate3;
    }

    public void setDmxExpDate3( String dmxExpDate3 ) {
        this.dmxExpDate3 = dmxExpDate3;
    }

    public String getIsMantissa() {
        return isMantissa;
    }

    public void setIsMantissa( String isMantissa ) {
        this.isMantissa = isMantissa;
    }

    public List<String> getCartons() {
        return cartons;
    }

    public void setCartons( List<String> cartons ) {
        this.cartons = cartons;
    }

    public List<String> getPallets() {
        return pallets;
    }

    public void setPallets( List<String> pallets ) {
        this.pallets = pallets;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }
}
