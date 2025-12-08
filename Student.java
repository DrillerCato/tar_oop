import java.util.*;

public class Student extends User {
    private String programme;
    private String department;
    private List<Project> projects;
    
    public Student(String id, String name, String email, String password, String programme, String department) {

        super(id, name, email, password, "STUDENT");
        this.programme = programme;
        this.department = department;
        this.projects = new ArrayList<>();
        
    }
    

    public String getProgramme() {
        return programme;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }


    public void setProgramme(String programme) {
        this.programme = programme;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Programme: " + programme + " Department: " + department + " Projects: " + projects.size();
    }
}