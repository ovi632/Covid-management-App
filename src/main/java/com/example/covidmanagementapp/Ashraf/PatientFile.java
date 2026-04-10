package com.example.covidmanagementapp.Ashraf;

import java.io.*;
import java.util.ArrayList;

public class PatientFile {
    public static ArrayList<Patient> patientList = new ArrayList<>();

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
            //
        }
    }

    public static void addPatient(Patient p) {

        try {
            File f = new File("Patient.bin");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new com.example.covidmanagementapp.util.AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(p);
            oos.close();

        } catch (Exception e) {
            //
        }
    }
}
