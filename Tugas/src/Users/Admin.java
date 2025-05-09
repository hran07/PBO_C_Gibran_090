package Users;

import java.util.Scanner;
import Action.*;

public class Admin extends User implements AdminAction {
    private String Username;
    private String Password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama,nim);
        this.Username = username;
        this.Password = password;
    }

    @Override
    public boolean Login(String InputUsername, String InputPassword) {
        return (InputUsername.equalsIgnoreCase(Username) && InputPassword.equalsIgnoreCase(Password));
    }

    @Override
    public void DisplayInfo(){
        System.out.println("\nLogin Admin Berhasil");
        System.out.println("\nNama User: " + Username);
    }

    @Override
    public void DisplayAppMenu() {
        Scanner scanner = new Scanner(System.in);

        DisplayInfo();

        while (true) {

            System.out.println("\n===Menu Admin===");
            System.out.println("1. Manage Item");
            System.out.println("2. Manage Users");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");
            int PilihanAdmin = scanner.nextInt();
            scanner.nextLine();

            if (PilihanAdmin == 1) {
                ManageItem();
            } else if (PilihanAdmin == 2) {
                ManageUser();
            } else if (PilihanAdmin == 3) {
                System.out.println("\nTerima Kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan Tidak Valid!");
            }
        }
    }

    @Override
    public void ManageItem() {
        System.out.println("\nFitur Belum Tersedia!");
    }

    @Override
    public void ManageUser() {
        System.out.println("\nFitur Belum Tersedia!");
    }
}