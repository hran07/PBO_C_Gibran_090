package Praktikum.Data;

import Praktikum.Users.*;

import java.util.ArrayList;

public class DataStore {

    public static ArrayList<User> UserList = new ArrayList<>();
    public static ArrayList<Item> ReportedItems = new ArrayList<>();

    static {
        UserList.add(new Admin("Adminaja", "test123"));
        UserList.add(new Mahasiswa("Gibran", "090"));

        ReportedItems.add(new Item("Laptop", "MSI Hitam", "Lab C/D", "Reported"));
    }
}
