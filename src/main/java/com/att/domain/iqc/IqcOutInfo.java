package com.att.domain.iqc;

import com.att.mssql.repository.entity.IqcOutbound;

import java.util.List;

public class IqcOutInfo extends IqcOutbound {

    private List<String> meStatusList;

    public List<String> getMeStatusList() {
        return meStatusList;
    }

    public void setMeStatusList( List<String> meStatusList ) {
        this.meStatusList = meStatusList;
    }
}
