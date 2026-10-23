package prototype;

import java.util.ArrayList;
import java.util.List;

public final class Phone implements Prototype<Phone> {

    private final String brand;
    private final String model;
    private int storageGb;
    private String color;
    private final List<String> apps;

    public Phone(String brand, String model, int storageGb, String color) {
        this.brand = requireText(brand, "Brand is required");
        this.model = requireText(model, "Model is required");
        this.storageGb = requirePositive(storageGb, "Storage must be positive");
        this.color = requireText(color, "Color is required");
        this.apps = new ArrayList<>();
    }

    private Phone(Phone source) {
        this.brand = source.brand;
        this.model = source.model;
        this.storageGb = source.storageGb;
        this.color = source.color;
        this.apps = new ArrayList<>(source.apps);
    }

    @Override
    public Phone copy() {
        return new Phone(this);
    }

    public void installApp(String name) {
        apps.add(requireText(name, "App name is required"));
    }

    public void setStorageGb(int storageGb) {
        this.storageGb = requirePositive(storageGb, "Storage must be positive");
    }

    public void setColor(String color) {
        this.color = requireText(color, "Color is required");
    }

    private static String requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    private static int requirePositive(int value, String message) {
        if (value <= 0) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", storageGb=" + storageGb +
                ", color='" + color + '\'' +
                ", apps=" + apps +
                '}';
    }
}
