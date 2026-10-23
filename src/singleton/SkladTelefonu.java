package singleton;

import builder.Telefon;

import java.util.LinkedHashMap;
import java.util.Map;

public final class SkladTelefonu {

    private record SkladovaPolozka(Telefon telefon, int pocetKusu) {
    }

    private final Map<String, SkladovaPolozka> polozky = new LinkedHashMap<>();

    private SkladTelefonu() {
    }

    private static final class Holder {
        private static final SkladTelefonu INSTANCE = new SkladTelefonu();
    }

    public static SkladTelefonu getInstance() {
        return Holder.INSTANCE;
    }

    public void naskladni(Telefon telefon, int pocet) {
        if (pocet <= 0) {
            throw new IllegalArgumentException("Počet kusů musí být kladný");
        }
        String model = telefon.getModel();
        polozky.put(model, new SkladovaPolozka(telefon, pocetKusu(model) + pocet));
    }

    public boolean vydej(String model, int pocet) {
        if (pocet <= 0) {
            throw new IllegalArgumentException("Počet kusů musí být kladný");
        }
        SkladovaPolozka polozka = polozky.get(model);
        if (polozka == null || polozka.pocetKusu() < pocet) {
            return false;
        }
        polozky.put(model, new SkladovaPolozka(polozka.telefon(), polozka.pocetKusu() - pocet));
        return true;
    }

    public int pocetKusu(String model) {
        SkladovaPolozka polozka = polozky.get(model);
        return polozka == null ? 0 : polozka.pocetKusu();
    }

    public void vypisSklad() {
        System.out.println("Stav skladu:");
        polozky.values().forEach(p -> System.out.println(
                p.telefon().getZnacka() + " " + p.telefon().getModel() + ": " + p.pocetKusu() + " ks"));
    }
}
