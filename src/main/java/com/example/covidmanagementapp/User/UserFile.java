package com.example.covidmanagementapp.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UserFile {
    public static User currentUser;
    public static ArrayList<User> userList = new ArrayList<>();

    public static void loadUsers() {

        userList.clear();

        try {
            File f = new File("users.bin");
            if (!f.exists()) return;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            while (true) {
                userList.add((User) ois.readObject());
            }

        } catch (Exception e) {
            // end of file
        }
    }
}
