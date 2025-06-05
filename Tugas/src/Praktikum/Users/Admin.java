package Praktikum.Users;

import Praktikum.Action.*;
import Praktikum.Data.*;
import java.util.*;

public class Admin extends User implements AdminAction {

    Scanner scanner = new Scanner(System.in);

    public Admin(String Username, String Password) {
        super(Username, Password);
    }

    @Override
    public void Login() {
        System.out.println("\nLogin Admin Berhasil!");
    }

    @Override
    public void DisplayInfo(){
        System.out.println("\nNama user: " + getInput1());
    }

    @Override
    public void DisplayAppMenu() {

        DisplayInfo();

        while (true) {
            int PilihanAdmin;

            try {
                System.out.println("\n===Menu Admin===");
                System.out.println("1. Manage item");
                System.out.println("2. Manage users");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                PilihanAdmin = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error){
                System.out.println("\nError!, Input harus berupa angka!");
                continue;
            }

            if (PilihanAdmin == 1) {
                ManageItem();
            } else if (PilihanAdmin == 2) {
                ManageUser();
            } else if (PilihanAdmin == 3) {
                System.out.println("\nTerima kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    @Override
    public void ManageItem() {

        int Pilihan;

        while (true) {
            try {
                System.out.println("\n===Menu Manage Item===");
                System.out.println("1. Lihat semua laporan");
                System.out.println("2. Tandai barang telah diambil");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                Pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error) {
                System.out.println("\nError!, Input harus berupa angka!\n");
                continue;
            }

            if (Pilihan == 1) {
                if (DataStore.ReportedItems.isEmpty()) {
                    System.out.println("\nBelum ada laporan barang!");
                    continue;
                }

                System.out.println("\nDaftar barang yang dilaporkan:");
                for (Item item : DataStore.ReportedItems) {
                    System.out.println("\nNama barang: " + item.getNamaItem());
                    System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                    System.out.println("Lokasi terakhir: " + item.getLokasi());
                    System.out.println("Status: " + item.getStatus());
                }

            } else if (Pilihan == 2) {
                if (DataStore.ReportedItems.isEmpty()) {
                    System.out.println("\nBelum ada laporan barang!");
                    continue;
                }

                System.out.println("\nDaftar barang yang dilaporkan:");
                for (int i = 0; i < DataStore.ReportedItems.size(); i++) {
                    Item item = DataStore.ReportedItems.get(i);
                    System.out.println("\nNomor indeks: " + i);
                    System.out.println("Nama barang: " + item.getNamaItem());
                    System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                    System.out.println("Lokasi terakhir: " + item.getLokasi());
                    System.out.println("Status: " + item.getStatus());
                }

                try {
                    System.out.print("\nMasukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
                    int Indeks = Integer.parseInt(scanner.nextLine());

                    Item SelectedItem = DataStore.ReportedItems.get(Indeks);

                    if ("Reported".equalsIgnoreCase(SelectedItem.getStatus())) {
                        SelectedItem.setStatus("Claimed");

                        System.out.println("\nStatus barang '" + SelectedItem.getNamaItem() + "' menjadi 'Claimed'!");
                    } else {
                        System.out.println("\nBarang telah berstatus 'claimed'!");
                    }

                } catch (IndexOutOfBoundsException Error) {
                    System.out.println("\nError, Indeks tidak valid!\n");
                } catch (NumberFormatException Error) {
                    System.out.println("\nError!, Input harus berupa angka!\n");
                }
            } else if(Pilihan == 3){
                System.out.println("\nTerima kasih!");
                break;
            }
        }

    }

    @Override
    public void ManageUser() {

        Mahasiswa mahasiswa;
        int Pilihan;

        while(true) {
            try {
                System.out.println("\n===Menu Manage User===");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Hapus Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                Pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error) {
                System.out.println("\nError!, Input harus berupa angka!\n");
                continue;
            }

            if (Pilihan == 1) {

                boolean SudahAda = false;

                System.out.print("\nMasukkan nama Mahasiswa: ");
                String nama = scanner.nextLine();

                String NIM;
                while (true) {
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    NIM = scanner.nextLine();
                    if (NIM.trim().isEmpty()) {
                        System.out.println("NIM tidak boleh kosong, silakan input ulang.");
                    } else {
                        break;
                    }
                }

                for(User u : DataStore.UserList){
                    if (u instanceof Mahasiswa && u.getInput2().equalsIgnoreCase(NIM)){
                        SudahAda = true;
                        break;
                    }
                }

                if (SudahAda) {
                    System.out.println("\nNIM sudah terdaftar, tidak bisa ditambahkan lagi.");
                } else {
                    DataStore.UserList.add(new Mahasiswa(nama, NIM));
                    System.out.println("\nMahasiswa berhasil ditambahkan!");
                }

            } else if (Pilihan == 2) {

                boolean MHS = false;
                for(User user : DataStore.UserList){
                    if(user instanceof Mahasiswa) {
                        MHS = true;
                        break;
                    }
                }

                if(!MHS){
                    System.out.println("\nMahasiswa tidak ada!");
                    continue;
                }

                Iterator<User> iterator = DataStore.UserList.iterator();

                for (User user : DataStore.UserList) {
                    if (user instanceof Mahasiswa) {
                        System.out.println("\nNama: " + user.getInput1() + "\nNIM: " + user.getInput2());
                    }
                }

                System.out.print("\nMasukkan NIM Mahasiswa yang akan dihapus: ");
                String InputNIM = scanner.nextLine();

                boolean Ditemukan = false;

                while (iterator.hasNext()) {
                    User user = iterator.next();
                    if (user instanceof Mahasiswa) {
                        mahasiswa = (Mahasiswa) user;
                        if (InputNIM.equalsIgnoreCase(mahasiswa.getInput2())) {
                            Ditemukan = true;
                            System.out.println("\nMahasiswa dengan nim '" + mahasiswa.getInput2() + "' Berhasil dihapus!");
                            iterator.remove();
                            break;
                        }
                    }
                }

                if (!Ditemukan) {
                    System.out.println("\nMahasiswa dengan NIM tersebut tidak ditemukan");
                }

            } else if (Pilihan == 3) {
                System.out.println("\nTerima kasih!");
                break;
            }
        }
    }
}