package Praktikum.Users;

public abstract class User {
    private String Input1;
    private String Input2;

    public User(String input1, String input2) {
        Input1 = input1;
        Input2 = input2;
    }

    public abstract void Login();

    public abstract void DisplayInfo();

    public abstract void DisplayAppMenu();

    public String getInput1() {
        return Input1;
    }

    public String getInput2() {
        return Input2;
    }
}
