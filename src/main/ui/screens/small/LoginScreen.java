//package ui.screens.small;
//
//import database.Database;
//import model.User;
////import ui.screens.big.ScreenForAdmin;
////import ui.screens.big.ScreenForUser;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class LoginScreen extends SmallScreen {
//    protected JTextField username;
//    protected JPasswordField passwordField;
//    protected JLabel status;
//    protected JButton login;
//    protected JButton back;
//
//    public LoginScreen(String title, Database database) {
//        super(title, database);
//        //marginTop += 40;
//        border = BorderFactory.createLineBorder(Color.BLACK);
//
//        getUsernameSetup();
//        getPasswordSetup();
//        loginButtonSetup();
//        backButtonSetup();
//        setupStatus();
//
//        login.addActionListener(e -> {
//            if (title.equals("Admin Login")) {
//                adminLogin(database);
//            } else {
//                userLogin(database);
//            }
//        });
//
//
//        back.addActionListener(e -> {
//            new WelcomeScreen("Welcome!", database);
//            dispose();
//        });
//
//        revalidate();
//        repaint();
//    }
//
//    private void setupStatus() {
//        status = new JLabel("");
//        status.setForeground(new Color(241, 14, 14));
//        status.setVisible(true);
//        status.setBounds(WIDTH / 4, marginTop + 3 * GAP_IN_BETWEEN + 3 * HEIGHT / 10, WIDTH / 2, GAP_IN_BETWEEN);
//        add(status);
//    }
//
//    public void getUsernameSetup() {
//        username = new JTextField("Username");
//        username.setBounds(WIDTH / 4, marginTop + 2 * GAP_IN_BETWEEN + HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
//        setupTextField(username);
//        add(username);
//    }
//
//    public void getPasswordSetup() {
//        passwordField = new JPasswordField("Password");
//      passwordField.setBounds(WIDTH / 4, marginTop + 3 * GAP_IN_BETWEEN + 2 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
//        setupTextField(passwordField);
//        add(passwordField);
//    }
//
//    public void loginButtonSetup() {
//        login = new JButton("Login");
//        login.setBounds(WIDTH / 4, marginTop + 4 * GAP_IN_BETWEEN + 3 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
//        setupButton(login);
//        add(login);
//    }
//
//    public void backButtonSetup() {
//        back = new JButton("Back");
//        back.setBounds(WIDTH / 4, marginTop + 5 * GAP_IN_BETWEEN + 4 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
//        setupButton(back);
//        add(back);
//    }
//
//    public void setupTextField(JTextField textField) {
//        textField.setBorder(border);
//        textField.setBackground(new Color(255, 255, 255));
//        textField.setHorizontalAlignment(JButton.CENTER);
//        textField.setOpaque(true);
//        textField.setFont(new Font("Helvetica", Font.PLAIN, 18));
//    }
//
//    public void adminLogin(Database database) {
//        String name = username.getText();
//        String pass = String.valueOf(passwordField.getPassword());
//        if (database.getAdmin().adminAuthentication(name, pass)) {
//            //new ScreenForAdmin("Admin Home Page", database);
//            dispose();
//        } else {
//            status.setText("Incorrect username or password!");
//        }
//
//    }
//
//    public void userLogin(Database database) {
//        String name = username.getText();
//        String pass = String.valueOf(passwordField.getPassword());
//        if (database.getUsers().userAuthentication(name, pass)) {
//            for (User user : database.getUsers().getAllUsers()) {
//                if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
//                    database.setCurrentUser(user);
//                    new ScreenForUser("Homepage", database);
//                    dispose();
//                }
//            }
//        } else {
//            status.setText("Incorrect username or password!");
//        }
//    }
//}
