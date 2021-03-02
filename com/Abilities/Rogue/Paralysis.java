package com.Abilities.Rogue;

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


public class Paralysis implements IAbility {
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
        int effectRounds = Constants.PARALYSIS_EFFECT_ROUND;

        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        if (caster.getPosition().getKey() == 'W') {
            effectRounds *= Constants.PARALYSIS_EFFECT_ROUND_AMPLIFIER;
            landA = Constants.ROGUE_LAND_BONUS;
        }
        effect = new OvertimeEffect(effectRounds,
                Math.round((Constants.PARALYSIS_BASE_DMG + caster.getLvl()
                        * Constants.PARALYSIS_UP_DMG) * landA * raceA), true, victim);
        dmg = (Constants.PARALYSIS_BASE_DMG + caster.getLvl() * Constants.PARALYSIS_UP_DMG);

        dmg *= landA;
        dmg = Math.round(dmg);
        info.setBruteDmg((float) roundHalfDown(dmg));

        if (raceA != 1f) {
            raceA += caster.getBonusDmgA();
        }
        dmg *= raceA;

        dmg = (float) roundHalfDown(dmg);
        info.setTotalDmg(dmg);

        victim.setEffect(effect);
        return info;
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Wizard victim) {
        raceA = Constants.PARALYSIS_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.PARALYSIS_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.PARALYSIS_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.PARALYSIS_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
