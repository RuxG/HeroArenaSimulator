package com.Heroes;


import com.Abilities.IAbility;
import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Hero {
    protected float hp;
    protected float exp;
    protected int lvl;
    protected int maxHP;
    protected ArrayList<IAbility> abilities;
    Pair<Pair<Integer, Integer>, Character> position;

    void addAbility(IAbility ability) {
        abilities.add(ability);
    }

    abstract void acceptAttack(int lvl, IAbility ability);

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Pair<Pair<Integer, Integer>, Character> getPosition() {
        return position;
    }

    public void setPosition(Pair<Pair<Integer, Integer>, Character> position) {
        this.position = position;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }



}


