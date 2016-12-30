import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless(name = "ProductService")
@Transactional
public class ProductService {

    private ProductDao productDao=new ProductDao();

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProductByCategory(Integer productCategoryId) {
        List<Product> products = productDao.getProductByCategoryId(productCategoryId);
        return products;
    }

    public List<ProductCategory> getAllCategories() {
        return null;
    }


    public List<ProductCategory> getProductCategories() {
    	ProductDao newProdDao=new ProductDao();
        List<ProductCategory> productCategories = newProdDao.getAllCategories();
        return productCategories;
    }

    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    public ProductDetail getProductProductDetailsByProductId(Integer productId) {
        return productDao.getProductDetails(productId);
    }
}
