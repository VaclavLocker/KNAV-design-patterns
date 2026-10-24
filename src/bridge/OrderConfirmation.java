package bridge;

public final class OrderConfirmation extends Notification {

    private final String orderNumber;

    public OrderConfirmation(NotificationChannel channel, String orderNumber) {
        super(channel);
        this.orderNumber = requireText(orderNumber, "Order number is required");
    }

    @Override
    protected String createMessage() {
        return "Your order " + orderNumber + " has been confirmed.";
    }
}
