package com.ntuli.model.enemy;

public class DirectorEnemy {
    private EnemyProduct enemyBuilder;
    private String[] enemies = {"Rat", "Monster", "Dragon", "Alien"};

    public void construct() {
        int rand = (int) (Math.random() * 4);

        if (enemies[rand].equals(enemies[0])) {
            enemyBuilder = new EnemyProduct();
            enemyBuilder.setEnemyBuilderStatsByDefaultsValue(enemies[rand]);
        } else if (enemies[rand].equals(enemies[1])) {
            enemyBuilder = new EnemyProduct();
            enemyBuilder.setEnemyBuilderStatsByDefaultsValue(enemies[rand]);
        } else if (enemies[rand].equals(enemies[2])) {
            enemyBuilder = new EnemyProduct();
            enemyBuilder.setEnemyBuilderStatsByDefaultsValue(enemies[rand]);
        } else if (enemies[rand].equals(enemies[3])) {
            enemyBuilder = new EnemyProduct();
            enemyBuilder.setEnemyBuilderStatsByDefaultsValue(enemies[rand]);
        }
    }

    public EnemyProduct getEnemyBuilder() {
        return enemyBuilder;
    }

    public String[] getEnemies() {
        return enemies;
    }
}
