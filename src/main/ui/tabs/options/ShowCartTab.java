package ui.tabs.options;

import database.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowCartTab extends OptionTab {
    protected ProductCard productCard;

    public ShowCartTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayCart(database);
    }

    public void displayCart(Database database) {
        for (int i = 0; i < database.getCurrentUser().getCart().size(); ++i) {
            productCard = new ProductCard(dimension, database.getCurrentUser().getCart().get(i), database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void updatePanel() {
        removeAll();
        addTitle(title);
        displayCart(database);
        revalidate();
        repaint();
    }
}
