package bridge;

public final class SmsChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS to " + recipient + ": " + message);
    }
}
