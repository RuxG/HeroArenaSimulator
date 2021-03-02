package com.Abilities.Knight;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Slam implements IAbility {
    private float raceA = 1f;
    private float landA = 1f;

    public static double roundHalfDown(final double d) {
        return new BigDecimal(d).setScale(0, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final AHero caster, final AHero victim) {
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
        info.setBruteDmg((float) roundHalfDown(dmg));
        if (raceA != 1f) {
            raceA += caster.getBonusDmgA();
        }
        dmg *= raceA;

        dmg = (float) roundHalfDown(dmg);

        info.setTotalDmg(dmg);
        effect = new OvertimeEffect(effectRounds, 0, true, victim);
        victim.setEffect(effect);

        return info;
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Wizard victim) {
        raceA = Constants.SLAM_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.SLAM_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.SLAM_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.SLAM_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
