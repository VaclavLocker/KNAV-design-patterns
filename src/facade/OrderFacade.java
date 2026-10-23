package facade;

import java.util.Objects;
import java.util.Optional;

public final class OrderFacade {

    private final InventoryService inventory;
    private final PaymentService payment;
    private final ShippingService shipping;
    private final EmailService email;

    public OrderFacade(InventoryService inventory, PaymentService payment,
                       ShippingService shipping, EmailService email) {
        this.inventory = Objects.requireNonNull(inventory, "Inventory service is required");
        this.payment = Objects.requireNonNull(payment, "Payment service is required");
        this.shipping = Objects.requireNonNull(shipping, "Shipping service is required");
        this.email = Objects.requireNonNull(email, "Email service is required");
    }

    public Optional<Order> placeOrder(String customer, String model, int priceCzk) {
        requireText(customer, "Customer is required");
        requireText(model, "Model is required");
        if (priceCzk <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        System.out.println("Placing order: " + model + " for " + customer);
        if (!inventory.reserve(model)) {
            email.send(customer, "Sorry, " + model + " is currently out of stock.");
            return Optional.empty();
        }
        payment.charge(customer, priceCzk);
        String trackingNumber = shipping.createShipment(customer, model);
        email.send(customer, "Your " + model + " is on its way, tracking number " + trackingNumber + ".");
        return Optional.of(new Order(customer, model, priceCzk, trackingNumber));
    }

    public void cancelOrder(Order order) {
        Objects.requireNonNull(order, "Order is required");

        System.out.println("Cancelling order: " + order.model() + " for " + order.customer());
        shipping.cancelShipment(order.trackingNumber());
        payment.refund(order.customer(), order.priceCzk());
        inventory.release(order.model());
        email.send(order.customer(), "Your order of " + order.model() + " has been cancelled.");
    }

    private static void requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
