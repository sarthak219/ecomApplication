package ui.screens.big;

import database.Database;

public class ScreenForAdmin extends BigScreen {
    public ScreenForAdmin(String title, Database database) {
        super(title, database);
        displayOptionsInMenuPanel(database.getAdminOptions());

    }


}
