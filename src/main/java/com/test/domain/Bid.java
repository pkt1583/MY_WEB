package com.test.domain;

import javax.persistence.*;

@Entity
@Table(name = "bid", schema = "assign")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private ComponentRequest componentRequest;

}
