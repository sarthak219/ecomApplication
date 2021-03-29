package ui.tabs.options;

import database.Database;
import javax.swing.*;
import java.awt.*;

public abstract class OptionTab extends JPanel {
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
