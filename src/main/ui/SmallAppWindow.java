package ui;

import database.Database;
import ui.panels.LoginScreenTab;
import ui.panels.WelcomeScreenTab;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents the main window of the application
 */
public class SmallAppWindow extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    //    public static final int BUTTON_HEIGHT = 50;
//    public static final int GAP_IN_BETWEEN = HEIGHT / 20;
//    public static final int TITLE_HEIGHT = HEIGHT / 10;
//    protected int marginTop = 30;
    protected Border border;
    protected JTabbedPane tabbedPane;
    protected Database database;

    public SmallAppWindow(Database database) {
        this.database = database;
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseTabbedPane();
        setVisible(true);
    }

    //EFFECTS: initializes the main window of the application
    public void initialiseGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void initialiseTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, -30, WIDTH, HEIGHT); //TODO:set y to -30
        tabbedPane.setBackground(Color.white);
        tabbedPane.setForeground(Color.BLACK);
        addElementsToTabbedPane();
        add(tabbedPane);
    }

    public void addElementsToTabbedPane() {
        tabbedPane.add("WelcomeScreen", new WelcomeScreenTab(this, "Welcome!", new Dimension(WIDTH, HEIGHT), database));
        tabbedPane.add("AdminLogin", new LoginScreenTab(this, "Admin Login", new Dimension(WIDTH, HEIGHT), database));
        tabbedPane.add("UserLogin", new LoginScreenTab(this, "User Login", new Dimension(WIDTH, HEIGHT), database));
//        tabbedPane.add("WelcomeScreen3", new WelcomeScreenTab(this, "Screen 3", new Dimension(WIDTH, HEIGHT)));
    }


    //EFFECTS: returns tabbedPane of this UI
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
