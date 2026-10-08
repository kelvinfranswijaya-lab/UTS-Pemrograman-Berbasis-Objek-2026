import java.util.Locale;

public class Pipa extends Barang {
    private String diameter;
    private double panjangMeter;

    public Pipa(String namaBarang, String merek, double harga, String diameter, double panjangMeter) {
        super(namaBarang, merek, "batang", harga);
        this.diameter = diameter;
        this.panjangMeter = panjangMeter;
    }

    public Pipa() {
        super();
        this.diameter = "";
        this.panjangMeter = 0;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public double getPanjangMeter() {
        return panjangMeter;
    }

    public void setPanjangMeter(double panjangMeter) {
        this.panjangMeter = panjangMeter;
    }

    @Override
    public String getKategori() {
        return "Pipa";
    }

    @Override
    public String getDetail() {
        return String.format(Locale.US, "Diameter: %s, Panjang: %.1f m", diameter, panjangMeter);
    }
}
