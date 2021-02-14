package model;

import java.util.ArrayList;

public class AllUsers {
    private final ArrayList<User> allUsers;

    public AllUsers() {
        this.allUsers = new ArrayList<>();
    }

    //EFFECTS: returns allUsers
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    //REQUIRES: User with same username should not already be present in allUsers
    //MODIFIES: this
    //EFFECTS: User will be added to allUsers
    public void insertUser(User user) {
        this.allUsers.add(user);
        System.out.println("Account created successfully!");
    }

    //MODIFIES: this
    //EFFECTS: removes the given User from allUsers
    public void removeUser(String username) {
        for (User u : allUsers) {
            if (u.getUsername().equals(username)) {
                allUsers.remove(u);
                System.out.println("User removed successfully!");
                return;
            }
        }
        System.out.println("User not found!");
    }


    //EFFECTS: returns true if the given username and password match with those of an existing user
    //false otherwise
    public boolean userAuthentication(String username, String password) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //TODO: Write tests
}
