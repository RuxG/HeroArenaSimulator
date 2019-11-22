package com.Heroes;

import com.Abilities.IAbility;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class Wizard extends Hero {
    Wizard(int hp, Pair<Pair<Integer, Integer>, Character> position, ArrayList<IAbility> abilities) {
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
