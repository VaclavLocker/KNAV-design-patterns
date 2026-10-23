package builder;

public final class Telefon {

    private final String znacka;
    private final String model;

    private final int pametGb;
    private final int ramGb;
    private final double uhlopricka;
    private final String barva;
    private final boolean nfc;
    private final boolean podpora5g;

    Telefon(String znacka, String model, int pametGb, int ramGb, double uhlopricka,
            String barva, boolean nfc, boolean podpora5g) {
        this.znacka = znacka;
        this.model = model;
        this.pametGb = pametGb;
        this.ramGb = ramGb;
        this.uhlopricka = uhlopricka;
        this.barva = barva;
        this.nfc = nfc;
        this.podpora5g = podpora5g;
    }

    public static TelefonBuilder builder(String znacka, String model) {
        return new TelefonBuilder(znacka, model);
    }

    public String getZnacka() { return znacka; }
    public String getModel() { return model; }
    public int getPametGb() { return pametGb; }
    public int getRamGb() { return ramGb; }
    public double getUhlopricka() { return uhlopricka; }
    public String getBarva() { return barva; }
    public boolean maNfc() { return nfc; }
    public boolean maPodporu5g() { return podpora5g; }

    @Override
    public String toString() {
        return "Telefon{" +
                "znacka='" + znacka + '\'' +
                ", model='" + model + '\'' +
                ", pametGb=" + pametGb +
                ", ramGb=" + ramGb +
                ", uhlopricka=" + uhlopricka +
                ", barva='" + barva + '\'' +
                ", nfc=" + nfc +
                ", podpora5g=" + podpora5g +
                '}';
    }
}
