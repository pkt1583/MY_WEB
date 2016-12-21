package com.project.dao;

import com.project.domain.Product;
import com.project.domain.ProductCategory;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.util.List;


@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ProductDao  {

    @Inject
    private BaseDao baseDao;

    public List<ProductCategory> getAllCategories() {
        return baseDao.getAllElements(ProductCategory.class);
    }

    public List<Product> getProductByCategoryId(Integer productCategoryId) {
        ProductCategory productCategory=new ProductCategory();
        productCategory= baseDao.findOneById(productCategoryId,ProductCategory.class);
       return productCategory.getProducts();
    }

    public Product getProductById(Integer productId) {
        return baseDao.findOneById(productId,Product.class);
    }
}
