package model;

import java.util.ArrayList;
import java.util.Scanner;

public class AllUsers {
    Scanner sc = new Scanner(System.in);

    private ArrayList<User> allUsers;

    public AllUsers() {
        this.allUsers = new ArrayList<>();
    }

    //EFFECTS: Creates a new user profile by using credentials from the user
    public User registerNewUser() {
        User person = new User();
        System.out.println("Enter first name");
        person.setFirstName(sc.nextLine());
        System.out.println("Enter last name");
        person.setLastName(sc.nextLine());
        System.out.println("Enter username");
        person.setUsername(sc.nextLine());
        System.out.println("Enter your email");
        person.setEmailId(sc.nextLine());
        person.setPassword(authenticatePassword());
        System.out.println("Enter mobile number");
        person.setMobileNumber(sc.nextLine());
        System.out.println("Enter your age");
        person.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter gender");
        person.setGender(sc.nextLine());
        return person;
    }

    //EFFECTS: returns user entered password if both passwords match
    public String authenticatePassword() {
        while (true) {
            System.out.println("Enter password");
            String pass1 = sc.nextLine();
            System.out.println("Confirm password");
            String pass2 = sc.nextLine();

            if (pass1.equals(pass2)) {
                return pass1;
            } else {
                System.out.println("Passwords don't match! Enter again...");
            }
        }
    }

    //REQUIRES: User with same username should not already be present in allUsers
    //MODIFIES: this
    //EFFECTS: Item will be added to allUsers
    public void insertUser(User user) {
        if (!allUsers.contains(user)) {
            this.allUsers.add(user);
        } else {
            System.out.println("ERROR! Item already exists in the list");
        }
    }

    // EFFECTS: Returns true if User u is in allUsers,
    // false otherwise
    public boolean contains(User u) {
        return allUsers.contains(u);
    }

    //EFFECTS: Returns true if Item with name n is present in allItems
    public boolean containsWithName(String n) {
        for (User i : this.allUsers) {
            if (i.getUsername().equals(n)) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: adds a horizontal line of to separate rows of a table
    private void addLine() {
        System.out.print("+-------+---------------------+---------------------+--------------------------------------"
                + "-------------+--------+----------+----------------+-------+-----------+-----------+----------+\n");
    }

    public void displayAllUsers() {
        addLine();
        System.out.printf("| %-6s| %-20s| %-20s| %-50s| %-7s| %-9s| %-15s| %-6s| %-10s| %-10s| %-9s|\n",
                "SNo.", "Name", "Brand", "Description", "Price", "Category", "Type", "Size",
                "Colour", "Discount", "inStock");

        addLine();
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.printf("| %-6d", i + 1);
            allUsers.get(i).showUser();
        }
        addLine();
    }

    public void login() {
        //stub
    }

    //TODO: Implement insertUser()
    //TODO: Implement displayUser()
    //TODO: Write tests
    //TODO: Implement Login feature
}
