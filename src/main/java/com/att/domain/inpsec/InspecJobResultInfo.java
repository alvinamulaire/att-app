package com.att.domain.inpsec;

import com.att.repository.entity.ZVwQmsInspecJobResult;

import java.util.List;

public class InspecJobResultInfo extends ZVwQmsInspecJobResult {

    private List<String> snList;

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList( List<String> snList ) {
        this.snList = snList;
    }
}
