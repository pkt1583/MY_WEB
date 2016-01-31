package com.test.service;

import com.test.dao.BaseDao;
import com.test.domain.ApplicationLinks;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class ApplicationService implements Serializable {

    @EJB(name = "baseDao")
    private BaseDao baseDao;

    public List<ApplicationLinks> getAllApplicationLinks(){
        return baseDao.getAllElements(ApplicationLinks.class);
    }


    public ApplicationLinks getApplicationLinkById(Integer id){
        return baseDao.findOneById(id, ApplicationLinks.class);
    }

    public ApplicationLinks getApplicationByLink(String s) {
        return null;
    }
}
