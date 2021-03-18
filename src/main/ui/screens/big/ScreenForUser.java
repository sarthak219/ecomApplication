package ui.screens.big;

import database.Database;
import ui.Card;

import javax.swing.*;
import java.awt.*;

public class ScreenForUser extends BigScreenTemplate {
    Card card;
    public static final int GAP = HEIGHT / 20;

    public ScreenForUser(String title, Database database) {
        super(title, database);
        card = new Card();
        //card.setBounds(card.getX(), GAP, card.getWidth(), card.getHeight());
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
//        card.setLabelName("card" + 1);
//        workspacePanel.add(card);
        displayOptionsInMenuPanel(database.getUserOptions());
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            int ycoor = card.getY();
            card = new Card();
            card.setLabelName("" + (i + 1) + " " + database.getAllProducts().getAllProducts().get(i).getName());
            //card.setBounds(card.getX(), ycoor + card.getHeight() + GAP, card.getWidth(), card.getHeight());
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setAlignmentX(Component.CENTER_ALIGNMENT);
            workspacePanel.add(card);
        }
        revalidate();
        repaint();
    }
}
