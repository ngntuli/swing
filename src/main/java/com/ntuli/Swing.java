package com.ntuli;

import com.ntuli.controller.Controller;

public class Swing {

    public static void main(String[] args) {
        try {
            Controller game = new Controller();
            game.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
