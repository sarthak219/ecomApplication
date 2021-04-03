package ui.tabs.options;

import ui.Database;
import model.Item;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * represents an OptionTab to display all products
 */
public class ShowProductsTab extends OptionTab {
    protected ProductCard productCard;
    protected String loggedInPerson;

    public ShowProductsTab(String title, Dimension dimension, Database database, String loggedInPerson) {
        super(title, dimension, database);
        this.loggedInPerson = loggedInPerson;
        update("");
    }

    //EFFECTS: adds those cards with product details on the current tab which contain the searchString
    public void displayAllProducts(Database database, String searchString) {
        for (Item item : database.getAllProducts().getAllProducts()) {
            if (isInName(item, searchString) || isInBrand(item, searchString)) {
                productCard = new ProductCard(dimension, item, database, loggedInPerson);
                add(Box.createRigidArea(new Dimension(0, 20)));
                add(productCard);
            }
        }
    }

    @Override
    public void update(String searchString) {
        removeAll();
        addTitle(title);
        displayAllProducts(database, searchString);
        validate();
        repaint();
    }
}
