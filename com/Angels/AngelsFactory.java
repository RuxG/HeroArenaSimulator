package com.Angels;

import java.util.Hashtable;
/**
 * This class is a factory for the game's angels.
 */
public class AngelsFactory {
    private static AngelsFactory instance = null;

    private AngelsFactory() {
    }

    public static AngelsFactory getInstance() {
        if (instance == null) {
            instance = new AngelsFactory();
        }
        return instance;
    }

    /**
     *
     * @return the angels of the game
     */
    public Hashtable<String, AAngel> getAngels() {
        Hashtable<String, AAngel> angels = new Hashtable<>();

        angels.put("DamageAngel", new DamageAngel());
        angels.put("DarkAngel", new DarkAngel());
        angels.put("Dracula", new Dracula());
        angels.put("GoodBoy", new GoodBoy());
        angels.put("LifeGiver", new LifeGiver());
        angels.put("LevelUpAngel", new LvlUpAngel());
        angels.put("SmallAngel", new SmallAngel());
        angels.put("Spawner", new Spawner());
        angels.put("TheDoomer", new TheDoomer());
        angels.put("XPAngel", new XpAngel());

        return angels;
    }

}
