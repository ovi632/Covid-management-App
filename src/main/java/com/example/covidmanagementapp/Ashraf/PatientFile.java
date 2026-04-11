package com.example.covidmanagementapp.Ashraf;

import java.io.*;
import java.util.ArrayList;

public class PatientFile {
    public static ArrayList<Patient> patientList = new ArrayList<>();

    // 🔵 LOAD
    public static void loadPatients() {
        patientList.clear();

        try {
            File f = new File("Patient.bin");
            if (!f.exists()) return;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            while (true) {
                patientList.add((Patient) ois.readObject());
            }

        } catch (Exception e) {
            // End of file
        }
    }

    // 🔵 SAVE (append)
    public static void addPatient(Patient p) {

        try {
            File f = new File("Patient.bin");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(p);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
