package ui.panels;

import database.Database;
import ui.BigAppWindow;

import java.awt.*;

public class AdminTab extends BigTab {

    public AdminTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension);
        initialiseTitle(title);
        displayOptionsInMenuPanel(database.getAdminOptions());
    }
}
