import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> DaftarBarang = new ArrayList<>();
        Barang barang;

        while (true) {

            int Pilihan;

            try {
                System.out.println("=== Menu Bran ===");
                System.out.println("1. Tambahkan barang baru");
                System.out.println("2. Tampilkan semua barang");
                System.out.println("3. Kurangi/Tambah stok barang");
                System.out.println("4. Hapus barang");
                System.out.println("5. Keluar");
                System.out.print("Masukkan pilihan: ");
                String Input = scanner.nextLine();
                Pilihan = Integer.parseInt(Input);
            } catch (NumberFormatException Error) {
                System.out.println("\nInput harus berupa angka!\n");
                continue;
            }

            if (Pilihan == 1) {
                System.out.println("\n=================================\n");
                System.out.print("Masukkan nama barang: ");
                String NmBarang = scanner.nextLine();

                try {
                    System.out.print("Masukkan stok barang: ");
                    int StokBarang = scanner.nextInt();

                    barang = new Barang(NmBarang, StokBarang);
                    DaftarBarang.add(barang);
                    System.out.println("\nBarang berhasil ditambahkan!");
                    System.out.println("\n=================================\n");
                    scanner.nextLine();
                    continue;
                } catch (InputMismatchException Error) {
                    System.out.println("\nInput stok harus berupa angka!\n");
                    scanner.nextLine();
                    continue;
                }

            } else if (Pilihan == 2) {
                Iterator<Barang> ITBarang = DaftarBarang.iterator();
                if (DaftarBarang.isEmpty()) {
                    System.out.println("\n=================================");
                    System.out.println("\nStok barang kosong");
                    System.out.println("\n=================================\n");
                } else {
                    System.out.println("\n=================================\n");
                    System.out.println("Daftar barang:");

                    while (ITBarang.hasNext()) {
                        barang = ITBarang.next();
                        System.out.println("Nama: " + barang.getNama());
                        System.out.println("Stok: " + barang.getStok() + "\n");
                    }

                    System.out.println("=================================\n");
                }
                continue;

            } else if (Pilihan == 3) {
                if (DaftarBarang.isEmpty()) {
                    System.out.println("\n=================================");
                    System.out.println("\nStok barang kosong");
                    System.out.println("\n=================================\n");
                    continue;
                } else {
                    System.out.println("\n=================================\n");

                    for (int i = 0; i < DaftarBarang.size(); i++) {
                        barang = DaftarBarang.get(i);
                        System.out.println("Daftar barang indeks ke-" + i + ": ");
                        System.out.println("Nama: " + barang.getNama());
                        System.out.println("Stok: " + barang.getStok() + "\n");
                    }

                    try {
                        System.out.print("Tambah/Kurangi Stok: ");
                        String Opsi = scanner.nextLine();

                        if (!Opsi.equalsIgnoreCase("Kurangi") && !Opsi.equalsIgnoreCase("Tambah")) {
                            System.out.println("\nInput opsi tidak valid!");
                            System.out.println("\n=================================\n");
                            continue;
                        }

                        System.out.print("\nMasukkan nomor indeks barang: ");
                        int Indeks = scanner.nextInt();

                        System.out.print("\nMasukkan jumlah stok: ");
                        int Jumlah = scanner.nextInt();
                        scanner.nextLine();

                        barang = DaftarBarang.get(Indeks);

                        if (Opsi.equalsIgnoreCase("Kurangi")) {
                            try {
                                barang.KurangiStok(Jumlah);
                                continue;
                            } catch (StokTidakCukupException Error) {
                                System.out.println("\n" + Error.getMessage() + "\n");
                                continue;
                            }
                        } else if (Opsi.equalsIgnoreCase("Tambah")) {
                            barang.TambahStok(Jumlah);
                            continue;
                        }

                    } catch (InputMismatchException Error) {
                        System.out.println("\nInput harus berupa angka!");
                        System.out.println("\n=================================\n");
                        scanner.nextLine();
                        continue;
                    } catch (IndexOutOfBoundsException Error) {
                        System.out.println("\nIndeks tidak valid!");
                        System.out.println("\n=================================\n");
                        continue;
                    }
                }

            } else if (Pilihan == 4) {
                if (DaftarBarang.isEmpty()) {
                    System.out.println("\n=================================");
                    System.out.println("\nStok barang kosong");
                    System.out.println("\n=================================\n");
                    continue;
                } else {
                    System.out.println("\n=================================\n");

                    for (int i = 0; i < DaftarBarang.size(); i++) {
                        barang = DaftarBarang.get(i);
                        System.out.println("Daftar barang indeks ke-" + i + ": ");
                        System.out.println("Nama: " + barang.getNama());
                        System.out.println("Stok: " + barang.getStok() + "\n");
                    }

                    try {
                        System.out.print("Masukkan indeks barang yang akan dihapus: ");
                        int Indeks = scanner.nextInt();
                        scanner.nextLine();

                        barang = DaftarBarang.get(Indeks);
                        System.out.println("\nBarang berhasil dihapus!");
                        System.out.println("Nama barang: " + barang.getNama());
                        System.out.println("Stok barang: " + barang.getStok());
                        System.out.println("\n=================================\n");
                        DaftarBarang.remove(Indeks);
                        continue;
                    } catch (InputMismatchException Error) {
                        System.out.println("\nInput harus berupa angka!");
                        System.out.println("\n=================================\n");
                        scanner.nextLine();
                        continue;
                    } catch (IndexOutOfBoundsException Error) {
                        System.out.println("\nIndeks tidak valid!");
                        System.out.println("\n=================================\n");
                        continue;
                    }
                }

            } else if (Pilihan == 5) {
                System.out.println("\nTerima kasih!");
                break;

            } else {
                System.out.println("\nError! Pilihan tidak valid\n");
                continue;
            }

            scanner.close();
        }
    }
}
