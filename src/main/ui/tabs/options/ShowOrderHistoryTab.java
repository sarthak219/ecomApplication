package ui.tabs.options;

import database.Database;
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
            productCard = new ProductCard(dimension, database.getCurrentUser().getOrderHistory().get(i), database);
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
