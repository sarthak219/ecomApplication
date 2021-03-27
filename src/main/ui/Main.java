package ui;

import database.Database;
import ui.screens.big.ScreenForUser;
import ui.screens.small.SmallScreen;
import ui.screens.small.WelcomeScreen;

public class Main extends MyApp {
    public static void main(String[] args) {
        new SmallAppWindow(new Database());
    }
}
