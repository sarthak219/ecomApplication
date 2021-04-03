package ui.screens;

import ui.Database;
import ui.tabs.LoginScreenTab;
import ui.tabs.WelcomeScreenTab;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents the main window of the application
 */
public class SmallAppWindow extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    protected Border border;
    protected JTabbedPane tabbedPane;
    protected Database database;
    protected JLabel background;

    public SmallAppWindow(Database database) {
        this.database = database;
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        ImageIcon icon = new ImageIcon("./data/images/background.jpg");
        Image img = icon.getImage();
        Image tempImage = img.getScaledInstance(7 * WIDTH / 4, HEIGHT, Image.SCALE_SMOOTH);
        icon = new ImageIcon(tempImage);
        background = new JLabel("", icon, JLabel.CENTER);
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);
        initialiseTabbedPane();
        validate();
        repaint();
        setVisible(true);
    }

    //EFFECTS: initializes the main window of the application
    public void initialiseGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void initialiseTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, -30, WIDTH, HEIGHT);
        tabbedPane.setBackground(Color.white);
        tabbedPane.setForeground(Color.BLACK);
        addElementsToTabbedPane();
        background.add(tabbedPane);
    }

    //EFFECTS: adds tabs to tabbedPane
    public void addElementsToTabbedPane() {
        tabbedPane.add("WelcomeScreen", new WelcomeScreenTab(this, "Welcome!", new Dimension(WIDTH, HEIGHT), database));
        tabbedPane.add("AdminLogin", new LoginScreenTab(this, "Admin Login", new Dimension(WIDTH, HEIGHT), database));
        tabbedPane.add("UserLogin", new LoginScreenTab(this, "User Login", new Dimension(WIDTH, HEIGHT), database));
    }


    //EFFECTS: returns tabbedPane of this UI
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
