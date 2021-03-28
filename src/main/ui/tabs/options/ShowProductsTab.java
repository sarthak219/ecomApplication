package ui.tabs.options;

import database.Database;
import ui.Card;
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
            productCard = new ProductCard(dimension);
            productCard.setLabelName("" + (i + 1) + " " + database.getAllProducts().getAllProducts().get(i).getName());
            add(Box.createRigidArea(new Dimension(Card.WIDTH, GAP)));
            add(productCard);
        }
    }
}
