package com.Game;

import fileio.FileSystem;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class processes the input.
 */
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
        Hashtable<MyPair<Integer, Integer>, Character> lands = new Hashtable<>();
        ArrayList<MyPair<Character, MyPair<Integer, Integer>>> initialPosition = new ArrayList<>();
        MyPair<Integer, Integer> mapSize = null;
        ArrayList<String> rounds = new ArrayList<>();
        ArrayList<String> angelsRounds = new ArrayList<>();
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            mapSize = new MyPair<>(fs.nextInt(), fs.nextInt());
            for (int i = 0; i < mapSize.getKey(); i++) {
                String line = fs.nextWord();
                for (int j = 0; j < mapSize.getValue(); j++) {
                    lands.put(new MyPair<Integer, Integer>(i, j), line.charAt(j));
                }
            }
            noCharacters = fs.nextInt();
            for (int i = 0; i < noCharacters; i++) {
                String line = fs.nextWord();
                initialPosition.add(new MyPair<Character, MyPair<Integer, Integer>>(line.charAt(0),
                        new MyPair<Integer, Integer>(fs.nextInt(), fs.nextInt())));
            }
            noRounds = fs.nextInt();
            for (int i = 0; i < noRounds; i++) {
                rounds.add(fs.nextWord());
            }
            for (int i = 0; i < noRounds; i++) {
                int num = fs.nextInt();
                StringBuilder builder = new StringBuilder(Integer.valueOf(num));
                for (int j = 0; j < num; j++) {
                    builder.append(fs.nextWord());
                    if (j != num - 1) {
                        builder.append(" ");
                    }
                }
                angelsRounds.add(builder.toString());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(noCharacters, noRounds, lands, rounds, initialPosition, mapSize,
                angelsRounds, mOutputPath);
    }

    public String getmInputPath() {
        return mInputPath;
    }

    public String getmOutputPath() {
        return mOutputPath;
    }
}
