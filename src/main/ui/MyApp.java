package ui;

import model.*;

import java.util.Scanner;

public class MyApp {
    Scanner sc = new Scanner(System.in);
    private User currentUser;
    private final Admin admin;
    private final AllUsers users;
    private final Collection allProducts;

    //MODIFIES: this
    //EFFECTS: Constructor for MyApp, creates a guest user and instantiates admin and user
    public MyApp() {
        this.currentUser = new User();
        currentUser.makeGuestUser();
        this.users = new AllUsers();
        this.admin = new Admin();
        this.allProducts = new Collection();
    }

    //EFFECTS: A welcome page for the user
    public void welcomeScreen() {
        int choice;
        System.out.println("\n\nWelcome to my app!!!");
        while (true) {
            displayOptionsForWelcomePage();
            choice = sc.nextInt();
            sc.nextLine(); //To fix bug
            optionsForWelcomePage(choice);
        }
    }

    //EFFECTS: prints all the options available for user in the homePage
    private void displayOptionsForHomePage() {
        System.out.println("\nHello " + currentUser.getFirstName() + "!!!");
        System.out.println("Enter a choice: ");
        System.out.println("0. EXIT");
        System.out.println("1. Search for a product");
        System.out.println("2. Show products");
        System.out.println("3. View cart");
        System.out.println("4. View wishlist");
        System.out.println("5. Logout");
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
    private void displayOptionsForWelcomePage() {
        System.out.println("Choose one of the options");
        System.out.println("0. EXIT");
        System.out.println("1. Login as admin");
        System.out.println("2. Log into existing account");
        System.out.println("3. Create new account");
        System.out.println("4. Login as guest");
    }

    private void optionsForWelcomePage(int choice) {
        switch (choice) {
            case 1:
                if (adminLogin()) {
                    adminHomepage();
                }
                break;
            case 2:
                if (login()) {
                    homePage();
                }
                break;
            case 3:
                users.insertUser(createUser());
                System.out.println("New user created successfully!");
                break;
            case 4:
                currentUser = new User();
                currentUser.makeGuestUser();
                homePage();

            default:
                System.out.println("Exiting app....\n" + "Thanks for using!");
                System.exit(0);
        }
    }

    //EFFECTS: shows options for admin account
    private void displayOptionsForAdminHomepage() {
        System.out.println("Admin Homepage");
        System.out.println("Enter a choice: ");
        System.out.println("1. Show all users");
        System.out.println("2. Add products to stock");
        System.out.println("3. Display all products");
        System.out.println("4. Remove products from stock");
        System.out.println("5. Logout from admin account");
    }

    //EFFECTS: homepage for admin account
    private void adminHomepage() {
        while (true) {
            displayOptionsForAdminHomepage();
            int choice = sc.nextInt();
            //sc.nextLine(); //to fix bug
            switch (choice) {
                case 1:
                    displayAllUsers();
                    break;
                case 2:
                    allProducts.insertItem(getItem());
                    break;
                case 3:
                    allProducts.displayAllItems();
                    break;
                case 4:
                    allProducts.removeItem(getItemNameFromUser());
                    break;
                case 5:
                    logout();
                    break;
                default:
                    System.out.println("Invalid input!!!");
            }
        }
    }

    //EFFECTS:
    private String getItemNameFromUser() {
        sc.nextLine(); //to fix bug
        System.out.println("Enter name of the item");
        return sc.nextLine();
    }

    //EFFECTS: accepts username and password for admin account and
    //         logs into admin account if they are valid
    private boolean adminLogin() {
        String username;
        String password;

        System.out.println("Enter username");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();

        if (adminAuthentication(username, password)) {
            return true;
        }
        System.out.println("Username or password is incorrect!");
        return false;
    }

    //EFFECTS: returns true if admin username and password match with the given username and password
    // false otherwise
    private boolean adminAuthentication(String username, String password) {
        return this.admin.getUsername().equals(username) && this.admin.getPassword().equals(password);
    }

    //EFFECTS: Takes values for all the fields of an Item and returns
    //         and Item with those credentials
    public Item getItem() {
        Item item = new Item();
        sc.nextLine();
        System.out.println("Enter name of the product:");
        item.setName(sc.nextLine());
        System.out.println("Enter brand of the product:");
        item.setBrand(sc.nextLine());
        System.out.println("Enter a small description of the product");
        item.setDescription(sc.nextLine());
        System.out.println("Enter price of the product");
        item.setPrice(sc.nextInt());
        sc.nextLine(); // to fix the nextInt() followed by nextLine() bug
        System.out.println("Enter gender category of the product(men/women/kids)");
        item.setCategory(sc.nextLine());
        System.out.println("Enter type of product(t-shirt/jeans/suit/shirt/pant/dress/gown/frock)");
        item.setType(sc.nextLine());
        System.out.println("Enter size of the product");
        item.setSize(sc.nextLine());
        System.out.println("Enter colour of the product");
        item.setColour(sc.nextLine());
        System.out.println("Enter discount % of the product");
        item.setDiscount(sc.nextInt());
        return item;
    }

    //creates a new user and adds it to allUsers
    public User createUser() {
        User person = new User();
        System.out.println("Enter first name");
        person.setFirstName(sc.nextLine());
        System.out.println("Enter last name");
        person.setLastName(sc.nextLine());
        person.setUsername(uniqueUsername());
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

    //EFFECTS: returns the accepted username if it is not already taken by another user
    private String uniqueUsername() {
        int t;
        System.out.println("Enter username");
        while (true) {
            t = 0;
            String username = sc.nextLine();
            for (User user : users.getAllUsers()) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already taken! Enter again...");
                    t = 1;
                    break;
                }
            }
            if (t == 0) {
                return username;
            }
        }
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

    //MODIFIES: this
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

    private boolean userAuthentication(String username, String password) {
        for (User user : users.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    //EFFECTS: adds a horizontal line of to separate rows of a table
    private void addLineToDisplayUser() {
        System.out.print("+-------+---------------------+----------------------+---------------------+-----------------"
                + "----------------------------------+---------------------+----------------+------+-----"
                + "------+\n");
    }

    public void displayAllUsers() {
        addLineToDisplayUser();
        System.out.printf("| %-6s| %-20s|  %-20s| %-20s| %-50s| %-20s| %-15s| %-5s| %-10s| \n",
                "SNo.", "First Name", "Last Name", "Username", "Email", "Password", "Mobile Number", "Age",
                "Gender");

        addLineToDisplayUser();
        for (int i = 0; i < this.users.getAllUsers().size(); i++) {
            System.out.printf("| %-6d", i + 1);
            users.getAllUsers().get(i).showUser();
        }
        addLineToDisplayUser();
    }

    //EFFECTS: Searches allItems and displays those which match the search criteria
    public void searchProduct() {
        System.out.println("Search method");
        //stub
    }

    //MODIFIES: this
    //EFFECTS: logs the user out and returns to welcome page
    public void logout() {
        //this.currentUser.makeGuestUser();
        System.out.println("You have logged out successfully!");
        welcomeScreen();
    }
}
