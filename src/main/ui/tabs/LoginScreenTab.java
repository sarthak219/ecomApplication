package ui.tabs;

import database.Database;
import model.User;
import ui.screens.BigAppWindow;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import java.awt.*;

/**
 * represents the login screen tab
 */
public class LoginScreenTab extends SmallTab {
    protected JTextField username;
    protected JPasswordField passwordField;
    protected JLabel status;
    protected JButton login;
    protected JButton back;

    public LoginScreenTab(SmallAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension);
        this.database = database;
        initialisePanel(title);
        getUsernameSetup();
        setupStatus();
        getPasswordSetup();
        loginButtonSetup();
        backButtonSetup();

        login.addActionListener(e -> {
            if (title.equals("Admin Login")) {
                adminLogin(database);
            } else {
                userLogin(database);
            }
        });

        back.addActionListener(e -> {
            reset();
            getController().getTabbedPane().setSelectedIndex(0);
        });
    }

    private void setupStatus() {
        status = new JLabel("");
        status.setForeground(new Color(241, 14, 14));
        status.setVisible(true);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        //status.setBounds(WIDTH / 4, marginTop + 3 * GAP_IN_BETWEEN + 3 * HEIGHT / 10, WIDTH / 2, GAP_IN_BETWEEN);
        add(status);
    }

    public void getUsernameSetup() {
        username = new JTextField("Username");
        setupTextField(username);
        add(username);
    }

    public void getPasswordSetup() {
        passwordField = new JPasswordField("Password");
        setupTextField(passwordField);
        add(passwordField);
    }

    public void loginButtonSetup() {
        login = new JButton("Login");
        setupButton(login);
        add(login);
    }

    public void backButtonSetup() {
        back = new JButton("Back");
        setupButton(back);
        add(back);
    }

    public void setupTextField(JTextField textField) {
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        textField.setBorder(border);
        textField.setBackground(new Color(255, 255, 255));
        textField.setHorizontalAlignment(JButton.CENTER);
        textField.setOpaque(true);
        textField.setFont(new Font("Helvetica", Font.PLAIN, 16));
        textField.setMaximumSize(new Dimension(dimension.width / 2, 50));
    }

    public void adminLogin(Database database) {
        String name = username.getText();
        String pass = String.valueOf(passwordField.getPassword());
        if (database.getAdmin().adminAuthentication(name, pass)) {
            getController().dispose();
            new BigAppWindow("Admin Homepage", database).getTabbedPane().setSelectedIndex(1);
        } else {
            status.setText("Incorrect username or password!");
        }
    }

    public void userLogin(Database database) {
        String name = username.getText();
        String pass = String.valueOf(passwordField.getPassword());
        if (database.getUsers().userAuthentication(name, pass)) {
            for (User user : database.getUsers().getAllUsers()) {
                if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                    database.setCurrentUser(user);
                    getController().dispose();
                    String title = database.getCurrentUser().getFirstName() + "'s Homepage";
                    new BigAppWindow(title, database).getTabbedPane().setSelectedIndex(0);
                }
            }
        } else {
            status.setText("Incorrect username or password!");
        }
    }

    public void reset() {
        username.setText("Username");
        passwordField.setText("Password");
        status.setText("");
    }
}
