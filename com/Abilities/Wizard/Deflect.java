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

public class Deflect implements IAbility {

    private float landA = 1f;
    private float raceA = 1f;

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
        landA = 1f;
        BattlesStatistics.AttackInfo info = caster.acceptAttack(victim);
        if (caster.getPosition().getKey() == 'D') {
            landA = Constants.WIZARD_LAND_BONUS;
        }
        proc = Constants.DEFLECT_BASE_PROC + caster.getLvl() * Constants.DEFLECT_UP_PROC;
        if (proc > Constants.DEFLECT_LIMIT_PROC) {
            proc = Constants.DEFLECT_LIMIT_PROC;
        }
        dmg = info.getBruteDmg();

        dmg *= proc;
        dmg = Math.round(dmg);
        dmg *= landA;
        info.setBruteDmg((float) Math.round(dmg));
        if (raceA != 1f) {
            raceA += caster.getBonusDmgA();
        }
        dmg *= raceA;

        dmg = (float) roundHalfDown(dmg);

        info.setTotalDmg(dmg);
        return info;
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Wizard victim) {
        raceA = Constants.DEFLECT_WIZARD_A;
        return new BattlesStatistics.AttackInfo();
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.DEFLECT_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.DEFLECT_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.DEFLECT_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
