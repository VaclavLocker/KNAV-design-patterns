package builder;

public final class PhoneBuilder {

    private final String brand;
    private final String model;

    private int storageGb = 64;
    private int ramGb = 4;
    private double screenSize = 6.1;
    private String color = "black";
    private boolean nfc = false;
    private boolean support5g = false;

    PhoneBuilder(String brand, String model) {
        this.brand = requireText(brand, "Brand is required");
        this.model = requireText(model, "Model is required");
    }

    public PhoneBuilder storage(int gb) {
        this.storageGb = gb;
        return this;
    }

    public PhoneBuilder ram(int gb) {
        this.ramGb = gb;
        return this;
    }

    public PhoneBuilder screenSize(double inches) {
        this.screenSize = inches;
        return this;
    }

    public PhoneBuilder color(String color) {
        this.color = requireText(color, "Color is required");
        return this;
    }

    public PhoneBuilder nfc(boolean nfc) {
        this.nfc = nfc;
        return this;
    }

    public PhoneBuilder support5g(boolean support5g) {
        this.support5g = support5g;
        return this;
    }

    public Phone build() {
        if (storageGb <= 0 || ramGb <= 0) {
            throw new IllegalStateException("Storage and RAM must be positive");
        }
        if (ramGb > storageGb) {
            throw new IllegalStateException("RAM cannot be larger than storage");
        }
        if (screenSize <= 0) {
            throw new IllegalStateException("Screen size must be positive");
        }
        return new Phone(brand, model, storageGb, ramGb, screenSize, color, nfc, support5g);
    }

    private static String requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
