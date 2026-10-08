public class Palu extends Perkakas {
    private int beratGram;

    public Palu(String namaBarang, String merek, double harga, String bahan, int beratGram) {
        super(namaBarang, merek, "pcs", harga, bahan);
        this.beratGram = beratGram;
    }

    public Palu() {
        super();
        this.beratGram = 0;
    }

    public int getBeratGram() {
        return beratGram;
    }

    public void setBeratGram(int beratGram) {
        this.beratGram = beratGram;
    }

    @Override
    public String getDetail() {
        return "Bahan: " + getBahan() + ", Berat: " + beratGram + " gram";
    }
}
