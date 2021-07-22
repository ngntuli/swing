package com.ntuli.view;

import com.ntuli.controller.Controller;
import com.ntuli.model.map.MapGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayMap extends JFrame {
    private final View view;
    private final Controller controller;
    JTextArea reportText;
    private boolean initialised = false;
    private JFrame frame;
    private JButton quit, north, south, west, east;
    private JPanel mapPanel, gamingPanel, movementPanel, statsPanel, reportPanel;
    private JLabel reportLabel, statsLabel, gamingLabel;
    private JTextArea statsText;
    private JScrollPane reportScroll, statsScroll;

    DisplayMap(View view) {
        this.view = view;
        this.controller = view.controller;
    }

    private void initHeroView() {
        quit = new JButton("Quit");
        west = new JButton("WEST");
        east = new JButton("EAST");
        south = new JButton("SOUTH");
        north = new JButton("NORTH");
        mapPanel = new JPanel();
        gamingPanel = new JPanel();
        movementPanel = new JPanel();
        statsPanel = new JPanel();
        reportPanel = new JPanel();
        statsLabel = new JLabel("Hero Status");
        reportLabel = new JLabel("Fight Report");
        gamingLabel = new JLabel("Gaming");
        statsText = new JTextArea();
        reportText = new JTextArea();
        statsScroll = new JScrollPane(statsText);
        reportScroll = new JScrollPane(reportText);

        statsText.setEditable(false);
        statsPanel.setLayout(null);

        reportText.setEditable(false);
        reportPanel.setLayout(null);

        movementPanel.setLayout(null);
        gamingPanel.setLayout(null);
        setColors();
        setBounds();
        setListeners();
        addToPanel();
    }

    private void setListeners() {
        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.receiveInputFromUser(1);
                    controller.displayGame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.receiveInputFromUser(4);
                    controller.displayGame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.receiveInputFromUser(2);
                    controller.displayGame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.receiveInputFromUser(3);
                    controller.displayGame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.quitDialogue();
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    private void setBounds() {
        statsLabel.setBounds(120, 10, 100, 20);
        statsScroll.setBounds(20, 40, 270, 460);
        statsPanel.setPreferredSize(new Dimension(295, 495));

        reportLabel.setBounds(120, 10, 100, 20);
        reportScroll.setBounds(0, 40, 270, 460);
        reportPanel.setPreferredSize(new Dimension(295, 495));

        north.setBounds(560, 20, 120, 20);
        south.setBounds(560, 100, 120, 20);
        east.setBounds(700, 60, 120, 20);
        west.setBounds(420, 60, 120, 20);
        quit.setBounds(700, 140, 160, 20);
        movementPanel.setPreferredSize(new Dimension(1200, 195));
        gamingPanel.setPreferredSize(new Dimension(600, 495));
        gamingLabel.setBounds(280, 10, 100, 20);
        mapPanel.setBounds(0, 40, 600, 455);
    }

    private void setColors() {
        statsLabel.setForeground(Color.WHITE);
        statsText.setBackground(Color.DARK_GRAY);
        statsText.setForeground(Color.WHITE);
        statsPanel.setBackground(Color.DARK_GRAY);
        reportLabel.setForeground(Color.WHITE);
        reportText.setBackground(Color.DARK_GRAY);
        reportText.setForeground(Color.WHITE);
        reportPanel.setBackground(Color.DARK_GRAY);
        movementPanel.setBackground(Color.DARK_GRAY);
        gamingLabel.setForeground(Color.WHITE);
        gamingPanel.setBackground(Color.DARK_GRAY);
    }

    private void addToPanel() {
        statsPanel.add(statsLabel);
        statsPanel.add(statsScroll);

        reportPanel.add(reportLabel);
        reportPanel.add(reportScroll);

        movementPanel.add(north);
        movementPanel.add(south);
        movementPanel.add(east);
        movementPanel.add(west);
        movementPanel.add(quit);

        gamingPanel.add(gamingLabel);
        gamingPanel.add(mapPanel);
    }

    void displayPlayView() {
        if (!initialised) {
            initHeroView();
            frame = new JFrame("Swingy");
            frame.add(statsPanel, BorderLayout.WEST);
            frame.add(gamingPanel, BorderLayout.CENTER);
            frame.add(reportPanel, BorderLayout.EAST);
            frame.add(movementPanel, BorderLayout.SOUTH);
            frame.setBackground(Color.WHITE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(1200, 720));
            frame.setResizable(false);
            frame.pack();
            initialised = true;
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        drawMap(controller.getMap());
    }

    private void drawMap(final MapGame map) {
        displayStatus();

        mapPanel.removeAll();
        mapPanel.setLayout(new GridLayout(map.getSize(), map.getSize()));
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                JButton button;
                if (map.getGrid()[i][j] == 1) {
                    button = new JButton();
                    button.setBackground(Color.GREEN);
                } else if (map.getGrid()[i][j] == 2) {
                    button = new JButton();
                    button.setBackground(Color.red);
                } else {
                    button = new JButton();
                    button.setBackground(Color.pink);
                }
                button.setOpaque(true);
                button.setEnabled(false);
                mapPanel.add(button);
            }
        }
        mapPanel.revalidate();
        mapPanel.repaint();
    }

    private void displayStatus() {
        String detail = "\n\tName: " + controller.getHero().getName() + "\n\n\n";
        detail += "\tType: " + controller.getHero().getType() + "\n\n\n";
        detail += "\tLevel: " + controller.getHero().getLevel() + "\n\n\n";
        detail += "\tExp: " + controller.getHero().getXp() + "\n\n\n";
        detail += "\tAtk: " + controller.getHero().getAttack() + "\n\n\n";
        detail += "\tDef: " + controller.getHero().getDefense() + "\n\n\n";
        detail += "\tHp: " + controller.getHero().getHp() + "\n\n\n";
        statsText.setText(detail);
    }
}
