package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingScreen extends JFrame implements ActionListener {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    private JProgressBar progressBar;
    private int progress;

    public LoadingScreen(String message) {
        add(Box.createRigidArea(new Dimension(WIDTH, HEIGHT / 3)));
        initialiseGraphics();
        insertMessage(message);
        initialiseProgressBar();
        Timer t = new Timer(10, this);
        setVisible(true);
        t.start();
    }

    public void insertMessage(String message) {
        JLabel message1 = new JLabel(message);
        message1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(message1);
    }

    public void initialiseProgressBar() {
        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(WIDTH / 2, 10));
        add(progressBar);
    }

    public void initialiseGraphics() {
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (progress == 100) {
            dispose();
        }
        progress++;
        progressBar.setValue(progress);
    }
}