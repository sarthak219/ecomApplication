package ui;

import model.AllUsers;
import model.User;

import java.util.Scanner;

public class MyApp {
    Scanner sc = new Scanner(System.in);
    private User currentUser;
    private final AllUsers users;

    //MODIFIES: this
    //EFFECTS: Constructor for MyApp, creates a guest user
    public MyApp(AllUsers users) {
        this.currentUser = new User();
        currentUser.makeGuestUser();
        this.users = users;
    }

    //EFFECTS: A welcome page for the user
    public void welcomeScreen() {
        int choice;
        System.out.println("\n\nWelcome to my app!!!");
        while (true) {
            displayOptionsForWelcomePage();
            choice = sc.nextInt();
            sc.nextLine(); //To fix bug
            switch (choice) {
                case 1:
                    if (login()) {
                        homePage();
                    }
                    break;
                case 2:
                    users.insertUser(createUser());
                    System.out.println("New user created successfully!");
                    break;
                case 3:
                    homePage();

                default:
                    System.out.println("Exiting app....\n" + "Thanks for using!");
                    System.exit(0);
            }
        }
    }

    //EFFECTS: Homepage for a user
    public void homePage() {
        int choice;
        while (true) {
            displayOptionsForHomePage();
            choice = sc.nextInt();
            sc.nextLine(); //to fix bug
            switch (choice) {
                case 0:
                    System.out.println("Exiting app....");
                    System.out.println("Thanks for using!");
                    System.exit(0);
                    break;

                case 1:
                    searchProduct();
                    break;

                case 5:
                    logout();
                    break;

                default:
                    System.out.println("Invalid input!");
            }
        }

    }

    //EFFECTS: prints all the options available for user in the welcomePage
    public void displayOptionsForWelcomePage() {
        System.out.println("Choose one of the options");
        System.out.println("0. EXIT");
        System.out.println("1. Log into existing account");
        System.out.println("2. Create new account");
        System.out.println("3. Login as guest");
    }

    //EFFECTS: prints all the options available for user in the homePage
    public void displayOptionsForHomePage() {
        System.out.println("\nHello " + currentUser.getFirstName() + "!!!");
        System.out.println("Enter a choice: ");
        System.out.println("0. EXIT");
        System.out.println("1. Search for a product");
        System.out.println("2. Show products");
        System.out.println("3. View cart");
        System.out.println("4. View wishlist");
        System.out.println("5. Logout");
    }

    //creates a new user and adds it to allUsers
    public User createUser() {
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
    private String authenticatePassword() {
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

    //EFFECTS: logs the user in by accepting username and password
    public boolean login() {
        String username;
        String password;

        System.out.println("Enter username");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();

        if (userAuthentication(username, password)) {
            for (User user : users.getAllUsers()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    this.currentUser = user;
                    System.out.println("Login Successful!");
                    return true;
                }
            }
        }
        System.out.println("Username or password is incorrect!");
        return false;
    }

    public boolean userAuthentication(String username, String password) {
        for (User user : users.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void searchProduct() {
        System.out.println("Search method");
        //stub
    }


    public void logout() {
        this.currentUser.makeGuestUser();
        System.out.println("You have logged out successfully!");
        welcomeScreen();
    }
}
