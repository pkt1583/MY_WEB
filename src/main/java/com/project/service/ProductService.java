package com.project.service;

import com.project.dao.ProductDao;
import com.project.domain.Product;
import com.project.domain.ProductCategory;
import com.project.web.model.ProductCategoryDto;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "ProductService")
@Transactional
public class ProductService {

    @Inject
    private ProductDao productDao;

    public List<Product> getProductByCategory(ProductCategory productCategory) {
        return null;
    }

    public List<ProductCategory> getAllCategories() {
        return null;
    }


    public List<ProductCategoryDto> getProductCategories() {
        List<ProductCategory> productCategories = productDao.getAllCategories();
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        productCategories.forEach(productCategory -> {
            ProductCategoryDto productCategoryDto = new ProductCategoryDto();
            productCategoryDto.setCategoryId(productCategory.getCategory_id());
            productCategoryDto.setCategoryName(productCategory.getName());
        });
        return productCategoryDtos;
    }
}
