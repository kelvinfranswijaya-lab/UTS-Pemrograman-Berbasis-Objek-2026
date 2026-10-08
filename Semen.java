import java.util.Locale;

public class Semen extends Barang {
    private double beratKg;
    private String tipe;

    public Semen(String namaBarang, String merek, double harga, double beratKg, String tipe) {
        super(namaBarang, merek, "sak", harga);
        this.beratKg = beratKg;
        this.tipe = tipe;
    }

    public Semen() {
        super();
        this.beratKg = 0;
        this.tipe = "";
    }

    public double getBeratKg() {
        return beratKg;
    }

    public void setBeratKg(double beratKg) {
        this.beratKg = beratKg;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public String getKategori() {
        return "Semen";
    }

    @Override
    public String getDetail() {
        return String.format(Locale.US, "Berat: %.1f kg, Tipe: %s", beratKg, tipe);
    }
}
