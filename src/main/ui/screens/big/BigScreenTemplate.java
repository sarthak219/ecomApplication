package ui.screens.big;

import database.Database;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ScrollBarUI;
import java.awt.*;
import java.util.ArrayList;

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
    protected JPanel workspacePanel;
    protected JScrollPane workspace;
    protected Border border;
    protected JTextField searchBar;
    protected ArrayList<JButton> buttons;

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
        setSize(WIDTH, HEIGHT + 30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(23, 23, 23));
        setResizable(false);
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
        workspacePanel = new JPanel();
        workspacePanel.setBackground(new Color(23, 23, 23));
        workspacePanel.setLayout(new BoxLayout(workspacePanel, BoxLayout.Y_AXIS));
        workspacePanel.setBorder(null);
        workspacePanel.setBounds(11 * MENU_PANEL_WIDTH / 10, MARGIN, 9 * WORKSPACE_PANEL_WIDTH / 10, HEIGHT - MARGIN);
        workspacePanel.setVisible(true);
        workspacePanel.setOpaque(true);
    }

    public void initialiseWorkspace() {
        workspace = new JScrollPane(workspacePanel, 20, 30);
        //workspace.setBackground(new Color(144, 56, 56));
        workspace.setBackground(null);
        workspace.setBorder(null);
        workspace.getVerticalScrollBar().setUI(new ScrollBarUI() {
        });
        workspace.setForeground(new Color(23, 23, 23));
        workspace.setLayout(new ScrollPaneLayout());
        int panelXCor = MENU_PANEL_WIDTH + WORKSPACE_PANEL_WIDTH / 10;
        workspace.setBounds(panelXCor, MARGIN, 8 * WORKSPACE_PANEL_WIDTH / 10, WORKSPACE_PANEL_HEIGHT);
        workspace.setVisible(true);
        add(workspace);
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
        searchButton.setBounds((19 * WIDTH / 20) - 1, MARGIN / 4, WIDTH / 21, MARGIN / 2);
        searchButton.setBorder(border);
        searchButton.setBackground(new Color(141, 141, 141));
        searchButton.setHorizontalAlignment(JButton.CENTER);
        searchButton.setOpaque(true);
        searchButton.setFont(new Font("Helvetica", Font.PLAIN, MARGIN / 5));
        //System.out.println((3 * MARGIN) / 4);
        titlePanel.add(searchButton);
    }

    public void displayOptionsInMenuPanel(String[] buttons) {
        this.buttons = new ArrayList<>();
        for (int i = 0; i < buttons.length; ++i) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(-1, OPTIONS_HEIGHT * i - i, MENU_PANEL_WIDTH + 2, OPTIONS_HEIGHT);
            button.setBorder(border);
            button.setHorizontalAlignment(JButton.CENTER);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Helvetica", Font.PLAIN, OPTIONS_HEIGHT / 5));
            this.buttons.add(button);
            menuPanel.add(button);
        }
    }
}
