public class Obeng extends Perkakas {
    private String tipeMata;

    public Obeng(String namaBarang, String merek, double harga, String bahan, String tipeMata) {
        super(namaBarang, merek, "pcs", harga, bahan);
        this.tipeMata = tipeMata;
    }

    public Obeng() {
        super();
        this.tipeMata = "";
    }

    public String getTipeMata() {
        return tipeMata;
    }

    public void setTipeMata(String tipeMata) {
        this.tipeMata = tipeMata;
    }

    @Override
    public String getDetail() {
        return "Bahan: " + getBahan() + ", Tipe Mata: " + tipeMata;
    }
}
