package com.Angels;

import com.Game.GreatMagician;
import com.Game.MyPair;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the abstract form of an angel, with it's characteristics (name (type),
 * position on the map).
 */
public abstract class AAngel extends Observable {
    private String name;
    private MyPair<Character, MyPair<Integer, Integer>> position;
    private Observer observer;
    private boolean changed;

    AAngel(final String name) {
        this.name = name;
        observer = GreatMagician.getInstance();
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final MyPair<Character, MyPair<Integer, Integer>> getPosition() {
        return position;
    }

    public final void setPosition(final MyPair<Character, MyPair<Integer, Integer>> position) {
        this.position = position;
        changed = true;
        notifyObservers();
    }

    /**
     * notify the Great Magician about the angel's position on the map.
     */

    @Override
    public void notifyObservers() {
        if (changed) {
            observer.update(this, "Angel " + name + " was spawned at "
                    + position.getValue().getKey() + " " + position.getValue().getValue() + "\n");
            changed = false;
        }
    }

    /**
     * notify the Great Magician about the powers given to a hero.
     *
     * @param arg is the hero on which the angel executes an action
     */

    public abstract void notifyObservers(Object arg);

    /**
     * @param victim is the subject of an angel's action
     */
    public abstract void execute(Wizard victim);

    /**
     * @param victim is the subject of an angel's action
     */
    public abstract void execute(Pyromancer victim);

    /**
     * @param victim is the subject of an angel's action
     */
    public abstract void execute(Rogue victim);

    /**
     * @param victim is the subject of an angel's action
     */
    public abstract void execute(Knight victim);

    public final Observer getObserver() {
        return observer;
    }
}
