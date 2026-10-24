package bridge;

public final class ShippingNotice extends Notification {

    private final String trackingNumber;

    public ShippingNotice(NotificationChannel channel, String trackingNumber) {
        super(channel);
        this.trackingNumber = requireText(trackingNumber, "Tracking number is required");
    }

    @Override
    protected String createMessage() {
        return "Your package is on its way, tracking number " + trackingNumber + ".";
    }
}
