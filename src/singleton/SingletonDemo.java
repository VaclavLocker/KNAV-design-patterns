package singleton;

import builder.Phone;

public class SingletonDemo {

    public static void main(String[] args) {
        Phone iphone = Phone.builder("Apple", "iPhone 16 Pro").storage(256).ram(8).build();
        Phone samsung = Phone.builder("Samsung", "Galaxy A15").build();

        receiveGoods(iphone, 5);
        receiveGoods(samsung, 10);

        sell("E-shop", "iPhone 16 Pro", 2);
        sell("Branch", "iPhone 16 Pro", 4);
        sell("Branch", "Galaxy A15", 3);

        System.out.println();
        PhoneWarehouse.getInstance().printStock();

        PhoneWarehouse warehouse1 = PhoneWarehouse.getInstance();
        PhoneWarehouse warehouse2 = PhoneWarehouse.getInstance();
        System.out.println("\nSame instance: " + (warehouse1 == warehouse2));
    }

    private static void receiveGoods(Phone phone, int quantity) {
        PhoneWarehouse.getInstance().addStock(phone, quantity);
        System.out.println("Received: " + phone.getModel() + " (" + quantity + " pcs)");
    }

    private static void sell(String store, String model, int quantity) {
        PhoneWarehouse warehouse = PhoneWarehouse.getInstance();
        if (warehouse.removeStock(model, quantity)) {
            System.out.println(store + ": sold " + quantity + " pcs of " + model);
        } else {
            System.out.println(store + ": cannot sell " + quantity + " pcs of " + model
                    + ", only " + warehouse.getQuantity(model) + " in stock");
        }
    }
}
