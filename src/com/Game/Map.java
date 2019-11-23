package com.Game;

import java.util.Hashtable;

public class Map {
    private static Map instance = null;
    private Hashtable<MyPair<Integer, Integer>, Character> lands;
    private int length;
    private int width;

    private Map(int length, int width, Hashtable<MyPair<Integer, Integer>, Character> lands) {
        this.length = length;
        this.width = width;
        this.lands = lands;
    }

    public static Map getInstance(int length, int width,
                                  Hashtable<MyPair<Integer, Integer>, Character> lands) {
        if (instance == null) {
            instance = new Map(length, width, lands);
        }
        return instance;
    }

    public static Map getInstance() {
        return instance;
    }

    public Hashtable<MyPair<Integer, Integer>, Character> getLands() {
        return lands;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

}
