package ui;

//import ui.screens.big.BigScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents an abstract card which displays Items or users
 */
public class Card extends JButton {
    protected Border border;
    protected Dimension dimension;

    //EFFECTS: Constructs a card
    public Card(Dimension dimension) {
        this.dimension = new Dimension(3 * dimension.width / 4, dimension.height / 4);
        initialiseCard();
        setVisible(true);
    }

    //EFFECTS: initialises a card to match the app theme
    private void initialiseCard() {
        setBackground(new Color(33, 33, 33));
        setLayout(new GridLayout(3, 6));
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        border = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);
        setOpaque(true);
    }
}
