package ui;

import model.Admin;
import model.AllUsers;
import model.Collection;
import model.User;
import persistence.JsonReaderForAllUsers;
import persistence.JsonReaderForCollection;
import persistence.JsonWriterForAllUsers;
import persistence.JsonWriterForCollection;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Database {
    public static final String JSON_USER_DATABASE = "./data/users.json";
    public static final String JSON_ITEMS_DATABASE = "./data/items.json";
    protected User currentUser;
    protected Admin admin;
    protected AllUsers users;
    protected Collection allProducts;
    protected Display display;
    protected String[] userOptions = {"Show Products", "View Wishlist",
            "View Cart", "You Orders", "Log Out"};

    protected String[] adminOptions = {"Show Users",
            "Show Products", "Add Products", "Log Out"};
    
    protected JsonWriterForAllUsers jsonWriterForAllUsers;
    protected JsonReaderForAllUsers jsonReaderForAllUsers;
    protected JsonWriterForCollection jsonWriterForCollection;
    protected JsonReaderForCollection jsonReaderForCollection;

    public Database() {
        this.currentUser = new User();
        currentUser.makeGuestUser();
        this.users = new AllUsers();
        this.admin = new Admin();
        this.allProducts = new Collection();
        display = new Display();
        jsonWriterForAllUsers = new JsonWriterForAllUsers(JSON_USER_DATABASE);
        jsonReaderForAllUsers = new JsonReaderForAllUsers(JSON_USER_DATABASE);
        jsonWriterForCollection = new JsonWriterForCollection(JSON_ITEMS_DATABASE);
        jsonReaderForCollection = new JsonReaderForCollection(JSON_ITEMS_DATABASE);

        updateDatabases();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AllUsers getUsers() {
        return users;
    }

    public void setUsers(AllUsers users) {
        this.users = users;
    }

    public Collection getAllProducts() {
        return allProducts;
    }

    public String[] getUserOptions() {
        return userOptions;
    }

    public String[] getAdminOptions() {
        return adminOptions;
    }

    // EFFECTS: saves the allUsers to file
    protected void saveUsers() {
        try {
            jsonWriterForAllUsers.open();
            jsonWriterForAllUsers.write(users);
            jsonWriterForAllUsers.close();
            System.out.println("Changes saved to " + JSON_USER_DATABASE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_USER_DATABASE);
        }
    }

    // EFFECTS: saves the allUsers to file
    protected void saveItems() {
        try {
            jsonWriterForCollection.open();
            jsonWriterForCollection.write(allProducts);
            jsonWriterForCollection.close();
            System.out.println("Changes saved to " + JSON_ITEMS_DATABASE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_ITEMS_DATABASE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads allUsers from file
    protected void loadUsers() {
        try {
            users = jsonReaderForAllUsers.read();
            System.out.println("Loaded users from " + JSON_USER_DATABASE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_USER_DATABASE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads allProducts from file
    protected void loadItems() {
        try {
            allProducts = jsonReaderForCollection.read();
            System.out.println("Loaded items from " + JSON_ITEMS_DATABASE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_ITEMS_DATABASE);
        }
    }

    //EFFECTS: loads items and users from their respective source files
    public void updateDatabases() {
        new LoadingScreen("Loading files from " + JSON_ITEMS_DATABASE + " and " + JSON_USER_DATABASE);
        loadItems();
        loadUsers();
    }

    //MODIFIES: this
    //EFFECTS: saves items and users to their respective files
    public void saveEverything() {
        saveUsers();
        saveItems();
    }
}
