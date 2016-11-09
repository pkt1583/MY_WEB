package com.project.service;

import com.project.domain.Product;
import com.project.domain.ProductCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless(name = "ProductService")
public class DefaultProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> getProductByCategory(ProductCategory productCategory) {
        return null;
    }

    public List<ProductCategory> getAllCategories() {
        return null;
    }
}
