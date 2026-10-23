package facade;

public final class ShippingService {

    private int lastTrackingNumber = 5000;

    public String createShipment(String customer, String model) {
        String trackingNumber = "PKG-" + (++lastTrackingNumber);
        System.out.println("Shipping: " + model + " for " + customer + ", tracking number " + trackingNumber);
        return trackingNumber;
    }

    public void cancelShipment(String trackingNumber) {
        System.out.println("Shipping: cancelled " + trackingNumber);
    }
}
