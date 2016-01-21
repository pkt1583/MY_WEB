package com.test.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "supplier", schema = "assign")
public class Supplier {
    @Id
    @Column(name = "supplierId")
    private int supplierId;
    @Column(name = "supplierName")
    private String supplierName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Bid> bids;

}
