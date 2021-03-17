package ui;

import database.Database;
import ui.screens.big.ScreenForUser;
import ui.screens.small.WelcomeScreen;

public class Main extends MyApp {
    public static void main(String[] args) {
        Database database = new Database();

//        String[] options = {"Back",
//                "Show Products", "Search Products", "View Wishlist",
//                "View Cart", "View Order History", "Log Out"};
//        new ScreenTemplate("Home", options);
       // new ScreenForUser("Home Screen", options, myApp.users.getAllUsers().get(0));

        new WelcomeScreen("Welcome!", database);
//        new LoginScreen("Login Screen");

    }
}
