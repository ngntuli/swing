package com.ntuli.model.map;

public class DirectorCoordinates {

    public static Coordinates newCoordinates(int x, int y, final MapGame mapGame) {
        Coordinates coordinates = null;
        if (mapGame == null || mapGame.getGrid()[y][x] == 0) {
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }
}
