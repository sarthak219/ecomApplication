package ui;

import ui.screens.big.BigScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Card extends JPanel {
    public static final float SCALE = (float) (0.6);
    public static final int WIDTH = (int) (BigScreen.WORKSPACE_PANEL_WIDTH * SCALE);
    public static final int HEIGHT = (int) (BigScreen.WORKSPACE_PANEL_HEIGHT * BigScreen.SCALE / 3);
    protected Border border;
    protected JLabel label1;

    public Card() {
        setBackground(new Color(33, 33, 33));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        border = BorderFactory.createLineBorder(Color.BLACK);
        setLayout(new GridLayout(3, 2));
        setBorder(border);
        setVisible(true);
        label1 = new JLabel("card");
        label1.setForeground(Color.WHITE);
        add(label1);
    }

    public void setLabelName(String labelName) {
        label1.setText(labelName);
    }
}
