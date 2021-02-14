package model;

public class Admin extends User {

    public Admin() {
        this.username = "admin123";
        this.password = "Admin@12345";
    }

    //EFFECTS: returns true if admin username and password match with the given username and password
    // false otherwise
    public boolean adminAuthentication(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
