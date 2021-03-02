package com.Abilities.Knight;

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

public class Execute implements IAbility {
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
        float dmg = 0f;
        float hpLimit = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        hpLimit = Constants.EXECUTE_HP_LIMIT + Constants.EXECUTE_HP_UP_LIMIT * caster.getLvl();

        if (hpLimit > Constants.EXECUTE_LIMIT) {
            hpLimit = Constants.EXECUTE_LIMIT;
        }
        float hpProc = victim.getHp() / victim.getMaxHP();
        if (hpProc < hpLimit) {
            dmg = victim.getHp();
            info.setBruteDmg((float) Math.round(dmg));
            info.setTotalDmg((float) Math.round(dmg));
            return info;
        }
        if (caster.getPosition().getKey() == 'L') {
            landA = Constants.KNIGHT_LAND_BONUS;
        }
        dmg = Constants.EXECUTE_BASE_DMG + Constants.EXECUTE_UP_DMG * caster.getLvl();
        dmg *= landA;

        info.setBruteDmg((float) Math.round(dmg));

        dmg = Math.round(dmg);

        if (raceA != 1f) {
            raceA += caster.getBonusDmgA();
        }
        dmg *= raceA;

        info.setTotalDmg((float) Math.round(dmg));

        return info;
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Wizard victim) {
        raceA = Constants.EXECUTE_WIZARD_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Rogue victim) {
        raceA = Constants.EXECUTE_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Pyromancer victim) {
        raceA = Constants.EXECUTE_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(AHero, AHero)
     */
    public BattlesStatistics.AttackInfo execute(final AHero caster, final Knight victim) {
        raceA = Constants.EXECUTE_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
