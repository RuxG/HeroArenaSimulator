package com.Heroes;


import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Angels.AAngel;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the abstract form of a hero, with it's specific characteristics.
 */
public abstract class AHero extends Observable {
    private int id;
    private String name;
    private String fullName;
    private float hp;
    private float exp;
    private int lvl;
    private int maxHP;
    private int baseHP;
    private int upHP;
    private ArrayList<IAbility> abilities;
    private OvertimeEffect effect;
    private MyPair<Character, MyPair<Integer, Integer>> position;
    private float bonusDmgA = 0f;
    private Observer observer;

    AHero(final int id, final String name, final String fullName, final int hp, final int upHP,
          final MyPair<Character, MyPair<Integer, Integer>> position,  final Observer observer) {
        setId(id);
        setName(name);
        setfullName(fullName);
        setHp(hp);
        setExp(0);
        setLvl(0);
        setMaxHP(hp);
        setBaseHP(hp);
        setUpHP(upHP);
        setPosition(position);
        setAbilities(new ArrayList<>());
        setEffect(new OvertimeEffect(0, 0, false, this));
        this.observer = observer;
    }

    protected final void setfullName(final String fullName) {
        this.fullName = fullName;
    }

    public final String getFullName() {
        return fullName;
    }

    /**
     *
     * @param arg is the hero / angel who killed the current hero
     */
    @Override
    public void notifyObservers(final Object arg) {
        if (arg instanceof AHero) {
            observer.update(this, "Player " + fullName + " " + id
                    + " was killed by " + ((AHero) arg).getFullName() + " " + ((AHero) arg).getId()
                    + "\n");
        }
        if (arg instanceof AAngel) {
            observer.update(this, "Player " + fullName + " " + id
                    + " was killed by an angel\n");
        }
    }

    public final void checkLvlUp() {
        int expLvlUp = Constants.LVL_UP_EXP + lvl * Constants.LVL_STEP;
        float aux = exp;
        while (aux >= expLvlUp) {
            aux -= Constants.LVL_STEP;
            lvl++;
            setMaxHP(baseHP + upHP * lvl);
            setHp(maxHP);
            observer.update(this, fullName + " " + id
                    + " reached level " + lvl + "\n");
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

    /**
     * @param angel is the angel which will apply an action on the current hero
     */
    public abstract void acceptAngel(AAngel angel);

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


    public final float getBonusDmgA() {
        return bonusDmgA;
    }

    public final void setBonusDmgA(final float bonusDmgA) {
        this.bonusDmgA = bonusDmgA;
    }

    public final Observer getObserver() {
        return observer;
    }
}
