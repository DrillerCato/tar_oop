import java.util.*;

public class Lecturer extends User {

    private String department;
    private List<String> backgrounds;
    private List<String> researchAreas;
    private List<Request> inbox;
    private List<Project> supervisees;
    private int maxSupervisees;
    
    public Lecturer(String id, String name, String email, String password, String department, int maxSupervisees) {

        super(id, name, email, password, "LECTURER");
        
        this.department = department;
        this.maxSupervisees = maxSupervisees;
        this.backgrounds = new ArrayList<>();
        this.researchAreas = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.supervisees = new ArrayList<>();

    }