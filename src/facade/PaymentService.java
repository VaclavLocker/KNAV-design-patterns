package facade;

public final class PaymentService {

    public void charge(String customer, int amountCzk) {
        System.out.println("Payment: charged " + amountCzk + " CZK to " + customer);
    }

    public void refund(String customer, int amountCzk) {
        System.out.println("Payment: refunded " + amountCzk + " CZK to " + customer);
    }
}
