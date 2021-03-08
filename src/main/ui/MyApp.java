package ui;

import model.*;
import persistence.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//represents the application
public class MyApp {
    Scanner sc = new Scanner(System.in);
    private static final String JSON_USER_DATABASE = "./data/users.json";
    private static final String JSON_ITEMS_DATABASE = "./data/items.json";
    private User currentUser;
    private final Admin admin;
    private AllUsers users;
    private Collection allProducts;
    private final Display display;
    private final JsonWriterForAllUsers jsonWriterForAllUsers;
    private final JsonReaderForAllUsers jsonReaderForAllUsers;
    private final JsonWriterForCollection jsonWriterForCollection;
    private final JsonReaderForCollection jsonReaderForCollection;

    //MODIFIES: this
    //EFFECTS: Constructor for MyApp, creates a guest user and instantiates admin, user and JSON reader and writers,
    //         loads user and items database, directs the user to welcome screen
    public MyApp() {
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
        welcomeScreen();
    }

    //EFFECTS: A welcome page for the user
    public void welcomeScreen() {
        int choice;
        System.out.println("\nWelcome to my app!!!");
        while (true) {
            displayOptionsForWelcomePage();
            choice = sc.nextInt();
            sc.nextLine(); //To fix bug
            optionsForWelcomePage(choice);
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


    //EFFECTS: accepts a choice from the user and performs the selected task
    private void optionsForWelcomePage(int choice) {
        if (choice == 1) {
            if (adminLogin()) {
                adminHomepage();
            }
        } else if (choice == 2) {
            if (login()) {
                homePage();
            }
        } else if (choice == 3) {
            users.insertUser(createUser());
            System.out.println("Account created successfully!");
        } else if (choice == 4) {
            currentUser = new User();
            currentUser.makeGuestUser();
            homePage();
        } else {
            saveEverything();
            closeApp();
        }
    }

    //EFFECTS: displays all the options available for user in the homePage
    private void displayOptionsForHomePage() {
        System.out.println("\nHello " + currentUser.getFirstName() + "!!!");
        System.out.println("Enter a choice: ");
        System.out.println("0. EXIT");
        System.out.println("1. Show all products");
        System.out.println("2. Search for a product");
        System.out.println("3. Add items to wishlist");
        System.out.println("4. Remove items from wishlist");
        System.out.println("5. Add items to cart");
        System.out.println("6. Remove items from cart");
        System.out.println("7. View wishlist");
        System.out.println("8. View cart");
        System.out.println("9. Place order");
        System.out.println("10. View order history");
        System.out.println("11. Return a product");
        System.out.println("12. Logout");
    }

    //EFFECTS: Homepage for a user
    public void homePage() {
        int choice;
        while (true) {
            //setInStockToFalseForAll(currentUser.getOrderHistory(), 1001);
            displayOptionsForHomePage();
            choice = sc.nextInt();
            sc.nextLine(); //to fix bug
            if (choice > 0 && choice < 6) {
                optionsForHomePage1(choice);
            } else {
                optionsForHomePage2(choice);
            }
        }
    }

    //EFFECTS: performs the task according to the choice
    private void optionsForHomePage1(int choice) {
        if (choice == 1) {
            display.displayAllItems(allProducts);
        } else if (choice == 2) {
            display.searchAndShowProduct(allProducts);
        } else if (choice == 3) {
            addItemToWishlist();
        } else if (choice == 4) {
            removeItemFromWishlist();
        } else if (choice == 5) {
            addItemToCart();
        } else {
            System.out.println("Invalid input!");
        }
    }

    //EFFECTS: performs the task according to the choice
    private void optionsForHomePage2(int choice) {
        if (choice == 6) {
            removeItemFromCart();
        } else if (choice == 7) {
            display.displayWishlist(currentUser);
        } else if (choice == 8) {
            display.displayCart(currentUser);
        } else if (choice == 9) {
            placeOrder();
        } else if (choice == 10) {
            display.displayRecentOrders(currentUser);
        } else if (choice == 11) {
            returnItem();
        } else if (choice == 12) {
            logout();
        } else {
            saveEverything();
            closeApp();
        }
    }

    //EFFECTS: shows options for admin account
    private void displayOptionsForAdminHomepage() {
        System.out.println("Admin Homepage");
        System.out.println("Enter a choice: ");
        System.out.println("1. Display all users");
        System.out.println("2. Add products to stock");
        System.out.println("3. Display all products");
        System.out.println("4. Remove products from stock");
        System.out.println("5. Delete user profile");
        System.out.println("6. Logout from admin account");
    }

    //EFFECTS: homepage for admin account
    private void adminHomepage() {
        while (true) {
            displayOptionsForAdminHomepage();
            int choice = sc.nextInt();
            sc.nextLine();
            optionsForAdminHomepage(choice);
        }
    }

    //EFFECTS: performs the task according to the choice
    private void optionsForAdminHomepage(int choice) {
        if (choice == 1) {
            display.displayAllUsers(users);
        } else if (choice == 2) {
            allProducts.insertItem(getItem());
            System.out.println("Item added successfully!");
        } else if (choice == 3) {
            display.displayAllItems(allProducts);
        } else if (choice == 4) {
            allProducts.removeItem(getProductIdFromUser());
        } else if (choice == 5) {
            users.removeUser(getUsernameFromUser());
        } else if (choice == 6) {
            logout();
        } else {
            System.out.println("Invalid input!!!");
        }
    }


    //EFFECTS: returns the username entered by the user
    private String getUsernameFromUser() {
        System.out.println("Enter username of the profile you want to delete");
        return sc.nextLine();
    }

    //EFFECTS: returns the product id entered by the user
    private int getProductIdFromUser() {
        System.out.println("Enter product Id (any number except 0)");
        int id = sc.nextInt();
        sc.nextLine(); //to fix bug
        return id;
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
        if (admin.adminAuthentication(username, password)) {
            return true;
        }
        System.out.println("Username or password is incorrect!");
        return false;
    }

    //EFFECTS: Takes values for all the fields of an Item and returns
    //         an Item with those credentials
    public Item getItem() {
        Item item = new Item();
        item.setId(uniqueProductId());
        System.out.println("Enter name of the product:");
        item.setName(sc.nextLine());
        System.out.println("Enter brand of the product:");
        item.setBrand(sc.nextLine());
        System.out.println("Enter a small description of the product");
        item.setDescription(sc.nextLine());
        System.out.println("Enter price of the product(in CAD$)");
        item.setPrice(sc.nextFloat());
        sc.nextLine(); // to fix the nextInt() followed by nextLine() bug
        System.out.println("Enter gender category of the product(men/women/kids)");
        item.setCategory(sc.nextLine());
        System.out.println("Enter size of the product(XS/S/M/L/XL/XXL)");
        item.setSize(sc.nextLine());
        System.out.println("Enter colour of the product");
        item.setColour(sc.nextLine());
        System.out.println("Enter discount % of the product");
        item.setDiscount(sc.nextFloat());
        return item;
    }

    //EFFECTS: accepts a product id from the user and returns it if its unique
    private int uniqueProductId() {
        int t;
        System.out.println("Enter product ID (any number except 0)");
        while (true) {
            t = 0;
            int id = sc.nextInt();
            sc.nextLine(); //To fix bug
            for (Item item : allProducts.getAllProducts()) {
                if (id != 0 && item.getId() == id) {
                    System.out.println("A product with this id already exists! Enter again...");
                    t = 1;
                    break;
                }
            }
            if (t == 0) {
                return id;
            }
        }
    }

    //EFFECTS: Takes values for all the fields of a user and returns
    //         a User with those credentials
    public User createUser() {
        User person = new User();
        System.out.println("Enter first name");
        person.setFirstName(sc.nextLine());
        System.out.println("Enter last name");
        person.setLastName(sc.nextLine());
        person.setUsername(uniqueUsername());
        System.out.println("Enter your email");
        person.setEmailId(sc.nextLine());
        person.setPassword(confirmPassword());
        System.out.println("Enter mobile number");
        person.setMobileNumber(sc.nextLine());
        System.out.println("Enter your age");
        person.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter gender(male/female/other)");
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
    private String confirmPassword() {
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
    //EFFECTS: logs in the user by setting currentUser to the user with the given credentials
    public boolean login() {
        String username;
        String password;

        System.out.println("Enter username");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();

        if (users.userAuthentication(username, password)) {
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

    //MODIFIES: this
    //EFFECTS: adds the item which the user enters in its wishlist
    private void addItemToWishlist() {
        int choice;
        int id = getProductIdFromUser();
        for (Item item : allProducts.getAllProducts()) {
            if (item.getId() == id) {
                if (currentUser.getWishlist().contains(item)) {
                    System.out.println("The item is already in the wishlist!");
                    return;
                }
                if (currentUser.inCart(item)) {
                    System.out.println("Item is already in cart, do you want to move it to wishlist?(1-yes, 2-no)");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        currentUser.removeItemsFromCart(item);
                    } else {
                        return;
                    }
                }
                currentUser.addItemToWishlist(item);
                System.out.println("Item successfully added to wishlist!!!");
                return;
            }
        }
        System.out.println("Item not found! Please enter a valid product ID");
    }


    //MODIFIES: this
    //EFFECTS: adds the item which the user enters in its cart
    private void addItemToCart() {
        int id = getProductIdFromUser();
        for (Item item : allProducts.getAllProducts()) {
            if (item.getId() == id && item.getInStock()) {
                if (currentUser.getCart().contains(item)) {
                    System.out.println("The item is already in the cart!");
                    return;
                }
                if (currentUser.inWishlist(item)) {
                    currentUser.removeItemsFromWishlist(item);
                }
                currentUser.addItemToCart(item);
                System.out.println("Item successfully added to cart!!!");
                return;
            }
        }
        System.out.println("Item not found! Please enter a valid product ID");
    }

    //MODIFIES: this
    //EFFECTS: removes item from the wishlist
    private void removeItemFromWishlist() {
        int id = getProductIdFromUser();
        for (Item item : currentUser.getWishlist()) {
            if (item.getId() == id) {
                currentUser.removeItemsFromWishlist(item);
                System.out.println("Item successfully removed!!!");
                return;
            }
        }
        System.out.println("Item not found in wishlist! Please enter a valid product ID");
    }

    //MODIFIES: this
    //EFFECTS: removes item from the cart
    private void removeItemFromCart() {
        int id = getProductIdFromUser();
        for (Item item : currentUser.getCart()) {
            if (item.getId() == id) {
                currentUser.removeItemsFromCart(item);
                System.out.println("Item successfully removed!!!");
                return;
            }
        }
        System.out.println("Item not found in cart! Please enter a valid product ID");
    }

    //MODIFIES: this
    //EFFECTS: Orders all the products in the cart and makes the item out of stock
    private void placeOrder() {
        if (currentUser.getCart().size() == 0) {
            System.out.println("Your cart is empty, please add products to it first.");
            return;
        }
        int choice;
        float bill = currentUser.totalBill();
        display.displayCart(currentUser);
        System.out.println("All these items will be ordered, and your order will amount to "
                + bill + " CAD$" + " do you wish to continue?" + "(enter 1 for yes & 0 for no)");
        choice = sc.nextInt();
        sc.nextLine();
        if (choice == 0) {
            System.out.println("Action aborted, no order was placed.");
            return;
        }
        for (Item item : currentUser.getCart()) {
            currentUser.addItemToOrderHistory(item);
            setInStockToFalseForAll(currentUser.getOrderHistory(), item.getId());
            item.setInStock(false);
        }
        currentUser.setCart(new ArrayList<>());
        System.out.println("Order successfully placed! Your order will be delivered within 2 days."
                + " Please keep " + bill + " CAD$ ready with you!");
    }

    //MODIFIES: this
    //EFFECTS: sets inStock to false for all occurrences of Item with the given id
    private void setInStockToFalseForAll(ArrayList<Item> items, int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setInStock(false);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: sets the Item back in stock if it hasn't been returned earlier
    private void returnItem() {
        float returnAmount;
        int itemIndex;
        display.displayRecentOrders(currentUser);
        int id = getProductIdFromUser();
        if (currentUser.orderHistoryContainsItemWithId(id)) {
            for (Item item : currentUser.getOrderHistory()) {
                if (item.getId() == id) {
                    itemIndex = currentUser.getOrderHistory().indexOf(item);
                    if (item.getInStock()) {
                        System.out.println("You have already returned this item!");
                        return;
                    }
                    currentUser.getOrderHistory().get(itemIndex).setInStock(true);
                }
            }
            returnAmount = setInStockToTrueInAllProducts(id);
            System.out.println("Item returned successful! Refund of " + returnAmount + " CAD$ has been initiated!");
        } else {
            System.out.println("Item not found in order history");
        }
    }

    //MODIFIES: this
    //EFFECTS: sets InStock to true for the item with given id in allProducts
    //         and returns the price of the item after discount
    private float setInStockToTrueInAllProducts(int id) {
        float returnAmount = 0;
        for (Item item : allProducts.getAllProducts()) {
            if (item.getId() == id) {
                returnAmount = item.getPrice() - item.getPrice() * item.getDiscount() / 100;
                item.setInStock(true);
                break;
            }
        }
        return returnAmount;
    }

    //MODIFIES: this
    //EFFECTS: logs the user out and returns to welcome page
    private void logout() {
        System.out.println("You have logged out successfully!");
        welcomeScreen();
    }


    //EFFECTS: closes the application
    private void closeApp() {
        System.out.println("Closing the app....");
        System.out.println("Goodbye! Thanks for using!");
        System.exit(0);
    }

    // EFFECTS: saves the allUsers to file
    private void saveUsers() {
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
    private void saveItems() {
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
    private void loadUsers() {
        try {
            users = jsonReaderForAllUsers.read();
            System.out.println("Loaded users from " + JSON_USER_DATABASE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_USER_DATABASE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads allProducts from file
    private void loadItems() {
        try {
            allProducts = jsonReaderForCollection.read();
            System.out.println("Loaded users from " + JSON_ITEMS_DATABASE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_ITEMS_DATABASE);
        }
    }

    //EFFECTS: loads items and users from their respective source files
    private void updateDatabases() {
        loadItems();
        loadUsers();
    }

    //MODIFIES: this
    //EFFECTS: saves items and users to their respective files
    private void saveEverything() {
        saveUsers();
        saveItems();
    }
}