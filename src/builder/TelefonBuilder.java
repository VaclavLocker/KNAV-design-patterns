package builder;

public final class TelefonBuilder {

    private final String znacka;
    private final String model;

    private int pametGb = 64;
    private int ramGb = 4;
    private double uhlopricka = 6.1;
    private String barva = "černá";
    private boolean nfc = false;
    private boolean podpora5g = false;

    TelefonBuilder(String znacka, String model) {
        if (znacka == null || znacka.isBlank()) {
            throw new IllegalArgumentException("Značka je povinná");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model je povinný");
        }
        this.znacka = znacka;
        this.model = model;
    }

    public TelefonBuilder pamet(int gb) {
        this.pametGb = gb;
        return this;
    }

    public TelefonBuilder ram(int gb) {
        this.ramGb = gb;
        return this;
    }

    public TelefonBuilder uhlopricka(double palce) {
        this.uhlopricka = palce;
        return this;
    }

    public TelefonBuilder barva(String barva) {
        this.barva = barva;
        return this;
    }

    public TelefonBuilder nfc(boolean nfc) {
        this.nfc = nfc;
        return this;
    }

    public TelefonBuilder podpora5g(boolean podpora5g) {
        this.podpora5g = podpora5g;
        return this;
    }

    public Telefon build() {
        if (pametGb <= 0 || ramGb <= 0) {
            throw new IllegalStateException("Paměť i RAM musí být kladné");
        }
        if (ramGb > pametGb) {
            throw new IllegalStateException("RAM nemůže být větší než úložiště");
        }
        if (uhlopricka <= 0) {
            throw new IllegalStateException("Úhlopříčka musí být kladná");
        }
        return new Telefon(znacka, model, pametGb, ramGb, uhlopricka, barva, nfc, podpora5g);
    }
}
