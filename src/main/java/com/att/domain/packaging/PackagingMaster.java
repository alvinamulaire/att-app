package com.att.domain.packaging;

import com.att.repository.entity.ZPackMaster;

import java.util.List;

public class PackagingMaster extends ZPackMaster {

    private String containerDesc;

    private String closeDateStart;

    private String closeDateEnd;

    private List<String> cartonList;

    public String getContainerDesc() {
        return containerDesc;
    }

    public void setContainerDesc( String containerDesc ) {
        this.containerDesc = containerDesc;
    }

    public String getCloseDateStart() {
        return closeDateStart;
    }

    public void setCloseDateStart(String closeDateStart) {
        this.closeDateStart = closeDateStart;
    }

    public String getCloseDateEnd() {
        return closeDateEnd;
    }

    public void setCloseDateEnd(String closeDateEnd) {
        this.closeDateEnd = closeDateEnd;
    }

    public List<String> getCartonList() {
        return cartonList;
    }

    public void setCartonList( List<String> cartonList ) {
        this.cartonList = cartonList;
    }
}
