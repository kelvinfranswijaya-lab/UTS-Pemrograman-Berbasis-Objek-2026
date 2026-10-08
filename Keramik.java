public class Keramik extends Barang {
    private String ukuran;
    private String motif;

    public Keramik(String namaBarang, String merek, double harga, String ukuran, String motif) {
        super(namaBarang, merek, "dus", harga);
        this.ukuran = ukuran;
        this.motif = motif;
    }

    public Keramik() {
        super();
        this.ukuran = "";
        this.motif = "";
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String getKategori() {
        return "Keramik";
    }

    @Override
    public String getDetail() {
        return "Ukuran: " + ukuran + ", Motif: " + motif;
    }
}
