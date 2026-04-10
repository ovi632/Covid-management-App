package com.example.covidmanagementapp.Ashraf;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class PrescriptionFile {
    public static ArrayList<Prescription> prescriptionList = new ArrayList<>();

    public static void loadPrescriptions() {

        prescriptionList.clear();

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("Prescription.bin")
            );

            while (true) {
                Prescription p = (Prescription) ois.readObject();
                prescriptionList.add(p);
            }

        } catch (Exception e) {
            //
        }
    }
}
