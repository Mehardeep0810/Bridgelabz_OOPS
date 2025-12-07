package File_Input_Output_Streams;

import java.io.*;

public class StudentDataStreamDemo {
    public static void main(String[] args) {
        String filename = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            
            dos.writeInt(101);              
            dos.writeUTF("Alice");          
            dos.writeDouble(8.5);           

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.9);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.2);

            System.out.println("Student details written to " + filename);
        } catch (IOException e) {
            System.out.println("IOException during writing: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nReading student details from file:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("IOException during reading: " + e.getMessage());
        }
    }
}

