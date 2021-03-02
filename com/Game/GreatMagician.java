package com.Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the Great Magician, with his characteristics.
 */
public final class GreatMagician implements Observer {
    private static GreatMagician instance = null;
    private ArrayList<Observable> subjects;
    private String outputPath;

    private GreatMagician() {
        subjects = new ArrayList<>();
    }

    public static GreatMagician getInstance() {
        if (instance == null) {
            instance = new GreatMagician();
        }
        return instance;
    }

    public void setOutputPath(final String outputPath) {
        this.outputPath = outputPath;
    }

    public void addSubjects(final Observable subject) {
        subjects.add(subject);
    }

    @Override
    public void update(final Observable observable, final Object o) {
        if (o instanceof String) {
            try {
                Game.getWriter().print((String) o);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public ArrayList<Observable> getSubjects() {
        return subjects;
    }

    public void setSubjects(final ArrayList<Observable> subjects) {
        this.subjects = subjects;
    }
}
