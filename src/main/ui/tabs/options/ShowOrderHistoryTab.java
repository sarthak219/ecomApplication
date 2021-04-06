package ui.tabs.options;

import ui.Database;
import model.Item;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

/**
 * represents an OptionTab to display User's Order History
 */

public class ShowOrderHistoryTab extends OptionTab {

    public ShowOrderHistoryTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayOrderHistory(database, "");
    }

    //EFFECTS: adds the cards with details of products in Order History on the current tab
    public void displayOrderHistory(Database database, String searchString) {
        for (Item item : database.getCurrentUser().getOrderHistory()) {
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
        displayOrderHistory(database, searchString);
        validate();
        repaint();
    }
}
