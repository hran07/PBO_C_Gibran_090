import java.util.Scanner;

public class Zetaa {
    public static void main(String[] args) {
        int pilihan;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Masukkan pilihan");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihan : ");
        pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Username: ");
            String Username = scanner.nextLine();
            System.out.print("Password: ");
            String Password = scanner.nextLine();

            String NIMutama = "090";
            String UsernameU = "Admin" + NIMutama;
            String PasswordU = "Pw" + NIMutama;

            if (Username.equals(UsernameU) && Password.equals(PasswordU)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login Admin Gagal!");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama Mahasiswa: ");
            String Nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String NIM = scanner.nextLine();

            System.out.println("\nLogin berhasil!");
            System.out.println("Nama Mahasiswa: " + Nama);
            System.out.println("NIM: " + NIM);
        } else {
            System.out.println("Kau pilih 1/2 lah");
        }

        scanner.close();
    }
}


