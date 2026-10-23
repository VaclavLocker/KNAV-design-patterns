package prototype;

import java.util.ArrayList;
import java.util.List;

public final class Telefon implements Prototyp<Telefon> {

    private final String znacka;
    private String model;
    private int pametGb;
    private String barva;
    private final List<String> aplikace;

    public Telefon(String znacka, String model, int pametGb, String barva) {
        this.znacka = znacka;
        this.model = model;
        this.pametGb = pametGb;
        this.barva = barva;
        this.aplikace = new ArrayList<>();
    }

    private Telefon(Telefon zdroj) {
        this.znacka = zdroj.znacka;
        this.model = zdroj.model;
        this.pametGb = zdroj.pametGb;
        this.barva = zdroj.barva;
        this.aplikace = new ArrayList<>(zdroj.aplikace);
    }

    @Override
    public Telefon klonuj() {
        return new Telefon(this);
    }

    public void nainstalujAplikaci(String nazev) {
        aplikace.add(nazev);
    }

    public String getZnacka() { return znacka; }
    public String getModel() { return model; }
    public int getPametGb() { return pametGb; }
    public String getBarva() { return barva; }
    public List<String> getAplikace() { return List.copyOf(aplikace); }

    public void setModel(String model) { this.model = model; }
    public void setPametGb(int pametGb) { this.pametGb = pametGb; }
    public void setBarva(String barva) { this.barva = barva; }

    @Override
    public String toString() {
        return "Telefon{" +
                "znacka='" + znacka + '\'' +
                ", model='" + model + '\'' +
                ", pametGb=" + pametGb +
                ", barva='" + barva + '\'' +
                ", aplikace=" + aplikace +
                '}';
    }
}
