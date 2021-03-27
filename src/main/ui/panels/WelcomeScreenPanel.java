package ui.panels;

import database.Database;
import ui.Card;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * represents the welcome screen
 */
public class WelcomeScreenPanel extends JPanel {
    public static final int GAP = 20;
    protected Dimension dimension;
    protected JButton adminLogin;
    protected JButton userLogin;
    protected JButton userSignup;
    protected JButton guestLogin;
    protected Border border;

    public WelcomeScreenPanel(String title, Dimension dimension) {
        this.dimension = dimension;
        initialisePanel(title);
        adminLoginButton();
        userLoginButton();
        userSignupButton();
        guestLoginButton();
    }

    private void initialisePanel(String title) {
        setSize(dimension);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(23, 23, 23));
        border = BorderFactory.createLineBorder(Color.BLACK);
        setupTitle(title);
    }

    //EFFECTS: adds the title to the Welcome Screen
    public void setupTitle(String title) {
        add(Box.createRigidArea(new Dimension(Card.WIDTH, 3 * GAP)));
        JLabel pageHeading = new JLabel(title);
        pageHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
        pageHeading.setForeground(new Color(226, 226, 226));
//        pageHeading.setForeground(Color.BLACK);
        add(pageHeading);
    }

    public void adminLoginButton() {
        adminLogin = new JButton("Login as Admin");
        setupButton(adminLogin);
        add(adminLogin);
    }

    public void userLoginButton() {
        userLogin = new JButton("Login as User");
//        userLogin.setBounds(WIDTH / 4, marginTop + 3 * GAP_IN_BETWEEN + 2 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(userLogin);
        add(userLogin);
    }

    public void userSignupButton() {
        userSignup = new JButton("Create New Account");
//        userSignup.setBounds(WIDTH / 4, marginTop + 4 * GAP_IN_BETWEEN + (3 * HEIGHT / 10), WIDTH / 2, BUTTON_HEIGHT);
        setupButton(userSignup);
        add(userSignup);
    }

    public void guestLoginButton() {
        guestLogin = new JButton("Login as Guest");
//        guestLogin.setBounds(WIDTH / 4, marginTop + 5 * GAP_IN_BETWEEN + 4 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(guestLogin);
        add(guestLogin);
    }

    public void setupButton(JButton button) {
        add(Box.createRigidArea(new Dimension(Card.WIDTH, GAP)));
        button.setBorder(border);
        button.setMaximumSize(new Dimension(dimension.width / 2, 50));
        button.setBackground(new Color(76, 76, 76));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setVerticalAlignment(JButton.CENTER);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(true);
        button.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }
}
