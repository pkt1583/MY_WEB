package com.test.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Employee", schema = "assign")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int employeeId;
    @OneToMany(mappedBy = "employee")
    private Set<ComponentRequest> componentRequests;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Set<ComponentRequest> getComponentRequests() {
        return componentRequests;
    }

    public void setComponentRequests(Set<ComponentRequest> componentRequests) {
        this.componentRequests = componentRequests;
    }

}
