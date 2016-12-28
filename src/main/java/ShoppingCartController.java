import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ShoppingCartController implements Serializable {
    @EJB
    private InventoryService inventoryService;

    @EJB
    private ShoppingCartService cart;

    private ShoppingCart shoppingCart = new ShoppingCart();

    private double totalAmount = 0.0;

    public String addProductToCart(Product product, Integer quantity) {
        if (inventoryService.isProductAvailable(product) != null) {
            this.shoppingCart = cart.addProduct(product, quantity);
            totalAmount = totalAmount + 1.0; //should be product getCost
        }
        return null;
    }

    public String updateCart(Product product, Integer quantity) {
        cart.updateProduct(product, quantity);
        return null;
    }

    public String removeProduct(Product product) {
        cart.removeProduct(product);
        return null;
    }

    public String checkout() {
        cart.checkout(shoppingCart);
        return null;
    }
}
