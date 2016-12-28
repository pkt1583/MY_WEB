import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProductController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    private List<ProductCategory> productCategories;
    private List<Product> products = new ArrayList<>();
    private Product selectedProduct = new Product();
    private int selectedProductCategory;
    private ProductDetail detailedProduct;
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
        List<ProductCategory> productCategoryDtos = productService.getProductCategories();
        this.productCategories = productCategoryDtos;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public void getProductByCategory(Integer categoryId) {
        for(int i=0;i<100;i++) {
            List<Product> products = productService.getProductByCategory(categoryId);
            products.clear();
        }
        this.products.addAll(products);
    }


    public void getProductDetails(Integer productId) {
        ProductDetail product = productService.getProductProductDetailsByProductId(productId);
        this.detailedProduct = product;
    }

    public ProductDetail getDetailedProduct() {
        return detailedProduct;
    }

    public void setDetailedProduct(ProductDetail detailedProduct) {
        this.detailedProduct = detailedProduct;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
