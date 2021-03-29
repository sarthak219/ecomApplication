package ui.tabs.options;

import database.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowCartTab extends OptionTab {
    protected ProductCard productCard;

    public ShowCartTab(Dimension dimension, Database database) {
        super(dimension, database);
        displayCart(database);
    }

    public void displayCart(Database database) {
        for (int i = 0; i < database.getCurrentUser().getCart().size(); ++i) {
            productCard = new ProductCard(dimension, database.getCurrentUser().getCart().get(i), database);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void updatePanel() {
        removeAll();
        displayCart(database);
        revalidate();
        repaint();
    }
}
