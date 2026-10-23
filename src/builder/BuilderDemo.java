package builder;

public class BuilderDemo {

    public static void main(String[] args) {
        Telefon samsung = Telefon.builder("Samsung", "Galaxy A15").build();
        Telefon iphone = Telefon.builder("Apple", "iPhone 16 Pro")
                .pamet(256)
                .ram(8)
                .uhlopricka(6.3)
                .barva("titanová")
                .nfc(true)
                .podpora5g(true)
                .build();

        System.out.println(samsung);
        System.out.println(iphone);

        try {
            Telefon.builder("Xiaomi", "Redmi 13").pamet(8).ram(16).build();
        } catch (IllegalStateException e) {
            System.out.println("Neplatný telefon: " + e.getMessage());
        }
    }
}
