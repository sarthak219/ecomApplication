package ui.tabs;

import database.Database;
import ui.screens.BigAppWindow;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class UserTab extends BigTab {

    public UserTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension, database);
        initialiseTitle(title);
        displayOptionsInMenuPanel(database.getUserOptions());
        buttonFunctionality();
    }

    public void buttonFunctionality() {
        button1Action();

        button2Action();

        button3Action();

        button4Action();
        button5Action();
    }

    private void button5Action() {
        buttons.get(4).addActionListener(e -> {
            String message = "Are you sure you want to logout?";
            int response = JOptionPane.showConfirmDialog(null, message, "Confirm", 0, 3);
            if (response == JOptionPane.YES_OPTION) {
                controller.dispose();
                new SmallAppWindow(database);
            }
        });
    }

    private void button4Action() {
        buttons.get(3).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(3));
            showOrderHistoryTab.updatePanel();
            workspaceTabbedPane.setSelectedIndex(3);
        });
    }

    private void button3Action() {
        buttons.get(2).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(2));
            showCartTab.updatePanel();
            workspaceTabbedPane.setSelectedIndex(2);
        });
    }

    private void button2Action() {
        buttons.get(1).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(1));
            showWishlistTab.updatePanel();
            workspaceTabbedPane.setSelectedIndex(1);
        });
    }

    private void button1Action() {
        buttons.get(0).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(0));
            showProductsTab.updatePanel();
            workspaceTabbedPane.setSelectedIndex(0);
        });
    }

    public void resetAllButtons() {
        for (JButton button : buttons) {
            button.setOpaque(false);
            button.setForeground(Color.WHITE);
        }
    }
}
