package com.project.dao;

import com.project.domain.Product;
import com.project.domain.ProductCategory;
import com.project.domain.ProductDetail;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ProductDao  {

   @Inject
   private EntityManager entityManager;

    public List<ProductCategory> getAllCategories() {

        return new ArrayList<>();
    }

    public List<Product> getProductByCategoryId(Integer productCategoryId) {
        return new ArrayList<>();
    }


    public ProductDetail getProductDetails(Integer productId) {
        return new ProductDetail();
    }
}
