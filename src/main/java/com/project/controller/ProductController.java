package com.project.controller;


import com.project.domain.Product;
import com.project.domain.ProductCategory;
import com.project.domain.ProductDetail;
import com.project.service.ProductService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProductController {

    private List<ProductCategory> productCategories;
    private List<Product> products = new ArrayList<>();
    private Product selectedProduct = new Product();
    private Integer selectedProductCategory = null;

    private ProductDetail productDetail;

    @EJB
    private ProductService productService;

    public String displayProductCategories() {
        productCategories.addAll(productService.getAllCategories());
        return "displayProductCategory";
    }

    public String diplayProductsByCategory() {
        products.addAll(productService.getProductByCategory(selectedProductCategory));
        return "displayProducts";
    }

    public String getProduct(int productId) {
        productDetail = productService.getProductDetails(productId);
        return "detailsScreen";
    }

    public String addProductToCart(){
        return "shoppingCart";
    }

}
