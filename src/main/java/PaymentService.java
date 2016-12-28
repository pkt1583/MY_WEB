import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class PaymentService {
    public Collection<? extends PaymentType> getPaymentTypes() {
        return null;
    }

    public boolean processPayment(Payment paymentInfo) {

        return false;
    }
}
