
class Person{
    String name;
    int age;
}
class Teacher extends Person{
    String subject;
    public void displayRole(){
        System.out.println("I am a teacher");
        System.out.println("Subject: " + subject);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person{
    String grade;
    public void displayRole(){
        System.out.println("I am a student");
        System.out.println("Grade: " + grade);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Staff extends Person{
    String department;
    public void displayRole(){
        System.out.println("I am a staff member");
        System.out.println("Department: " + department);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {

        Teacher t1 = new Teacher();
        t1.name = "Mr. Smith";
        t1.age = 35;
        t1.subject = "Math";
        t1.displayRole();

        Student s1 = new Student();
        s1.name = "Bob";
        s1.age = 16;
        s1.grade = "10th";
        s1.displayRole();

        Staff st1 = new Staff();
        st1.name = "Mrs. Johnson";
        st1.age = 45;
        st1.department = "Administration";
        st1.displayRole();
    }
}
