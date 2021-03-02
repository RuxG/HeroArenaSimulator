package com.Heroes;

import com.Abilities.Strategy;

import java.util.Hashtable;

public final class StrategiesFactory {
    private static StrategiesFactory instance = null;
    private Hashtable<String, Strategy> strategies;

    private StrategiesFactory() {

    }

    public static StrategiesFactory getInstance() {
        if (instance == null) {
            instance = new StrategiesFactory();
        }
        return instance;
    }

    public Hashtable<String, Strategy> getStrategies() {
        strategies = new Hashtable<>();
        strategies.put("Wizard", new Strategy(Constants.WATTACKSTRATEGYLOWHP,
                Constants.WATTACKSTRATEGYHIGHHP,
                Constants.WATTACKSTRATEGDRAINHP, Constants.WATTACKSTRATEGYADDCOEFF,
                Constants.WDEFENSESTRATEGYLOWHP,
                Constants.WDEFENSESTRATEGYDRAINCOEFF, Constants.WDEFENSESTRATEGYADDHP));
        strategies.put("Pyromancer", new Strategy(Constants.PATTACKSTRATEGYLOWHP,
                Constants.PATTACKSTRATEGYHIGHHP,
                Constants.PATTACKSTRATEGDRAINHP, Constants.PATTACKSTRATEGYADDCOEFF,
                Constants.PDEFENSESTRATEGYLOWHP,
                Constants.PDEFENSESTRATEGYDRAINCOEFF, Constants.PDEFENSESTRATEGYADDHP));
        strategies.put("Rogue", new Strategy(Constants.RATTACKSTRATEGYLOWHP,
                Constants.RATTACKSTRATEGYHIGHHP,
                Constants.RATTACKSTRATEGDRAINHP, Constants.RATTACKSTRATEGYADDCOEFF,
                Constants.RDEFENSESTRATEGYLOWHP,
                Constants.RDEFENSESTRATEGYDRAINCOEFF, Constants.RDEFENSESTRATEGYADDHP));
        strategies.put("Knight", new Strategy(Constants.KATTACKSTRATEGYLOWHP,
                Constants.KATTACKSTRATEGYHIGHHP,
                Constants.KATTACKSTRATEGDRAINHP, Constants.KATTACKSTRATEGYADDCOEFF,
                Constants.KDEFENSESTRATEGYLOWHP,
                Constants.KDEFENSESTRATEGYDRAINCOEFF, Constants.KDEFENSESTRATEGYADDHP));
        return strategies;
    }

    class Constants {
        static final float WATTACKSTRATEGYLOWHP = 1 / 4f;
        static final float PATTACKSTRATEGYLOWHP = 1 / 4f;
        static final float RATTACKSTRATEGYLOWHP = 1 / 2f;
        static final float KATTACKSTRATEGYLOWHP = 1 / 4f;

        static final float WATTACKSTRATEGYHIGHHP = 1 / 2f;
        static final float PATTACKSTRATEGYHIGHHP = 0.333f;
        static final float RATTACKSTRATEGYHIGHHP = 1 / 5f;
        static final float KATTACKSTRATEGYHIGHHP = 1 / 2f;

        static final float WATTACKSTRATEGDRAINHP = 10f;
        static final float PATTACKSTRATEGDRAINHP = 4f;
        static final float RATTACKSTRATEGDRAINHP = 7f;
        static final float KATTACKSTRATEGDRAINHP = 5f;

        static final float WATTACKSTRATEGYADDCOEFF = 0.6f;
        static final float PATTACKSTRATEGYADDCOEFF = 0.7f;
        static final float RATTACKSTRATEGYADDCOEFF = 0.4f;
        static final float KATTACKSTRATEGYADDCOEFF = 0.5f;

        static final float WDEFENSESTRATEGYLOWHP = 1 / 4f;
        static final float PDEFENSESTRATEGYLOWHP = 1 / 4f;
        static final float RDEFENSESTRATEGYLOWHP = 0.142f;
        static final float KDEFENSESTRATEGYLOWHP = 0.333f;

        static final float WDEFENSESTRATEGYDRAINCOEFF = 0.2f;
        static final float PDEFENSESTRATEGYDRAINCOEFF = 0.3f;
        static final float RDEFENSESTRATEGYDRAINCOEFF = 0.1f;
        static final float KDEFENSESTRATEGYDRAINCOEFF = 0.2f;

        static final float WDEFENSESTRATEGYADDHP = 1 / 5f;
        static final float PDEFENSESTRATEGYADDHP = 0.333f;
        static final float RDEFENSESTRATEGYADDHP = 1 / 2f;
        static final float KDEFENSESTRATEGYADDHP = 1 / 4f;
    }
}
