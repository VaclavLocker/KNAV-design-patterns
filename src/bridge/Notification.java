package bridge;

import java.util.Objects;

public abstract class Notification {

    private final NotificationChannel channel;

    protected Notification(NotificationChannel channel) {
        this.channel = Objects.requireNonNull(channel, "Channel is required");
    }

    public void sendTo(String recipient) {
        channel.send(requireText(recipient, "Recipient is required"), createMessage());
    }

    protected abstract String createMessage();

    protected static String requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
