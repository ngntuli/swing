package com.ntuli.view;

import com.ntuli.controller.Controller;
import com.ntuli.db.GameDB;
import com.ntuli.model.hero.DirectorHero;
import com.ntuli.model.hero.HeroBuilder;
import com.ntuli.model.hero.HeroProduct;
import com.ntuli.model.map.Coordinates;
import com.ntuli.model.map.MapGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame implements IView {

    static int selected;
    static HeroBuilder hero;
    static GameDB db;
    static List<String> names;
    static HeroProduct heroP;
    static List<HeroProduct> heroes;
    Controller controller;
    DirectorHero directorHero;
    private DisplayMap displayMap;

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void startGame() {

        try {
            names = db.getNamesFromDB();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


        StartGame startGame = new StartGame(this);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        startGame.setLocation(
                dimension.width / 2 - startGame.getSize().width / 2,
                dimension.height / 2 - startGame.getSize().height / 2
        );
        startGame.setVisible(true);
        startGame.setListeners();
    }

    @Override
    public void createPlayer() {
        CreatePlayer createPlayer = new CreatePlayer(this);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        createPlayer.setLocation(
                dimension.width / 2 - createPlayer.getSize().width / 2,
                dimension.height / 2 - createPlayer.getSize().height / 2
        );
        createPlayer.setVisible(true);
        createPlayer.setListeners();
    }

    @Override
    public void heroNamePrompt(String type) {

        HeroNamePrompt heroNamePrompt = new HeroNamePrompt(this);
        directorHero.construct(type);
        hero = directorHero.getHeroBuilder();

        heroNamePrompt.jTextArea1.setText(hero.infoHero());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        heroNamePrompt.setLocation(
                dim.width / 2 - heroNamePrompt.getSize().width / 2,
                dim.height / 2 - heroNamePrompt.getSize().height / 2
        );
        heroNamePrompt.setVisible(true);
        heroNamePrompt.setListeners();
    }

    @Override
    public void enterYourName() {

        EnterYourName enterYourName = new EnterYourName(this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        enterYourName.setLocation(
                dim.width / 2 - enterYourName.getSize().width / 2,
                dim.height / 2 - enterYourName.getSize().height / 2);
        enterYourName.setVisible(true);
        enterYourName.setListeners();
    }

    @Override
    public void existsHero() throws Exception {

        if (names.size() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "There is no saved Heroes. Create Him",
                    "Notice to you",
                    JOptionPane.ERROR_MESSAGE
            );
            createPlayer();
        } else {
            heroes = heroesDB();
            ExistsHero existsHero = new ExistsHero(this);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            existsHero.setLocation(
                    dim.width / 2 - existsHero.getSize().width / 2,
                    dim.height / 2 - existsHero.getSize().height / 2
            );
            existsHero.setVisible(true);
            existsHero.setListeners((ArrayList<HeroProduct>) heroesDB());
        }
    }

    @Override
    public void displayMap(MapGame map) {
        displayMap.displayPlayView();
    }

    @Override
    public boolean displayQuitDialogue(String msg) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, msg, "Choose below", dialogButton);

        return dialogResult == 0;
    }

    @Override
    public void quitDialogue() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(
                this,
                "Save current Game?",
                "Exiting Game",
                dialogButton
        );
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                db.updateHero(controller.hero);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setVisible(false);
            this.dispose();
        } else {
            this.setVisible(false);
            this.dispose();
        }
    }

    @Override
    public void displayBattleReport(String report) {
        displayMap.reportText.setText(report);
    }

    @Override
    public void displayForcedFightMsg() {
        String msg = "Busted!!! Fight";
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void displayGameOver() throws Exception {
        String status = controller.heroWon ? "WON!" : "DIED!";
        Object[] options1 = {"Start New Game ?", "Quit"};
        int dialogResult = JOptionPane.showOptionDialog(this, "You " + status, "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (dialogResult == JOptionPane.YES_OPTION) {
            controller.saveHero();
            if (controller.countLife == 0) {
                controller.countLife = 1;
            }
            controller.heroWon = false;
            controller.hero.setHp(controller.randClass.nextInt(300));
            controller.hero.setCoordinates(new Coordinates(controller.map.getSize() / 2, controller.map.getSize() / 2));
            controller.initGame();
            controller.displayGame();
        } else {
            controller.saveHero();
            displayHeroWonTheGame2();
        }
    }

    @Override
    public void displayHeroWonTheGame() {
        JOptionPane.showMessageDialog(
                this,
                "Sorry You have No Life ! Goodbye !!!",
                "Notice to you",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(1);
    }

    @Override
    public void displayHeroWonTheGame2() {
        JOptionPane.showMessageDialog(
                this,
                "Goodbye !!!",
                "Notice to you",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(1);
    }

    private List<HeroProduct> heroesDB() throws Exception {
        ArrayList<HeroProduct> details = new ArrayList<HeroProduct>();
        for (String name : names) {
            details.add(db.getHeroFromDB(name));
        }
        return details;
    }

}
