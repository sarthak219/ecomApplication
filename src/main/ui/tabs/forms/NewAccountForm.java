package ui.tabs.forms;

import database.Database;
import model.User;
import ui.screens.Form;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents a JPanel with a form to create new user account
 */
public class NewAccountForm extends JPanel {
    public static final int GAP = 10;

    private JTextField firstName;
    private JTextField lastName;
    private JTextField username;
    private JTextField emailId;
    private JPasswordField password;
    private JPasswordField confirmPassword;
    private JTextField mobileNumber;
    private JTextField age;
    private JTextField gender;

    private Form controller;
    protected String title;
    protected Dimension dimension;
    protected Border border;
    protected Database database;

    public NewAccountForm(Form controller, Dimension dimension, Database database) {
        this.dimension = dimension;
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.controller = controller;
        this.database = database;
        initialiseGraphics();
        setupTitle("Create New Account");
        addFields();
    }

    //EFFECTS: initialises the from screen to match the template of the app
    public void initialiseGraphics() {
        setPreferredSize(this.dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
        setForeground(Color.WHITE);
    }

    //EFFECTS: adds the title to the Screen
    public void setupTitle(String title) {
        add(Box.createRigidArea(new Dimension(dimension.width, 2 * GAP)));
        JLabel pageHeading = new JLabel(title);
        pageHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 36));
        pageHeading.setForeground(new Color(226, 226, 226));
        this.add(pageHeading);
    }

    //EFFECTS: adds all form components to the panel
    private void addFields() {
        setupFirstNameField();
        setupLastNameField();
        setupEmailIdField();
        setupUserNameField();
        setupPasswordField();
        setupConfirmPasswordField();
        setupMobileNumberField();
        setupAgeField();
        setupGenderField();
        setupOkayButton();
        setupCancelButton();
    }

    //EFFECTS: add text field and label to accept first name
    public void setupFirstNameField() {
        JLabel enterName = new JLabel("Enter First Name");
        this.firstName = new JTextField();
        setupLabel(enterName);
        setupTextField(firstName);
        add(enterName);
        add(firstName);
    }

    //EFFECTS: add text field and label to accept last name
    public void setupLastNameField() {
        JLabel enterName = new JLabel("Enter Last Name");
        lastName = new JTextField();
        setupLabel(enterName);
        setupTextField(lastName);
        add(enterName);
        add(lastName);
    }

    //EFFECTS: add text field and label to accept  username
    public void setupUserNameField() {
        JLabel enterName = new JLabel("Enter  Username");
        username = new JTextField();
        setupLabel(enterName);
        setupTextField(username);
        add(enterName);
        add(username);
    }

    //EFFECTS: add text field and label to accept  password
    public void setupPasswordField() {
        JLabel enterName = new JLabel("Enter  Password");
        password = new JPasswordField();
        setupLabel(enterName);
        setupTextField(password);
        add(enterName);
        add(password);
    }

    //EFFECTS: add text field and label to accept  password
    public void setupConfirmPasswordField() {
        JLabel enterName = new JLabel("Confirm Password");
        confirmPassword = new JPasswordField();
        setupLabel(enterName);
        setupTextField(confirmPassword);
        add(enterName);
        add(confirmPassword);
    }

    //EFFECTS: add text field and label to accept  email
    public void setupEmailIdField() {
        JLabel enterName = new JLabel("Enter  Email Id");
        emailId = new JTextField();
        setupLabel(enterName);
        setupTextField(emailId);
        add(enterName);
        add(emailId);
    }

    //EFFECTS: add text field and label to accept  mobile number
    public void setupMobileNumberField() {
        JLabel enterName = new JLabel("Enter Mobile Number");
        mobileNumber = new JTextField();
        setupLabel(enterName);
        setupTextField(mobileNumber);
        add(enterName);
        add(mobileNumber);
    }

    //EFFECTS: add text field and label to accept age
    public void setupAgeField() {
        JLabel enterName = new JLabel("Enter Age");
        age = new JTextField();
        setupLabel(enterName);
        setupTextField(age);
        add(enterName);
        add(age);
    }

    //EFFECTS: add text field and label to accept gender
    public void setupGenderField() {
        JLabel enterName = new JLabel("Enter Gender");
        gender = new JTextField();
        setupLabel(enterName);
        setupTextField(gender);
        add(enterName);
        add(gender);
    }


    //EFFECTS: adds the okay Button
    private void setupOkayButton() {
        JButton button = new JButton("Create Account");
        setupButton(button);
        add(button);

        String message = "Are you sure you want to create a new user?";
        button.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                if (isUniqueAndValidUsername() && passwordsMatch()) {
                    database.getUsers().insertUser(makeNewUser());
                    database.saveEverything();
                    JOptionPane.showMessageDialog(null, "Account successfully created! Changes Saved", "Success", 1);
                    controller.dispose();
                } else {
                    if (!isUniqueAndValidUsername()) {
                        JOptionPane.showMessageDialog(null, "Invalid Username!", "Error", 0);
                    }
                    if (!passwordsMatch()) {
                        JOptionPane.showMessageDialog(null, "Passwords don't match!", "Error", 0);
                    }
                }
            }
        });
    }

    //EFFECTS: returns true if user with the entered username doesn't already exist, false otherwise
    private boolean isUniqueAndValidUsername() {
        if (username.getText().equals("") || username.getText() == null) {
            return false;
        }
        for (User user : database.getUsers().getAllUsers()) {
            if (user.getUsername().equals(username.getText())) {
                return false;
            }
        }
        return true;
    }

    //EFFECTS: return true if both password and confirmPassword match, false otherwise
    private boolean passwordsMatch() {
        return String.valueOf(password.getPassword()).equals(String.valueOf(confirmPassword.getPassword()));
    }

    //EFFECTS: adds the okay Button
    private void setupCancelButton() {
        JButton button = new JButton("Cancel");
        setupButton(button);
        add(button);

        String message = "Are you sure you want to exit? All unsaved changes will be lost.";
        button.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                controller.dispose();
            }
        });
    }

    //EFFECTS: makes new users with the values of Text fields in the GUI
    public User makeNewUser() {
        String emailId = this.emailId.getText();
        int age = Integer.parseInt(this.age.getText());
        String password = String.valueOf(this.password.getPassword());
        User user = new User(firstName.getText(), lastName.getText(), username.getText(), emailId, password, age);
        user.setMobileNumber(mobileNumber.getText());
        user.setGender(gender.getText());
        return user;
    }

    //EFFECTS: formats the given label to match the template of the app
    public void setupLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Helvetica", Font.PLAIN, 14));
    }

    //EFFECTS: formats the text field to match the template of the app
    public void setupTextField(JTextField textField) {
        add(Box.createRigidArea(new Dimension(dimension.width, GAP)));
        textField.setBorder(border);
        textField.setBackground(new Color(220, 220, 220));
        textField.setHorizontalAlignment(JButton.CENTER);
        textField.setOpaque(true);
        textField.setFont(new Font("Helvetica", Font.PLAIN, 16));
        textField.setMaximumSize(new Dimension(dimension.width / 2, 30));
    }

    //EFFECTS: formats the button to match the template of the app
    public void setupButton(JButton button) {
        button.setBorder(border);
        button.setMaximumSize(new Dimension(dimension.width / 4, 30));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 13));
        add(Box.createRigidArea(new Dimension(dimension.width, 20)));
    }

}
