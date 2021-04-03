package ui.tabs.options;

import model.Item;
import ui.Database;
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
        displayWishlist(database, "");
    }

    //EFFECTS: adds the cards with details of products in wishlist on the current tab
    public void displayWishlist(Database database, String searchString) {
        for (Item item : database.getCurrentUser().getCart()) {
            if (isInName(item, searchString) || isInBrand(item, searchString)) {
                productCard = new ProductCard(dimension, item, database, "user");
                add(Box.createRigidArea(new Dimension(0, 20)));
                add(productCard);
            }
        }
    }

    @Override
    public void update(String searchString) {
        removeAll();
        addTitle(title);
        displayWishlist(database, searchString);
        validate();
        repaint();
    }
}
