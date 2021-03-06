package ui.screens;

import ui.Database;
import model.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents a dialogue box asking user to either add/remove given item to/from card,
 * add/remove item to/from wishlist, buy an item or return an item or delete an item from store if
 * the user is admin
 */
public class DialogueBox extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 105;
    protected Item item;
    protected Database database;
    protected String loggedInPerson;
    protected Border border;
    protected JButton wishlistButton;
    protected JButton cartButton;
    protected JButton orderOrReturnButton;
    protected JButton deleteButton;

    //EFFECTS: initialises the dialogue box according to the logged in person
    public DialogueBox(Item item, Database database, String loggedInPerson) {
        this.item = item;
        this.loggedInPerson = loggedInPerson;
        this.database = database;
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseGraphics();
        if (loggedInPerson.equalsIgnoreCase("user")) {
            initialiseWishlistButton();
            initialiseCartButton();
            initialiseOrderOrReturnButton();
        } else if (loggedInPerson.equalsIgnoreCase("admin")) {
            initialiseDeleteItemButton();
        }
        setVisible(true);
    }

    //EFFECTS: initialises the dialogue box
    public void initialiseGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(23, 23, 23));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    //EFFECTS: creates a button to add/remove items from the current user's wishlist
    public void initialiseWishlistButton() {
        if (database.getCurrentUser().wishListContainsItemWithId(item.getId())) {
            wishlistButton = new JButton("Remove from Wishlist");
            wishlistButton.addActionListener(e -> {
                removeFromWishlistWithId(this.item.getId());
                JOptionPane.showMessageDialog(null, "Item removed successfully and changes saved!");
                database.saveEverything();
                dispose();
            });
        } else {
            wishlistButton = new JButton("Add to Wishlist");
            wishlistButton.addActionListener(e -> {
                database.getCurrentUser().addItemToWishlist(item);
                JOptionPane.showMessageDialog(null, "Item added successfully and changes saved!");
                database.saveEverything();
                dispose();
            });
        }
        setupButton(wishlistButton);
        add(wishlistButton);
    }

    //MODIFIES: this
    //EFFECTS: removes the item with the given id from wishlist
    private void removeFromWishlistWithId(int id) {
        for (Item item : database.getCurrentUser().getWishlist()) {
            if (item.getId() == id) {
                database.getCurrentUser().removeItemsFromWishlist(item);
                return;
            }
        }
    }

    //EFFECTS: creates a button to add/remove items from the current user's cart
    public void initialiseCartButton() {
        if (database.getCurrentUser().cartContainsItemWithId(item.getId())) {
            cartButton = new JButton("Remove from Cart");
            cartButton.addActionListener(e -> {
                removeFromCartWithId(item.getId());
                JOptionPane.showMessageDialog(null, "Item removed successfully and changes saved!");
                database.saveEverything();
                dispose();
            });
        } else {
            cartButton = new JButton("Add to Cart");
            cartButton.addActionListener(e -> {
                database.getCurrentUser().addItemToCart(item);
                JOptionPane.showMessageDialog(null, "Item added successfully and changes saved!");
                database.saveEverything();
                dispose();
            });
        }
        setupButton(cartButton);
        add(cartButton);
    }

    //MODIFIES: this
    //EFFECTS: removes the item with the given id from cart
    private void removeFromCartWithId(int id) {
        for (Item item : database.getCurrentUser().getCart()) {
            if (item.getId() == id) {
                database.getCurrentUser().removeItemsFromCart(item);
                return;
            }
        }
    }

    //EFFECTS: creates a button to order or return an item
    public void initialiseOrderOrReturnButton() {
        if (database.getCurrentUser().orderHistoryContainsItemWithId(item.getId()) && !item.getInStock()) {
            orderOrReturnButton = new JButton("Return Item");
            orderOrReturnButton.addActionListener(e -> {
                returnItem(item);
                dispose();
            });
        } else {
            orderOrReturnButton = new JButton("Buy Now");
            orderOrReturnButton.addActionListener(e -> {
                orderOneItem(item);
                dispose();
            });
        }
        setupButton(orderOrReturnButton);
        add(orderOrReturnButton);
    }


    //MODIFIES: this
    //EFFECTS: orders the given item if user approves
    public void orderOneItem(Item item) {
        if (item.getInStock()) {
            float price = item.getPrice();
            float priceAfterDiscount = price - (price * item.getDiscount()) / 100;
            String message = "The item would cost CAD$" + priceAfterDiscount + "\nAre you sure you want proceed?";
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                database.getCurrentUser().orderItem(item);
                database.getCurrentUser().removeItemsFromCart(item);
                database.getCurrentUser().removeItemsFromWishlist(item);
                JOptionPane.showMessageDialog(null, "Order Placed successfully!\nIt will be delivered within 2 days.");
                database.saveEverything();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Action Aborted! No order was placed!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Item out of stock!");
        }
    }

    //MODIFIES: this
    //EFFECTS: orders the given item if user approves
    public void returnItem(Item item) {
        float price = item.getPrice();
        float priceAfterDiscount = price - (price * item.getDiscount()) / 100;
        String message = "Are you sure you want to return " + item.getName() + "?";
        int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
        if (response == JOptionPane.YES_OPTION) {
            database.getCurrentUser().returnItem(item);
            String refundMsg1 = "Item returned successfully!\nYour refund of CAD$" + priceAfterDiscount;
            String refundMsg2 = refundMsg1 + " will be initiated shortly";
            JOptionPane.showMessageDialog(null, refundMsg2);
            setInStockToTrueInAllProducts(item);
            database.saveEverything();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Action Aborted! No order was returned!");
        }

    }

    //MODIFIES: this
    //EFFECTS: sets item.inStock to true if found in database.allProducts
    private void setInStockToTrueInAllProducts(Item item) {
        for (Item product : database.getAllProducts().getAllProducts()) {
            if (product.getId() == item.getId()) {
                product.setInStock(true);
            }
        }
    }

    //EFFECTS: adds a button which can delete item from Collection
    public void initialiseDeleteItemButton() {
        deleteButton = new JButton("Delete item");
        setupButton(deleteButton);
        deleteButton.addActionListener(e -> {
            String message = "Are you sure you want to delete this item? This action can't be undone";
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                database.getAllProducts().removeItem(item.getId());
                JOptionPane.showMessageDialog(null, "Item removed successfully and changes saved!");
                database.saveEverything();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Action aborted! Nothing was removed.");
            }

        });
        add(deleteButton);
    }

    //EFFECTS: formats the given button according to the app theme
    public void setupButton(JButton button) {
        button.setBorder(border);
        button.setPreferredSize(new Dimension(150, 30));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 12));
    }
}
