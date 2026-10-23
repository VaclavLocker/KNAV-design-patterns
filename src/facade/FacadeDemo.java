package facade;

import java.util.Map;
import java.util.Optional;

public class FacadeDemo {

    public static void main(String[] args) {
        OrderFacade eshop = new OrderFacade(
                new InventoryService(Map.of("iPhone 16 Pro", 1)),
                new PaymentService(),
                new ShippingService(),
                new EmailService());

        Optional<Order> eliskaOrder = eshop.placeOrder("eliska@example.com", "iPhone 16 Pro", 32990);

        System.out.println();
        eshop.placeOrder("petr@example.com", "iPhone 16 Pro", 32990);

        System.out.println();
        eliskaOrder.ifPresent(eshop::cancelOrder);
    }
}
