package ui.screens.big;

import database.Database;
import model.User;

public class ScreenForUser extends ScreenTemplate {
    public ScreenForUser(String title, Database database) {
        super(title, database);
        displayOptionsInMenuPanel(database.getUserOptions());
        //user.showUser();
    }
}
