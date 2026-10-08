public class DetailPenjualan {
    private Barang barang;
    private int jumlah;

    public DetailPenjualan(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public DetailPenjualan() {
        this.barang = null;
        this.jumlah = 0;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double hitungSubtotal() {
        return barang.getHarga() * jumlah;
    }
}
