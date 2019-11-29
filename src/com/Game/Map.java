package com.Game;

import java.util.Hashtable;

/**
 * This class represents the game's map
 */
public class Map {
    private static Map instance = null;
    private Hashtable<MyPair<Integer, Integer>, Character> lands;
    private int length;
    private int width;

    private Map(final int length, final int width,
                final Hashtable<MyPair<Integer, Integer>, Character> lands) {
        this.length = length;
        this.width = width;
        this.lands = lands;
    }

    /**
     * @param length is the length of the map
     * @param width  is the width of the map
     * @param lands  define the individual cells of the map
     * @return map instance
     */
    public static Map getInstance(final int length, final int width,
                                  final Hashtable<MyPair<Integer, Integer>, Character> lands) {
        if (instance == null) {
            instance = new Map(length, width, lands);
        }
        return instance;
    }

    public static Map getInstance() {
        return instance;
    }

    public final Hashtable<MyPair<Integer, Integer>, Character> getLands() {
        return lands;
    }

    public final int getLength() {
        return length;
    }

    public final int getWidth() {
        return width;
    }

}
