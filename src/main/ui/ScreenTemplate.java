package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ScreenTemplate extends JFrame {
    public static final float SCALE = (float) 0.8;
    public static final int WIDTH = (int) (1440 * SCALE);
    public static final int HEIGHT = (int) (900 * SCALE);
    public static final int PANEL_WIDTH = WIDTH / 5;
    protected JPanel menuPanel;
    protected JPanel titlePanel;
    protected Border border;

    public ScreenTemplate(String title, String[] labels) {
        initialiseGraphics();
        int margin = HEIGHT / 10;
        menuPanel = new JPanel();
        titlePanel = new JPanel();
        border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(PANEL_WIDTH + 30, 0, WIDTH, HEIGHT / 10);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
        pageHeading.setHorizontalAlignment(JLabel.LEFT);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        titlePanel.add(pageHeading);

        menuPanel.setBackground(new Color(40, 40, 40));
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, margin, PANEL_WIDTH, HEIGHT - margin);
        menuPanel.setVisible(true);
        add(menuPanel);

        titlePanel.setBackground(new Color(76, 76, 76));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, WIDTH, HEIGHT / 10);
        titlePanel.setVisible(true);
        add(titlePanel);

        displayOptionsInMenuPanel(labels);
    }

    public void initialiseGraphics() {
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(false);
    }

    public void displayOptionsInMenuPanel(String[] labels) {
        for (int i = 0; i < labels.length; ++i) {
            JLabel label = new JLabel(labels[i]);
            label.setBorder(border);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBounds(-1, 50 * i - i, PANEL_WIDTH + 2, 50);
            label.setForeground(Color.WHITE);
            menuPanel.add(label);
        }
    }
}
