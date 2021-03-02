package com.Abilities.Wizard;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.AHero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Float.min;

public class Drain implements IAbility {
    private float landA = 1f;
    private float raceA = 1f;
    private int scale = 3;

    public static double roundHalfDown(final double d) {
        return new BigDecimal(d).setScale(0, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final AHero caster, final AHero victim) {
        float proc = 0f;
        float dmg = 0f;
        float hp = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        if (caster.getPosition().getKey() == 'D') {
            landA = Constants.WIZARD_LAND_BONUS;
        }
        proc = Constants.DRAIN_BASE_PROC + caster.getLvl() * Constants.DRAIN_UP_PROC;
        proc *= landA;
        hp = (int) min(Constants.DRAIN_BASE_HP_PROC * victim.getMaxHP(), victim.getHp());
        dmg = proc * hp;
        BigDecimal value = new BigDecimal(proc);
        value = value.setScale(scale, RoundingMode.HALF_UP);
        proc = value.floatValue();
        info.setBruteDmg((float) Math.round(dmg));
        if (raceA != 1f) {
            raceA += caster.getBonusDmgA();
        }
        proc *= raceA;
        dmg = proc * hp;

        dmg = (float) roundHalfDown(dmg);
        info.setTotalDmg(dmg);

        return info;
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Wizard victim) {
        raceA = Constants.DRAIN_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.DRAIN_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.DRAIN_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.DRAIN_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
