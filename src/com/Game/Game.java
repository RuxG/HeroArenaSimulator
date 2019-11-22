package com.Game;

import com.Heroes.Hero;
import javafx.util.Pair;

import java.util.ArrayList;

public class Game {
    private static Game instance = null;
    GameInput input;
    Map map;
    ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    private Game(GameInput input) {
        this.input = input;
        map = Map.getInstance(input.getMapSize().getKey(), input.getMapSize().getValue(),
                input.getLands());
        rounds = input.getRounds();
    }

    public static Game getInstance(GameInput input) {
        if (instance == null) {
            instance = new Game(input);
        }
        return instance;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }

}
