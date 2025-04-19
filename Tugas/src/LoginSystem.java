import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;

    public LoginSystem(){
        admin = new Admin("Admin", "Branaja");
        mahasiswa = new Mahasiswa("Gibran", "090");
    }

    public void Menu(){
        System.out.println("Masukkan pilihan");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Keluar");
    }

    public void Start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            Menu();
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if(pilihan == 1){
                System.out.print("\nMasukkan Username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();

                if(admin.Login(username,password)) {
                    admin.DisplayInfo();
                } else {
                    System.out.println("\nLogin Admin Gagal\n");
                }
            } else if (pilihan == 2){
                System.out.print("\nMasukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String NIM = scanner.nextLine();

                if(mahasiswa.Login(nama, NIM)){
                    mahasiswa.DisplayInfo();
                } else {
                    System.out.println("\nLogin Mahasiswa Gagal\n");
                }
            } else if (pilihan == 3){
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.Start();
    }
}
