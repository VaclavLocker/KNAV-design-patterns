package facade;

public final class EmailService {

    public void send(String customer, String message) {
        System.out.println("Email to " + customer + ": " + message);
    }
}
