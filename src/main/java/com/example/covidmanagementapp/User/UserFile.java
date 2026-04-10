package com.example.covidmanagementapp.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UserFile {

    public static ArrayList<User> userList = new ArrayList<>();

    public static void loadUsers() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("users.bin");

            if (!f.exists()) return; // no file yet

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {
                userList.add((User) ois.readObject());
            }

        } catch (Exception e) {
            // end of file
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                //
            }
        }
    }
}
