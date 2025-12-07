import java.util.*;

public class Admin extends User {
    
    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password, "ADMIN");
    }
    
    public void addLecturer(Lecturer lecturer, List<Lecturer> lecturers) {

            System.out.println("Lecturer added: " + lecturer.getName());
        }
    }
    
    public void removeLecturer(int index, List<Lecturer> lecturers) {
            //;
    }
    
    public void viewAllUsers(List<User> users) {
        System.out.println("\n=== All Users ===");
        
    }
    
    public void viewAllProjects() {
        
    }

class Lecturer extends User {
    public Lecturer(String id, String name, String email, String password) {
        super(id, name, email, password, "LECTURER");
    }
}

class Project {
    private String id;
    private String title;
    private String status;
    
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
}