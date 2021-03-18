package ui.screens.small;

import database.Database;

import javax.swing.*;

public class WelcomeScreen extends SmallScreen {
    protected JButton adminLogin;
    protected JButton userLogin;
    protected JButton userSignup;
    protected JButton guestLogin;

    public WelcomeScreen(String title, Database database) {
        super(title, database);

        adminLoginButton();
        userLoginButton();
        userSignupButton();
        guestLoginButton();

        adminLogin.addActionListener(e -> {
            new LoginScreen("Admin Login", database);
            dispose();
        });

        userLogin.addActionListener(e -> {
            new LoginScreen("User Login", database);
            dispose();
        });

        userSignup.addActionListener(e -> {
            JOptionPane.showConfirmDialog(this, "Do you wish to continue?", "Yes", 0, 3);
        });

        add(adminLogin);
        add(userLogin);
        add(userSignup);
        add(guestLogin);

        revalidate();
        repaint();
    }

    public void adminLoginButton() {
        adminLogin = new JButton("Login as Admin");
        adminLogin.setBounds(WIDTH / 4, marginTop + 2 * GAP_IN_BETWEEN + HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(adminLogin);
    }

    public void userLoginButton() {
        userLogin = new JButton("Login as User");
        userLogin.setBounds(WIDTH / 4, marginTop + 3 * GAP_IN_BETWEEN + 2 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(userLogin);
    }

    public void userSignupButton() {
        userSignup = new JButton("Create New Account");
        userSignup.setBounds(WIDTH / 4, marginTop + 4 * GAP_IN_BETWEEN + (3 * HEIGHT / 10), WIDTH / 2, BUTTON_HEIGHT);
        setupButton(userSignup);
    }

    public void guestLoginButton() {
        guestLogin = new JButton("Login as Guest");
        guestLogin.setBounds(WIDTH / 4, marginTop + 5 * GAP_IN_BETWEEN + 4 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(guestLogin);
    }
}
