package ui.tabs.options;

import database.Database;

import javax.swing.*;
import java.awt.*;

public abstract class OptionTab extends JPanel {
    public static final int GAP = 20;
    protected Dimension dimension;
    protected Database database;
    protected String title;

    public OptionTab(String title, Dimension dimension, Database database) {
        this.dimension = dimension;
        this.database = database;
        this.title = title;
        initialisePanel();
        addTitle(title);
    }

    //EFFECTS: initialises a small tab
    public void initialisePanel() {
        setSize(dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
    }

    //EFFECTS: Shows the title of the particular tab
    public void addTitle(String titleString) {
        add(Box.createRigidArea(new Dimension(0, GAP)));
        JLabel title = new JLabel(titleString);
        initialiseTitle(title);
        add(title);
    }

    public void initialiseTitle(JLabel titleLabel) {
        titleLabel.setFont(new Font("helvetica", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
    }


}
