public abstract class Perkakas extends Barang {
    private String bahan;

    public Perkakas(String namaBarang, String merek, String satuan, double harga, String bahan) {
        super(namaBarang, merek, satuan, harga);
        this.bahan = bahan;
    }

    public Perkakas() {
        super();
        this.bahan = "";
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    @Override
    public String getKategori() {
        return "Perkakas";
    }

    @Override
    public abstract String getDetail();
}
