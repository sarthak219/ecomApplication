package ui;

import model.Item;
import ui.screens.DialogueBox;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * represents a Card which displays an Item
 */
public class ProductCard extends Card {
    public static final String SPACE = "  ";
    private final Item item;

    //EFFECTS: initialises a card to display products and open a DialogueBox when clicked
    public ProductCard(Dimension dimension, Item item, Database database, String loggedInPerson) {
        super(dimension);
        this.item = item;
        setupLabels();

        this.addActionListener(e -> new DialogueBox(item, database, loggedInPerson));
    }

    @Override
    //EFFECTS: sets up different labels, each with a particular field of the given Item
    public void setupLabels() {
        setupBrand();
        setupName();
        setupDescription();
        setupPrice();
        setupDiscount();
        setupCategory();
        setupSize();
        setupColour();
        setupInStock();
    }

    // EFFECTS: adds the name JLabel to this card
    public void setupName() {
        JLabel name = new JLabel(SPACE + item.getName());
        setupLabel(name);
        add(name);
    }

    // EFFECTS: adds the brand JLabel to this card
    public void setupBrand() {
        JLabel brand = new JLabel(SPACE + item.getBrand().toUpperCase(Locale.ROOT));
        setupLabel(brand);
        brand.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(brand);
    }

    // EFFECTS: adds the description JLabel to this card
    public void setupDescription() {
        JLabel description = new JLabel(SPACE + item.getDescription());
        setupLabel(description);
        description.setForeground(new Color(231, 231, 231));
        description.setFont(new Font("Helvetica", Font.PLAIN, 14));
        add(description);
    }

    // EFFECTS: adds the price JLabel to this card
    public void setupPrice() {
        float price = item.getPrice();
        float priceAfterDiscount = price - (price * item.getDiscount()) / 100;
        JLabel priceLabel = new JLabel(SPACE + "CAD$ " + priceAfterDiscount);
        setupLabel(priceLabel);
        add(priceLabel);
    }

    // EFFECTS: adds the discount JLabel to this card
    public void setupDiscount() {
        JLabel discount = new JLabel(SPACE + "Flat " + item.getDiscount() + "% off");
        setupLabel(discount);
        add(discount);
    }

    // EFFECTS: adds the category JLabel to this card
    public void setupCategory() {
        JLabel category = new JLabel("(For " + item.getCategory() + ")");
        setupLabel(category);
        add(category);
    }

    // EFFECTS: adds the size JLabel to this card
    public void setupSize() {
        JLabel size = new JLabel(SPACE + "Size: " + item.getSize().toUpperCase(Locale.ROOT));
        setupLabel(size);
        add(size);
    }

    // EFFECTS: adds the colour JLabel to this card
    public void setupColour() {
        JLabel colour = new JLabel(SPACE + item.getColour().toUpperCase(Locale.ROOT));
        setupLabel(colour);
        add(colour);
    }

    // EFFECTS: adds the colour JLabel to this card
    public void setupInStock() {
        JLabel inStock = new JLabel();
        setupLabel(inStock);
        if (item.getInStock()) {
            inStock.setText(SPACE + "In stock");
            inStock.setForeground(new Color(70, 255, 0));
        } else {
            inStock.setText(SPACE + "Currently out of stock");
            inStock.setForeground(new Color(241, 14, 14));
        }
        add(inStock);
    }

    //EFFECTS: formats the JLabel according to Card theme
    public void setupLabel(JLabel label) {
        label.setForeground(new Color(231, 231, 231));
        label.setFont(new Font("Helvetica", Font.PLAIN, 16));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
