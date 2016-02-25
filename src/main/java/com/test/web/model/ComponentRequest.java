package com.test.web.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Named(value = "componentRequest")
@SessionScoped
public class ComponentRequest implements Serializable {


    private List<EmployeeComponentRequest> componentRequestList = new LinkedList<>();

    public List<EmployeeComponentRequest> getComponentRequestList() {
        return componentRequestList;
    }

    public void setComponentRequestList(List<EmployeeComponentRequest> componentRequestList) {
        this.componentRequestList = componentRequestList;
    }

    public void add(EmployeeComponentRequest componentRequest) {
        componentRequestList.add(componentRequest);
    }

    public void add(){
        System.out.println("Don't know what to do");
    }

    public void removeComponent(EmployeeComponentRequest componentRequest) {
        componentRequestList.remove(componentRequest);
    }
}
