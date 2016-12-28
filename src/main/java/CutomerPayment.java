import javax.persistence.*;

@Entity
public class CutomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerPaymentId;

    @OneToOne
    private Customer customer;
    @OneToOne
    private Payment payment;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Integer getCustomerPaymentId() {
        return customerPaymentId;
    }

    public void setCustomerPaymentId(Integer customerPaymentId) {
        this.customerPaymentId = customerPaymentId;
    }
}
