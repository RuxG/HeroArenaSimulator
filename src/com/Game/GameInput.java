package com.Game;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameInput {
    private final ArrayList<Pair<String, Pair<Integer, Integer>>> initialPosition;
    private final Pair<Integer, Integer> mapSize;
    Hashtable<Pair<Integer, Integer>, Character> lands;
    private int noCharacters;
    private int noRounds;
    private ArrayList<String> rounds;

    public GameInput() {
        lands = null;
        initialPosition = null;
        noCharacters = -1;
        noRounds = -1;
        mapSize = null;
    }

    public GameInput(int noCharacters, int noRounds, Hashtable<Pair<Integer, Integer>, Character> lands,
                     ArrayList<String> rounds, ArrayList<Pair<String,
            Pair<Integer, Integer>>> initialPosition, Pair<Integer, Integer> mapSize) {
        this.lands = lands;
        this.initialPosition = initialPosition;
        this.noCharacters = noCharacters;
        this.noRounds = noRounds;
        this.mapSize = mapSize;
        this.rounds = rounds;
    }

    public int getNoCharacters() {
        return noCharacters;
    }

    public void setNoCharacters(int noCharacters) {
        this.noCharacters = noCharacters;
    }

    public int getNoRounds() {
        return noRounds;
    }

    public void setNoRounds(int noRounds) {
        this.noRounds = noRounds;
    }

    public Hashtable<Pair<Integer, Integer>, Character> getLands() {
        return lands;
    }



    public ArrayList<Pair<String, Pair<Integer, Integer>>> getInitialPosition() {
        return initialPosition;
    }

    public Pair<Integer, Integer> getMapSize() {
        return mapSize;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<String> rounds) {
        this.rounds = rounds;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = lands != null && initialPosition != null && mapSize != null;
        boolean membersNotEmpty = lands.size() > 0 && initialPosition.size() > 0
                && noRounds > 0 && noCharacters > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
