package com.test.domain.convertor;

import com.test.domain.UserRoles;
import com.test.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "userRoleConverter")
@ApplicationScoped
public class UserRoleConvertor implements Converter {

    @Inject
    private UserService userService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s==null || s.isEmpty()){
            return null;
        }
        UserRoles userRoles = userService.getRoleById(s);
        return userRoles;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return "";
        }
        UserRoles roles = (UserRoles) o;
        return roles.getRoleId() + "";
    }
}
