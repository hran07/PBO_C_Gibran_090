public class Admin extends User {
    private String Username;
    private String Password;

    public Admin(String username, String password) {
        super(username, password);
        this.Username = username;
        this.Password = password;
    }

    @Override
    public Boolean Login(String InputUsername, String InputPassword) {
        return (InputUsername.equals(Username) && InputPassword.equals(Password));
    }

    @Override
    public void DisplayInfo(){
        System.out.println("\nLogin Admin Berhasil");
        System.out.println("Username: " + Username);
        System.out.println("\n");
    }
}
