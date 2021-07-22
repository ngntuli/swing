package com.ntuli.model.hero;

import com.ntuli.model.artifacts.Artifacts;
import com.ntuli.model.map.Coordinates;

import java.util.ArrayList;

public class HeroProduct {
    private ArrayList<Artifacts> artifacts;
    private String name;
    private String type;
    private int level;
    private int xp;
    private int attack;
    private int defense;
    private int hp;
    private Coordinates prevCoordinates;
    private Coordinates coordinates;

    public HeroProduct() {
        prevCoordinates = new Coordinates(0, 0);
        coordinates = new Coordinates(0, 0);
        artifacts = new ArrayList<Artifacts>();
    }

    public String getInfo() {
        return ("[" + type + " ] [Level: " + level + " ] [Exp: " + xp
                + " ] [Attack: " + attack + " ] [Defense: " + defense + " ] [Hit points: " + hp + " ]");
    }

    public void move(int x, int y) {
        prevCoordinates = new Coordinates(coordinates.getX(), coordinates.getY());
        coordinates = new Coordinates(coordinates.getX() + x, coordinates.getY() + y);
    }

    public int getXPNeeded() {
        double xP;
        xP = level * 1000 + Math.pow(((double) level) - 1, 2) * 450;
        return (int) xP;
    }

    public ArrayList<Artifacts> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<Artifacts> artifacts) {
        this.artifacts = artifacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public Coordinates getPrevCoordinates() {
        return prevCoordinates;
    }

    public void setPrevCoordinates(Coordinates prevCoordinates) {
        this.prevCoordinates = prevCoordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
