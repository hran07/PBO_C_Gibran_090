package Praktikum.Users;

import Praktikum.Action.*;
import Praktikum.Data.*;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaAction {
    Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama,nim);
    }


    @Override
    public void Login(){
        System.out.println("\nLogin Mahasiswa Berhasil!");
    }

    @Override
    public void DisplayInfo() {
        System.out.println("\nNama: " + getInput1());
        System.out.println("NIM: " + getInput2());
    }

    @Override
    public void DisplayAppMenu() {

        DisplayInfo();
        int PilihanMahasiswa;

        while(true) {

            try {
                System.out.println("\n===Menu Mahasiswa===");
                System.out.println("1. Laporan barang hilang/temuan");
                System.out.println("2. Liat laporan barang hilang");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                PilihanMahasiswa = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error){
                System.out.println("\nErrpr!, Input harus berupa angka!");
                continue;
            }

            if (PilihanMahasiswa == 1) {
                ReportItem();
            } else if (PilihanMahasiswa == 2) {
                ViewReportItem();
            } else if (PilihanMahasiswa == 3) {
                System.out.println("\nTerima kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    @Override
    public void ReportItem() {

        System.out.print("\nNama barang: ");
        String NamaBarang = scanner.nextLine();
        System.out.print("Deskripsi barang: ");
        String DeskripsiBarang = scanner.nextLine();
        System.out.print("Lokasi terakhir: ");
        String Lokasi = scanner.nextLine();

        String Status = "Reported";

        Item item = new Item(NamaBarang, DeskripsiBarang, Lokasi, Status);

        DataStore.ReportedItems.add(item);

        System.out.println("\nNama barang: " + NamaBarang);
        System.out.println("Deskripsi barang: " + DeskripsiBarang);
        System.out.println("Lokasi terakhir: " + Lokasi);
        System.out.println("Status: " + Status);
    }

    @Override
    public void ViewReportItem() {
        if(DataStore.ReportedItems.isEmpty()){
            System.out.println("\nBelum ada laporan barang!\n");
            return;
        }

        System.out.println("\nDaftar barang yang dilaporkan:");
        for(Item item : DataStore.ReportedItems) {
            if("Reported".equalsIgnoreCase(item.getStatus())){
                System.out.println("\nNama barang: " + item.getNamaItem());
                System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                System.out.println("Lokasi terakhir: " + item.getLokasi());
            }
        }
    }
}