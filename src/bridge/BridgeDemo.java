package bridge;

public class BridgeDemo {

    public static void main(String[] args) {
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();

        Notification confirmationByEmail = new OrderConfirmation(email, "ORD-1001");
        confirmationByEmail.sendTo("petr@example.com");

        Notification confirmationBySms = new OrderConfirmation(sms, "ORD-1001");
        confirmationBySms.sendTo("+420 777 123 456");

        Notification shippingByEmail = new ShippingNotice(email, "PKG-5521");
        shippingByEmail.sendTo("petr@example.com");

        Notification shippingBySms = new ShippingNotice(sms, "PKG-5521");
        shippingBySms.sendTo("+420 777 123 456");
    }
}
