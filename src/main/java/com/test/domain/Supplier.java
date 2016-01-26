package com.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supplier", schema = "assign")
public class Supplier {
    @Id
    @Column(name = "supplierId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int supplierId;
    @Column(name = "supplierName")
    private String supplierName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Bid> bids;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

}
