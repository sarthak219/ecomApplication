package ui.tabs;

import ui.Database;
import ui.screens.BigAppWindow;
import ui.screens.FormWindow;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class AdminTab extends BigTab implements CaretListener {

    public AdminTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension, database);
        initialiseTitle(title);
        workspaceTabbedPane.setSelectedIndex(4);
        displayOptionsInMenuPanel(database.getAdminOptions());
        buttonFunctionality();
    }

    public void buttonFunctionality() {
        button1Action();
        button2Action();
        button3Action();
        button4Action();
    }

    /* protected String[] adminOptions = {"Show Users", "Show Products", "Add Products", "Log Out"};
     */

    private void button1Action() {
        buttons.get(0).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(0));
            showUsersTab.update("");
            workspaceTabbedPane.setSelectedIndex(4);
            searchBar.setText("");
        });
    }

    private void button2Action() {
        buttons.get(1).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(1));
            showProductsTabForAdmin.update("");
            showProductsTabForAdmin.update("");
            workspaceTabbedPane.setSelectedIndex(5);
            searchBar.setText("");
        });
    }

    private void button3Action() {
        buttons.get(2).addActionListener(e -> {
            new FormWindow(database).getTabbedPane().setSelectedIndex(1);
            searchBar.setText("");
        });
    }

    private void button4Action() {
        buttons.get(3).addActionListener(e -> {
            String message = "Are you sure you want to logout?";
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                controller.dispose();
                new SmallAppWindow(database);
            }
        });
    }

    public void resetAllButtons() {
        for (JButton button : buttons) {
            button.setOpaque(false);
            button.setForeground(Color.WHITE);
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        showProductsTabForAdmin.update(searchBar.getText());
        showUsersTab.update(searchBar.getText());
    }
}
