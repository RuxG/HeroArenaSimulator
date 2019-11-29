package com.Game;

import com.Abilities.IAbility;
import com.Constants;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

import java.util.ArrayList;
import java.util.Hashtable;


/**
 * This class is a factory for the game's heroes.
 */
public class HeroesFactory {
    private static HeroesFactory instance = null;

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    /**
     * This method instantiates the heroes, each with their given abilities
     * initial parameters.
     *
     * @param initialPositions retains the type and position of the heroes
     *                         that will be instantiated
     * @return a list of all the heroes who will participate in the game
     */
    public ArrayList<Hero> getHeroes(final ArrayList<MyPair<Character,
            MyPair<Integer, Integer>>> initialPositions) {

        ArrayList<Hero> heroes = new ArrayList<>();
        Hashtable<String, IAbility> abilities = AbilitiesFactory.getInstance().getAbilities();

        for (int i = 0; i < initialPositions.size(); i++) {
            BattlesStatistics.getInstance().getStatistics().put(i,
                    new BattlesStatistics.HeroInfo());
            Hashtable<MyPair<Integer, Integer>, Character> lands =
                    Map.getInstance().getLands();

            switch (initialPositions.get(i).getKey()) {
                case 'W':
                    heroes.add(new Wizard(i, Constants.WIZARD_BASE_HP, Constants.WIZARD_UP_HP,
                            new MyPair<Character, MyPair<Integer, Integer>>(
                                    lands.get(initialPositions.get(i).getValue()),
                                    initialPositions.get(i).getValue())));
                    heroes.get(i).addAbility(abilities.get("Deflect"));
                    heroes.get(i).addAbility(abilities.get("Drain"));
                    break;
                case 'P':
                    heroes.add(new Pyromancer(i, Constants.PYROMANCER_BASE_HP, Constants.PYRO_UP_HP,
                            new MyPair<Character, MyPair<Integer, Integer>>(
                                    lands.get(initialPositions.get(i).getValue()),
                                    initialPositions.get(i).getValue())));
                    heroes.get(i).addAbility(abilities.get("Fireblast"));
                    heroes.get(i).addAbility(abilities.get("Ignite"));
                    break;
                case 'R':
                    heroes.add(new Rogue(i, Constants.ROGUE_BASE_HP, Constants.ROGUE_UP_HP,
                            new MyPair<Character, MyPair<Integer, Integer>>(
                                    lands.get(initialPositions.get(i).getValue()),
                                    initialPositions.get(i).getValue())));
                    heroes.get(i).addAbility(abilities.get("Backstab"));
                    heroes.get(i).addAbility(abilities.get("Paralysis"));
                    break;
                case 'K':
                    heroes.add(new Knight(i, Constants.KNIGHT_BASE_HP, Constants.KNIGHT_UP_HP,
                            new MyPair<Character, MyPair<Integer, Integer>>(
                                    lands.get(initialPositions.get(i).getValue()),
                                    initialPositions.get(i).getValue())));
                    heroes.get(i).addAbility(abilities.get("Execute"));
                    heroes.get(i).addAbility(abilities.get("Slam"));
                    break;
                default:
                    break;
            }
        }
        return heroes;
    }
}
