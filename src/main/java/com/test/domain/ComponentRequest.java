package com.test.domain;

import com.test.domain.Component;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "component",schema = "assign")
public class ComponentRequest {

    @Id
    private int componentId;


//    private List<Component> component;

    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee employee;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "componentRequest")
    private List<Bid> bids;

}
