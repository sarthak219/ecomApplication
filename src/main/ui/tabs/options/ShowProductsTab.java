package ui.tabs.options;

import database.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowProductsTab extends OptionTab {
    protected ProductCard productCard;

    public ShowProductsTab(Dimension dimension, Database database) {
        super(dimension, database);
        displayAllProducts(database);
    }

    public void displayAllProducts(Database database) {
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            productCard = new ProductCard(dimension, database.getAllProducts().getAllProducts().get(i), database);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }
}
