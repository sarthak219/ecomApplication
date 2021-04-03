package ui.tabs.forms;

import ui.Database;
import model.Item;
import ui.screens.FormWindow;

import javax.swing.*;
import java.awt.*;

/**
 * represents a JPanel with a form to create new user account
 */
public class NewProductFormTab extends FormTab {
    private JTextField id;
    private JTextField name;
    private JTextField brand;
    private JTextField description;
    private JTextField price;
    private ButtonGroup category;
    private ButtonGroup size;
    private JTextField colour;
    private JTextField discount;
    private JCheckBox inStock;

    private final JRadioButton maleBtn = new JRadioButton("Men");
    private final JRadioButton femaleBtn = new JRadioButton("Women");
    private final JRadioButton kidsBtn = new JRadioButton("Kids");

    private final JRadioButton xsBtn = new JRadioButton("XS");
    private final JRadioButton smallBtn = new JRadioButton("S");
    private final JRadioButton medBtn = new JRadioButton("M");
    private final JRadioButton largeBtn = new JRadioButton("L");
    private final JRadioButton xlBtn = new JRadioButton("XL");
    private final JRadioButton xxlBtn = new JRadioButton("XXL");


    public NewProductFormTab(FormWindow controller, Dimension dimension, Database database) {
        super(controller, dimension, database);
        setupTitle("Add New Product");
        addFields();
    }


    //EFFECTS: adds all form components to the panel
    public void addFields() {
        setupProductIdField();
        setupNameField();
        setupBrandField();
        setupDescriptionField();
        setupPriceField();
        setupColourField();
        setupGenderField();
        setupCategoryField();
        setupSizeField();
        setupInStock();
        setupOkayButton();
        setupCancelButton();
    }

    public void setupInStock() {
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        JLabel enterStockStatus = new JLabel("Item in stock?: ");
        setupLabel(enterStockStatus);
        inStock = new JCheckBox();
        JPanel categoryPanel = new JPanel();
        categoryPanel.add(enterStockStatus);
        categoryPanel.add(inStock);
        categoryPanel.setForeground(Color.WHITE);
        categoryPanel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        categoryPanel.setOpaque(false);
        categoryPanel.setMaximumSize(new Dimension(dimension.width, 30));
        add(categoryPanel);

    }

    //EFFECTS: add text field and label to accept product id
    public void setupProductIdField() {
        JLabel enterId = new JLabel("Enter product ID");
        this.id = new JTextField();
        setupLabel(enterId);
        setupTextField(id);
        add(enterId);
        add(id);
    }

    //EFFECTS: add text field and label to accept product name
    public void setupNameField() {
        JLabel enterName = new JLabel("Enter Product Name");
        name = new JTextField();
        setupLabel(enterName);
        setupTextField(name);
        add(enterName);
        add(name);
    }

    //EFFECTS: add text field and label to accept brand
    public void setupBrandField() {
        JLabel enterBrand = new JLabel("Enter Brand of the Product");
        brand = new JTextField();
        setupLabel(enterBrand);
        setupTextField(brand);
        add(enterBrand);
        add(brand);
    }

    //EFFECTS: add text field and label to accept description
    public void setupDescriptionField() {
        JLabel enterDescription = new JLabel("Enter Product Description");
        description = new JTextField();
        setupLabel(enterDescription);
        setupTextField(description);
        add(enterDescription);
        add(description);
    }

    //EFFECTS: add text field and label to accept price
    public void setupPriceField() {
        JLabel enterPrice = new JLabel("Enter Price (in CAD$)");
        price = new JTextField();
        setupLabel(enterPrice);
        setupTextField(price);
        add(enterPrice);
        add(price);
    }

    //EFFECTS: adds radio buttons to accept category of the product
    public void setupCategoryField() {
        JLabel enterCategory = new JLabel("Choose Category");
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        setupLabel(enterCategory);
        add(enterCategory);
        addCategoryRadioButtons();
    }

    //EFFECTS: adds 3 radio buttons with names men, women or kids
    public void addCategoryRadioButtons() {
        category = new ButtonGroup();
        category.add(maleBtn);
        category.add(femaleBtn);
        category.add(kidsBtn);
        maleBtn.setForeground(Color.WHITE);
        femaleBtn.setForeground(Color.WHITE);
        kidsBtn.setForeground(Color.WHITE);
        JPanel categoryPanel = new JPanel();
        categoryPanel.add(maleBtn);
        categoryPanel.add(femaleBtn);
        categoryPanel.add(kidsBtn);
        categoryPanel.setForeground(Color.WHITE);
        categoryPanel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        categoryPanel.setOpaque(false);
        categoryPanel.setMaximumSize(new Dimension(dimension.width, 30));
        add(categoryPanel);
    }

    //EFFECTS: add text field and label to accept  mobile number
    public void setupSizeField() {
        JLabel enterCategory = new JLabel("Select Size");
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        setupLabel(enterCategory);
        add(enterCategory);
        addSizeRadioButtons();
    }

