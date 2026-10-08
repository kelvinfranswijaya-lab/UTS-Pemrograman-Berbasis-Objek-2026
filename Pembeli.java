public class Pembeli extends User {

    public Pembeli(String nama) {
        super(nama);
    }

    public Pembeli() {
        super();
    }

    @Override
    public String getPeran() {
        return "Pembeli";
    }
}
