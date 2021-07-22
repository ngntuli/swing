package com.ntuli.model.enemy;

import com.ntuli.model.map.Coordinates;

import java.util.Random;

public class EnemyProduct {
    private String nameEnemy;
    private String typeEnemy = "Enemy";
    private int levelEnemy;
    private int xpEnemy;
    private int attackEnemy;
    private int defenseEnemy;
    private int hpEnemy;
    private Coordinates coordinatesEnemy;

    public EnemyProduct() {
        coordinatesEnemy = new Coordinates(0, 0);
    }

    public String getInfo() {
        return ("\n\t" + nameEnemy + "\n\n\n\tLevel: " + levelEnemy + "\n\n\n\tExp: " + xpEnemy +
                "\n\n\n\tAttack: " + attackEnemy + "\n\n\n\tDefense: " + defenseEnemy +
                "\n\n\n\tHit points: " + hpEnemy + "\n\n\n"
        );
    }

    void setEnemyBuilderStatsByDefaultsValue(String nameEnemy) {
        Random rand = new Random();
        int c = rand.nextInt(16) + 1;
        setNameEnemy(nameEnemy);
        setLevelEnemy(rand.nextInt(6) + 1);
        setXpEnemy(0);
        setAttackEnemy(rand.nextInt(16 - c + 2) * 21);
        setDefenseEnemy(rand.nextInt(16 - c + 1) * 16);
        setHpEnemy(rand.nextInt(16 - c + 1) * 66);
    }

    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public String getTypeEnemy() {
        return typeEnemy;
    }

    public void setTypeEnemy(String typeEnemy) {
        this.typeEnemy = typeEnemy;
    }

    public int getLevelEnemy() {
        return levelEnemy;
    }

    public void setLevelEnemy(int levelEnemy) {
        this.levelEnemy = levelEnemy;
    }

    public int getXpEnemy() {
        return xpEnemy;
    }

    public void setXpEnemy(int xpEnemy) {
        this.xpEnemy = xpEnemy;
    }

    public int getAttackEnemy() {
        return attackEnemy;
    }

    public void setAttackEnemy(int attackEnemy) {
        this.attackEnemy = attackEnemy;
    }

    public int getDefenseEnemy() {
        return defenseEnemy;
    }

    public void setDefenseEnemy(int defenseEnemy) {
        this.defenseEnemy = defenseEnemy;
    }

    public int getHpEnemy() {
        return hpEnemy;
    }

    public void setHpEnemy(int hpEnemy) {
        this.hpEnemy = hpEnemy;
    }

    public Coordinates getCoordinatesEnemy() {
        return coordinatesEnemy;
    }

    public void setCoordinatesEnemy(Coordinates coordinatesEnemy) {
        this.coordinatesEnemy = coordinatesEnemy;
    }
}
