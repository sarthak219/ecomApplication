package ui;

import database.Database;

public class Main extends MyApp {
    public static void main(String[] args) {
//        new LoadingScreen("Launching App...");
        new SmallAppWindow(new Database());
//        new BigAppWindow("title", new Database());
    }
}
