package ui.tabs.options;

import database.Database;
import model.Item;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowUsersTab extends OptionTab {
    protected ProductCard productCard;

    public ShowUsersTab(Dimension dimension, Database database) {
        super(dimension, database);
    }

    public void displayAllUsers(Database database) {
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            Item product = database.getAllProducts().getAllProducts().get(i);
            productCard = new ProductCard(dimension, product, database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void updatePanel() {
        removeAll();
        displayAllUsers(database);
        validate();
        repaint();
    }
}
