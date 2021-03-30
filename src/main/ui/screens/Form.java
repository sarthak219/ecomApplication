package ui.screens;

import database.Database;
import ui.tabs.forms.NewAccountForm;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents a JFrame to display forms
 */
public class Form extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 700;
    protected Border border;
    protected JTabbedPane tabbedPane;
    protected Database database;

    public Form(Database database) {
        this.database = database;
        initializeGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseTabbedPane();

        setVisible(true);
    }

    //EFFECTS: initializes the form window
    public void initializeGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // EFFECTS: initializes the tabbedPane to match the template of the app and adds it to the controller
    public void initialiseTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, -30, WIDTH, HEIGHT);
        tabbedPane.setBackground(Color.white);
        tabbedPane.setForeground(Color.BLACK);
        addElementsToTabbedPane();
        add(tabbedPane);
    }

    //EFFECTS: adds tabs to tabbedPane
    public void addElementsToTabbedPane() {
        tabbedPane.add("New Account", new NewAccountForm(this, new Dimension(WIDTH, HEIGHT), database));
    }
}
