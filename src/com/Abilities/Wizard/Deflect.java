package com.Abilities.Wizard;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.Hero;
import com.Heroes.Knight;
import com.Heroes.Pyromancer;
import com.Heroes.Rogue;
import com.Heroes.Wizard;

public class Deflect implements IAbility {

    private float landA = 1f;
    private float raceA = 1f;

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo computeDamage(final Hero caster, final Hero victim) {
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
        dmg *= landA;
        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);

        info.setTotalDmg(dmg);
        return info;
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Wizard victim) {
        raceA = Constants.DEFLECT_WIZARD_A;
        return new BattlesStatistics.AttackInfo();
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Rogue victim) {
        raceA = Constants.DEFLECT_ROGUE_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Pyromancer victim) {
        raceA = Constants.DEFLECT_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    /**
     * @see IAbility#computeDamage(Hero, Hero)
     */
    public BattlesStatistics.AttackInfo execute(final Hero caster, final Knight victim) {
        raceA = Constants.DEFLECT_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
