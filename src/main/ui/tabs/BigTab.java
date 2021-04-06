package ui.tabs;

import ui.Database;
import ui.screens.BigAppWindow;
import ui.tabs.options.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * represents an abstract tab for tabbedPane in BigAppWindow
 */
public abstract class BigTab extends JPanel implements CaretListener {
    public static final int OPTIONS_HEIGHT = 65;
    protected BigAppWindow controller;
    protected Border border;
    protected Dimension dimension;
    protected Database database;
    protected JPanel menuPanel;
    protected JPanel titlePanel;
    protected JTextField searchBar;
    protected ArrayList<JButton> buttons;
    protected JTabbedPane workspaceTabbedPane;
    protected ShowWishlistTab showWishlistTab;
    protected ShowProductsTab showProductsTabForUser;
    protected ShowProductsTab showProductsTabForAdmin;
    protected ShowCartTab showCartTab;
    protected ShowOrderHistoryTab showOrderHistoryTab;
    protected ShowUsersTab showUsersTab;

    //REQUIRES: BigAppWindow controller that holds this tab
    public BigTab(BigAppWindow controller, Dimension dimension, Database database) {
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.dimension = dimension;
        this.controller = controller;
        this.database = database;
        this.showWishlistTab = new ShowWishlistTab("Wishlist", dimension, database);
        this.showProductsTabForUser = new ShowProductsTab("All Products", dimension, database, "user");
        this.showProductsTabForAdmin = new ShowProductsTab("All Products", dimension, database, "admin");
        this.showCartTab = new ShowCartTab("Cart", dimension, database);
        this.showOrderHistoryTab = new ShowOrderHistoryTab("Order History", dimension, database);
        this.showUsersTab = new ShowUsersTab("All Users", dimension, database);

        initialisePanel();
        initialiseTitlePanel();
        initialiseWorkspaceTabbedPane();
        initialiseMenuPanel();
        initialiseSearchBar();
        initialiseSearchButton();
        validate();
        repaint();
    }

    //EFFECTS: initialises the BigTab panel to match the theme of the app
    public void initialisePanel() {
        setSize(dimension);
        setLayout(null);
        setBackground(new Color(23, 23, 23));

    }

    //EFFECTS: initialises the title panel to match the theme of the app and adds it
    public void initialiseTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(76, 76, 76));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, dimension.width, dimension.height / 10);
        titlePanel.setVisible(true);
        add(titlePanel);
    }

    //EFFECTS: initialises the menu panel to match the theme of the app and adds it
    public void initialiseMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(40, 40, 40));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        int height = dimension.height - dimension.height / 10;
        menuPanel.setBounds(0, dimension.height / 10, dimension.width / 5, height);
        menuPanel.setVisible(true);
        menuPanel.setOpaque(true);
        add(menuPanel);
    }

    //EFFECTS: initialises the title to match the theme of the app and adds it
    public void initialiseTitle(String title) {
        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(dimension.width / 5 + dimension.height / 30, 5, dimension.width, dimension.height / 11);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, dimension.height / 14));
        pageHeading.setHorizontalAlignment(JLabel.LEFT);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        titlePanel.add(pageHeading);
    }

    //EFFECTS: initialises the search text field to match the theme of the app and adds it
    public void initialiseSearchBar() {
        searchBar = new JTextField("", 20);
        searchBar.setLayout(null);
        int tenthOfHeight = dimension.height / 10;
        searchBar.setBounds(3 * dimension.width / 4 - 20, tenthOfHeight / 4, dimension.width / 5, tenthOfHeight / 2);
        searchBar.setBorder(border);
        searchBar.setBackground(new Color(255, 255, 255));
        searchBar.setHorizontalAlignment(JTextField.LEFT);
        searchBar.setOpaque(true);
        searchBar.setFont(new Font("Helvetica", Font.PLAIN, dimension.height / 40));
        searchBar.addCaretListener(this);
        titlePanel.add(searchBar);
    }

    //EFFECTS: initialises the search button to match the theme of the app and adds it
    public void initialiseSearchButton() {
        JButton searchButton = new JButton("Search");
        searchButton.setLayout(null);
        int partOfHeight = dimension.height / 20;
        searchButton.setBounds((19 * dimension.width / 20) - 20, partOfHeight / 2, dimension.width / 21, partOfHeight);
        searchButton.setBorder(border);
        searchButton.setBackground(new Color(141, 141, 141));
        searchButton.setHorizontalAlignment(JButton.CENTER);
        searchButton.setOpaque(true);
        searchButton.setFont(new Font("Helvetica", Font.PLAIN, dimension.height / 50));
        titlePanel.add(searchButton);
    }

    //MODIFIES: this
    //EFFECTS: makes a button with every string in the given list of string and adds it to buttons.
    public void displayOptionsInMenuPanel(String[] buttons) {
        this.buttons = new ArrayList<>();
        for (String s : buttons) {
            JButton button = new JButton(s);
            setupButton(button);
            this.buttons.add(button);
            menuPanel.add(button);
        }
        selectedButton(this.buttons.get(0));
    }

    //EFFECTS: initialises the tabbed pane having various screens of the application as its tabs and adds it
    public void initialiseWorkspaceTabbedPane() {
        workspaceTabbedPane = new JTabbedPane();
        int height = dimension.height / 10;
        workspaceTabbedPane.setBounds(dimension.width / 5, height - 30, 4 * dimension.width / 5 - 10, 9 * height);
        workspaceTabbedPane.setBackground(Color.white);
        workspaceTabbedPane.setForeground(Color.BLACK);
        addElementsToWorkspaceTabbedPane();
        add(workspaceTabbedPane);
    }

    //EFFECTS: adds various optionTabs to the workspaceTabbedPane
    public void addElementsToWorkspaceTabbedPane() {
        JScrollPane showProductsForUser = new JScrollPane(showProductsTabForUser, 22, 30);
        setupScrollPane(showProductsForUser);
        workspaceTabbedPane.add("Products(user)", showProductsForUser);
        JScrollPane showWishlist = new JScrollPane(showWishlistTab, 22, 30);
        setupScrollPane(showWishlist);
        workspaceTabbedPane.add("Wishlist", showWishlist);
        JScrollPane showCart = new JScrollPane(showCartTab, 22, 30);
        setupScrollPane(showCart);
        workspaceTabbedPane.add("Cart", showCart);
        JScrollPane showHistory = new JScrollPane(showOrderHistoryTab, 22, 30);
        setupScrollPane(showHistory);
        workspaceTabbedPane.add("Order History", showHistory);
        JScrollPane showUsers = new JScrollPane(showUsersTab, 22, 30);
        setupScrollPane(showUsers);
        workspaceTabbedPane.add("Users", showUsers);
        JScrollPane showProductsForAdmin = new JScrollPane(showProductsTabForAdmin, 22, 30);
        setupScrollPane(showProductsForAdmin);
        workspaceTabbedPane.add("Products(Admin)", showProductsForAdmin);
    }

    //EFFECTS: initialises the scrollPane to match the theme of the app which contains various optionTabs
    private void setupScrollPane(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(dimension.width - 10, dimension.height));
    }

    //EFFECTS: sets up the given button to match the theme of the app
    public void setupButton(JButton button) {
        button.setMaximumSize(new Dimension(dimension.width / 5 + 4, OPTIONS_HEIGHT));
        button.setBorder(border);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Helvetica", Font.PLAIN, OPTIONS_HEIGHT / 5));
    }

    //EFFECTS: changes foreground colour to black and background colour to white of the given button
    public void selectedButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
    }


}
