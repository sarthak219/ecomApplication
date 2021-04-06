package ui.tabs.options;

import model.Item;
import ui.Database;
import ui.ProductCard;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public abstract class OptionTab extends JPanel implements Observer {
    public static final int GAP = 20;
    protected Dimension dimension;
    protected Database database;
    protected String title;
    protected ProductCard productCard;

    public OptionTab(String title, Dimension dimension, Database database) {
        this.dimension = dimension;
        this.database = database;
        this.title = title;
        initialisePanel();
        addTitle(title);
    }

    //EFFECTS: initialises a small tab
    public void initialisePanel() {
        setSize(dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
    }

    //EFFECTS: Shows the title of the particular tab
    public void addTitle(String titleString) {
        add(Box.createRigidArea(new Dimension(0, GAP)));
        JLabel title = new JLabel(titleString);
        initialiseTitle(title);
        add(title);
    }

    //EFFECTS: Formats the given titleLabel according to the app template
    public void initialiseTitle(JLabel titleLabel) {
        titleLabel.setFont(new Font("helvetica", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
    }

    //EFFECTS: returns true if the item's name contains the given string (ignoring case)
    //         false otherwise
    public boolean isInName(Item item, String searchString) {
        return item.getName().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT));
    }

    //EFFECTS: returns true if the item's brand contains the given string (ignoring case)
    //         false otherwise
    public boolean isInBrand(Item item, String searchString) {
        return item.getBrand().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT));
    }
}
