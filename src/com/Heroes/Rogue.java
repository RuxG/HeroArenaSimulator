package com.Heroes;

import com.Abilities.IAbility;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class Rogue extends Hero {
    public Rogue(int hp, Pair<String, Pair<Integer, Integer>> position, ArrayList<IAbility> abilities) {
        this.hp = hp;
        exp = 0;
        lvl = 1;
        maxHP = hp;
        this.position = position;
        Collections.addAll(abilities);
    }
    void acceptAttack(int lvl, IAbility ability) {
        ability.execute(lvl,this);
    }
}
