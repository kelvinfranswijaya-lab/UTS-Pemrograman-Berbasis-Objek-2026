import java.util.Locale;

public class Cat extends Barang {
    private String warna;
    private double volumeLiter;

    public Cat(String namaBarang, String merek, double harga, String warna, double volumeLiter) {
        super(namaBarang, merek, "kaleng", harga);
        this.warna = warna;
        this.volumeLiter = volumeLiter;
    }

    public Cat() {
        super();
        this.warna = "";
        this.volumeLiter = 0;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double getVolumeLiter() {
        return volumeLiter;
    }

    public void setVolumeLiter(double volumeLiter) {
        this.volumeLiter = volumeLiter;
    }

    @Override
    public String getKategori() {
        return "Cat";
    }

    @Override
    public String getDetail() {
        return String.format(Locale.US, "Warna: %s, Volume: %.1f L", warna, volumeLiter);
    }
}
