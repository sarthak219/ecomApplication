package ui.panels;

import ui.Card;
import ui.SmallAppWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Tab extends JPanel {
    public static final int GAP = 20;
    private SmallAppWindow controller;
    protected Border border;
    protected Dimension dimension;

    //REQUIRES: SmallAppWindow controller that holds this tab
    public Tab(SmallAppWindow controller, Dimension dimension) {
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.dimension = dimension;
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JComponent b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public SmallAppWindow getController() {
        return controller;
    }

    public void setupButton(JButton button) {
        add(Box.createRigidArea(new Dimension(Card.WIDTH, GAP)));
        button.setBorder(border);
        button.setMaximumSize(new Dimension(dimension.width / 2, 50));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }
}
