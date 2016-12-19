package com.project.controller;


import com.project.domain.ProductCategory;
import com.project.service.ProductService;
import com.project.web.model.ProductCategoryDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class SearchController {


    @Inject
    private ProductService productService;

    public String getProductCategories() {
       List<ProductCategoryDto> productCategoryDtos= productService.getProductCategories();
       return null;
    }
}
