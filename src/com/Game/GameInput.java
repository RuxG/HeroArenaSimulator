package com.Game;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class retains the input of the game:
 * - heroes's *initial positions* on the map
 * - *sizes* of the map
 * - the *lands* of the map <=> <<coordinate, coordinate>, land_type>
 * - the number of *heroes* and *rounds*
 */
public class GameInput {
    private final ArrayList<MyPair<Character, MyPair<Integer, Integer>>> initialPosition;
    private final MyPair<Integer, Integer> mapSize;
    private final Hashtable<MyPair<Integer, Integer>, Character> lands;
    private final int noHeroes;
    private final int noRounds;
    private final ArrayList<String> rounds;

    public GameInput() {
        lands = null;
        initialPosition = null;
        noHeroes = -1;
        noRounds = -1;
        mapSize = null;
        rounds = null;
    }

    public GameInput(final int noCharacters, final int noRounds,
                     final Hashtable<MyPair<Integer, Integer>, Character> lands,
                     final ArrayList<String> rounds, final ArrayList<MyPair<Character,
            MyPair<Integer, Integer>>> initialPosition, final MyPair<Integer, Integer> mapSize) {
        this.lands = lands;
        this.initialPosition = initialPosition;
        this.noHeroes = noCharacters;
        this.noRounds = noRounds;
        this.mapSize = mapSize;
        this.rounds = rounds;
    }

    public final int getNoHeroes() {
        return noHeroes;
    }

    public final int getNoRounds() {
        return noRounds;
    }

    public final Hashtable<MyPair<Integer, Integer>, Character> getLands() {
        return lands;
    }

    public final ArrayList<MyPair<Character, MyPair<Integer, Integer>>> getInitialPosition() {
        return initialPosition;
    }

    public final MyPair<Integer, Integer> getMapSize() {
        return mapSize;
    }

    public final ArrayList<String> getRounds() {
        return rounds;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = lands != null && initialPosition != null && mapSize != null;
        boolean membersNotEmpty = lands.size() > 0 && initialPosition.size() > 0
                && noRounds > 0 && noHeroes > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
