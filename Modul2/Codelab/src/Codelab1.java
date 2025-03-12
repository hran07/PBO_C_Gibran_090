// Kelas Hewan
class Hewan {
    String nama;
    String jenis;
    String suara;

    // Constructor
    Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Method untuk menampilkan informasi hewan
    void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println("----------------------");
    }
}

// Kelas Main untuk menjalankan program
public class codelab1 {
    public static void main(String[] args) {
        // Membuat objek Hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Memanggil method tampilkanInfo()
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}