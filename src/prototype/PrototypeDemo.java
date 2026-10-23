package prototype;

public class PrototypeDemo {

    public static void main(String[] args) {
        Phone original = new Phone("Samsung", "Galaxy A55", 128, "black");
        original.installApp("WhatsApp");
        original.installApp("Chrome");

        Phone copy = original.copy();
        copy.setColor("blue");
        copy.setStorageGb(256);
        copy.installApp("Spotify");

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        System.out.println("Different instances: " + (original != copy));
    }
}