    //EFFECTS: adds 5 radio buttons with names men, women or kids
    public void addSizeRadioButtons() {
        size = new ButtonGroup();
        size.add(xsBtn);
        size.add(smallBtn);
        size.add(medBtn);
        size.add(largeBtn);
        size.add(xlBtn);
        size.add(xxlBtn);
        xsBtn.setForeground(Color.WHITE);
        smallBtn.setForeground(Color.WHITE);
        medBtn.setForeground(Color.WHITE);
        largeBtn.setForeground(Color.WHITE);
        xlBtn.setForeground(Color.WHITE);
        xxlBtn.setForeground(Color.WHITE);
        JPanel sizePanel = new JPanel();
        sizePanel.add(xsBtn);
        sizePanel.add(smallBtn);
        sizePanel.add(medBtn);
        sizePanel.add(largeBtn);
        sizePanel.add(xlBtn);
        sizePanel.add(xxlBtn);
        addRadioButtonsToJPanel(sizePanel);
    }

    private void addRadioButtonsToJPanel(JPanel sizePanel) {
        sizePanel.setForeground(Color.WHITE);
        sizePanel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        sizePanel.setOpaque(false);
        sizePanel.setMaximumSize(new Dimension(dimension.width, 30));
        add(sizePanel);
    }


    //EFFECTS: add text field and label to accept age
    public void setupColourField() {
        JLabel enterColour = new JLabel("Enter Colour");
        colour = new JTextField();
        setupLabel(enterColour);
        setupTextField(colour);
        add(enterColour);
        add(colour);
    }

    //EFFECTS: add text field and label to accept gender
    public void setupGenderField() {
        JLabel enterDiscount = new JLabel("Enter Discount (%)");
        discount = new JTextField();
        setupLabel(enterDiscount);
        setupTextField(discount);
        add(enterDiscount);
        add(discount);
    }


    //MODIFIES: this.database
    //EFFECTS: adds the okay Button and implements its actions
    private void setupOkayButton() {
        JButton button = new JButton("Add Product");
        setupButton(button);
        add(button);

        String message = "Are you sure you want to add a new product?";
        button.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                if (isUniqueId()) {
                    database.getAllProducts().insertItem(makeNewProduct());
                    database.saveEverything();
                    JOptionPane.showMessageDialog(null, "Product successfully added! Changes Saved", "Success", 1);
                    controller.dispose();
                } else {
                    if (id.getText().equals("") || id.getText() == null) {
                        JOptionPane.showMessageDialog(null, "Invalid Product ID", "Error", 0);
                    } else if (!isUniqueId()) {
                        JOptionPane.showMessageDialog(null, " Product with this ID already exists", "Error", 0);
                    }

                }
            }
        });
    }

    //EFFECTS: returns true if user with the entered username doesn't already exist, false otherwise
    private boolean isUniqueId() {
        if (id.getText().equals("") || id.getText() == null) {
            return false;
        }

        for (Item item : database.getAllProducts().getAllProducts()) {
            if (item.getId() == Integer.parseInt(id.getText())) {
                return false;
            }
        }
        return true;
    }

    //EFFECTS: adds the okay Button
    private void setupCancelButton() {
        JButton button = new JButton("Cancel");
        setupButton(button);
        add(button);

        String message = "Are you sure you want to exit? All unsaved changes will be lost.";
        button.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                controller.dispose();
            }
        });
    }


    //EFFECTS: makes new Item with the values of Text fields in the GUI
    public Item makeNewProduct() {
        String category = getSelectedCategory();
        String size = getSelectedSize();
        int id = Integer.parseInt(this.id.getText());
        float price = Float.parseFloat(this.price.getText());
        String description = this.description.getText();
        Item item = new Item(id, name.getText(), brand.getText(), description, price, category, size);
        item.setColour(this.colour.getText());
        item.setDiscount(Float.parseFloat(this.discount.getText()));
        item.setInStock(this.inStock.isSelected());
        return item;
    }

    //EFFECTS: returns the text value of the button which is selected out of male, female or kids
    private String getSelectedCategory() {
        String category;
        if (kidsBtn.isSelected()) {
            category = kidsBtn.getText();
        } else if (femaleBtn.isSelected()) {
            category = femaleBtn.getText();
        } else {
            category = maleBtn.getText();
        }
        return category;
    }

    //EFFECTS: returns the text value of the button which is selected out of XS, S, M, L, XL, XXL
    private String getSelectedSize() {
        String size;
        if (xsBtn.isSelected()) {
            size = xsBtn.getText();
        } else if (smallBtn.isSelected()) {
            size = smallBtn.getText();
        } else if (largeBtn.isSelected()) {
            size = largeBtn.getText();
        } else if (xlBtn.isSelected()) {
            size = xlBtn.getText();
        } else if (xxlBtn.isSelected()) {
            size = xxlBtn.getText();
        } else {
            size = medBtn.getText();
        }
        return size;
    }
}
