package ui.tabs.options;

import database.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

public class ShowWishlistTab extends OptionTab {
    protected ProductCard productCard;

    public ShowWishlistTab(Dimension dimension, Database database) {
        super(dimension, database);
        displayWishlist(database);
    }

    public void displayWishlist(Database database) {
        for (int i = 0; i < database.getCurrentUser().getWishlist().size(); ++i) {
            productCard = new ProductCard(dimension, database.getCurrentUser().getWishlist().get(i), database);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    public void update() {
        removeAll();
        displayWishlist(database);
        validate();
        repaint();
    }
}
