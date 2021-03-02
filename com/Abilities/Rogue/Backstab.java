package com.Abilities.Rogue;

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


public class Backstab implements IAbility {
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
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        dmg = Constants.BACKSTAB_BASE_DMG + Constants.BACKSTAB_UP_DMG * caster.getLvl();
        if (caster.getPosition().getKey() == 'W') {
            landA = Constants.ROGUE_LAND_BONUS;
            BattlesStatistics.HeroInfo aux =
                    BattlesStatistics.getInstance().getStatistics().get(caster.getId());
            if (aux.getTotalBattles() % Constants.BACKSTAB_CRIT_ROUND == 0) {
                dmg *= Constants.BACKSTAB_CRIT_PROC;
            }
        }
        dmg *= landA;
        dmg = Math.round(dmg);
        info.setBruteDmg((float) roundHalfDown(dmg));
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
        raceA = Constants.BACKSTAB_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.BACKSTAB_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.BACKSTAB_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.BACKSTAB_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
