package com.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "componentRequest", schema = "assign")
public class ComponentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee employee;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componentRequest")
    private List<Bid> bids;
    @ManyToMany
    @JoinTable(name = "REQUEST_COMPONENT", schema = "assign", joinColumns = {@JoinColumn(name = "REQUEST_ID", referencedColumnName = "requestId")}, inverseJoinColumns = {@JoinColumn(name = "COMPONENT_ID", referencedColumnName = "componentId")})
    private List<Component> components;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
