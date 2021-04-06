package ui;

import ui.screens.SmallAppWindow;


public class Main {
    public static void main(String[] args) {

        //runs the application
        new SmallAppWindow(new Database());
    }
}
