package singleton;

import builder.Telefon;

public class SingletonDemo {

    public static void main(String[] args) {
        Telefon iphone = Telefon.builder("Apple", "iPhone 16 Pro").pamet(256).ram(8).build();
        Telefon samsung = Telefon.builder("Samsung", "Galaxy A15").build();

        prijemZbozi(iphone, 5);
        prijemZbozi(samsung, 10);

        prodej("E-shop", "iPhone 16 Pro", 2);
        prodej("Pobočka", "iPhone 16 Pro", 4);
        prodej("Pobočka", "Galaxy A15", 3);

        System.out.println();
        SkladTelefonu.getInstance().vypisSklad();

        SkladTelefonu sklad1 = SkladTelefonu.getInstance();
        SkladTelefonu sklad2 = SkladTelefonu.getInstance();
        System.out.println("\nStejná instance: " + (sklad1 == sklad2));
    }

    private static void prijemZbozi(Telefon telefon, int pocet) {
        SkladTelefonu.getInstance().naskladni(telefon, pocet);
        System.out.println("Naskladněno: " + telefon.getModel() + " (" + pocet + " ks)");
    }

    private static void prodej(String kde, String model, int pocet) {
        SkladTelefonu sklad = SkladTelefonu.getInstance();
        if (sklad.vydej(model, pocet)) {
            System.out.println(kde + ": prodáno " + pocet + " ks " + model);
        } else {
            System.out.println(kde + ": nelze prodat " + pocet + " ks " + model
                    + ", skladem je jen " + sklad.pocetKusu(model));
        }
    }
}
