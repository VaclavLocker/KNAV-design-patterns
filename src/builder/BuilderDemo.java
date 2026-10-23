package builder;

public class BuilderDemo {

    public static void main(String[] args) {
        Phone samsung = Phone.builder("Samsung", "Galaxy A15").build();
        Phone iphone = Phone.builder("Apple", "iPhone 16 Pro")
                .storage(256)
                .ram(8)
                .screenSize(6.3)
                .color("titanium")
                .nfc(true)
                .support5g(true)
                .build();

        System.out.println(samsung);
        System.out.println(iphone);

        try {
            Phone.builder("Xiaomi", "Redmi 13").storage(8).ram(16).build();
        } catch (IllegalStateException e) {
            System.out.println("Invalid phone: " + e.getMessage());
        }
    }
}
