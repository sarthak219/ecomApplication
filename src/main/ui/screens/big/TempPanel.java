package ui.screens.big;

import javax.swing.*;
import java.awt.*;

public class TempPanel extends JPanel {

    public static final int MARGIN = HEIGHT / 10;
    public static final int MENU_PANEL_WIDTH = WIDTH / 5;
    public static final int WORKSPACE_PANEL_WIDTH = WIDTH - MENU_PANEL_WIDTH;
    public static final int WORKSPACE_PANEL_HEIGHT = HEIGHT - MARGIN;
    public static final int OPTIONS_HEIGHT = WORKSPACE_PANEL_HEIGHT / 10;

    public TempPanel() {
        //setBackground(new Color(23, 23, 23));
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(null);
        setBounds(11 * MENU_PANEL_WIDTH / 10, MARGIN, 9 * WORKSPACE_PANEL_WIDTH / 10, HEIGHT - MARGIN);
        setVisible(true);
        setOpaque(true);
        addLabels();
    }

    public void addLabels() {
        for (int i = 0; i < 100; ++i) {
            JLabel label = new JLabel("cvlsajhvcl,cvb,e_____" + i);
            setForeground(Color.WHITE);
            this.add(label);
        }
    }
}
