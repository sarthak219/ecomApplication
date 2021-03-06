package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//represents the database of all users
public class AllUsers implements Writable {
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
    }

    //MODIFIES: this
    //EFFECTS: removes the user given username from allUsers
    public void removeUser(String username) {
        if (this.allUsers.removeIf(user -> user.getUsername().equals(username))) {
            System.out.println("User removed successfully!");
            return;
        }
        System.out.println("User not found!");
    }

    //EFFECTS: returns true if user with given username exists in allUsers, false otherwise
    public boolean containsWithUsername(String username) {
        for (User user : this.allUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of items in allItems
    public int size() {
        return allUsers.size();
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("users", allUsersToJson());
        return json;
    }

    // EFFECTS: returns users in this ArrayList of users as a JSON array
    private JSONArray allUsersToJson() {
        JSONArray jsonArray = new JSONArray();
        for (User user : allUsers) {
            jsonArray.put(user.toJson());
        }
        return jsonArray;
    }
}
