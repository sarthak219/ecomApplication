package ui.tabs.options;

import database.Database;
import ui.Card;

import javax.swing.*;
import java.awt.*;

public class ShowProductsTab extends OptionTab {
    protected Card card;

    public ShowProductsTab(Dimension dimension, Database database) {
        super(dimension, database);
//        for (int i = 0; i < 1000; ++i) {
//            JLabel label = new JLabel("hello" + i);
//            add(label);
//        }
        displayAllProducts(database);
    }

    public void displayAllProducts(Database database) {
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            card = new Card();
            card.setLabelName("" + (i + 1) + " " + database.getAllProducts().getAllProducts().get(i).getName());
            add(Box.createRigidArea(new Dimension(Card.WIDTH, GAP)));
            add(card);
        }
    }
}
