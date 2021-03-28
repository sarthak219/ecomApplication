package ui.tabs;

import database.Database;
import ui.screens.BigAppWindow;
import ui.tabs.options.ShowCartTab;
import ui.tabs.options.ShowProductsTab;
import ui.tabs.options.ShowWishlistTab;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * represents an abstract tab for tabbedPane in BigAppWindow
 */
public abstract class BigTab extends JPanel {
    public static final int OPTIONS_HEIGHT = 65;
    protected BigAppWindow controller;
    protected Border border;
    protected Dimension dimension;
    protected Database database;
    protected JPanel menuPanel;
    protected JPanel titlePanel;
    protected JTextField searchBar;
    protected ArrayList<JButton> buttons;
    private JTabbedPane workspaceTabbedPane;

    //REQUIRES: BigAppWindow controller that holds this tab
    public BigTab(BigAppWindow controller, Dimension dimension, Database database) {
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.dimension = dimension;
        this.controller = controller;
        this.database = database;
        initialisePanel();
        initialiseTitlePanel();
        initialiseWorkspaceTabbedPane();
        initialiseMenuPanel();
        initialiseSearchBar();
        initialiseSearchButton();
        validate();
        repaint();
    }

    public void initialisePanel() {
        setSize(dimension);
        setLayout(null);
        setBackground(new Color(23, 23, 23));
    }

    public void initialiseTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(76, 76, 76));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, dimension.width, dimension.height / 10);
        titlePanel.setVisible(true);
        add(titlePanel);
    }

    public void initialiseMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(40, 40, 40));
        //menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        int height = dimension.height - dimension.height / 10;
        menuPanel.setBounds(0, dimension.height / 10, dimension.width / 5, height);
        menuPanel.setVisible(true);
        menuPanel.setOpaque(true);
        add(menuPanel);
    }

    public void initialiseTitle(String title) {
        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(dimension.width / 5 + dimension.height / 30, 5, dimension.width, dimension.height / 11);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, dimension.height / 14));
        pageHeading.setHorizontalAlignment(JLabel.LEFT);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        titlePanel.add(pageHeading);
    }

    public void initialiseSearchBar() {
        searchBar = new JTextField(20);
        searchBar.setLayout(null);
        int tenthOfHeight = dimension.height / 10;
        searchBar.setBounds(3 * dimension.width / 4 - 20, tenthOfHeight / 4, dimension.width / 5, tenthOfHeight / 2);
        searchBar.setBorder(border);
        searchBar.setBackground(new Color(255, 255, 255));
        searchBar.setHorizontalAlignment(JTextField.LEFT);
        searchBar.setOpaque(true);
        searchBar.setFont(new Font("Helvetica", Font.PLAIN, dimension.height / 40));
        titlePanel.add(searchBar);
    }

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

    public void displayOptionsInMenuPanel(String[] buttons) {
        this.buttons = new ArrayList<>();
        for (String s : buttons) {
            JButton button = new JButton(s);
            setupButton(button);
            this.buttons.add(button);
            menuPanel.add(button);
        }
    }

    public void initialiseWorkspaceTabbedPane() {
        workspaceTabbedPane = new JTabbedPane();
//        workspaceTabbedPane.setBounds(0, 0, WIDTH, HEIGHT); //TODO:set y to -30
        int height = dimension.height / 10;
        workspaceTabbedPane.setBounds(dimension.width / 5, height, 4 * dimension.width / 5 - 10, 9 * height);
        workspaceTabbedPane.setBackground(Color.white);
        workspaceTabbedPane.setForeground(Color.BLACK);
        addElementsToWorkspaceTabbedPane();
        add(workspaceTabbedPane);
    }

    public void addElementsToWorkspaceTabbedPane() {
        JScrollPane showProducts = new JScrollPane(new ShowProductsTab(dimension, database), 22, 30);
        setupScrollPane(showProducts);
        workspaceTabbedPane.add("Products", showProducts);
        JScrollPane showWishlist = new JScrollPane(new ShowWishlistTab(dimension, database), 22, 30);
        setupScrollPane(showWishlist);
        workspaceTabbedPane.add("wishlist", showWishlist);
        JScrollPane showCart = new JScrollPane(new ShowCartTab(dimension, database), 22, 30);
        setupScrollPane(showCart);
        workspaceTabbedPane.add("Cart", showCart);
    }

    private void setupScrollPane(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(dimension.width - 10, dimension.height));
    }

    public void setupButton(JButton button) {
        button.setMaximumSize(new Dimension(dimension.width / 5 + 4, OPTIONS_HEIGHT));
        button.setBorder(border);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Helvetica", Font.PLAIN, OPTIONS_HEIGHT / 5));
    }
}
