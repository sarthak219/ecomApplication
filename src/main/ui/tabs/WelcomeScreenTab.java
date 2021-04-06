package ui.tabs;

import ui.Database;
import ui.screens.FormWindow;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import java.awt.*;

/**
 * represents the welcome screen tab with buttons to login as admin, user and guest along with a button to
 * create a new User account
 */
public class WelcomeScreenTab extends SmallTab {
    protected JButton adminLogin;
    protected JButton userLogin;
    protected JButton userSignup;
    protected JButton guestLogin;

    //EFFECTS: constructs a WelcomeScreenTab
    public WelcomeScreenTab(SmallAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension);
        this.database = database;
        initialisePanel(title);
        adminLoginButton();
        userLoginButton();
        userSignupButton();
        guestLoginButton();
    }

    //EFFECTS: adds the button to go to the LoginScreenTab as admin when clicked
    public void adminLoginButton() {
        adminLogin = new JButton("Login as Admin");
        setupButton(adminLogin);
        adminLogin.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(1));
        add(adminLogin);
    }

    //EFFECTS: adds the button to go to the LoginScreenTab as user when clicked
    public void userLoginButton() {
        userLogin = new JButton("Login as User");
        setupButton(userLogin);
        add(userLogin);
        userLogin.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(2));
    }

    //EFFECTS: adds the button to go to the NewAccountFormTab when clicked
    public void userSignupButton() {
        userSignup = new JButton("Create New Account");
        setupButton(userSignup);
        userSignup.addActionListener(e -> {
            new FormWindow(database).getTabbedPane().setSelectedIndex(0);
        });
        add(userSignup);
    }

    //EFFECTS: adds the button to login as a guest when clicked
    public void guestLoginButton() {
        guestLogin = new JButton("Login as Guest");
        setupButton(guestLogin);
        guestLogin.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Feature unavailable at the moment");
        });
        add(guestLogin);
    }
}
