package Assigned10;

import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }

    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    public void addRecord(String record) {
        addToHistory("InPatient Record: " + record);
    }

    public void viewRecords() {
        System.out.println("Medical History for InPatient:");
        for (String record : getMedicalHistory()) {
            System.out.println(record);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        addToHistory("OutPatient Record: " + record);
    }

    public void viewRecords() {
        System.out.println("Medical History for OutPatient:");
        for (String record : getMedicalHistory()) {
            System.out.println(record);
        }
    }
}

public class HospitalSystem {
    public static void processPatient(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Diagnosis: " + patient.getDiagnosis());
        System.out.println("Total Bill: ₹" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            ((MedicalRecord) patient).viewRecords();
        }

        System.out.println("-----");
    }

    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "Mehardeep", 30, "Pneumonia", 5, 1500);
        Patient p2 = new OutPatient("P002", "Aman", 25, "Flu", 500);

        ((MedicalRecord) p1).addRecord("Admitted to ICU");
        ((MedicalRecord) p2).addRecord("Prescribed antibiotics");

        processPatient(p1);
        processPatient(p2);
    }
}
