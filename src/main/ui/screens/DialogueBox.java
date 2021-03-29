package ui.screens;

import database.Database;
import model.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents a dialogue box asking user to either add/remove given item to card,
 * add/remove item to wishlist, buy an item, return an item
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
        } else {
            initialiseDeleteButton();
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

    //MODIFIES: database
    //EFFECTS: removes the item with the given id from wishlist
    private void removeFromWishlistWithId(int id) {
        for (Item item : database.getCurrentUser().getWishlist()) {
            if (item.getId() == id) {
                database.getCurrentUser().removeItemsFromWishlist(item);
                return;
            }
        }
    }

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

    //MODIFIES: database
    //EFFECTS: removes the item with the given id from cart
    private void removeFromCartWithId(int id) {
        for (Item item : database.getCurrentUser().getCart()) {
            if (item.getId() == id) {
                database.getCurrentUser().removeItemsFromCart(item);
                return;
            }
        }
    }

    public void initialiseOrderOrReturnButton() {
        if (database.getCurrentUser().orderHistoryContainsItemWithId(item.getId()) && !item.getInStock()) {
            orderOrReturnButton = new JButton("Return Item");
        } else {
            orderOrReturnButton = new JButton("Buy Now");
        }
        setupButton(orderOrReturnButton);
        add(orderOrReturnButton);
    }

    public void initialiseDeleteButton() {
        deleteButton = new JButton("Delete item");
        setupButton(deleteButton);
        add(deleteButton);
    }

    //EFFECTS: formats the given button accridng to theme
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
