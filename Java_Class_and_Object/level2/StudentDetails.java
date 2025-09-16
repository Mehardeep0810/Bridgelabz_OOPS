package Assigned6.level2;

class Student {
    String name;
    int rollNumber;
    int marks;

    String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    void displayReport() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentDetails{
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Mehardeep";
        s.rollNumber = 101;
        s.marks = 86;

        s.displayReport();
    }
}
    

