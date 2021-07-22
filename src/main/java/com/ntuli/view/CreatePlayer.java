package com.ntuli.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePlayer extends JFrame {

    private final View view;
    private final javax.swing.JRadioButton gobackbutton;
    private final javax.swing.JRadioButton hbutton;
    private final javax.swing.JButton proceed;
    private final javax.swing.JRadioButton tbutton;

    CreatePlayer(View view) {
        this.view = view;
        ButtonGroup rbuttonGroup2 = new ButtonGroup();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JPanel jPanel2 = new JPanel();
        hbutton = new javax.swing.JRadioButton();
        gobackbutton = new javax.swing.JRadioButton();
        JRadioButton wbutton = new JRadioButton();
        proceed = new javax.swing.JButton();
        tbutton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("swing");
        setBackground(new java.awt.Color(153, 153, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, null));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Select a Type of Hero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(46, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rbuttonGroup2.add(hbutton);
        hbutton.setText("Hunter");

        rbuttonGroup2.add(gobackbutton);
        gobackbutton.setText("GoBack To Main");

        rbuttonGroup2.add(wbutton);
        wbutton.setSelected(true);
        wbutton.setText("Warrior");

        proceed.setBackground(new java.awt.Color(153, 255, 0));
        proceed.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        proceed.setForeground(new java.awt.Color(51, 204, 0));
        proceed.setText("OK");

        rbuttonGroup2.add(tbutton);
        tbutton.setText("Thief");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(hbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gobackbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(wbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(proceed)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(wbutton)
                                                .addGap(18, 18, 18)
                                                .addComponent(hbutton)
                                                .addGap(18, 18, 18)
                                                .addComponent(tbutton)
                                                .addGap(18, 18, 18)
                                                .addComponent(gobackbutton))
                                        .addComponent(proceed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    void setListeners() {
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                if (hbutton.isSelected()) {
                    view.heroNamePrompt("hunter");
                } else if (tbutton.isSelected()) {
                    view.heroNamePrompt("thief");
                } else if (gobackbutton.isSelected()) {
                    try {
                        view.startGame();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else view.heroNamePrompt("warrior");
            }
        });
    }
}
