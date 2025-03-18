class Hewan {
    String nama;
    String jenis;
    String suara;

    Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println("----------------------");
    }
}

public class Codelab1 {
    public static void main(String[] args) {

        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        hewan1.nama = "Kucing";
        hewan2.nama = "anjing";

        hewan1.jenis = "mamalia";
        hewan2.jenis = "mamalia";

        hewan1.suara = ""

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}