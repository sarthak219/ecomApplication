package ui.screens.big;

import database.Database;

public class ScreenForAdmin extends ScreenTemplate {
    public ScreenForAdmin(String title, Database database) {
        super(title, database);
        displayOptionsInMenuPanel(database.getAdminOptions());
    }
}
