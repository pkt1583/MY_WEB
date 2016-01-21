package com.test.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee",schema = "assign")
public class Employee {
    @Id
    private int employeeId;

    @OneToMany(mappedBy = "employee")
    private Set<ComponentRequest> componentRequests;

}
