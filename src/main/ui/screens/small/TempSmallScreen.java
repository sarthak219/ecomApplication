package ui.screens.small;

import javax.swing.*;
import java.awt.*;

public class TempSmallScreen extends JPanel {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int BUTTON_HEIGHT = 50;
    public static final int GAP_IN_BETWEEN = HEIGHT / 20;
    public static final int TITLE_HEIGHT = HEIGHT / 10;

    public TempSmallScreen(String title) {
        initialiseGraphics();
        //border = BorderFactory.createLineBorder(Color.BLACK);
        setupTitle(title);
    }

    public void initialiseGraphics() {
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setBackground(new Color(161, 10, 10));
    }

    public void setupTitle(String title) {
        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(0, GAP_IN_BETWEEN + 30, WIDTH, TITLE_HEIGHT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
        pageHeading.setForeground(new Color(226, 226, 226));
        pageHeading.setHorizontalAlignment(JLabel.CENTER);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        add(pageHeading);
    }
}
