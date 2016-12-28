import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ManagedBean
@SessionScoped
public class PaymentController implements Serializable {

    @EJB
    private PaymentService paymentService;

    @EJB
    private ShoppingCartService shoppingCartService;

    @EJB
    private OrderService orderService;

    private Set<PaymentType> paymentTypes = new HashSet<>();

    private PaymentType selectedPaymentType;

    private Payment paymentInfo;

    private Payment payment;

    private ShippingDetails shippingDetails = new ShippingDetails();

    public String loadOrderInformation(Integer cartId) {
        ProductOrder productOrder = shoppingCartService.getShoppingCart(cartId).getProductOrder();
        return "productOrderDisplay";
    }

    public String updateOrder(Integer cartId) {
        ShoppingCart cart = shoppingCartService.getShoppingCart(cartId);
        return "shoppingCart";
    }

    public String finalizeOrder(ProductOrder order) {
        orderService.finalizeOrder(order);
        return "paymentScreen";
    }

    public String getPaymentDetails(PaymentType paymentType) {
        if (paymentType.getPaymentTypeName().equals("CREDITCARD")) {
            payment = new CreditCardPayment();
            return "creditCardPayment";
        }
        return "nullPayment";
    }

    public String updateShippingDetails() {
        return null;
    }

    @PostConstruct
    public void loadPaymentType() {
        paymentTypes.addAll(paymentService.getPaymentTypes());
    }

    public String doPayment() {
        paymentInfo.setPaymentType(selectedPaymentType);
        if (paymentService.processPayment(paymentInfo)) {
            return "paymentSuccess";
        }
        return "paymentFailure";
    }

}
