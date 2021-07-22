package com.ntuli.model.hero;

import com.ntuli.model.map.Coordinates;
import com.ntuli.model.map.DirectorCoordinates;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.ResultSet;
import java.util.Set;
import java.util.logging.Level;

public class DirectorHero {
    private HeroBuilder heroBuilder;

    public void construct(String type) {
        if (type.equals("warrior")) {
            heroBuilder = new WarriorConcrete();
            heroBuilder.setHeroStatsWithDefaultValues();
        } else if (type.equals("hunter")) {
            heroBuilder = new HunterConcrete();
            heroBuilder.setHeroStatsWithDefaultValues();
        } else {
            heroBuilder = new ThiefConcrete();
            heroBuilder.setHeroStatsWithDefaultValues();
        }
    }

    /* https://www.programcreek.com/java-api-examples/javax.validation.ValidatorFactory */
    public String SetTheNameOfUser(HeroBuilder hero, String name) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        hero.setNameI(name);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<HeroBuilder>> violations = validator.validate(hero);

        for (ConstraintViolation<HeroBuilder> violation : violations) {
            return violation.getMessage();
        }
        return null;
    }

    public HeroProduct buildByInfo(ResultSet info) throws Exception {
        HeroProduct heroGetInfo = new HeroProduct();

        heroGetInfo.setName(info.getString("name"));
        heroGetInfo.setType(info.getString("type"));
        heroGetInfo.setAttack(info.getInt("atk"));
        heroGetInfo.setDefense(info.getInt("def"));
        heroGetInfo.setXp(info.getInt("exp"));
        heroGetInfo.setLevel(info.getInt("level"));
        heroGetInfo.setHp(info.getInt("hp"));
        int size = ((heroGetInfo.getLevel() - 1) * 5) + 10 - (heroGetInfo.getLevel() % 2);
        Coordinates coordinates = DirectorCoordinates.newCoordinates(size / 2, size / 2, null);
        heroGetInfo.setCoordinates(coordinates);

        return heroGetInfo;
    }

    public HeroBuilder getHeroBuilder() {
        return heroBuilder;
    }
}
