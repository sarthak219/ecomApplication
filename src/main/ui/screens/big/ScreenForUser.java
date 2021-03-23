package ui.screens.big;

import database.Database;
import ui.Card;

import javax.swing.*;
import java.awt.*;

public class ScreenForUser extends BigScreen {
    protected Card card;
    //protected JList list;
    public static final int GAP = HEIGHT / 20;

    public ScreenForUser(String title, Database database) {
        super(title, database);
        card = new Card();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        displayOptionsInMenuPanel(database.getUserOptions());
        displayAllProducts(database);
        initialiseWorkspacePanel();
        revalidate();
        repaint();
    }

    public void displayAllProducts(Database database) {
        for (int i = 0; i < database.getAllProducts().size(); ++i) {
            card = new Card();
            card.setLabelName("" + (i + 1) + " " + database.getAllProducts().getAllProducts().get(i).getName());
            workspacePanel.add(Box.createRigidArea(new Dimension(Card.WIDTH, GAP)));
            workspacePanel.add(card);
        }
    }
}
