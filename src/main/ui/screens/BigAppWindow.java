package ui.screens;

import database.Database;
import ui.tabs.AdminTab;
import ui.tabs.UserTab;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class BigAppWindow extends JFrame {
    public static final float SCALE = (float) 0.8;
    public static final int WIDTH = (int) (1440 * SCALE);
    public static final int HEIGHT = (int) (900 * SCALE);
    protected JTabbedPane tabbedPane;
    protected JTabbedPane workspaceTabbedPane;
    protected Border border;
    protected Database database;
    protected String title;

    public BigAppWindow(String title, Database database) {
        this.database = database;
        this.title = title;
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseTabbedPane();

        setVisible(true);
    }

    public void initialiseGraphics() {
        setSize(WIDTH - 20, HEIGHT - 15);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void initialiseTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(-10, -33, WIDTH, HEIGHT); //TODO:set y to -33
        tabbedPane.setBackground(Color.white);
        tabbedPane.setForeground(Color.BLACK);
        addElementsToTabbedPane();
        tabbedPane.setOpaque(false);
        add(tabbedPane);
    }

    public void addElementsToTabbedPane() {
        tabbedPane.add("user", new UserTab(this, title, new Dimension(WIDTH, HEIGHT), database));
        tabbedPane.add("admin", new AdminTab(this, title, new Dimension(WIDTH, HEIGHT), database));
    }


    //EFFECTS: returns tabbedPane of this UI
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    //EFFECTS: returns workspaceTabbedPane of this UI
    public JTabbedPane getWorkspaceTabbedPane() {
        return workspaceTabbedPane;
    }
}
