package ui.tabs;

import database.Database;
import ui.screens.BigAppWindow;

import java.awt.*;

public class AdminTab extends BigTab {

    public AdminTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension, database);
        initialiseTitle(title);
        displayOptionsInMenuPanel(database.getAdminOptions());
    }
}
