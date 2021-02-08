package ui;

import model.AllUsers;

public class Main {
    public static void main(String[] args) {
//        ProductManagement productManager = new ProductManagement();
//        productManager.addNewItems();
        AllUsers users = new AllUsers();
        MyApp app = new MyApp(users);
        app.welcomeScreen();
    }
}
