import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String nama;
        char kelamin;
        int tahunLahir, umur;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        nama = scanner.nextLine();

        System.out.print("Masukkan kelamin (L/P): ");
        kelamin = scanner.next().charAt(0);
        String jenisKelamin;
        switch(kelamin) {
            case 'L':
            case 'l':
                jenisKelamin = "Laki-laki";
                break;
            case 'P':
            case 'p':
                jenisKelamin = "Perempuan";
                break;
            default:
                jenisKelamin = "Tidak diketahui";
                break;
        }

        System.out.print("Masukkan tahun lahir: ");
        tahunLahir = scanner.nextInt();
        umur = LocalDate.now().getYear() - tahunLahir;

        System.out.println("\nData Diri:");
        System.out.println("Nama            : " + nama);
        System.out.println("Jenis Kelamin   : " + jenisKelamin);
        System.out.println("Umur            : " + umur + " tahun");

        scanner.close();
    }
}