package com.ntuli.model.map;

public class MapGame {
    private int size;
    private int[][] grid;

    public MapGame(int size) {
        this.setSize(size);
        this.setGrid(new int[size][size]);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
