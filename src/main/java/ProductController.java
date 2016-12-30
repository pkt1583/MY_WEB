import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProductController {

    private List<ProductCategory> productCategories;
    private List<Product> products = new ArrayList<>();
    private ProductService productService = new ProductService();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
        List<Product> products = productService.getProductByCategory(categoryId);
        products.clear();
        this.products.addAll(products);
    }


    public void getProductDetails(Integer productId) {
        ProductDetail product = productService.getProductProductDetailsByProductId(productId);
    }


    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
