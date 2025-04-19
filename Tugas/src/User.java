public abstract class User {
    private String Nama;
    private String NIM;

    public User(String NIM, String nama) {
        this.NIM = NIM;
        this.Nama = nama;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public Boolean Login(String input1, String input2){
        return false;
    }

    public void DisplayInfo(){
        System.out.println("\n");
    }


}

