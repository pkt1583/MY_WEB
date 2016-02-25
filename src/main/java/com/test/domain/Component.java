package com.test.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int componentId;


    private String componentName;

    @ManyToMany(mappedBy = "components")
    private List<ComponentRequest> componentRequests = new ArrayList<>();

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public List<ComponentRequest> getComponentRequests() {
        return componentRequests;
    }

    public void setComponentRequests(List<ComponentRequest> componentRequests) {
        this.componentRequests = componentRequests;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}
