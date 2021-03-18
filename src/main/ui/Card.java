package ui;

import ui.screens.big.BigScreenTemplate;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Card extends JPanel {
    public static final int WIDTH = (int) (BigScreenTemplate.WORKSPACE_PANEL_WIDTH * BigScreenTemplate.SCALE);
    public static final int HEIGHT = (int) (BigScreenTemplate.WORKSPACE_PANEL_HEIGHT * BigScreenTemplate.SCALE / 3);
    protected Border border;
    protected JLabel label1;
    protected JLabel label2;

    public Card() {
        setBackground(new Color(33, 33, 33));
        //setBounds(WIDTH / 9, 30, WIDTH, HEIGHT);
        border = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);
        setVisible(true);
        label1 = new JLabel("card");
        label1.setForeground(Color.yellow);
        add(label1);

        label2 = new JLabel("card2");
        //label2.setBounds(this.getX() + 30, this.getY(), 30, 100);
        label2.setForeground(Color.yellow);
        //add(label2);
    }

    public void setLabelName(String labelName) {
        label1.setText(labelName);
        label2.setText(labelName);
    }
}
