package facade;

import java.util.HashMap;
import java.util.Map;

public final class InventoryService {

    private final Map<String, Integer> stock;

    public InventoryService(Map<String, Integer> initialStock) {
        this.stock = new HashMap<>(initialStock);
    }

    public boolean reserve(String model) {
        int available = stock.getOrDefault(model, 0);
        if (available == 0) {
            System.out.println("Inventory: " + model + " is out of stock");
            return false;
        }
        stock.put(model, available - 1);
        System.out.println("Inventory: reserved " + model + ", " + (available - 1) + " left");
        return true;
    }

    public void release(String model) {
        int available = stock.getOrDefault(model, 0) + 1;
        stock.put(model, available);
        System.out.println("Inventory: returned " + model + ", " + available + " left");
    }
}
