import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Penjualan {
    private int nomorTransaksi;
    private String noNota;
    private String tanggalWaktu;
    private Penjual penjual;
    private Pembeli pembeli;
    private Toko toko;
    private ArrayList<DetailPenjualan> listDetail;

    public Penjualan(String noNota, String tanggalWaktu, Penjual penjual, Pembeli pembeli, Toko toko) {
        this.nomorTransaksi = hitungTransaksiTersimpan() + 1;
        this.noNota = noNota;
        this.tanggalWaktu = tanggalWaktu;
        this.penjual = penjual;
        this.pembeli = pembeli;
        this.toko = toko;
        this.listDetail = new ArrayList<>();
    }

    public Penjualan() {
        this.nomorTransaksi = hitungTransaksiTersimpan() + 1;
        this.noNota = "";
        this.tanggalWaktu = "";
        this.listDetail = new ArrayList<>();
    }

    public static int hitungTransaksiTersimpan() {
        File f = new File("nota.txt");
        if (!f.exists()) {
            return 0;
        }
        int jumlah = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("NOTA|")) {
                    jumlah++;
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca nota: " + e.getMessage());
        }
        return jumlah;
    }

    public void addDetail(Barang barang, int jumlah) {
        listDetail.add(new DetailPenjualan(barang, jumlah));
    }

    public ArrayList<DetailPenjualan> getListDetail() {
        return listDetail;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public String getTanggalWaktu() {
        return tanggalWaktu;
    }

    public void setTanggalWaktu(String tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Toko getToko() {
        return toko;
    }

    public void setToko(Toko toko) {
        this.toko = toko;
    }

    public double hitungTotal() {
        double total = 0;
        for (DetailPenjualan d : listDetail) {
            total += d.hitungSubtotal();
        }
        return total;
    }

    public void cetakNota() {
        System.out.println("==================================================");
        System.out.println(toko.getNamaToko());
        System.out.println(toko.getAlamatToko() + " | Telp: " + toko.getTelpToko());
        System.out.println("==================================================");
        System.out.println("Transaksi ke : " + nomorTransaksi);
        System.out.println("No. Nota     : " + noNota);
        System.out.println("Tanggal      : " + tanggalWaktu);
        System.out.println("Penjual      : " + penjual.getNama());
        System.out.println("Pembeli      : " + pembeli.getNama());
        System.out.println("--------------------------------------------------");
        for (DetailPenjualan d : listDetail) {
            System.out.println(d.getBarang().getNamaBarang() + " (" + d.getBarang().getMerek() + ")");
            System.out.println(String.format(Locale.US, "   %d %s x Rp %,.0f = Rp %,.0f",
                    d.getJumlah(), d.getBarang().getSatuan(), d.getBarang().getHarga(), d.hitungSubtotal()));
        }
        System.out.println("--------------------------------------------------");
        System.out.println(String.format(Locale.US, "TOTAL : Rp %,.0f", hitungTotal()));
        System.out.println("==================================================");
    }

    public void simpanNota() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("nota.txt", true))) {
            pw.println("NOTA|" + nomorTransaksi + "|" + noNota + "|" + tanggalWaktu + "|"
                    + penjual.getNama() + "|" + pembeli.getNama() + "|" + (long) hitungTotal());
            for (DetailPenjualan d : listDetail) {
                pw.println("  - " + d.getBarang().getNamaBarang() + " (" + d.getBarang().getMerek() + ") x "
                        + d.getJumlah() + " " + d.getBarang().getSatuan() + " = " + (long) d.hitungSubtotal());
            }
            System.out.println("Nota berhasil disimpan ke nota.txt");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan nota: " + e.getMessage());
        }
    }
}
