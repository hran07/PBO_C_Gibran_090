import java.util.Scanner;

public class Barang {
    private String Nama;
    private int Stok;

    public Barang(String nama, int stok) {
        Nama = nama;
        Stok = stok;
    }

    public String getNama() {
        return Nama;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        Stok = stok;
    }

    public void KurangiStok(int jumlah) throws StokTidakCukupException {
        if (jumlah > Stok) {
            throw new StokTidakCukupException("\nStok untuk " + Nama + " hanya tersisa " + Stok + "\n\n=================================");
        } else {
            Stok -= jumlah;
            System.out.println("\nJumlah stok berhasil dikurangi!");
            System.out.println("\n=================================\n");
        }
    }

    public void TambahStok(int Jumlah){
        if (Jumlah <= 0){
            System.out.println("\nJumlah tidak valid!");
            System.out.println("\n=================================\n");
        } else {
            Stok += Jumlah;
            System.out.println("\nJumlah stok berhasil ditambah!");
            System.out.println("\n=================================\n");
        }
    }
}
