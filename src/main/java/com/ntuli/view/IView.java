package com.ntuli.view;

import com.ntuli.model.map.MapGame;

public interface IView {

    void startGame() throws Exception;

    void  createPlayer();

    void heroNamePrompt(String type);

    void enterYourName();

    void existsHero() throws Exception;

    void displayMap(MapGame map);

    boolean displayQuitDialogue(String msg);

    void quitDialogue();

    void displayBattleReport(String report);

    void displayForcedFightMsg();

    void displayGameOver() throws Exception;

    void displayHeroWonTheGame();

    void displayHeroWonTheGame2();
}
