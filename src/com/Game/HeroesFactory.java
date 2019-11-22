package com.Game;

import com.Abilities.IAbility;
import com.Constants;
import com.Heroes.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public class HeroesFactory {
    private static HeroesFactory instance = null;

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    ArrayList<Hero> getHeroes(ArrayList<Pair<String, Pair<Integer, Integer>>> initialPositions) {
        ArrayList<Hero> heroes = new ArrayList<>();
        Hashtable<String, IAbility> abilities = AbilitiesFactory.getInstance().getAbilities();
        for(int i = 0; i < initialPositions.size(); i++) {
            ArrayList<IAbility> ability = new ArrayList<>();
           switch(initialPositions.get(i).getKey()) {
               case "W":
                   ability.add(abilities.get("Deflect"));
                   ability.add(abilities.get("Drain"));
                   heroes.add(new Wizard(Constants.WIZARD_BASE_HP,
                           new Pair<String, Pair<Integer, Integer>>(initialPositions.get(i).getKey(),
                           initialPositions.get(i).getValue()), ability));
                   break;
               case "P":
                   ability.add(abilities.get("Fireblast"));
                   ability.add(abilities.get("Ignite"));
                   heroes.add(new Pyromancer(Constants.PYROMANCER_BASE_HP,
                           new Pair<String, Pair<Integer, Integer>>(initialPositions.get(i).getKey(),
                           initialPositions.get(i).getValue()), ability));
                   break;
               case "R":
                   ability.add(abilities.get("Backstab"));
                   ability.add(abilities.get("Paralysis"));
                   heroes.add(new Rogue(Constants.ROGUE_BASE_HP,
                           new Pair<String, Pair<Integer, Integer>>(initialPositions.get(i).getKey(),
                           initialPositions.get(i).getValue()), ability));
               case "K":
                   ability.add(abilities.get("Execute"));
                   ability.add(abilities.get("Slam"));
                   heroes.add(new Knight(Constants.KNIGHT_BASE_HP,
                           new Pair<String, Pair<Integer, Integer>>(initialPositions.get(i).getKey(),
                           initialPositions.get(i).getValue()), ability));
                   break;
           }
        }
        return heroes;
    }
}
