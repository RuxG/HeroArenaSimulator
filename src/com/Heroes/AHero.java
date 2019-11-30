package com.Heroes;


import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

import java.util.ArrayList;

/**
 * This class represents the abstract form of a hero, with it's specific characteristics.
 */
public abstract class AHero {
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

    AHero(final int id, final String name, final int hp, final int upHP,
          final MyPair<Character, MyPair<Integer, Integer>> position) {
        setId(id);
        setName(name);
        setHp(hp);
        setExp(0);
        setLvl(0);
        setMaxHP(hp);
        setBaseHP(hp);
        setUpHP(upHP);
        setPosition(position);
        setAbilities(new ArrayList<>());
        setEffect(new OvertimeEffect(0, 0, false, this));
    }

    public final void checkLvlUp() {
        int expLvlUp = Constants.LVL_UP_EXP + lvl * Constants.LVL_STEP;
        float aux = exp;
        while (aux >= expLvlUp) {
            aux -= Constants.LVL_STEP;
            lvl++;
            setMaxHP(baseHP + upHP * lvl);
            setHp(maxHP);
        }
    }

    public final void addAbility(final IAbility ability) {
        abilities.add(ability);
    }

    /**
     * This method sequentially applies the caster's abilities on the current Hero instantiation
     * and retains the damage given in the attack.
     *
     * @param caster is the hero initiating the attack
     * @return information about the battle outcome
     */
    public abstract BattlesStatistics.AttackInfo acceptAttack(AHero caster);

    public final int getLvl() {
        return lvl;
    }

    public final void setLvl(final int lvl) {
        this.lvl = lvl;
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final float getExp() {
        return exp;
    }

    public final void setExp(final float exp) {
        this.exp = exp;
    }

    public final int getBaseHP() {
        return baseHP;
    }

    public final void setBaseHP(final int baseHP) {
        this.baseHP = baseHP;
    }

    public final int getUpHP() {
        return upHP;
    }

    public final void setUpHP(final int upHP) {
        this.upHP = upHP;
    }

    public final ArrayList<IAbility> getAbilities() {
        return abilities;
    }

    public final void setAbilities(final ArrayList<IAbility> abilities) {
        this.abilities = abilities;
    }

    public final OvertimeEffect getEffect() {
        return effect;
    }

    public final void setEffect(final OvertimeEffect effect) {
        this.effect = effect;
    }

    public final MyPair<Character, MyPair<Integer, Integer>> getPosition() {
        return position;
    }

    public final void setPosition(final MyPair<Character, MyPair<Integer, Integer>> position) {
        this.position = position;
    }

    public final float getHp() {
        return hp;
    }

    public final void setHp(final float hp) {
        this.hp = hp;
    }

    public final int getMaxHP() {
        return maxHP;
    }

    public final void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }
}
