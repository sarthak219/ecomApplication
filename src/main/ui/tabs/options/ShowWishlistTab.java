package ui.tabs.options;

import database.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

/**
 * represents an OptionTab to display User's Wishlist
 */
public class ShowWishlistTab extends OptionTab {
    protected ProductCard productCard;

    public ShowWishlistTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayWishlist(database);
    }

    //EFFECTS: adds the cards with details of products in wishlist on the current tab
    public void displayWishlist(Database database) {
        for (int i = 0; i < database.getCurrentUser().getWishlist().size(); ++i) {
            productCard = new ProductCard(dimension, database.getCurrentUser().getWishlist().get(i), database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    @Override
    public void update() {
        removeAll();
        addTitle(title);
        displayWishlist(database);
        validate();
        repaint();
    }
}
