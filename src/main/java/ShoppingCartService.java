import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.Set;

@Stateful
public class ShoppingCartService {
    private Customer customer;
    private ShoppingCart cart = new ShoppingCart();

    @Inject
    private InventoryService inventoryService;

    @Inject
    private OrderService orderService;

    public ShoppingCart getShoppingCart(Integer shoppingCartId) {
        return new ShoppingCart();
    }

    public ShoppingCart addProduct(Product product, Integer quantity) {
        Inventory inventory = inventoryService.getProductInventoryDetails(product);
        inventoryService.updateProduct(inventory, quantity);
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setProduct(product);
        orderLineItem.setQuantity(quantity);
        cart.addOrderLineItem(orderLineItem);
        return cart;
    }

    public boolean checkout(ShoppingCart shoppingCart) {
        orderService.createOrder(cart);
        return true;
    }

    public ShoppingCart updateProduct(Product product, Integer quantity) {
        Set<OrderLineItem> orderLineItems = cart.getOrderLineItems();
        for (OrderLineItem orderLineItem : orderLineItems) {
            Product lineItemProduct = orderLineItem.getProduct();
            if (lineItemProduct.equals(product)) {
                inventoryService.updateProduct(inventoryService.getProductInventoryDetails(product), quantity);
                orderLineItem.setQuantity(quantity);
            }
        }
        return cart;
    }

    public ShoppingCart removeProduct(Product product) {
        //remove product and return updated cart
        return cart;
    }
}
