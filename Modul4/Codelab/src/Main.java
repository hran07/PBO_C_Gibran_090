import Perpustakaan.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buku buku1 = new Fiksi("Laut Bercerita", "Dilla");
        Buku buku2 = new NonFiksi("Penulisan Ilmiah", "John");

        buku1.displayInfo();
        buku2.displayInfo();


        System.out.print("\nMasukkan Nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID Anggota: ");
        String ID = scanner.nextLine();

        System.out.println("\nMasukkan pilihan");
        System.out.println("1. Pinjam Buku Beberapa Hari");
        System.out.println("2. Pinjam Buku Saja");
        System.out.println("2. Kembalikan Buku");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan==1){
            System.out.print("\nMasukkan judul buku yang ingin dipinjam: ");
            String judulPinjam = scanner.nextLine();

            if (judulPinjam.equalsIgnoreCase(buku1.getJudul()) || judulPinjam.equalsIgnoreCase(buku2.getJudul())) {
                System.out.print("Masukkan jumlah hari pinjam: ");
                int hari = scanner.nextInt();

                Anggota anggota = new Anggota(nama, ID);
                anggota.pinjamBuku(judulPinjam, hari);
            } else {
                System.out.println("\nMaaf, buku tidak tersedia.");
            }

        } else if (pilihan==2){
            System.out.print("\nMasukkan judul buku yang ingin dipinjam: ");
            String judulPinjam = scanner.nextLine();

            if (judulPinjam.equalsIgnoreCase(buku1.getJudul()) || judulPinjam.equalsIgnoreCase(buku2.getJudul())) {

                Anggota anggota = new Anggota(nama, ID);
                anggota.pinjamBuku(judulPinjam);
            } else {
                System.out.println("\nMaaf, buku tidak tersedia.");
            }

        } else if (pilihan==3){
            System.out.print("\nMasukkan judul buku yang ingin dikembalikan: ");
            String judulPinjam = scanner.nextLine();

            if (judulPinjam.equalsIgnoreCase(buku1.getJudul()) || judulPinjam.equalsIgnoreCase(buku2.getJudul())) {
                Anggota anggota = new Anggota(nama, ID);
                anggota.kembalikanBuku(judulPinjam);
            } else {
                System.out.println("\nMaaf, data buku tidak dikenali.");
            }

        } else {
            System.out.println("\nMaaf pilihan tidak tersedia!");
        }
        scanner.close();
    }
}
