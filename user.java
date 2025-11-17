public abstract class User {

    private String username;
    private String password;
    private String email;
    
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    //
    public String getUsnm() {
        return username;
    }

    public String getPswd() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setUsnm(String username) {
        this.username = username;
    }

    public void setPswd(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getRole();
}