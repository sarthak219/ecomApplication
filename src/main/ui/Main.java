package ui;

import ui.screens.SmallAppWindow;


public class Main extends MyApp {
    public static void main(String[] args) {

        //Runs the application
        new SmallAppWindow(new Database());
    }
}
