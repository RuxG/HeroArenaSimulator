package com.Game;

import fileio.FileSystem;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    public GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int noCharacters = -1;
        int noRounds = -1;
        Hashtable<Pair<Integer, Integer>, Character> lands = new Hashtable<>();
        ArrayList<Pair<String, Pair<Integer, Integer>>> initialPosition = new ArrayList<>();
        Pair<Integer, Integer> mapSize = null;
        ArrayList<String> rounds = new ArrayList<>();
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            mapSize = new Pair<>(fs.nextInt(), fs.nextInt());
            for (int i = 0; i < mapSize.getKey(); i++) {
                String line = fs.nextWord();
                for (int j = 0; j < mapSize.getValue(); j++) {
                    lands.put(new Pair<Integer, Integer>(i, j), line.charAt(j));
                }
            }
            noCharacters = fs.nextInt();
            for (int i = 0; i < noCharacters; i++) {
                initialPosition.add(new Pair<>(fs.nextWord(),
                        new Pair<>(fs.nextInt(), fs.nextInt())));
            }
            noRounds = fs.nextInt();
            for (int i = 0; i < noRounds; i++) {
                rounds.add(fs.nextWord());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(noCharacters, noRounds, lands, rounds, initialPosition, mapSize);
    }
}
