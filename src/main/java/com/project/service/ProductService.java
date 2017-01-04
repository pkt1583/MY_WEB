package com.project.service;

import com.project.dao.ProductDao;
import com.project.domain.Product;
import com.project.domain.ProductCategory;
import com.project.domain.ProductDetail;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless(name = "ProductService")
@Transactional
public class ProductService {

    @Inject
    private ProductDao productDao;

    public List<Product> getProductByCategory(Integer productCategoryId) {
        List<Product> products = productDao.getProductByCategoryId(productCategoryId);
        return products;
    }

    public List<ProductCategory> getAllCategories() {
        List<ProductCategory> productCategories = productDao.getAllCategories();
        return productCategories;
    }


    public ProductDetail getProductDetails(Integer productId) {
        return productDao.getProductDetails(productId);
    }
}
