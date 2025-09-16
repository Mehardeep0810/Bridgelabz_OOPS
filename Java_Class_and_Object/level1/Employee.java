package Assigned6.level1;

public class Employee {
    String name;
    int id;
    double salary;

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.printf("Salary: "+ salary);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(); 
        emp1.name = "Mehardeep";
        emp1.id = 101;
        emp1.salary = 75000.00;

        emp1.displayDetails();
    }
}