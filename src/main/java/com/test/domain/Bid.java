package com.test.domain;

import javax.persistence.*;

@Entity
@Table(name = "bid", schema = "assign")
public class Bid {
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ComponentRequest getComponentRequest() {
        return componentRequest;
    }

    public void setComponentRequest(ComponentRequest componentRequest) {
        this.componentRequest = componentRequest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private ComponentRequest componentRequest;

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }
}
