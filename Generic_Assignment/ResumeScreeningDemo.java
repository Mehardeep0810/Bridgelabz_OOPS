import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() { return candidateName; }

    public abstract String evaluateResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) { super(candidateName); }
    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Software Engineer role (skills: Java, Spring, REST APIs)";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) { super(candidateName); }
    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Data Scientist role (skills: Python, ML, Statistics)";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) { super(candidateName); }
    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Product Manager role (skills: Strategy, Communication, Leadership)";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() { return jobRole; }

    public void processResume() {
        System.out.println(jobRole.evaluateResume());
    }
}

class ScreeningUtils {
    public static <T extends JobRole> void processSingleResume(Resume<T> resume) {
        resume.processResume();
    }

    public static void processMultipleResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println(role.evaluateResume());
        }
    }
}

public class ResumeScreeningDemo {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        System.out.println("Processing Single Resumes:");
        ScreeningUtils.processSingleResume(seResume);
        ScreeningUtils.processSingleResume(dsResume);
        ScreeningUtils.processSingleResume(pmResume);

        System.out.println("\nProcessing Multiple Resumes:");
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer("David"));
        allResumes.add(new DataScientist("Eva"));
        allResumes.add(new ProductManager("Frank"));

        ScreeningUtils.processMultipleResumes(allResumes);
    }
}
