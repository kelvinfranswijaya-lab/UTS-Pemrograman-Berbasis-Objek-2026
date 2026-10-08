public class Paku extends Perkakas {
    private String ukuran;

    public Paku(String namaBarang, String merek, double harga, String bahan, String ukuran) {
        super(namaBarang, merek, "kg", harga, bahan);
        this.ukuran = ukuran;
    }

    public Paku() {
        super();
        this.ukuran = "";
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public String getDetail() {
        return "Bahan: " + getBahan() + ", Ukuran: " + ukuran;
    }
}
