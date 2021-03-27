package ui;

import database.Database;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class BigAppWindow extends JFrame {
    public static final float SCALE = (float) 0.8;
    public static final int WIDTH = (int) (1440 * SCALE);
    public static final int HEIGHT = (int) (900 * SCALE);
    protected JTabbedPane tabbedPane;
    protected Border border;
    protected Database database;

    public BigAppWindow(String title, Database database) {
        this.database = database;
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);
        initialiseTabbedPane();

        setVisible(true);
    }

    public void initialiseGraphics() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(false);
        setLocationRelativeTo(null);
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
        // stub
    }
}
