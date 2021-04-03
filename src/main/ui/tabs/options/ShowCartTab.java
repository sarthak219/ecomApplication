package ui.tabs.options;

import ui.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;

/**
 * represents an OptionTab to display User's Cart
 */
public class ShowCartTab extends OptionTab {
    protected ProductCard productCard;

    public ShowCartTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        displayCart(database);
        System.out.println(getComponentCount());
    }

    //EFFECTS: adds the cards with details of products in cart on the current tab
    public void displayCart(Database database) {
        for (int i = 0; i < database.getCurrentUser().getCart().size(); ++i) {
            productCard = new ProductCard(dimension, database.getCurrentUser().getCart().get(i), database, "user");
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(productCard);
        }
    }

    @Override
    public void update() {
        removeAll();
        addTitle(title);
        displayCart(database);
        revalidate();
        repaint();
    }
}
