import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderService {

    @Inject
    private OrderDao orderDao;


    public ProductOrder createOrder(ShoppingCart cart) {
        return new ProductOrder();
    }

    public void finalizeOrder(ProductOrder order) {

    }
}
