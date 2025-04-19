public class Mahasiswa extends User {
    public Mahasiswa(String nama, String NIM) {
        super(NIM, nama);
    }

    @Override
    public Boolean Login(String inputNama, String inputNIM) {
        return (inputNIM.equals(getNIM()) && inputNama.equals(getNama()));
    }

    @Override
    public void DisplayInfo() {
        System.out.println("\nLogin Mahasiswa Berhasil");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNIM());
        System.out.println("\n");
    }
}
