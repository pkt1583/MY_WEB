import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless(name = "ProductService")
@Transactional
public class ProductService {

    @Inject
    private ProductDao productDao;

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
        List<ProductCategory> productCategories = productDao.getAllCategories();
       /* productCategories.forEach(productCategory -> {
            ProductCategoryDto productCategoryDto = new ProductCategoryDto();
            productCategoryDto.setCategoryId(productCategory.getCategory_id());
            productCategoryDto.setCategoryName(productCategory.getName());
            productCategoryDtos.add(productCategoryDto);
        });*/
        return productCategories;
    }

    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    public ProductDetail getProductProductDetailsByProductId(Integer productId) {
        return productDao.getProductDetails(productId);
    }
}
