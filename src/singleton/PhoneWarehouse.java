package singleton;

import builder.Phone;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class PhoneWarehouse {

    private record StockItem(Phone phone, int quantity) {
    }

    private final Map<String, StockItem> items = new LinkedHashMap<>();

    private PhoneWarehouse() {
    }

    private static final class Holder {
        private static final PhoneWarehouse INSTANCE = new PhoneWarehouse();
    }

    public static PhoneWarehouse getInstance() {
        return Holder.INSTANCE;
    }

    public void addStock(Phone phone, int quantity) {
        Objects.requireNonNull(phone, "Phone is required");
        requirePositive(quantity);
        String model = phone.getModel();
        items.put(model, new StockItem(phone, getQuantity(model) + quantity));
    }

    public boolean removeStock(String model, int quantity) {
        requirePositive(quantity);
        StockItem item = items.get(model);
        if (item == null || item.quantity() < quantity) {
            return false;
        }
        items.put(model, new StockItem(item.phone(), item.quantity() - quantity));
        return true;
    }

    public int getQuantity(String model) {
        StockItem item = items.get(model);
        return item == null ? 0 : item.quantity();
    }

    public void printStock() {
        System.out.println("Stock:");
        items.values().forEach(item -> System.out.println(
                item.phone().getBrand() + " " + item.phone().getModel() + ": " + item.quantity() + " pcs"));
    }

    private static void requirePositive(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }
}
