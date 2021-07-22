package com.ntuli.db;

import com.ntuli.model.hero.DirectorHero;
import com.ntuli.model.hero.HeroBuilder;
import com.ntuli.model.hero.HeroProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "swingy";
    private static final String PASS = "swingy";
    private static GameDB db;
    private static Statement statm;
    private static ResultSet info;
    private Connection conn;

    private GameDB() {
        db = null;
    }

    public static GameDB getDb() {
        if (db == null) {
            db = new GameDB();
        }
        return db;
    }

    private void connectDb() throws Exception {
        if (conn == null) {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);

            statm = conn.createStatement();
            String createHeroTable =
                    "CREATE TABLE if not exists `swingy`.`heroes` (" +
                            "`name` TEXT NOT NULL , " +
                            "`type` TEXT NOT NULL , " +
                            "`level` INT NOT NULL , " +
                            "`exp` INT NOT NULL , " +
                            "`atk` INT NOT NULL , " +
                            "`def` INT NOT NULL , " +
                            "`hp` INT NOT NULL);";
            statm.executeUpdate(createHeroTable);
        }
    }

    public void insertHero(HeroBuilder insertHero) throws Exception {
        connectDb();

        statm = conn.createStatement();

        String create = String.format("INSERT INTO `swingy`.`heroes` (`name`, `type`, `level`, `exp`," +
                        " `atk`, `def`, `hp`) " +
                        " VALUES ('%s', '%s', %d, %d, %d, %d, %d)",

                insertHero.getNameI(),
                insertHero.getTypeI(),
                insertHero.getLevelI(),
                insertHero.getXpI(),
                insertHero.getAttackI(),
                insertHero.getDefenseI(),
                insertHero.getHpI()
        );
        statm.executeUpdate(create);
    }

    public boolean heroExists(String heroExist) throws Exception {
        connectDb();
        boolean exists = false;
        String select = String.format("SELECT * FROM `swingy`.`heroes` WHERE (`name` = '" + heroExist + "');");

        info = statm.executeQuery(select);
        exists = info.next();
        return exists;
    }

    public List<String> getNamesFromDB() throws Exception {
        connectDb();
        List<String> names = new ArrayList<String>();

        String selectCharactersQuery = "SELECT * FROM `swingy`.`heroes`";
        info = statm.executeQuery(selectCharactersQuery);
        while (info.next()) {
            names.add(info.getString("name"));
        }
        return names;
    }

    public void deleteHero(String name) throws Exception {
        connectDb();
        statm.execute("DELETE FROM `swingy`.`heroes` WHERE name = '" + name + "';");
    }

    public HeroProduct getHeroFromDB(String name) throws Exception {
        connectDb();
        String selectQuery = "SELECT * FROM `swingy`.`heroes` where name = '" + name + "';";
        info = statm.executeQuery(selectQuery);
        return info.next() ? new DirectorHero().buildByInfo(info) : null;
    }


    public void updateHero(HeroProduct heroUpdate) throws Exception {
        connectDb();

        String request = "UPDATE `swingy`.`heroes` SET level = " + heroUpdate.getLevel() + ", exp = " +
                heroUpdate.getXp() + ", atk = " + heroUpdate.getAttack() + ", def = " + heroUpdate.getDefense() +
                ", hp = " + heroUpdate.getHp() + " WHERE name = '" + heroUpdate.getName() + "';";

        try {
            statm.execute(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
