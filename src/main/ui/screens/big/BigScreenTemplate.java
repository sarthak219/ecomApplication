package ui.screens.big;

import database.Database;
import ui.Card;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BigScreenTemplate extends JFrame {
    public static final float SCALE = (float) 0.8;
    public static final int WIDTH = (int) (1440 * SCALE);
    public static final int HEIGHT = (int) (900 * SCALE);
    public static final int MARGIN = HEIGHT / 10;
    public static final int MENU_PANEL_WIDTH = WIDTH / 5;
    public static final int WORKSPACE_PANEL_WIDTH = WIDTH - MENU_PANEL_WIDTH;
    public static final int WORKSPACE_PANEL_HEIGHT = HEIGHT - MARGIN;
    public static final int OPTIONS_HEIGHT = WORKSPACE_PANEL_HEIGHT / 10;
    protected JPanel menuPanel;
    protected JPanel titlePanel;
    protected JLayeredPane workspacePanel;
    protected JScrollPane workspace;
    protected Border border;
    protected JTextField searchBar;

    public BigScreenTemplate(String title, Database database) {
        initialiseGraphics();
        initialiseMenuPanel();
        initialiseTitlePanel();
        initialiseSearchBar();
        initialiseSearchButton();
        initialiseWorkspacePanel();
        initialiseWorkspace();

        JLabel pageHeading = new JLabel(title);
        pageHeading.setBounds(MENU_PANEL_WIDTH + MARGIN / 5, 0, WIDTH, HEIGHT / 10);
        pageHeading.setFont(new Font("Helvetica", Font.BOLD, 5 * MARGIN / 7));
        pageHeading.setHorizontalAlignment(JLabel.LEFT);
        pageHeading.setVerticalAlignment(JLabel.BOTTOM);
        titlePanel.add(pageHeading);


        revalidate();
        repaint();
    }

    public void initialiseGraphics() {
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(true);
        border = BorderFactory.createLineBorder(Color.BLACK);
    }

    public void initialiseTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(76, 76, 76));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, WIDTH, HEIGHT / 10);
        titlePanel.setVisible(true);
        add(titlePanel);
    }

    public void initialiseMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(40, 40, 40));
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, MARGIN, MENU_PANEL_WIDTH, HEIGHT - MARGIN);
        menuPanel.setVisible(true);
        add(menuPanel);
    }

    public void initialiseWorkspacePanel() {
        workspacePanel = new JLayeredPane();
        workspacePanel.setBackground(new Color(23, 23, 23));
        workspacePanel.setLayout(new BoxLayout(workspacePanel, BoxLayout.Y_AXIS));
        workspacePanel.setBorder(border);
        workspacePanel.setBounds(MENU_PANEL_WIDTH, MARGIN, WORKSPACE_PANEL_WIDTH, HEIGHT / 2);
        workspacePanel.setVisible(true);
        workspacePanel.setOpaque(true);
        System.out.print(workspacePanel.getX());
    }

    // workspacePanel.setLayout(new GridLayout(5, 0, 20, 20));
    //workspacePanel.setBounds(MENU_PANEL_WIDTH, MARGIN, WORKSPACE_PANEL_WIDTH, HEIGHT - MARGIN);

    public void initialiseWorkspace() {
        workspace = new JScrollPane(workspacePanel, 22, 32);
        workspace.setBackground(new Color(144, 56, 56));
        workspace.setForeground(new Color(23, 23, 23));
        workspace.setLayout(new ScrollPaneLayout());
        workspace.setBounds(MENU_PANEL_WIDTH, MARGIN, WORKSPACE_PANEL_WIDTH, HEIGHT - MARGIN);
        workspace.setVisible(true);
        add(workspace);
    }

    public void displayOptionsInMenuPanel(String[] buttons) {
        for (int i = 0; i < buttons.length; ++i) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(-1, OPTIONS_HEIGHT * i - i, MENU_PANEL_WIDTH + 2, OPTIONS_HEIGHT);
            button.setBorder(border);
            button.setHorizontalAlignment(JButton.CENTER);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Helvetica", Font.PLAIN, OPTIONS_HEIGHT / 5));
            menuPanel.add(button);
        }
    }

    public void initialiseSearchBar() {
        searchBar = new JTextField(20);
        searchBar.setLayout(null);
        searchBar.setBounds(3 * WIDTH / 4, MARGIN / 4, WIDTH / 5, MARGIN / 2);
        searchBar.setBorder(border);
        searchBar.setBackground(new Color(255, 255, 255));
        searchBar.setHorizontalAlignment(JTextField.LEFT);
        searchBar.setOpaque(true);
        searchBar.setFont(new Font("Helvetica", Font.PLAIN, MARGIN / 4));
        titlePanel.add(searchBar);
    }

    public void initialiseSearchButton() {
        JButton searchButton = new JButton("Search");
        searchButton.setLayout(null);
        searchButton.setBounds(19 * WIDTH / 20, MARGIN / 4, WIDTH / 21, MARGIN / 2);
        searchButton.setBorder(border);
        searchButton.setBackground(new Color(141, 141, 141));
        searchButton.setHorizontalAlignment(JButton.CENTER);
        searchButton.setOpaque(true);
        searchButton.setFont(new Font("Helvetica", Font.PLAIN, MARGIN / 5));
        //System.out.println((3 * MARGIN) / 4);
        titlePanel.add(searchButton);
    }
}
