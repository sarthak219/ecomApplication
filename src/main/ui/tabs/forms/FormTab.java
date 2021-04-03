package ui.tabs.forms;

import ui.Database;
import ui.screens.FormWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class FormTab extends JPanel {
    public static final int GAP = 10;

    protected FormWindow controller;
    protected Dimension dimension;
    protected Border border;
    protected Database database;

    public FormTab(FormWindow controller, Dimension dimension, Database database) {
        this.dimension = dimension;
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.controller = controller;
        this.database = database;
        initialiseGraphics();
    }

    //EFFECTS: initialises the from screen to match the template of the app
    public void initialiseGraphics() {
        setPreferredSize(this.dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
        setForeground(Color.WHITE);
    }

    //EFFECTS: Adds all the fields to the form
    public abstract void addFields();

    //EFFECTS: adds the title to the Screen
    public void setupTitle(String title) {
        add(Box.createRigidArea(new Dimension(dimension.width, 2 * GAP)));
        JLabel pageHeading = new JLabel(title);
        pageHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 36));
        pageHeading.setForeground(new Color(226, 226, 226));
        this.add(pageHeading);
    }

    //EFFECTS: formats the given label to match the template of the app
    public void setupLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Helvetica", Font.PLAIN, 14));
    }

    //EFFECTS: formats the text field to match the template of the app
    public void setupTextField(JTextField textField) {
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        textField.setBorder(border);
        textField.setBackground(new Color(220, 220, 220));
        textField.setHorizontalAlignment(JButton.CENTER);
        textField.setOpaque(true);
        textField.setFont(new Font("Helvetica", Font.PLAIN, 16));
        textField.setMaximumSize(new Dimension(dimension.width / 2, 30));
    }

    //EFFECTS: formats the button to match the template of the app
    public void setupButton(JButton button) {
        button.setBorder(border);
        button.setMaximumSize(new Dimension(dimension.width / 4, 30));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 13));
        add(Box.createRigidArea(new Dimension(dimension.width, 20)));
    }
}
