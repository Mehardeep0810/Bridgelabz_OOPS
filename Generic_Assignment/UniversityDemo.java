import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) { super(name); }
    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) { super(name); }
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) { super(name); }
    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}


class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(String department, T courseType) {
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() { return courseType; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Department: " + department +
               ", Course: " + courseType.getName() +
               ", Evaluation: " + courseType.getEvaluationMethod();
    }
}

class UniversityUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getName() + " - " + course.getEvaluationMethod());
        }
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
    
        ExamCourse mathExam = new ExamCourse("Mathematics 101");
        AssignmentCourse csAssignment = new AssignmentCourse("Data Structures");
        ResearchCourse aiResearch = new ResearchCourse("AI Research Project");

        Course<ExamCourse> examCourse = new Course<>("Science Dept", mathExam);
        Course<AssignmentCourse> assignmentCourse = new Course<>("Computer Science Dept", csAssignment);
        Course<ResearchCourse> researchCourse = new Course<>("Research Dept", aiResearch);

        System.out.println("Individual Courses:");
        System.out.println(examCourse);
        System.out.println(assignmentCourse);
        System.out.println(researchCourse);

        System.out.println("\nWildcard Display:");
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(mathExam);
        allCourses.add(csAssignment);
        allCourses.add(aiResearch);

        UniversityUtils.displayCourses(allCourses);
    }
}
