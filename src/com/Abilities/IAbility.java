package com.Abilities;

import com.Game.BattlesStatistics;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

/**
 * This interface sketches the main operations of an ability
 */
public interface IAbility {

    /**
     * This method computes and returns information about the attack (damage given with
     * and without modifiers).
     * <p>
     * execute (Hero, ***) computes the race amplifier and calls the computeDamage method
     *
     * @param caster should be the hero initiating the attack
     * @param victim should be the hero targeted by the attack
     * @return information about battle outcome
     */
    BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Knight victim);
}

