package ui.panels;

import database.Database;
import ui.BigAppWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class BigTab extends JPanel {
    protected BigAppWindow controller;
    protected Border border;
    protected Dimension dimension;
    protected Database database;
    protected JPanel menuPanel;
    protected JPanel titlePanel;
    protected JTextField searchBar;

    //REQUIRES: SmallAppWindow controller that holds this tab
    public BigTab(BigAppWindow controller, Dimension dimension) {
        this.border = BorderFactory.createLineBorder(Color.BLACK);
        this.dimension = dimension;
        this.controller = controller;
        initialisePanel();
        initialiseTitlePanel();
        initialiseMenuPanel();
        initialiseSearchBar();
        initialiseSearchButton();
    }

    public void initialisePanel() {
        setSize(dimension);
        setLayout(null);
        setBackground(new Color(23, 23, 23));
        //setupTitle(title);
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
        menuPanel.setLayout(null);
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
        searchButton.setBounds((19 * dimension.width / 20) - 20, dimension.height / 40, dimension.width / 21, dimension.height / 20);
        searchButton.setBorder(border);
        searchButton.setBackground(new Color(141, 141, 141));
        searchButton.setHorizontalAlignment(JButton.CENTER);
        searchButton.setOpaque(true);
        searchButton.setFont(new Font("Helvetica", Font.PLAIN, dimension.height / 50));
        titlePanel.add(searchButton);
    }
}
