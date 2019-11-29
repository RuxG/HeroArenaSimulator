package com.Abilities.Knight;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

public class Slam implements IAbility {
    private float raceA = 1f;
    private float landA = 1f;

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final Hero caster, final Hero victim) {
        float dmg = 0f;
        landA = 1f;
        OvertimeEffect effect;
        int effectRounds = Constants.SLAM_EFFECT_DUR;

        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        dmg = Constants.SLAM_BASE_DMG + caster.getLvl() * Constants.SLAM_UP_DMG;

        if (caster.getPosition().getKey() == 'L') {
            landA = Constants.KNIGHT_LAND_BONUS;
        }

        dmg *= landA;

        info.setBruteDmg(dmg);

        dmg *= raceA;
        dmg = Math.round(dmg);

        info.setTotalDmg(dmg);
        effect = new OvertimeEffect(effectRounds, 0, true, victim);
        victim.setEffect(effect);

        return info;
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Wizard victim) {
        raceA = Constants.SLAM_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Rogue victim) {
        raceA = Constants.SLAM_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Pyromancer victim) {
        raceA = Constants.SLAM_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Knight victim) {
        raceA = Constants.SLAM_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
