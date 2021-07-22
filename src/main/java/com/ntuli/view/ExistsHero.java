package com.ntuli.view;

import com.ntuli.controller.Controller;
import com.ntuli.db.GameDB;
import com.ntuli.model.hero.HeroProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ExistsHero extends JFrame {
    private final List<String> names;
    private final GameDB db;
    private HeroProduct heroP;
    private final View view;
    private final Controller controller;
    private final javax.swing.JButton goback;
    private final JComboBox listheroes;
    private final javax.swing.JButton startgame;
    private final javax.swing.JTextArea statsHero;

    ExistsHero(View view) {
        this.view = view;
        controller = this.view.controller;
        this.db = View.db;
        List<HeroProduct> heroes = View.heroes;
        this.names = View.names;
        this.heroP = View.heroP;
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JPanel jPanel1 = new JPanel();
        startgame = new javax.swing.JButton();
        goback = new javax.swing.JButton();
        JPanel jPanel2 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        statsHero = new javax.swing.JTextArea();
        JPanel jPanel3 = new JPanel();
        ArrayList<String> options = fetchHeroDetails((ArrayList<HeroProduct>) heroes);
        listheroes = new JComboBox(options.toArray());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("swing");

        jLabel1.setForeground(new java.awt.Color(148, 225, 47));
        jLabel1.setLabelFor(listheroes);
        jLabel1.setText("Select Hero");

        jLabel2.setForeground(new java.awt.Color(208, 121, 121));
        jLabel2.setLabelFor(statsHero);
        jLabel2.setText("Hero Status");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(239, 73, 73), null));

        startgame.setForeground(new java.awt.Color(22, 111, 245));
        startgame.setText("Start Game");

        goback.setForeground(new java.awt.Color(185, 35, 35));
        goback.setText("Go Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startgame, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(goback, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(goback, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(startgame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(145, 8, 8), null));

        statsHero.setColumns(20);
        statsHero.setForeground(new java.awt.Color(0, 0, 0));
        statsHero.setRows(5);
        jScrollPane1.setViewportView(statsHero);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(46, 83, 21), null));

        listheroes.setBackground(new java.awt.Color(0, 0, 0));
        listheroes.setForeground(new java.awt.Color(226, 232, 212));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(listheroes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(listheroes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }

    void setListeners(final ArrayList<HeroProduct> heroes) {
        if (heroes.size() == 0)
            startgame.setEnabled(false);

        startgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    heroP = db.getHeroFromDB(names.get(listheroes.getSelectedIndex()));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                controller.hero = heroP;
                setVisible(false);
                dispose();
                controller.initGame();
                controller.displayGame();
            }
        });

        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                try {
                    view.startGame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        listheroes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> details = fetchAllHeroDetails(heroes);
                statsHero.setText(details.get(listheroes.getSelectedIndex()));
                View.selected = (listheroes.getSelectedIndex() + 1);
            }
        });
    }

    private ArrayList<String> fetchHeroDetails(ArrayList<HeroProduct> heroes) {
        ArrayList<String> details = new ArrayList<String>();
        int index = 0;
        for (HeroProduct player : heroes) {
            index++;
            String detail = index + ". " + player.getType() + " " + player.getName();
            details.add(detail);
        }
        return (details);
    }

    private ArrayList<String> fetchAllHeroDetails(ArrayList<HeroProduct> heroes) {
        ArrayList<String> details = new ArrayList<String>();
        for (HeroProduct player : heroes) {
            String detail = "\n\tName: " + player.getName() + "\n\n";
            detail += "\tType: " + player.getType() + "\n\n";
            detail += "\tLevel: " + player.getLevel() + "\n\n";
            detail += "\tExp: " + player.getXp() + "\n\n";
            detail += "\tAtk: " + player.getAttack() + "\n\n";
            detail += "\tDef: " + player.getDefense() + "\n\n";
            detail += "\tHp: " + player.getHp() + "\n\n";
            details.add(detail);
        }
        return (details);
    }
}
