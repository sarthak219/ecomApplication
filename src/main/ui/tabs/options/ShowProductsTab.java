package ui.tabs.options;

import database.Database;
import model.Item;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowProductsTab extends OptionTab {
    protected ProductCard productCard;
    protected String loggedInPerson;

    public ShowProductsTab(Dimension dimension, Database database, String loggedInPerson) {
        super(dimension, database);
        this.loggedInPerson = loggedInPerson;
        displayAllProducts(database);
    }

    public void displayAllProducts(Database database) {
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            Item product = database.getAllProducts().getAllProducts().get(i);
            productCard = new ProductCard(dimension, product, database, loggedInPerson);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void updatePanel() {
        removeAll();
        displayAllProducts(database);
        validate();
        repaint();
    }
}
