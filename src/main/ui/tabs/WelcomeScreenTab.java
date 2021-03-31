package ui.tabs;

import database.Database;
import ui.screens.FormWindow;
import ui.screens.SmallAppWindow;
//import ui.screens.big.ScreenForUser;

import javax.swing.*;
import java.awt.*;

/**
 * represents the welcome screen tab
 */
public class WelcomeScreenTab extends SmallTab {
    protected JButton adminLogin;
    protected JButton userLogin;
    protected JButton userSignup;
    protected JButton guestLogin;

    public WelcomeScreenTab(SmallAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension);
        this.database = database;
        initialisePanel(title);
        adminLoginButton();
        userLoginButton();
        userSignupButton();
        guestLoginButton();
    }

    public void adminLoginButton() {
        adminLogin = new JButton("Login as Admin");
        setupButton(adminLogin);
        adminLogin.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(1));
        add(adminLogin);
    }

    public void userLoginButton() {
        userLogin = new JButton("Login as User");
        setupButton(userLogin);
        add(userLogin);
        userLogin.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(2));
    }

    public void userSignupButton() {
        userSignup = new JButton("Create New Account");
        setupButton(userSignup);
        userSignup.addActionListener(e -> {
//            JOptionPane.showConfirmDialog(this, "Do you wish to continue?", "Yes", 0, 3)
            new FormWindow(database).getTabbedPane().setSelectedIndex(0);
        });
        add(userSignup);
    }

    public void guestLoginButton() {
        guestLogin = new JButton("Login as Guest");
        setupButton(guestLogin);
        guestLogin.addActionListener(e -> {
            //new ScreenForUser("Guest HomePage", database);
        });
        add(guestLogin);
    }
}
