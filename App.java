import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Toko toko = new Toko();
        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== PROGRAM " + toko.getNamaToko().toUpperCase() + " ===");
            System.out.println("1. Sign Up (Penjual)");
            System.out.println("2. Sign In (Penjual)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String pilih = in.nextLine().trim();
            switch (pilih) {
                case "1":
                    Penjual baru = new Penjual();
                    System.out.print("Nama     : ");
                    baru.setNama(in.nextLine());
                    System.out.print("Username : ");
                    baru.setUsername(in.nextLine());
                    System.out.print("Password : ");
                    baru.setPassword(in.nextLine());
                    baru.signUp();
                    break;
                case "2":
                    Penjual p = new Penjual();
                    System.out.print("Username : ");
                    p.setUsername(in.nextLine());
                    System.out.print("Password : ");
                    p.setPassword(in.nextLine());
                    if (p.signIn()) {
                        System.out.println("Selamat datang, " + p.getNama() + " (" + p.getPeran() + ")");
                        menuPenjual(p, toko);
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;
                case "0":
                    jalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        System.out.println("Terima kasih.");
    }

    private static void menuPenjual(Penjual penjual, Toko toko) {
        boolean aktif = true;
        while (aktif) {
            System.out.println("\n--- Menu Penjual ---");
            System.out.println("1. Tampilkan katalog");
            System.out.println("2. Buat transaksi penjualan");
            System.out.println("3. Jumlah transaksi tersimpan");
            System.out.println("0. Sign out");
            System.out.print("Pilih: ");
            String pilih = in.nextLine().trim();
            switch (pilih) {
                case "1":
                    toko.tampilkanKatalog();
                    break;
                case "2":
                    transaksi(penjual, toko);
                    break;
                case "3":
                    System.out.println("Transaksi tersimpan: " + Penjualan.hitungTransaksiTersimpan());
                    break;
                case "0":
                    aktif = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void transaksi(Penjual penjual, Toko toko) {
        System.out.print("Nama pembeli: ");
        Pembeli pembeli = new Pembeli(in.nextLine());
        String waktu = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        String noNota = "NOTA-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Penjualan penjualan = new Penjualan(noNota, waktu, penjual, pembeli, toko);

        boolean tambah = true;
        while (tambah) {
            toko.tampilkanKatalog();
            System.out.print("Nomor barang (0 = selesai): ");
            int no;
            try {
                no = Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka.");
                continue;
            }
            if (no == 0) {
                break;
            }
            Barang b = toko.getBarang(no - 1);
            if (b == null) {
                System.out.println("Barang tidak ditemukan.");
                continue;
            }
            System.out.print("Jumlah: ");
            try {
                int jml = Integer.parseInt(in.nextLine().trim());
                if (jml <= 0) {
                    System.out.println("Jumlah harus lebih dari 0.");
                    continue;
                }
                penjualan.addDetail(b, jml);
                System.out.println("Ditambahkan: " + b.getNamaBarang() + " x " + jml);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka.");
            }
        }

        if (penjualan.getListDetail().isEmpty()) {
            System.out.println("Transaksi dibatalkan (tidak ada barang).");
            return;
        }
        penjualan.cetakNota();
        penjualan.simpanNota();
    }
}
