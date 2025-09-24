

class Course{
    String courseName = "Java";
    String Duration = "3 months";
}
class OnlineCourse extends Course{
    String platform = "Udemy";
    Boolean isRecoded = true;
}
class PaidOnlineCourse extends OnlineCourse{
    int Fee = 500;
    int Discount = 50;
    public void displayDetails(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + Duration);
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + isRecoded);
        System.out.println("Fee: " + Fee);
        System.out.println("Discount: " + Discount);
        System.out.println("Final Fee after Discount: " + (Fee - Discount));
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        PaidOnlineCourse paidCourse = new PaidOnlineCourse();
        paidCourse.displayDetails();
    }
}
