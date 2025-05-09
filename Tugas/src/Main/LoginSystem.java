package Main;

import Users.*;
import java.util.Scanner;

public class LoginSystem {

    User user = null;

    Admin admin = new Admin("Gibran","090", "Jeruk", "Raa");
    Mahasiswa mahasiswa = new Mahasiswa("Gibran", "090");


    public void Menu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Login/Logout: ");
            String Pilihan = scanner.nextLine();

            if (Pilihan.equalsIgnoreCase("Login")) {

                System.out.print("\nUsername: ");
                String Username = scanner.nextLine();
                System.out.print("Password: ");
                String Password = scanner.nextLine();

                if (mahasiswa.Login(Username, Password)) {
                    user = mahasiswa;
                } else if (admin.Login(Username, Password)) {
                    user = admin;
                } else {
                    System.out.print("\nLogin Gagal!\n");
                }

                if (user != null) {
                    user.DisplayAppMenu();
                }
            } else if (Pilihan.equalsIgnoreCase("Logout")){
                System.out.println("\nTerima Kasih!");
                break;
            }
        }
    }
    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.Menu();
    }
}
