package ui;

import model.AllUsers;
import model.Collection;
import model.Item;
import model.User;

import java.util.Scanner;

//represents the class which displays the databases
public class Display {
    Scanner sc = new Scanner(System.in);

    //EFFECTS: adds a horizontal line of to separate rows of a table
    private void addLineToDisplayUser() {
        System.out.print("+-------+---------------------+----------------------+---------------------+-----------------"
                + "----------------------------------+---------------------+----------------+------+-----"
                + "------+\n");
    }

    //EFFECTS: displays the header row for the table of displayAllUsers
    private void userTableHeader() {
        System.out.printf("| %-6s| %-20s|  %-20s| %-20s| %-50s| %-20s| %-15s| %-5s| %-10s| \n",
                "SNo.", "First Name", "Last Name", "Username", "Email", "Password", "Mobile Number", "Age",
                "Gender");
    }

    //EFFECTS: displays list of all the users in a tabular format
    public void displayAllUsers(AllUsers users) {
        System.out.println("\nAll Users");
        addLineToDisplayUser();
        userTableHeader();
        addLineToDisplayUser();
        for (int i = 0; i < users.getAllUsers().size(); i++) {
            System.out.printf("| %-6d", i + 1);
            users.getAllUsers().get(i).showUser();
        }
        addLineToDisplayUser();
    }


    //EFFECTS: adds a horizontal line of to separate rows of a table
    private void addLineToDisplayProducts() {
        System.out.print("+-------+-------+---------------------+---------------------+-------------------"
                + "--------------------------------+--------------+----------+-------+-----------+--------------+"
                + "----------+ \n");
    }

    //EFFECTS: displays the header row for the table of displayAllItems
    private void productsTableHeader() {
        System.out.printf("| %-6s| %-6s| %-20s| %-20s| %-50s| %-13s| %-9s| %-6s| %-10s| %-13s| %-9s|\n",
                "SNo.", "ID", "Name", "Brand", "Description", "Price(CAD$)", "Category", "Size",
                "Colour", "Discount (%)", "inStock");
    }

    //EFFECTS: displays all the products
    public void displayAllItems(Collection allProducts) {
        System.out.println("\nAll Products");
        addLineToDisplayProducts();
        productsTableHeader();
        addLineToDisplayProducts();
        for (int i = 0; i < allProducts.size(); i++) {
            System.out.printf("| %-6d", i + 1);
            allProducts.getAllProducts().get(i).showItem();
        }
        addLineToDisplayProducts();
    }

    //EFFECTS: Searches allItems and displays those which match the search criteria
    public void searchAndShowProduct(Collection allProducts) {
        int i = 1;
        System.out.println("Enter name of product to search");
        String name = sc.nextLine();
        System.out.println("Search Results");
        addLineToDisplayProducts();
        productsTableHeader();
        addLineToDisplayProducts();
        for (Item item : allProducts.getAllProducts()) {
            if (item.getName().contains(name)) {
                System.out.printf("| %-6s ", i);
                item.showItem();
                ++i;
            }
        }
        addLineToDisplayProducts();
        if (i == 0) {
            System.out.println("No items found");
        }
    }

    //EFFECTS: Displays the user's wishlist in tabular form
    public void displayWishlist(User user) {
        int i = 1;
        System.out.println(user.getFirstName() + "'s Wishlist:");
        addLineToDisplayProducts();
        productsTableHeader();
        addLineToDisplayProducts();
        for (Item item : user.getWishlist()) {
            System.out.printf("| %-6s ", i);
            item.showItem();
            ++i;
        }
        addLineToDisplayProducts();
    }

    //EFFECTS: Displays the user's cart in tabular form
    public void displayCart(User user) {
        int i = 1;
        System.out.println(user.getFirstName() + "'s Cart:");
        addLineToDisplayProducts();
        productsTableHeader();
        addLineToDisplayProducts();
        for (Item item : user.getCart()) {
            System.out.printf("| %-6s ", i);
            item.showItem();
            ++i;
        }
        addLineToDisplayProducts();
    }

    //EFFECTS: Displays user's order history tabular form
    public void displayRecentOrders(User user) {
        int i = 1;
        System.out.println(user.getFirstName() + "'s Order History:");
        addLineToDisplayProducts();
        productsTableHeader();
        addLineToDisplayProducts();
        for (Item item : user.getOrderHistory()) {
            System.out.printf("| %-6s ", i);
            item.showItem();
            ++i;
        }
        addLineToDisplayProducts();
    }
}
