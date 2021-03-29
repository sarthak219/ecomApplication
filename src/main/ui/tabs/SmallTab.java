package ui.tabs;

import database.Database;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


/**
 * represents an abstract tab for a SmallAppWindow
 */
public abstract class SmallTab extends JPanel {
    public static final int GAP = 20;
    private SmallAppWindow controller;
    protected Border border;
    protected Dimension dimension;
    protected Database database;

    //REQUIRES: SmallAppWindow controller that holds this tab
    public SmallTab(SmallAppWindow controller, Dimension dimension) {
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.dimension = dimension;
        this.controller = controller;

    }

    //EFFECTS: initialises a small tab
    public void initialisePanel(String title) {
        setSize(dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
        setupTitle(title);
        setOpaque(false);
    }

    //EFFECTS: adds the title to the Screen
    public void setupTitle(String title) {
        add(Box.createRigidArea(new Dimension(dimension.width, 3 * GAP)));
        JLabel pageHeading = new JLabel(title);
        pageHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
//        pageHeading.setForeground(new Color(226, 226, 226));
        pageHeading.setForeground(Color.WHITE);
        this.add(pageHeading);
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public SmallAppWindow getController() {
        return controller;
    }


    //EFFECTS: formats the button to match the template of the app
    public void setupButton(JButton button) {
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        button.setBorder(border);
        button.setMaximumSize(new Dimension(dimension.width / 2, 50));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 16));
    }
}
