package Users;

public abstract class User {
    private String Nama;
    private String NIM;

    public User(String nama, String NIM) {
        this.Nama = nama;
        this.NIM = NIM;
    }

    public abstract boolean Login(String Input1, String Input2);

    public abstract void DisplayInfo();

    public abstract void DisplayAppMenu();

}
