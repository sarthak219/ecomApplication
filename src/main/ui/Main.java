package ui;

import database.Database;
import ui.screens.FormWindow;
import ui.screens.SmallAppWindow;

import java.text.Normalizer;

public class Main extends MyApp {
    public static void main(String[] args) {
        new SmallAppWindow(new Database());
//        new BigAppWindow("title", new Database());
//        Database database = new Database();
//        String title = database.getCurrentUser().getFirstName() + "'s Homepage";
//        new BigAppWindow(title, database).getTabbedPane().setSelectedIndex(0);

//        new DialogueBox(new Item(), database, "admin");

//        new FormWindow(new Database());
//        new BigAppWindow("hello", new Database());
    }
}
