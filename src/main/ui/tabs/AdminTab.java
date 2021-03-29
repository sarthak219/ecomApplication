package ui.tabs;

import database.Database;
import ui.screens.BigAppWindow;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AdminTab extends BigTab {

    public AdminTab(BigAppWindow controller, String title, Dimension dimension, Database database) {
        super(controller, dimension, database);
        initialiseTitle(title);
        displayOptionsInMenuPanel(database.getAdminOptions());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
