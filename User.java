public abstract class User {
    private String nama;

    public User(String nama) {
        this.nama = nama;
    }

    public User() {
        this.nama = "";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public abstract String getPeran();
}
