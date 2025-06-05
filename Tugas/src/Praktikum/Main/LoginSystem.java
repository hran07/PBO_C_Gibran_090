package Praktikum.Main;

import Praktikum.Data.*;
import Praktikum.Users.*;
import java.util.*;


public class LoginSystem {

    User user;

    public static User tryLogin(String username, String password) {
        for (User u : DataStore.UserList) {
            if (u.getInput1().equals(username) && u.getInput2().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void Menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Username: ");
            String InputNama = scanner.nextLine();
            System.out.print("Password: ");
            String InputPassword = scanner.nextLine();

            user = null;

            for (User u : DataStore.UserList) {
                if (u.getInput1().equals(InputNama) && u.getInput2().equals(InputPassword)){
                    user = u;
                    user.Login();
                    break;
                }
            }

            if (user != null) {
                user.DisplayAppMenu();
            } else {
                System.out.println("\nLogin Gagal!\n");
            }
        }
    }
}
