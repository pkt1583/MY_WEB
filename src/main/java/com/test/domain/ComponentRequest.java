package com.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component", schema = "assign")
public class ComponentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int componentId;
    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee employee;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componentRequest")
    private List<Bid> bids;

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


//    private List<Component> component;

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

}
