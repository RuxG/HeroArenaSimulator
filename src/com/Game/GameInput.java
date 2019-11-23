package com.Game;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameInput {
    private final ArrayList<MyPair<Character, MyPair<Integer, Integer>>> initialPosition;
    private final MyPair<Integer, Integer> mapSize;
    private final Hashtable<MyPair<Integer, Integer>, Character> lands;
    private final int noCharacters;
    private final int noRounds;
    private final ArrayList<String> rounds;

    public GameInput() {
        lands = null;
        initialPosition = null;
        noCharacters = -1;
        noRounds = -1;
        mapSize = null;
        rounds = null;
    }

    public GameInput(int noCharacters, int noRounds, Hashtable<MyPair<Integer, Integer>, Character> lands,
                     ArrayList<String> rounds, ArrayList<MyPair<Character,
            MyPair<Integer, Integer>>> initialPosition, MyPair<Integer, Integer> mapSize) {
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

    public int getNoRounds() {
        return noRounds;
    }

    public Hashtable<MyPair<Integer, Integer>, Character> getLands() {
        return lands;
    }

    public ArrayList<MyPair<Character, MyPair<Integer, Integer>>> getInitialPosition() {
        return initialPosition;
    }

    public MyPair<Integer, Integer> getMapSize() {
        return mapSize;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = lands != null && initialPosition != null && mapSize != null;
        boolean membersNotEmpty = lands.size() > 0 && initialPosition.size() > 0
                && noRounds > 0 && noCharacters > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
