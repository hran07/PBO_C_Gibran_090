package Users;

import Action.*;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaAction {
    private String Nama;
    private String Nim;

    public Mahasiswa(String nama, String nim) {
        super(nama,nim);
        this.Nama = nama;
        this.Nim = nim;
    }

    @Override
    public boolean Login(String InputNama, String InputNim){
        return (InputNama.equalsIgnoreCase(Nama) && InputNim.equalsIgnoreCase(Nim));
    }

    @Override
    public void DisplayInfo() {
        System.out.println("\nLogin Mahasiswa Berhasil!");
        System.out.println("\nNama: " + Nama);
        System.out.println("NIM: " + Nim);
    }

    @Override
    public void DisplayAppMenu() {
        Scanner scanner = new Scanner(System.in);

        DisplayInfo();

        while(true) {
            System.out.println("\n===Menu Mahasiswa===");
            System.out.println("1. Laporan barang hilang/Temuan");
            System.out.println("2. Liat laporan barang hilang");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int PilihanMahasiswa = scanner.nextInt();
            scanner.nextLine();

            if (PilihanMahasiswa == 1) {
                ReportItem();
            } else if (PilihanMahasiswa == 2) {
                ViewReportItem();
            } else if (PilihanMahasiswa == 3) {
                System.out.println("\nTerima Kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan Tidak Valid!");
            }
        }
    }

    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNama Barang: ");
        String NamaBarang = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String DeskripsiBarang = scanner.nextLine();
        System.out.print("Lokasi Terakhir: ");
        String Lokasi = scanner.nextLine();

        System.out.println("\nNama Barang: " + NamaBarang);
        System.out.println("Deskripsi Barang: " + DeskripsiBarang);
        System.out.println("Lokasi Terakhir: " + Lokasi);
    }

    @Override
    public void ViewReportItem() {
        System.out.println("\nFitur Liat Laporan Belum tersedia");
    }
}
