import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Inventory implements Serializable {

    @Id
    private Integer InventoryId;
    @Basic
    private int currentStock;

    @OneToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        InventoryId = inventoryId;
    }
}
