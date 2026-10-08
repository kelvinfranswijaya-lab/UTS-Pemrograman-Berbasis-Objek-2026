import java.io.*;

public class Penjual extends User implements LogIn {
    private String username;
    private String password;
    private static final String FILE_AKUN = "akun.txt";

    public Penjual(String nama, String username, String password) {
        super(nama);
        this.username = username;
        this.password = password;
    }

    public Penjual() {
        super();
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPeran() {
        return "Penjual";
    }

    @Override
    public void signUp() {
        if (usernameSudahAda(username)) {
            System.out.println("Sign up gagal: username sudah digunakan.");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_AKUN, true))) {
            pw.println(username + ";" + password + ";" + getNama());
            System.out.println("Sign up berhasil. Silakan sign in.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan akun: " + e.getMessage());
        }
    }

    @Override
    public boolean signIn() {
        File f = new File(FILE_AKUN);
        if (!f.exists()) {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(";", 3);
                if (d.length == 3 && d[0].equals(username) && d[1].equals(password)) {
                    setNama(d[2]);
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca akun: " + e.getMessage());
        }
        return false;
    }

    private boolean usernameSudahAda(String username) {
        File f = new File(FILE_AKUN);
        if (!f.exists()) {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(";", 3);
                if (d.length >= 1 && d[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca akun: " + e.getMessage());
        }
        return false;
    }
}
