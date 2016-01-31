package com.test.domain.convertor;

import com.test.domain.ApplicationLinks;
import com.test.service.ApplicationService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "applicationLinkConverter")
@ApplicationScoped
public class ApplicationLinksConverter implements Converter {
    @Inject
    private ApplicationService applicationService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ApplicationLinks applicationLinks=applicationService.getApplicationLinkById(Integer.parseInt(s));
        return applicationLinks;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        ApplicationLinks applicationLinks=(ApplicationLinks)o;
        return applicationLinks.getLinkId()+"";
    }
}
