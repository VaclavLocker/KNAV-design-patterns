package builder;

public final class Phone {

    private final String brand;
    private final String model;

    private final int storageGb;
    private final int ramGb;
    private final double screenSize;
    private final String color;
    private final boolean nfc;
    private final boolean support5g;

    Phone(String brand, String model, int storageGb, int ramGb, double screenSize,
          String color, boolean nfc, boolean support5g) {
        this.brand = brand;
        this.model = model;
        this.storageGb = storageGb;
        this.ramGb = ramGb;
        this.screenSize = screenSize;
        this.color = color;
        this.nfc = nfc;
        this.support5g = support5g;
    }

    public static PhoneBuilder builder(String brand, String model) {
        return new PhoneBuilder(brand, model);
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", storageGb=" + storageGb +
                ", ramGb=" + ramGb +
                ", screenSize=" + screenSize +
                ", color='" + color + '\'' +
                ", nfc=" + nfc +
                ", support5g=" + support5g +
                '}';
    }
}
