package com.ntuli.model.map;

public class DirectorMap {

    public static MapGame newMap(int level) {
        int size = ((level - 1) * 5) + 10 - (level % 2);
        return new MapGame(size);
    }
}
