package ui.panels;

import database.Database;
import ui.BigAppWindow;

import java.awt.*;

public class UserTab extends BigTab {

    public UserTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension);
        initialiseTitle(title);
        displayOptionsInMenuPanel(database.getUserOptions());
    }
}
