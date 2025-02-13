package com.javastreams.problem7;

import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem7\\students.txt";

        // Writing student details
        writeStudentData(fileName);

        // Reading and displaying student details
        readStudentData(fileName);
    }

    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Sahil"); // Name
            dos.writeDouble(8.5); // GPA

            dos.writeInt(102);
            dos.writeUTF("Rahul");
            dos.writeDouble(9.2);

            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
