package com.ntuli.model.hero;

public interface HeroBuilder {

    String infoHero();

    String getNameI();

    void setNameI(String name);

    String getTypeI();

    int getLevelI();

    int getXpI();

    int getAttackI();

    int getDefenseI();

    int getHpI();

    void setHeroStatsWithDefaultValues();

}
