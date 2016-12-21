package com.project.controller;


import com.project.domain.Product;
import com.project.service.ProductService;
import com.project.web.model.ProductCategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class SearchController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    private List<ProductCategoryDto> productCategories;
    private List<Product> products = new ArrayList<>();
    private Product selectedProduct = new Product();
    private int selectedProductCategory;
    @EJB
    private ProductService productService;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getSelectedProductCategory() {
        return selectedProductCategory;
    }

    public void setSelectedProductCategory(int selectedProductCategory) {
        this.selectedProductCategory = selectedProductCategory;
    }

    @PostConstruct
    public void populateProductCategories() {
        List<ProductCategoryDto> productCategoryDtos = productService.getProductCategories();
        this.productCategories = productCategoryDtos;
    }

    public List<ProductCategoryDto> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategoryDto> productCategories) {
        this.productCategories = productCategories;
    }

    public void populateProducts(ActionEvent event) {
        List<Product> products = productService.getProductByCategory(selectedProductCategory);
        products.clear();
        this.products.addAll(products);
    }

}
