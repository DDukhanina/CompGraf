package ru.vsu.cs.cg24.gr12_2.dukhanina_d_a;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel paintAreaPanel;
    private DrawPanel drawPanel;

    public MainFrame() {
        contentPane = new JPanel();
        paintAreaPanel = new JPanel();
        drawPanel = new DrawPanel();

        contentPane.setLayout(new BorderLayout());
        contentPane.add(paintAreaPanel, BorderLayout.CENTER);

        paintAreaPanel.setLayout(new BorderLayout());
        paintAreaPanel.add(drawPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setSize(1300, 900);
        dialog.setVisible(true);
        System.exit(0);
    }
}