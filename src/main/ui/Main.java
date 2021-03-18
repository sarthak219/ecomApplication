package ui;

import database.Database;
import ui.screens.big.ScreenForUser;
import ui.screens.small.WelcomeScreen;

public class Main extends MyApp {
    public static void main(String[] args) {
        Database database = new Database();
        //new WelcomeScreen("Welcome!", database);
        new ScreenForUser("Test Screen", database);
    }
}
