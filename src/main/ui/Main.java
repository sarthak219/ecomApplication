package ui;

import database.Database;
import ui.screens.BigAppWindow;
import ui.screens.SmallAppWindow;
import ui.tabs.UserTab;

public class Main extends MyApp {
    public static void main(String[] args) {
//        new LoadingScreen("Launching App...");
//        new SmallAppWindow(new Database());
//        new BigAppWindow("title", new Database());
        Database database = new Database();
        String title = database.getCurrentUser().getFirstName() + "'s Homepage";
        new BigAppWindow(title, database).getTabbedPane().setSelectedIndex(0);
    }
}
