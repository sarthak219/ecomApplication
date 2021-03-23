package ui;

import database.Database;
import ui.screens.big.ScreenForUser;
import ui.screens.small.SmallScreen;
import ui.screens.small.WelcomeScreen;

public class Main extends MyApp {
    public static void main(String[] args) {
        //new WelcomeScreen("Welcome!", new Database());
        //new ScreenForUser("Test Screen", new Database());
        new SmallScreen("12345", new Database());
    }
}
