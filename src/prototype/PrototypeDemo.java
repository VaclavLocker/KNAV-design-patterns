package prototype;

public class PrototypeDemo {

    public static void main(String[] args) {
        Telefon vzor = new Telefon("Samsung", "Galaxy A55", 128, "černá");
        vzor.nainstalujAplikaci("WhatsApp");
        vzor.nainstalujAplikaci("Chrome");

        Telefon klon = vzor.klonuj();
        klon.setBarva("modrá");
        klon.setPametGb(256);
        klon.nainstalujAplikaci("Spotify");

        System.out.println("Vzor: " + vzor);
        System.out.println("Klon: " + klon);
        System.out.println("Různé instance: " + (vzor != klon));
    }
}
