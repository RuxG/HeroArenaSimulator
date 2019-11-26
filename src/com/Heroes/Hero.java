package com.Heroes;


import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

import java.util.ArrayList;

public abstract class Hero {
    private int id;
    private String name;
    private float hp;
    private float exp;
    private int lvl;
    private int maxHP;
    private int baseHP;
    private int upHP;
    private ArrayList<IAbility> abilities;
    private OvertimeEffect effect;
    private MyPair<Character, MyPair<Integer, Integer>> position;

    public void checkLvlUp() {
        int expLvlUp = 250 + lvl * 50;
        float aux = exp;
        while (aux >= expLvlUp) {
            aux -= 50;
            lvl++;
            setMaxHP(baseHP + upHP * lvl);
            setHp(maxHP);
        }
    }

    public void addAbility(IAbility ability) {
        abilities.add(ability);
    }

    public abstract BattlesStatistics.AttackInfo acceptAttack(Hero caster, final ArrayList<IAbility> abilities);

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getUpHP() {
        return upHP;
    }

    public void setUpHP(int upHP) {
        this.upHP = upHP;
    }

    public ArrayList<IAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<IAbility> abilities) {
        this.abilities = abilities;
    }

    public OvertimeEffect getEffect() {
        return effect;
    }

    public void setEffect(OvertimeEffect effect) {
        this.effect = effect;
    }

    public MyPair<Character, MyPair<Integer, Integer>> getPosition() {
        return position;
    }

    public void setPosition(MyPair<Character, MyPair<Integer, Integer>> position) {
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


