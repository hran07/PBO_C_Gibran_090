import java.util.Scanner;

class Karakter {
    private String nama;
    private int kesehatan;

    public Karakter(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(nama + " menyerang " + target.getNama() + " dengan " + jenisSerangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan() + "\n");
    }
}

class Hero extends Karakter {
    public Hero(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " melakukan serangan heroik: " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

class Monster extends Karakter {
    public Monster(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " mengamuk dengan serangan: " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

public class Codelab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero Arthur = new Hero("Arthur", 5000);
        Monster Dragon = new Monster("Dragon", 6000);

        System.out.println("Pertarungan dimulai!\n");
        System.out.println(Arthur.getNama() + " vs " + Dragon.getNama());

        int ronde = 1;

        while (Arthur.getKesehatan() > 0 && Dragon.getKesehatan() > 0) {
            System.out.println("Ronde " + ronde);
            System.out.println("Pilihan serangan " + Arthur.getNama() + ":");
            System.out.println("1. Slash (500 damage)");
            System.out.println("2. Power Strike (1000 damage)");
            System.out.println("3. Ultimate Slash (2000 damage)");
            System.out.println("4. Cek Kesehatan");
            System.out.print("Pilih serangan: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                Arthur.serang(Dragon, 500, "Slash");
            } else if (pilihan == 2) {
                Arthur.serang(Dragon, 1000, "Power Strike");
            } else if (pilihan == 3) {
                Arthur.serang(Dragon, 2000, "Ultimate Slash");
            } else if (pilihan == 4) {
                System.out.println(Arthur.getNama() + " memiliki kesehatan: " + Arthur.getKesehatan());
                System.out.println(Dragon.getNama() + " memiliki kesehatan: " + Dragon.getKesehatan());
                continue;
            } else {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            if (Dragon.getKesehatan() > 0) {
                System.out.println(Dragon.getNama() + " menyerang balik!");
                Dragon.serang(Arthur, 750, "Fire Breath");
            }

            ronde++;
        }

        if (Arthur.getKesehatan() > 0) {
            System.out.println(Arthur.getNama() + " memenangkan pertarungan!");
        } else {
            System.out.println(Dragon.getNama() + " memenangkan pertarungan!");
        }

        scanner.close();
    }
}