package ui.screens.small;

import database.Database;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SmallScreen extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int BUTTON_HEIGHT = 50;
    public static final int GAP_IN_BETWEEN = HEIGHT / 20;
    public static final int TITLE_HEIGHT = HEIGHT / 10;
    protected int marginTop = 30;
    protected Border border;
    protected JPanel screen;

    public SmallScreen(String title, Database database) {
        initialiseGraphics();
        border = BorderFactory.createLineBorder(Color.BLACK);

        setupTitle(title);
    }

    public void initialiseGraphics() {
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(false);
    }

    public void initialiseScreen() {
        screen = new JPanel();
        screen.setLayout(null);
        screen.setBounds(0, 0, WIDTH, HEIGHT);
        screen.setBackground(new Color(23, 23, 23));
        add(screen);
    } //TODO: ask TA about coherency of this method

    public void setupTitle(String title) {
        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(0, GAP_IN_BETWEEN + 30, WIDTH, TITLE_HEIGHT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
        pageHeading.setForeground(new Color(226, 226, 226));
        pageHeading.setHorizontalAlignment(JLabel.CENTER);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        add(pageHeading);
    }

    public void setupButton(JButton button) {
        button.setBorder(border);
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }
}
