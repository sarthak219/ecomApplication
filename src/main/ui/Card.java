package ui;

import ui.screens.big.BigScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents an abstract card which displays Items or users
 */
public abstract class Card extends JPanel {
    public static final float SCALE = (float) (0.6);
    public static final int WIDTH = (int) (BigScreen.WORKSPACE_PANEL_WIDTH * SCALE);
    public static final int HEIGHT = (int) (BigScreen.WORKSPACE_PANEL_HEIGHT * BigScreen.SCALE / 3);
    protected Border border;
    protected Dimension dimension;

    //EFFECTS: Constructs a card
    public Card(Dimension dimension) {
        this.dimension = new Dimension(3 * dimension.width / 4, dimension.height / 5);
        initialiseCard();
        setVisible(true);
    }

    private void initialiseCard() {
        setBackground(new Color(33, 33, 33));
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        border = BorderFactory.createLineBorder(Color.BLACK);
        setLayout(new GridLayout(3, 6));
        setBorder(border);
    }
}
