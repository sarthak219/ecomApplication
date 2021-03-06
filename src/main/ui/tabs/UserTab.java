package ui.tabs;

import ui.Database;
import ui.screens.BigAppWindow;
import ui.screens.SmallAppWindow;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class UserTab extends BigTab implements CaretListener {

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
            showOrderHistoryTab.update("");
            workspaceTabbedPane.setSelectedIndex(3);
            searchBar.setText("");
        });
    }

    private void button3Action() {
        buttons.get(2).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(2));
            showCartTab.update("");
            workspaceTabbedPane.setSelectedIndex(2);
            searchBar.setText("");
        });
    }

    private void button2Action() {
        buttons.get(1).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(1));
            showWishlistTab.update("");
            workspaceTabbedPane.setSelectedIndex(1);
            searchBar.setText("");
        });
    }

    private void button1Action() {
        buttons.get(0).addActionListener(e -> {
            resetAllButtons();
            selectedButton(buttons.get(0));
            showProductsTabForUser.update("");
            workspaceTabbedPane.setSelectedIndex(0);
            searchBar.setText("");
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
        showProductsTabForUser.update(searchBar.getText());
        showWishlistTab.update(searchBar.getText());
        showCartTab.update(searchBar.getText());
        showOrderHistoryTab.update(searchBar.getText());
    }
}
