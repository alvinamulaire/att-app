package com.att.domain.nc;

import com.att.repository.entity.ZVwSfcNcData;

public class SfcNcDataInfo extends ZVwSfcNcData {

    private String date;

    private String time;

    private String user;

    private String userName;

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }
}
