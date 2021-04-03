package ui.tabs.options;

import model.Item;
import ui.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

/**
 * represents an OptionTab to display User's Cart
 */
public class ShowCartTab extends OptionTab {
    protected ProductCard productCard;

    public ShowCartTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayCart(database, "");
    }

    //EFFECTS: adds the cards with details of products in cart on the current tab
    public void displayCart(Database database, String searchString) {
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
        displayCart(database, searchString);
        revalidate();
        repaint();
    }
}
