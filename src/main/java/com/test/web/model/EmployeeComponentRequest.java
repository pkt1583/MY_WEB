package com.test.web.model;

import com.test.domain.Component;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

public class EmployeeComponentRequest implements Serializable {

    private Component component;
    private Integer numberOfComponent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeComponentRequest that = (EmployeeComponentRequest) o;

        if (component != null ? !component.equals(that.component) : that.component != null) return false;
        return numberOfComponent != null ? numberOfComponent.equals(that.numberOfComponent) : that.numberOfComponent == null;

    }

    @Override
    public int hashCode() {
        int result = component != null ? component.hashCode() : 0;
        result = 31 * result + (numberOfComponent != null ? numberOfComponent.hashCode() : 0);
        return result;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Integer getNumberOfComponent() {
        return numberOfComponent;
    }

    public void setNumberOfComponent(Integer numberOfComponent) {
        this.numberOfComponent = numberOfComponent;
    }
}
