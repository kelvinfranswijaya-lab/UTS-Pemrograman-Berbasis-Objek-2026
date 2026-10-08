import java.util.Locale;

public abstract class Barang {
    private String namaBarang;
    private String merek;
    private String satuan;
    private double harga;

    public Barang(String namaBarang, String merek, String satuan, double harga) {
        this.namaBarang = namaBarang;
        this.merek = merek;
        this.satuan = satuan;
        this.harga = harga;
    }

    public Barang() {
        this.namaBarang = "";
        this.merek = "";
        this.satuan = "";
        this.harga = 0;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public abstract String getKategori();

    public abstract String getDetail();

    public String tampilInfo() {
        return String.format(Locale.US, "[%s] %s | Merek: %s | %s | Rp %,.0f/%s",
                getKategori(), namaBarang, merek, getDetail(), harga, satuan);
    }
}
