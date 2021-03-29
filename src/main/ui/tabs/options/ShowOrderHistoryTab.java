package ui.tabs.options;

import database.Database;
import model.Item;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowOrderHistoryTab extends OptionTab {
    protected ProductCard productCard;

    public ShowOrderHistoryTab(Dimension dimension, Database database) {
        super(dimension, database);
        displayOrderHistory(database);
    }

    public void displayOrderHistory(Database database) {
        for (int i = 0; i < database.getCurrentUser().getOrderHistory().size(); ++i) {
            Item product = database.getAllProducts().getAllProducts().get(i);
            productCard = new ProductCard(dimension, product, database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void updatePanel() {
        removeAll();
        displayOrderHistory(database);
        validate();
        repaint();
    }
}
