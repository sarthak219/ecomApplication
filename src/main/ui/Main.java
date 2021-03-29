package ui;

import database.Database;
import model.Item;
import ui.screens.BigAppWindow;
import ui.screens.DialogueBox;
import ui.screens.Form;
import ui.screens.SmallAppWindow;
import ui.tabs.UserTab;

public class Main extends MyApp {
    public static void main(String[] args) {
        new SmallAppWindow(new Database());
//        new BigAppWindow("title", new Database());
//        Database database = new Database();
//        String title = database.getCurrentUser().getFirstName() + "'s Homepage";
//        new BigAppWindow(title, database).getTabbedPane().setSelectedIndex(0);

//        new DialogueBox(new Item(), database, "admin");

//        new Form(new Database());
    }
}
