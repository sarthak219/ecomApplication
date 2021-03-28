package ui.tabs.options;

import database.Database;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OptionTab extends JPanel {
    public static final int GAP = 20;
    //    private SmallAppWindow controller;
    protected Dimension dimension;
    protected Database database;

    public OptionTab(Dimension dimension, Database database) {
        this.dimension = dimension;
        this.database = database;
//        this.controller = controller;
        initialisePanel();
    }

    //EFFECTS: initialises a small tab
    public void initialisePanel() {
        setSize(dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
//        setBackground(Color.WHITE);
    }

}
