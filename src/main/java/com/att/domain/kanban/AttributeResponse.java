package com.att.domain.kanban;

public class AttributeResponse extends AttributeRequest {

    private String description;

    private String itemDesc;

    private String router;

    private String routerRevision;

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc( String itemDesc ) {
        this.itemDesc = itemDesc;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter( String router ) {
        this.router = router;
    }

    public String getRouterRevision() {
        return routerRevision;
    }

    public void setRouterRevision( String routerRevision ) {
        this.routerRevision = routerRevision;
    }
}
