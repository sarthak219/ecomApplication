package ui.panels;

import ui.SmallAppWindow;

import javax.swing.*;
import java.awt.*;

/**
 * represents the welcome screen
 */
public class WelcomeScreenTab extends Tab {
    protected Dimension dimension;
    protected JButton adminLogin;
    protected JButton userLogin;
    protected JButton userSignup;
    protected JButton guestLogin;

    public WelcomeScreenTab(SmallAppWindow controller, String title, Dimension dimension) {
        super(controller, dimension);
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
        setupTitle(title);
    }

    //EFFECTS: adds the title to the Welcome Screen
    public void setupTitle(String title) {
        add(Box.createRigidArea(new Dimension(dimension.width, 3 * GAP)));
        JLabel pageHeading = new JLabel(title);
        pageHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 52));
        pageHeading.setForeground(new Color(226, 226, 226));
        this.add(pageHeading);
    }

    public void adminLoginButton() {
        adminLogin = new JButton("Login as Admin");
        setupButton(adminLogin);
        adminLogin.addActionListener(e -> {
            getController().getTabbedPane().setSelectedIndex(1);
        });
        add(adminLogin);
    }

    public void userLoginButton() {
        userLogin = new JButton("Login as User");
        setupButton(userLogin);
        add(userLogin);
        userLogin.addActionListener(e -> {
            getController().getTabbedPane().setSelectedIndex(0);
        });
    }

    public void userSignupButton() {
        userSignup = new JButton("Create New Account");
        setupButton(userSignup);
        add(userSignup);
    }

    public void guestLoginButton() {
        guestLogin = new JButton("Login as Guest");
//        guestLogin.setBounds(WIDTH / 4, marginTop + 5 * GAP_IN_BETWEEN + 4 * HEIGHT / 10, WIDTH / 2, BUTTON_HEIGHT);
        setupButton(guestLogin);
        add(guestLogin);
    }


}
