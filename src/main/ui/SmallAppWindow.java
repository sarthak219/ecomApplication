package ui;

import database.Database;
import ui.panels.WelcomeScreenTab;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SmallAppWindow extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    //    public static final int BUTTON_HEIGHT = 50;
//    public static final int GAP_IN_BETWEEN = HEIGHT / 20;
//    public static final int TITLE_HEIGHT = HEIGHT / 10;
//    protected int marginTop = 30;89
    protected Border border;
    protected JTabbedPane tabbedPane;
    protected Database database;

    public SmallAppWindow(Database database) {
        this.database = database;
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseTabbedPane();
        //setupTitle(title);
        setVisible(true);
    }

    public void initialiseGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(true);
    }

    public void initialiseTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, 0, WIDTH, HEIGHT); //TODO:set y to -30
        tabbedPane.setBackground(Color.white);
        tabbedPane.setForeground(Color.BLACK);
        addElementsToTabbedPane();
        add(tabbedPane);
    }

    public void addElementsToTabbedPane() {
        tabbedPane.add("WelcomeScreen1", new WelcomeScreenTab(this, "Welcome!", new Dimension(WIDTH, HEIGHT)));
        tabbedPane.add("WelcomeScreen2", new WelcomeScreenTab(this, "Screen 2", new Dimension(WIDTH, HEIGHT)));
        tabbedPane.add("WelcomeScreen3", new WelcomeScreenTab(this, "Screen 3", new Dimension(WIDTH, HEIGHT)));
    }

//    public void setupTitle(String title) {
//        JLabel pageHeading = new JLabel(title);
//        pageHeading.setBounds(0, GAP_IN_BETWEEN + 30, WIDTH, TITLE_HEIGHT);
//        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
//        pageHeading.setForeground(new Color(226, 226, 226));
//        pageHeading.setHorizontalAlignment(JLabel.CENTER);
//        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
//        add(pageHeading);
//    }

    public void setupButton(JButton button) {
        button.setBorder(border);
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }


    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
