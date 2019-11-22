package com.Game;

import javafx.util.Pair;

import java.util.Hashtable;

public class Map {
    private static Map instance = null;
    Hashtable<Pair<Integer, Integer>, Character> lands;
    private int length;
    private int width;

    private Map(int length, int width, Hashtable<Pair<Integer, Integer>, Character> lands) {
        this.length = length;
        this.width = width;
        this.lands = lands;
    }

    public static Map getInstance(int length, int width, Hashtable<Pair<Integer, Integer>, Character> lands) {
        if (instance == null) {
            instance = new Map(length, width, lands);
        }
        return instance;
    }
    Hashtable<Pair<Integer, Integer>, Character> getLands() {
        return lands;
    }

}
