import java.util.ArrayList;

public class Toko {
    private String namaToko;
    private String alamatToko;
    private String telpToko;
    private ArrayList<Barang> katalog;

    public Toko(String namaToko, String alamatToko, String telpToko) {
        this.namaToko = namaToko;
        this.alamatToko = alamatToko;
        this.telpToko = telpToko;
        this.katalog = new ArrayList<>();
        isiKatalog();
    }

    public Toko() {
        this("Toko Bangunan Maju Jaya", "Jl. Raya No. 1, Jakarta", "021-1234567");
    }

    private void isiKatalog() {
        tambahBarang(new Cat("Cat Tembok Putih", "Dulux", 185000, "Putih", 5));
        tambahBarang(new Cat("Cat Kayu Coklat", "Avian", 65000, "Coklat", 1));
        tambahBarang(new Semen("Semen Portland", "Tiga Roda", 62000, 40, "PCC"));
        tambahBarang(new Semen("Semen Instan", "Holcim", 58000, 40, "PPC"));
        tambahBarang(new Keramik("Keramik Lantai", "Roman", 75000, "40x40 cm", "Polos"));
        tambahBarang(new Keramik("Keramik Dinding", "Mulia", 68000, "25x40 cm", "Marmer"));
        tambahBarang(new Pipa("Pipa PVC", "Rucika", 45000, "3 inch", 4));
        tambahBarang(new Pipa("Pipa PVC", "Wavin", 32000, "1/2 inch", 4));
        tambahBarang(new Paku("Paku Beton", "Eagle", 28000, "Baja", "2 inch"));
        tambahBarang(new Palu("Palu Konde", "Tekiro", 55000, "Baja", 500));
        tambahBarang(new Obeng("Obeng Plus", "Krisbow", 15000, "Baja Krom", "Phillips"));
    }

    public void tambahBarang(Barang barang) {
        katalog.add(barang);
    }

    public Barang getBarang(int index) {
        if (index < 0 || index >= katalog.size()) {
            return null;
        }
        return katalog.get(index);
    }

    public void tampilkanKatalog() {
        System.out.println("=== Katalog " + namaToko + " ===");
        for (int i = 0; i < katalog.size(); i++) {
            System.out.println((i + 1) + ". " + katalog.get(i).tampilInfo());
        }
    }

    public String getNamaToko() {
        return namaToko;
    }

    public String getAlamatToko() {
        return alamatToko;
    }

    public String getTelpToko() {
        return telpToko;
    }

    public ArrayList<Barang> getKatalog() {
        return katalog;
    }
}
