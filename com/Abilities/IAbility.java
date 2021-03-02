package com.Abilities;

import com.Game.BattlesStatistics;
import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

/**
 * This interface sketches the main operations of an ability.
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
    BattlesStatistics.AttackInfo computeDamage(AHero caster, AHero victim);

    BattlesStatistics.AttackInfo execute(AHero caster, Wizard victim);

    BattlesStatistics.AttackInfo execute(AHero caster, Rogue victim);

    BattlesStatistics.AttackInfo execute(AHero caster, Pyromancer victim);

    BattlesStatistics.AttackInfo execute(AHero caster, Knight victim);
}

