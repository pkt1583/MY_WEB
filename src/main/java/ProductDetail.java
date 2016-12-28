import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductDetail {

    @Id
    private Integer productDetailId;

    @OneToOne
    private Product product;

    @Basic
    private String productionApprovals;
    @Basic

    private String productAdditionalDescription;

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductionApprovals() {
        return productionApprovals;
    }

    public void setProductionApprovals(String productionApprovals) {
        this.productionApprovals = productionApprovals;
    }

    public String getProductAdditionalDescription() {
        return productAdditionalDescription;
    }

    public void setProductAdditionalDescription(String productAdditionalDescription) {
        this.productAdditionalDescription = productAdditionalDescription;
    }

}
