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
    protected ProductCard productCard;

    public ShowOrderHistoryTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayOrderHistory(database);
    }

    //EFFECTS: adds the cards with details of products in Order History on the current tab
    public void displayOrderHistory(Database database) {
        for (int i = 0; i < database.getCurrentUser().getOrderHistory().size(); ++i) {
            Item product = database.getAllProducts().getAllProducts().get(i);
            productCard = new ProductCard(dimension, product, database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    @Override
    public void update() {
        removeAll();
        addTitle(title);
        displayOrderHistory(database);
        validate();
        repaint();
    }
}
